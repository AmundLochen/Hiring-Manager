

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import java.util.List;

//Starter klassen for arbeidss�kervinduet.
public class arbeidssokervindu extends JFrame implements ActionListener
{
	private JTextField utdKodefelt, navnefelt, adressefelt, erfaringsfelt, referansefelt, fodselsdatofelt;
	private JButton registrersoker;
	private arbeidssokerliste arbeidss�kerliste;
	private Hentefil vindu2;
	
	//Konstrukt�ren, f�r tilsendt en liste over arbeidss�kere fra hovedvinduet.
	public arbeidssokervindu(arbeidssokerliste l)
	{
		super("Registrering av arbeidss�ker");
		arbeidss�kerliste = l;
		
		//Initialiserer alle feltene og knappene.
		fodselsdatofelt = new JTextField(20);
		utdKodefelt = new JTextField(20);
		navnefelt = new JTextField(20);
		adressefelt = new JTextField(20);
		erfaringsfelt = new JTextField(100);
		referansefelt = new JTextField(50);
		registrersoker = new JButton("Registrer ny s�ker");
		
		//Bygger opp GUIen.
		Container content = getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(Color.lightGray);
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		p1.add(new JLabel("Navn: "));
		p1.add(navnefelt);
		p1.add(new JLabel("Adresse: "));
		p1.add(adressefelt);
		p1.add(new JLabel("F�dselsdato (DD/MM/����): "));
		p1.add(fodselsdatofelt);
		p1.add(new JLabel("Utdanningskode: "));
		p1.add(utdKodefelt);
		p1.add(new JLabel("Erfaring: "));
		p1.add(erfaringsfelt);
		p1.add(new JLabel ("Referanser: "));
		p1.add(referansefelt);
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
		p2.add(registrersoker);
		registrersoker.addActionListener(this);
		JPanel p3 = new JPanel ();
		p3.setLayout(new BoxLayout(p3, BoxLayout.PAGE_AXIS));
		content.add(p1);
		p1.add(p2);
		p1.add(p3);
		setSize(500,350);
		setVisible(true);
	}
		
	//Metode for ny arbeidss�ker. Sender med en ledig ID. 
		public void nySoker() throws ParseException
		{
			String utdKode = utdKodefelt.getText();
			String navn = navnefelt.getText();
			String adresse = adressefelt.getText();
			String erfaring = erfaringsfelt.getText();
			String referanser = referansefelt.getText();
			DateFormat fodselsdato = new SimpleDateFormat("dd/MM/yyyy");
			Date f�dselsdato = fodselsdato.parse(fodselsdatofelt.getText());
			
			
			
			int ID = 0;
				if(arbeidss�kerliste.isEmpty())
				{
						ID = 1;
						arbeidssoker nySoker = new arbeidssoker(ID, f�dselsdato, utdKode, navn, adresse, null);
						arbeidss�kerliste.settInn(nySoker);
				}
				else
				{
						ID = arbeidss�kerliste.getSisteSoker().getSokerID() + 1;
						arbeidssoker nySoker = new arbeidssoker(ID, f�dselsdato, utdKode, navn, adresse, null);
						arbeidss�kerliste.settInn(nySoker);
				}

		}
		
	//Metode for � lytte til knappene. Hindrer IOExceptions og ParseExceptions med try/catch.
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == registrersoker)
		{
			if (navnefelt.getText().length() == 0 || utdKodefelt.getText().length() == 0 || adressefelt.getText().length() == 0 || erfaringsfelt.getText().length() == 0 || referansefelt.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vennligst fyll ut all n�dvendig informasjon");
			}
			else
			{
				try {
				nySoker();
				Hentefil vindu2 = new Hentefil(arbeidss�kerliste);
				setVisible(false);
				dispose();
			} catch (ParseException e1) 
			{
				JOptionPane.showMessageDialog(null, "Skriv inn en gyldig f�dselsdato i formen dd/mm/yyyy");
			}
		
			
			
			
			
			}
		}
	}
}// End of class Arbeidss�kervindu.


