// Julie Colle s146311
//Amund L�chen s169999
import java.io.Serializable;
import java.util.Calendar;

//Starter klasse for s�knader.
public class soknader implements Serializable
{
	private int soknadsID;
	private arbeidssoker S�ker;
	private Jobb jobb;
	
	//Konstrukt�r for s�knader. F�r tilsendt s�ker, jobb og s�knadsID for s�knaden.
	public soknader (arbeidssoker soker, Jobb Jobben, int soknadID)
	{
		S�ker = soker;
		jobb = Jobben;
		soknadsID = soknadID;
		}
	
	//Henter s�knadsID og returnerer.
	public int getSoknadsID()
	{
		return soknadsID;
	}
	
	//Henter arbeidss�ker
	public arbeidssoker getSoker()
	{
		return S�ker;
	}
	
	//Henter jobben
	public Jobb getJobb()
	{
		return jobb;
	}
	
	//Skriver ut all relevant info om S�knaden.
	public String getInfo()
	{
		String s = "S�knadens ID: " + soknadsID + "\n" + "\n";
		s += "S�kers navn: " + S�ker.getNavn() + "\n" + "\n";
		s += "S�kers ID: " + S�ker.getSokerID() + "\n" + "\n";
		s += "S�kers adresse: " + S�ker.getAdresse() + "\n" + "\n";
		s += "S�kers erfaring: " + S�ker.getErfaring() + "\n" + "\n";
		s += "Navn p� jobb som s�kes p�: " + jobb.getNavn() + "\n" + "\n";
		s += "ID for jobb som s�kes p�: " + jobb.getJobbID() + "\n" + "\n";
		s += "S�kers CV: \n" + S�ker.getCV() + "\n" + "\n";
		return s;
	}
}//End of class soknader.


