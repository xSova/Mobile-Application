package contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddContact() {
        contactService.addContact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Contact result = contactService.getContact("1234567890");

        Assertions.assertNotNull(result);
        Assertions.assertEquals("1234567890", result.getContactID());
        Assertions.assertEquals("FirstName", result.getFirstName());
        Assertions.assertEquals("LastName", result.getLastName());
        Assertions.assertEquals("1111111111", result.getPhone());
        Assertions.assertEquals("123 Test St", result.getAddress());
    }

    @Test
    void testAddContactWithExistingID() {
        contactService.addContact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.addContact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St"));
    }

    @Test
    void testDeleteContact() {
        contactService.addContact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        contactService.deleteContact("1234567890");
        Assertions.assertNull(contactService.getContact("1234567890"));
    }

    @Test
    void testDeleteNonExistentContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("2"));
    }

    @Test
    void testGetNonExistentContact() {
        Contact result = contactService.getContact("1");
        Assertions.assertNull(result);
    }

    @Test
    void testUpdateExistingContact() {
        contactService.addContact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Map<String, String> updates = new HashMap<>();

        updates.put("firstname", "FirstName2");
        updates.put("lastname", "LastName2");
        updates.put("phone", "1211111111");
        updates.put("address", "124 Test St");
        contactService.updateContactFields("1234567890", updates);
        Contact updatedContact = contactService.getContact("1234567890");

        Assertions.assertEquals("FirstName2", updatedContact.getFirstName());
        Assertions.assertEquals("LastName2", updatedContact.getLastName());
        Assertions.assertEquals("1211111111", updatedContact.getPhone());
        Assertions.assertEquals("124 Test St", updatedContact.getAddress());
    }

    @Test
    void testUpdateExistingContactInvalidInputs() {
        contactService.addContact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Map<String, String> updates = new HashMap<>();
        Map<String, String> tempMap = new HashMap<>();

        updates.put("firstname", null);
        updates.put("firstName", "12345678901");
        updates.put("lastname", null);
        updates.put("lastName", "12345678901");
        updates.put("phone", null);
        updates.put("Phone", "12111111110");
        updates.put("address", null);
        updates.put("Address", "1234567890123456789012345678901");
        updates.put("SomeKey", "SomeValue");
        for (String i : updates.keySet()) {
            tempMap.put(i, updates.get(i));
            Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.updateContactFields("1234567890", tempMap));
            tempMap.remove(i);
        }
    }

    @Test
    void testUpdateNonExistentContact() {
        Map<String, String> updates = new HashMap<>();
        updates.put("firstname", "FirstName2");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFields("2", updates); // Assuming "2" does not exist
        });
    }

    @Test
    void testUpdateWithInvalidFieldName() {
        contactService.addContact("1234567890", "FirstName", "LastName", "1111111111", "123 Test St");
        Map<String, String> updates = new HashMap<>();
        updates.put("invalidField", "Some Value");

        Assertions.assertThrows(IllegalArgumentException.class, () -> contactService.updateContactFields("1", updates));
    }
}
