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
            shoeRepository.deleteById(id); // Lógica para eliminar el zapato
        } else {
            throw new IllegalArgumentException("El zapato con el ID " + id + " no existe.");
        }
    }


}
