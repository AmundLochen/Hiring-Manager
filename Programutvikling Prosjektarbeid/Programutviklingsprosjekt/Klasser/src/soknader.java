// Julie Colle s146311
//import java.util.Date;

public class soknader 
{
	private int soknadsID;
	private int sokerID;
	private int jobbID;
	//private date dato; usikker på hva vi skal gjøre med dato. Vi kan bruke String istedet.
	
	public soknader (int soknad, int soker, int jobb)
	{
		soknadsID = soknad;
		sokerID = soker;
		jobbID = jobb;
	}
	
	public int getSoknadsID()
	{
		return soknadsID;
	}
	
	public int getSokerID()
	{
		return sokerID;
	}
	
	public int getJobbID()
	{
		return jobbID;
	}
}

