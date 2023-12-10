package contact;

public class Contact {

    private static final int maxLength = 10; // Maximum length of the strings.
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private final String contactID;

    // Constructor method.
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contactID.length() > maxLength) {
            throw new IllegalArgumentException("Invalid contact ID.");
        }
        if (firstName == null || firstName.length() > maxLength) {
            throw new IllegalArgumentException("Invalid first name.");
        }
        if (lastName == null || lastName.length() > maxLength) {
            throw new IllegalArgumentException("Invalid last name.");
        }
        if (phone == null || phone.length() > maxLength) {
            throw new IllegalArgumentException("Invalid phone number.");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.contactID = contactID;
    }

    // Getter methods.
    public String getAddress() { return address; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getContactID() { return contactID; }

    // Setter methods.
    // No setter for contactID because it will not be changed.
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() <= maxLength) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Error: Invalid first name.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() <= maxLength) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Error: Invalid last name.");
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.length() <= maxLength) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Error: Invalid phone number.");
        }
    }

    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Error: Invalid address.");
        }
    }


    // make something iterate and pass in requirements for max len and what is needed like phone numbers
    // loop for input until valid input is given

}
