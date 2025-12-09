package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


import base.BaseTest;
import pages.ToDoPage;

public class ToDoTextboxTest extends BaseTest {

    @Test
    public void pressEnterDirectly() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify pressing Enter directly adds the todo.");

        todo.navigate();
        todo.addToDo("Direct Enter Test");
        page.keyboard().press("Enter");

        assertEquals(todo.getToDoCount(), 1);
    }

    @Test
    public void addMultipleTodos() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify user can add multiple default todos.");

        todo.navigate();

        todo.addDefaultTodos();
    }

    @Test
    public void addEmptyTodo() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify no todo is created when empty string is entered.");

        todo.navigate();
        todo.addToDo("");
        todo.enterToDo();

        assertEquals(todo.getToDoCount(), 0);
    }

    @Test
    public void addSpacesTodo() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify spaces-only todo is not added.");

        todo.navigate();
        todo.addToDo("     "); // spaces
        todo.enterToDo();

        assertEquals(todo.getToDoCount(), 0);
    }

    @Test
    public void addSpecialCharacters() {
        ToDoPage todo = new ToDoPage(page);

        test.info("Verify special character todo is accepted and added.");

        todo.navigate();
        todo.addToDo("Learn Playwright! @#$%^&*()");
        todo.enterToDo();

        assertEquals(todo.getToDoCount(), 1);
    }

}
