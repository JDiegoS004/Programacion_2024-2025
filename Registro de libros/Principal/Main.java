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

