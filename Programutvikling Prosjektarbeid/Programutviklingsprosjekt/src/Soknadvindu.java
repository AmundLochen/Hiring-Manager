

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Starter klassen soknadvindu
public class Soknadvindu extends JFrame implements ActionListener 
{
	private JTextField sokerIDfelt,  jobbIDfelt;
	private JButton registrersoknad, vissoknader;
	private soknadsliste soknadListe;
	private arbeidssokerliste arbeidssokere;
	private Jobbliste jobber;

//Konstruktør for Soknadvindu, får tilsendt søknadsliste, søkerliste og jobbliste.
	public Soknadvindu( soknadsliste l, arbeidssokerliste m, Jobbliste j)
	{
		super("Registrering av Søknad");
		soknadListe = l;
		arbeidssokere = m;
		jobber = j;
		
		//Inistialiserer feltene.
		sokerIDfelt = new JTextField(20);
		jobbIDfelt = new JTextField(20);
		registrersoknad = new JButton("Registrer ny søknad");

		//Bygger GUIen
		Container content = getContentPane();
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		p1.add(new JLabel("SøkerID: "));
		p1.add(sokerIDfelt);
		p1.add(new JLabel("ID for jobb: "));
		p1.add(jobbIDfelt);
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
		p2.add(registrersoknad);
		registrersoknad.addActionListener(this);
		content.add(p1);
		p1.add(p2);
		setSize(400,130);
		setVisible(true);
	}

	//Metode for å registrere ny søknad med unik ID.
	public void nySoknad()
	{
		int sokerID = Integer.parseInt(sokerIDfelt.getText());
		int jobbID = Integer.parseInt(jobbIDfelt.getText());
		arbeidssoker søker = null;
		Jobb jobb = null;
		
		for (arbeidssoker Søker : arbeidssokere.getList())
		{
			if (Søker.getSokerID() == sokerID)
			{
				søker = Søker;
				
			}
		}
		for (Jobb enJobb : jobber.getList())
		{
			if (enJobb.getJobbID() == jobbID )
			{
				jobb = enJobb;
			}
		}
				
		int soknadsID = 0;
				
		if(soknadListe.isEmpty())
			{
				soknadsID = 1;
				soknader nySoknad = new soknader(søker, jobb, soknadsID);
				soknadListe.settInn(nySoknad);
			}
			else
			{
				arbeidssoker sok = null;
				sok = sokSoker();
				
				if (sok == null)
				{
					soknadsID = soknadListe.getSisteSoknad().getSoknadsID() + 1;
					soknader nySoknad = new soknader(søker, jobb, soknadsID);
					soknadListe.settInn(nySoknad);
				}
				else
					JOptionPane.showMessageDialog(null, "Søkeren har allerede søkt på denne jobben. En søker kan ikke søke på samme jobb to ganger.");
			}
	}
	
	//Metode for å søke etter en arbeidssøker.
	public arbeidssoker sokSoker()
	{
		int sokerID = Integer.parseInt(sokerIDfelt.getText());
		int jobbID = Integer.parseInt(jobbIDfelt.getText());
		
		for(soknader søk : soknadListe.getList())
		{
			if (søk.getSoker().getSokerID() == sokerID && søk.getJobb().getJobbID() == jobbID)
			{
				return søk.getSoker();
			}		
		}
		return null;
	}
	
	//Metode for å lytte til knappene.
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == registrersoknad)
		{
			if (sokerIDfelt.getText().length() == 0 || jobbIDfelt.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vennligst fyll ut all nødvendig informasjon");
			}
			else
			{
				nySoknad();
			try 
			{
				soknadListe.skrivData();
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
}

