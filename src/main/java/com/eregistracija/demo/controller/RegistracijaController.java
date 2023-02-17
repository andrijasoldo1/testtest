package com.eregistracija.demo.controller;

import com.eregistracija.demo.model.Registracija;
import com.eregistracija.demo.model.UserDetails;
import com.eregistracija.demo.repositories.RegistracijaRepository;
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
public class RegistracijaController {

    @Autowired
    RegistracijaRepository registracijaRepository;

    @GetMapping("registracije")
    public String listRegistracije(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userDetails", userDetails);
        List<Registracija> listRegistracije = registracijaRepository.findAll();
        model.addAttribute("listRegistracije", listRegistracije);
        model.addAttribute("activeLink", "registracije");
        return "registracije";
    }

    @GetMapping("registracije/add")
    public String showAddRegistracijaForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Registracije");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("registracija",  new Registracija());
        return "add_registracije";
    }

    @PostMapping("registracije/add")
    public String addRegistracija(@Valid Registracija registracija, BindingResult result, Model model) {
        boolean errors = result.hasErrors();
        if (errors) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Registracije");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("registracija", registracija);
            return "add_registracije";
        }
        registracijaRepository.save(registracija);
        return "redirect:/registracije";
    }

    @GetMapping("registracije/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Registracija registracija = registracijaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid registracija Id:" + id));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Registracije");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("registracija", registracija);
        return "edit_registracija";
    }

    @PostMapping("registracije/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Registracija registracija,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            registracija.setId(id);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Registracije");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("registracija", registracija);
            return "edit_registracija";
        }

        registracijaRepository.save(registracija);
        return "redirect:/registracije";
    }

    @GetMapping("/registracije/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Registracija registracija = registracijaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid registracije Id:" + id));
        registracijaRepository.delete(registracija);
        return "redirect:/registracije";
    }
}
