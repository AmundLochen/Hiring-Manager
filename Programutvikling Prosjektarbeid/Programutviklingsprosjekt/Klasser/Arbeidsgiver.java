// s156169

public class Arbeidsgiver 
{
	private int agiverID;
	private String arbsted;
	private String sektor;
	private String bransje;
	private String utdKode;
	private String navn;
	private String adresse;
	private String[] ledjobber;
	
	public Arbeidsgiver (int giver, String sek, String[]led, String bran, String utdanning, String n, String bosted)
	{
		agiverID = giver;
		utdKode = utdanning;
		sektor = sek;
		bransje = bran;
		navn = n;
		adresse = bosted;
		ledjobber = led;
	}
	
	public int getAgiverID()
	{
		return agiverID;
	}
	
	public String getUtdKodeID()
	{
		return utdKode;
	}
	
	public String getSektor()
	{
		return sektor;
	}
	
	public String getBransje()
	{
		return bransje;
	}
	
	public String getNavn()
	{
		return navn;
	}
	
	public String getAdresse()
	{
		return adresse;
	}
	
	public String[] getLedjobber()
	{
		return ledjobber;
	}
	
}