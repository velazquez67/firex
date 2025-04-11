package firex.it;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import com.google.gwt.user.client.rpc.IsSerializable;

public class PlanEstudios implements Comparable<PlanEstudios>, IsSerializable, Mapa
{
	String clave;
	String nombre;
	String abreviado;
	String siglaCarrera;
	private TreeMap<String, Especialidad> especialidades;
	private TreeMap<String, Materia> materias;
	private long cargaMinima;
	private long cargaMaxima;
	private long totalCreditos;
	private String nivelEscolar;
	private boolean competencias;
	private String claveSubes;
	private String fechaInicio;
	private String fechaTermino;
	private long situacion;
	private String claveDeptoAcademico;
	private String nombreCorto;
	private long numeroPlan;
	private long creditosEspecialidad;

	public PlanEstudios()
	{
		materias = new TreeMap<String, Materia>();
		especialidades = new TreeMap<String, Especialidad>();
		clave = "";
		abreviado = "";
		nombre = "";
		competencias = true;
		claveSubes = "";
		fechaInicio = "";
		fechaTermino = "";
		situacion = 0;
		claveDeptoAcademico = "";
		nombreCorto = "";
		numeroPlan = 0;
		creditosEspecialidad = 0;
		cargaMinima = 0;
		cargaMaxima = 36;
		totalCreditos = 0;
		nivelEscolar = "";
		siglaCarrera = "";
	}

	public PlanEstudios(Map<String, Object> m)
	{
		this();
		fromMap(m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		clave = (String) m.get("clave");
		abreviado = (String) m.get("abreviado");
		nombre = (String) m.get("nombre");
		competencias = (Boolean) m.get("competencias");
		claveSubes = (String) m.get("claveSubes");
		fechaInicio = (String) m.get("fechaInicio");
		fechaTermino = (String) m.get("fechaTermino");
		situacion = (Long) m.get("situacion");
		claveDeptoAcademico = (String) m.get("claveDeptoAcademico");
		nombreCorto = (String) m.get("nombreCorto");
		numeroPlan = (Long) m.get("numeroPlan");
		creditosEspecialidad = (Long) m.get("creditosEspecialidad");
		cargaMaxima = (Long) m.get("cargaMaxima");
		cargaMinima = (Long) m.get("cargaMinima");
		totalCreditos = (Long) m.get("totalCreditos");
		nivelEscolar = (String) m.get("nivelEscolar");
		siglaCarrera = (String) m.get("siglaCarrera");
		materiasFromMap((Map<String, Object>) m.get("materias"));
		especialidadesFromMap((Map<String, Object>) m.get("especialidades"));
	}

	@SuppressWarnings("unchecked")
	public void especialidadesFromMap(Map<String, Object> m)
	{
		Especialidad esp;
		Iterator<Object> esps = m.values().iterator();
		Map<String, Object> aux;
		while (esps.hasNext())
		{
			aux = (Map<String, Object>) esps.next();
			esp = new Especialidad(aux);
			especialidades.put(esp.getClave(), esp);
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
			switch ((String) actual.get("tipo"))
			{
			case "normal":
				mat = new Materia(actual);
				break;
			case "academica":
				mat = new MateriaAcademica(actual);
				break;
			case "residencia":
				mat = new MateriaResidencia(actual);
				break;
			case "tutoria":
				mat = new MateriaTutoria(actual);
				break;
			case "extraescolar":
				mat = new MateriaExtraescolar(actual);
				break;
			case "servicioSocial":
				mat = new MateriaServicioSocial(actual);
				break;
			default:
				mat = new Materia(actual);
			}
			materias.put(mat.getClave(), mat);
		}
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("clave", clave);
		m.put("abreviado", abreviado);
		m.put("nombre", nombre);
		m.put("competencias", competencias);
		m.put("claveSubes", claveSubes);
		m.put("fechaInicio", fechaInicio);
		m.put("fechaTermino", fechaTermino);
		m.put("situacion", situacion);
		m.put("claveDeptoAcademico", claveDeptoAcademico);
		m.put("nombreCorto", nombreCorto);
		m.put("numeroPlan", numeroPlan);
		m.put("creditosEspecialidad", creditosEspecialidad);
		m.put("cargaMaxima", cargaMaxima);
		m.put("cargaMinima", cargaMinima);
		m.put("totalCreditos", totalCreditos);
		m.put("nivelEscolar", nivelEscolar);
		m.put("siglaCarrera", siglaCarrera);
		m.put("materias", toMapMaterias());
		m.put("especialidades", toMapEspecialidades());
		return m;
	}

	public Map<String, Object> toMapMaterias()
	{
		Map<String, Object> mats = new HashMap<String, Object>();
		Iterator<Materia> i = materias.values().iterator();
		Materia mat;
		while (i.hasNext())
		{
			mat = i.next();
			mats.put(mat.getClave(), mat.toMap());
		}
		return mats;
	}

	public Map<String, Object> toMapEspecialidades()
	{
		Map<String, Object> espes = new HashMap<String, Object>();
		Iterator<Especialidad> i = especialidades.values().iterator();
		Especialidad esp;
		while (i.hasNext())
		{
			esp = i.next();
			espes.put(esp.getClave(), esp.toMap());
		}
		return espes;
	}

	public long getCreditosEspecialidad()
	{
		return creditosEspecialidad;
	}

	public void setCreditosEspecialidad(long creditosEspecialidad)
	{
		this.creditosEspecialidad = creditosEspecialidad;
	}

	public long getNumeroPlan()
	{
		return numeroPlan;
	}

	public void setNumeroPlan(long numeroPlan)
	{
		this.numeroPlan = numeroPlan;
	}

	public String getNombreCorto()
	{
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto)
	{
		this.nombreCorto = nombreCorto;
	}

	public String claveCarrera()
	{
		return siglaCarrera;
	}

	public long numeroNivel()
	{
		switch (nivelEscolar)
		{
		case "L":
			return 11;
		case "M":
			return 13;
		case "D":
			return 14;
		}
		return 11;
	}

	public long modalidad()
	{
		switch ((int) numeroNivel())
		{
		case 11:
			return 1; // licenciatura
		case 13:
			return 2; // maestria
		case 14:
			return 4; // doctorado
		}
		return 3; // especializacion
	}

	public String getFechaInicio()
	{
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTermino()
	{
		return fechaTermino;
	}

	public void setFechaTermino(String fechaTermino)
	{
		this.fechaTermino = fechaTermino;
	}

	public long getSituacion()
	{
		return situacion;
	}

	public void setSituacion(long situacion)
	{
		this.situacion = situacion;
	}

	public void setMaterias(TreeMap<String, Materia> materias)
	{
		this.materias = materias;
	}

	public String getClaveSubes()
	{
		return claveSubes;
	}

	public void setClaveSubes(String claveSubes)
	{
		this.claveSubes = claveSubes;
	}

	public boolean isFichas()
	{
		return this.getNivelEscolar().equals("L") && this.situacion==1;
	}

	public MateriaResidencia getMateriaResidencia()
	{
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			if (m instanceof MateriaResidencia)
				return (MateriaResidencia) m;
		}
		return null;
	}

	public MateriaServicioSocial getMateriaServicioSocial()
	{
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			if (m instanceof MateriaServicioSocial)
				return (MateriaServicioSocial) m;
		}
		return null;
	}

	public HashMap<String, Materia> getMateriasAcademicas()
	{
		HashMap<String, Materia> aux = new HashMap<String, Materia>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			if (m instanceof MateriaAcademica)
				aux.put(m.getClave(), m);
		}
		return aux;
	}

	public HashMap<String, Materia> getMateriasExtraescolaresNoAcademica()
	{
		HashMap<String, Materia> aux = new HashMap<String, Materia>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			if (m instanceof MateriaExtraescolar && !(m instanceof MateriaAcademica))
				aux.put(m.getClave(), m);
		}
		return aux;
	}

	public HashMap<String, Materia> getMateriasExtraescolares()
	{
		HashMap<String, Materia> aux = new HashMap<String, Materia>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			if (m instanceof MateriaExtraescolar)
				aux.put(m.getClave(), m);
		}
		return aux;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getAbreviado()
	{
		return abreviado;
	}

	public void setAbreviado(String abreviado)
	{
		this.abreviado = abreviado;
	}

	public String getSiglaCarrera()
	{
		return siglaCarrera;
	}

	public void setSiglaCarrera(String siglaCarrera)
	{
		this.siglaCarrera = siglaCarrera;
	}

	public String getNivelEscolar()
	{
		return nivelEscolar;
	}

	public void setNivelEscolar(String nivelEscolar)
	{
		this.nivelEscolar = nivelEscolar;
	}

	public void setCompetencias(boolean b)
	{
		competencias = b;
	}

	public boolean esPorCompetencias()
	{
		return competencias;
	}

	public Materia getMateriaPlan(String clave)
	{
		Materia m = materias.get(clave);
		if (m != null)
			return m;
		return null;
	}

	public Materia getMateria(String clave)
	{
		Materia m = materias.get(clave);
		if (m != null)
			return m;
		Iterator<Especialidad> ie = especialidades.values().iterator();
		Especialidad e;
		while (ie.hasNext())
		{
			e = ie.next();
			m = e.getMateria(clave);
			if (m != null)
				return m;
		}
		return null;
	}

	public void setClave(String c)
	{
		clave = c;
	}

	public String getClave()
	{
		return clave;
	}

	public TreeMap<String, Materia> getMaterias()
	{
		return materias;
	}

	public HashMap<String, Materia> getTodasMaterias()
	{
		Iterator<Materia> i = materias.values().iterator();
		TreeMap<String, Materia> result = new TreeMap<String, Materia>();
		Materia mat;
		while (i.hasNext())
		{
			mat = i.next();
			result.put(mat.getNombre() + mat.getClave(), mat);
		}
		Especialidad e;
		Iterator<Especialidad> ie = especialidades.values().iterator();
		while (ie.hasNext())
		{
			e = ie.next();
			i = e.getMaterias().values().iterator();
			while (i.hasNext())
			{
				mat = i.next();
				result.put(mat.getNombre() + mat.getClave(), mat);
			}
		}
		HashMap<String, Materia> mates = new HashMap<String, Materia>();
		i = result.values().iterator();
		while (i.hasNext())
		{
			mat = i.next();
			mates.put(mat.getClave(), mat);
		}
		return mates;
	}

	public TreeMap<String, Materia> getMateriasYEspecialidad(String claveEspecialidad)
	{
		TreeMap<String, Materia> mates = new TreeMap<String, Materia>();
		mates.putAll(materias);
		if (claveEspecialidad == null || claveEspecialidad.length() == 0)
			return mates;
		Especialidad e = especialidades.get(claveEspecialidad);
		if (e == null)
			return mates;
		mates.putAll(e.getMaterias());
		return mates;
	}

	public HashMap<String, Materia> getMateriasOrdenadas()
	{
		TreeMap<String, Materia> mates = new TreeMap<String, Materia>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			mates.put(m.getAbreviado() + m.getClave(), m);
		}
		HashMap<String, Materia> aux = new HashMap<String, Materia>();
		Iterator<Materia> ii = mates.values().iterator();
		while (ii.hasNext())
		{
			m = ii.next();
			aux.put(m.getClave(), m);
		}
		return aux;
	}

	public HashMap<String, Materia> getMateriasOrdenadas(String claveEspecialidad)
	{
		TreeMap<String, Materia> mates = new TreeMap<String, Materia>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			mates.put(m.getAbreviado() + m.getClave(), m);
		}
		Especialidad esp = this.getEspecialidad(claveEspecialidad);
		if (esp != null)
		{
			i = esp.getMaterias().values().iterator();
			while (i.hasNext())
			{
				m = i.next();
				mates.put(m.getAbreviado() + m.getClave(), m);
			}
		}
		HashMap<String, Materia> aux = new HashMap<String, Materia>();
		Iterator<Materia> ii = mates.values().iterator();
		while (ii.hasNext())
		{
			m = ii.next();
			aux.put(m.getClave(), m);
		}
		return aux;
	}

	public HashMap<String, String> getMateriasOrdenadasTodas()
	{
		TreeMap<String, String> mates = new TreeMap<String, String>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			mates.put(m.getNombre() + "~" + m.getClave() + "~---", m.getNombre() + " [" + m.getClave() + "]");
		}
		Especialidad esp;
		Iterator<Especialidad> ie = especialidades.values().iterator();
		long x = 0;
		while (ie.hasNext())
		{
			esp = ie.next();
			i = esp.getMaterias().values().iterator();
			while (i.hasNext())
			{
				m = i.next();
				mates.put(m.getNombre() + "~" + m.getClave() + "~" + esp.getClaveOficial() + "~" + x,
						m.getNombre() + " [" + m.getClave() + "]\n(" + esp.getNombre() + ")");
				x++;
			}
		}
		return new HashMap<String, String>(mates);
	}

	public Especialidad getEspecialidad(String clave)
	{
		if (clave == null)
			return null;
		return especialidades.get(clave);
	}

	public Especialidad getEspecialidadMateria(String claveMateria)
	{
		Iterator<Especialidad> i = getEspecialidades().values().iterator();
		Especialidad esp;
		while (i.hasNext())
		{
			esp = i.next();
			if (esp.getMaterias().get(claveMateria) != null)
				return esp;
		}
		return null;
	}

	public TreeMap<String, Especialidad> getEspecialidades()
	{
		return especialidades;
	}

	public boolean isVigente()
	{
		return situacion != 3;
	}

	public long getCargaMinima()
	{
		return cargaMinima;
	}

	public void setCargaMinima(long cargaMinima)
	{
		this.cargaMinima = cargaMinima;
	}

	public long getCargaMaxima()
	{
		return cargaMaxima;
	}

	public void setCargaMaxima(long cargaMaxima)
	{
		this.cargaMaxima = cargaMaxima;
	}

	public long getTotalCreditos()
	{
		return totalCreditos;
	}

	public void setTotalCreditos(long totalCreditos)
	{
		this.totalCreditos = totalCreditos;
	}

	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PlanEstudios))
			return false;
		PlanEstudios other = (PlanEstudios) obj;
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

	public boolean esMateriaDual(String claveMateria)
	{
		if (materias.keySet().contains(claveMateria))
			return false;
		Iterator<Especialidad> i = especialidades.values().iterator();
		Especialidad esp;
		while (i.hasNext())
		{
			esp = i.next();
			if (esp instanceof EspecialidadDual && esp.getMaterias().keySet().contains(claveMateria))
				return true;
		}
		return false;
	}

	public String toString()
	{
		return abreviado + " [" + clave + ']';
	}

	@Override
	public int compareTo(PlanEstudios o)
	{
		return this.nombre.compareTo(o.nombre);
	}

	public String getClaveDeptoAcademico()
	{
		return claveDeptoAcademico;
	}

	public void setClaveDeptoAcademico(String claveDeptoAcademico)
	{
		this.claveDeptoAcademico = claveDeptoAcademico;
	}

	public int getNumeroCarrera()
	{
		return Integer
				.parseInt((int) siglaCarrera.charAt(0) + "" + (int) siglaCarrera.charAt(1) + "" + (int) siglaCarrera.charAt(2));
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
