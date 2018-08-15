//s156169 Maha Laham
//Amund Løchen s169999

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Starter klassen for historikk, som er en liste over ansettelser som er gjort av programmet.
public class Historikk 
{
	private LinkedList<Ansettelse> Ansettelser = new LinkedList<Ansettelse>();
   
	//Metoden setter inn ny ansettelse i historikken.
	public void settInn(Ansettelse a)
	{
		Ansettelser.add(a);
	}
	
	//Metoden setter inn ny ansettelse på en bestemt plass i lista.
	public void settInn(int i, Ansettelse a)
	{
		Ansettelser.add(i, a);
	}
	
	//Metoden setter inn ansettelse først i lista.
	public void settInnForst(Ansettelse a)
	{
		Ansettelser.addFirst(a);
	}
	
	//Metoden skriver ut historikken i JTextArea feltene som følger med.
	public void skrivListe(JTextArea ListeOverAnsettelser, JTextArea ListeOverDatoer)
	{
		String OverN = "SøknadsID og \nJobbID for ansettelsen: "  + "\n" + "\n";
		String OverID = "Dato for ansettelsen: "  + "\n" + "\n" + "\n";
		String UnderN = "";
		String UnderID = "";
		for(Ansettelse a : Ansettelser)
		{
			UnderN += a.getSoknad().getSoknadsID() + "  " + a.getJobb().getJobbID() + "\n";
			UnderID += a.getDate() + "\n";
		}
		ListeOverDatoer.append(OverID);
		ListeOverDatoer.append(UnderID);
		ListeOverAnsettelser.append(OverN);
		ListeOverAnsettelser.append(UnderN);
	}
	
	//Metode for å hente ansettelsen på et bestemt sted i lista.
	public Ansettelse getAnsettelse(int i)
	{
		return Ansettelser.get(i);
	}
	
	//Metode for å hente første ansettelse i lista.
	public Ansettelse getForsteAnsettelse()
	{
		return Ansettelser.getFirst();
	}
	
	//Metode for å hente siste ansettelse i lista.
	public Ansettelse getSisteAnsettelse()
	{
		return Ansettelser.getLast();
	}
	
	//Metode for å hente størrelsen til lista.
	public int getSize()
	{
		return Ansettelser.size();
	}
	
	//Metode for å fjerne en ansettelse fra en bestemt plass i lista.
	public void fjernAnsettelse(int i)
	{
		Ansettelser.remove(i);
	}
	
	//Metode for å sjekke om historikken er tom.
	public boolean isEmpty()
	{
		return Ansettelser.isEmpty();
	}
	
	//Metode for å hente hele lista over ansettelser.
	public LinkedList<Ansettelse> getList()
	{
		return Ansettelser;
	}
	
	//Metode for å lese historikken fra filen "Historikk.dat", Try/Catch tar seg av ClassNotFoundException.
	public void lesData() throws IOException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Historikk.dat"));
		
		try 
		{
			Ansettelser = (LinkedList<Ansettelse>) ois.readObject();
		} catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Klassen ble ikke funnet, kontroller at du har filen Historikk.dat. Dersom du har denne, slett den og start programmet på nytt.\nAdvarsel, dette vil slette hele historikken.");
		}
		ois.close();
	}
	
	//Metode for å skrive data til filen Historikk.dat
	public void skrivData() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Historikk.dat"));
		
		oos.writeObject(Ansettelser);
		
		oos.close();
	}
}//End of class Historikk.
