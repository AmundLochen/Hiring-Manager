

import java.io.Serializable;
import java.util.Date;
//import javax.swing.JFileChooser;

//Starter klassen for Arbeidssøkere.
public class arbeidssoker implements Serializable
{
	private int sokerID;
	private Date fødselsdato;
	private String utdKode; 
	private String navn;
	private String adresse;
	private String erfaring; 
	private String referanser;
	private String CV;
	//CV-link
	
	//Konstruktør for å registrere en arbeidssøker, får sendt med all informasjon som trengs, inkludert CV fra hovedvinduet.
	public arbeidssoker (int soker, Date fodselsdato, String utdanning, String n, String bosted, String CurriculumV)
	{
		sokerID = soker;
		fødselsdato = fodselsdato;
		utdKode = utdanning;
		navn = n;
		adresse = bosted;
		CV = CurriculumV;
	}

	//Metode for å sette sokerID datafeltet fra en annen klasse.
	public void setSokerID (int soker)
	{
		sokerID = soker;
	}
	
	//Metode for å hente ut sokerID.
	public int getSokerID()
	{
		return sokerID;
	}
	
	//Metode for å hente ut CV.
	public String getCV()
	{
		return CV;
	}
	
	//Metode for å sette CV datafeltet fra en annen klasse.
	public String setCV(String Curri)
	{
		CV = Curri;
		return CV;
	}
	
	//Metode for å sette fødselsdato fra en annnen klasse.
	public void setFodselsdato (Date d )
	{
		fødselsdato = d;
	}
	
	//Metode for å hente fødselsdato fra en annen klasse.
	public Date getFodselsdato()
	{
		return fødselsdato;
	}
	
	//Metode for å hente all info om søkeren.
	public String getInfo()
	{
		String s = "Navn: " + navn + "\n" + "\n";
		s += "Arbeidssøkers ID: " + sokerID + "\n" + "\n";
		s += "Arbeidssøkers navn: " + navn + "\n" + "\n";
		s += "Arbeidssøkers adresse: " + adresse + "\n" + "\n";
		s += "Fødselsdato: " + fødselsdato + "\n" + "\n";
		s += "Utdanningskode: " + utdKode + "\n" + "\n";
		s += "CV: " + "\n" + "\n" + getCV();
		return s;
	}
	
	//Metode for å hente søkerens utdanningskode.
	public String getUtdKode()
	{
		return utdKode;
	}
	
	//Metode for å hente søkerens navn.
	public String getNavn()
	{
		return navn;
	}
	
	//Metode for å hente søkerens adresse.
	public String getAdresse()
	{
		return adresse;
	}
	
	//Metode for å hente erfaringsfeltet.
	public String getErfaring()
	{
		return erfaring;
	}
	
	//Metode for å hente referansefeltet.
	public String getReferanser()
	{
		return referanser;
	}
}// End of class arbeidssoker.
