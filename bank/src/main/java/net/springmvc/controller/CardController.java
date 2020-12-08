package net.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.springmvc.entity.Card;
import net.springmvc.service.CardService;


@Controller
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping("/existingCard")
    public String listCards(Model theModel) {
        List < Card > theCards = cardService.getCards();
        theModel.addAttribute("cards", theCards);
        return "display";
        }
	
	@GetMapping("/apply")
	public String application(Model theModel) {
		
		return "applyCard";
	}
	
	@PostMapping("/saveNewCard")
	public String saveCard(@ModelAttribute("card") Card theCard,
			Model model) {
		 cardService.saveCard(theCard);
		
		return "cardCreationSuccess";
		
	}
}
