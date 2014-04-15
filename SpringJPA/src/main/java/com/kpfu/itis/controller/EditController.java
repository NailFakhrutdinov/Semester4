package com.kpfu.itis.controller;

import com.kpfu.itis.dao.CRUDDao;
import com.kpfu.itis.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/edit/*")
public class EditController {

    @Autowired
    private CRUDDao<ToDo> dao;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String goToEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("toDo", dao.getById(id));
        return "editTodo";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handleForm(ToDo todo, BindingResult result) {
        dao.update(todo);
        return "redirect:/list";
    }
}
