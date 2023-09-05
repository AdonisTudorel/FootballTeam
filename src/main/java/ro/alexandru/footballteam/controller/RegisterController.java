package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.alexandru.footballteam.dto.PlayerDto;
import ro.alexandru.footballteam.service.PlayerService;

@Controller
public class RegisterController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/register")
    public String showRegistration(Model model) {
        model.addAttribute("player", new PlayerDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("player") PlayerDto playerDto) {
        playerService.save(playerDto);
        return "redirect:/register?success";
    }

}