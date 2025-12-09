package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import base.BaseTest;

public class ToDoPage extends BaseTest {
    private Page page;
    
    private final String toDoInput = "#new-todo";
    private final String toDoCount = "#todo-list li";
    private final String checkBox = "role=checkbox";
    private final String deleteBtn = ".destroy";
    private final String AllBtn = "#filters > li:nth-child(1) > a";
    private final String activeBtn = "#filters > li:nth-child(2) > a";
    private final String completedBtn = "#filters > li:nth-child(3) > a";
    private final String clearCompletedBtn = ".clear-completed";


    public ToDoPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://todomvc.com/examples/jquery/dist/#/all");
    }

    public void addDefaultTodos() {
        addToDo("Eat");
        enterToDo();

        addToDo("Sleep");
        enterToDo();

        addToDo("Repeat");
        enterToDo();
    }

    public void addToDo(String todo) {
        page.fill(toDoInput, todo);
    }

    public void enterToDo() {
        page.press(toDoInput, "Enter");
    }

    public int getToDoCount() {
        return page.locator(toDoCount).count();
    }


    public void checkNthCheckbox(int index) {
        page.locator(checkBox).nth(index).check();
    }

    public void uncheckNthCheckbox(int index) {
        page.locator(checkBox).nth(index).uncheck();
    }

    public void deleteToDo(String itemText) {
        Locator todoItem = page.locator("div", new Page.LocatorOptions().setHasText(itemText));
        todoItem.hover();
        todoItem.locator(deleteBtn).click();
    }

    public void showAllToDo() {
        page.click(AllBtn);
    }

    public void showActiveToDo() {
        page.click(activeBtn);
    }

    public void showCompletedToDo() {
        page.click(completedBtn);
    }

    public void clearCompleted() {
        page.click(clearCompletedBtn);
    }

}
