
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane;

//starter klassen for hovedvinduet.
public class Hovedvindu extends JFrame implements ActionListener
{
	private JTabbedPane tabbedPane;
	private JButton registrerarbeidsgiver, registrerfirma, registrerarbeidss�ker, registrerjobb, registrers�knad, registreransettelse, visjobber, vissokere, visgivere, vissoknader,  vishistorikk, fjernGiver, fjernS�ker, fjernJobb, fjernS�knad, giverInfo, s�kerInfo, jobbInfo, s�knadInfo;
	private JTextArea Jobbtekstfelt, JobbIDfelt, S�knadsnavnogIDfelt, S�knadsIDfelt, arbeidssokernavnfelt, arbeidssokeridfelt, arbeidsgivernavnfelt, arbeidsgiveridfelt, ansettelsesfelt, Datofelt;
	private JTextField soknadsIDForAnsettelse, jobbIDForAnsettelse ;
	final Jobbliste jobber = new Jobbliste();
	final soknadsliste s�knader = new soknadsliste();
	final arbeidssokerliste s�kerliste = new arbeidssokerliste();
	final Arbeidsgiverliste giverliste = new Arbeidsgiverliste();
	final Historikk ansettelser = new Historikk();
	
	//Konstrukt�ren for hovedvinduet. Sjekker om filene som lagrer alle de 5 listene eksisterer og leser fra dem. Lagrer informasjonen i datafeltene for listene.
	public Hovedvindu()
	{
		super("Arbeidsprogram");
		File fil = new File("Jobb.dat");
		if (fil.exists())
		{
			try {
				jobber.lesData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		File fil2 = new File("Arbeidssoker.dat");
		if (fil2.exists())
		{
			try {
				s�kerliste.lesData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		File fil3 = new File("Arbeidsgiver.dat");
		if (fil3.exists())
		{
			try {
				giverliste.lesData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		
		File fil4 = new File("Soknader.dat");
		if (fil4.exists())
		{
			try {
				s�knader.lesData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		File fil5 = new File("Historikk.dat");
		if (fil5.exists())
		{
			try {
				ansettelser.lesData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//Initialiserer alle knapper og felter i vinduet.
		registrerarbeidsgiver = new JButton("Registrer arbeidsgiver");
		registrerfirma = new JButton("Registrer firma");
		registrerarbeidss�ker = new JButton("Registrer arbeidss�ker");
		vissokere = new JButton("Vis alle s�kere");
		registrerjobb = new JButton("Registrer ny jobb");
		registrers�knad = new JButton("Registrer s�knad");
		registreransettelse = new JButton("Foreta ansettelse");
		visgivere = new JButton("Vis alle arbeidsgivere");
		visjobber = new JButton("Vis alle jobber");
		vissoknader = new JButton("Vis alle soknader");
		vishistorikk = new JButton("Vis historikk over ansettelser");
		fjernGiver = new JButton("Fjern Arbeidsgiver");
		fjernS�ker = new JButton("Fjern Arbeidss�ker");
		fjernJobb = new JButton("Fjern Jobb");
		fjernS�knad = new JButton("Fjern S�knad");
		giverInfo = new JButton("Informasjon om Arbeidsgiver");
		s�kerInfo = new JButton("Informasjon om s�ker");
		jobbInfo = new JButton("Informasjon om en jobb");
		s�knadInfo = new JButton("Informasjon om s�knad");
		Jobbtekstfelt = new JTextArea(20, 15);
		Jobbtekstfelt.setEditable(false);
		JobbIDfelt = new JTextArea(20, 15);
		JobbIDfelt.setEditable(false);
		arbeidssokernavnfelt = new JTextArea(20, 15);
		arbeidssokernavnfelt.setEditable(false);
		arbeidssokeridfelt = new JTextArea(20, 15);
		arbeidssokeridfelt.setEditable(false);
		arbeidsgivernavnfelt = new JTextArea(20, 15);
		arbeidsgivernavnfelt.setEditable(false);
		arbeidsgiveridfelt = new JTextArea(20, 15);
		arbeidsgiveridfelt.setEditable(false);
		S�knadsnavnogIDfelt = new JTextArea(20, 15);
		S�knadsnavnogIDfelt.setEditable(false);
		S�knadsIDfelt = new JTextArea(20, 15);
		S�knadsIDfelt.setEditable(false);
		ansettelsesfelt = new JTextArea(20, 15);
		ansettelsesfelt.setEditable(false);
		Datofelt = new JTextArea(20, 15);
		Datofelt.setEditable(false);
		soknadsIDForAnsettelse = new JTextField(6);
		jobbIDForAnsettelse = new JTextField(6);
		
		
		//Bygger opp GUIen med JPanels.
		Container content = getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(Color.lightGray);
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3, BoxLayout.PAGE_AXIS));
		JPanel p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4, BoxLayout.PAGE_AXIS));
		JPanel p5 = new JPanel();
		p5.setLayout(new BoxLayout(p5, BoxLayout.PAGE_AXIS));
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();
		JPanel p9 = new JPanel();
		JPanel p10 = new JPanel();
		JPanel p11 = new JPanel();
		JPanel p12 = new JPanel();
		JPanel p13 = new JPanel();
		JPanel p14 = new JPanel();
		JPanel p15 = new JPanel();
		JPanel p16 = new JPanel();
		JPanel p17 = new JPanel();
		JPanel p18 = new JPanel();
		tabbedPane = new JTabbedPane();
		content.add(tabbedPane);
		tabbedPane.addTab("Arbeidsgiver", null, p1, "Fane for Arbeidsgivere");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.addTab("Arbeidss�ker", null, p3, "Fane for Arbeidss�ker");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.addTab("Jobb", null, p4, "Fane for Jobber");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.addTab("S�knad", null, p5, "Fane for S�knader");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		tabbedPane.addTab("Ansettelse", null, p10, "Fane for Ansettelser");
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
		p1.add(p13);
		p1.add(p14);
		p13.add(new JScrollPane(arbeidsgivernavnfelt));
		p13.add(new JScrollPane(arbeidsgiveridfelt));
		p14.add(registrerarbeidsgiver);
		p14.add(visgivere);
		p14.add(fjernGiver);
		p14.add(giverInfo);
		p2.add(registrerfirma);
		p3.add(p11);
		p11.add(new JScrollPane(arbeidssokernavnfelt));
		p11.add(new JScrollPane(arbeidssokeridfelt));
		p3.add(p12);
		p12.add(registrerarbeidss�ker);
		p12.add(vissokere);
		p12.add(fjernS�ker);
		p12.add(s�kerInfo);
		p6.add(new JScrollPane(Jobbtekstfelt));
		p6.add(new JScrollPane(JobbIDfelt));
		p5.add(p8);
		p5.add(p9);
		p8.add(new JScrollPane(S�knadsnavnogIDfelt));
		p8.add(new JScrollPane(S�knadsIDfelt));
		p4.add(p6);
		p4.add(p7);
		p7.add(registrerjobb);
		p7.add(visjobber);
		p7.add(fjernJobb);
		p7.add(jobbInfo);
		p9.add(registrers�knad);
		p9.add(vissoknader);
		p9.add(fjernS�knad);
		p9.add(s�knadInfo);
		p10.add(p15);
		p15.add(new JLabel("S�knads ID:"));
		p16.add(new JLabel("Jobb ID:"));
		p10.add(p16);
		p15.add(soknadsIDForAnsettelse);
		p16.add(jobbIDForAnsettelse);
		p10.add(p17);
		p10.add(p18);
		p17.add(registreransettelse);
		p17.add(vishistorikk);
		p18.add(new JScrollPane(ansettelsesfelt));
		p18.add(new JScrollPane(Datofelt));
		registrerarbeidsgiver.addActionListener(this);
		registrerfirma.addActionListener(this);
		registrerarbeidss�ker.addActionListener(this);
		registrerjobb.addActionListener(this);
		registrers�knad.addActionListener(this);
		visjobber.addActionListener(this);
		vissokere.addActionListener(this);
		visgivere.addActionListener(this);
		vissoknader.addActionListener(this);
		vishistorikk.addActionListener(this);
		registreransettelse.addActionListener(this);
		fjernGiver.addActionListener(this);
		fjernS�ker.addActionListener(this);
		fjernJobb.addActionListener(this);
		fjernS�knad.addActionListener(this);
		giverInfo.addActionListener(this);
		s�kerInfo.addActionListener(this);
		jobbInfo.addActionListener(this);
		s�knadInfo.addActionListener(this);
		setSize(500,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	
	
	
	
	
	//Klasse for � lytte til knappene.
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == registrerjobb)
		{
			Jobbvindu vindu1 = new Jobbvindu(jobber);
		}
		else if (e.getSource() == visjobber)
		{
			Jobbtekstfelt.setText("");
			JobbIDfelt.setText("");
			jobber.skrivListe(Jobbtekstfelt, JobbIDfelt);
		}
		else if (e.getSource() == vissokere)
		{
			arbeidssokernavnfelt.setText("");
			arbeidssokeridfelt.setText("");
			s�kerliste.skrivListe(arbeidssokernavnfelt, arbeidssokeridfelt);
		}
		
		else if (e.getSource() == visgivere)
		{
			arbeidsgivernavnfelt.setText("");
			arbeidsgiveridfelt.setText("");
			giverliste.skrivListe(arbeidsgivernavnfelt, arbeidsgiveridfelt);
		}
		
		else if (e.getSource() == vissoknader)
		{
			S�knadsnavnogIDfelt.setText("");
			S�knadsIDfelt.setText("");
			s�knader.skrivListe(S�knadsIDfelt, S�knadsnavnogIDfelt);
		}
		
		else if (e.getSource() == registrers�knad)
		{
			Soknadvindu vindu2 = null;
			if (!s�kerliste.isEmpty() && !jobber.isEmpty())
				vindu2 = new Soknadvindu(s�knader, s�kerliste, jobber);
			else
				JOptionPane.showMessageDialog(null, "Du m� registrere minst en arbeidss�ker og minst en jobb f�r du kan registrere s�knader.");
		}
		
		else if (e.getSource() == registrerarbeidss�ker)
		{
			arbeidssokervindu vindu3 = new arbeidssokervindu(s�kerliste);
		}
		else if (e.getSource() == registrerarbeidsgiver)
		{
			Arbeidsgivervindu vindu4 = new Arbeidsgivervindu(giverliste);
		}
		else if (e.getSource() == registreransettelse) //Sjekker at hverken s�knader eller jobber er tom, og at feltene inneholder noe. Deretter finner den riktig s�knad og jobb som den tilslutt bruker i ansettelse.
		{

			if(s�knader.isEmpty() || jobber.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Du m� registrere jobber og s�knader f�r du kan ansette noen.");
			}
			else if (soknadsIDForAnsettelse.getText().length() == 0 && jobbIDForAnsettelse.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vennligst fyll inn alle n�dvendige felter.");
			}
			else {
				soknader S�k = s�knader.getSoknadByID(Integer.parseInt(soknadsIDForAnsettelse.getText()));
				if (S�k != null)
				{
					Jobb Jobben = jobber.getJobbByID(Integer.parseInt(jobbIDForAnsettelse.getText()));
					if (Jobben != null) {
						Ansettelse nyAnsettelse = new Ansettelse(S�k, Jobben, DateUtils.now());
						ansettelser.settInn(nyAnsettelse);
						s�knader.fjernSoknad(S�k);
						jobber.fjernJobb(Jobben);
						try {
							ansettelser.skrivData();
						} 
						catch (IOException e1) 
						{
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "S�ker har n� blitt ansatt p� bakgrunn av sin s�knad.");
					}
					else {
						JOptionPane.showMessageDialog(null, "Skriv inn gyldig s�knadsID og jobbID som allerede er registrert.");
					}
				}
				else  {
					JOptionPane.showMessageDialog(null, "Skriv inn gyldige s�knadsID og jobbID som allerede er registrert.");
				}
			}
		}
		else if (e.getSource() == vishistorikk)
		{
			ansettelsesfelt.setText("");
			Datofelt.setText("");
			ansettelser.skrivListe(ansettelsesfelt, Datofelt);
		}
		else if (e.getSource() == fjernGiver)
		{
			int giver = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID til Arbeidsgiver som du �nsker � fjerne"));
			
			Arbeidsgiver a = giverliste.getGiverByID(giver);
			
			giverliste.fjernArbeidsgiver(a);
			
			try {
				giverliste.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == fjernS�ker)
		{
			int s�ker = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID til Arbeidss�ker som du �nsker � fjerne"));
			
			arbeidssoker b = s�kerliste.getS�kerByID(s�ker);
			
			s�kerliste.fjernArbeidssoker(b);
			
			try {
				s�kerliste.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == fjernJobb)
		{
			int job = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn Jobb ID til jobben som du �nsker � fjerne"));
			
			Jobb c = jobber.getJobbByID(job);
			
			jobber.fjernJobb(c);
			
			try {
				jobber.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == fjernS�knad)
		{
			int soknaden = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn S�knadsID til s�knaden som du �nsker � fjerne"));
			
			soknader d = s�knader.getSoknadByID(soknaden);
			
			s�knader.fjernSoknad(d);
			
			try {
				s�knader.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == jobbInfo) //Infofeltene passer p� at du skriver inn gyldig ID og oppretter et eget vindu med all informasjon om det relevante infofeltet.
		{
			try{
			int i = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID p� Jobben du skal ha informasjon om."));
			Jobb j = jobber.getJobbByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(j.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
			} catch (NullPointerException npe)
			{
				JOptionPane.showMessageDialog(null, "Du m� skrive inn en gyldig jobb ID.");
			}
		}
		else if (e.getSource() == s�kerInfo)
		{
			try {
			String melding = JOptionPane.showInputDialog("Skriv inn ID p� Arbeidss�keren du skal ha informasjon om.");
			if (melding != null)
			{
				int i = 0;
			try {
				i = Integer.parseInt(melding);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Skriv inn en heltallsID for arbeidss�ker!");
			}
			if (i != 0)
			{
			arbeidssoker s = s�kerliste.getS�kerByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(s.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
			}
			}
		} catch (NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Du m� skrive inn en gyldig S�ker ID.");
		}
		}
		else if (e.getSource() == giverInfo)
		{
			try{
			int i = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID p� Arbeidsgiveren du skal ha informasjon om."));
			Arbeidsgiver s = giverliste.getGiverByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(s.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
		} catch (NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Du m� skrive inn en gyldig Arbeidsgiver ID.");
		}
		}
		else if (e.getSource() == s�knadInfo)
		{
			try{
			int i = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID p� S�knaden du skal ha informasjon om."));
			soknader s = s�knader.getSoknadByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(s.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
		} catch (NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Du m� skrive inn en gyldig S�knads ID.");
		}
		}
	}
}// End of class Hovedvindu.
