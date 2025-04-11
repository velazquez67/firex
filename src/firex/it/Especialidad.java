package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Especialidad implements IsSerializable
{
	String clave;
	String nombre;
	boolean vigente;
	Long numero;
	HashMap<String, Materia> materias;
	String claveOficial;
	String nombreCorto;
	Long creditos;
	String inicio;
	String fin;
	Long situacion;
	String clavePlan;

	public Especialidad()
	{
		materias = new HashMap<String, Materia>();
		numero = 0L;
		claveOficial = "";
		nombreCorto = "";
		creditos = 25L;
		inicio = "";
		fin = "";
		situacion = 1L;
		clavePlan = "";
	}

	@SuppressWarnings("unchecked")
	public Especialidad(Map<String, Object> m)
	{
		this();
		fromMap(m);
		materiasFromMap((Map<String, Object>) m.get("materias"));
	}

	public void fromMap(Map<String, Object> m)
	{
		clave = (String) m.get("clave");
		nombre = (String) m.get("nombre");
		vigente = (Boolean) m.get("vigente");
		numero = (Long) m.get("numero");
		claveOficial = (String) m.get("claveOficial");
		nombreCorto = (String) m.get("nombreCorto");
		inicio = (String) m.get("inicio");
		fin = (String) m.get("fin");
		situacion = (Long) m.get("situacion");
		clavePlan = (String) m.get("clavePlan");
	}

	@SuppressWarnings("unchecked")
	public void setMateriasDual(Map<String, Object> md)
	{
		Iterator<Object> i = md.values().iterator();
		Materia mat;
		while (i.hasNext())
		{
			mat = new Materia((Map<String, Object>) i.next());
			materias.put(mat.getClave(), mat);
		}
	}

	@SuppressWarnings("unchecked")
	public void materiasFromMap(Map<String, Object> m)
	{
		Materia mat;
		Map<String, Object> actual;
		String clave;
		Iterator<String> i = m.keySet().iterator();
		while (i.hasNext())
		{
			clave = i.next();
			actual = (Map<String, Object>) m.get(clave);
			mat = new Materia(actual);
			materias.put(mat.getClave(), mat);
		}
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("clave", clave);
		m.put("nombre", nombre);
		m.put("vigente", vigente);
		m.put("claveOficial", claveOficial);
		m.put("nombreCorto", nombreCorto);
		m.put("creditos", creditos);
		m.put("inicio", inicio);
		m.put("fin", fin);
		m.put("situacion", situacion);
		m.put("clavePlan", clavePlan);
		Map<String, Object> mats = new HashMap<String, Object>();
		Iterator<Materia> i = materias.values().iterator();
		Materia mat;
		while (i.hasNext())
		{
			mat = i.next();
			mats.put(mat.getClave(), mat.toMap());
		}
		m.put("materias", mats);
		return m;
	}

	public String getClavePlan()
	{
		return clavePlan;
	}

	public void setClavePlan(String clavePlan)
	{
		this.clavePlan = clavePlan;
	}

	public String getClaveOficial()
	{
		return claveOficial;
	}

	public void setClaveOficial(String claveOficial)
	{
		this.claveOficial = claveOficial;
	}

	public String getNombreCorto()
	{
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto)
	{
		this.nombreCorto = nombreCorto;
	}

	public long getCreditos()
	{
		return creditos;
	}

	public void setCreditos(long creditos)
	{
		this.creditos = creditos;
	}

	public String getInicio()
	{
		return inicio;
	}

	public void setInicio(String inicio)
	{
		this.inicio = inicio;
	}

	public String getFin()
	{
		return fin;
	}

	public void setFin(String fin)
	{
		this.fin = fin;
	}

	public long getSituacion()
	{
		return situacion;
	}

	public void setSituacion(long situacion)
	{
		this.situacion = situacion;
	}

	public long getNumero()
	{
		return numero;
	}

	public void setNumero(long numero)
	{
		this.numero = numero;
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

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public HashMap<String, Materia> getMaterias()
	{
		return materias;
	}

	public ArrayList<Materia> getMateriasOrdenadas()
	{
		TreeMap<String, Materia> mates = new TreeMap<String, Materia>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			mates.put(m.getAbreviado() + m.getClave(), m);
		}
		return new ArrayList<Materia>(mates.values());
	}

	public Materia getMateria(String clave)
	{
		Iterator<Materia> im = materias.values().iterator();
		Materia m;
		while (im.hasNext())
		{
			m = im.next();
			if (m.getClave().equals(clave))
				return m;
		}
		return null;
	}

	public boolean isVigente()
	{
		return vigente;
	}

	public void setVigente(boolean vigente)
	{
		this.vigente = vigente;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Especialidad))
			return false;
		Especialidad other = (Especialidad) obj;
		if (clave == null)
		{
			if (other.clave != null)
				return false;
		}
		else
			if (!clave.equals(other.clave))
				return false;
		return true;
	}

	public String toString()
	{
		return nombre + " [" + clave + "]";
	}
}
