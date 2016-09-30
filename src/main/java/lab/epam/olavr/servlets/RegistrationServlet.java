package lab.epam.olavr.servlets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import lab.epam.olavr.dao.AccountDB;
import lab.epam.olavr.dao.AccountDao;
import lab.epam.olavr.dao.UserDB;
import lab.epam.olavr.dao.UserDao;
import lab.epam.olavr.exception.GeneralCustomException;
import lab.epam.olavr.service.MailService;
import lab.epam.olavr.service.Security;
import lab.epam.olavr.service.Validator;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(RegistrationServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get user entered info
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String verifyPassword = request.getParameter("verification");
		// if at least one of the fields is empty, render same page again

		if (name == null || surname == null || email == null || login == null || password == null
				|| verifyPassword == null || name.isEmpty() || surname.isEmpty() || email.isEmpty() | login.isEmpty()
				|| password.isEmpty() || verifyPassword.isEmpty()) {
			request.setAttribute("errormsg", "Please fill all fields");
			request.setAttribute("name", name);
			request.setAttribute("surname", surname);
			request.setAttribute("email", email);
			request.setAttribute("login", login);
			request.getRequestDispatcher("/pages/registration.jsp").forward(request, response);
		}

		// Validate all entered data
		boolean validMail = true;
		boolean validPassword = true;
		boolean newUser = true;
		try {
			validMail = Validator.isValidEmail(email);
			validPassword = Validator.isValidPassword(password, verifyPassword);
			newUser = !UserDao.get().existsUser(login);

			// if everything is all right, register new user
			if (validMail && validPassword && newUser) {
				Long accId = AccountDao.get().getMaxId() + 1;
				AccountDao.get().insert(new AccountDB(accId, 0.0, login));
				UserDao.get()
						.insert(new UserDB(login,
								Security.get_SHA_1_SecurePassword(password, login.getBytes(Charset.forName("UTF-8"))),
								name, surname, email, 1L));

				HttpSession session = request.getSession(true);
				session.setAttribute("login", login);
				session.setAttribute("role", "user");
				session.setAttribute("logout", "Log out");
				request.setAttribute("welcomeMessage", "Hello " + login);
				MailService.generateAndSendEmail(email, "Greetings from Coffee Machine..",
						"You were registered at Coffee Machine ");
				// request.getRequestDispatcher("/pages/index.jsp").forward(request,
				// response);
			}
		} catch (GeneralCustomException | MessagingException e) {
			request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
		}
		// if something is wrong, render the same page with appropriate message
		if (!validMail)
			request.setAttribute("errormsg", "incorrect email");
		if (!validPassword)
			request.setAttribute("errormsg", "password error");
		if (!newUser)
			request.setAttribute("errormsg", "Such user already exists");
	
		request.setAttribute("name", name);
		request.setAttribute("surname", surname);
		request.setAttribute("email", email);
		request.setAttribute("login", login);
		request.getRequestDispatcher("/pages/registration.jsp").forward(request, response);
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
