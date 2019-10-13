package jobfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jobfinder.model.Job;
import jobfinder.service.JobService;
import jobfinder.util.Constants;
import jobfinder.util.JspPath;

@Controller
public class DashboardController {

	@Autowired
	private JobService jobsService;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Job> jobsList = jobsService.getJobs(); // Retrieve all the currently available jobs
		model.addAttribute(Constants.JOBS, jobsList); // Send jobs to the view
		return JspPath.DASHBOARD;
	}

}
