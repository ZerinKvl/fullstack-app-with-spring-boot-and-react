package com.zrn.webservice.restservicemytodo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zrn.webservice.restservicemytodo.domain.ToDo;
import com.zrn.webservice.restservicemytodo.domain.ToDoList;

@Service
public class ToDoServiceImpl implements ToDoService {

  private static List<ToDoList> lists = new ArrayList<>();

  private static int idCounter = 0;

  static {
    List<ToDo> todos1 = new ArrayList<>();
    todos1.add(new ToDo("study java"));
    todos1.add(new ToDo("study mysql"));

    lists.add(idCounter++, new ToDoList(idCounter, "interview", todos1));

    List<ToDo> todos2 = new ArrayList<>();
    todos2.add(new ToDo("clean wc"));
    todos2.add(new ToDo("clean rooms"));

    lists.add(idCounter++, new ToDoList(idCounter, "cleaning", todos2));
    List<ToDo> todos3 = new ArrayList<>();
    todos3.add(new ToDo("go to cinema"));
    todos3.add(new ToDo("go shopping"));

    lists.add(idCounter++, new ToDoList(idCounter, "personals", todos3));
  }

  @Override
  public List<ToDoList> findAllList(String username) {

    return lists;
  }

  @Override
  public List<ToDo> findAllToDos(String listName) {

    for (ToDoList list : lists) {
      if (listName.equals(list.getListName())) return list.getTodos();
    }
    return null;
  }

  @Override
  public ToDoList deleteListById(int id) {
    ToDoList todoList = findListById(id);
    if (todoList == null) return null;
    if (lists.remove(todoList)) return todoList;

    return null;
  }

  public ToDoList findListById(int listId) {

    for (ToDoList list : lists) {
      if (list.getTodolistId() == listId) return list;
    }
    return null;
  }

  @Override
  public List<ToDoList> deleteAllList(String username) {
    lists.clear();
    return null;
  }

  @Override
  public List<ToDo> deleteToDosBylistId(int listId) {
    List<ToDo> todos = findListById(listId).getTodos();

    if (todos != null) {
      todos.clear();
      return null;
    }
    return todos;
  }

  @Override
  public ToDo deleteToDoByTodoId(int listId, int todoId) {
    ToDoList list = findListById(listId);
    // ToDo todo=findToDoById(list, todoId);

    // list.getTodos().set(todoId, null);
    List<ToDo> todos = list.getTodos();

    todos.set(todoId, null);

    if (todos.get(todoId) == null) {
      return null;
    }
    return todos.get(todoId);
  }
}
