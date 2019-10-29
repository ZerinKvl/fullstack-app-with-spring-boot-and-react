package com.zrn.webservice.restservicemytodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zrn.webservice.restservicemytodo.domain.ToDo;
import com.zrn.webservice.restservicemytodo.domain.ToDoList;
import com.zrn.webservice.restservicemytodo.service.ToDoService;

@RestController
@CrossOrigin(origins = "http://localhost:8083")
public class ToDoController {

  @Autowired private ToDoService todoService;

  @GetMapping("/users/{username}/lists")
  public List<ToDoList> getAllLists(@PathVariable String username) {
    return todoService.findAllList(username);
  }

  @GetMapping("/users/{username}/{listName}/todos")
  public List<ToDo> getListName(@PathVariable String listName) {
    return todoService.findAllToDos(listName);
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
