
public class Amo {

	private String nombre;
	private String fechaPosesionLampara;
	private String mayorDeseo;
	private String[] deseosRedimidos = new String[3];
	private int numeroDeseosDisponibles = 3;

	public Amo(String nombre, String fechaPosesionLampara)
	{
		this.nombre = nombre;
		this.fechaPosesionLampara = fechaPosesionLampara;
	}

	public String getNombre()
	{
		return this.nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getFechaPosesionLampara()
	{
		return this.fechaPosesionLampara;
	}

	public String getMayorDeseo()
	{
		return this.mayorDeseo;
	}

	public void setMayorDeseo(String deseo)
	{
		mayorDeseo = deseo;
	}

	public String[] getDeseosRedimidos()
	{
		return this.deseosRedimidos;
	}

	public void setDeseosRedimidos(String[] deseosRedimidos) 
	{
		if(deseosRedimidos.length <= numeroDeseosDisponibles)
		{
			this.deseosRedimidos = deseosRedimidos;
			this.numeroDeseosDisponibles = this.numeroDeseosDisponibles - deseosRedimidos.length;
		}else {
			System.err.println("Tramposo, no puedes pedir mas de " + numeroDeseosDisponibles + " deseos.");
		}
		
	}

	public boolean redimirDeseo(String deseoRedimible)
	{
		if(numeroDeseosDisponibles>0)
		{
			int indice = Math.abs(numeroDeseosDisponibles - 3);
			this.deseosRedimidos[indice] = deseoRedimible;
			numeroDeseosDisponibles--;
			System.out.println("Deseo redimido! Le quedan " + this.numeroDeseosDisponibles + "deseos.");
			return true;
		}else {
			System.out.println("No te quedan deseos.");
			return false;
		}
	}
	
	public int getNumeroDeseosDisponibles()
	{
		return this.numeroDeseosDisponibles;
	}
	
	@Override
	public String toString()
	{
		return "Amo " +  this.nombre + " tienes aun " + numeroDeseosDisponibles + " deseos.";
	}
	
}
