package lab.epam.olavr.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.management.InvalidApplicationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import lab.epam.olavr.dao.IngredientDB;
import lab.epam.olavr.dao.IngredientDao;
import lab.epam.olavr.model.Ingredient;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static boolean isValidData = true;
	public static final Logger log = Logger.getLogger(AdminServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		isValidData = true;
		try {
			List<IngredientDB> ingredients = IngredientDao.get().getAll();
			// HttpSession session=request.getSession();
			// request.setAttribute("ingredients", ingredients);
			if (request.getParameter("source") != null) {
				Map<String, String[]> ingrAmounts = request.getParameterMap();
				for (String ingr : ingrAmounts.keySet()) {
					String ingrStr = ingr;
					String amountStr = ingrAmounts.get(ingr)[0];

					if (!(ingr.equals("source")) && !(ingr.equals("ingredients_length"))) {
						if (Double.parseDouble(amountStr) >= Ingredient.getIngredientByName(ingredients, ingr)
								.getAmount()
								&& Double.parseDouble(amountStr) <= Ingredient.getIngredientByName(ingredients, ingr)
										.getMaxAmount()) {

							IngredientDao.get().updateAmount(Double.parseDouble(amountStr), IngredientDao.get()
									.getByFieldName("ingredientName", ingrStr).get(0).getIngredientId());
						} else {
							request.setAttribute("message", "Invalid data");
							// isValidData = false;

						}
					}
				}
			}
			ingredients = IngredientDao.get().getAll();
			request.setAttribute("ingredients", ingredients);
		} catch (Exception e) {
			log.error(e.getStackTrace());
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
			return;

		}
		request.getRequestDispatcher("/pages/administration.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
