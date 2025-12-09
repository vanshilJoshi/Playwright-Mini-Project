package tests;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ToDoPage;

public class ToDoFooterTest extends BaseTest {
    
    @Test
    public void activeToDo() {

        ToDoPage todo = new ToDoPage(page);

        test.info("Verify the Active filter shows only uncompleted todos and All filter restores full list.");

        todo.navigate();

        todo.addDefaultTodos();

        todo.checkNthCheckbox(1);

        todo.showActiveToDo();

        assertEquals(todo.getToDoCount(), 2);

        todo.showAllToDo();

        assertEquals(todo.getToDoCount(), 3);
    }

    @Test
    public void completedToDo() {

        ToDoPage todo = new ToDoPage(page);

        test.info("Verify the Completed filter shows only completed todos and All filter restores full list.");

        todo.navigate();

        todo.addDefaultTodos();

        todo.checkNthCheckbox(1);

        todo.showCompletedToDo();

        assertEquals(todo.getToDoCount(), 1);

        todo.showAllToDo();

        assertEquals(todo.getToDoCount(), 3);

    }

    @Test
    public void clearCompletedToDo() {

        ToDoPage todo = new ToDoPage(page);

        test.info("Verify Clear Completed removes only completed todos and keeps active todos intact.");

        todo.navigate();

        todo.addDefaultTodos();

        todo.checkNthCheckbox(1);

        todo.clearCompleted();

        assertEquals(todo.getToDoCount(), 2);

    }
}
