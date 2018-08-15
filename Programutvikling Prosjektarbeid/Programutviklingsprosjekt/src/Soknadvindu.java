

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

//Konstrukt�r for Soknadvindu, f�r tilsendt s�knadsliste, s�kerliste og jobbliste.
	public Soknadvindu( soknadsliste l, arbeidssokerliste m, Jobbliste j)
	{
		super("Registrering av S�knad");
		soknadListe = l;
		arbeidssokere = m;
		jobber = j;
		
		//Inistialiserer feltene.
		sokerIDfelt = new JTextField(20);
		jobbIDfelt = new JTextField(20);
		registrersoknad = new JButton("Registrer ny s�knad");

		//Bygger GUIen
		Container content = getContentPane();
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		p1.add(new JLabel("S�kerID: "));
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

	//Metode for � registrere ny s�knad med unik ID.
	public void nySoknad()
	{
		int sokerID = Integer.parseInt(sokerIDfelt.getText());
		int jobbID = Integer.parseInt(jobbIDfelt.getText());
		arbeidssoker s�ker = null;
		Jobb jobb = null;
		
		for (arbeidssoker S�ker : arbeidssokere.getList())
		{
			if (S�ker.getSokerID() == sokerID)
			{
				s�ker = S�ker;
				
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
				soknader nySoknad = new soknader(s�ker, jobb, soknadsID);
				soknadListe.settInn(nySoknad);
			}
			else
			{
				arbeidssoker sok = null;
				sok = sokSoker();
				
				if (sok == null)
				{
					soknadsID = soknadListe.getSisteSoknad().getSoknadsID() + 1;
					soknader nySoknad = new soknader(s�ker, jobb, soknadsID);
					soknadListe.settInn(nySoknad);
				}
				else
					JOptionPane.showMessageDialog(null, "S�keren har allerede s�kt p� denne jobben. En s�ker kan ikke s�ke p� samme jobb to ganger.");
			}
	}
	
	//Metode for � s�ke etter en arbeidss�ker.
	public arbeidssoker sokSoker()
	{
		int sokerID = Integer.parseInt(sokerIDfelt.getText());
		int jobbID = Integer.parseInt(jobbIDfelt.getText());
		
		for(soknader s�k : soknadListe.getList())
		{
			if (s�k.getSoker().getSokerID() == sokerID && s�k.getJobb().getJobbID() == jobbID)
			{
				return s�k.getSoker();
			}		
		}
		return null;
	}
	
	//Metode for � lytte til knappene.
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == registrersoknad)
		{
			if (sokerIDfelt.getText().length() == 0 || jobbIDfelt.getText().length() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vennligst fyll ut all n�dvendig informasjon");
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

