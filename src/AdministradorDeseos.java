import java.util.Scanner;

public class AdministradorDeseos {

	public static void main(String[] args) {
		menu();
	}

	public static void menu()
	{
		Genio.datosGeneralesGenio();
		System.out.println(Genio.DESEOS_TOTALES_POR_AMO);
		Genio g = new Genio("Matamba");
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
			System.out.println("6. Salir");

			Scanner s = new Scanner(System.in);
			int opcion = s.nextInt();
			s.nextLine();

			switch (opcion) {
			case 1:
				g.invocar();
				break;
			case 2:
				System.out.println("Escriba un deseo y presione enter para culminar.");
				String deseo = s.nextLine();
				g.cumplirDeseo(deseo);
				System.out.println("Los deseos Totales cumplidos por todos los genios son: " + Genio.contadorDeseosTotalesCumplidos);
				break;
			case 3:
				System.out.println("Escriba el nombre del nuevo amo");
				String nombreAmoNuevo = s.next();
				Amo nuevoAmo = new Amo(nombreAmoNuevo,"2/7/2019");
				g.cambiarAmo(nuevoAmo);
				break;
			case 4:
				g.liberar();
				break;
			case 5:
				g.encerrar();
				break;
			case 6:
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
