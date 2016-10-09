package lab.epam.olavr.servlets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.epam.olavr.dao.ConnectionUtils;
import lab.epam.olavr.dao.DataSourceRepository;
import lab.epam.olavr.dao.UserDB;
import lab.epam.olavr.dao.UserDao;
import lab.epam.olavr.exception.GeneralCustomException;
import lab.epam.olavr.service.Security;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	HttpSession session;
	// Log4j logger
	public static final Logger log = Logger.getLogger(IndexServlet.class);

	/**
	 * Default constructor.
	 */
	public IndexServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		UserDB user;
		try {
			System.out.println(Security.get_SHA_1_SecurePassword(pass, login.getBytes(Charset.forName("UTF-8"))));
			if (UserDao.get().existsUser(login)) {

				user = UserDao.get().getByFieldName("login", login).get(0);
				if (user.getPassword()
						.equals(Security.get_SHA_1_SecurePassword(pass, login.getBytes(Charset.forName("UTF-8"))))) {
					HttpSession session = request.getSession(true);
					session.setAttribute("login", user.getLogin());
					session.setAttribute("role", user.getRoleId());
					session.setAttribute("logout", "logout");
					session.setAttribute("welcomeMessage", "Hello " + user.getLogin());

					if (user.getRoleId() == 2)
						session.setAttribute("admin", "admin");
					request.getRequestDispatcher("/menu").forward(request, response);
				} else {
					request.setAttribute("error", "errorLogin");
					request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
				}
			} else {
				request.setAttribute("error", "errorLogin");
				request.getRequestDispatcher("/pages/index.jsp").forward(request,response);
			}
		} catch (GeneralCustomException e) {
			request.setAttribute("error", "Invalid login or password");
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
			log.error(e.getMessage());
		} catch (Exception e) {
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
			log.error(e.getMessage());
		}


	}

}
