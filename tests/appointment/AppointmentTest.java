package appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class AppointmentTest {
    private Date pastDate;
    private Date validTestDate;
    private Date futureDate;

    @SuppressWarnings("DuplicatedCode")
    @BeforeEach
    public void setUp() {
        Calendar cal = Calendar.getInstance();
        Date now = new Date();

        // Set fixedPastDate to 2 days before now
        cal.setTime(now);
        cal.add(Calendar.DATE, -2);
        pastDate = cal.getTime();

        cal.setTime(now);
        cal.add(Calendar.DATE, (int) (Math.random() * 100000));
        validTestDate = cal.getTime();

        cal.setTime(now);
        cal.add(Calendar.DATE, 2);
        futureDate = cal.getTime();
    }

    // Positive tests
    @Test
    public void testValidConstruction() {
        Appointment appointment = new Appointment("123", "Appointment Description", validTestDate);
        Assert.assertNotNull(appointment);
        Assertions.assertEquals("123", appointment.getAppointmentId());
        Assertions.assertEquals("Appointment Description", appointment.getDescription());
        Assertions.assertEquals(validTestDate, appointment.getAppointmentDate());
    }
    @Test
    public void testValidDescriptionUpdate() {
        Appointment appointment = new Appointment("123", "TestDescription", validTestDate);
        assertDoesNotThrow(() -> appointment.setDescription("New Description"));
        Assert.assertSame("New Description", appointment.getDescription());
    }
    @Test
    public void testValidDateUpdate() {
        Appointment appointment = new Appointment("123", "Appointment Description", validTestDate);
        assertDoesNotThrow(() -> appointment.setAppointmentDate(futureDate));
        Assert.assertEquals(futureDate, appointment.getAppointmentDate());
    }

    // Negative tests
    @Test
    public void testInvalidConstruction() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(null, "test", validTestDate));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("IdThatIsCertainlyTooLongProbably", "test", validTestDate));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("123", null, validTestDate));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("123", "Descriptiooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooon", validTestDate));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("123", "Description", pastDate));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("123", "Description", null));
    }
    private static final int appointmentIdMaxLength = 10;
    private static final int descriptionMaxLength = 50;

    @Test
    public void testBoundaries() {
        testFieldLengthBoundary(appointmentIdMaxLength, this::assertNoExceptionOnFieldCreation);
        testFieldLengthBoundary(descriptionMaxLength, this::assertExceptionOnFieldCreation);
    }

    private void testFieldLengthBoundary(int fieldMaxLength, BiConsumer<String, Integer> assertionMethod) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= fieldMaxLength + 1; i++) {
            assertionMethod.accept(sb.toString(), i);
            sb.append("*");
        }
    }

    private void assertNoExceptionOnFieldCreation(final String stringToTest, final int i) {
        if (i > 0 && i <= appointmentIdMaxLength) {
            Assertions.assertDoesNotThrow(() -> new Appointment(stringToTest, "test", validTestDate));
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(stringToTest, "test", validTestDate));
        }
    }

    private void assertExceptionOnFieldCreation(final String stringToTest, final int i) {
        if (i > 0 && i <= descriptionMaxLength) {
            Assertions.assertDoesNotThrow(() -> new Appointment("123", stringToTest, validTestDate));
        } else {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment("123", stringToTest, validTestDate));
        }
    }
    @Test
    public void testInvalidDateUpdate() {
        Appointment appointment = new Appointment("123", "Test Description", validTestDate);
        Assertions.assertThrows(IllegalArgumentException.class, () -> { appointment.setAppointmentDate(pastDate); });
        Assertions.assertThrows(IllegalArgumentException.class, () -> { appointment.setAppointmentDate(null); });
    }
    @Test
    public void testInvalidDescriptionUpdate() {
        Appointment appointment = new Appointment("123", "TestDescription", validTestDate);
        Assertions.assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> appointment.setDescription("DescriptionThatIsWayTooLongToAcceptDescriptionThatIsWayTooLongToAcceptDescriptionThatIsWayTooLongToAcceptDescriptionThatIsWayTooLongToAccept"));
    }
    @Test
    public void testInvalidUpdateDescription() {
        Appointment appointment = new Appointment("123", "TestDescription", validTestDate);
        Assertions.assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> appointment.setDescription("I am writing a description that will certainly be too long to accept, but in a way this is a cry for help because I don't actually know how long this is or if I'm totally wasting my time. At least my code is reusable."));
    }
}
