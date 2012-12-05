package br.com.videira.util;

import javax.swing.text.MaskFormatter;

public class Util {

	 public static MaskFormatter setMascara(String mascara){  
	      MaskFormatter mask = null;  
	      try{  
	         mask = new MaskFormatter(mascara);                    
	         }catch(java.text.ParseException ex){}  
	      return mask;  
	   }  

}
