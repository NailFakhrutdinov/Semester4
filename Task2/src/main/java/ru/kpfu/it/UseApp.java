package ru.kpfu.it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ru.kpfu.it.model.Todo;

public class UseApp {
	public static void main( String[] args ) throws IOException {
		TodoStore store = new TodoStoreSetImpl();
        App app = new App(store);
		System.out.println( "Todo app" );
        store.add(new Todo("Check listAll."));
        boolean exit = false;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (!exit) {
            System.out.print("> ");
            String input = in.readLine().toLowerCase();
            String answer = "";
            if (input.equals("list")) {
                answer = app.listAll();
            } else if (input.startsWith("q")) {
                exit = true;
            } else if (input.startsWith("add ")) {
                answer = app.addTodo(input);
            }
            System.out.println(answer);
        }
    }

}
