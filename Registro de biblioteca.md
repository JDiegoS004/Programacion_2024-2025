## Contenido
Proyecto de registro de libros en catalogo haciendo uso de Arrays.

# Clase Main
```java
package Principal;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Catalogo catalogo = new Catalogo();
			Scanner scanner = new Scanner(System.in);
		        int opcion;

		        do
		        {
		            System.out.println("\nMenú de opciones:");
		            System.out.println("1. Agregar libro");
		            System.out.println("2. Consultar libro por ISBN");
		            System.out.println("3. Modificar título del libro");
		            System.out.println("4. Eliminar libro");
		            System.out.println("5. Mostrar libros con máximo dos ejemplares");
		            System.out.println("6. Salir");
		            System.out.print("Ingrese una opción: ");
		            opcion = scanner.nextInt();
		            scanner.nextLine();  // Limpiar el buffer

		            switch (opcion)
		            {
		                case 1:
		                    System.out.print("Título: ");
		                    String titulo = scanner.nextLine();
		                    System.out.print("Autor: ");
		                    String autor = scanner.nextLine();
		                    System.out.print("ISBN: ");
		                    String ISBN = scanner.nextLine();
		                    System.out.print("Editorial: ");
		                    String editorial = scanner.nextLine();
		                    System.out.print("Fecha de publicación: ");
		                    String fechaPublicacion = scanner.nextLine();
		                    System.out.print("Número de páginas: ");
		                    int paginas = scanner.nextInt();
		                    scanner.nextLine();  // Limpiar el buffer
		                    Libro libro = new Libro(titulo, autor, ISBN, editorial, fechaPublicacion, paginas);
		                    catalogo.agregarLibro(libro);
		                    break;
		                case 2:
		                    System.out.print("ISBN: ");
		                    ISBN = scanner.nextLine();
		                    Libro libroBuscado = catalogo.buscarPorISBN(ISBN);
		                    if (libroBuscado != null) {
		                        System.out.println("Título: " + libroBuscado.getTitulo());
		                    } else {
		                        System.out.println("Libro no encontrado.");
		                    }
		                    break;
		                case 3:
		                    System.out.print("ISBN: ");
		                    ISBN = scanner.nextLine();
		                    System.out.print("Nuevo título: ");
		                    String nuevoTitulo = scanner.nextLine();
		                    catalogo.actualizarTitulo(ISBN, nuevoTitulo);
		                    break;
		                case 4:
		                    System.out.print("ISBN: ");
		                    ISBN = scanner.nextLine();
		                    catalogo.eliminarLibro(ISBN);
		                    break;
		                case 5:
		                    catalogo.mostrarLibrosConMaximoDosEjemplares();
		                    break;
		                case 6:
		                    System.out.println("Saliendo...");
		                    break;
		                default:
		                    System.out.println("Opción no válida.");
		                    break;
		            }
		        }while (opcion != 6);

		        scanner.close();
		    }
	}
```

# Clase Libro
```java
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
```
# Clase Catalogo
```java
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
```
