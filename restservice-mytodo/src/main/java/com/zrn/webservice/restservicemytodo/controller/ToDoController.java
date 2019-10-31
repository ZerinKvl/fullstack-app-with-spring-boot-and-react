package com.zrn.webservice.restservicemytodo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zrn.webservice.restservicemytodo.domain.ToDo;
import com.zrn.webservice.restservicemytodo.domain.ToDoList;
import com.zrn.webservice.restservicemytodo.service.ToDoService;

@RestController

public class ToDoController {

  @Autowired private ToDoService todoService;

  @GetMapping(
      path = "/users/{username}/lists",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public List<ToDoList> getAllLists(@PathVariable String username) {
    return todoService.findAllList(username);
  }

  @GetMapping(
      path = "/users/{username}/lists/{listId}",
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ToDoList getListById(@PathVariable String username, @PathVariable int listId) {
    ToDoList list = todoService.getListById(listId);

    return list;
  }

  @GetMapping("/users/{username}/{listName}/todos")
  public List<ToDo> getListName(@PathVariable String listName) {
    return todoService.findAllToDos(listName);
  }

  @PostMapping(
      path = "/users/{username}/lists",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<List<ToDoList>> createList(
      @PathVariable String username, @RequestBody ToDoList newList) {
    List<ToDoList> createdList = todoService.createList(newList);

    return new ResponseEntity<List<ToDoList>>(createdList, HttpStatus.OK);
  }

  @PostMapping(
      path = "/users/{username}/lists/{listId}/todos",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<ToDoList> createList(
      @PathVariable String username, @PathVariable int listId, @RequestBody ToDo newTodo) {
    ToDoList createdToDo = todoService.createToDo(listId, newTodo);

    return new ResponseEntity<ToDoList>(createdToDo, HttpStatus.OK);
  }

  @DeleteMapping("/users/{username}/lists")
  public ResponseEntity<Void> deleteAllList(@PathVariable String username) {

    List<ToDoList> lists = todoService.deleteAllList(username);

    if (lists == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/users/{username}/lists/{listId}")
  public ResponseEntity<Void> deleteListById(
      @PathVariable String username, @PathVariable int listId) {

    ToDoList list = todoService.deleteListById(listId);

    if (list != null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/users/{username}/lists/{listId}/todos")
  public ResponseEntity<Void> deleteToDosBylistId(
      @PathVariable String username, @PathVariable int listId) {

    List<ToDo> todos = todoService.deleteToDosBylistId(listId);

    if (todos == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/users/{username}/lists/{listId}/todos/{todoId}")
  public ResponseEntity<Void> deleteToDoByTodoId(
      @PathVariable String username, @PathVariable int listId, @PathVariable int todoId) {

    ToDo todos = todoService.deleteToDoByTodoId(listId, todoId);

    if (todos == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
