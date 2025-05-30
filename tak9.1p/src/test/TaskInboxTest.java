package SIT333;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskInboxTest {

    @Test
    void testGetTasksReturnsEmptyListForUnknownStudent() {
        TaskInbox inbox = new TaskInbox();
        List<String> tasks = inbox.getTasks("unknown123");
        assertTrue(tasks.isEmpty(), "Expected empty task list for unknown student");
    }

    @Test
    void testSubmitAndRetrieveTasks() {
        TaskInbox inbox = new TaskInbox();
        inbox.submitTask("student001", "Math Quiz");
        inbox.submitTask("student001", "Java Assignment");

        List<String> tasks = inbox.getTasks("student001");
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains("Math Quiz"));
        assertTrue(tasks.contains("Java Assignment"));
    }

    @Test
    void testMultipleStudentsHaveSeparateTaskLists() {
        TaskInbox inbox = new TaskInbox();
        inbox.submitTask("student001", "Math Quiz");
        inbox.submitTask("student002", "Science Homework");

        List<String> tasks1 = inbox.getTasks("student001");
        List<String> tasks2 = inbox.getTasks("student002");

        assertEquals(1, tasks1.size());
        assertTrue(tasks1.contains("Math Quiz"));

        assertEquals(1, tasks2.size());
        assertTrue(tasks2.contains("Science Homework"));
    }

    @Test
    void testDuplicateTaskNamesAllowed() {
        TaskInbox inbox = new TaskInbox();
        inbox.submitTask("student001", "Task A");
        inbox.submitTask("student001", "Task A");

        List<String> tasks = inbox.getTasks("student001");
        assertEquals(2, tasks.size());
        assertEquals("Task A", tasks.get(0));
        assertEquals("Task A", tasks.get(1));
    }

    @Test
    void testSubmitEmptyTaskName() {
        TaskInbox inbox = new TaskInbox();
        inbox.submitTask("student001", "");

        List<String> tasks = inbox.getTasks("student001");
        assertEquals(1, tasks.size());
        assertEquals("", tasks.get(0));
    }

    @Test
    void testSubmitNullTaskName() {
        TaskInbox inbox = new TaskInbox();
        inbox.submitTask("student001", null);

        List<String> tasks = inbox.getTasks("student001");
        assertEquals(1, tasks.size());
        assertNull(tasks.get(0));
    }

    @Test
    void testSubmitEmptyStudentId() {
        TaskInbox inbox = new TaskInbox();
        inbox.submitTask("", "Task A");

        List<String> tasks = inbox.getTasks("");
        assertEquals(1, tasks.size());
        assertEquals("Task A", tasks.get(0));
    }

    @Test
    void testSubmitNullStudentId() {
        TaskInbox inbox = new TaskInbox();
        inbox.submitTask(null, "Task A");

        List<String> tasks = inbox.getTasks(null);
        assertEquals(1, tasks.size());
        assertEquals("Task A", tasks.get(0));
    }
}
