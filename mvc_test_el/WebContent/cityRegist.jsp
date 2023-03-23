<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도시 정보 등록 페이지</title>
</head>

<body>
    <form action="${pageContext.request.contextPath}/city">
    	<input type = "hidden" name= "param" value="regist"/>
        <fieldset>
            <label for="">Name</label>
            <input type="text" name="name" id=""><br>
            <label for="">CountryCode</label>
            <input type="text" name="countryCode" id=""><br>
            <label for="">Population</label>
            <input type="text" name="population" id=""><br>
            <input type="submit" value="등록">
        </fieldset>
    </form>
</body>

</html>