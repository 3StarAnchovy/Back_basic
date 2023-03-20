package bookProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/book_list")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		try {
			List<City> list = bookDao.selectAll();
			//city 목록을 통해 html 문서를 만들어서
			String html =
					"<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <title>도시 목록 페이지</title>\r\n" + 
					"    <style>\r\n" + 
					"        table, th, td {\r\n" + 
					"            border: 1px solid black;\r\n" + 
					"        }\r\n" + 
					"    </style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"    <table>\r\n" + 
					"        <tr>\r\n" + 
					"            <th>ID</th>\r\n" + 
					"            <th>Name</th>\r\n" + 
					"            <th>CountryCode</th>\r\n" + 
					"            <th>Population</th>\r\n" + 
					"        </tr>\r\n" ;  
					
			//city 개수만큼 tr태그 만들기
			for(City city : list)
			{
				html +=  "<tr>\r\n" + 
						"            <td>"+ city.getId() +"</td>\r\n" + 
						"            <td>"+ city.getName() +"</td>\r\n" + 
						"            <td>"+ city.getContryCode() +"</td>\r\n" + 
						"            <td>"+ city.getPopulation() +"</td>\r\n" + 
						"        </tr>\r\n";
			} 
					
					html += "    </table>\r\n" + 
					"</body>\r\n" + 
					"</html>";
			
			//html 문서 반환
			response.getWriter().append(html);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter().append("도서 반환");
	}

	

}
