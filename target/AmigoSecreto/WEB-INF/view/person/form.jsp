<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar Pessoa</title>
</head>
<body>
  <h3>Adicionar Pessoa</h3>
  <form action="add" method="post">

    
    name:<br/>
    <input type="text" name="name"><br/>     
    <form:errors path="person.name" cssStyle="color:red"/><br/>
    
    
    email:<br/>
    <input type="text" name="email"><br/>     
    <form:errors path="person.email" cssStyle="color:red"/><br/>

    <input type="submit" value="Adicionar"/>

  </form>
</body>
</html>