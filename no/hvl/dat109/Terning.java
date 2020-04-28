/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4607.2d2b84eb8 modeling language!*/

package no.hvl.dat109;
import java.util.Random;

/**
 * Klasse for ein terning
 * @author Stian Grønås
 */
// line 11 "../../../craps.ump"
public class Terning
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Terning Attributes
  private int verdi;
  private Random r;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Terning()
  {
    verdi = 0;
    resetR();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVerdi(int aVerdi)
  {
    boolean wasSet = false;
    verdi = aVerdi;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetDefaulted */
  public boolean setR(Random aR)
  {
    boolean wasSet = false;
    r = aR;
    wasSet = true;
    return wasSet;
  }

  public boolean resetR()
  {
    boolean wasReset = false;
    r = getDefaultR();
    wasReset = true;
    return wasReset;
  }

  /**
   * Variabel som held på verdien til terningen
   */
  public int getVerdi()
  {
    return verdi;
  }

  /**
   * Lagar ein ny random som blir brukt for å generere tilfeldige tal
   */
  public Random getR()
  {
    return r;
  }
  /* Code from template attribute_GetDefaulted */
  public Random getDefaultR()
  {
    return new Random();
  }

  public void delete()
  {}


  /**
   * Metoden set eit tilfeldig tal frå 1 til 6 på verdi-variabelen ved hjelp av Random-klassen
   */
  // line 24 "../../../craps.ump"
  public void trill(){
    setVerdi(r.nextInt(6) + 1);
  }


  public String toString()
  {
    return super.toString() + "["+
            "verdi" + ":" + getVerdi()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "r" + "=" + (getR() != null ? !getR().equals(this)  ? getR().toString().replaceAll("  ","    ") : "this" : "null");
  }
}