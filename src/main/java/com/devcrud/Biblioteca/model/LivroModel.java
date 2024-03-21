package com.devcrud.Biblioteca.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Livros")
public class LivroModel implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_livro;
    private String titulo_livro;
    private String autor;
    private String editora;
    private String descricao;
    private String genero;

    public UUID getId_livro() {
        return id_livro;
    }

    public void setId_livro(UUID id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo_livro() {
        return titulo_livro;
    }

    public void setTitulo_livro(String titulo_livro) {
        this.titulo_livro = titulo_livro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
