package com.kpfu.itis.controller;

import com.kpfu.itis.model.ToDo;
import com.kpfu.itis.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/list")
public class ToDoListController {

    @Autowired
    private TodoService todoService;

    @ModelAttribute("toDoList")
    public TodoService populateMakes() {
        return todoService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleAddToDo(Model model,@Valid ToDo toDo, BindingResult result) {
        if(result.hasErrors()) {
            return "toDoList";
        }
        todoService.saveToDo(toDo);
        model.addAttribute("toDo", new ToDo());
        return "toDoList";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getToDoList(Model model) {
        ToDo toDo = new ToDo();
        model.addAttribute("toDo", toDo);
        return "toDoList";
    }
}
