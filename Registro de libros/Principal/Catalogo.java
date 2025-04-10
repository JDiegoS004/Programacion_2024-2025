package Principal;

public class Catalogo {
	    private Libro[] libros = new Libro[100];
	    private int contador = 0;

	    public void agregarLibro(Libro libro) {
	        if (contador < 100) {
	            libros[contador++] = libro;
	        } else {
	            System.out.println("El catálogo está lleno.");
	        }
	    }

	    public Libro buscarPorISBN(String ISBN) {
	        for (int i = 0; i < contador; i++) {
	            if (libros[i].getISBN().equals(ISBN)) {
	                return libros[i];
	            }
	        }
	        return null;
	    }

	    public void actualizarTitulo(String ISBN, String nuevoTitulo) {
	        Libro libro = buscarPorISBN(ISBN);
	        if (libro != null) {
	            libro.setTitulo(nuevoTitulo);
	        } else {
	            System.out.println("No se encontró el libro con el ISBN proporcionado.");
	        }
	    }

	    public void eliminarLibro(String ISBN) {
	        for (int i = 0; i < contador; i++) {
	            if (libros[i].getISBN().equals(ISBN)) {
	                libros[i] = libros[--contador];
	                libros[contador] = null;
	                return;
	            }
	        }
	        System.out.println("No se encontró el libro con el ISBN proporcionado.");
	    }

	    public void mostrarLibrosConMaximoDosEjemplares() {
	        Libro[] copiaLibros = new Libro[contador];
	        System.arraycopy(libros, 0, copiaLibros, 0, contador);

	        for (int i = 0; i < contador - 1; i++) {
	            for (int j = i + 1; j < contador; j++) {
	                if (copiaLibros[i].getTitulo().compareTo(copiaLibros[j].getTitulo()) > 0) {
	                    Libro temp = copiaLibros[i];
	                    copiaLibros[i] = copiaLibros[j];
	                    copiaLibros[j] = temp;
	                }
	            }
	        }

	        for (int i = 0; i < contador; i++) {
	            System.out.println(copiaLibros[i].getTitulo());
	        }
	    }
	}
