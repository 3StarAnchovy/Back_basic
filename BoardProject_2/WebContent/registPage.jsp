<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="http://localhost:8080/BoardProject_2/board">
        <input type="hidden" name="param" value="regist" />
        <fieldset>
            <label for="">title</label>
            <input type="text" name="title" id=""><br>
            <label for="">content</label>
            <input type="text" name="content" id=""><br>
            <label for="">writername</label>
            <input type="text" name="writername" id=""><br>
            <input type="submit" value="등록">
        </fieldset>
    </form>
</body>

</html>