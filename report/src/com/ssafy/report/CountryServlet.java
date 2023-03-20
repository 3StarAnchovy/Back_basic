package com.ssafy.report;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/country_list")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CountryDAO dao = new CountryDAO();
		try {
			List<CountryDTO> list = dao.selectAll();

			String html = "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "    <table>\r\n"
					+ "        <tr>\r\n" + "            <th>code</th>\r\n" + "            <th>name</th>\r\n"
					+ "            <th>continent</th>\r\n" + "            <th>life_expectancy</th>\r\n"
					+ "        </tr>\r\n";
			// city 개수만큼 tr태그 만들기
			for (CountryDTO country : list) {
				html += "<tr>\r\n" + "            <td>" + country.getCode() + "</td>\r\n" + "            <td>"
						+ country.getName() + "</td>\r\n" + "            <td>" + country.getContinent() + "</td>\r\n"
						+ "            <td>" + country.getLifeExpectancy() + "</td>\r\n" + "        </tr>\r\n";
			}
			html += "    </table>\r\n" + "</body>\r\n" + "</html>";
			response.getWriter().append(html);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
