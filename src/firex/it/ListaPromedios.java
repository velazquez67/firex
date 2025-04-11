package firex.it;

public class ListaPromedios {

  static public int promedio(int creditosAprobados, int prom)
  {
	  if(creditosAprobados>=200)         
      { if(creditosAprobados>=250)
    	  return 106;        
        if(creditosAprobados>=240)
          return 105;        
        if(creditosAprobados>=230)
          return 104;        
        if(creditosAprobados>=220)
          return 103;        
        if(creditosAprobados>=210)
          return 102;
        else
          return 101;
      }
	  return prom;
  }

}
