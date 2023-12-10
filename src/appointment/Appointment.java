package appointment;

import java.util.Date;

public class Appointment {
    private String description;
    private final String appointmentId;
    private Date appointmentDate;

    // Constructor method.
    public Appointment(String appointmentId, String description, Date appointmentDate) {
        if (appointmentId == null || appointmentId.isEmpty() || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID.");
        }
        if (description == null || description.isEmpty() || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid date.");
        }

        this.appointmentDate = appointmentDate;
        this.description = description;
        this.appointmentId = appointmentId;
    }

    // Getter methods.
    public String getDescription() { return description; }
    public String getAppointmentId() { return appointmentId; }
    public Date getAppointmentDate() { return appointmentDate; }

    // Setter methods.
    // No setter for appointmentID because it will not be changed.
    public void setAppointmentDate(Date newAppointmentDate) {
        if (newAppointmentDate != null && newAppointmentDate.after(new Date())) {
            this.appointmentDate = newAppointmentDate;
        } else {
            throw new IllegalArgumentException("Error: Invalid date.");
        }
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Error: Invalid description.");
        } else {
            this.description = description;
        }
    }
}

