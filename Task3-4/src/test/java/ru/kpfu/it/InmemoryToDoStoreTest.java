package ru.kpfu.it;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.kpfu.it.model.ToDo;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class InmemoryToDoStoreTest {
    private ToDoStore store;

    @Before
    public void setUp() {
        store = new InmemoryToDoStore();
    }

    @Test
    public void testGetAll() {
        assertEquals("Store empty", 0, store.getAll().size());
        store.add("Test");
        final Collection<ToDo> todos = store.getAll();
        assertEquals("Store has 1 element", 1, todos.size());
        final ToDo t = todos.iterator().next();
        assertEquals("Correct title", "Test", t.getTitle());
    }

    @Test
    public void testGet() {
        assertNull("Unexisting element", store.get(99L));
        store.add("Test");
        ToDo todo = store.get(1L);
        assertNotNull(todo);
        assertEquals("Correct element", "Test", todo.getTitle());
        todo = store.get(-1L);
        assertNull(todo);
        todo = store.get(1L);
        assertEquals("Element with two calls doesn't deleted","Test",todo.getTitle());
    }
    @Test
    public void testDelete() {
    	store.add("delete me");
    	assertEquals("Store has 1 element", 1,store.getAll().size());
    	boolean isDelete = store.delete(store.getAll().iterator().next().getId());
    	assertEquals("Element has deleted", isDelete, true);
    	assertEquals("Store must be empty", 0,store.getAll().size());
    }
}
