package SIT333;

import java.util.*;

public class TaskInbox {
    // Maps studentId -> Map of taskId -> fileName
    private final Map<String, Map<String, String>> submissionBox = new HashMap<>();

    /**
     * Submits a task file to a task ID for a student.
     * 
     * @param studentId The ID of the student submitting the task
     * @param taskId The task identifier (must be valid)
     * @param fileName The submitted file (must not be null/empty)
     * @return true if submission is accepted, false otherwise
     */
    public boolean submitTask(String studentId, String taskId, String fileName) {
        if (studentId == null || taskId == null || fileName == null || fileName.trim().isEmpty()) {
            return false;
        }

        Map<String, String> studentSubmissions = submissionBox.computeIfAbsent(studentId, id -> new HashMap<>());

        // Prevent duplicate submissions
        if (studentSubmissions.containsKey(taskId)) {
            return false;
        }

        studentSubmissions.put(taskId, fileName);
        return true;
    }

    /**
     * Retrieves submitted files for a student
     * @param studentId The student identifier
     * @return Map of taskId -> fileName, or empty map if no submissions
     */
    public Map<String, String> getSubmittedTasks(String studentId) {
        return submissionBox.getOrDefault(studentId, new HashMap<>());
    }
}
