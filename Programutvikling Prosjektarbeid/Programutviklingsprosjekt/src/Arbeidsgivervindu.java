
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import java.util.List;

//Klasse for vinduet som registrerer arbeidsgivere i programmet.
public class Arbeidsgivervindu extends JFrame implements ActionListener
{
	private JTextField arbstedFelt, sektorFelt,
	bransjeFelt, navnFelt, adrFelt;
	private JButton lagreGiver;
	private JPanel p1;
	private Arbeidsgiverliste arbeidsGiverListe;
	
	//Konstruktøren for å opprette arbeidsgivervinduet. Får med arbeidsgiverliste fra hovedvinduet, som er lest fra fil.
	public Arbeidsgivervindu(Arbeidsgiverliste l)
	{
		super("Registrering av arbeidsgiver");
		arbeidsGiverListe = l;
		
		arbstedFelt = new JTextField(20);
		sektorFelt = new JTextField(20);
		bransjeFelt = new JTextField(20);
		adrFelt = new JTextField(20);
		navnFelt = new JTextField(20);
		lagreGiver = new JButton("Registrer ny Arbeidsgiver");
		
		Container c = getContentPane();
	    c.setLayout( new BoxLayout(c, BoxLayout.PAGE_AXIS) );
		p1 = new JPanel();
		c.add(p1);
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		p1.add(new JLabel("Navn"));
		p1.add(navnFelt);
		p1.add(new JLabel("Adresse: "));
		p1.add(adrFelt);
		p1.add(new JLabel("Arbeidsted "));
		p1.add(arbstedFelt);
		p1.add(new JLabel("Bransje"));
		p1.add(bransjeFelt);
		p1.add(new JLabel("Sektor "));
		p1.add(sektorFelt);
		p1.add(lagreGiver);
		lagreGiver.addActionListener(this);
		setSize(300,350);
		setVisible(true);
	}
	
	//Metode for å registrere ny arbeidsgiver i listen.
	public void nyGiver()
		{
			String sektor = sektorFelt.getText();
			String navn = navnFelt.getText();
			String adresse = adrFelt.getText();
			String bransje = bransjeFelt.getText();
			
		
			int ID = 0;
			if(arbeidsGiverListe.isEmpty())
			{
					ID = 1;
					Arbeidsgiver nyGiver = new Arbeidsgiver(ID, sektor, bransje, navn, adresse);
					arbeidsGiverListe.settInn(nyGiver);
			}
			else
			{
					ID = arbeidsGiverListe.getSisteGiver().getAgiverID() + 1;
					Arbeidsgiver nyGiver = new Arbeidsgiver(ID, sektor, bransje, navn, adresse);
					arbeidsGiverListe.settInn(nyGiver);
			}  
		}
	
	//Metode for å lytte til knappene i programmet. Try/Catch for IOExceptions.
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == lagreGiver)
		{
			//If-setning som sjekker at alle feltene har informasjon.
			if (sektorFelt.getText().length() == 0 || adrFelt.getText().length() == 0 || bransjeFelt.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vennligst fyll ut all nødvendig informasjon");
			}
			else
			{
				nyGiver();
			try 
			{
				arbeidsGiverListe.skrivData();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			setVisible(false);
			dispose();
			}
		}
	}
	
}//End of class Arbeidsgivervindu.
