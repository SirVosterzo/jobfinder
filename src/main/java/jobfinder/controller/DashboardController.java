package jobfinder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jobfinder.model.Job;
import jobfinder.service.JobService;
import jobfinder.service.UserService;
import jobfinder.util.Constants;
import jobfinder.util.JspPath;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DashboardController {

	@Autowired
	private JobService jobsService;
	@Autowired
	private UserService userService;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Job> jobsList = jobsService.getJobs(); // Retrieve all the currently available jobs
		model.addAttribute(Constants.JOBS, jobsList); // Send jobs to the view
		log.info("[ROUTE] Navigating to dashboard.");
		return JspPath.DASHBOARD;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		userService.logout(request);
		return "redirect:/";
	}

	@GetMapping("/profile")
	public String profile() {
		log.info("[ROUTE] Navigating to profile.");
		return JspPath.PROFILE;
	}

}
