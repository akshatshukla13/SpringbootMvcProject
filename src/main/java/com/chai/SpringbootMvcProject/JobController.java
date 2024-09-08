package com.chai.SpringbootMvcProject;

import com.chai.SpringbootMvcProject.Model.JobPost;
import com.chai.SpringbootMvcProject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    public JobService service;

    @GetMapping({"/","home"})
    public String Home(){
        return "home";
    }

    @GetMapping("/addjob")
    public String addJob(){
        return "addjob";
    }

//    @RequestMapping(value = "handleForm",method = RequestMethod.POST)
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJobPost(jobPost);
        return "success";
    }

    @GetMapping("/viewalljobs")
    public String viewJobs(Model model) {

        List<JobPost> jobPosts = service.returnAllJobPosts();
        model.addAttribute("jobPosts", jobPosts);
        return "viewalljobs";
    }

}
