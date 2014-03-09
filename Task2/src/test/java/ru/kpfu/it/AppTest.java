package ru.kpfu.it;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class AppTest {
	App app;
	@Before
	public void createApp() {
		app = new App(new TodoStoreSetImpl());
	}
	@After
	public void SetNull() {
		app = null;
	}
	@Test
    public void testCorrectAdd() {
        String answer;
        answer = app.addTodo("add Test");
        assertEquals("Incorrect add", "Done.", answer);
        assertEquals("Store hasn't 1 element",Long.valueOf(1), app.size());
    }
	@Test
	public void testSingleAdd() {
		String answer;
		answer = app.addTodo("add");
		assertEquals("Correct add","Missing title.",answer);
		assertEquals("Store has any elements",Long.valueOf(0),app.size());
	}
	@Test
	public void testAddWithSpace() {
		String answer = app.addTodo("add ");
		assertEquals("Correct add","Missing title.",answer);
		assertEquals("Store has any elements",Long.valueOf(0),app.size());
	}
	@Test
	public void testAddSeveralWords() {
		String answer = app.addTodo("add many words");
		assertEquals("Incorrect add","Done.",answer);
	}
}
