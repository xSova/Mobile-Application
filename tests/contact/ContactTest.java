package contact;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ContactTest {
    @Test
    public void testValidConstruction() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assert.assertNotNull(contact);
        Assertions.assertEquals("1234567890", contact.getContactID());
        Assertions.assertEquals("FirstName", contact.getFirstName());
        Assertions.assertEquals("LastName", contact.getLastName());
        Assertions.assertEquals("1111111111", contact.getPhone());
        Assertions.assertEquals("123 Test St", contact.getAddress());
    }
    @Test
    public void testInvalidConstructionNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact(null, "FirstName", "LastName", "1111111111", "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "LastName", "1111111111", "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "FirstName", null, "1111111111", "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "FirstName", "LastName", null, "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "FirstName", "LastName", "1111111111", null));
    }
    @Test
    public void testInvalidConstructionLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "FirstName", "LastName", "1111111111", "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "12345678901", "LastName", "1111111111", "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "FirstName", "12345678901", "1111111111", "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "FirstName", "LastName", "12345678901", "123 Test St"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "FirstName", "LastName", "1111111111", "1234567890123456789012345678901"));
    }
    @Test
    public void testValidFirstNameUpdate() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertDoesNotThrow(() -> contact.setFirstName("FirstName2"));
        Assert.assertSame("FirstName2", contact.getFirstName());
    }
    @Test
    public void testInvalidFirstNameUpdateNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }
    @Test
    public void testInvalidFirstNameUpdateLength() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("12345678901"));
    }
    @Test
    public void testInvalidLastNameUpdateNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }
    @Test
    public void testInvalidLastNameUpdateLength() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setLastName("12345678901"));
    }
    @Test
    public void testInvalidPhoneUpdateNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }
    @Test
    public void testInvalidPhoneUpdateLength() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345678901"));
    }
    @Test
    public void testInvalidAddressUpdateNull() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
    @Test
    public void testInvalidAddressUpdateLength() {
        Contact contact = new Contact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
    }

}
