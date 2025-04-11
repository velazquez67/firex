package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Empleado implements Comparable<Empleado>, IsSerializable, Mapa
{

	String rfc;
	String paterno;
	String materno;
	String nombre;
	String departamento;
	boolean activo;
	String curp;
	boolean baja;
	String abreviaturaTitulo;
	String correoInstitucional;
	String apellidosNombre;
	long tarjeta;
	

	public Empleado()
	{
		rfc = "";
		paterno = "";
		materno = "";
		nombre = "";
		departamento = "";
		abreviaturaTitulo = "";
		curp = "xxxxxxxxxxHxxxxxxx";
		activo = true;
		tarjeta = 0;
		baja = false;
		correoInstitucional = "";
		apellidosNombre = "";
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rfc", rfc);
		m.put("paterno", paterno);
		m.put("materno", materno);
		m.put("nombre", nombre);
		m.put("apellidosNombre", apellidosNombre);
		m.put("departamento", departamento);
		m.put("abreviaturaTitulo", abreviaturaTitulo);
		m.put("curp", curp);
		m.put("activo", activo);
		m.put("tarjeta", tarjeta);
		m.put("baja", baja);
		m.put("correoInstitucional", correoInstitucional);
		ArrayList<String> palabras = new ArrayList<String>();
		String s, p[] = getApellidosNombre().trim().split(" ");
		for (int y = 0; y < p.length; y++)
			if (!p[y].equals("DE") && !p[y].equals("LA") && !p[y].equals("LOS") && !p[y].equals("DEL"))
			{
				palabras.add(p[y]);
				s = p[y].replace("�", "A").replace("�", "E").replace("�", "I").replace("�", "O").replace("�", "U");
				if (!p[y].equals(s))
					palabras.add(s);
			}
		if (nombre.contains(" "))
		{
			palabras.add(nombre);
			s = nombre.replace("�", "A").replace("�", "E").replace("�", "I").replace("�", "O").replace("�", "U");
			if (!nombre.equals(s))
				palabras.add(s);
		}
		m.put("palabras", palabras);
		return m;
	}

	public Empleado(Map<String, Object> datos)
	{
		fromMap(datos);
	}

	@Override
	public void fromMap(Map<String, Object> datos)
	{
		rfc = (String) datos.get("rfc");
		this.setPaterno((String) datos.get("paterno"));
		this.setMaterno((String) datos.get("materno"));
		this.setNombre((String) datos.get("nombre"));
		departamento = (String) datos.get("departamento");
		abreviaturaTitulo = (String) datos.get("abreviaturaTitulo");
		curp = (String) datos.get("curp");
		activo = (Boolean) datos.get("activo");
		tarjeta = (Long) datos.get("tarjeta");
		baja = (Boolean) datos.get("baja");
		correoInstitucional = (String) datos.get("correoInstitucional");
	}

	public String getCorreoInstitucional()
	{
		return correoInstitucional;
	}

	public void setCorreoInstitucional(String correoInstitucional)
	{
		this.correoInstitucional = correoInstitucional;
	}

	public String getAbreviaturaTitulo()
	{
		return abreviaturaTitulo;
	}

	public void setAbreviaturaTitulo(String abreviaturaTitulo)
	{
		this.abreviaturaTitulo = abreviaturaTitulo;
	}

	public long getTarjeta()
	{
		return tarjeta;
	}

	public void setTarjeta(long tarjeta)
	{
		this.tarjeta = tarjeta;
	}

	public boolean isBaja()
	{
		return baja;
	}

	public void setBaja(boolean baja)
	{
		this.baja = baja;
	}

	public String getCurp()
	{
		return curp;
	}

	public void setCurp(String curp)
	{
		this.curp = curp.trim().toUpperCase();
	}

	public char getGenero()
	{
		if (curp == null || curp.length() < 18)
			return 'H';
		return curp.charAt(10);
	}

	public boolean esHombre()
	{
		return getGenero() == 'H';
	}

	public int getEdad(int yearActual, int mesActual, int diaActual)
	{
		if (curp == null)
			return 0;
		try
		{
			int a = Integer.parseInt("" + curp.charAt(4) + curp.charAt(5));
			if (a < 50)
				a = (a + 2000) * 365;
			else
				a = (a + 1900) * 365;
			int m = Integer.parseInt("" + curp.charAt(6) + curp.charAt(7)) * 30;
			int d = Integer.parseInt("" + curp.charAt(8) + curp.charAt(9));
			int x = a + m + d;
			int y = yearActual * 365 + mesActual * 30 + diaActual;
			int z = y - x;
			return z / 365;
		} catch (Exception error)
		{
			return 0;
		}
	}

	public boolean isActivo()
	{
		return activo;
	}

	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}

	public String getCURP()
	{
		return curp;
	}

	public void setCURP(String curp)
	{
		this.curp = curp;
	}

	public String getRfc()
	{
		return rfc;
	}

	public void setRfc(String rfc)
	{
		this.rfc = rfc;
	}

	public String getPaterno()
	{
		return paterno;
	}

	public void setPaterno(String paterno)
	{
		this.paterno = paterno.trim().toUpperCase();
		this.apellidosNombre = paterno + ' ' + materno + ' ' + nombre;
	}

	public String getMaterno()
	{
		return materno.trim().toUpperCase();
	}

	public void setMaterno(String materno)
	{
		this.materno = materno.trim().toUpperCase();
		this.apellidosNombre = paterno + ' ' + materno + ' ' + nombre;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre.trim().toUpperCase();
		this.apellidosNombre = paterno + ' ' + materno + ' ' + nombre;
	}

	public String getNombreCompleto()
	{
		return nombre + ' ' + paterno + ' ' + materno;
	}

	public String getApellidosNombre()
	{
		return apellidosNombre;
	}

	@Override
	public int compareTo(Empleado emp)
	{
		return (toString().replace('�', 'A').replace('�', 'E').replace('�', 'I').replace('�', 'O').replace('�', 'U')
				.replace("�", "NZ"))
						.compareTo(emp.toString().replace('�', 'A').replace('�', 'E').replace('�', 'I').replace('�', 'O')
								.replace('�', 'U').replace("�", "NZ"));
	}

	public boolean equals(Object obj)
	{
		if (!(obj instanceof Empleado))
			return false;
		Empleado emp = (Empleado) obj;
		return rfc.equals(emp.rfc);
	}

	public String getDepartamento()
	{
		return departamento;
	}

	public void setDepartamento(String departamento)
	{
		this.departamento = departamento;
	}

	public String toString()
	{
		return apellidosNombre;
	}

	@Override
	public String gets(String campo)
	{
		return null;
	}

	@Override
	public Object get(String campo)
	{
		return null;
	}
}
