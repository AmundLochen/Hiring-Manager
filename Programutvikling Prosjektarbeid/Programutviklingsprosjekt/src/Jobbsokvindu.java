//Maha Laham s156169
//Julie Colle s146311

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Jobbsokvindu extends JFrame{
	
	
	private JTextField navnFelt, firmaFelt, kategoriFelt,stedFelt;
	private JButton navnSok, firmaSok, kategoriSok, stedSok;
	private JTextArea utskriftomrade;
	private Jobbsok s = new Jobbsok();

	
	
	public Jobbsokvindu()
	{
		super ("S�kevindu");
		
	    navnFelt = new JTextField( 18 );
	    firmaFelt = new JTextField( 18 );
	    kategoriFelt = new JTextField( 18 );
	    stedFelt = new JTextField( 18 );
	    navnSok = new JButton( "S�k" );
	    firmaSok = new JButton( "S�k" );
	    kategoriSok = new JButton( "S�k" );
	    stedSok = new JButton( "S�k" );
	    
	    Container c = getContentPane();
	    c.setLayout( new FlowLayout() );
	    c.add( new JLabel( "Jobbs�k" ) );
	    c.add( navnFelt );
	    c.add(navnSok);
	    c.add( new JLabel( "Firmaok" ) );
	    c.add( firmaFelt );
	    c.add(firmaSok);
	    c.add( new JLabel( "Kategoris�k" ) );
	    c.add( kategoriFelt );
	    c.add(kategoriSok);
	    c.add( new JLabel( "Stedss�k" ) );
	    c.add( stedFelt );
	    c.add(stedSok);
	    c.add( new JScrollPane( utskriftomrade ) );
	    
	    Knappelytter lytter = new Knappelytter();
        navnSok.addActionListener( lytter );
        firmaSok.addActionListener( lytter );
        kategoriSok.addActionListener( lytter );
        stedSok.addActionListener( lytter );
        setSize( 400, 180 );
        setVisible( true );
	}
	
	public void nyJobbSok()
	{
	  s.ledigeNavn();
	}
	
	public void nyKatSok()
	{
	  s.ledigeKategori();
	}
	
	public void nyFirmaSok()
	{
	  s.ledigeFrima();
	}
	
	public void nyStedSok()
	{
	  s.ledigSted();
	}
	
	
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	      if ( e.getSource() == navnSok )
	        nyJobbSok();
	      else if ( e.getSource() == kategoriSok )
	        nyKatSok();
	      else if ( e.getSource() == firmaSok )
	        nyFirmaSok();
	      else if ( e.getSource() == stedSok )
		        nyStedSok();
	    }
	  }

}