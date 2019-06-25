package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.models.CantidadComentarios2;
import com.example.SimulacroParcial.models.Comentario;
import com.example.SimulacroParcial.models.Publicacion;
import com.example.SimulacroParcial.repository.CantidadComentarios;
import com.example.SimulacroParcial.repository.CantidadComentariosRepository;
import com.example.SimulacroParcial.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {

    @Autowired
    private PublicacionRepository pr;
    @Autowired
    private CantidadComentariosRepository ccr;

    @PostMapping("")
    public void agregar(@RequestBody final @NotNull Publicacion p) {
        pr.save(p);
    }

    @GetMapping("")
    public List<Publicacion> listarTodas() {
        return pr.findAll();
    }

    @PostMapping("/{id}/comentar")
    public void comentar(@PathVariable final @NotNull Integer id, @RequestBody @NotNull Comentario c) {
        Publicacion p = pr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Publicación " + id + " no encontrada."));
        p.getComentarios().add(c);
        c.setFecha();
        c.setPublicacion(p);
        pr.save(p);
    }

    @GetMapping("/cantidadComentarios")
    public List<CantidadComentarios> cantidadComentarios() {
        return pr.getCantidadComentarios();
    }

    @GetMapping("/cantidadComentarios2")
    public List<CantidadComentarios2> cantidadComentarios2() {
        return ccr.getCantidadComentarios2();
    }
}