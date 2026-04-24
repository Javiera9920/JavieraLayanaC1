package cl.utfsm.sansalibros.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros") // Indica que esto es una colección en MongoDB [cite: 19, 39]
public class Libro {

    @Id
    private String id; // ID autogenerado por MongoDB

    private String titulo;   // Obligatorio [cite: 27]
    private String autor;    // Obligatorio [cite: 28]
    private String isbn;     // Obligatorio, largo 13 [cite: 29]
    private int paginas;     // Obligatorio, mayor que 10 [cite: 30]
    private String categoria; // Obligatorio [cite: 31]

    // Constructores
    public Libro() {}

    public Libro(String titulo, String autor, String isbn, int paginas, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.categoria = categoria;
    }

    // Getters y Setters (Necesarios para que Spring convierta de/a JSON)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getPaginas() { return paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
