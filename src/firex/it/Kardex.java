package firex.it;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import firex.Periodo;

public class Kardex
{
	Estudiante alumno;
	PlanEstudios plan;
	String periodoActual;
	Especialidad especialidad;
	TreeMap<String, RegistroKardex> registros;
	int semestreAlumno;
	int creditosAprobados;
	int repites;
	int especiales;
	int especialesReprobados;
	double promedioGeneral;
	double promedioGeneralCertificado;
	int repitesCarrera;
	int especialesCarrera;
	boolean egresado;
	TreeMap<String, String> periodosInscrito;
	double porcentajeAvance;

	public Kardex()
	{
		alumno = null;
		plan = null;
		periodoActual = null;
		registros = null;
		semestreAlumno = 0;
		especialidad = null;
		creditosAprobados = 0;
		repites = 0;
		especiales = 0;
		especialesReprobados = 0;
		promedioGeneral = 0;
		promedioGeneralCertificado = 0;
		repitesCarrera = 0;
		especialesCarrera = 0;
		periodosInscrito = null;
		egresado = false;
		porcentajeAvance = 0;
	}

	public Kardex(Estudiante alumno, PlanEstudios plan, String periodoActual)
	{
		inicializa(alumno, plan, periodoActual);
	}

	public void inicializa(Estudiante alumno, PlanEstudios plan, String periodoActual)
	{
		this.alumno = alumno;
		this.plan = plan;
		this.periodoActual = periodoActual;
		semestreAlumno = (int) alumno.getSemestre(periodoActual);
		if (alumno.getClaveEspecialidad() != null)
		{
			especialidad = plan.getEspecialidad(alumno.getClaveEspecialidad());
			if (alumno.getMateriasDual() != null)
				especialidad.setMateriasDual(alumno.getMateriasDual());
		}
		this.registros = alumno.getRegistrosKardex(plan, periodoActual);
		creditosAprobados = 0;
		repites = 0;
		especiales = 0;
		especialesReprobados = 0;
		promedioGeneral = 0;
		promedioGeneralCertificado = 0;
		especialesCarrera = 0;
		repitesCarrera = 0;
		float sumaCalificacionesAcreditadas = 0;
		float contCalificacionesAcreditadas = 0;
		egresado = false;
		float suma = 0;
		int cont = 0;
		porcentajeAvance = 0;
		Iterator<RegistroKardex> reg = registros.values().iterator();
		periodosInscrito = new TreeMap<String, String>();
		RegistroKardex r;
		Evaluacion eva;
		Materia m;
		while (reg.hasNext())
		{
			r = reg.next();
			m = null;
			if (especialidad != null)
				m = especialidad.getMaterias().get(r.getClaveMateria());
			if (m == null)
				m = plan.getMateriaPlan(r.getClaveMateria());
			if (m != null)
			{
				r.setMateria(m);
				if (r.getCN() != null)
				{
					eva = r.getCN();
					if (eva.getCalificacion() == 0)
						repitesCarrera++;
					periodosInscrito.put(eva.getPeriodo(), eva.getPeriodo());
				}
				if (r.getRC() != null)
				{
					periodosInscrito.put(r.getRC().getPeriodo(), r.getRC().getPeriodo());
					if (r.getRC().getCalificacion() == 0)
						especialesCarrera++;
				}
				if (r.getE() != null)
					periodosInscrito.put(r.getE().getPeriodo(), r.getE().getPeriodo());
				if (r.estaAcreditada())
				{
					creditosAprobados += m.getCreditos();
					if (!(r.getCalificacionTexto().equals("AC") || m instanceof MateriaAcademica
							|| m instanceof MateriaExtraescolar || m instanceof MateriaServicioSocial))
					{
						suma += r.getCalificacion();
						cont++;
						sumaCalificacionesAcreditadas += r.getCalificacion();
						contCalificacionesAcreditadas++;
					}
				}
				if (r.estaRepite())
				{
					if (!(m instanceof MateriaExtraescolar || m instanceof MateriaAcademica
							|| m instanceof MateriaServicioSocial))
					{
						repites++;
						cont++;
					}
				}
				else
					if (r.estaEspecial() && !(m instanceof MateriaExtraescolar || m instanceof MateriaAcademica
							|| m instanceof MateriaServicioSocial))
					{
						especiales++;
						cont++;
					}
					else
						if (r.especialReprobado())
						{
							especialesReprobados++;
							cont++;
						}
			}
		}
		if (suma != 0 || cont != 0)
		{
			promedioGeneral = ((int) (suma / cont * 100)) / 100.0;
		}
		if (sumaCalificacionesAcreditadas != 0 && contCalificacionesAcreditadas != 0)
		{
			this.promedioGeneralCertificado = ((int) (sumaCalificacionesAcreditadas / contCalificacionesAcreditadas * 100))
					/ 100.0;
		}
		egresado = (creditosAprobados >= plan.getTotalCreditos());
		if (creditosAprobados > 0)
			porcentajeAvance = ((int) (creditosAprobados * 100) / plan.getTotalCreditos() * 100) / 100.0;
	}

	public void setSemestreAlumno(int sem)
	{
		this.semestreAlumno = sem;
	}

	@SuppressWarnings("unchecked")
	public boolean estaAutorizada(String claveMateria)
	{
		Map<String, Object> autorizadas = (Map<String, Object>) alumno.get("materiasAutorizadas");
		return autorizadas != null && autorizadas.containsKey(claveMateria);
	}

	public ArrayList<String> clavesMateriasRepite()
	{
		Iterator<RegistroKardex> i = registros.values().iterator();
		RegistroKardex r;
		ArrayList<String> mats = new ArrayList<String>();
		while (i.hasNext())
		{
			r = i.next();
			if (r.estaRepite())
				mats.add(r.getClaveMateria());
		}
		return mats;
	}

	public ArrayList<String> clavesMateriasEspecial()
	{
		Iterator<RegistroKardex> i = registros.values().iterator();
		RegistroKardex r;
		ArrayList<String> mats = new ArrayList<String>();
		while (i.hasNext())
		{
			r = i.next();
			if (r.estaEspecial())
				mats.add(r.getClaveMateria());
		}
		return mats;
	}

	public double getPorcentajeAvance()
	{
		return porcentajeAvance;
	}

	public boolean esEgresado()
	{
		return egresado;
	}

	public Iterator<String> getPeriodosInscrito()
	{
		if (!periodosInscrito.isEmpty())
			return periodosInscrito.values().iterator();
		return null;
	}

	public int getRepitesCarrera()
	{
		return repitesCarrera;
	}

	public int getEspecialesCarrera()
	{
		return especialesCarrera;
	}

	public String ultimoPeriodoInscrito()
	{
		if (periodosInscrito.isEmpty())
			return alumno.getPeriodoIngreso();
		String p = periodosInscrito.lastKey();
		if (Periodo.esVerano(p))
			p = Periodo.getPeriodoAnteriorSinVerano(p);
		return p;
	}

	public Estudiante getAlumno()
	{
		return alumno;
	}

	public PlanEstudios getPlan()
	{
		return plan;
	}

	public double getPromedioGeneral()
	{
		return promedioGeneral;
	}

	public double getPromedioGeneralCertificado()
	{
		return promedioGeneralCertificado;
	}

	public int getCreditosAprobados()
	{
		return creditosAprobados;
	}

	public int getTotalRepites()
	{
		return repites;
	}

	public int getTotalEspeciales()
	{
		return especiales;
	}

	public int getTotalEspecialesReprobados()
	{
		return especialesReprobados;
	}

	public boolean estuvoInscrito(String periodo)
	{
		return this.periodosInscrito.get(periodo) != null;
	}

	public int getCreditosCursados(String periodo)
	{
		ArrayList<RegistroKardex> evasCursadas = getRegistros(periodo);
		int contCreditos = 0;
		if (evasCursadas != null)
		{
			RegistroKardex r;
			for (int x = 0; x < evasCursadas.size(); x++)
			{
				r = evasCursadas.get(x);
				if (r.getMateria() != null)
					contCreditos += r.getMateria().getCreditos();
			}
		}
		return contCreditos;
	}

	public int getTotalMateriasEquivalencia()
	{
		Iterator<RegistroKardex> i = this.registros.values().iterator();
		int total = 0;
		RegistroKardex r;
		while (i.hasNext())
		{
			r = i.next();
			if (r.esEquivalencia())
				total++;
		}
		return total;
	}

	public int getTotalMateriasConvalidacion()
	{
		Iterator<RegistroKardex> i = this.registros.values().iterator();
		int total = 0;
		RegistroKardex r;
		while (i.hasNext())
		{
			r = i.next();
			if (r.esConvalidacion())
				total++;
		}
		return total;
	}

	public double getPromedio(String periodo)
	{
		ArrayList<RegistroKardex> evasCursadas = getRegistros(periodo);
		float cont = 0, suma = 0;
		int menos = 0;
		Materia mat;
		if (evasCursadas != null)
		{
			Evaluacion e;
			RegistroKardex r;
			cont = evasCursadas.size();
			String sm;
			for (int x = 0; x < cont; x++)
			{
				r = evasCursadas.get(x);
				e = r.getEvaluacion(periodo);
				sm = r.getClaveMateria();
				mat = plan.getMateria(sm);
				if (mat instanceof MateriaExtraescolar || e.getTipoExamen().equals("EQUI") || e.getTipoExamen().equals("CONV"))
					menos++;
				else
					if (e.getCalificacion() > 0)
						suma += e.getCalificacion();
			}
		}
		cont -= menos;
		if (cont == 0 || suma == 0)
			return 0;
		return ((int) (suma / cont * 100)) / 100.0;
	}

	public int getCreditosAprobados(String periodo)
	{
		ArrayList<RegistroKardex> evasCursadas = getRegistros(periodo);
		int contCreditos = 0;
		if (evasCursadas != null)
		{
			Materia mat;
			Evaluacion e;
			RegistroKardex r;
			for (int x = 0; x < evasCursadas.size(); x++)
			{
				r = evasCursadas.get(x);
				e = r.getEvaluacion(periodo);
				if (e.getCalificacion() > 0)
				{
					mat = r.getMateria();
					if (mat != null)
						contCreditos += r.getMateria().getCreditos();
				}
			}
		}
		return contCreditos;
	}

	public ArrayList<RegistroKardex> getRegistros(String periodo)
	{
		ArrayList<RegistroKardex> evas = new ArrayList<RegistroKardex>();
		Iterator<RegistroKardex> reg = registros.values().iterator();
		RegistroKardex r;
		while (reg.hasNext())
		{
			r = reg.next();
			if (r.getEvaluacion(periodo) != null)
				evas.add(r);
		}
		if (evas.size() > 0)
			return evas;
		return null;
	}

	public TreeMap<String, RegistroKardex> getRegistros()
	{
		return registros;
	}

	public boolean puedeCursar(RegistroKardex r)
	{
		if (r.estaAcreditada())
			return false;
		if (r.estaRepite() || (r.estaEspecial()))
			return true;
		Materia mat = r.getMateria();
		if (estaAutorizada(mat.getClave()))
			return true;
		if (plan.getNivelEscolar().equals("M") || plan.getNivelEscolar().equals("D"))
			return true;
		if (this.creditosAprobados < mat.getCreditosRequeridos())
			return false;
		if (this.semestreAlumno + 1 < mat.getSemestre())
			return false;
		ArrayList<String> requisitos = mat.getRequisitos();
		if (requisitos == null)
			return true;
		RegistroKardex r2;
		int x, total = requisitos.size();
		for (x = 0; x < total; x++)
		{
			r2 = this.registros.get(requisitos.get(x));
			if (r2 == null || !r2.estaAcreditada())
				return false;
		}
		return true;
	}

	public int getSemestreFinal()
	{
		if (this.egresado)
			return (int) alumno.getSemestre(this.ultimoPeriodoInscrito());
		if (this.semestreAlumno > 20)
			return 20;
		return this.semestreAlumno;
	}

	public RegistroKardex getRegistro(String clave)
	{
		return registros.get(clave);
	}

	public int semestresBajaTemporal()
	{
		String p = alumno.getPeriodoIngreso();
		String pf = periodoActual;
		if (pf.charAt(4) == '2')
			pf = pf.substring(0, 4) + '3';
		int total = 0;
		int fin = 0;
		while (!p.equals(pf) && fin < 15)
		{
			if (!this.estuvoInscrito(p))
				total++;
			p = Periodo.getPeriodoSiguienteSinVerano(p);
			fin++;
		}
		return total;
	}

	public String sePuedeReinscribir()
	{
		if (getTotalEspecialesReprobados() != 0)
			return "NO PUEDE REINSCRIBIRSE POR ESPECIAL REPROBADO";
		else
			if (semestresBajaTemporal() > 4)
				return "NO PUEDE REINSCRIBIRSE POR MAS DE 4 SEMESTRES SIN INSCRIBIRSE";
		return "SI PUEDE REINSCRIBIRSE";
	}

	public boolean puedeReinscribirse()
	{
		return !(this.egresado || getTotalEspecialesReprobados() != 0 || this.semestreAlumno > 12);
	}
}
