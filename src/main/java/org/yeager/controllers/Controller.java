package org.yeager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yeager.models.Request;
import org.yeager.models.Response;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Response>> getAll(){
        List<Response> list = new ArrayList<Response>();
        return new ResponseEntity<List<Response>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getById(@PathVariable Integer id){
        return new ResponseEntity<Response>(new Response("Hello"), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Request request, @PathVariable Integer id){
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id){
        return new ResponseEntity(HttpStatus.OK);
    };

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Request request){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /**
     * Prohibited endpoints - violation of REST principals.
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> createById(@PathVariable Integer id) {
        return new ResponseEntity<String>(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<String> updateOrDeleteAll(@RequestBody Request request) {
        return new ResponseEntity<String>(HttpStatus.METHOD_NOT_ALLOWED);
    }
}
