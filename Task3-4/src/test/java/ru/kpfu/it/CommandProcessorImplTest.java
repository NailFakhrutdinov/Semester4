package ru.kpfu.it;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.kpfu.it.model.ToDo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CommandProcessorImplTest {
    @Autowired
    private CommandProcessor processor;
    @Autowired
    private ToDoStore mockStore;
    @Before
    public void clear() {
    	reset(mockStore);
    }
    @Test
    public void testHandleCreate() {
        processor.handleCreate("Test");
        verify(mockStore).add("Test");
        processor.handleCreate("Test");
        verify(mockStore,times(2)).add("Test");
    }
    @Test
    public void testHandleCloseWithExistingToDo() {
    	ToDo todo = mock(ToDo.class);
    	when(mockStore.get(1L)).thenReturn(todo);
    	processor.handleClose(1L);
    	verify(mockStore).get(1L);
    	verify(todo).setCompleted(true);
    }
    @Test
    public void testHandleList() {
        processor.handleList();
        verify(mockStore).getAll();
    }
    @Test
    public void testHandleDelete() {
    	processor.handleDelete(1l);
    	verify(mockStore).delete(1L);
    }

    @Configuration
    static class Config {
        @Bean CommandProcessor cmdProc() {
            return new CommandProcessorImpl(mockStore());
        }

        @Bean
        public ToDoStore mockStore() {
            return mock(ToDoStore.class);
        }
    }
}