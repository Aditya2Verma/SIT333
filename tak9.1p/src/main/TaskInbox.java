package SIT333;

import java.util.*;

public class TaskInbox {
    // Stores tasks submitted by students: studentId -> list of task names
    private final Map<String, List<String>> studentTasks = new HashMap<>();

    /**
     * Allows a student to submit a task.
     * If the student is new, initializes their task list.
     * @param studentId Unique identifier for the student
     * @param taskName Name of the task being submitted
     */
    public void submitTask(String studentId, String taskName) {
        studentTasks.computeIfAbsent(studentId, id -> new ArrayList<>()).add(taskName);
    }

    /**
     * Retrieves the list of tasks submitted by a student.
     * @param studentId Unique identifier for the student
     * @return List of submitted tasks; empty if none
     */
    public List<String> getTasks(String studentId) {
        return studentTasks.getOrDefault(studentId, new ArrayList<>());
    }
}
