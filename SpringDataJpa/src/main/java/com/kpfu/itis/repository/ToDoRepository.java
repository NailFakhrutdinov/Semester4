package com.kpfu.itis.repository;

import com.kpfu.itis.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,Long> {

}
