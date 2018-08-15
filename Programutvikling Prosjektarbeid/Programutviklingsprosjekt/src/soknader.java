// Julie Colle s146311
//Amund Løchen s169999
import java.io.Serializable;
import java.util.Calendar;

//Starter klasse for søknader.
public class soknader implements Serializable
{
	private int soknadsID;
	private arbeidssoker Søker;
	private Jobb jobb;
	
	//Konstruktør for søknader. Får tilsendt søker, jobb og søknadsID for søknaden.
	public soknader (arbeidssoker soker, Jobb Jobben, int soknadID)
	{
		Søker = soker;
		jobb = Jobben;
		soknadsID = soknadID;
		}
	
	//Henter søknadsID og returnerer.
	public int getSoknadsID()
	{
		return soknadsID;
	}
	
	//Henter arbeidssøker
	public arbeidssoker getSoker()
	{
		return Søker;
	}
	
	//Henter jobben
	public Jobb getJobb()
	{
		return jobb;
	}
	
	//Skriver ut all relevant info om Søknaden.
	public String getInfo()
	{
		String s = "Søknadens ID: " + soknadsID + "\n" + "\n";
		s += "Søkers navn: " + Søker.getNavn() + "\n" + "\n";
		s += "Søkers ID: " + Søker.getSokerID() + "\n" + "\n";
		s += "Søkers adresse: " + Søker.getAdresse() + "\n" + "\n";
		s += "Søkers erfaring: " + Søker.getErfaring() + "\n" + "\n";
		s += "Navn på jobb som søkes på: " + jobb.getNavn() + "\n" + "\n";
		s += "ID for jobb som søkes på: " + jobb.getJobbID() + "\n" + "\n";
		s += "Søkers CV: \n" + Søker.getCV() + "\n" + "\n";
		return s;
	}
}//End of class soknader.


