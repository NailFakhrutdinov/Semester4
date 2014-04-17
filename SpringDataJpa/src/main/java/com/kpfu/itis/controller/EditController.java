package com.kpfu.itis.controller;

import com.kpfu.itis.model.ToDo;
import com.kpfu.itis.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("/edit/*")
public class EditController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String goToEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("toDo", todoService.getById(id));
        return "editTodo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleForm(@Valid ToDo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "editTodo";
        }
        todoService.updateToDo(todo);
        return "redirect:/list";
    }
}
