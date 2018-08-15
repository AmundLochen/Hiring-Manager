import java.awt.Container;

import javax.swing.*;

//starter klasse Infovindu.
public class Infovindu extends JFrame
{
	private JTextArea Informasjonsomr�de;
	
	//Oppretter et lite vindu til � vise et JTextArea.
	public Infovindu(JTextArea feltSomSendesMed)
	{
		super("Informasjonsvindu");
		Informasjonsomr�de = feltSomSendesMed;
		Informasjonsomr�de.setEditable(false);
		
		Container content = getContentPane();
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		content.add(p1);
		p1.add(new JScrollPane(Informasjonsomr�de));
		setSize(400, 400);
		setVisible(true);
	}
}// End of class Infovindu
