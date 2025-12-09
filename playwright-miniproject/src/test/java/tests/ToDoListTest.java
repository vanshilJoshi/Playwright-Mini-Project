package tests;

import static org.testng.Assert.*;

import java.util.stream.IntStream;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ToDoPage;

public class ToDoListTest extends BaseTest {
    
    @Test
    public void checkSingleToDo() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify only the selected single todo item gets checked.");

        todo.navigate();

        todo.addDefaultTodos();

        todo.checkNthCheckbox(1);

        assertEquals(todo.getToDoCount(), 3);
    }

    @Test
    public void checkMultipleToDo() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify multiple todos can be checked using checkboxes.");

        todo.navigate();

        todo.addDefaultTodos();

        IntStream.rangeClosed(1, 3).forEach(todo::checkNthCheckbox);

        assertEquals(todo.getToDoCount(), 3);
    }

    @Test
    public void uncheckMultipleToDo() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify checked todos can be unchecked back to active state.");

        todo.navigate();

        todo.addDefaultTodos();

        IntStream.rangeClosed(1, 3).forEach(todo::checkNthCheckbox);

        IntStream.rangeClosed(1, 3).forEach(todo::uncheckNthCheckbox);

        assertEquals(todo.getToDoCount(), 3);
    }

    @Test
    public void removeToDo() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify user can delete a todo item by clinking on X button.");

        todo.navigate();

        todo.addDefaultTodos();

        todo.deleteToDo("Sleep");

        assertEquals(todo.getToDoCount(), 2);
    }

}
