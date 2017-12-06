package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TournamentService;

@Controller
@RequestMapping("tournament")
public class TournamentController {

    private TournamentService tournamentSevice;

    @GetMapping("/")
    public String showTournamentsPage(Model model)
    {
        model.addAttribute("tournaments", tournamentSevice.getAll());
        return "tournaments";
    }
}
