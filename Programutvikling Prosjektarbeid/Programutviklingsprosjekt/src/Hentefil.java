
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hentefil extends JFrame
{
  private JButton velg, vis, lagre;
  private JTextArea output;
  private String filsti = null;
  private Inputlytter lytter;
  private arbeidssokerliste arbs;

  public Hentefil(arbeidssokerliste ny)
  //Bruker får opp vindu for å hente frem lagrede CVer for å kunne vurdere om eieren passer i en stilling.
  {
    super( "CV-link" );
    arbs = ny;
    
    lytter = new Inputlytter();
    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    c.add( new JLabel( "Viser innhold av valgt CV. Må være .txt fil" ));
    velg = new JButton( "Velg CV" );
    lagre = new JButton("Lagre CV");
    velg.addActionListener( lytter );
    c.add( velg );
    
    vis = new JButton( "Vis fil" );
    vis.addActionListener( lytter );
    c.add( vis );
    c.add( lagre );
    output = new JTextArea( 20, 30 );
    output.setEditable( false );
    c.add( new JScrollPane( output ) );
    lagre.addActionListener(lytter);
    setSize( 600, 500 );
    setVisible( true );
  }

  public String velgFil()
  //Bruker velger CV. Sjekke om bruker trykker Cancel eller lukker vinduet.
  {
    JFileChooser filvelger = new JFileChooser();
    int resultat = filvelger.showOpenDialog( this );
    if ( resultat == JFileChooser.APPROVE_OPTION )
    {  
      File fil = filvelger.getSelectedFile();
      return fil.getPath();
    }
    else 
      return null;
  }
  
//Metode for å vise fil med tilsendt filnavn.
  public void visFil( String filnavn )
  {
    if ( filnavn == null )
    {
      JOptionPane.showMessageDialog( this, "Du må først velge CV!", "Advarsel",
                                     JOptionPane.WARNING_MESSAGE );
      return;
    }

    FileInputStream innfil; 

    try
    { 
      innfil = new FileInputStream( filnavn );
    }
    catch( FileNotFoundException e )
    {
      output.setText( "Finner ikke CV " + filnavn );
      return;
    }

    output.setText( "Innhold i CV " + filnavn + "\n" );
		
    int i;
    try
    {
      do
      {
        i = innfil.read(); 
        if ( i != -1 ) 
          output.append( String.valueOf( (char) i ) );
        arbeidssoker soker = arbs.getSisteSoker();
        soker.setCV(output.getText());
      } while ( i != -1 );
      
      innfil.close();
      output.setCaretPosition( 0 );
    }
    catch ( IOException ex )
    { 
      output.append( "Problemer med lesing fra CVen." );
    }
  }

 
  //Lytteklasse til knappene. Hindrer diverse exceptions med Try/Catch.
  private class Inputlytter implements ActionListener
  {
    public void actionPerformed( ActionEvent e )
    {
      if ( e.getSource() == velg )
        filsti = velgFil();
      else if ( e.getSource() == vis )
        visFil( filsti );
      else if (e.getSource() == lagre)
      {
	       arbeidssoker soker = arbs.getSisteSoker();
	       if (soker.getCV() != null)
	       {
    	  try {
				arbs.skrivData();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			setVisible(false);
			dispose();
	       }
	       else
	    	   JOptionPane.showMessageDialog(null, "Du må velge CV før du kan lagre.");
      }
    }
  }
}//End of class Hentefil.

