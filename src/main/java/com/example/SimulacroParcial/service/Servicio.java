package com.example.SimulacroParcial.service;

import com.example.SimulacroParcial.models.Comentario;
import com.example.SimulacroParcial.models.Publicacion;
import com.example.SimulacroParcial.models.Usuario;
import com.example.SimulacroParcial.repository.ComentarioRepository;
import com.example.SimulacroParcial.repository.PublicacionRepository;
import com.example.SimulacroParcial.repository.UsuarioRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class Servicio {

    @Async("executor")
    public CompletableFuture<List<Usuario>> metodo1(UsuarioRepository usuarios) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(usuarios.findAll());
    }

    @Async("executor")
    public CompletableFuture<List<Publicacion>> metodo2(PublicacionRepository publicaciones) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(publicaciones.findAll());
    }

    @Async("executor")
    public CompletableFuture<List<Comentario>> metodo3(ComentarioRepository comentarios) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(comentarios.findAll());
    }
}