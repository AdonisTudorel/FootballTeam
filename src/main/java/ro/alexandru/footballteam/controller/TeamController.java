package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.alexandru.footballteam.model.Stadium;
import ro.alexandru.footballteam.model.Team;
import ro.alexandru.footballteam.repository.PlayerRepository;
import ro.alexandru.footballteam.service.JucatorService;
import ro.alexandru.footballteam.service.StadiumService;
import ro.alexandru.footballteam.service.TeamService;

import java.security.Principal;
import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private StadiumService stadiumService;
    @Autowired
    private JucatorService jucatorService;

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
        model.addAttribute("nrJucatori", jucatorService.countByTeamId(id));
        model.addAttribute("jucatori", jucatorService.getAllJucatoriByTeamId(id));
        return "viewteam";
    }

    @ModelAttribute("team")
    public Team team(@ModelAttribute(name="team") Team team) {
        return team;
    }


    @GetMapping("/addteam")
    @Secured("ROLE_ADMIN")
    public String showAddTeam(Model model, Principal principal) {
        model.addAttribute("team", team(new Team()));
        model.addAttribute("stadiums", stadiumService.getAll());
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "addteam";
    }

    @PostMapping("/teams")
    @Secured("ROLE_ADMIN")
    public String addTeam(@ModelAttribute("team") Team team, @RequestParam("stadium") Long stadiumId) {
        Stadium dbStadium = stadiumService.getById(stadiumId);
        team.setStadium(dbStadium);
        teamService.save(team);
        return "redirect:/";
    }

    @GetMapping("/teams/edit/{id}")
    @Secured("ROLE_ADMIN")
    public String showEditTeam(Model model, Principal principal, @PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        model.addAttribute("team", team);
        model.addAttribute("stadiums", stadiumService.getAll());
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "addteam";
    }

    @PutMapping("/teams")
    @Secured("ROLE_ADMIN")
    public String editTeam(@ModelAttribute("team") Team team) {
        teamService.save(team);
        return "redirect:/";
    }

    @DeleteMapping("/teams/{id}")
    @Secured("ROLE_ADMIN")
    public String deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/teams/search")
    public String search(@RequestParam("query") String query, Model model, Principal principal) {
        List<Team> teams = teamService.search(query);
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        model.addAttribute("teams", teams);
        return "index";
    }

}

