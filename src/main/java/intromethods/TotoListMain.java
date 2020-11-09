package intromethods;

import java.util.Arrays;

public class TotoListMain {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.addTodo("Első feladat");
        todoList.addTodo("Második feladat");
        todoList.addTodo("Harmadik feladat");
        todoList.addTodo("Negyedik feladat");

        System.out.println(todoList);

        todoList.finishTodos("Első feladat");

        System.out.println(todoList);

        System.out.println(todoList.todosToFinish());

        System.out.println(todoList.numberOfFinishedTodos());

        todoList.finishAllTodos(Arrays.asList("Második feladat", "Negyedik feladat"));

        System.out.println(todoList);
        System.out.println(todoList.numberOfFinishedTodos());
        System.out.println(todoList.todosToFinish());


    }

}
