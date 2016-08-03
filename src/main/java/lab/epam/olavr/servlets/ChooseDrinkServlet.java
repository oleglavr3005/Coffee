package lab.epam.olavr.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import lab.epam.olavr.dao.DrinkDB;
import lab.epam.olavr.dao.DrinkDao;
import lab.epam.olavr.dao.IngredientDB;
import lab.epam.olavr.dao.IngredientDao;
import lab.epam.olavr.dao.UserDao;

/**
 * Servlet implementation class ChooseDrinkServlet
 */
public class ChooseDrinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(ChooseDrinkServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseDrinkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			List<DrinkDB> drinks= DrinkDao.get().getAll();
			List<IngredientDB> ingredients= IngredientDao.get().getAll();
			// remove water and coffee from ingredients list
			ingredients.remove(0);
			ingredients.remove(0);
			request.setAttribute("drinks",drinks);
			request.setAttribute("ingredients",ingredients);
			request.getRequestDispatcher("/pages/menu.jsp").forward(request, response);
		}
		catch (Exception e) {
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
			log.error(e.getMessage());
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
