import React, { Component } from "react";

class ToDoList extends Component {
  render() {
    return (
      <div className="list">
        <header>
          <form>
            <input placeholder="Create New List" />
            <button type="submit"> Add List </button>
          </form>
        </header>
      </div>
    );
  }
}

export default ToDoList;
