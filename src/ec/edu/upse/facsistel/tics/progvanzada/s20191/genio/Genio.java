package ec.edu.upse.facsistel.tics.progvanzada.s20191.genio;

public class Genio implements Dibujable {
	public static final int DESEOS_TOTALES_POR_AMO = 3;
	public static int contadorDeseosTotalesCumplidos = 0;
	private String nombre;
	private String fechaEncarcelamientoLampara;
	private int aniosEncierro;
	private Amo amoAnterior;
	private Amo amoActual;
	private boolean visible = false;
	
	public Genio(String nombre)
	{
		this.nombre = nombre;
	}
	
	public Genio(Genio otroGenio)
	{
		this.nombre = otroGenio.nombre;
		this.fechaEncarcelamientoLampara = otroGenio.fechaEncarcelamientoLampara;
		this.aniosEncierro = otroGenio.aniosEncierro;
		this.amoActual = otroGenio.amoActual;
		//this.amoActual = new Amo(otroGenio.getAmoActual());
		this.amoAnterior = otroGenio.amoAnterior;
		this.visible = otroGenio.visible;
	}
	
	public Genio(String nombre, String fechaEncarcelamientoLampara)
	{
		this.nombre = nombre;
		this.fechaEncarcelamientoLampara = fechaEncarcelamientoLampara;
	}
	
	public Genio(String nombre, Amo amoAnterior, Amo amoNuevo)
	{
		this.nombre = nombre;
		this.amoAnterior = amoAnterior;
		this.amoActual = amoNuevo;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getFechaEncarcelamiento()
	{
		return this.fechaEncarcelamientoLampara;
	}
	
	public void setFechaEncarcelamiento(String fechaEncarcelamiento)
	{
		this.fechaEncarcelamientoLampara = fechaEncarcelamiento;
	}
	
	public int getAniosEncierro()
	{
		return aniosEncierro;		
	}
	
	public void setAniosEncierro(int aniosEncierro)
	{
		this.aniosEncierro = aniosEncierro;
	}
	
	public Amo getAmoAnterior()
	{
		return this.amoAnterior;
	}
	
	public Amo getAmoActual()
	{
		return this.amoActual;
	}
	
	public void setAmoActual(Amo amoActual)
	{
		if(amoActual!=null)
		{
			this.amoAnterior = this.amoActual;
		}
		this.amoActual = amoActual;
	}
	
	public String toString()
	{
		return "El genio " + this.nombre + " tiene como amo " + this.amoActual;
	}
	
	public void invocar()
	{
		this.visible = true;
		System.out.println("Hola soy el genio " + this.nombre);
		
		if(amoActual!=null)
		{
			System.out.println("Listo para cumplir sus deseos.");
			System.out.println(amoActual.getNombre());
			System.out.println("Ud, amo, tiene " + amoActual.getNumeroDeseosDisponibles() + " deseos disponibles");
			System.out.println("Ya le he cumplido " + (DESEOS_TOTALES_POR_AMO - amoActual.getNumeroDeseosDisponibles()) + " deseo(s)." );
		}else {
			System.out.println("Soy un genio empoderado, no tengo dueno!");
		}
	}
	
	public void cambiarAmo(Amo amoNuevo)
	{
		setAmoActual(amoNuevo);
		System.out.println("Tu eres mi nuevo amo " + amoNuevo);
	}
	
	public void cumplirDeseo(String deseo)
	{
		if(amoActual!= null && amoActual.redimirDeseo(deseo))
		{
			System.out.println(amoActual.getNombre() + " tu deseo " + "' "+ deseo + "'" + " ... pufff. Se ha cumplido.");
			contadorDeseosTotalesCumplidos++;
		}else {
			System.out.println("Ex-amo, ya no te quedan deseos.");
			this.amoAnterior = amoActual;
			this.amoActual = null;
		}
		
	}
	
	public void encerrar()
	{
		System.out.println("Encierrooooooooooooo! Chao!!!");
		this.visible = false;
	}
	
	public void liberar()
	{
		if(amoActual!=null && amoActual.getNumeroDeseosDisponibles()>0)
		{
			System.out.println("Gracias " + amoActual.getNombre() + " por liberarme.");
			System.out.println("Ahora hare lo que yo quiera!");
			setAmoActual(null);
		}
	}
	
	public static void datosGeneralesGenio()
	{
		System.out.println("No es particular a ningun genio, "
				+ "pero todos los genios cumplen solo " + DESEOS_TOTALES_POR_AMO + " deseos." );
		System.out.println("Ademas todos los genios viven en una lampara!");
	}
	
	public void pasoParametros(Genio a, int x)
	{
		System.out.println("Antes");
		System.out.println(a);
		System.out.println(x);
		a.setNombre("Pepito");
		x = -5;
		System.out.println("Despues");
		System.out.println(a);
		System.out.println(x);
	}

	@Override
	public void dibujar() {
		System.out.println("                                          ..\n" + 
				"                                         dP/$.\n" + 
				"                                         $4$$%\n" + 
				"                                       .ee$$ee.\n" + 
				"                                    .eF3??????$C$r.        .d$$$$$$$$$$$e.\n" + 
				" .zeez$$$$$be..                    JP3F$5'$5K$?K?Je$.     d$$$FCLze.CC?$$$e\n" + 
				"     \"\"\"??$$$$$$$$ee..         .e$$$e$CC$???$$CC3e$$$$.  $$$/$$$$$$$$$.$$$$\n" + 
				"            `\"?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$b $$\"$$$$P?CCe$$$$$F\n" + 
				"                 \"?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$b$$J?bd$$$$$$$$$F\"\n" + 
				"                     \"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$d$$F\"\n" + 
				"                        \"?$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\"...\n" + 
				"                            \"?$$$$$$$$$$$$$$$$$$$$$$$$$F \"$$\"$$$$b\n" + 
				"                                \"?$$$$$$$$$$$$$$$$$$F\"     ?$$$$$F\n" + 
				"                                     \"\"????????C\"\n" + 
				"                                     e$$$$$$$$$$$$.\n" + 
				"                                   .$b CC$????$$F3eF\n" + 
				"                                 4$bC/%$bdd$b@$Pd??Jbbr\n" + 
				"                                   \"\"?$$$$eeee$$$$F?\"\n" + 
				"\n" + 
				"------------------------------------------------\n" + 
				"Thank you for visiting https://asciiart.website/\n" + 
				"This ASCII pic can be found at\n" + 
				"https://asciiart.website/index.php?art=movies/aladdin\n" + 
				"");
		
	}

	
	
}
