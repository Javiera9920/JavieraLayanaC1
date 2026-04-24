package cl.utfsm.sansalibros.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "libros")
public class Libro {

    @Id
    private String id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotBlank(message = "El ISBN es obligatorio")
    @Size(min = 13, max = 13, message = "El ISBN debe tener exactamente 13 caracteres")
    private String isbn;

    @Min(value = 11, message = "Las páginas deben ser mayores a 10")
    private int paginas;

    @NotBlank(message = "La categoría es obligatoria")
    private String categoria;

    // Constructores
    public Libro() {}

    public Libro(String titulo, String autor, String isbn, int paginas, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.categoria = categoria;
    }

    // Getters y Setters
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