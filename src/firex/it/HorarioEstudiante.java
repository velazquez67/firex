package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;
import firex.Estaticos;

public class HorarioEstudiante implements IsSerializable, Mapa
{
	String control;
	String carrera;
	String clavePlan;
	String especialidad;
	String nombre;
	String periodo;
	long semestre;
	boolean validado;
	String idGrupo;
	ArrayList<GrupoHorarioEstudiante> grupos;
	boolean tieneQueEvaluarDocente;
	// ignore
	int creditosAsignados;
	boolean esResidente;
	

	public HorarioEstudiante()
	{
		control = "";
		carrera = "";
		clavePlan = "";
		especialidad = "";
		nombre = "";
		periodo = "";
		semestre = 0;
		idGrupo = "";
		validado = false;
		grupos = new ArrayList<GrupoHorarioEstudiante>();
		tieneQueEvaluarDocente = false;
		creditosAsignados = 0;
		esResidente = false;
	}

	public HorarioEstudiante(Map<String, Object> data)
	{
		fromMap(data);
	}

	public boolean esResidente()
	{
		return this.esResidente;
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("control", control);
		m.put("carrera", carrera);
		m.put("clavePlan", clavePlan);
		m.put("especialidad", especialidad);
		m.put("nombre", nombre);
		m.put("periodo", periodo);
		m.put("semestre", semestre);
		m.put("validado", validado);
		m.put("idGrupo", idGrupo);
		GrupoHorarioEstudiante aux;
		for (int x = 0; x < grupos.size(); x++)
		{
			aux = grupos.get(x);
			m.put("#" + aux.getClaveMateria(), aux.toMap());
		}
		return m;
	}

	public int getCreditosAsignados()
	{
		return creditosAsignados;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		control = (String) m.get("control");
		carrera = (String) m.get("carrera");
		clavePlan = (String) m.get("clavePlan");
		especialidad = (String) m.get("especialidad");
		nombre = (String) m.get("nombre");
		periodo = (String) m.get("periodo");
		semestre = (Long) m.get("semestre");
		validado = (Boolean) m.get("validado");
		idGrupo = (String) m.get("idGrupo");
		Iterator<String> i = m.keySet().iterator();
		String campo;
		tieneQueEvaluarDocente = false;
		grupos = new ArrayList<GrupoHorarioEstudiante>();
		GrupoHorarioEstudiante ghe;
		String aux;
		while (i.hasNext())
		{
			campo = i.next();
			if (campo.charAt(0) == '#')
			{
				ghe = new GrupoHorarioEstudiante((Map<String, Object>) m.get(campo));
				grupos.add(ghe);
				aux = ghe.getClaveMateria();
				if (!(aux.equals(Estaticos.RESIDENCIA) || aux.equals(Estaticos.SERVICIO_SOCIAL)
						|| aux.equals(Estaticos.TUTORIA1) || aux.equals(Estaticos.TUTORIA2)
						|| aux.equals(Estaticos.ACTIVIDAD_CULTURAL) || aux.equals(Estaticos.ACTIVIDAD_DEPORTIVA)))
					tieneQueEvaluarDocente = true;
				creditosAsignados += ghe.getCreditos();
				if (aux.equals(Estaticos.RESIDENCIA))
					esResidente = true;
			}
		}
	}

	public boolean isTieneQueEvaluarDocente()
	{
		return tieneQueEvaluarDocente;
	}

	public String getIdGrupo()
	{
		return idGrupo;
	}

	public void setIdGrupo(String idGrupo)
	{
		this.idGrupo = idGrupo;
	}

	public String getControl()
	{
		return control;
	}

	public void setControl(String control)
	{
		this.control = control;
	}

	public String getCarrera()
	{
		return carrera;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera;
	}

	public String getClavePlan()
	{
		return clavePlan;
	}

	public void setClavePlan(String clavePlan)
	{
		this.clavePlan = clavePlan;
	}

	public String getEspecialidad()
	{
		return especialidad;
	}

	public void setEspecialidad(String especialidad)
	{
		this.especialidad = especialidad;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getPeriodo()
	{
		return periodo;
	}

	public void setPeriodo(String periodo)
	{
		this.periodo = periodo;
	}

	public long getSemestre()
	{
		return semestre;
	}

	public void setSemestre(long semestre)
	{
		this.semestre = semestre;
	}

	public boolean isValidado()
	{
		return validado;
	}

	public void setValidado(boolean validado)
	{
		this.validado = validado;
	}

	public ArrayList<GrupoHorarioEstudiante> getGrupos()
	{
		return grupos;
	}

	public GrupoHorarioEstudiante getGrupo(String claveMateria)
	{
		ArrayList<GrupoHorarioEstudiante> gpos = getGrupos();
		for (int x = 0; x < gpos.size(); x++)
			if (gpos.get(x).getClaveMateria().equals(claveMateria))
				return gpos.get(x);
		return null;
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
