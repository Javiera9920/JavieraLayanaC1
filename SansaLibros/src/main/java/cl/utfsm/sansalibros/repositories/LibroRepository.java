package cl.utfsm.sansalibros.repositories;

import cl.utfsm.sansalibros.entities.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends MongoRepository<Libro, String> {

    // /libros/:autor (coincidencia exacta)
    List<Libro> findByAutor(String autor);

    // búsqueda parcial en Título o Autor
    List<Libro> findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(String titulo, String autor);
}