package SIT333;

import java.util.*;

public class TaskInbox {
    // Map to store studentId and their submitted tasks
    private final Map<String, List<String>> studentTasks = new HashMap<>();

    // Submits a task for a specific student
    public void submitTask(String studentId, String taskName) {
        // If studentId is null, use a special key (optional safety)
        // You can skip this if you prefer null key to be accepted directly
        studentTasks.computeIfAbsent(studentId, k -> new ArrayList<>()).add(taskName);
    }

    // Returns the list of tasks for a student, or an empty list if none found
    public List<String> getTasks(String studentId) {
        return studentTasks.getOrDefault(studentId, new ArrayList<>());
    }
}
