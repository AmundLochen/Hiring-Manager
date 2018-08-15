
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Sokersokvindu extends JFrame{
	
	
	private JTextField navnFelt, adresseFelt;
	private JButton navnSok, adresseSok;
	private JTextArea utskriftomrade;
	private Sokersok s = new Sokersok();

	
	
	public Sokersokvindu()
	{
		super ("S�kevindu");
		
	    navnFelt = new JTextField( 18 );
	    adresseFelt = new JTextField( 18 );
	    navnSok = new JButton( "S�k" );
	    adresseSok = new JButton( "S�k" );
	    
	    Container c = getContentPane();
	    c.setLayout( new FlowLayout() );
	    c.add( new JLabel( "Jobbs�k" ) );
	    c.add( navnFelt );
	    c.add(navnSok);
	    c.add( new JLabel( "Firmas�k" ) );
	    c.add( adresseFelt );
	    c.add(adresseSok);
	    c.add( new JScrollPane( utskriftomrade ) );
	    
	    Knappelytter lytter = new Knappelytter();
        navnSok.addActionListener( lytter );
        adresseSok.addActionListener( lytter );
        setSize( 400, 120 );
        setVisible( true );
	}
	
	public void nySokerSok()
	{
	  s.sokerNavn();
	}
	
	public void nyAdrSok()
	{
	  s.sokerAdresse();
	}
	
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	      if ( e.getSource() == navnSok )
	        nySokerSok();
	      else if ( e.getSource() == adresseSok )
	        nyAdrSok();
	    }
	  }

}
