

import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Giversok {
	
	private int giver;
	private String sek;
	private String bran;
	private String kode;
	private String n;
	private String bosted;
	private Arbeidsgiverliste list = new Arbeidsgiverliste();
	private Arbeidsgiver s = new Arbeidsgiver (giver, sek,
			bran, kode, n, bosted);
	private JTextArea utskrift = new JTextArea();
	
	public String giverNavn()
	{
		int i = 0;
		int size;
		size = list.getSize();
		Arbeidsgiver info = list.getArbeidsgiver(i);
				
		for (Arbeidsgiver a : list.arbeidsgiver){

			if (list.arbeidsgiver.isEmpty())
			{
			    JOptionPane.showMessageDialog(null, "Feil");
			}
			else if(a.equals(s.getNavn()))
			{
				utskrift.setText( "Informasjon " + info + "\nantall:" + size);
			}
		}
		return "Feil";
	}
}
