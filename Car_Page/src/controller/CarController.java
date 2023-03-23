package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import service.CarService;

/**
 * Servlet implementation class CarController
 */
@WebServlet("/car")
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarService carService = new CarService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("param");

		try {
			if (param.equals("list")) {
				listAction(request, response);
			}
			
			else if(param.equals("regist"))
			{
				regist(request,response);
			}
			
			else if(param.equals("registAction"))
			{
				registAction(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void registAction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String number = request.getParameter("number");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		String brand = request.getParameter("brand");
		
		Car car = new Car(number,model,price,brand);
		//서비스 호출
		carService.registAction(car);
		response.sendRedirect(request.getContextPath() + "/car?param=list");
	}

	private void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/regist_page.jsp");
		
	}

	private void listAction(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// 모델 호출
		List<Car> car_list = carService.list();
		// view page로 이동

		request.setAttribute("car_list", car_list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("car_list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
