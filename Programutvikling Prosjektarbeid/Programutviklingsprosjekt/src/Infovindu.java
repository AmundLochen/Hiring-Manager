import java.awt.Container;

import javax.swing.*;

//starter klasse Infovindu.
public class Infovindu extends JFrame
{
	private JTextArea Informasjonsområde;
	
	//Oppretter et lite vindu til å vise et JTextArea.
	public Infovindu(JTextArea feltSomSendesMed)
	{
		super("Informasjonsvindu");
		Informasjonsområde = feltSomSendesMed;
		Informasjonsområde.setEditable(false);
		
		Container content = getContentPane();
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		content.add(p1);
		p1.add(new JScrollPane(Informasjonsområde));
		setSize(400, 400);
		setVisible(true);
	}
}// End of class Infovindu
