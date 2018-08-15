import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.Serializable;



//Klasse for � registrere ansettelser. Dvs hvor mange s�knader som har blitt godtatt hvor s�kerne har f�tt jobben.
public class Ansettelse implements Serializable
{
	private soknader soknad;
	private Jobb jobb;
	private String Date;

	//Datafeltene lagrer s�knaden som blir innvilget, jobben som man s�kte p� og dato for ansettelsen.
	public Ansettelse (soknader sID, Jobb ID, String Dato)
	{
		soknad = sID;
		jobb = ID;
		Date = Dato;
	}
    
	//Metoden returnerer s�knaden som ble innvilget.
	public soknader getSoknad()
	{
		return soknad;
	}
	
	//Metoden returnerer jobben som ble s�kt p�.
	public Jobb getJobb()
	{
		return jobb;
	}
	
	//Metoden returnerer datoen for s�ket.
	public String getDate()
	{
		return Date;
	}
}// End of class Ansettelse.
