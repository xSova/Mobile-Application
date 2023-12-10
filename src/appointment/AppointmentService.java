package appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Adds a new appointment to the service.
    public void addAppointment(String appointmentID, String description, Date date) {
        Appointment appointment = new Appointment(appointmentID, description, date);
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment with this ID already exists.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Deletes the appointment with the specified appointmentID.
    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment does not exist and cannot be deleted.");
        }
        appointments.remove(appointmentID);
    }

    // Retrieves the appointment with the specified appointmentID.
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }

    // Updates the appointment fields with the values provided in the updates map.
    public void updateAppointmentFields(String appointmentID, Map<String, String> updates) {
        Appointment appointment = findAppointment(appointmentID);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Date data should be passed in as mm/dd/yyyy.

        for (Map.Entry<String, String> entry : updates.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "description":
                    appointment.setDescription(entry.getValue());
                    break;
                case "date":
                    try {
                        Date newDate = dateFormat.parse(entry.getValue());
                        appointment.setAppointmentDate(newDate);
                    } catch (ParseException e) {
                        throw new IllegalArgumentException("Invalid date format for 'date'. Expected format: MM/dd/yyyy");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field name: " + entry.getKey() + ".");
            }
        }
    }

    // Method to find a appointment and throw an exception if it doesn't exist.
    private Appointment findAppointment(String appointmentID) {
        Appointment appointment = appointments.get(appointmentID);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        return appointment;
    }
}
