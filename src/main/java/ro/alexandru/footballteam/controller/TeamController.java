package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.alexandru.footballteam.service.TeamService;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public String getAllTeams(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "index";
    }

}

