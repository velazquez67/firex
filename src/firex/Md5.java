package firex;

import java.security.MessageDigest;

public class Md5 
{
	public static String encripta(String clave)
	{	try {	MessageDigest md = MessageDigest.getInstance("MD5");
      		byte[] b = md.digest(clave.getBytes());
      
      		int size = b.length;
      		StringBuffer h = new StringBuffer(size);
      		for (int i = 0; i < size; i++) 
      		  { int u = b[i] & 255;
      		    if (u < 16) 
      		      h.append("0" + Integer.toHexString(u));
      		    else 
      		      h.append(Integer.toHexString(u));		
      		  }
      		return h.toString();
	      } catch(Exception error)
	         { return "dfasASDFS2#$!..||#$SADCDS/%&/&%/DFDFSVDS$!SDADSSQ";
	         }
	}
	
	public static String encriptaQuebec(String clave)
	{
		try
			{
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] b = md.digest(clave.getBytes());

				int size = b.length;
				StringBuffer h = new StringBuffer(size);
				for (int i = 0; i < size; i++)
					{
						int u = b[i] & 255;
						if (u < 16)
							h.append("0" + Integer.toHexString(u));
						else
							h.append(Integer.toHexString(u));
					}						
				return h.toString().replaceFirst("a", "b");
			} catch (Exception error)
			{
				return "dfasASDFS2#$!..||#$SADCDS/%&/&%/DFDFSVDS$!SDADSSQ";
			}
	}
}