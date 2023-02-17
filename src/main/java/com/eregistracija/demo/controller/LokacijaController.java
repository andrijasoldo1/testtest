package com.eregistracija.demo.controller;

import com.eregistracija.demo.model.Lokacija;
import com.eregistracija.demo.model.UserDetails;
import com.eregistracija.demo.repositories.LokacijaRepository;
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
public class LokacijaController {

    @Autowired
    LokacijaRepository lokacijaRepository;

    @GetMapping("lokacije")
    public String listLokacije(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userDetails", userDetails);
        List<Lokacija> listLokacije = lokacijaRepository.findAll();
        model.addAttribute("listLokacije", listLokacije);
        model.addAttribute("activeLink", "Lokacije");
        return "lokacije";
    }

    @GetMapping("lokacije/add")
    public String showAddLokacijaForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Lokacije");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("lokacija", new Lokacija());
        return "add_lokacije";
    }

    @PostMapping("lokacije/add")
    public String addLokacija(@Valid Lokacija lokacija, BindingResult result, Model model) {
        boolean errors = result.hasErrors();
        if (errors) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Lokacije");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("lokacija", lokacija);
            return "add_lokacije";
        }
        lokacijaRepository.save(lokacija);
        return "redirect:/lokacije";
    }

    @GetMapping("lokacije/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Lokacija lokacija = lokacijaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lokacija Id:" + id));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Lokacije");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("lokacija", lokacija);
        return "edit_lokacija";
    }

    @PostMapping("lokacije/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Lokacija lokacija,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            lokacija.setId(id);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Lokacije");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("lokacija", lokacija);
            return "edit_lokacija";
        }

        lokacijaRepository.save(lokacija);
        return "redirect:/lokacije";
    }

    @GetMapping("/lokacije/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Lokacija lokacija = lokacijaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid lokacija Id:" + id));
        lokacijaRepository.delete(lokacija);
        return "redirect:/lokacije";
    }
}
