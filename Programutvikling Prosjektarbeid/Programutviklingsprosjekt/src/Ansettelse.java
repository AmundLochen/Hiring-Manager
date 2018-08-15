import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.Serializable;



//Klasse for å registrere ansettelser. Dvs hvor mange søknader som har blitt godtatt hvor søkerne har fått jobben.
public class Ansettelse implements Serializable
{
	private soknader soknad;
	private Jobb jobb;
	private String Date;

	//Datafeltene lagrer søknaden som blir innvilget, jobben som man søkte på og dato for ansettelsen.
	public Ansettelse (soknader sID, Jobb ID, String Dato)
	{
		soknad = sID;
		jobb = ID;
		Date = Dato;
	}
    
	//Metoden returnerer søknaden som ble innvilget.
	public soknader getSoknad()
	{
		return soknad;
	}
	
	//Metoden returnerer jobben som ble søkt på.
	public Jobb getJobb()
	{
		return jobb;
	}
	
	//Metoden returnerer datoen for søket.
	public String getDate()
	{
		return Date;
	}
}// End of class Ansettelse.
