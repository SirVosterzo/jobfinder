package jobfinder.controller;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jobfinder.controller.dto.login.LoginRequest;
import jobfinder.controller.dto.register.RegisterRequest;
import jobfinder.exception.EncryptionException;
import jobfinder.exception.UsernameTakenException;
import jobfinder.model.User;
import jobfinder.service.UserService;
import jobfinder.util.Constants;
import jobfinder.util.CustomValidator;
import jobfinder.util.JspPath;

@Controller
public class IndexController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8893168491065503534L;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(HttpServletRequest request) {
		try {
			processIndex(request);
		} catch (AuthenticationException e) {
			return JspPath.LOGIN;
		}
		return "redirect:/" + JspPath.DASHBOARD;
	}

	@PostMapping("/login")
	public String login(LoginRequest loginRequest, HttpServletRequest request) {

		try {

			CustomValidator.validate(loginRequest);
			processLogin(loginRequest, request);

		} catch (ValidationException | AuthenticationException e) {
			request.setAttribute("exception", e);
			return JspPath.NOPE;
		}

		return "redirect:/" + JspPath.DASHBOARD;
	}

	@PostMapping("/register")
	public String register(RegisterRequest registerRequest, Model model) {
		try {

			CustomValidator.validate(registerRequest);
			processRegister(registerRequest);

		} catch (UsernameTakenException | EncryptionException e) {
			model.addAttribute("exception", e);
			return JspPath.REGISTER_KO;
		}

		return JspPath.REGISTER_OK;

	}

	@GetMapping("/register")
	public String register() {
		return JspPath.REGISTER;
	}

	@GetMapping("/profile")
	public String profile() {
		return JspPath.PROFILE;
	}

	private void processLogin(LoginRequest loginRequest, HttpServletRequest request) throws AuthenticationException {
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();

		// Authenticate the user
		User user = userService.authenticate(username, password);

		// Store user's safe info into the current session
		storeUser(request.getSession(), user);
	}

	private void processIndex(HttpServletRequest request) throws AuthenticationException {
		User user = (User) request.getSession().getAttribute(Constants.USER);
		if (user == null) {
			throw new AuthenticationException();
		}
	}

	private void processRegister(RegisterRequest registerRequest) throws UsernameTakenException, EncryptionException {
		String username = registerRequest.getUsername();
		String password = registerRequest.getPassword();
		userService.register(new User(username, password));
	}

	private void storeUser(HttpSession session, User user) {
		user.setPassword(null);
		user.setSalt(null);
		session.setAttribute(Constants.USER, user);
	}
}
