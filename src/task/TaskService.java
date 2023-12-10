package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Adds a new task to the service.
    public void addTask(String taskID, String name, String description) {
        Task task = new Task(taskID, name, description);
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task with this ID already exists.");
        }
        tasks.put(task.getTaskID(), task);
    }

    // Deletes the task with the specified taskID.
    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task does not exist and cannot be deleted.");
        }
        tasks.remove(taskID);
    }

    // Retrieves the task with the specified taskID.
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }

    // Updates the task fields with the values provided in the updates map.
    public void updateTaskFields(String taskID, Map<String, String> updates) {
        Task task = findTask(taskID);
        for (Map.Entry<String, String> entry : updates.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "name":
                    task.setName(entry.getValue());
                    break;
                case "description":
                    task.setDescription(entry.getValue());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field name: " + entry.getKey() + ".");
            }
        }
    }

    // Method to find a task and throw an exception if it doesn't exist.
    private Task findTask(String taskID) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        return task;
    }
}
