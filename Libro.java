package Principal;

public class Libro
{
	    private String titulo;
	    private String autor;
	    private String ISBN;
	    private String editorial;
	    private String fechaPublicacion;
	    private int paginas;

	    public Libro(String titulo, String autor, String ISBN, String editorial, String fechaPublicacion, int paginas) {
	        this.titulo = titulo;
	        this.autor = autor;
	        this.ISBN = ISBN;
	        this.editorial = editorial;
	        this.fechaPublicacion = fechaPublicacion;
	        this.paginas = paginas;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public String getISBN() {
	        return ISBN;
	    }
}
