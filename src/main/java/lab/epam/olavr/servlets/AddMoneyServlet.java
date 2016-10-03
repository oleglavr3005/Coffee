package lab.epam.olavr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import lab.epam.olavr.dao.AccountDB;
import lab.epam.olavr.dao.AccountDao;
import lab.epam.olavr.service.OrderService;

/**
 * Servlet implementation class AddMoneyServlet
 */
public class AddMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(AddMoneyServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMoneyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Double amount;
		HttpSession session;
		try {
			Double addMoney = Double.parseDouble(request.getParameter("addMoney"));
			session = request.getSession();
			AccountDB acc = AccountDao.get().getByFieldName("user", session.getAttribute("login").toString()).get(0);
			amount = acc.getAmount();
			Long id = acc.getAccountId();
			AccountDao.get().updateAmount(amount + addMoney, id);
			amount = AccountDao.get().getByFieldName("user", session.getAttribute("login").toString()).get(0)
					.getAmount();
			request.setAttribute("currentAmount", amount);
			request.getRequestDispatcher("/pages/account.jsp").forward(request, response);
		} catch (Exception e) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
