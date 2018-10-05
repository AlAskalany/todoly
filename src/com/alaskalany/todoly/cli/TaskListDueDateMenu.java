package com.alaskalany.todoly.cli;

import com.alaskalany.todoly.todo.TaskManager;

import java.util.ArrayList;

public class TaskListDueDateMenu extends Menu {

    private final TaskManager taskManager;
    private final MainMenu mainMenu;

    TaskListDueDateMenu(MainMenu mainMenu, TaskManager taskManager) {

        super("Tasks by due date");
        this.taskManager = taskManager;
        this.mainMenu = mainMenu;
    }

    @Override
    protected void setOptions(ArrayList<String> options) {

    }

    @Override
    protected void displayBody() {

        taskManager.getAllProjects().forEach(project -> {
            System.out.println(project.getTitle());
            System.out.println();
            project.getAllTasks()
                    .forEach(task -> System.out.println(project.getAllTasks().indexOf(task) + "- " + task));
        });
        taskManager.getAllWithNoProject().forEach(task -> System.out
                .println((1 + taskManager.getAllWithNoProject().indexOf(task)) + "- " + task));
    }

    @Override
    protected String setPrompt() {

        return "Enter task number to edit, or 0 to go to main menu";
    }

    @Override
    public void onInput(String input) {

        if (input.equals("0")) {
            mainMenu.display();
        }
    }
}
