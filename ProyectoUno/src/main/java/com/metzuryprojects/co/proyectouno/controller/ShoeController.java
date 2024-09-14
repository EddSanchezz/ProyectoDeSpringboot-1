package com.metzuryprojects.co.proyectouno.controller;

import com.metzuryprojects.co.proyectouno.model.Shoe;
import com.metzuryprojects.co.proyectouno.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.metzuryprojects.co.proyectouno.services.*;

import java.util.ArrayList;
import java.util.List;

//Controller for html
@Controller
public class ShoeController {

    @Autowired
    private ShoeRepository shoeRepository;
    @Autowired
    private ShoeService shoeService;

    //Redirect methods

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin-options")
    public String adminOptions(Model model) {
        return "admin-options";
    }

    @GetMapping("/add-shoe-panel")
    public String addShoe(Model model) {
        return "add-shoe-panel";
    }

    @GetMapping("/list-shoe-panel")
    public String listShoes(Model model) {
        List<Shoe> shoes = shoeRepository.findAll();
        model.addAttribute("shoes", shoes);
        return "list-shoe-panel";
    }

    @GetMapping("/delete-shoe-panel")
    public String deleteShoePanel(Model model) {
        return "delete-shoe-panel";
    }

    @GetMapping("/find-shoe-panel")
    public String findShoePanel(Model model) {
        model.addAttribute("formSubmitted", false);
        return "find-shoe-panel";
    }

    @GetMapping("/modify-shoe-panel")
    public String modifyShoePanel(Model model) {
        model.addAttribute("formSubmitted", false);
        return "modify-shoe-panel";
    }

    //CRUD shoe:

    //add shoe method
    @PostMapping("/save-shoe")
    public String saveShoe(@RequestParam String name, @RequestParam Double price, @RequestParam Integer size, @RequestParam String color, @RequestParam int quantity ,Model model) {
        Shoe shoe = new Shoe(name,price,size,color,quantity);
        shoeRepository.save(shoe);
        model.addAttribute("message", "Shoe added successfully!");

        return "add-shoe-panel";
    }

    //delete shoe method
    @PostMapping("/delete-shoe")
    public String deleteShoe(@RequestParam Long id, Model model) {
        try {
            shoeService.deleteShoeById(id);
            model.addAttribute("message", "Shoe successfully deleted.");
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "delete-shoe-panel";
    }

    //fin shoe method
    @PostMapping("/find-shoe")
    public String findShoe(@RequestParam Long id, Model model) {
        Shoe shoe = shoeService.getShoeById(id);
        model.addAttribute("shoe", shoe);
        model.addAttribute("formSubmitted", true);
        return "find-shoe-panel";
    }

    //update a shoe
    @PutMapping("/modify-shoe")
    public String modifyShoe(@RequestParam Long id, @RequestParam String color, @RequestParam String name, @RequestParam Integer size, @RequestParam Double price, @RequestParam Integer quantity, Model model) {
        shoeService.ModifyShoe(id, name, price, size, color, quantity);
        return "modify-shoe-panel";
    }



}
