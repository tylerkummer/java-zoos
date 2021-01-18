package com.lambda.zoos.controllers;

import com.lambda.zoos.models.Zoo;
import com.lambda.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/zoos",
        produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(),
            HttpStatus.OK);
    }

    @GetMapping(value = "/zoo/{id}",
        produces = {"application/json"})
    public ResponseEntity<?> findZooById(
        @PathVariable
            long id)
    {
        Zoo z = zooService.findZooById(id);
        return new ResponseEntity<>(z,
            HttpStatus.OK);
    }
}
