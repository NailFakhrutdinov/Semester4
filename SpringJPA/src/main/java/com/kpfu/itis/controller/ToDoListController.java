package com.kpfu.itis.controller;

import com.kpfu.itis.dao.CRUDDao;
import com.kpfu.itis.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/list")
public class ToDoListController {


    @Autowired
    private CRUDDao<ToDo> dao;

    @ModelAttribute("toDoList")
    public CRUDDao<ToDo> populateMakes() {
        return dao;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleAddToDo(Model model, ToDo newToDo, BindingResult result) {
        dao.save(newToDo);
        model.addAttribute("newToDo", new ToDo());
        return "toDoList";
}

    @RequestMapping(method = RequestMethod.GET)
    public String getToDoList(Model model) {
        ToDo newToDo = new ToDo();
        model.addAttribute("newToDo", newToDo);
        return "toDoList";
    }
}
