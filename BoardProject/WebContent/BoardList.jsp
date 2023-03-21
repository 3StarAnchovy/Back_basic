<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List, com.ssafy.model.Board"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 페이지</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>num</th>
			<th>title</th>
			<th>content</th>
			<th>writername</th>
		</tr>
		<%
        List<Board> board_list = (List<Board>)request.getAttribute("board_list");
        
        String html = ""; 
        		for (Board board : board_list) {
    				html += "<tr>\r\n" + 
    						"			<td>"+board.getNum()+ "</td>\r\n" + 
    						"			<td>"+board.getTitle()+ "</td>\r\n" + 
    						"			<td>"+board.getContent()+ "</td>\r\n" + 
    						"			<td>"+board.getWritername()+ "</td>\r\n" + 
    						"		<tr>";
    						
    			}
        		
        		out.print(html);
        %>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>