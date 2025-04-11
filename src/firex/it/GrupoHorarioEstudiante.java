package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class GrupoHorarioEstudiante implements IsSerializable, Mapa
{
	String abreviado;
	String calificacion;
	ArrayList<String> claseAula;
	ArrayList<Long> claseDia;
	ArrayList<Long> claseHora;
	long creditos;
	String curso;
	String descripcion;
	String docente;
	String evaluacion;
	boolean global;
	String grupo;
	String claveMateria;
	String tipo;
	

	public GrupoHorarioEstudiante()
	{
		abreviado = "";
		calificacion = "";
		claseAula = new ArrayList<String>();
		claseDia = new ArrayList<Long>();
		claseHora = new ArrayList<Long>();
		creditos = 0;
		curso = "";
		descripcion = "";
		docente = "";
		evaluacion = "";
		global = false;
		grupo = "";
		claveMateria = "";
		tipo = "";
	}

	public GrupoHorarioEstudiante(Map<String, Object> data)
	{
		fromMap(data);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("abreviado", abreviado);
		m.put("calificacion", calificacion);
		m.put("claseAula", claseAula);
		m.put("claseDia", claseDia);
		m.put("claseHora", claseHora);
		m.put("creditos", creditos);
		m.put("curso", curso);
		m.put("descripcion", descripcion);
		m.put("docente", docente);
		m.put("evaluacion", evaluacion);
		m.put("global", global);
		m.put("grupo", grupo);
		m.put("claveMateria", claveMateria);
		m.put("tipo", tipo);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		abreviado = (String) m.get("abreviado");
		calificacion = (String) m.get("calificacion");
		claseAula = (ArrayList<String>) m.get("claseAula");
		claseDia = (ArrayList<Long>) m.get("claseDia");
		claseHora = (ArrayList<Long>) m.get("claseHora");
		creditos = (Long) m.get("creditos");
		curso = (String) m.get("curso");
		descripcion = (String) m.get("descripcion");
		docente = (String) m.get("docente");
		evaluacion = (String) m.get("evaluacion");
		global = (Boolean) m.get("global");
		grupo = (String) m.get("grupo");
		claveMateria = (String) m.get("claveMateria");
		tipo = (String) m.get("tipo");
	}

	public String getAbreviado()
	{
		return abreviado;
	}

	public void setAbreviado(String abreviado)
	{
		this.abreviado = abreviado;
	}

	public String getCalificacion()
	{
		return calificacion;
	}

	public void setCalificacion(String calificacion)
	{
		this.calificacion = calificacion;
	}

	public ArrayList<String> getClaseAula()
	{
		return claseAula;
	}

	public ArrayList<Long> getClaseDia()
	{
		return claseDia;
	}

	public ArrayList<Long> getClaseHora()
	{
		return claseHora;
	}

	public long getCreditos()
	{
		return creditos;
	}

	public void setCreditos(long creditos)
	{
		this.creditos = creditos;
	}

	public String getCurso()
	{
		return curso;
	}

	public void setCurso(String curso)
	{
		this.curso = curso;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getDocente()
	{
		return docente;
	}

	public void setDocente(String docente)
	{
		this.docente = docente;
	}

	public String getEvaluacion()
	{
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion)
	{
		this.evaluacion = evaluacion;
	}

	public boolean isGlobal()
	{
		return global;
	}

	public void setGlobal(boolean global)
	{
		this.global = global;
	}

	public String getGrupo()
	{
		return grupo;
	}

	public void setGrupo(String grupo)
	{
		this.grupo = grupo;
	}

	public String getClaveMateria()
	{
		return claveMateria;
	}

	public void setClaveMateria(String materia)
	{
		this.claveMateria = materia;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
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
