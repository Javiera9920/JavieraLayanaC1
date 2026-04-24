package cl.utfsm.sansalibros.controllers;

import cl.utfsm.sansalibros.entities.Libro;
import cl.utfsm.sansalibros.services.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // 1. GET /libros (Incluye búsqueda opcional por parámetro 'search')
    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getLibros(@RequestParam(required = false) String search) {
        List<Libro> libros = libroService.obtenerLibros(search);
        // Si la lista está vacía, devolvemos 204 No Content
        if (libros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // 2. POST /crearLibro
    @PostMapping("/crearLibro")
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody Libro libro) {
        try {
            Libro nuevoLibro = libroService.guardarLibro(libro);
            return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED); // 201 Created
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 3. GET /libros/:autor Búsqueda exacta por autor
    @GetMapping("/libros/{autor}")
    public ResponseEntity<List<Libro>> getLibrosByAutor(@PathVariable String autor) {
        List<Libro> libros = libroService.obtenerPorAutor(autor);
        // Si no hay libros del autor, error 404 Not Found
        if (libros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}