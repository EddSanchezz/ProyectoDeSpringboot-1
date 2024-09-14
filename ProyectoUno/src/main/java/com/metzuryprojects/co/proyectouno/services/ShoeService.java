package com.metzuryprojects.co.proyectouno.services;

import com.metzuryprojects.co.proyectouno.model.Shoe;
import com.metzuryprojects.co.proyectouno.repository.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shoeRepository;

    public List<Shoe> findAll() {
        return shoeRepository.findAll();
    }

    public void deleteShoeById(Long id) {
        if (shoeRepository.existsById(id)) {
            shoeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Shoe with ID " + id + " doesn't exist.");
        }
    }

    public Shoe getShoeById(Long id) {
        if(shoeRepository.existsById(id)) {
            return shoeRepository.findById(id).get();
        }else{
            return null;
        }
    }

    public void ModifyShoe(Long id, String name, Double price, Integer size, String color, Integer Quantity) {
        Shoe shoe = getShoeById(id);
        Shoe updatedShoe = new Shoe();
        updatedShoe.setId(id);

        if(name != null){updatedShoe.setName(name);}else{updatedShoe.setName(shoe.getName());}

        if(price != null){shoe.setPrice(price);}else{updatedShoe.setPrice(shoe.getPrice());}

        if(size != null){shoe.setSize(size);}else{updatedShoe.setSize(shoe.getSize());}

        if(color != null){shoe.setColor(color);}else{updatedShoe.setColor(shoe.getColor());}

        if(Quantity != null){shoe.setQuantity(Quantity);}else{updatedShoe.setQuantity(shoe.getQuantity());}

        shoeRepository.delete(shoe);
        shoeRepository.save(updatedShoe);
    }
}
