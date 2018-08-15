import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;


public class Soknadliste 
{
	LinkedList<soknader> s�knader = new LinkedList<soknader>();
	
	public void settInn(soknader s)
	{
		s�knader.add(s);
	}
	
	public void settInn(int i, soknader s)
	{
		s�knader.add(i, s);
	}
	
	public void settInnForst(soknader s)
	{
		s�knader.addFirst(s);
	}
	
	
	public soknader getSoknad(int i)
	{
		return s�knader.get(i);
	}
	
	public soknader getForsteSoknad()
	{
		return s�knader.getFirst();
	}
	
	public int getSize()
	{
		return s�knader.size();
	}
	
	public void fjernSoknad(int i)
	{
		s�knader.remove(i);
	}
}
