# Mobile Application

## Overview
This Java project manages appointments, contacts, and tasks (originally from [Appointment-Service](https://github.com/xSova/Appointment-Service), [Contact-Service](https://github.com/xSova/Contact-Service), and [Task-Service](https://github.com/xSova/Task-Service). It focuses on robust data management with validation and includes packages for each entity along with their test suites.

## Packages and Classes

### 1. Appointment Package
- `Appointment`: Manages appointment data with fields like description, appointment ID, and date. Includes data integrity validation.
- `AppointmentService`: Handles a collection of appointments, supporting adding, deleting, and updating.
- `AppointmentServiceTest`: Tests for AppointmentService to ensure correct method functionality.

### 2. Contact Package
- `Contact`: Defines a contact with fields like name, phone, and address, enforcing length constraints and null checks.
- `ContactService`: Manages contacts, allowing addition, deletion, and updating of contact information.
- `ContactServiceTest`: Tests for ContactService, validating contact management functionality.

### 3. Task Package
- `Task`: Represents a task with fields like name, description, and ID.
- `TaskService`: Handles task management including adding, deleting, and updating tasks.
- `TaskServiceTest`: Tests for TaskService ensuring proper operation and data handling.

## Functionality

- **Data Validation**: Strict rules for data integrity in each class.
- **Error Handling**: Exceptions for handling invalid operations like adding duplicates or updating non-existent entries.
- **Unit Testing**: Comprehensive testing for various scenarios, including positive and negative cases.

## Usage

1. **Clone the Repository**: Use Git or checkout with SVN.
2. **Compile and Run**: Ensure Java is installed, compile the classes, and run desired classes or tests.
3. **Adding/Updating Entities**: Use service classes (`AppointmentService`, `ContactService`, `TaskService`) for managing entities.
4. **Testing**: Run test classes to ensure functionality integrity.

## Contributions

Contributions are welcome. Adhere to the project's coding style and include tests for new features or fixes.

## License

This project is licensed under the MIT License.
