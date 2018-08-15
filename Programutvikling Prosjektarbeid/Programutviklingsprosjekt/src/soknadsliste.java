//Skrevet av Julie Colle s146311
//Amund Løchen s169999

import java.io.*;
import java.util.LinkedList;
//import java.util.List;

import javax.swing.*;

//Starter klassen som oppretter en liste over søknader.
public class soknadsliste 
{
	private LinkedList<soknader> soknad = new LinkedList<soknader>();
	
	//Setter inn ny søknad i lista.
	public void settInn(soknader s)
	{
		soknad.add(s);
	}
	
	//Setter inn ny søknad på et bestemt punkt i lista.
	public void settInn(int i, soknader s)
	{
		soknad.add(i, s);
	}
	
	//Setter inn ny søknad først i lista.
	public void settInnForst(soknader s)
	{
		soknad.addFirst(s);
	}
	
	//Henter ut en bestemt søknad fra lista.
	public soknader getSoknader(int i)
	{
		return soknad.get(i);
	}
	
	//Henter første søknad i lista
	public soknader getForsteSoknad()
	{
		return soknad.getFirst();
	}
	
	//Henter siste søknad i lista
	public soknader getSisteSoknad()
	{
		return soknad.getLast();
	}
	
	//Sjekker om lista er tom.
	public boolean isEmpty()
	{
		return soknad.isEmpty();
	}
	
	//Skriver lista ut i JTextAreas som følger med.
	public void skrivListe(JTextArea ListeOverSokersnavnogID, JTextArea ListeOverSoknadID)
	{
		String overN = "Navn og ID for Søker: " + "\n" + "\n";
		String overID = "Søknadens ID: " + "\n" + "\n";
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
	
	//Får hele størrelsen til lista over søknader.
	public int getSize()
	{
		return soknad.size();
	}
	
	//Fjerner en søknad fra lista.
	public void fjernSoknad(soknader d)
	{
		soknad.remove(d);
	}
	
	//Søker etter og henter søknad med tilsendt ID.
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
	
	//Henter hele lista over søknader.
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


