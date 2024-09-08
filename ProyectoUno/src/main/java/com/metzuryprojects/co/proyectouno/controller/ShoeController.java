package com.metzuryprojects.co.proyectouno.controller;

import com.metzuryprojects.co.proyectouno.model.Shoe;
import com.metzuryprojects.co.proyectouno.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.metzuryprojects.co.proyectouno.services.*;
import java.util.List;

//Controller for html
@Controller
public class ShoeController {

    @Autowired
    private ShoeRepository shoeRepository;
    @Autowired
    private ShoeService shoeService;

    //Redirect methods
    @GetMapping("/admin-options")
    public String adminOptions(Model model) {
        return "admin-options";
    }

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


    //CRUD shoe:

    //add shoe
    @PostMapping("/save-shoe")
    public String saveShoe(@RequestParam String name, @RequestParam Double price, @RequestParam Integer size, @RequestParam String color, @RequestParam int quantity ,Model model) {
        Shoe shoe = new Shoe(name,price,size,color,quantity);
        shoeRepository.save(shoe);
        model.addAttribute("message", "Shoe added successfully!");

        return "add-shoe";
    }

    @DeleteMapping("/shoes/{id}")
    public ResponseEntity<String> deleteShoe(@PathVariable Long id) {
        try {
            shoeService.deleteShoeById(id);
            return ResponseEntity.ok("Shoe added successfully ");  // Return http 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());  // Return http 400 Bad Request
        }
    }



}
