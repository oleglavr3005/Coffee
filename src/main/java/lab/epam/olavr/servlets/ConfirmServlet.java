package lab.epam.olavr.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.log4j.Logger;

import lab.epam.olavr.dao.AccountDao;
import lab.epam.olavr.dao.DrinkDB;
import lab.epam.olavr.dao.DrinkDao;
import lab.epam.olavr.dao.IngredientDB;
import lab.epam.olavr.dao.IngredientDao;
import lab.epam.olavr.dao.UserDao;
import lab.epam.olavr.model.Order;
import lab.epam.olavr.service.OrderService;

/**
 * Servlet implementation class ConfirmServlet
 */
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(ConfirmServlet.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		HttpSession session = request.getSession(false);
		List<DrinkDB> drinks = DrinkDao.get().getAll();
		List<IngredientDB> ingredients = IngredientDao.get().getAll();
		ingredients.remove(0);
		ingredients.remove(0);
		String drink=request.getParameter("drink");
		System.out.println(drink);
		DrinkDB selectedDrink= DrinkDao.get().getByFieldName("drinkName", drink).get(0);
		List<String> ingredientsAmount=new ArrayList<>();
		for (IngredientDB ingr:ingredients){
			ingredientsAmount.add(request.getParameter(ingr.getIngredientName()));
		}
		
		System.out.println(drink);
		System.out.println(ingredientsAmount);
		Order order=new Order(UserDao.get().getByFieldName("login", session.getAttribute("login").toString()).get(0),selectedDrink,ingredients,ingredientsAmount);
		Double totalPrice=OrderService.getValue(order);
		
		//ingredients = IngredientDao.get().getAll();
		Map<IngredientDB, Double>totalExpenses=OrderService.calcExpenses(order);
		//Long id=AccountDao.get().getByFieldName("login", session.getAttribute("login").toString()).get(0).getAccountId();
		Boolean isSumOnAccount=totalPrice<=AccountDao.get().getByFieldName("user", session.getAttribute("login").toString()).get(0).getAmount();
		Boolean isIngredients=true;
		List<IngredientDB>ingredientsAll = IngredientDao.get().getAll();
		for (IngredientDB ingr:ingredients){
			if(ingr.getAmount()<totalExpenses.get(ingr)){
				isIngredients=false;
				break;
			}
		}
		if ( isSumOnAccount && isIngredients){
			OrderService.finishOrder(order);
		}
		request.setAttribute("drinks", drinks);
		request.setAttribute("ingredients", ingredients);
		request.setAttribute("isOrdered", "true");
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("isSumOnAccount", isSumOnAccount);
		request.setAttribute("isIngredients", isIngredients);
		request.getRequestDispatcher("/pages/menu.jsp").forward(request, response);
	}
		catch (Exception e) {
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
			log.error(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
