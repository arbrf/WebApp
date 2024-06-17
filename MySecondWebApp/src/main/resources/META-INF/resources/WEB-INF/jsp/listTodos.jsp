<%@ include file="common/header.jspf" %>
    <div class="container">
        <div class="my-4">
            <h1>Welcome ${name}</h1>
            <hr>
            <h2>Your Todo List</h2>
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done</th>
                        <th>Delete Todo</th>
                        <th>Update Todo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="todo" items="${todos}">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
                            <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update todo</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <a href="add-todo" class="btn btn-success">Add todo</a>
        
    </div>
    
  <%@ include file="common/footer.jspf" %>
