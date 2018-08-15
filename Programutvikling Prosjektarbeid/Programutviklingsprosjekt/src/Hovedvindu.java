
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
	private JButton registrerarbeidsgiver, registrerfirma, registrerarbeidssøker, registrerjobb, registrersøknad, registreransettelse, visjobber, vissokere, visgivere, vissoknader,  vishistorikk, fjernGiver, fjernSøker, fjernJobb, fjernSøknad, giverInfo, søkerInfo, jobbInfo, søknadInfo;
	private JTextArea Jobbtekstfelt, JobbIDfelt, SøknadsnavnogIDfelt, SøknadsIDfelt, arbeidssokernavnfelt, arbeidssokeridfelt, arbeidsgivernavnfelt, arbeidsgiveridfelt, ansettelsesfelt, Datofelt;
	private JTextField soknadsIDForAnsettelse, jobbIDForAnsettelse ;
	final Jobbliste jobber = new Jobbliste();
	final soknadsliste søknader = new soknadsliste();
	final arbeidssokerliste søkerliste = new arbeidssokerliste();
	final Arbeidsgiverliste giverliste = new Arbeidsgiverliste();
	final Historikk ansettelser = new Historikk();
	
	//Konstruktøren for hovedvinduet. Sjekker om filene som lagrer alle de 5 listene eksisterer og leser fra dem. Lagrer informasjonen i datafeltene for listene.
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
				søkerliste.lesData();
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
				søknader.lesData();
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
		registrerarbeidssøker = new JButton("Registrer arbeidssøker");
		vissokere = new JButton("Vis alle søkere");
		registrerjobb = new JButton("Registrer ny jobb");
		registrersøknad = new JButton("Registrer søknad");
		registreransettelse = new JButton("Foreta ansettelse");
		visgivere = new JButton("Vis alle arbeidsgivere");
		visjobber = new JButton("Vis alle jobber");
		vissoknader = new JButton("Vis alle soknader");
		vishistorikk = new JButton("Vis historikk over ansettelser");
		fjernGiver = new JButton("Fjern Arbeidsgiver");
		fjernSøker = new JButton("Fjern Arbeidssøker");
		fjernJobb = new JButton("Fjern Jobb");
		fjernSøknad = new JButton("Fjern Søknad");
		giverInfo = new JButton("Informasjon om Arbeidsgiver");
		søkerInfo = new JButton("Informasjon om søker");
		jobbInfo = new JButton("Informasjon om en jobb");
		søknadInfo = new JButton("Informasjon om søknad");
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
		SøknadsnavnogIDfelt = new JTextArea(20, 15);
		SøknadsnavnogIDfelt.setEditable(false);
		SøknadsIDfelt = new JTextArea(20, 15);
		SøknadsIDfelt.setEditable(false);
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
		tabbedPane.addTab("Arbeidssøker", null, p3, "Fane for Arbeidssøker");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.addTab("Jobb", null, p4, "Fane for Jobber");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		tabbedPane.addTab("Søknad", null, p5, "Fane for Søknader");
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
		p12.add(registrerarbeidssøker);
		p12.add(vissokere);
		p12.add(fjernSøker);
		p12.add(søkerInfo);
		p6.add(new JScrollPane(Jobbtekstfelt));
		p6.add(new JScrollPane(JobbIDfelt));
		p5.add(p8);
		p5.add(p9);
		p8.add(new JScrollPane(SøknadsnavnogIDfelt));
		p8.add(new JScrollPane(SøknadsIDfelt));
		p4.add(p6);
		p4.add(p7);
		p7.add(registrerjobb);
		p7.add(visjobber);
		p7.add(fjernJobb);
		p7.add(jobbInfo);
		p9.add(registrersøknad);
		p9.add(vissoknader);
		p9.add(fjernSøknad);
		p9.add(søknadInfo);
		p10.add(p15);
		p15.add(new JLabel("Søknads ID:"));
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
		registrerarbeidssøker.addActionListener(this);
		registrerjobb.addActionListener(this);
		registrersøknad.addActionListener(this);
		visjobber.addActionListener(this);
		vissokere.addActionListener(this);
		visgivere.addActionListener(this);
		vissoknader.addActionListener(this);
		vishistorikk.addActionListener(this);
		registreransettelse.addActionListener(this);
		fjernGiver.addActionListener(this);
		fjernSøker.addActionListener(this);
		fjernJobb.addActionListener(this);
		fjernSøknad.addActionListener(this);
		giverInfo.addActionListener(this);
		søkerInfo.addActionListener(this);
		jobbInfo.addActionListener(this);
		søknadInfo.addActionListener(this);
		setSize(500,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	
	
	
	
	
	//Klasse for å lytte til knappene.
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
			søkerliste.skrivListe(arbeidssokernavnfelt, arbeidssokeridfelt);
		}
		
		else if (e.getSource() == visgivere)
		{
			arbeidsgivernavnfelt.setText("");
			arbeidsgiveridfelt.setText("");
			giverliste.skrivListe(arbeidsgivernavnfelt, arbeidsgiveridfelt);
		}
		
		else if (e.getSource() == vissoknader)
		{
			SøknadsnavnogIDfelt.setText("");
			SøknadsIDfelt.setText("");
			søknader.skrivListe(SøknadsIDfelt, SøknadsnavnogIDfelt);
		}
		
		else if (e.getSource() == registrersøknad)
		{
			Soknadvindu vindu2 = null;
			if (!søkerliste.isEmpty() && !jobber.isEmpty())
				vindu2 = new Soknadvindu(søknader, søkerliste, jobber);
			else
				JOptionPane.showMessageDialog(null, "Du må registrere minst en arbeidssøker og minst en jobb før du kan registrere søknader.");
		}
		
		else if (e.getSource() == registrerarbeidssøker)
		{
			arbeidssokervindu vindu3 = new arbeidssokervindu(søkerliste);
		}
		else if (e.getSource() == registrerarbeidsgiver)
		{
			Arbeidsgivervindu vindu4 = new Arbeidsgivervindu(giverliste);
		}
		else if (e.getSource() == registreransettelse) //Sjekker at hverken søknader eller jobber er tom, og at feltene inneholder noe. Deretter finner den riktig søknad og jobb som den tilslutt bruker i ansettelse.
		{

			if(søknader.isEmpty() || jobber.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Du må registrere jobber og søknader før du kan ansette noen.");
			}
			else if (soknadsIDForAnsettelse.getText().length() == 0 && jobbIDForAnsettelse.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Vennligst fyll inn alle nødvendige felter.");
			}
			else {
				soknader Søk = søknader.getSoknadByID(Integer.parseInt(soknadsIDForAnsettelse.getText()));
				if (Søk != null)
				{
					Jobb Jobben = jobber.getJobbByID(Integer.parseInt(jobbIDForAnsettelse.getText()));
					if (Jobben != null) {
						Ansettelse nyAnsettelse = new Ansettelse(Søk, Jobben, DateUtils.now());
						ansettelser.settInn(nyAnsettelse);
						søknader.fjernSoknad(Søk);
						jobber.fjernJobb(Jobben);
						try {
							ansettelser.skrivData();
						} 
						catch (IOException e1) 
						{
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Søker har nå blitt ansatt på bakgrunn av sin søknad.");
					}
					else {
						JOptionPane.showMessageDialog(null, "Skriv inn gyldig søknadsID og jobbID som allerede er registrert.");
					}
				}
				else  {
					JOptionPane.showMessageDialog(null, "Skriv inn gyldige søknadsID og jobbID som allerede er registrert.");
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
			int giver = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID til Arbeidsgiver som du ønsker å fjerne"));
			
			Arbeidsgiver a = giverliste.getGiverByID(giver);
			
			giverliste.fjernArbeidsgiver(a);
			
			try {
				giverliste.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == fjernSøker)
		{
			int søker = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID til Arbeidssøker som du ønsker å fjerne"));
			
			arbeidssoker b = søkerliste.getSøkerByID(søker);
			
			søkerliste.fjernArbeidssoker(b);
			
			try {
				søkerliste.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == fjernJobb)
		{
			int job = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn Jobb ID til jobben som du ønsker å fjerne"));
			
			Jobb c = jobber.getJobbByID(job);
			
			jobber.fjernJobb(c);
			
			try {
				jobber.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == fjernSøknad)
		{
			int soknaden = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn SøknadsID til søknaden som du ønsker å fjerne"));
			
			soknader d = søknader.getSoknadByID(soknaden);
			
			søknader.fjernSoknad(d);
			
			try {
				søknader.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == jobbInfo) //Infofeltene passer på at du skriver inn gyldig ID og oppretter et eget vindu med all informasjon om det relevante infofeltet.
		{
			try{
			int i = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID på Jobben du skal ha informasjon om."));
			Jobb j = jobber.getJobbByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(j.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
			} catch (NullPointerException npe)
			{
				JOptionPane.showMessageDialog(null, "Du må skrive inn en gyldig jobb ID.");
			}
		}
		else if (e.getSource() == søkerInfo)
		{
			try {
			String melding = JOptionPane.showInputDialog("Skriv inn ID på Arbeidssøkeren du skal ha informasjon om.");
			if (melding != null)
			{
				int i = 0;
			try {
				i = Integer.parseInt(melding);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Skriv inn en heltallsID for arbeidssøker!");
			}
			if (i != 0)
			{
			arbeidssoker s = søkerliste.getSøkerByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(s.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
			}
			}
		} catch (NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Du må skrive inn en gyldig Søker ID.");
		}
		}
		else if (e.getSource() == giverInfo)
		{
			try{
			int i = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID på Arbeidsgiveren du skal ha informasjon om."));
			Arbeidsgiver s = giverliste.getGiverByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(s.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
		} catch (NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Du må skrive inn en gyldig Arbeidsgiver ID.");
		}
		}
		else if (e.getSource() == søknadInfo)
		{
			try{
			int i = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn ID på Søknaden du skal ha informasjon om."));
			soknader s = søknader.getSoknadByID(i);
			JTextArea output = new JTextArea();
			output.setEditable(false);
			output.append(s.getInfo());
			Infovindu informasjonsvindu = new Infovindu(output);
		} catch (NullPointerException npe)
		{
			JOptionPane.showMessageDialog(null, "Du må skrive inn en gyldig Søknads ID.");
		}
		}
	}
}// End of class Hovedvindu.
