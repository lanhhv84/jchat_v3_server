package com.example.jchat_v3.controller;

import com.example.jchat_v3.model.ChatGroup;
import com.example.jchat_v3.service.ChatGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/group")
public class GroupController  extends BaseController{

    @Autowired
    ChatGroupService chatGroupService;

    @RequestMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") int id) {
        return ok(chatGroupService.findOne(id));
    }


}
