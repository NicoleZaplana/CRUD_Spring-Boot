package com.devcrud.Biblioteca.controller;

import com.devcrud.Biblioteca.model.LivroModel;
import com.devcrud.Biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class LivroController {
    final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService= livroService;
    }

    @PostMapping("/salvarLivro")
    public ResponseEntity<Object> salvarLivro(@Valid @RequestBody LivroModel livroModel) {
        livroModel.setId_livro(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.salvar(livroModel));
    }

    @GetMapping("listarLivros")
    public ResponseEntity<List<LivroModel>>getAllLivros(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findAll());
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<Object>getOneLivro(@PathVariable(value = "id")UUID id){
        Optional<LivroModel> livroModelOptional= livroService.findById(id);
        if(livroModelOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(livroModelOptional.get());

        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro não foi encontrado");
        }
    }

    @DeleteMapping("/deletarLivro/{id}")
    public ResponseEntity<Object>deletarLivro(@PathVariable(value = "id")UUID id){
        Optional<LivroModel> livroModelOptional= livroService.findById(id);
        if(livroModelOptional.isPresent()){
            livroService.delete(livroModelOptional.get());
            return  ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso!");

        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro não foi encontrado");
        }
    }

    @PutMapping("/atualizarLivro/{id}")
    public ResponseEntity<Object> updateLivro(@PathVariable(value = "id") UUID id, @RequestBody LivroModel livroModel) {
        Optional<LivroModel> existingLivroOptional = livroService.findById(id);

        if (existingLivroOptional.isPresent()) {
            livroModel.setId_livro(id);
            livroService.salvar(livroModel);
            return ResponseEntity.status(HttpStatus.OK).body(livroModel);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O livro não foi encontrado.");
        }
    }
}
