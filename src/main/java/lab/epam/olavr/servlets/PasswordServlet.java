package lab.epam.olavr.servlets;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.epam.olavr.dao.AccountDB;
import lab.epam.olavr.dao.AccountDao;
import lab.epam.olavr.dao.UserDB;
import lab.epam.olavr.dao.UserDao;
import lab.epam.olavr.service.MailService;
import lab.epam.olavr.service.PasswordService;
import lab.epam.olavr.service.Security;
import lab.epam.olavr.service.Validator;

/**
 * Servlet implementation class PasswordSevlet
 */
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		try {
			if (!UserDao.get().existsUser(login)) {
				request.setAttribute("message", "invalid login");
				request.getRequestDispatcher("/pages/password.jsp").forward(request, response);
			} else {
				if (!Validator.isValidEmail(email)) {
					request.setAttribute("message", "invalid email");
					request.getRequestDispatcher("/pages/password.jsp").forward(request, response);
				} else {
					String password = PasswordService.createPassword();
					MailService.generateAndSendEmail(email, "New password (Coffee Machine)",
							"Your new password is " + password);
					UserDB user = UserDao.get().getByFieldName("login", login).get(0);

					UserDao.get().updatePassword(login,
							Security.get_SHA_1_SecurePassword(password, login.getBytes(Charset.forName("UTF-8"))));
					request.setAttribute("message", "new password is sent");
				}
			}
		} catch (MessagingException e) {
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
		}

		request.getRequestDispatcher("/pages/password.jsp").forward(request, response);
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
