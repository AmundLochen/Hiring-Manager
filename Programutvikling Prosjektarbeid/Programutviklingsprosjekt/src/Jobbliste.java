//Skrevet av Amund Løchen s169999
import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

//Starter klassen for jobbliste.
public class Jobbliste implements Serializable
{
	private LinkedList<Jobb> jobber = new LinkedList<Jobb>();
	
	//Metode for å sette inn jobb i jobblisten.
	public void settInn(Jobb j)
	{
		jobber.add(j);
	}
	
	//Metode for å sette inn jobb på en bestemt plass i jobblisten.
	public void settInn(int i, Jobb j)
	{
		jobber.add(i, j);
	}
	
	//Metode for å sette inn jobb først i jobblisten.
	public void settInnForst(Jobb j)
	{
		jobber.addFirst(j);
	}
	
	//Metode for å hente Jobb basert på tilsendt ID.
	public Jobb getJobbByID(int i)
	{
		for(Jobb jobb : jobber)
		{
			if (jobb.getJobbID() == i)
			{
				return jobb;
			}		
		}
		return null;
	}
	
	//Metode for å skrive ut liste over jobber i TextArea.
	public void skrivListe(JTextArea ListeOverJobber, JTextArea ListeOverJobbID)
	{
		String OverN = "Navn på Jobb: "  + "\n" + "\n";
		String OverID = "ID: "  + "\n" + "\n";
		String UnderN = "";
		String UnderID = "";
		for(Jobb j : jobber)
		{
			UnderN += j.getNavn() + "\n";
			UnderID += j.getJobbID() + "\n";
		}
		ListeOverJobbID.append(OverID);
		ListeOverJobbID.append(UnderID);
		ListeOverJobber.append(OverN);
		ListeOverJobber.append(UnderN);
	}
	
	//Metode for å hente en jobb fra en bestemt plass.
	public Jobb getJobb(int i)
	{
		return jobber.get(i);
	}
	
	//Metode for å hente første jobb i lista.
	public Jobb getForsteJobb()
	{
		return jobber.getFirst();
	}
	
	//Metode for å hente siste jobb i lista.
	public Jobb getSisteJobb()
	{
		return jobber.getLast();
	}
	
	//Metode for å hente listas størrelse.
	public int getSize()
	{
		return jobber.size();
	}
	
	//Metode for å fjerne jobb.
	public void fjernJobb(Jobb c)
	{
		jobber.remove(c);
	}
	
	//Sjekker om lista er tom.
	public boolean isEmpty()
	{
		return jobber.isEmpty();
	}
	
	//Henter ut hele jobblisten.
	public LinkedList<Jobb> getList()
	{
		return jobber;
	}
	
	//Leser data fra fil Jobb.dat
	public void lesData() throws IOException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Jobb.dat"));
		
		try 
		{
			jobber = (LinkedList<Jobb>) ois.readObject();
		} catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Class Not Found Exception");
		}
		ois.close();
	}
	
	//Skriver lista til fil Jobb.dat.
	public void skrivData() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Jobb.dat"));
		
		oos.writeObject(jobber);
		
		oos.close();
	}
}// End of class Jobbliste.
