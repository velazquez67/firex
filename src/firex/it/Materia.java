package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Materia implements IsSerializable, Mapa
{
	 String clave;
	 String nombre;
	 String abreviado;
	 String claveOficial;
	 long creditos;
	 long semestre;
	 long horasTeoricas;
	 long horasPractica;
	 long creditosRequeridos;
	 long ordenCertificado;
	 String claveDepartamento;
	 ArrayList<String> requisitos;
	 long porcentajeEspacioLetrasCertificado;

	public Materia()
	{
		clave = "";
		nombre = "";
		abreviado = "";
		claveOficial = "";
		creditos = 0;
		semestre = 1;
		horasTeoricas = 0;
		horasPractica = 0;
		creditosRequeridos = 0;
		ordenCertificado = 0;
		claveDepartamento = "";
		requisitos = new ArrayList<String>();
		porcentajeEspacioLetrasCertificado = 100;
	}

	public Materia(Map<String, Object> m)
	{
		this();
		fromMap(m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		clave = (String) m.get("clave");
		nombre = (String) m.get("nombre");
		abreviado = (String) m.get("abreviado");
		claveOficial = (String) m.get("claveOficial");
		creditos = (Long) m.get("creditos");
		semestre = (Long) m.get("semestre");
		horasTeoricas = (Long) m.get("horasTeoricas");
		horasPractica = (Long) m.get("horasPractica");
		creditosRequeridos = (Long) m.get("creditosRequeridos");
		ordenCertificado = (Long) m.get("ordenCertificado");
		claveDepartamento = (String) m.get("claveDepartamento");
		requisitos = (ArrayList<String>) m.get("requisitos");
		if(requisitos==null)
			requisitos = new ArrayList<String>();
		porcentajeEspacioLetrasCertificado = (Long) m.get("porcentajeEspacioLetrasCertificado");
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("tipo", "normal");
		m.put("clave", clave);
		m.put("nombre", nombre);
		m.put("abreviado", abreviado);
		m.put("claveOficial", claveOficial);
		m.put("creditos", creditos);
		m.put("semestre", semestre);
		m.put("horasTeoricas", horasTeoricas);
		m.put("horasPractica", horasPractica);
		m.put("creditosRequeridos", creditosRequeridos);
		m.put("ordenCertificado", ordenCertificado);
		m.put("claveDepartamento", claveDepartamento);
		m.put("requisitos", requisitos);
		m.put("porcentajeEspacioLetrasCertificado", porcentajeEspacioLetrasCertificado);
		return m;
	}

	public Materia(String clavePlan, String clave)
	{
		this();
		this.clave = clave.trim();
	}

	public Materia(String clavePlan, String claveEspecialidad, String clave)
	{
		this();
		this.clave = clave.trim();
	}

	public long getPorcentajeEspacioLetrasCertificado()
	{
		return porcentajeEspacioLetrasCertificado;
	}

	public void setPorcentajeEspacioLetrasCertificado(long porcentajeEspacioLetrasCertificado)
	{
		this.porcentajeEspacioLetrasCertificado = porcentajeEspacioLetrasCertificado;
	}

	public String getClave()
	{
		return clave;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre.trim();
	}

	public String getAbreviado()
	{
		return abreviado;
	}

	public void setAbreviado(String abreviado)
	{
		this.abreviado = abreviado.trim();
	}

	public long getSemestre()
	{
		return semestre;
	}

	public void setSemestre(long semestre)
	{
		this.semestre = semestre;
	}

	public long getHorasPractica()
	{
		return horasPractica;
	}

	public void setHorasPractica(long horasPractica)
	{
		this.horasPractica = horasPractica;
	}

	public ArrayList<String> getRequisitos()
	{
		if (requisitos == null)
			requisitos = new ArrayList<String>();
		return requisitos;
	}

	public long getHorasTeoricas()
	{
		return horasTeoricas;
	}

	public void setHorasTeoricas(long horasTeoricas)
	{
		this.horasTeoricas = horasTeoricas;
	}

	public long getCreditosRequeridos()
	{
		return creditosRequeridos;
	}

	public void setCreditosRequeridos(long creditosRequeridos)
	{
		this.creditosRequeridos = creditosRequeridos;
	}

	public long getOrdenCertificado()
	{
		return ordenCertificado;
	}

	public void setOrdenCertificado(long ordenCertificado)
	{
		this.ordenCertificado = ordenCertificado;
	}

	public String getClaveDepartamento()
	{
		return claveDepartamento;
	}

	public void setClaveDepartamento(String claveDepartamento)
	{
		this.claveDepartamento = claveDepartamento;
	}

	public String getClaveOficial()
	{
		return claveOficial;
	}

	public void setClaveOficial(String claveOficial)
	{
		this.claveOficial = claveOficial.trim();
	}

	public long getCreditos()
	{
		return creditos;
	}

	public void setCreditos(long creditos)
	{
		this.creditos = creditos;
	}

	public long getTotalHoras()
	{
		return horasPractica + horasTeoricas;
	}

	@Override
	public String toString()
	{
		return abreviado + " [" + clave + "]";
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
