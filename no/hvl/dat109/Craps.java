/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4607.2d2b84eb8 modeling language!*/

package no.hvl.dat109;

/**
 * Klasse for Craps spelet
 * @author Stian Grønås
 */
// line 58 "../../../craps.ump"
public class Craps
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Craps Attributes
  private int rettVerdi;

  //Craps State Machines
  public enum State { Oppstart, Triller, Sjekk, Vunne, Tapt }
  private State state;

  //Craps Associations
  private Kopp kopp;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Craps(Kopp aKopp)
  {
    rettVerdi = 7;
    if (!setKopp(aKopp))
    {
      throw new RuntimeException("Unable to create Craps due to aKopp. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    setState(State.Oppstart);
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**
   * Den korrekte verdien ein må få for å vinne
   */
  public int getRettVerdi()
  {
    return rettVerdi;
  }

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  private boolean __autotransition1__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Oppstart:
        setState(State.Triller);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition2__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Triller:
        setState(State.Sjekk);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition3__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Sjekk:
        if (harVunne())
        {
          setState(State.Vunne);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition4__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Sjekk:
        if (!(harVunne()))
        {
          setState(State.Tapt);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case Oppstart:
        // line 70 "../../../craps.ump"
        System.out.println("Spelet starter");
        __autotransition1__();
        break;
      case Triller:
        // line 76 "../../../craps.ump"
        kopp.trillTerninger();
        __autotransition2__();
        break;
      case Sjekk:
        // line 82 "../../../craps.ump"
        System.out.println("Verdi på terningane: " + kopp.getSum());
        __autotransition3__();
        __autotransition4__();
        break;
      case Vunne:
        // line 90 "../../../craps.ump"
        System.out.println("Du har vunne");
        delete();
        break;
      case Tapt:
        // line 94 "../../../craps.ump"
        System.out.println("Du har tapt");
        delete();
        break;
    }
  }
  /* Code from template association_GetOne */
  public Kopp getKopp()
  {
    return kopp;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setKopp(Kopp aNewKopp)
  {
    boolean wasSet = false;
    if (aNewKopp != null)
    {
      kopp = aNewKopp;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    kopp = null;
  }


  /**
   * Metoden sjekkar om ein har vunne eller ikkje (koppen sin getSum() metode)
   * @return true om det er 7 (rettVerdi), false elles
   */
  // line 103 "../../../craps.ump"
  public Boolean harVunne(){
    return kopp.getSum() == getRettVerdi();
  }

  // line 107 "../../../craps.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new no.hvl.dat109.Craps.UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new no.hvl.dat109.Craps.UmpleExceptionHandler());
    Terning t1 = new Terning();
    Terning t2 = new Terning();
    Kopp kopp = new Kopp(t1, t2);
    Craps craps = new Craps(kopp);
    /*
    craps.triller();
    craps.sjekkerSum();
    craps.einVinn();
    craps.einTaper();
    */
  }


  public String toString()
  {
    return super.toString() + "["+
            "rettVerdi" + ":" + getRettVerdi()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "kopp = "+(getKopp()!=null?Integer.toHexString(System.identityHashCode(getKopp())):"null");
  }
  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler
  {
    public void uncaughtException(Thread t, Throwable e)
    {
      translate(e);
      if(e.getCause()!=null)
      {
        translate(e.getCause());
      }
      e.printStackTrace();
    }
    public void translate(Throwable e)
    {
      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();
      StackTraceElement[] elements = e.getStackTrace();
      try
      {
        for(StackTraceElement element:elements)
        {
          String className = element.getClassName();
          String methodName = element.getMethodName();
          boolean methodFound = false;
          int index = className.lastIndexOf('.')+1;
          try {
            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+"_"+methodName,new Class[]{});
            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});
            for(int i=0;i<sourceInformation.size();++i)
            {
              // To compensate for any offsets caused by injected code we need to loop through the other references to this function
              //  and adjust the start / length of the function.
              int functionStart = sourceInformation.getJavaLine(i) + (("main".equals(methodName))?3:1);
              int functionEnd = functionStart + sourceInformation.getLength(i);
              int afterInjectionLines = 0;
              //  We can leverage the fact that all inject statements are added to the uncaught exception list 
              //   before the functions that they are within
              for (int j = 0; j < i; j++) {
                if (sourceInformation.getJavaLine(j) - 1 >= functionStart &&
                    sourceInformation.getJavaLine(j) - 1 <= functionEnd &&
                    sourceInformation.getJavaLine(j) - 1 <= element.getLineNumber()) {
                    // A before injection, +2 for the comments surrounding the injected code
                    if (sourceInformation.getJavaLine(j) - 1 == functionStart) {
                        functionStart += sourceInformation.getLength(j) + 2;
                        functionEnd += sourceInformation.getLength(j) + 2;
                    } else {
                        // An after injection
                        afterInjectionLines += sourceInformation.getLength(j) + 2;
                        functionEnd += sourceInformation.getLength(j) + 2;
                    }
                }
              }
              int distanceFromStart = element.getLineNumber() - functionStart - afterInjectionLines;
              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))
              {
                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));
                methodFound = true;
                break;
              }
            }
          }
          catch (Exception e2){}
          if(!methodFound)
          {
            result.add(element);
          }
        }
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
      }
      e.setStackTrace(result.toArray(new StackTraceElement[0]));
    }
  //The following methods Map Java lines back to their original Umple file / line    
    public UmpleSourceData Terning_trill(){ return new UmpleSourceData().setFileNames("craps.ump").setUmpleLines(23).setJavaLines(89).setLengths(1);}
    public UmpleSourceData Kopp_trillTerninger(){ return new UmpleSourceData().setFileNames("craps.ump").setUmpleLines(39).setJavaLines(138).setLengths(8);}
    public UmpleSourceData Craps___autotransition4__(){ return new UmpleSourceData().setFileNames("craps.ump").setUmpleLines(85).setJavaLines(132).setLengths(1);}
    public UmpleSourceData Craps_setState(){ return new UmpleSourceData().setFileNames("craps.ump","craps.ump","craps.ump","craps.ump","craps.ump").setUmpleLines(69, 75, 81, 89, 93).setJavaLines(154, 159, 164, 170, 175).setLengths(1, 1, 1, 1, 1);}
    public UmpleSourceData Craps_main(){ return new UmpleSourceData().setFileNames("craps.ump").setUmpleLines(106).setJavaLines(212).setLengths(10);}
    public UmpleSourceData Craps___autotransition3__(){ return new UmpleSourceData().setFileNames("craps.ump").setUmpleLines(83).setJavaLines(110).setLengths(1);}
    public UmpleSourceData Craps_harVunne(){ return new UmpleSourceData().setFileNames("craps.ump").setUmpleLines(102).setJavaLines(207).setLengths(1);}

  }
  public static class UmpleSourceData
  {
    String[] umpleFileNames;
    Integer[] umpleLines;
    Integer[] umpleJavaLines;
    Integer[] umpleLengths;
    
    public UmpleSourceData(){
    }
    public String getFileName(int i){
      return umpleFileNames[i];
    }
    public Integer getUmpleLine(int i){
      return umpleLines[i];
    }
    public Integer getJavaLine(int i){
      return umpleJavaLines[i];
    }
    public Integer getLength(int i){
      return umpleLengths[i];
    }
    public UmpleSourceData setFileNames(String... filenames){
      umpleFileNames = filenames;
      return this;
    }
    public UmpleSourceData setUmpleLines(Integer... umplelines){
      umpleLines = umplelines;
      return this;
    }
    public UmpleSourceData setJavaLines(Integer... javalines){
      umpleJavaLines = javalines;
      return this;
    }
    public UmpleSourceData setLengths(Integer... lengths){
      umpleLengths = lengths;
      return this;
    }
    public int size(){
      return umpleFileNames.length;
    }
  }
}