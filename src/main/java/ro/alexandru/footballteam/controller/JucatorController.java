package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.alexandru.footballteam.model.Jucator;
import ro.alexandru.footballteam.repository.PlayerRepository;
import ro.alexandru.footballteam.service.JucatorService;
import ro.alexandru.footballteam.service.TeamService;

import java.security.Principal;

@Controller
public class JucatorController {
    @Autowired
    private JucatorService jucatorService;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamService teamService;

    @ModelAttribute("jucator")
    public Jucator jucator(@ModelAttribute(name="jucator") Jucator jucator) {
        return jucator;
    }

    @GetMapping("/addjucator")
    @Secured("ROLE_ADMIN")
    public String showAddJucator(Model model, Principal principal) {
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        model.addAttribute("teams", teamService.getAllTeams());
        model.addAttribute("jucator", jucator(new Jucator()));
        return "addjucator";
    }

    @PostMapping("/jucatori")
    @Secured("ROLE_ADMIN")
    public String addJucator(@ModelAttribute("jucator") Jucator jucator) {
        jucatorService.save(jucator);
        return "redirect:/";
    }
}
