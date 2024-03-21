package com.devcrud.Biblioteca.service;

import com.devcrud.Biblioteca.model.LivroModel;
import com.devcrud.Biblioteca.repositories.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LivroService {
    @Autowired
     LivroRepository livroRepository;

    @Transactional
    public LivroModel salvar(LivroModel livroModel) {
        return  livroRepository.save(livroModel);
    }

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public Optional<LivroModel> findById(UUID id) {
        return  livroRepository.findById(id);
    }

    @Transactional
    public void delete(LivroModel livroModel) {
         livroRepository.delete(livroModel);
    }
}
