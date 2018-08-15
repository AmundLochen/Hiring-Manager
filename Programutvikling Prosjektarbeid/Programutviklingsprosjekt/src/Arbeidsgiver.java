

import java.io.Serializable;
import java.util.ArrayList;

//Denne klassen registrerer en Arbeidsgiver/firma.
public class Arbeidsgiver implements Serializable
{
	private int agiverID;
	private String arbsted;
	private String sektor;
	private String bransje;
	private String navn;
	private String adresse;
	
//Konstrukt�r for � lagre informasjon om arbeidsgiver.
	public Arbeidsgiver (int giver, String sek,
			String bran, String n, String bosted)
	{
		agiverID = giver;
		sektor = sek;
		bransje = bran;
		navn = n;
		adresse = bosted;
	}
	
	//Get metode for � hente ut arbeidsgiver ID.
	public int getAgiverID()
	{
		return agiverID;
	}
	
	
	//Get metode for � hente ut sektor.
	public String getSektor()
	{
		return sektor;
	}
	
	//Get metode for � hente ut bransje.
	public String getBransje()
	{
		return bransje;
	}
	
	//Metode for � hente all info om arbeidsgiver.
	public String getInfo()
	{
		String s = "Navn: " + navn + "\n" + "\n";
		s += "Arbeidsgivers ID: " + agiverID + "\n" + "\n";
		s += "Arbeidsgivers navn: " + navn + "\n" + "\n";
		s += "Arbeidsgivers adresse: " + adresse + "\n" + "\n";
		s += "Bransje: " + bransje + "\n" + "\n";
		s += "Sektor: " + sektor + "\n" + "\n";
		return s;
	}
	
	//Metode for � hente navn p� arbeidsgiver.
	public String getNavn()
	{
		return navn;
	}
	
	//Metode for � hente adresse p� arbeidsgiver.
	public String getAdresse()
	{
		return adresse;
	}
	
}//End of class Arbeidsgiver.
