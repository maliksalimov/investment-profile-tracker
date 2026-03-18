package com.maliksalimov.my_spring_portfolio.controller;

import com.maliksalimov.my_spring_portfolio.model.Investment;
import com.maliksalimov.my_spring_portfolio.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InvestmentController {

    private final PortfolioService portfolioService;

    public InvestmentController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(name = "sort", required = false) String sort) {
        if(sort != null) {
            model.addAttribute("investments", portfolioService.getSortedInvestments(sort));
        } else {
            model.addAttribute("investments", portfolioService.getAllInvestments());
        }

        model.addAttribute("remaining", portfolioService.getRemainingFund());
        return "index";
    }

    @PostMapping("/add")
    public String addInvestment(@Valid @ModelAttribute Investment investment,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String message = fieldError != null
                ? fieldError.getDefaultMessage()
                    : (bindingResult.getAllErrors().isEmpty() ? "Invalid input" : bindingResult.getAllErrors().get(0).getDefaultMessage());
            redirectAttributes.addFlashAttribute("error", "Invalid input: " + message);
            return "redirect:/";
        }

        try {
            portfolioService.saveInvestment(investment);
            return "redirect:/?addSuccess=true";
        } catch (IllegalStateException | IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/";
        }
    }

    @PostMapping("/add-fund")
    public String addToFund(@RequestParam("amount") Double amount, RedirectAttributes redirectAttributes) {
        try {
            portfolioService.addToFund(amount);
            redirectAttributes.addFlashAttribute("success", "Fund increased successfully!");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateInvestment(@RequestParam("id") Long id,
                                   @RequestParam("newName") String newName,
                                   RedirectAttributes redirectAttributes) {
        try {
            portfolioService.updateInvestment(id, newName);
            redirectAttributes.addFlashAttribute("success", "Investment updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to update investment");
        }
        return "redirect:/";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") Long id, Model model) {
        try {
            Investment investment = portfolioService.getInvestmentById(id);
            model.addAttribute("investment", investment);
            return "details";
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @PostMapping("/delete")
    public String deleteInvestment(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            portfolioService.deleteInvestment(id);
            redirectAttributes.addFlashAttribute("success", "Investment deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete investment");
        }
        return "redirect:/";
    }
}