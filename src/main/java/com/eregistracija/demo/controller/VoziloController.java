package com.eregistracija.demo.controller;

import com.eregistracija.demo.model.UserDetails;
import com.eregistracija.demo.model.Vozilo;
import com.eregistracija.demo.repositories.VoziloRepository;
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
public class VoziloController {

    @Autowired
    VoziloRepository voziloRepository;

    @GetMapping("vozila")
    public String listVozila(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userDetails", userDetails);
        List<Vozilo> listVozila = voziloRepository.findAll();
        model.addAttribute("listVozila", listVozila);
        model.addAttribute("activeLink", "Vozila");
        return "vozila";
    }

    @GetMapping("vozila/add")
    public String showAddVoziloForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Vozila");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("vozilo", new Vozilo());
        return "add_vozila";
    }

    @PostMapping("vozila/add")
    public String addVozilo(@Valid Vozilo vozilo, BindingResult result, Model model) {
        boolean errors = result.hasErrors();
        if (errors) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Vozila");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("vozilo", vozilo);
            return "add_vozila";
        }
        voziloRepository.save(vozilo);
        return "redirect:/vozila";
    }

    @GetMapping("vozila/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Vozilo vozilo = voziloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vozilo Id:" + id));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Vozila");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("vozilo", vozilo);
        return "edit_vozilo";
    }

    @PostMapping("vozila/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Vozilo vozilo,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            vozilo.setId(id);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Vozila");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("vozilo", vozilo);
            return "edit_vozilo";
        }

        voziloRepository.save(vozilo);
        return "redirect:/vozila";
    }

    @GetMapping("/vozila/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Vozilo vozilo = voziloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vozilo Id:" + id));
        voziloRepository.delete(vozilo);
        return "redirect:/vozila";
    }
}
