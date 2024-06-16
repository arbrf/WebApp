<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todos List</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        <h1>Add new Todo</h1>
        <form:form method="post" modelAttribute="todo">
        Enter Todo <form:input type="text"  path="description" required="required"/>
        <form:errors path="description" cssClass="text-warning"/>
        <form:input type="hidden"  path="id"/>
        <form:input type="hidden"  path="done"/>
        
         <input type="submit" class="btn btn-success">
        </form:form>
    </div>
    
    <!-- Include jQuery and Bootstrap JS -->
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
