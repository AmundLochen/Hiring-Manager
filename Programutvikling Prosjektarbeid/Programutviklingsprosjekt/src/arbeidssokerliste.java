

	//Skrevet av Julie Colle s146311 og Amund Løchen s169999
	import java.io.*;
	import java.util.LinkedList;
	import java.util.List;

import javax.swing.*;

//starter klasse for liste over arbeidssøkere.
	public class arbeidssokerliste 
	{
		private LinkedList<arbeidssoker> arbeidssokere = new LinkedList<arbeidssoker>();
		
		//Setter inn ny arbeidssøker i lista.
		public void settInn(arbeidssoker arbs)
		{
			arbeidssokere.add(arbs);
		}
		
		//Setter inn ny arbeidssøker på en bestemt plass i lista.
		public void settInn(int i, arbeidssoker arbs)
		{
			arbeidssokere.add(i, arbs);
		}
		
		//Setter inn arbeidssøker først i lista.
		public void settInnForst(arbeidssoker arbs)
		{
			arbeidssokere.addFirst(arbs);
		}
		
		//Skriver all informasjon om lista ut i JTextAreas, skrevet av Amund Løchen
		public void skrivListe(JTextArea ListeOverArbeidssokere, JTextArea ListeOverSokerID)
		{
			String overN = "Navn på Søker: " + "\n" + "\n";
			String overID = "Søkers ID: " + "\n" + "\n";
			String underN = "";
			String underID = "";
			
			for(arbeidssoker arbs : arbeidssokere)
			{
				underN += arbs.getNavn() + "\n";
				underID += arbs.getSokerID() + "\n";
			}
			
			ListeOverSokerID.append(overID);
			ListeOverSokerID.append(underID);
			ListeOverArbeidssokere.append(overN);
			ListeOverArbeidssokere.append(underN);
		}
		
		//Henter arbeidssøker på en gitt plass.
		public arbeidssoker getArbeidssoker(int i)
		{
			return arbeidssokere.get(i);
		}
		
		//Henter første arbeidssøker i lista.
		public arbeidssoker getForsteArbeidssoker()
		{
			return arbeidssokere.getFirst();
		}
		
		//sjekker om lista er tom.
		public boolean isEmpty()
		{
			return arbeidssokere.isEmpty();
		}
		
		//Henter siste søker i lista.
		public arbeidssoker getSisteSoker()
		{
			return arbeidssokere.getLast();
		}
		
		//Henter størrelsen til lista.
		public int getSize()
		{
			return arbeidssokere.size();
		}
		
		//Fjerner en arbeidssøker fra lista.
		public void fjernArbeidssoker(arbeidssoker b)
		{
			arbeidssokere.remove(b);
		}
		
		//Søker opp en søker med tilsendt ID skrevet av Amund Løchen.
		public arbeidssoker getSøkerByID(int i)
		{
			for(arbeidssoker soker : arbeidssokere)
			{
				if (soker.getSokerID() == i)
				{
					return soker;
				}		
			}
			return null;
		}
		
		//Henter ut hele listen.
		public LinkedList<arbeidssoker> getList()
		{
			return arbeidssokere;
		}
		
		//Leser listen fra filen "Arbeidssoker.dat"
		public void lesData() throws IOException
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Arbeidssoker.dat"));
			
			try 
			{
				arbeidssokere = (LinkedList<arbeidssoker>) ois.readObject();
			} catch (ClassNotFoundException e) 
			{
				JOptionPane.showMessageDialog(null, "Class Not Found Exception");
			}
			ois.close();
		}
		
		//Skriver listen til filen "Arbeidssoker.dat"
		public void skrivData() throws IOException
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Arbeidssoker.dat"));
			
			oos.writeObject(arbeidssokere);
			
			oos.close();
		}
	}//End of class arbeidssokerliste.


