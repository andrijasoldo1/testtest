package com.eregistracija.demo.controller;

import com.eregistracija.demo.model.Vozac;
import com.eregistracija.demo.model.UserDetails;
import com.eregistracija.demo.repositories.VozacRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VozacController {

    @Autowired
    VozacRepository vozacRepository;

    @GetMapping("vozaci")
    public String listVozaci(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userDetails", userDetails);
        List<Vozac> listVozaci = vozacRepository.findAll();
        model.addAttribute("listVozaci", listVozaci);
        model.addAttribute("activeLink", "Vozaci");
        return "vozaci";
    }

    @GetMapping("vozaci/add")
    public String showAddVozacForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Vozaci");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("vozac", new Vozac());
        return "add_vozaci";
    }

    @PostMapping("vozaci/add")
    public String addVozac(@Valid Vozac vozac, BindingResult result, Model model) {
        boolean errors = result.hasErrors();
        if (errors) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Vozaci");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("vozac", vozac);
            return "add_vozaci";
        }
        vozacRepository.save(vozac);
        return "redirect:/vozaci";
    }

    @GetMapping("vozaci/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Vozac vozac = vozacRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vozac Id:" + id));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Vozaci");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("vozac", vozac);
        return "edit_vozac";
    }

    @PostMapping("vozaci/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Vozac vozac,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            vozac.setId(id);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Vozaci");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("vozac", vozac);
            return "edit_vozac";
        }

        vozacRepository.save(vozac);
        return "redirect:/vozaci";
    }

    @GetMapping("/vozaci/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Vozac vozac = vozacRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vozac Id:" + id));
        vozacRepository.delete(vozac);
        return "redirect:/vozaci";
    }
}
