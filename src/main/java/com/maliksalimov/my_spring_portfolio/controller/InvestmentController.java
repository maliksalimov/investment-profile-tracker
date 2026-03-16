package com.maliksalimov.my_spring_portfolio.controller;

import com.maliksalimov.my_spring_portfolio.model.Investment;
import com.maliksalimov.my_spring_portfolio.service.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvestmentController {

    private final PortfolioService portfolioService;

    public InvestmentController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String sort) {
        if(sort != null) {
            model.addAttribute("investments", portfolioService.getSortedInvestments(sort));
        } else {
            model.addAttribute("investments", portfolioService.getAllInvestments());
        }

        model.addAttribute("remaining", portfolioService.getRemainingFund());
        return "index";
    }

    @PostMapping("/add")
    public String addInvestment(@ModelAttribute Investment investment) {
        portfolioService.saveInvestment(investment);
        return "redirect:/?addSuccess=true";
    }

    @PostMapping("/add-fund")
    public String addToFund(@RequestParam Double amount) {
        portfolioService.addToFund(amount);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateInvestment(@RequestParam Long id, @RequestParam String newName) {
        portfolioService.updateInvestment(id, newName);
        return "redirect:/";
    }

    @GetMapping("/details")
    public String details(@RequestParam Long id, Model model) {
        Investment investment = portfolioService.getInvestmentById(id);
        model.addAttribute("investment", investment);
        return "details";
    }

    @PostMapping("/delete")
    public String deleteInvestment(@RequestParam Long id) {
        portfolioService.deleteInvestment(id);
        return "redirect:/";
    }
}
