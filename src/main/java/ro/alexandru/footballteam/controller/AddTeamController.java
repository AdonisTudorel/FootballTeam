package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.alexandru.footballteam.model.Team;
import ro.alexandru.footballteam.service.TeamService;

@Controller
public class AddTeamController {

    @Autowired
    private TeamService teamService;

    @ModelAttribute("team")
    public Team team() {
        return new Team();
    }

    @GetMapping("/addteam")
    public String showAddTeam(Model model) {
        model.addAttribute("team", team());
        return "addteam";
    }

    @PostMapping("/teams")
    public String addTeam(@ModelAttribute("team") Team team) {
        teamService.save(team);
        return "redirect:/";
    }

}