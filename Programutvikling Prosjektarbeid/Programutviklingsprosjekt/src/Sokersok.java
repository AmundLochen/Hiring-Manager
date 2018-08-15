

import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Sokersok {
	
	private int soker;
	private static int nesteSoker = 1;
	private int soknad;
	private int soknadID;
	private Date fodselsd;
	private String utdKode; 
	private String fornavn;
	private String etternavn;
	private String bosted;
	private String utdanning; 
	private String n;
	private JTextArea utskrift = new JTextArea();
	private Arbeidssokerliste list = new Arbeidssokerliste();
	private Arbeidssoker s = new Arbeidssoker (soknad, soknadID, fodselsd, fornavn, etternavn, utdKode, utdanning,  n, bosted);

	
	public String sokerNavn()
	{
		int i = 0;
		Arbeidssoker info = list.getArbeidssoker(i);
				
		for (Arbeidssoker a : list.arbeidssokere){

			if (list.arbeidssokere.isEmpty())
			{
			    JOptionPane.showMessageDialog(null, "Feil");
			}
			else if(a.equals(s.getEtternavn()))
			{
				utskrift.setText( "Informasjon " + info);;
			}
		}
		return "Feil";
	}
		
	public String sokerAdresse()
	{
		int i = 0;
		Arbeidssoker info = list.getArbeidssoker(i);
				
		for (Arbeidssoker a : list.arbeidssokere){

			if (list.arbeidssokere.isEmpty())
			{
			    JOptionPane.showMessageDialog(null, "Feil");
			}
			else if(a.equals(s.getAdresse()))
			{
				utskrift.setText( "Informasjon " + info);;
			}
		}
		return "Feil";
	}
	
}
