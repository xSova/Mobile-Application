# Mobile Application

## Overview
This Java project manages appointments, contacts, and tasks (originally from [Appointment-Service](https://github.com/xSova/Appointment-Service), [Contact-Service](https://github.com/xSova/Contact-Service), and [Task-Service](https://github.com/xSova/Task-Service). It focuses on robust data management with validation and includes packages for each entity along with their test suites.

## Packages and Classes

### 1. Appointment Package
- `Appointment`: Manages appointment data with fields like description, appointment ID, and date. Includes data integrity validation.
- `AppointmentService`: Handles a collection of appointments, supporting adding, deleting, and updating.
- `AppointmentTest`: Tests for Appointment to validate requirements.
- `AppointmentServiceTest`: Tests for AppointmentService to ensure correct method functionality.

### 2. Contact Package
- `Contact`: Defines a contact with fields like name, phone, and address, enforcing length constraints and null checks.
- `ContactService`: Manages contacts, allowing addition, deletion, and updating of contact information.
- `ContactTest`: Tests for Appointment to validate requirements.
- `ContactServiceTest`: Tests for ContactService, validating contact management functionality.

### 3. Task Package
- `Task`: Represents a task with fields like name, description, and ID.
- `TaskService`: Handles task management including adding, deleting, and updating tasks.
- `TaskTest`: Tests for Task to validate requirements.
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

## Reflection (for School)

- _How can I ensure that my code, program, or software is functional and secure?_
  - **Rigorous Testing**: The use of JUnit testing, as demonstrated in this project, is a vital strategy for ensuring functionality. Through both positive and negative test cases, like `testValidConstruction()` and `testInvalidConstruction()`, I thoroughly examined all possible scenarios. This not only validates functionality but also aids in catching bugs early.
  - **Code Reviews and Peer Feedback**: Seeking peer reviews, as I did, helps in identifying potential issues that a single developer might overlook. This is crucial for both functionality and security.
  - **Adherence to Coding Standards**: Following industry standards ensures that the code is not just functional but also secure. Standards often include best practices for security, like input validation and error handling.
  - **Continuous Learning and Updating**: Security is dynamic; hence, keeping abreast of the latest security trends and vulnerabilities is essential. Regularly updating the software to patch any known vulnerabilities is a practice I intend to maintain when working on professional projects.
- _How do I interpret user needs and incorporate them into a program?_
  - **User Stories and Feedback Loops**: Understanding user needs is a critical aspect of software development. In this project, I imagined real-world applications, such as how the Appointment feature would be used. This hypothetical scenario guided my testing process, as reflected in the tests like `testAddAppointmentInThePast()`.
  - **Iterative Development**: Using an iterative approach (and utilizing version control systems, like git) allows for regular feedback and adaptation. By developing in stages and continually testing against user needs, the software becomes more user-centric.
  - **Empathy and Use Case Scenarios**: Putting myself in the users' shoes, considering their challenges, and anticipating their needs helped tailor the software more effectively.
- _How do I approach designing software?_
  - **Requirement Analysis and Planning**: My approach starts with a comprehensive (static testing) analysis of requirements. This ensures that the software is designed to meet specific goals.
  - **Modular Design**: I focus on creating modular, maintainable code. This not only makes testing each part easier but also simplifies future updates and bug fixes.
  - **Scalability and Performance Consideration**: While writing the code, I kept scalability in mind, using efficient data structures and avoiding redundant checks, which aligns with my focus on efficiency.
  - **User-Centric Design**: A significant part of my design philosophy involves keeping the end user in mind. This means creating intuitive interfaces and ensuring the software is accessible and easy to use.
