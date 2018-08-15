

import java.io.Serializable;
import java.util.Date;
//import javax.swing.JFileChooser;

//Starter klassen for Arbeidss�kere.
public class arbeidssoker implements Serializable
{
	private int sokerID;
	private Date f�dselsdato;
	private String utdKode; 
	private String navn;
	private String adresse;
	private String erfaring; 
	private String referanser;
	private String CV;
	//CV-link
	
	//Konstrukt�r for � registrere en arbeidss�ker, f�r sendt med all informasjon som trengs, inkludert CV fra hovedvinduet.
	public arbeidssoker (int soker, Date fodselsdato, String utdanning, String n, String bosted, String CurriculumV)
	{
		sokerID = soker;
		f�dselsdato = fodselsdato;
		utdKode = utdanning;
		navn = n;
		adresse = bosted;
		CV = CurriculumV;
	}

	//Metode for � sette sokerID datafeltet fra en annen klasse.
	public void setSokerID (int soker)
	{
		sokerID = soker;
	}
	
	//Metode for � hente ut sokerID.
	public int getSokerID()
	{
		return sokerID;
	}
	
	//Metode for � hente ut CV.
	public String getCV()
	{
		return CV;
	}
	
	//Metode for � sette CV datafeltet fra en annen klasse.
	public String setCV(String Curri)
	{
		CV = Curri;
		return CV;
	}
	
	//Metode for � sette f�dselsdato fra en annnen klasse.
	public void setFodselsdato (Date d )
	{
		f�dselsdato = d;
	}
	
	//Metode for � hente f�dselsdato fra en annen klasse.
	public Date getFodselsdato()
	{
		return f�dselsdato;
	}
	
	//Metode for � hente all info om s�keren.
	public String getInfo()
	{
		String s = "Navn: " + navn + "\n" + "\n";
		s += "Arbeidss�kers ID: " + sokerID + "\n" + "\n";
		s += "Arbeidss�kers navn: " + navn + "\n" + "\n";
		s += "Arbeidss�kers adresse: " + adresse + "\n" + "\n";
		s += "F�dselsdato: " + f�dselsdato + "\n" + "\n";
		s += "Utdanningskode: " + utdKode + "\n" + "\n";
		s += "CV: " + "\n" + "\n" + getCV();
		return s;
	}
	
	//Metode for � hente s�kerens utdanningskode.
	public String getUtdKode()
	{
		return utdKode;
	}
	
	//Metode for � hente s�kerens navn.
	public String getNavn()
	{
		return navn;
	}
	
	//Metode for � hente s�kerens adresse.
	public String getAdresse()
	{
		return adresse;
	}
	
	//Metode for � hente erfaringsfeltet.
	public String getErfaring()
	{
		return erfaring;
	}
	
	//Metode for � hente referansefeltet.
	public String getReferanser()
	{
		return referanser;
	}
}// End of class arbeidssoker.
