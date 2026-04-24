package cl.utfsm.sansalibros.repositories;

import cl.utfsm.sansalibros.entities.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LibroRepository extends MongoRepository<Libro, String> {

    // Búsqueda exacta por autor
    List<Libro> findByAutor(String autor);

    //Búsqueda parcial (search) en Título o Autor
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
}