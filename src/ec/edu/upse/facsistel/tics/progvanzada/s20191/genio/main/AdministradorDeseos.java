package ec.edu.upse.facsistel.tics.progvanzada.s20191.genio.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

import ec.edu.upse.facsistel.tics.progvanzada.s20191.genio.Amo;
import ec.edu.upse.facsistel.tics.progvanzada.s20191.genio.Genio;
/**
 * Esta clase administra deseos y tiene una CLI.
 * @author ivansanchez
 *
 */
public class AdministradorDeseos {

	public static void main(String[] args) {
		//menu();
		//testMemoria();
		//nuevoTestMemoria();
		
		Genio r = new Genio("Pi");
		r.setAmoActual(new Amo("Freddy", "Ayer"));
		System.out.println(r.getAmoActual().getNombre());
		
		//String nombre = "Campomania";
		String nombre = new String("Campomania");
		nombre = "Campomania1";
		nombre = nombre + 2;
		
	}
	
	public static void nuevoTestMemoria()
	{
		Genio l = new Genio("l");
		Genio m = new Genio("m");
		Genio n;
		
		int i = 10;
		m.pasoParametros(l, i);
		System.out.println("Super Despues");
		System.out.println(l);
		System.out.println(i);
		n = new Genio("n");
	}
	
	public static void testMemoria()
	{
		Genio a = new Genio("A");
		Genio b = a;
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println();
		b.setNombre("Z");
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println();
		String nuevoNombre = "W";
		b.setNombre(nuevoNombre);
		System.out.println("Nuevo nombre: "+ nuevoNombre);
		Genio c = new Genio("C");
		//c.setAmoActual(amoActual);
		//b = new Genio(c);
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("C: " + c);
		System.out.println();
		b.setNombre("X");
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("C: " + c);
		System.out.println();
		
		Amo amo1 = new Amo("Luis", "hoy");
		Amo amo2 = new Amo("Freddy", "manana");
		c.setAmoActual(amo1);
		Genio d = new Genio(c);
		d.getAmoActual().setNombre("Oscar");
		//d.cambiarAmo(amo1);
		
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("C: " + c);
		System.out.println("D: " + d);
		System.out.println();
		
//		c.cambiarAmo(amo2);
//		c.getAmoActual().setDeseosDisponibles(10);
//		d.getAmoActual().setDeseosDisponibles(20);
//		
//		System.out.println("A: " + a);
//		System.out.println("B: " + b);
//		System.out.println("C: " + c);
//		System.out.println("deseos de amo de c = " + c.getAmoActual().getNumeroDeseosDisponibles());
//		System.out.println("D: " + d);
//		System.out.println("deseos de amo de d = " + d.getAmoActual().getNumeroDeseosDisponibles());
//		
//		System.out.println();
		
//		Genio b = new Genio("B");
//		b = new Genio(g);
//		b.setAmoActual(null);
	}

	public static void menu()
	{
		List<Amo> historicoAmos = new ArrayList<Amo>();
		List<String> listaDeseosGlobales = new LinkedList<String>();
		Set<Amo> setAmosUnico = new HashSet<Amo>();
		
		Genio.datosGeneralesGenio();
		System.out.println(Genio.DESEOS_TOTALES_POR_AMO);
		Genio g = new Genio("Matamba");
		Genio b = new Genio("a");
		b = new Genio(g);
		b.setAmoActual(null);
		Amo a = new Amo("Luis", "2/7/2019");
		g.cambiarAmo(a);
		
		Genio g2 = new Genio("Sheng-Long");
		Amo a2 = new Amo("Goku", "2/09/1933");
		g2.setAmoActual(a2);
		g2.cumplirDeseo("Revive a Krilin por 5 vez!");
		do {
			System.out.println("******Reglas*******");
			System.out.println("Solo 3 deseos se pueden cumplir por amo...");
			System.out.println("Pero no se puede:");
			System.out.println("-Forzar el amor.");
			System.out.println("-Revivir a los muertos.");
			System.out.println("-Pedir mas deseos.");

			System.out.println("Coooooomencemos");
			
			System.out.println("Elija una opcion");
			System.out.println("1. Invocar Genio.");
			System.out.println("2. Pedir un Deseo.");
			System.out.println("3. Cambiar de Amo.");
			System.out.println("4. Liberar Genio.");
			System.out.println("5. Encerrar Genio.");
			System.out.println("6. Ver todos los deseos redimidos.");
			System.out.println("0. Salir");

			Scanner s = new Scanner(System.in);
			int opcion = s.nextInt();
			s.nextLine();

			switch (opcion) {
			case 1:
				g.invocar();
				g.dibujar();
				break;
			case 2:
				System.out.println("Escriba un deseo y presione enter para culminar.");
				String deseo = s.nextLine();
				g.cumplirDeseo(deseo);
				System.out.println("Los deseos Totales cumplidos por todos los genios son: " + Genio.contadorDeseosTotalesCumplidos);
				listaDeseosGlobales.add(deseo);
				break;
			case 3:
				System.out.println("Escriba el nombre del nuevo amo");
				String nombreAmoNuevo = s.next();
				historicoAmos.add(g.getAmoActual());
				setAmosUnico.add(g.getAmoActual());
				System.out.println("El historial de amos anteriores fueron: " + historicoAmos);
				System.out.println("Los amos unicos son: " + setAmosUnico);
				Amo nuevoAmo = new Amo(nombreAmoNuevo,"2/7/2019");
				g.cambiarAmo(nuevoAmo);
				nuevoAmo.dibujar();
				
				break;
			case 4:
				g.liberar();
				break;
			case 5:
				g.encerrar();
				break;
			case 6: 
				System.out.println("Todos los deseos pedidos hasta ahora, independiente del amo son:");
				int i = 1;
				for(String deseito:listaDeseosGlobales)
				{
					
					System.out.println("El deseo " + i + " fue: " + deseito);
					i++;
				}
				break;
			case 0:
				s.close();
				System.exit(0);
				break;
			default:
				System.out.println("No sea pendejo, escoja una opcion valida!");
				System.out.println();
				//menu();
				break;
			}
			
		}while(true);
	}

}
