//Maha Laham s156169
//Julie Colle s146311

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Giversokvindu extends JFrame{
	
	
	private JTextField navnFelt;
	private JButton navnSok;
	private JTextArea utskriftomrade;
	private Giversok s = new Giversok();

	
	
	public Giversokvindu()
	{
		super ("Søkevindu");
		
	    navnFelt = new JTextField( 18 );
	    navnSok = new JButton( "Søk" );
	    
	    Container c = getContentPane();
	    c.setLayout( new FlowLayout() );
	    c.add( new JLabel( "Jobbsøk" ) );
	    c.add( navnFelt );
	    c.add(navnSok);
	    c.add( new JScrollPane( utskriftomrade ) );
	    
	    Knappelytter lytter = new Knappelytter();
        navnSok.addActionListener( lytter );
        setSize( 400, 80 );
        setVisible( true );
	}
	
	public void nyGiverSok()
	{
	  s.giverNavn();
	}
	
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	      if ( e.getSource() == navnSok )
	        nyGiverSok();
	    }
	  }

}