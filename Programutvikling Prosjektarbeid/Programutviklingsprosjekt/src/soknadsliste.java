//Skrevet av Julie Colle s146311
//Amund L�chen s169999

import java.io.*;
import java.util.LinkedList;
//import java.util.List;

import javax.swing.*;

//Starter klassen som oppretter en liste over s�knader.
public class soknadsliste 
{
	private LinkedList<soknader> soknad = new LinkedList<soknader>();
	
	//Setter inn ny s�knad i lista.
	public void settInn(soknader s)
	{
		soknad.add(s);
	}
	
	//Setter inn ny s�knad p� et bestemt punkt i lista.
	public void settInn(int i, soknader s)
	{
		soknad.add(i, s);
	}
	
	//Setter inn ny s�knad f�rst i lista.
	public void settInnForst(soknader s)
	{
		soknad.addFirst(s);
	}
	
	//Henter ut en bestemt s�knad fra lista.
	public soknader getSoknader(int i)
	{
		return soknad.get(i);
	}
	
	//Henter f�rste s�knad i lista
	public soknader getForsteSoknad()
	{
		return soknad.getFirst();
	}
	
	//Henter siste s�knad i lista
	public soknader getSisteSoknad()
	{
		return soknad.getLast();
	}
	
	//Sjekker om lista er tom.
	public boolean isEmpty()
	{
		return soknad.isEmpty();
	}
	
	//Skriver lista ut i JTextAreas som f�lger med.
	public void skrivListe(JTextArea ListeOverSokersnavnogID, JTextArea ListeOverSoknadID)
	{
		String overN = "Navn og ID for S�ker: " + "\n" + "\n";
		String overID = "S�knadens ID: " + "\n" + "\n";
		String underN = "";
		String underID = "";
		
		for(soknader sok : soknad)
		{
			underN += sok.getSoker().getNavn() + "    " + sok.getSoker().getSokerID() + "\n";
			underID += sok.getSoknadsID() + "\n";
		}
		
		ListeOverSokersnavnogID.append(overID);
		ListeOverSokersnavnogID.append(underID);
		ListeOverSoknadID.append(overN);
		ListeOverSoknadID.append(underN);
	}
	
	//F�r hele st�rrelsen til lista over s�knader.
	public int getSize()
	{
		return soknad.size();
	}
	
	//Fjerner en s�knad fra lista.
	public void fjernSoknad(soknader d)
	{
		soknad.remove(d);
	}
	
	//S�ker etter og henter s�knad med tilsendt ID.
	public soknader getSoknadByID(int i)
	{
		for(soknader sok : soknad)
		{
			if (sok.getSoknadsID() == i)
			{
				return sok;
			}		
		}
		return null;
	}
	
	//Henter hele lista over s�knader.
	public LinkedList<soknader> getList()
	{
		return soknad;
	}
	
	//Leser lista fra filen Soknader.dat
	public void lesData() throws IOException
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Soknader.dat"));
		
		try 
		{
			soknad = (LinkedList<soknader>) ois.readObject();
		} catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Class Not Found Exception");
		}
		ois.close();
	}
	
	//Skriver lista til filen Soknader.dat
	public void skrivData() throws IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Soknader.dat"));
		
		oos.writeObject(soknad);
		
		oos.close();
	}
}//End of class soknadsliste


