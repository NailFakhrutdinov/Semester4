package com.kpfu.itis.controller;

import com.kpfu.itis.dao.CRUDDao;
import com.kpfu.itis.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/delete/*")
public class DeleteTodoController {

    @Autowired
    private CRUDDao<ToDo> dao;
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String doDelete(@PathVariable("id")Long id) {
        dao.delete(id);
        return "redirect:/list";
    }
}
