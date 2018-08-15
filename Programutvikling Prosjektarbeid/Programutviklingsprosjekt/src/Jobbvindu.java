//Vindusklasse for vinduet man bruker til å registrere jobber. Skrevet av Amund Løchen. s169999

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;

import java.util.*;
import java.util.List;

//Starter klassen for jobbvinduet.
public class Jobbvindu extends JFrame implements ActionListener
{
	private JTextField navnefelt, sektorfelt, arbeidsstedsfelt, firmafelt, kategorifelt, stillingstypefelt;
	private JButton registrerjobb;
	private JRadioButton fastknapp, midlertidigknapp, heltidsknapp, deltidsknapp;
	private Jobbliste jobber;
	private int fastellermidlertidig, heltidsellerdeltids;
	private JTextArea kvalifikasjonskravfelt, lønnsbetingelsesfelt, kontaktinformasjonsfelt, stillingsbeskrivelsesfelt, vilkårfelt;

	//Konstruktøren for Jobbvinduet, får med Jobbliste fra hovedvinduet som er lest fra fil.
	public Jobbvindu(Jobbliste l)
	{
		super("Jobbregistrering");
		jobber = l;
		
		//Initialiserer alle feltene og knappene.
		navnefelt = new JTextField();
		sektorfelt = new JTextField(20);
		arbeidsstedsfelt = new JTextField(20);
		firmafelt = new JTextField(20);
		kategorifelt = new JTextField(20);
		stillingstypefelt = new JTextField(20);
		kvalifikasjonskravfelt = new JTextArea(5, 10);
		lønnsbetingelsesfelt = new JTextArea(5, 10);
		kontaktinformasjonsfelt = new JTextArea(5, 10);
		stillingsbeskrivelsesfelt = new JTextArea(5, 10);
		vilkårfelt = new JTextArea(10, 20);
		registrerjobb = new JButton("Lagre ny jobb");
		ButtonGroup gruppe = new ButtonGroup();
		ButtonGroup gruppe2 = new ButtonGroup();
		fastknapp = new JRadioButton("Fast stilling");
		midlertidigknapp = new JRadioButton("Midlertidig stilling");
		heltidsknapp = new JRadioButton("Heltidsstilling");
		deltidsknapp = new JRadioButton("Deltidsstilling");
		
		//Bygger opp GUIen
		Container content = getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(Color.lightGray);
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		p1.add(new JLabel("Navn på Jobb"));
		p1.add(navnefelt);
		p1.add(new JLabel("Sektor"));
		p1.add(sektorfelt);
		p1.add(new JLabel("Arbeidssted"));
		p1.add(arbeidsstedsfelt);
		p1.add(new JLabel("Arbeidsgiver/firma"));
		p1.add(firmafelt);
		p1.add(new JLabel("Kategori"));
		p1.add(kategorifelt);
		p1.add(new JLabel("stillingstype"));
		p1.add(stillingstypefelt);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3, BoxLayout.PAGE_AXIS));
		p1.add(new JScrollPane(p3));
		p3.add(new JLabel("Velg om stillingen er fast eller midlertidig: "));
		p3.add(fastknapp);
		fastknapp.setSelected(true);
		gruppe.add(fastknapp);
		p3.add(midlertidigknapp);
		gruppe.add(midlertidigknapp);
		p3.add(new JLabel("Velg om det er en heltidstilling eller deltidstilling: "));
		p3.add(heltidsknapp);
		heltidsknapp.setSelected(true);
		gruppe2.add(heltidsknapp);
		p3.add(deltidsknapp);
		gruppe2.add(deltidsknapp);
		p3.add(new JLabel("Kvalifikasjonskrav:"));
		p3.add(new JScrollPane(kvalifikasjonskravfelt));
		p3.add(new JLabel("Lønnsbetingelser: "));
		p3.add(new JScrollPane(lønnsbetingelsesfelt));
		p3.add(new JLabel("Kontaktinformasjon"));
		p3.add(new JScrollPane(kontaktinformasjonsfelt));
		p3.add(new JLabel("Stillingsbeskrivelse: "));
		p3.add(new JScrollPane(stillingsbeskrivelsesfelt));
		p3.add(new JLabel("Andre vilkår: "));
		p3.add(new JScrollPane(vilkårfelt));
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
		p2.add(registrerjobb);
		registrerjobb.addActionListener(this);
		content.add(p1);
		content.add(p2);
		p1.setSize(200, 300);
		setSize(400,600);
		setVisible(true);
		
		
	}
		
		
		//Metode for å registrere ny jobb og dele ut riktig unik ID.
	public void nyJobb()
	{
		
		String navn = navnefelt.getText();
		String sektor = sektorfelt.getText();
		String arbeidssted = arbeidsstedsfelt.getText();
		String firma = firmafelt.getText();
		String kategori = kategorifelt.getText();
		String stillingstype = stillingstypefelt.getText();
		String kvalifikasjonskrav = kvalifikasjonskravfelt.getText();
		String lønnsbetingelser = lønnsbetingelsesfelt.getText();
		String kontaktinformasjon = kontaktinformasjonsfelt.getText();
		String stillingsbeskrivelse = stillingsbeskrivelsesfelt.getText();
		String vilkår = vilkårfelt.getText();
		
		if (fastknapp.isSelected() == true)
		{
			fastellermidlertidig = 1;
		}
		if (midlertidigknapp.isSelected() == true)
		{
			fastellermidlertidig = 2;
		}
		
		if (heltidsknapp.isSelected() == true)
		{
			heltidsellerdeltids = 1;
		}
		if (deltidsknapp.isSelected() == true)
		{
			heltidsellerdeltids = 2;
		}
		
		else
		{
		int ID = 0;
		if(jobber.isEmpty())
		{
				ID = 1;
				Jobb nyJobb = new Jobb(navn, sektor, arbeidssted, firma, kategori, fastellermidlertidig, heltidsellerdeltids, stillingstype, ID, kvalifikasjonskrav, lønnsbetingelser, kontaktinformasjon, stillingsbeskrivelse, vilkår);
				jobber.settInn(nyJobb);
		}
		else
		{
				ID = jobber.getSisteJobb().getJobbID() + 1;
				Jobb nyJobb = new Jobb(navn, sektor, arbeidssted, firma, kategori, fastellermidlertidig, heltidsellerdeltids, stillingstype, ID, kvalifikasjonskrav, lønnsbetingelser, kontaktinformasjon, stillingsbeskrivelse, vilkår);
				jobber.settInn(nyJobb);
		}
		}
	}
	
	//Metode for å lytte til knappene 
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == registrerjobb)
		{
			if (navnefelt.getText().length() == 0 || sektorfelt.getText().length() == 0 || arbeidsstedsfelt.getText().length() == 0 || firmafelt.getText().length() == 0 || kategorifelt.getText().length() == 0 || stillingstypefelt.getText().length() == 0 || kvalifikasjonskravfelt.getText().length() == 0 || lønnsbetingelsesfelt.getText().length() == 0 || kontaktinformasjonsfelt.getText().length() == 0 || stillingsbeskrivelsesfelt.getText().length() == 0 || vilkårfelt.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vennligst fyll ut alle feltene for å registrere en jobb.");
			}
			else
			{
				nyJobb();
				try {
					jobber.skrivData();
			} 	catch (IOException e1) {
					e1.printStackTrace();
			}
				setVisible(false);
				dispose();
			}
		}
	}
}// End of class Jobbvindu
