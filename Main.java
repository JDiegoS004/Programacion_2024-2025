##Contenido
Maquina expendedora que calcula a partir de números enteros cuanto deberá devolver


import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
	
	Scanner TN=new Scanner (System.in);
	
	int b20,b10,b5,m2,m1;
	int m050,m020,m010,m005,m002,m001;
	double adevolver, precio_producto;
	double abonoUsuario,cantidad;
	
	System.out.println("Cuanto vale el producto seleccionado");
	precio_producto=TN.nextInt();
	System.out.println("Cuanto dinero ha introducido (ejemplo:2, 5, 10, 60)");
	abonoUsuario= TN.nextDouble();
	adevolver= abonoUsuario-precio_producto;
	cantidad= Math.round(adevolver*100);
	
	b20= (int) (cantidad/2000);
	cantidad= cantidad%2000;
	
	b10= (int) (cantidad/1000);
	cantidad= cantidad%1000;
	
	b5= (int) (cantidad/500);
	cantidad= cantidad%500;
	
	m2= (int) (cantidad/200);
	cantidad= cantidad%200;
	
	m1= (int) (cantidad/100);
	cantidad= cantidad%100;
	
	m050= (int) (cantidad/50);
	cantidad= cantidad%50;
	
	m020= (int) (cantidad/20);
	cantidad= cantidad%20;
	
	m010= (int) (cantidad/10);
	cantidad= cantidad%10;
	
	m005= (int) (cantidad/5);
	cantidad= cantidad%5;
	
	m002= (int) (cantidad/2);
	cantidad= cantidad%2;
	
	m001= (int) (cantidad/1);
	cantidad= cantidad%1;
	
	adevolver= cantidad - precio_producto;
	
	System.out.println("El dinero a devolver sería: ");
	System.out.println("Billetes de 20 euros: " +b20);
	System.out.println("Billetes de 10 euros: " +b10);	
	System.out.println("Billetes de 5 euros: " +b5);	
	System.out.println("Monedas de 2 euros: " +m2);
	System.out.println("Monedas de 1 euro: " +m1);
	System.out.println("Monedas de 50 centimos: " +m050);
	System.out.println("Monedas de 20 centimos: " +m020);
	System.out.println("Monedas de 10 centimos: " +m010);
	System.out.println("Monedas de 5 centimos: " +m005);
	System.out.println("Monedas de 2 centimos: " +m002);
	System.out.println("Monedas de 1 centimo: " +m001);
	
	TN.close();	
		
	}
}
