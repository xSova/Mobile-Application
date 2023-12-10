package task;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TaskTest {

    @Test
    public void testValidConstruction() {
        Task task = new Task("123", "TaskName", "TaskDescription");
        Assert.assertNotNull(task);
        Assertions.assertEquals("123", task.getTaskID());
        Assertions.assertEquals("TaskName", task.getName());
        Assertions.assertEquals("TaskDescription", task.getDescription());
    }
    @Test
    public void testInvalidConstruction() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null, "test", "test"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("IdThatIsCertainlyTooLongProbably", "test", "test"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "test"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("123", "NameThatIsWayTooLongToBeAccepted", "test"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("test", "test", null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Task("test", "test", "I am writing a description that will certainly be too long to accept, but in a way this is a cry for help because I don't actually know how long this is or if I'm totally wasting my time."));
    }
    @Test
    public void testValidNameUpdate() {
        Task task = new Task("123", "TestName", "TestDescription");
        Assertions.assertDoesNotThrow(() -> task.setName("newName"));
        Assert.assertSame("newName", task.getName());
    }
    @Test
    public void testInvalidNameUpdate() {
        Task task = new Task("123", "TestName", "TestDescription");
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName("NameThatIsWayTooLongToAccept"));
    }
    @Test
    public void testValidUpdateDescription() {
        Task task = new Task("123", "TestName", "TestDescription");
        Assertions.assertDoesNotThrow(() -> task.setDescription("newDescription"));
        Assert.assertSame("newDescription", task.getDescription());
    }
    @Test
    public void testInvalidUpdateDescription() {
        Task task = new Task("123", "TestName", "TestDescription");
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDescription("I am writing a description that will certainly be too long to accept, but in a way this is a cry for help because I don't actually know how long this is or if I'm totally wasting my time. At least my code is reusable."));
    }
}
