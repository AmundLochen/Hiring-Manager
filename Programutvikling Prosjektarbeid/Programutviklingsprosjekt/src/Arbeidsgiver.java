

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
	
//Konstruktør for å lagre informasjon om arbeidsgiver.
	public Arbeidsgiver (int giver, String sek,
			String bran, String n, String bosted)
	{
		agiverID = giver;
		sektor = sek;
		bransje = bran;
		navn = n;
		adresse = bosted;
	}
	
	//Get metode for å hente ut arbeidsgiver ID.
	public int getAgiverID()
	{
		return agiverID;
	}
	
	
	//Get metode for å hente ut sektor.
	public String getSektor()
	{
		return sektor;
	}
	
	//Get metode for å hente ut bransje.
	public String getBransje()
	{
		return bransje;
	}
	
	//Metode for å hente all info om arbeidsgiver.
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
	
	//Metode for å hente navn på arbeidsgiver.
	public String getNavn()
	{
		return navn;
	}
	
	//Metode for å hente adresse på arbeidsgiver.
	public String getAdresse()
	{
		return adresse;
	}
	
}//End of class Arbeidsgiver.
