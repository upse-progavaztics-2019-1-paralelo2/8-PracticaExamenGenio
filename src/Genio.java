
public class Genio {
	public static final int DESEOS_TOTALES_POR_AMO = 3;
	public static int contadorDeseosTotalesCumplidos = 0;
	private final String nombre;
	private String fechaEncarcelamientoLampara;
	private int aniosEncierro;
	private Amo amoAnterior;
	private Amo amoActual;
	private boolean visible = false;
	
	public Genio(String nombre)
	{
		this.nombre = nombre;
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
}
