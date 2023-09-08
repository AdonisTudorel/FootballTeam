package ro.alexandru.footballteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.alexandru.footballteam.dto.StadiumDto;
import ro.alexandru.footballteam.model.Stadium;
import ro.alexandru.footballteam.repository.PlayerRepository;
import ro.alexandru.footballteam.service.StadiumService;

import java.security.Principal;

@Controller
public class StadiumController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private StadiumService stadiumService;

    @ModelAttribute("team")
    public Stadium stadium(@ModelAttribute(name="stadium") Stadium stadium) {
        return stadium;
    }
    @GetMapping("/addstadium")
    public String showAddStadium(Model model, Principal principal) {
        model.addAttribute("stadium", stadium(new Stadium()));
        model.addAttribute("myUser", playerRepository.findByUsername(principal.getName()));
        return "addstadium";
    }

    @PostMapping("/stadiums")
    public String addStadium(@ModelAttribute("stadium") Stadium stadium) {
        stadiumService.save(stadium);
        return "redirect:/";
    }
}
