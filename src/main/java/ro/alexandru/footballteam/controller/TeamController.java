package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.alexandru.footballteam.model.Team;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        return "index";
    }

    @GetMapping("/teams/view/{id}")
    public String getTeamById(Model model, Principal principal, @PathVariable Long id) {
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        model.addAttribute("team", teamService.getTeamById(id));
        return "viewteam";
    }

    @ModelAttribute("team")
    public Team team(@ModelAttribute(name="team") Team team) {
        return team;
    }

    @GetMapping("/addteam")
    public String showAddTeam(Model model, Principal principal) {
        model.addAttribute("team", team(new Team()));
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "addteam";
    }

    @PostMapping("/teams")
    public String addTeam(@ModelAttribute("team") Team team) {
        teamService.save(team);
        return "redirect:/";
    }

    @GetMapping("/teams/edit/{id}")
    public String showEditTeam(Model model, Principal principal, @PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team", team);
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "addteam";
    }

    @PutMapping("/teams")
    public String editTeam(@ModelAttribute("team") Team team) {
        teamService.save(team);
        return "redirect:/";
    }

    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
        return "redirect:/";
    }

}

