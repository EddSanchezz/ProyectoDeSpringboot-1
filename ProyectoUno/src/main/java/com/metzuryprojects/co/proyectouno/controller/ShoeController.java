package com.metzuryprojects.co.proyectouno.controller;

import com.metzuryprojects.co.proyectouno.model.Shoe;
import com.metzuryprojects.co.proyectouno.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Controller for html, RestController for info, xml and json files
@Controller
public class ShoeController {

    @Autowired
    private ShoeRepository shoeRepository;

    @GetMapping("/add-shoe")
    public String addShoe(Model model) {
        return "add-shoe";
    }

    @GetMapping("/list-shoe")
    public String listShoes(Model model) {
        List<Shoe> shoes = shoeRepository.findAll();
        model.addAttribute("shoes", shoes);
        return "list-shoe";
    }

    @PostMapping("/save-shoe")
    public String saveShoe(@RequestParam String name, @RequestParam Double price, @RequestParam Integer size, Model model) {
        Shoe shoe = new Shoe();
        shoe.setName(name);
        shoe.setPrice(price);
        shoe.setSize(size);
        shoeRepository.save(shoe);

        model.addAttribute("message", "Shoe added successfully!");

        return "add-shoe";
    }




}
