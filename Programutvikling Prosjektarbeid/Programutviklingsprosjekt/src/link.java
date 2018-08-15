import javax.swing.JFileChooser;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class link extends JFrame
{
	private JButton velg;
	private JTextArea output;
	private String filsti = null;
	//private Inputlytter lytter;
	
	public link()
	//Informasjon om dialogvinduet.
	{
		super ("CV-link");
		//lytter = new Inputlytter;
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
	}
	
	public String velgCV()
	//Bruker skal her velge filsti.
	{
		JFileChooser cvlink = new JFileChooser();
		//cvlink.setCurrentDirectory( new File( "." ) );
		int resultat = cvlink.showOpenDialog( this );
	
		if (resultat == JFileChooser.APPROVE_OPTION)
		{
			File cv = cvlink.getSelectedFile();
			return cv.getPath();
		}
		else
			return null;
	}
	
	public static void main( String[] args )
	{
		link vindu = new link();
		vindu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
	}
}
