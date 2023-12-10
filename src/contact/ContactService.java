package contact;

/*
- The contact service shall be able to add contacts with a unique ID. Done
- The contact service shall be able to delete contacts per contact ID. Done
- The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
- firstName Done
- lastName Done
- Number Done
- Address Done
*/

import java.util.Map;
import java.util.HashMap;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact to the service.
    public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact with this ID already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Deletes the contact with the specified ID.
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact does not exist and cannot be deleted.");
        }
        contacts.remove(contactID);
    }

    // Retrieves the contact with the specified ID.
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }

    // Updates the contact fields with the values provided in the updates map.
    public void updateContactFields(String contactID, Map<String, String> updates) {
        Contact contact = findContact(contactID);
        for (Map.Entry<String, String> entry : updates.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "firstname":
                    contact.setFirstName(entry.getValue());
                    break;
                case "lastname":
                    contact.setLastName(entry.getValue());
                    break;
                case "phone":
                    contact.setPhone(entry.getValue());
                    break;
                case "address":
                    contact.setAddress(entry.getValue());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field name: " + entry.getKey() + ".");
            }
        }
    }

    // Method to find a contact and throw an exception if it doesn't exist.
    private Contact findContact(String contactID) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        return contact;
    }
}

// Maybe make something to display the contact list?
