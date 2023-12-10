package appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Date validTestDate;
    private Date futureDate;
    private Date pastDate;


    @BeforeEach
    void setUp() {

        appointmentService = new AppointmentService();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        Calendar cal = Calendar.getInstance();
        Date now = new Date();

        // Set fixedPastDate to 2 days before now
        cal.setTime(now);
        cal.add(Calendar.DATE, -2);
        pastDate = cal.getTime();

        cal.setTime(now);
        cal.add(Calendar.DATE, (int) (Math.random() * 100000));
        validTestDate = cal.getTime();

        // Set fixedFutureDate to 2 days after now
        cal.setTime(now);
        cal.add(Calendar.DATE, 2);
        futureDate = cal.getTime();

    }

    /* Positive tests for appointment creation (works as intended) */
    @Test
    void testAddAppointment() { // Validate appointment creation
        // Add an appointment
        appointmentService.addAppointment("1", "Appointment 1", validTestDate);

        // Retrieve the appointment
        Appointment result = appointmentService.getAppointment("1");

        // Assertions
        Assertions.assertNotNull(result);
        Assertions.assertEquals("1", result.getAppointmentId());
        Assertions.assertEquals(validTestDate, result.getAppointmentDate());
        Assertions.assertEquals("Appointment 1", result.getDescription());
    }
    @Test
    void testUpdateExistingAppointment() {
        // Add an initial appointment
        appointmentService.addAppointment("1", "Appointment 1", validTestDate);

        // Prepare updates
        Map<String, String> updates = new HashMap<>();
        updates.put("description", "Updated Appointment 1");

        // Format futureDate to String
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String futureDateString = dateFormat.format(futureDate);
        updates.put("date", futureDateString);

        // Update the appointment
        appointmentService.updateAppointmentFields("1", updates);

        // Retrieve the updated appointment
        Appointment updatedAppointment = appointmentService.getAppointment("1");

        // Assertions
        Assertions.assertNotNull(updatedAppointment);
        Assertions.assertEquals("Updated Appointment 1", updatedAppointment.getDescription());

        // Convert the updated appointment date back to String for comparison
        String updatedDateString = dateFormat.format(updatedAppointment.getAppointmentDate());
        Assertions.assertEquals(futureDateString, updatedDateString);
    }

    @Test
    void testDeleteAppointment() {
        appointmentService.addAppointment("1", "Appointment 1", validTestDate);
        appointmentService.addAppointment("2", "Appointment 2", validTestDate);
        // Delete appointment where appointmentID == "1"
        appointmentService.deleteAppointment("1");

        // Validate that appointment where appointmentID == "2" is still intact
        Assertions.assertNotNull(appointmentService.getAppointment("2"));
        Assertions.assertEquals("2", appointmentService.getAppointment("2").getAppointmentId());
        Assertions.assertEquals("Appointment 2", appointmentService.getAppointment("2").getDescription());
        Assertions.assertEquals(validTestDate, appointmentService.getAppointment("2").getAppointmentDate());

        // Validate that the appointment where appointmentID == "1" is deleted
        Assertions.assertNull(appointmentService.getAppointment("1"));
    }

    /* Negative tests for appointment service (doesn't do what it is supposed to not do) */
    @Test
    void testAddAppointmentWithExistingID() {
        appointmentService.addAppointment("1", "Appointment 1", validTestDate);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment("1", "Appointment 2", validTestDate);
        });
    }
    @Test
    void testDeleteNonExistentAppointment() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("2"); // Assuming no appointments exist
        });
    }
    @Test
    void testGetNonExistentAppointment() {
        Appointment result = appointmentService.getAppointment("1");
        Assertions.assertNull(result);
    }
    @Test
    void testAddAppointmentInThePast() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment("1", "Appointment 1", pastDate);
        });
    }
    @Test
    void testUpdateNonExistentAppointment() {
        Map<String, String> updates = new HashMap<>();
        updates.put("name", "New Name");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointmentFields("2", updates); // Assuming "2" does not exist
        });
    }
    @Test
    void testUpdateWithInvalidFieldName() {
        appointmentService.addAppointment("1", "Appointment 1", validTestDate);

        Map<String, String> updates = new HashMap<>();
        updates.put("invalidField", "Some Value");

        Assertions.assertThrows(IllegalArgumentException.class, () -> appointmentService.updateAppointmentFields("1", updates));
    }
    @Test
    void testUpdateWithInvalidDateInput() {
        appointmentService.addAppointment("1", "Appointment 1", validTestDate);

        Map<String, String> updates = new HashMap<>();
        updates.put("date", "2012-12-12");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.updateAppointmentFields("1", updates);
        });
    }

}

