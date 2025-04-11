package firex.it;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Grupo implements IsSerializable, Mapa
{
	static String[] DIAS =
	{ "Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa" };
	String id;
	String periodo;
	String clavePlanBase;
	String claveMateriaBase;
	ArrayList<String> clavesMaterias;
	String grupo;
	ArrayList<String> clavesPlanes;
	String docente;
	long cupo;
	boolean calificar;
	long folio;
	long inscritos;
	ArrayList<EstudianteGrupo> alumnos;
	TreeMap<String, String> evaluacionDocente;
	boolean exclusivo;
	String controlJefeGrupo;
	String nombreJefeGrupo;
	ArrayList<String> claseAula;
	ArrayList<Long> claseDia;
	ArrayList<Long> claseHora;
	String tipo;
	long genero;
	String descripcion;
	boolean asesoria;
	HashMap<String, Map<String, Object>> materias;

	public Grupo()
	{
		periodo = null;
		clavePlanBase = "";
		claveMateriaBase = "";
		clavesMaterias = new ArrayList<String>();
		grupo = "";
		clavesPlanes = new ArrayList<String>();
		claseAula = new ArrayList<String>();
		claseDia = new ArrayList<Long>();
		claseHora = new ArrayList<Long>();
		cupo = 0;
		inscritos = 0;
		docente = "";
		calificar = false;
		alumnos = new ArrayList<EstudianteGrupo>();
		evaluacionDocente = null;
		exclusivo = true;
		controlJefeGrupo = "";
		nombreJefeGrupo = "";
		tipo = "";
		genero = 1;
		descripcion = "";
		asesoria = false;
		materias = new HashMap<String, Map<String, Object>>();
	}

	public Grupo(Map<String, Object> m)
	{
		this();
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("claveMateriaBase", claveMateriaBase);
		m.put("clavePlanBase", clavePlanBase);
		m.put("tipo", "grupo");
		m.put("id", id);
		m.put("periodo", periodo);
		m.put("clavesMaterias", clavesMaterias);
		m.put("grupo", grupo);
		m.put("clavesPlanes", clavesPlanes);
		m.put("docente", docente);
		m.put("cupo", cupo);
		m.put("inscritos", inscritos);
		m.put("claseAula", claseAula);
		m.put("claseDia", claseDia);
		m.put("claseHora", claseHora);
		m.put("calificar", calificar);
		m.put("folio", folio);
		m.put("exclusivo", exclusivo);
		m.put("controlJefeGrupo", controlJefeGrupo);
		m.put("tipo", tipo);
		m.put("descripcion", descripcion);
		m.put("genero", genero);
		m.put("materias", materias);
		m.put("asesoria", asesoria);
		// faltan los alumnos
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		id = (String) m.get("id");
		clavePlanBase = (String) m.get("clavePlanBase");
		claveMateriaBase = (String) m.get("claveMateriaBase");
		periodo = (String) m.get("periodo");
		clavesMaterias = (ArrayList<String>) m.get("clavesMaterias");
		grupo = (String) m.get("grupo");
		clavesPlanes = (ArrayList<String>) m.get("clavesPlane");
		docente = (String) m.get("docente");
		cupo = (Long) m.get("cupo");
		calificar = (Boolean) m.get("calificar");
		folio = (Long) m.get("folio");
		exclusivo = (Boolean) m.get("exclusivo");
		controlJefeGrupo = (String) m.get("controlJefeGrupo");
		tipo = (String) m.get("tipo");
		claseAula = (ArrayList<String>) m.get("claseAula");
		claseDia = (ArrayList<Long>) m.get("claseDia");
		claseHora = (ArrayList<Long>) m.get("claseHora");
		if (m.get("genero") == null)
			genero = 1;
		else
			genero = (Long) m.get("genero");
		descripcion = (String) m.get("descripcion");
		materias = (HashMap<String, Map<String, Object>>) m.get("materias");
		Iterator<String> i = m.keySet().iterator();
		String cc;
		EstudianteGrupo ee;
		while (i.hasNext())
		{
			cc = i.next();
			if (cc.charAt(0) == '#')
			{
				ee = new EstudianteGrupo((Map<String, Object>) m.get(cc));
				alumnos.add(ee);
			}
		}
		Collections.sort(alumnos, new EstudianteGrupo());
		inscritos = getInscritos();
		Boolean b = (Boolean) m.get("asesoria");
		if (b != null)
			asesoria = b;
	}

	public void setClavePlanBase(String clavePlanBase)
	{
		this.clavePlanBase = clavePlanBase;
	}

	public boolean estaCalificado()
	{
		ArrayList<EstudianteGrupo> als = alumnos;
		for (int x = 0; x < als.size(); x++)
			if (!als.get(x).estaCalificado())
				return false;
		return true;
	}

	public boolean isAsesoria()
	{
		return asesoria;
	}

	public void setAsesoria(boolean asesoria)
	{
		this.asesoria = asesoria;
	}

	public static String[] getDIAS()
	{
		return DIAS;
	}

	public static void setDIAS(String[] dIAS)
	{
		DIAS = dIAS;
	}

	public String getClaveMateriaBase()
	{
		return claveMateriaBase;
	}

	public void setClaveMateriaBase(String claveMateriaBase)
	{
		this.claveMateriaBase = claveMateriaBase;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setClavesMaterias(ArrayList<String> clavesMaterias)
	{
		this.clavesMaterias = clavesMaterias;
	}

	public void setClavesPlanes(ArrayList<String> clavesPlanes)
	{
		this.clavesPlanes = clavesPlanes;
	}

	public void setCupo(long cupo)
	{
		this.cupo = cupo;
	}

	public void setFolio(long folio)
	{
		this.folio = folio;
	}

	public void setInscritos(long inscritos)
	{
		this.inscritos = inscritos;
	}

	public void setAlumnos(ArrayList<EstudianteGrupo> alumnos)
	{
		this.alumnos = alumnos;
	}

	public void setEvaluacionDocente(TreeMap<String, String> evaluacionDocente)
	{
		this.evaluacionDocente = evaluacionDocente;
	}

	public void setClaseAula(ArrayList<String> claseAula)
	{
		this.claseAula = claseAula;
	}

	public void setClaseDia(ArrayList<Long> claseDia)
	{
		this.claseDia = claseDia;
	}

	public void setClaseHora(ArrayList<Long> claseHora)
	{
		this.claseHora = claseHora;
	}

	public void setMaterias(HashMap<String, Map<String, Object>> materias)
	{
		this.materias = materias;
	}

	public ArrayList<String> getClavesPlanes()
	{
		return clavesPlanes;
	}

	public void setDescripcion(String des)
	{
		descripcion = des;
	}

	public void setGenero(long g)
	{
		genero = g;
	}

	public long getGenero()
	{
		return genero;
	}

	public void setGenero(String gen)
	{
		if (gen.equalsIgnoreCase("Mixto"))
			genero = 1;
		if (gen.equalsIgnoreCase("Varonil"))
			genero = 2;
		if (gen.equalsIgnoreCase("Femenil"))
			genero = 3;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public String getGeneroCadena()
	{
		switch ((int)genero)
		{
		case 0:
			return "MIXTO";
		case 1:
			return "VARONIL";
		case 2:
			return "FEMENIL";
		case 3:
			return "PAREJAS";
		}
		return "---";
	}

	public boolean calificado()
	{
		for (EstudianteGrupo e : alumnos)
			if (!e.estaCalificado())
				return false;
		return true;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getTipo()
	{
		return tipo;
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

	public String getNombreJefeGrupo()
	{
		return nombreJefeGrupo;
	}

	public void setNombreJefeGrupo(String nombreJefeGrupo)
	{
		this.nombreJefeGrupo = nombreJefeGrupo;
	}

	public String getControlJefeGrupo()
	{
		return controlJefeGrupo;
	}

	public void setControlJefeGrupo(String controlJefeGrupo)
	{
		this.controlJefeGrupo = controlJefeGrupo;
	}

	public int[] getHorasSemana()
	{
		int dias[] = new int[6];
		for (int x = 0; x < dias.length; dias[x] = 0, x++)
			;
		for (int x = 0; x < 5; x++)
			dias[x] = getHorasDia(x + 1);
		return dias;
	}

	public int getHorasDia(int dia)
	{
		String[][] h = getHorario();
		int cad = 0;
		for (int x = 7; x < 21; x++)
			if (h[x][dia] != null)
				cad++;
		return cad;
	}

	public String[] getAulasPorDia()
	{
		String dias[] = new String[6];
		for (int x = 0; x < dias.length; dias[x] = "", x++)
			;
		for (int x = 0; x < 5; x++)
			dias[x] = getAulaDia(x + 1);
		return dias;
	}

	public String getAulaDia(int dia)
	{
		String[][] h = getHorario();
		StringBuffer cad = new StringBuffer();
		int i, x, y;
		y = dia;
		x = 7;
		String aulaMas = getAulaMasUsada();
		while (x < 21)
		{
			if (h[x][y] != null)
			{
				i = x;
				while (x < 21 && h[x][y] != null && h[x][y].equals(h[i][y]))
					x++;
				if (cad.length() > 0)
					cad.append(',');
				if (h[i][y].equals(aulaMas))
					cad.append(i + ":00-" + x + ":00");
				else
					cad.append(i + ":00-" + x + ":00," + h[i][y]);
			}
			else
				x++;
		}
		return cad.toString();
	}

	public String getAulaMasUsada()
	{
		TreeMap<String, Integer> aux = new TreeMap<String, Integer>();
		String a;
		int x;
		Integer i;
		for (x = 0; x < claseAula.size(); x++)
		{
			a = claseAula.get(x);
			i = aux.get(a);
			if (i == null)
				aux.put(a, 1);
			else
				aux.put(a, i + 1);
		}
		Iterator<String> m = aux.keySet().iterator();
		x = 0;
		String s, resp = "";
		while (m.hasNext())
		{
			s = m.next();
			i = aux.get(s);
			if (i > x)
			{
				x = i;
				resp = s;
			}
		}
		return resp;
	}

	public String getIdGrupoBase()
	{
		return id;
	}

	public boolean isExclusivo()
	{
		return exclusivo;
	}

	public void setExclusivo(boolean exclusivo)
	{
		this.exclusivo = exclusivo;
	}

	public TreeMap<String, String> getEvaluacionDocente()
	{
		if (evaluacionDocente == null)
			evaluacionDocente = new TreeMap<String, String>();
		return evaluacionDocente;
	}

	public ArrayList<String> getClavesMaterias()
	{
		return clavesMaterias;
	}

	public boolean isCalificar()
	{
		return calificar;
	}

	public void setCalificar(boolean calificar)
	{
		this.calificar = calificar;
	}

	public String getDocente()
	{
		if (docente == null)
			return "MAESTRO SIN ASIGNAR";
		return docente;
	}

	public void setDocente(String docente)
	{
		this.docente = docente;
	}

	public ArrayList<EstudianteGrupo> getAlumnos()
	{
		return alumnos;
	}

	public TreeMap<String, String> getControles()
	{
		TreeMap<String, String> ctrls = new TreeMap<String, String>();
		for (EstudianteGrupo e : alumnos)
			ctrls.put(e.getControl(), "");
		return ctrls;
	}

	public void setId()
	{
		id = periodo + '|' + clavesMaterias.get(0) + '|' + grupo;
	}

	public String getId()
	{
		return id;
	}

	public int getInscritos()
	{
		return alumnos.size();
	}

	public void setInscritos(int inscritos)
	{
		this.inscritos = inscritos;
	}

	public boolean hayCupo()
	{
		return cupo > inscritos;
	}

	public String[][] getHorario()
	{
		String hr[][] = new String[21][7];
		int x, total;
		total = claseAula.size();
		for (x = 0; x < total; x++)
			hr[claseHora.get(x).intValue()][claseDia.get(x).intValue()] = claseAula.get(x);
		return hr;
	}

	public String getLineaHorario()
	{
		String[][] h = getHorario();
		StringBuffer cad = new StringBuffer();
		int i, x, y;
		for (y = 1; y < 7; y++)
		{
			x = 7;
			while (x < 21)
			{
				if (h[x][y] != null)
				{
					i = x;
					while (x < 21 && h[x][y] != null && h[x][y].equals(h[i][y]))
						x++;
					if (cad.length() > 0)
						cad.append('|');
					cad.append(DIAS[y] + ' ' + i + 'a' + x + ',' + h[i][y]);
				}
				else
					x++;
			}
		}
		return cad.toString();
	}

	public String getAulas(int dia)
	{
		String[][] h = getHorario();
		int x, i, y = dia;
		x = 7;
		StringBuffer cad = new StringBuffer();
		while (x < 21)
		{
			if (h[x][y] != null)
			{
				i = x;
				while (x < 21 && h[x][y] != null && h[x][y].equals(h[i][y]))
					x++;
				if (cad.length() > 0)
					cad.append(" ");
				cad.append(i + "a" + x + "," + h[i][y]);
			}
			else
				x++;
		}
		return cad.toString();
	}

	public int getCupo()
	{
		return (int) cupo;
	}

	public int getEspaciosLibres()
	{
		return (int) (cupo - inscritos);
	}

	public Materia getMateria()
	{
		return new Materia(materias.get(clavePlanBase + "_" + claveMateriaBase));
	}

	public ArrayList<String> getAulas()
	{
		return claseAula;
	}

	public String getClaveMateria()
	{
		return claveMateriaBase;
	}

	public String getPeriodo()
	{
		return periodo;
	}

	public void setPeriodo(String periodo)
	{
		this.periodo = periodo;
	}

	public String getGrupo()
	{
		return grupo;
	}

	public void setGrupo(String grupo)
	{
		this.grupo = grupo;
	}

	public String getClavePlanBase()
	{
		if ((clavePlanBase == null || clavePlanBase.length() == 0) && getClavesPlanes() != null
				&& getClavesPlanes().size() > 0)
			clavePlanBase = getClavesPlanes().get(0);
		return clavePlanBase;
	}

	public void setCupo(int x)
	{
		cupo = x;
	}

	public String toString()
	{
		return getMateria().getAbreviado() + " [" + grupo + "] " + descripcion;
	}

	public int getFolio()
	{
		return (int) folio;
	}

	public void setFolio(int folio)
	{
		this.folio = folio;
	}

	public HashMap<String, Map<String, Object>> getMaterias()
	{
		return materias;
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
