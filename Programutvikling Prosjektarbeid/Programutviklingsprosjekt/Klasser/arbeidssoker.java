

public class arbeidssoker 
{
	private int sokerID;
	private int soknadsID;
	private int lonnskrav;
	private int fodselsdato;
	private String utdKode; //array?
	private String navn;
	private String adresse;
	private String erfaring; //evt boolean. Kommer an på tekst eller bare om vedkommende har erfaring eller ikke.
	private String referanser;
	//CV-link
	
	public arbeidssoker (int soker, int soknad, int krav, int fodt, String utdanning, String n, String bosted)
	{
		sokerID = soker;
		soknadsID = soknad;
		lonnskrav = krav;
		fodselsdato = fodt;
		utdKode = utdanning;
		navn = n;
		adresse = bosted;
	}
	
	public int getSokerID()
	{
		return sokerID;
	}
	
	public int getSoknadsID()
	{
		return soknadsID;
	}
	
	public int getLonnskrav()
	{
		return lonnskrav;
	}
	
	public int getFodselsdato()
	{
		return fodselsdato;
	}
	
	public String getUtdKode()
	{
		return utdKode;
	}
	
	public String getNavn()
	{
		return navn;
	}
	
	public String getAdresse()
	{
		return adresse;
	}
	
	public String getErfaring()
	{
		return erfaring;
	}
	
	public String getReferanser()
	{
		return referanser;
	}
}
