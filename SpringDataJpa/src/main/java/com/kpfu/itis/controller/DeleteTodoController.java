package com.kpfu.itis.controller;

import com.kpfu.itis.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/delete/*")
public class DeleteTodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String doDelete(@PathVariable("id")Long id) {
        todoService.deleteToDo(id);
        return "redirect:/list";
    }
}
