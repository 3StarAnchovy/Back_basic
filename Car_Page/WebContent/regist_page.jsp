<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>차 등록</title>
</head>

<body>
    <form action="${pageContext.request.contextPath}/car">
    	<input type = "hidden" name= "param" value="registAction"/>
        <fieldset>
            <label for="">car number</label>
            <input type="text" name="number" id=""><br>
            <label for="">model</label>
            <input type="text" name="model" id=""><br>
            <label for="">price</label>
            <input type="text" name="price" id=""><br>
            <label for="">brand</label>
            <input type="text" name="brand" id=""><br>
            <input type="submit" value="등록">
        </fieldset>
    </form>
</body>

</html>