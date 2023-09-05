package ro.alexandru.footballteam.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.alexandru.footballteam.dto.PlayerDto;
import ro.alexandru.footballteam.repository.PlayerRepository;
import ro.alexandru.footballteam.service.PlayerService;

import java.security.Principal;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public String listUsers(Model model) {
        model.addAttribute("users", playerService.getAll());
        return "player-list";
    }

    @GetMapping("/player")
    public String showUserPage(Model model, Principal principal) {
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "player";
    }

    @GetMapping("/table")
    public String showTable(Model model, Principal principal) {
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "table";
    }

    @PostMapping("/player")
    public String addUser(@Valid PlayerDto player, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "player-add";
        }
        playerService.save(player);
        return "redirect:/players";
    }
}