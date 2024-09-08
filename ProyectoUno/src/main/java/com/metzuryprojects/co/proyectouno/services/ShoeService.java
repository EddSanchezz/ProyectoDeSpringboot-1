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
            //throw new IllegalArgumentException("Shoe with ID " + id + " doesn't exist.");
        }
    }
}
