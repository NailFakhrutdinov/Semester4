package com.kpfu.itis.dao;

import com.kpfu.itis.model.ToDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@ContextConfiguration(locations ="classpath:dispatcher-servlet.xml" )
@Transactional
public class ToDoCRUDDaoDerbyImplIT {
    @Autowired
    ToDoCRUDDaoDerbyImpl toDoDao;
    @Test
    public void testSave() {
        ToDo toDo = new ToDo("test");
        toDoDao.save(toDo);
        List<ToDo> list = toDoDao.getAll();
        assertEquals("Table must contains one todo",list.size(),1);
       assertEquals("Objects must be equals",toDo,list.get(0));
    }

    @Test
    public void testUpdate() {
        ToDo toDo = new ToDo("test");
        toDoDao.save(toDo);
        List<ToDo> list = toDoDao.getAll();
        ToDo toDoWithId = list.get(0);
        toDoWithId.setTitle("updated test");
        toDoDao.update(toDoWithId);
        list = toDoDao.getAll();
        assertEquals("Object must be alone in table",list.size(),1);
        assertEquals("objects must be equals",toDoWithId,list.get(0));
    }
    @Test
    public void testGetAll() {
        ToDo todo;
        String todoName = "test";
        for(int i = 0; i < 20; i++) {
            todo = new ToDo(todoName + " " + i);
            toDoDao.save(todo);
        }
        assertEquals("Size must be 20",toDoDao.getAll().size(),20);
    }
    @Test
    public void testDelete() {
        ToDo todo = new ToDo("test");
        toDoDao.save(todo);
        ToDo todoWithId = toDoDao.getAll().get(0);
        toDoDao.delete(todoWithId.getId());
        assertEquals("Table must be empty",toDoDao.getAll().size(),0);
    }
    @Test
    public void testGetTodoById() {
        ToDo todo = new ToDo("test");
        toDoDao.save(todo);
        List<ToDo> list = toDoDao.getAll();
        assertEquals("Table must contains one todo",list.size(),1);
        ToDo todoWithId = list.get(0);
        ToDo expectedTodo = toDoDao.getTodoById(todoWithId.getId());
        assertEquals("Both todo must be equals",expectedTodo,todoWithId);
    }
}
