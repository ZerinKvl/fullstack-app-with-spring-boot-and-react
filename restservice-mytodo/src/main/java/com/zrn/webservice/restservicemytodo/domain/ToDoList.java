package com.zrn.webservice.restservicemytodo.domain;

import java.util.List;

public class ToDoList {

  private int todolistId;
  private String listName;

  List<ToDo> todos;

  public ToDoList() {
    // TODO Auto-generated constructor stub
  }

  public ToDoList(String listName) {
    this.listName = listName;
  }

  public ToDoList(int todolistId, String listName, List<ToDo> todos) {
    this.todolistId = todolistId;
    this.listName = listName;
    this.todos = todos;
  }

  public int getTodolistId() {
    return todolistId;
  }

  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public List<ToDo> getTodos() {
    return todos;
  }

  public void setTodos(List<ToDo> todos) {
    this.todos = todos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + todolistId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ToDoList other = (ToDoList) obj;
    if (todolistId != other.todolistId) return false;
    return true;
  }

  @Override
  public String toString() {
    return "ToDoList [todolistId="
        + todolistId
        + ", listName="
        + listName
        + ", todos="
        + todos.toString()
        + "]";
  }
}
