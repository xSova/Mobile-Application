package task;

public class Task {
    private String name;
    private String description;
    private final String taskID;

    // Constructor method.
    public Task (String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }

        this.name = name;
        this.description = description;
        this.taskID = taskID;
    }

    // Getter methods.
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getTaskID() { return taskID; }

    // Setter methods.
    // No setter for taskID because it will not be changed.
    public void setName(String name) {
        if (name != null && name.length() <= 20) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Error: Invalid task name.");
        }
    }

    public void setDescription(String description) {
        if (description != null && description.length() <= 50) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Error: Invalid description.");
        }
    }
}
