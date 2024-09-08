package com.metzuryprojects.co.proyectouno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryController {

    @GetMapping("/inventory-options")
    public String menuInventory() {
        return "inventory-options";
    }


}
