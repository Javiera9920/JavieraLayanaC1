package cl.utfsm.sansalibros.services;

import cl.utfsm.sansalibros.entities.Libro;
import cl.utfsm.sansalibros.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Listar todos o buscar por coincidencia parcial
    public List<Libro> obtenerLibros(String search) {
        if (search != null && !search.isEmpty()) {
            // Query Parameter llamado 'search' para busquedas parciales
            return libroRepository.findByTituloContainingIgnoreCaseOrAutorContainingIgnoreCase(search, search);
        }
        // Si no hay parámetro, devolvemos todo
        return libroRepository.findAll();
    }

    // Guardar un libro en MongoDB:
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Buscar por autor exacto:
    public List<Libro> obtenerPorAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }
}