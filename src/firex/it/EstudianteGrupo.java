package firex.it;

import java.util.Comparator;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class EstudianteGrupo implements Mapa, IsSerializable, Comparator<EstudianteGrupo>
{
	String calificacion;
	String control;
	String curso;
	String evaluacion;
	boolean global;
	String claveMateria;
	String nombre;
	String clavePlan;
	long semestre;

	public EstudianteGrupo()
	{
		calificacion = "";
		control = "";
		curso = "";
		evaluacion = "ORD";
		global = false;
		claveMateria = "";
		nombre = "";
		clavePlan = "";
		semestre = 0;
	}

	public EstudianteGrupo(Map<String, Object> data)
	{
		fromMap(data);
	}

	@Override
	public Map<String, Object> toMap()
	{// Map<String,Object> d = new HashMap<String,Object>();
		return null;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		calificacion = (String) m.get("calificacion");
		control = (String) m.get("control");
		curso = (String) m.get("curso");
		evaluacion = (String) m.get("evaluacion");
		global = (Boolean) m.get("global");
		claveMateria = (String) m.get("claveMateria");
		nombre = (String) m.get("nombre");
		clavePlan = (String) m.get("clavePlan");
		semestre = (Long) m.get("semestre");
	}

	public String getClaveMateria()
	{
		return claveMateria;
	}

	public String getClavePlanEstudios()
	{
		return clavePlan;
	}

	public String getControl()
	{
		return control;
	}

	public String getCurso()
	{
		return curso;
	}

	public String getEvaluacion()
	{
		return evaluacion;
	}

	public boolean isGlobal()
	{
		return global;
	}

	public String getNombre()
	{
		return nombre;
	}

	public long getSemestre()
	{
		return semestre;
	}

	public String getCalificacion()
	{
		return calificacion;
	}

	public void setCalificacion(String calificacion)
	{
		this.calificacion = calificacion;
	}

	public void setClaveMateria(String claveMateria)
	{
		this.claveMateria = claveMateria;
	}

	public String getClavePlan()
	{
		return clavePlan;
	}

	public void setClavePlan(String clavePlan)
	{
		this.clavePlan = clavePlan;
	}

	public void setControl(String control)
	{
		this.control = control;
	}

	public void setCurso(String curso)
	{
		this.curso = curso;
	}

	public void setEvaluacion(String evaluacion)
	{
		this.evaluacion = evaluacion;
	}

	public void setGlobal(boolean global)
	{
		this.global = global;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void setSemestre(long semestre)
	{
		this.semestre = semestre;
	}

	public String getCalificacionTexto()
	{
		String cal = getCalificacion();
		if (cal.equals(""))
			return "---";
		if (cal.equals("NA") || cal.equals("NP"))
			return cal;
		int c = getCalificacionNumero();
		if (c >= 94)
			return "EXCELENTE";
		if (c >= 86)
			return "NOTABLE";
		if (c >= 78)
			return "BUENO";
		if (c >= 70)
			return "SUFICIENTE";
		return "INSUFICIENTE";
	}

	public boolean estaCalificado()
	{
		return getCalificacion().length() > 0;
	}

	public boolean estaAprobado()
	{
		return getCalificacionNumero() >= 70;
	}

	public int getCalificacionNumero()
	{
		String c = getCalificacion().trim();
		if (c.equals("NA") || c.equals("NP"))
			return 0;
		try
		{
			return Integer.parseInt("0" + c);
		} catch (Exception error)
		{
		}
		return 0;
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

	@Override
	public int compare(EstudianteGrupo arg0, EstudianteGrupo arg1)
	{
		return arg0.nombre.compareTo(arg1.nombre);
	}
}
