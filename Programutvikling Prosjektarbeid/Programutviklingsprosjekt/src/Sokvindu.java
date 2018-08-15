//Maha Laham s156169
//Julie Colle s146311

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window;

import javax.swing.*;

public class Sokvindu extends JFrame{
	
	private JButton jobbSok, sokerSok, giverSok;	
	
	public Sokvindu()
	{
		super ("Sokevinduet");
		
	    jobbSok = new JButton( "Søk" );
	    sokerSok = new JButton( "Søk" );
	    giverSok = new JButton( "Søk" );
	    
	    Container c = getContentPane();
	    c.setLayout( new FlowLayout() );
	    c.add( new JLabel( "Jobbsøk" ) );
	    c.add(jobbSok);
	    c.add( new JLabel( "Søkersøk" ) );
	    c.add(sokerSok);
	    c.add( new JLabel( "Arbeidsgiversøk" ) );
	    c.add(giverSok);
	    
	    Knappelytter lytter = new Knappelytter();
        jobbSok.addActionListener( lytter );
        sokerSok.addActionListener( lytter );
        giverSok.addActionListener( lytter );
        setSize( 200, 150 );
        setVisible( true );
	}
	
	public void nyJobbSok()
	{
		Jobbsokvindu j = new Jobbsokvindu(); 
	}
	
	public void nySokerSok()
	{
		Sokersokvindu s = new Sokersokvindu();
	}
	
	public void nyGiverSok()
	{
		Giversokvindu g = new Giversokvindu();
	}
	
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	      if ( e.getSource() == jobbSok )
	        nyJobbSok();
	      else if ( e.getSource() == sokerSok )
	        nySokerSok();
	      else if ( e.getSource() == giverSok )
	        nyGiverSok();
	    }
	  }

}