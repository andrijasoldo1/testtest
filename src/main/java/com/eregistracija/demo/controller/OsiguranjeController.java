package com.eregistracija.demo.controller;

import com.eregistracija.demo.model.Osiguranje;
import com.eregistracija.demo.model.UserDetails;
import com.eregistracija.demo.repositories.OsiguranjeRepository;
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
public class OsiguranjeController {

    @Autowired
    OsiguranjeRepository osiguranjeRepository;

    @GetMapping("osiguranja")
    public String listOsiguranja(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("userDetails", userDetails);
        List<Osiguranje> listOsiguranja = osiguranjeRepository.findAll();
        model.addAttribute("listOsiguranja", listOsiguranja);
        model.addAttribute("activeLink", "osiguranja");
        return "osiguranja";
    }

    @GetMapping("osiguranja/add")
    public String showAddOsiguranjeForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Osiguranja");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("osiguranje", new Osiguranje());
        return "add_osiguranja";
    }

    @PostMapping("osiguranja/add")
    public String addOsiguranje(@Valid Osiguranje osiguranje, BindingResult result, Model model) {
        boolean errors = result.hasErrors();
        if (errors) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Osiguranja");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("osiguranje", osiguranje);
            return "add_osiguranja";
        }
        osiguranjeRepository.save(osiguranje);
        return "redirect:/osiguranja";
    }

    @GetMapping("osiguranja/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Osiguranje osiguranje = osiguranjeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid osiguranje Id:" + id));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("activeLink", "Osiguranja");
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("osiguranje", osiguranje);
        return "edit_osiguranje";
    }

    @PostMapping("osiguranja/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Osiguranje osiguranje,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            osiguranje.setId(id);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeLink", "Osiguraja");
            model.addAttribute("userDetails", userDetails);
            model.addAttribute("osiguranje", osiguranje);
            return "edit_osiguranje";
        }

        osiguranjeRepository.save(osiguranje);
        return "redirect:/osiguranja";
    }

    @GetMapping("/osiguranja/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Osiguranje osiguranje = osiguranjeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid osiguranje Id:" + id));
        osiguranjeRepository.delete(osiguranje);
        return "redirect:/osiguranja";
    }
}
