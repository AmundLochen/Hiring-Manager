import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//Programmert av Amund Løchen s169999

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
	private String lønnsbetingelser; 
	private String andrevilkår; 
	private String kontaktinformasjon; 
	private String stillingsbeskrivelse;
	private int JobbID;
	//Eventuelt andre datafelt.
	
	//Konstruktør for Jobb som bruker informasjon tilsendt fra Jobbvindu.
	public Jobb(String navnet, String sektoren, String arbeidsstedet, String firmaet, String kategorien, int fastellermidlertidige, int heltidsellerdeltids, String stillingstypen, int ID, String kvalifikasjon, String lønn, String kontakt, String stillingbeskrivelse, String vilkår)
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
		lønnsbetingelser = lønn;
		kontaktinformasjon = kontakt;
		stillingsbeskrivelse = stillingbeskrivelse;
		andrevilkår = vilkår;
	}
	
	//Metode for å hente navn på jobben.
	public String getNavn()
	{
		return navn;
	}
	
	//Metode for å hente sektorfeltet til jobben.
	public String getSektor()
	{
		return sektor;
	}
	
	//Metode for å hente arbeidsstedsfeltet til jobben.
	public String getArbeidssted()
	{
		return arbeidssted;
	}
	
	//Metode for å hente Arbeidsgiver/firma feltet til jobben.
	public String getFirma()
	{
		return firma;
	}
	
	//Metode for å hente kategorien til jobben.
	public String getKategori()
	{
		return kategori;
	}
	
	//Metode for å hente et heltall 1 eller 2 avhengig av om jobben er fast eller midlertidig, bestemt av radiobuttons i jobbvinduet.
	public int getFastellermidlertidig()
	{
		return fastellermidlertidig;
	}
	
	//Metode for å hente et heltall 1 eller 2 avhengig av om jobben er heltidsstilling eller deltidsstilling, bestemt av radiobuttons i jobbvinduet.
	public int getHeltidellerdeltid()
	{
		return heltidellerdeltid;
	}
	
	//Metode for å hente stillingstypefeltet.
	public String getStillingstype()
	{
		return stillingstype;
	}
	
	//Metode for å hente kvalifikasjonskravfeltet.
	public String getKvalifikasjonskrav()
	{
		return kvalifikasjonskrav;
	}
	
	//Metode for å hente lønnsbetingelsesfeltet.
	public String getLønnsbetingelser()
	{
		return lønnsbetingelser;
	}
	
	//Metode for å hente kontaktinformasjonen.
	public String getKontaktinformasjon()
	{
		return kontaktinformasjon;
	}
	
	//Metode for å hente stillingsbeskrivelse.
	public String getStillingsbeskrivelse()
	{
		return stillingsbeskrivelse;
	}
	
	//Metode for å hente andre vilkår.
	public String getAndreVilkar()
	{
		return andrevilkår;
	}
	
	//Metode for å hente JobbID
	public int getJobbID()
	{
		return JobbID;
	}
	
	//metode for å hente all informasjon om jobben.
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
		s += "Lønnsbetingelser: " + lønnsbetingelser + "\n" + "\n";
		s += "Kontaktinformasjon: " + kontaktinformasjon + "\n" + "\n";
		s += "Stillingsbeskrivelse: " + stillingsbeskrivelse + "\n" + "\n";
		s += "Andre vilkår: " + andrevilkår + "\n" + "\n";
		s += "Jobb ID: " + Integer.toString(JobbID) + "\n" + "\n";
		s += getJobbSoknader();
		return s;
	}
	
	//Metode for å hente alle søknadsIDene til jobbsøknadene på en jobb.
	public String getJobbSoknader()
	{
		soknadsliste søknader = new soknadsliste();
		File fil = new File("Soknader.dat");
		if (fil.exists())
		{
			try {
				søknader.lesData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		String output = null;
		
		
		for (soknader søknad : søknader.getList())
		{
			if (søknad.getJobb().getJobbID() == JobbID)
			{
				output = "Alle søknader på denne jobben: " + "\n" + "\n";
				output += "SøknadsID: " + søknad.getSoknadsID() + "\n\n";
				
			}
		}
		return output;
	}
	//evt flere get metoder.
} //end of class Jobb.
