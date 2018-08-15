

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

//Lager en liste over arbeidsgivere.
public class Arbeidsgiverliste
{
	private LinkedList<Arbeidsgiver> arbeidsgiver = new LinkedList<Arbeidsgiver>();
	
	//Setter inn en ny arbeidsgiver i lista.
	public void settInn(Arbeidsgiver arbg)
	{
		arbeidsgiver.add(arbg);
	}
	
	// Sjekker om lista er tom.
	public boolean isEmpty()
	{
		return arbeidsgiver.isEmpty();
	}
	
	//Setter inn ny arbeidsgiver i lista.
	public void settInn(int i, Arbeidsgiver arbg)
	{
		arbeidsgiver.add(i, arbg);
	}
	
	//Henger siste arbeidsgiver i lista.
	public Arbeidsgiver getSisteGiver()
	{
		return arbeidsgiver.getLast();
	}
	
	//Setter inn arbeidsgiver først i lista.
	public void settInnForst(Arbeidsgiver arbg)
	{
		arbeidsgiver.addFirst(arbg);
	}	
	
	//Skriver ut all info om arbeidsgiver i tekstfeltene som følger med.
	public void skrivListe(JTextArea ListeOverArbeidsgivere, JTextArea ListeOverGiverID)
	{
		String overN = "Navn på Arbeidsgiver: " + "\n" + "\n";
		String overID = "Arbeidsgivers ID: " + "\n" + "\n";
		String underN = "";
		String underID = "";
		
		for(Arbeidsgiver arbg : arbeidsgiver)
		{
			underN += arbg.getNavn() + "\n";
			underID += arbg.getAgiverID() + "\n";
		}
		
		ListeOverGiverID.append(overID);
		ListeOverGiverID.append(underID);
		ListeOverArbeidsgivere.append(overN);
		ListeOverArbeidsgivere.append(underN);
	}
	
	//henter ut en arbeidsgiver fra en indeks i lista.
	public Arbeidsgiver getArbeidsgiver(int i)
	{	
		return arbeidsgiver.get(i);
	}
	
	//Returnerer hele lista med arbeidsgivere.
	public LinkedList<Arbeidsgiver> getList()
	{
		return arbeidsgiver;
	}
	
	//Returnerer første arbeidsgiver.
	public Arbeidsgiver getForsteArbeidsgiver()
	{
		return arbeidsgiver.getFirst();
	}
	
	//Returnerer listas størrelse.
	public int getSize()
	{
		return arbeidsgiver.size();
	}
	
	//Fjerner en arbeidsgiver fra lista.
	public void fjernArbeidsgiver(Arbeidsgiver arbg)
	{
		arbeidsgiver.remove(arbg);
	}	
	
	//Henter ut en Arbeidsgiver når man sender med en ID og returnerer.
	public Arbeidsgiver getGiverByID(int i)
	{
		for(Arbeidsgiver arbg : arbeidsgiver)
		{
			if (arbg.getAgiverID() == i)
			{
				return arbg;
			}		
		}
		return null;
	}
	
	//Leser data fra filen "Arbeidsgiver.dat"
	public void lesData() throws IOException
	{
		ObjectInputStream oii = new ObjectInputStream(new FileInputStream("Arbeidsgiver.dat"));
		
		try 
		{
			arbeidsgiver = (LinkedList<Arbeidsgiver>) oii.readObject();
		} catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Class Not Found Exception");
		}
		oii.close();
	}
	
	//Skriver data til filen "Arbeidsgiver.dat"
	public void skrivData() throws IOException
	{
		ObjectOutputStream oio = new ObjectOutputStream(new FileOutputStream("Arbeidsgiver.dat"));
		
		oio.writeObject(arbeidsgiver);
		
		oio.close();
	}
}
