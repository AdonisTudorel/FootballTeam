package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.alexandru.footballteam.repository.PlayerRepository;
import ro.alexandru.footballteam.service.TeamService;

import java.security.Principal;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/")
    public String getAllTeams(Model model, Principal principal) {
        model.addAttribute("teams", teamService.getAllTeams());
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "index";
    }

    @GetMapping("/getTeam")
    public String getTeamById(Model model, Principal principal, @RequestParam("id") Long id) {
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        model.addAttribute("team", teamService.getTeamById(id));
        return "viewteam";
    }

}

