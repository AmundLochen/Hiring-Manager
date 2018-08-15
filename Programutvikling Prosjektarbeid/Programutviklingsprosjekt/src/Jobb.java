import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//Programmert av Amund L�chen s169999

//Starter klassen for Jobb.
public class Jobb implements Serializable
{
	private String navn;
	private String sektor;
	private String arbeidssted;
	private String firma;
	private String kategori;
	private int fastellermidlertidig;
	private int heltidellerdeltid;
	private String stillingstype;
	private String kvalifikasjonskrav; 
	private String l�nnsbetingelser; 
	private String andrevilk�r; 
	private String kontaktinformasjon; 
	private String stillingsbeskrivelse;
	private int JobbID;
	//Eventuelt andre datafelt.
	
	//Konstrukt�r for Jobb som bruker informasjon tilsendt fra Jobbvindu.
	public Jobb(String navnet, String sektoren, String arbeidsstedet, String firmaet, String kategorien, int fastellermidlertidige, int heltidsellerdeltids, String stillingstypen, int ID, String kvalifikasjon, String l�nn, String kontakt, String stillingbeskrivelse, String vilk�r)
	{
		navn = navnet;
		sektor = sektoren;
		arbeidssted = arbeidsstedet;
		firma = firmaet;
		kategori = kategorien;
		fastellermidlertidig = fastellermidlertidige;
		heltidellerdeltid = heltidsellerdeltids;
		stillingstype = stillingstypen;
		JobbID = ID;
		kvalifikasjonskrav = kvalifikasjon;
		l�nnsbetingelser = l�nn;
		kontaktinformasjon = kontakt;
		stillingsbeskrivelse = stillingbeskrivelse;
		andrevilk�r = vilk�r;
	}
	
	//Metode for � hente navn p� jobben.
	public String getNavn()
	{
		return navn;
	}
	
	//Metode for � hente sektorfeltet til jobben.
	public String getSektor()
	{
		return sektor;
	}
	
	//Metode for � hente arbeidsstedsfeltet til jobben.
	public String getArbeidssted()
	{
		return arbeidssted;
	}
	
	//Metode for � hente Arbeidsgiver/firma feltet til jobben.
	public String getFirma()
	{
		return firma;
	}
	
	//Metode for � hente kategorien til jobben.
	public String getKategori()
	{
		return kategori;
	}
	
	//Metode for � hente et heltall 1 eller 2 avhengig av om jobben er fast eller midlertidig, bestemt av radiobuttons i jobbvinduet.
	public int getFastellermidlertidig()
	{
		return fastellermidlertidig;
	}
	
	//Metode for � hente et heltall 1 eller 2 avhengig av om jobben er heltidsstilling eller deltidsstilling, bestemt av radiobuttons i jobbvinduet.
	public int getHeltidellerdeltid()
	{
		return heltidellerdeltid;
	}
	
	//Metode for � hente stillingstypefeltet.
	public String getStillingstype()
	{
		return stillingstype;
	}
	
	//Metode for � hente kvalifikasjonskravfeltet.
	public String getKvalifikasjonskrav()
	{
		return kvalifikasjonskrav;
	}
	
	//Metode for � hente l�nnsbetingelsesfeltet.
	public String getL�nnsbetingelser()
	{
		return l�nnsbetingelser;
	}
	
	//Metode for � hente kontaktinformasjonen.
	public String getKontaktinformasjon()
	{
		return kontaktinformasjon;
	}
	
	//Metode for � hente stillingsbeskrivelse.
	public String getStillingsbeskrivelse()
	{
		return stillingsbeskrivelse;
	}
	
	//Metode for � hente andre vilk�r.
	public String getAndreVilkar()
	{
		return andrevilk�r;
	}
	
	//Metode for � hente JobbID
	public int getJobbID()
	{
		return JobbID;
	}
	
	//metode for � hente all informasjon om jobben.
	public String getInfo()
	{
		String s = "Navn: " + navn + "\n" + "\n";
		s += "Sektor: " + sektor + "\n" + "\n";
		s += "Arbeidssted: " + arbeidssted + "\n" + "\n";
		s += "Arbeidsgiver: " + firma + "\n" + "\n";
		s += "Kategori: " + kategori + "\n" + "\n";
		if (fastellermidlertidig == 1)
			s += "Stillingen er fast." + "\n" + "\n";
		else if (fastellermidlertidig == 2)
			s += "Stillingen er midlertidig." + "\n" + "\n";
		if (heltidellerdeltid == 1)
			s += "Heltidsstilling" + "\n" + "\n";
		else if (heltidellerdeltid == 2)
			s += "Deltidsstilling" + "\n" + "\n";
		s += "Stillingstype: " + stillingstype + "\n" + "\n";
		s += "Kvalifikasjonskrav: " + kvalifikasjonskrav + "\n" + "\n";
		s += "L�nnsbetingelser: " + l�nnsbetingelser + "\n" + "\n";
		s += "Kontaktinformasjon: " + kontaktinformasjon + "\n" + "\n";
		s += "Stillingsbeskrivelse: " + stillingsbeskrivelse + "\n" + "\n";
		s += "Andre vilk�r: " + andrevilk�r + "\n" + "\n";
		s += "Jobb ID: " + Integer.toString(JobbID) + "\n" + "\n";
		s += getJobbSoknader();
		return s;
	}
	
	//Metode for � hente alle s�knadsIDene til jobbs�knadene p� en jobb.
	public String getJobbSoknader()
	{
		soknadsliste s�knader = new soknadsliste();
		File fil = new File("Soknader.dat");
		if (fil.exists())
		{
			try {
				s�knader.lesData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		String output = null;
		
		
		for (soknader s�knad : s�knader.getList())
		{
			if (s�knad.getJobb().getJobbID() == JobbID)
			{
				output = "Alle s�knader p� denne jobben: " + "\n" + "\n";
				output += "S�knadsID: " + s�knad.getSoknadsID() + "\n\n";
				
			}
		}
		return output;
	}
	//evt flere get metoder.
} //end of class Jobb.
