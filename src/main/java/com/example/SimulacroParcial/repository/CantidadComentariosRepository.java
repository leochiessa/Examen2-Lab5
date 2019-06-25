package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.models.CantidadComentarios2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CantidadComentariosRepository extends JpaRepository<CantidadComentarios2, String> {

    @Query(value="select p.titulo as publicacion, u.nombre as usuario, count(c.id) as comentarios from usuario u join publicacion p on p.id_usuario = u.id join comentario c on c.id_publicacion = p.id group by publicacion, usuario", nativeQuery = true)
    List<CantidadComentarios2> getCantidadComentarios2();
}