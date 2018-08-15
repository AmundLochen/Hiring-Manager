//Skrevet av Amund Løchen s169999
import java.util.Calendar;
import java.text.SimpleDateFormat;

//Klasse for å finne eksakt dato og klokkeslett.
public class DateUtils {
  public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

  //Metoden skaffer en string som inneholder eksakt dato og klokkeslett.
  public static String now() 
  {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());
  }
}// End of class DateUtils.

