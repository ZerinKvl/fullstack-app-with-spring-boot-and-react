package com.zrn.webservice.restservicemytodo.domain;

import java.util.Date;

public class ToDo {

  private Long toDoId;
  private String todoName;
  private String description;
  private Date deadline;
  private boolean status = false;

  public ToDo() {
    // TODO Auto-generated constructor stub
  }

  public ToDo(String todoName) {
    this.todoName = todoName;
  }

  public ToDo(String todoName, String description, Date deadline, boolean status) {
    this.todoName = todoName;
    this.description = description;
    this.deadline = deadline;
    this.status = status;
  }

  public String getTodoName() {
    return todoName;
  }

  public void setTodoName(String todoName) {
    this.todoName = todoName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDeadline() {
    return deadline;
  }

  public void setDeadline(Date deadline) {
    this.deadline = deadline;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((toDoId == null) ? 0 : toDoId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ToDo other = (ToDo) obj;
    if (toDoId == null) {
      if (other.toDoId != null) return false;
    } else if (!toDoId.equals(other.toDoId)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "ToDo [toDoId="
        + toDoId
        + ", todoName="
        + todoName
        + ", description="
        + description
        + ", deadline="
        + deadline
        + ", status="
        + status
        + "]";
  }
}
