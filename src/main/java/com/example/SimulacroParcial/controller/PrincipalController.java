package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.models.Comentario;
import com.example.SimulacroParcial.models.Publicacion;
import com.example.SimulacroParcial.models.Usuario;
import com.example.SimulacroParcial.repository.ComentarioRepository;
import com.example.SimulacroParcial.repository.PublicacionRepository;
import com.example.SimulacroParcial.repository.UsuarioRepository;
import com.example.SimulacroParcial.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/allContent")
public class PrincipalController {

    @Autowired
    private UsuarioRepository ur;
    @Autowired
    private PublicacionRepository pr;
    @Autowired
    private ComentarioRepository cr;
    @Autowired
    private Servicio s;

    @GetMapping("")
    public ResponseEntity<?> listar() {
        CompletableFuture<List<Usuario>> cf1 = s.metodo1(ur);
        CompletableFuture<List<Publicacion>> cf2 = s.metodo2(pr);
        CompletableFuture<List<Comentario>> cf3 = s.metodo3(cr);
        return ResponseEntity.status(HttpStatus.OK).body(cf1.join() + "-" + cf2.join() + "-" + cf3.join());
    }
}