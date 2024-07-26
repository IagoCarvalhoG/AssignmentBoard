package com.projetospessoal.assignmentboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospessoal.assignmentboard.entities.Group;
import com.projetospessoal.assignmentboard.services.group.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    
    @Autowired
    GroupService groupService;
    
    @PostMapping("/create")
    public ResponseEntity<Map<String,String>> createGroup(@RequestBody Map<String, Object> groupMap){
        String groupName = (String) groupMap.get("group_name");
        Group group = groupService.createGroup(groupName);
        Map<String, String> map = new HashMap<>();
        map.put("message", "group successfully created");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
}
