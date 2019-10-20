package jobfinder.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.ValidationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jobfinder.controller.dto.login.LoginRequest;
import jobfinder.controller.dto.register.RegisterRequest;
import jobfinder.exception.AuthenticationException;
import jobfinder.exception.EncryptionException;
import jobfinder.exception.UsernameTakenException;
import jobfinder.model.User;
import jobfinder.service.UserService;
import jobfinder.util.Constants;
import jobfinder.util.JspPath;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = -8893168491065503534L;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/")
	public String index(HttpServletRequest request) {
		try {
			checkUserSession(request);
		} catch (AuthenticationException e) {
			log.info("[ROUTE] Navigating to login.");
			return JspPath.LOGIN;
		}
		return "redirect:/" + JspPath.DASHBOARD;
	}

	@PostMapping("/login")
	public String login(@Valid LoginRequest loginRequest, HttpServletRequest request) {

		try {

			processLogin(loginRequest, request);

		} catch (ValidationException | AuthenticationException e) {
			log.error("Error: {}", e.getMessage());
			request.setAttribute("exception", e);
			return JspPath.NOPE;
		}

		return "redirect:/" + JspPath.DASHBOARD;
	}

	@PostMapping("/register")
	public String register(@Valid RegisterRequest registerRequest, Model model) {
		try {

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

	private void processLogin(LoginRequest loginRequest, HttpServletRequest request) throws AuthenticationException {
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();

		// Authenticate the user
		User user = userService.authenticate(username, password);

		// Store user's safe info into the current session
		storeUser(request.getSession(), user);
	}

	private void checkUserSession(HttpServletRequest request) throws AuthenticationException {
		User user = (User) request.getSession().getAttribute(Constants.USER);
		if (user == null) {
			throw new AuthenticationException();
		}
	}

	private void processRegister(RegisterRequest registerRequest) throws UsernameTakenException, EncryptionException {
		User user = modelMapper.map(registerRequest, User.class);
		userService.register(user);
	}

	private void storeUser(HttpSession session, User user) {
		user.setPassword(null);
		user.setSalt(null);
		session.setAttribute(Constants.USER, user);
	}
}
