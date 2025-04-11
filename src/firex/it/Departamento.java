package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Departamento implements Comparable<Departamento>, IsSerializable, Mapa
{
	String clave;
	String nombre;
	String cargo;
	Empleado _jefe;
	String extTelefono;
	String correo;
	String nombreCorto;
	String claveTecNM;

	public Departamento()
	{
		clave = "";
		nombre = "";
		cargo = "";
		_jefe = null;
		extTelefono = "";
		correo = "";
		claveTecNM = "";
		nombreCorto = "";
	}

	public Departamento(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("tipo", "departamento");
		m.put("clave", clave);
		m.put("nombre", nombre);
		m.put("cargo", cargo);
		m.put("_jefe", _jefe.toMap());
		m.put("extTelefono", extTelefono);
		m.put("correo", correo);
		m.put("claveTecNM", claveTecNM);
		m.put("nombreCorto", nombreCorto);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		clave = (String) m.get("clave");
		nombre = (String) m.get("nombre");
		cargo = (String) m.get("cargo");
		if (m.get("_jefe") != null)
			_jefe = new Empleado((Map<String, Object>) m.get("_jefe"));
		extTelefono = (String) m.get("extTelefono");
		correo = (String) m.get("correo");
		claveTecNM = (String) m.get("claveTecNM");
		nombreCorto = (String) m.get("nombreCorto");
	}

	public String getNombreCorto()
	{
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto)
	{
		this.nombreCorto = nombreCorto;
	}

	public String getClaveTecNM()
	{
		return claveTecNM;
	}

	public void setClaveTecNM(String claveTecNM)
	{
		this.claveTecNM = claveTecNM;
	}

	public String getExtTelefono()
	{
		return extTelefono;
	}

	public void setExtTelefono(String extTelefono)
	{
		this.extTelefono = extTelefono;
	}

	public String getCorreo()
	{
		return correo;
	}

	public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	public String getCargo()
	{
		return cargo;
	}

	public void setCargo(String cargo)
	{
		this.cargo = cargo;
	}

	public String getClave()
	{
		return clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
	}

	public String getNombre()
	{
		return nombre;
	}

	public String getNombreAbreviado()
	{
		return nombre.replace("DEPARTAMENTO", "DEPTO.");
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Empleado getJefe()
	{
		return _jefe;
	}

	public void setJefe(Empleado e)
	{
		this._jefe = e;
	}

	public boolean equals(Object obj)
	{
		if (!(obj instanceof Departamento))
			return false;
		Departamento d = (Departamento) obj;
		return clave.equals(d.clave);
	}

	public String toString()
	{
		return this.nombre;
	}

	@Override
	public int compareTo(Departamento o)
	{
		return this.nombre.compareTo(o.toString());
	}

	@Override
	public String gets(String campo)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String campo)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
