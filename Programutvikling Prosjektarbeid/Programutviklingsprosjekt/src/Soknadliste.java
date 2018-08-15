import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;


public class Soknadliste 
{
	LinkedList<soknader> søknader = new LinkedList<soknader>();
	
	public void settInn(soknader s)
	{
		søknader.add(s);
	}
	
	public void settInn(int i, soknader s)
	{
		søknader.add(i, s);
	}
	
	public void settInnForst(soknader s)
	{
		søknader.addFirst(s);
	}
	
	
	public soknader getSoknad(int i)
	{
		return søknader.get(i);
	}
	
	public soknader getForsteSoknad()
	{
		return søknader.getFirst();
	}
	
	public int getSize()
	{
		return søknader.size();
	}
	
	public void fjernSoknad(int i)
	{
		søknader.remove(i);
	}
}
