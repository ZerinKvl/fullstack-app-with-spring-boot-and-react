package com.zrn.webservice.restservicemytodo.service;

import java.util.List;

import com.zrn.webservice.restservicemytodo.domain.ToDo;
import com.zrn.webservice.restservicemytodo.domain.ToDoList;

public interface ToDoService {

  public List<ToDoList> findAllList(String username);

  public ToDoList getListById(int listId);

  public List<ToDo> findAllToDos(String listName);

  public List<ToDoList> createList(ToDoList newList);

  public ToDoList createToDo(int listId, ToDo newToDo);

  public List<ToDoList> deleteAllList(String username);

  public ToDoList deleteListById(int listId);

  public List<ToDo> deleteToDosBylistId(int listId);

  public ToDo deleteToDoByTodoId(int listId, int todoId);
}
