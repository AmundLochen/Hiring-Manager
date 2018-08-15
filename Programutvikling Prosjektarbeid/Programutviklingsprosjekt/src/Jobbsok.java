//s156169

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Jobbsok {
	
	private String navnet;
	private String sektoren;
	private String arbeidsstedet;
	private String firmaet;
	private String kategorien;
	private int fastellermidlertidige;
	private int heltidsellerdeltids;
	private String stillingstypen;
	private int ID;
	String kvalifikasjon;
	String lonn;
	String kontakt;
	String stillingbeskrivelse;
	String vilkar;
	private Jobbliste list = new Jobbliste();
	Jobb j = new Jobb(navnet,sektoren, arbeidsstedet, firmaet,
	kategorien, fastellermidlertidige, heltidsellerdeltids, 
	stillingstypen, ID, kvalifikasjon, lonn, kontakt,
	stillingbeskrivelse, vilkar);
	JTextArea utskrift = new JTextArea();
	
	public String ledigeNavn()
	{
		int i = 0;
		Jobb info = list.getJobb(i);
				
		for (Jobb a : list.jobber){

			if (list.jobber.isEmpty())
			{
			    JOptionPane.showMessageDialog(null, "Feil");
			}
			else if(a.equals(j.getNavn()))
			{
				utskrift.setText( "Informasjon " + info);;
			}
		}
		return "Feil";
	}
		
	public String ledigeKategori()
	{
		int i = 0;
		Jobb info = list.getJobb(i);
				
		for (Jobb a : list.jobber)
		{
			if (list.jobber.isEmpty())
			{
			    JOptionPane.showMessageDialog(null, "Feil");
			}
			else if(a.equals(j.getKategori()))
			{	
				utskrift.setText( "Informasjon" + info);
			}
		}
		
		return "-1";
	}
	
	public String ledigeFrima()
	{
		int i = 0;
		Jobb info = list.getJobb(i);
				
		for (Jobb a : list.jobber)
		{
			if (list.jobber.isEmpty())
			{
			    JOptionPane.showMessageDialog(null, "Feil");
			}
			else if (a.equals(j.getFirma()))
			{
				utskrift.setText( "Informasjon" + info);
			}
		}
		
		return "Feil";
	}
	
	public String ledigSted()
	{
		JTextArea utskrift = new JTextArea();
		int i = 0;
		Jobb info = list.getJobb(i);
				
		for (Jobb a : list.jobber)
		{
			if (list.jobber.isEmpty())
			{
			    JOptionPane.showMessageDialog(null, "Feil");
			}
			else if (a.equals(j.getArbeidssted()))
			{
				utskrift.setText( "Informasjon" + info);
			}
		}
		return "-1";
	}
}
