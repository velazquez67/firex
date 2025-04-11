package firex.it;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import com.google.gwt.user.client.rpc.IsSerializable;
import firex.Estaticos;

public class Estudiante implements IsSerializable, Mapa, Comparator<Estudiante>
{
	Map<String, Object> datos;
	boolean inscrito;
	String auxiliar;
	String foto;
	PlanEstudios plan;
	ProyectoResidencia proyecto;

	public Estudiante()
	{
		datos = new HashMap<String, Object>();
		Map<String, Object> personales = new HashMap<String, Object>();
		personales.put("estadoCivil", "SOLTERO(A)");
		datos.put("datosPersonales", personales);
		datos.put("periodosRevalidados", 0L);
		datos.put("claveEspecialidad","");
		datos.put("nivel", "L");
		datos.put("evaluaciones", new ArrayList<String>());
		plan = null;
		proyecto = null;
	}

	public Estudiante(Map<String, Object> d)
	{
		datos = d;
	}

	public Estudiante(String control)
	{
		this();
		setControl(control);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("control", getControl());
		m.put("paterno", getPaterno());
		m.put("materno", getMaterno());
		m.put("nombre", getNombre());
		m.put("apellidosNombre", getApellidosNombre());
		m.put("siglaCarrera", getSiglaCarrera());
		m.put("clavePlanEstudios", getClavePlanEstudios());
		m.put("claveEspecialidad", getClaveEspecialidad());
		m.put("periodoIngreso", getPeriodoIngreso());
		m.put("periodosRevalidados", getPeriodosRevalidados());
		m.put("CURP", getCURP());
		m.put("nivel", getNivel());
		m.put("RfcTutor", getRfcTutor());
		m.put("correo", getCorreo());
		m.put("correoInstitucional", getCorreoInstitucional());
		m.put("seguro", getSeguro());
		m.put("telefono", getTelefono());
		m.put("celular", getCelular());
		m.put("evaluaciones", getEvaluaciones());
		m.put("palabras", palabras());
		m.put("datosPersonales", getDatosPersonales());
		m.put("materiasDual", getMateriasDual());
		return m;
	}

	public ProyectoResidencia getProyecto()
	{
		return proyecto;
	}

	public void setProyecto(ProyectoResidencia proyecto)
	{
		this.proyecto = proyecto;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMateriasDual()
	{
		Object o = datos.get("materiasDual");
		if (o != null)
			return (Map<String, Object>) o;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMateriasAutorizadas()
	{
		return (Map<String, Object>) datos.get("materiasAutorizadas");
	}

	public void setMateriasAutorizadas(Map<String, Object> auts)
	{
		datos.put("materiasAutorizadas", auts);
	}

	public void setDatosPersonales(Map<String, Object> d)
	{
		datos.put("datosPersonales", d);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTitulacion()
	{
		{
			Object o = datos.get("titulacion");
			if (o != null)
				return (Map<String, Object>) o;
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDatosPersonales()
	{
		Map<String, Object> dp = (Map<String, Object>) datos.get("datosPersonales");
		if (dp != null)
			return dp;
		return new HashMap<String, Object>();
	}

	private ArrayList<String> palabras()
	{
		ArrayList<String> p = new ArrayList<String>();
		String[] n = this.getApellidosNombre().split(" ");
		String s;
		for (int x = 0; x < n.length; x++)
		{
			p.add(n[x]);
			s = n[x].replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U");
			if (!s.equals(n[x]))
				p.add(s);
		}
		String nn = getNombre();
		if (nn.contains(" "))
		{
			p.add(nn);
			s = nn.replace("Á", "A").replace("É", "E").replace("Í", "I").replace("Ó", "O").replace("Ú", "U");
			if (!s.equals(nn))
				p.add(s);
		}
		return p;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		datos.put("control", m.get("control"));
		datos.put("paterno", m.get("paterno"));
		datos.put("materno", m.get("materno"));
		datos.put("nombre", m.get("nombre"));
		datos.put("siglaCarrera", m.get("siglaCarrera"));
		datos.put("clavePlanEstudios", m.get("clavePlanEstudios"));
		datos.put("claveEspecialidad", m.get("claveEspecialidad"));
		datos.put("periodoIngreso", m.get("periodoIngreso"));
		datos.put("periodosRevalidados", m.get("periodosRevalidados"));
		datos.put("CURP", m.get("CURP"));
		datos.put("RfcTutor", m.get("RfcTutor"));
		datos.put("correo", (m.get("correo") != null) ? m.get("correo") : "");
		datos.put("nivel", m.get("nivel"));
		datos.put("correoInstitucional", m.get("correoInstitucional"));
		datos.put("seguro", (m.get("seguro") != null) ? m.get("seguro") : "");
		datos.put("periodoEgreso", m.get("periodoEgreso"));
		datos.put("promedioEgreso", m.get("promedioEgreso"));
		datos.put("telefono", m.get("telefono"));
		datos.put("celular", m.get("celular"));
		datos.put("fechaTitulacion", m.get("fechaTitulacion"));
		datos.put("opcionTitulacion", m.get("opcionTitulacion"));
		datos.put("evaluaciones", m.get("evaluaciones"));
	}

	public double getPromedio()
	{
		TreeMap<String, RegistroKardex> regs = this.getRegistros();
		RegistroKardex r;
		Iterator<RegistroKardex> i = regs.values().iterator();
		int total = 0;
		int sumaCalif = 0;
		while (i.hasNext())
		{
			r = i.next();
			if (!r.estaSinCursar())
			{
				total++;
				sumaCalif += r.getCalificacion();
			}
		}
		if (total > 0 && sumaCalif > 0)
			return sumaCalif / total / 1.0;
		return 0;
	}

	public String getNivel()
	{
		return (String) datos.get("nivel");
	}

	public void setNivel(String nivel)
	{
		datos.put("nivel", nivel);
	}

	public PlanEstudios getPlan()
	{
		return plan;
	}

	public void setPlan(PlanEstudios plan)
	{
		this.plan = plan;
	}

	public void setFechaTitulacion(String fechaTitulacion)
	{
		datos.put("fechaTitulacion", fechaTitulacion);
	}

	public String getOpcionTitulacion()
	{
		return (String) datos.get("opcionTitulacion");
	}

	public void setOpcionTitulacion(String opcionTitulacion)
	{
		datos.put("opcionTitulacion", opcionTitulacion);
	}

	public String getPromedioEgreso()
	{
		return (String) datos.get("promedioEgreso");
	}

	public void setPromedioEgreso(String promedioEgreso)
	{
		datos.put("promedioEgreso", promedioEgreso);
	}

	public void setEvaluaciones(ArrayList<String> evals)
	{
		datos.put("evaluaciones", evals);
	}

	public String getTelefono()
	{
		return (String) datos.get("telefono");
	}

	public void setTelefono(String telefono)
	{
		datos.put("telefono", telefono);
	}

	public String getCelular()
	{
		return (String) datos.get("celular");
	}

	public void setCelular(String celular)
	{
		datos.put("celular", celular);
	}

	public String getPeriodoEgreso()
	{
		return (String) datos.get("periodoEgreso");
	}

	public void setPeriodoEgreso(String egreso)
	{
		datos.put("periodoEgreso", egreso);
	}

	public String getCorreoInstitucional()
	{
		String c = (String) datos.get("correoInstitucional");
		if (c != null && c.length() > 0)
			return c;
		c = getNivel() + getControl();
		return c + "@" + Estaticos.dominioIt;
	}

	public void setCorreoInstitucional(String correoInstitucional)
	{
		datos.put("correoInstitucional", correoInstitucional);
	}

	public String getSeguro()
	{
		String s = (String) datos.get("seguro");
		if (s == null)
			s = "";
		return s;
	}

	public void setSeguro(String seguro)
	{
		datos.put("seguro", seguro);
	}

	public String getFoto()
	{
		return foto;
	}

	public void setFoto(String foto)
	{
		this.foto = foto;
	}

	public boolean esHombre()
	{
		String c = getCURP();
		return (c == null || c.length() < 11 || c.charAt(10) != 'M');
	}

	public String getAuxiliar()
	{
		return auxiliar;
	}

	public void setAuxiliar(String auxiliar)
	{
		this.auxiliar = auxiliar;
	}

	public boolean isInscrito()
	{
		return inscrito;
	}

	@SuppressWarnings("unchecked")
	public boolean existeEvaluacion(String id)
	{
		ArrayList<String> evals = (ArrayList<String>) datos.get("evaluaciones");
		for (int x = 0; x < evals.size(); x++)
			if (evals.get(x).contains(id))
				return true;
		return false;
	}

	public void setInscrito(boolean inscrito)
	{
		this.inscrito = inscrito;
	}

	public TreeMap<String, RegistroKardex> getRegistrosKardex(PlanEstudios plan, String ultimoPeriodo)
	{
		ArrayList<String> evas = getEvaluaciones();
		TreeMap<String, RegistroKardex> registros = new TreeMap<String, RegistroKardex>();
		RegistroKardex r;
		int x = 0, total = evas.size();
		Evaluacion e;
		String linea = null, cad[] = null;
		try
		{
			for (x = 0; x < total; x++)
			{ // 0 1 2 3 4 5 6 7 8
				// 20133~EMF1023~CN~88~2014-01-08~KA~ORD~N~MARCO AURELIO VELAZQUEZ
				// VELAZCO
				linea = evas.get(x);
				if (linea.length() == 0)
					continue;
				cad = linea.split("~");
				if (plan.getMateria(cad[1]) == null)
					continue;
				if (cad[0].compareTo(ultimoPeriodo) > 0)
					continue;
				r = registros.get(cad[1]);
				if (r == null)
				{
					r = new RegistroKardex(cad[1]);
					registros.put(cad[1], r);
				}
				e = new Evaluacion();
				e.setPeriodo(cad[0]);
				cad[3] = cad[3].trim();
				if (cad[3].equals("NA") || cad[3].equals("NP"))
					e.setCalificacion(0);
				else
					e.setCalificacion(Integer.parseInt(cad[3]));
				e.setFechaCalificacion(cad[4]);
				e.setGrupo(cad[5]);
				e.setTipoEvaluacion(cad[6]);
				if ((e.getCalificacion() > 0) && (cad[1].equals(Estaticos.TUTORIA1) || cad[1].equals("TESIS")
						|| cad[1].equals(Estaticos.ACTIVIDAD_ACADEMICA) || cad[1].equals(Estaticos.ACTIVIDAD_ACADEMICA2)
						|| cad[1].equals(Estaticos.TUTORIA2) || cad[1].equals(Estaticos.ACTIVIDAD_CULTURAL)
						|| cad[1].equals(Estaticos.ACTIVIDAD_DEPORTIVA)))
					e.setTipoEvaluacion(Evaluacion.Acreditada);
				e.setDeserto(cad[7].equals("S"));
				if (cad[2].equals("CN"))
					r.setCN(e);
				else
					if (cad[2].equals("RC"))
						r.setRC(e);
					else
						r.setE(e);
			}
		} catch (Exception error)
		{
			System.err.println("Error:" + getControl() + " " + x + " " + linea);
		}
		return registros;
	}

	public TreeMap<String, RegistroKardex> getRegistrosKardex(PlanEstudios plan)
	{
		ArrayList<String> evas = getEvaluaciones();
		TreeMap<String, RegistroKardex> registros = new TreeMap<String, RegistroKardex>();
		RegistroKardex r;
		int x = 0, total = evas.size();
		Evaluacion e;
		String linea = null, cad[] = null;
		try
		{
			for (x = 0; x < total; x++)
			{ // 0 1 2 3 4 5 6 7 8
				// 20133~EMF1023~CN~88~2014-01-08~KA~ORD~N~MARCO AURELIO VELAZQUEZ
				// VELAZCO
				linea = evas.get(x);
				if (linea.length() == 0)
					continue;
				cad = linea.split("~");
				if (plan.getMateria(cad[1]) == null)
					continue;
				r = registros.get(cad[1]);
				if (r == null)
				{
					r = new RegistroKardex(cad[1]);
					registros.put(cad[1], r);
				}
				e = new Evaluacion();
				e.setPeriodo(cad[0]);
				cad[3] = cad[3].trim();
				if (cad[3].equals("NA") || cad[3].equals("NP"))
					e.setCalificacion(0);
				else
					e.setCalificacion(Integer.parseInt(cad[3]));
				e.setFechaCalificacion(cad[4]);
				e.setGrupo(cad[5]);
				e.setTipoEvaluacion(cad[6]);
				if ((e.getCalificacion() > 0) && (cad[1].equals(Estaticos.TUTORIA1) || cad[1].equals("TESIS")
						|| cad[1].equals(Estaticos.ACTIVIDAD_ACADEMICA) || cad[1].equals(Estaticos.ACTIVIDAD_ACADEMICA2)
						|| cad[1].equals(Estaticos.TUTORIA2) || cad[1].equals(Estaticos.ACTIVIDAD_CULTURAL)
						|| cad[1].equals(Estaticos.ACTIVIDAD_DEPORTIVA)))
					e.setTipoEvaluacion(Evaluacion.Acreditada);
				e.setDeserto(cad[7].equals("S"));
				if (cad[2].equals("CN"))
					r.setCN(e);
				else
					if (cad[2].equals("RC"))
						r.setRC(e);
					else
						r.setE(e);
			}
		} catch (Exception error)
		{
			System.err.println("Error:" + getControl() + " " + x + " " + linea);
		}
		return registros;
	}

	public TreeMap<String, RegistroKardex> getRegistros()
	{
		ArrayList<String> evas = getEvaluaciones();
		TreeMap<String, RegistroKardex> registros = new TreeMap<String, RegistroKardex>();
		RegistroKardex r;
		int x, total = evas.size();
		Evaluacion e;
		String cad[];
		for (x = 0; x < total; x++)
			if (evas.get(x).length() > 5)
			{ // 0 1 2 3 4 5 6 7 8
				// 20133~EMF1023~CN~88~2014-01-08~KA~ORD~N~MARCO AURELIO VELAZQUEZ
				// VELAZCO
				cad = evas.get(x).split("~");
				r = registros.get(cad[1]);
				if (r == null)
				{
					r = new RegistroKardex(cad[1]);
					registros.put(cad[1], r);
				}
				e = new Evaluacion();
				e.setPeriodo(cad[0]);
				cad[3] = cad[3].trim();
				if (cad[3].equals("NA") || cad[3].equals("NP"))
					e.setCalificacion(0);
				else
					e.setCalificacion(Integer.parseInt(cad[3]));
				e.setFechaCalificacion(cad[4]);
				e.setGrupo(cad[5]);
				e.setTipoEvaluacion(cad[6]);
				e.setDeserto(cad[7].equals("S"));
				if (cad.length > 8)
					e.setQuienCalifico(cad[8]);
				else
					e.setQuienCalifico("---");
				if (cad[2].equals("CN"))
					r.setCN(e);
				else
					if (cad[2].equals("RC"))
						r.setRC(e);
					else
						r.setE(e);
			}
		return registros;
	}

	public String getCorreo()
	{
		return (String) datos.get("correo");
	}

	public void setCorreo(String correo)
	{
		datos.put("correo", correo);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getEvaluaciones()
	{
		ArrayList<String> aux = (ArrayList<String>) datos.get("evaluaciones");
		Collections.sort(aux);
		return aux;
	}

	public String getRfcTutor()
	{
		return (String) datos.get("RfcTutor");
	}

	public void setRfcTutor(String rfcTutor)
	{
		datos.put("RfcTutor", rfcTutor);
	}

	public String getCURP()
	{
		return (String) datos.get("CURP");
	}

	public void setCURP(String curp)
	{
		datos.put("CURP", curp);
	}

	/*
	 * public String lugarNacimiento() { String edo=
	 * ""+this.CURP.charAt(11)+this.CURP.charAt(12);
	 * 
	 * switch(edo) { case "AS" : return "AGUASCALIENTES"; case "BC" : return BAJA
	 * CALIFORNIA NORTE"; case "BS" : return BAJA CALIFORNIA SUR"; case "CC" :
	 * return "CAMPECHE"; case "CL" : COAHUILA CL case "CM" : COLIMA CM case "CS" :
	 * CHIAPAS CS case "CH": CHIHUAHUA CH case "":DISTRITO FEDERAL DF case
	 * "":DURANGO DG case "":GUANAJUATO GT case "":GUERRERO GR case "":HIDALGO HG
	 * case "":JALISCO JC case "":M�XICO MC case "":MICHOAC�N MN case "":MORELOS MS
	 * case "":NAYARIT NT case "":NUEVO LE�N NL case "":OAXACA OC case "":PUEBLA PL
	 * case "":QUER�TARO QT case "":QUINTANA ROO QR case "":SAN LUIS POTOS� SP case
	 * "":SINALOA SL case "":SONORA SR case "":TABASCO TC case "":TAMAULIPAS TS case
	 * "":TLAXCALA TL case "":VERACRUZ VZ case "":YUCAT�N YN case
	 * "ZACATECAS ZS case "NE": NACIDO EN EL EXTRANJERO NE } return "--"; }
	 */
	public String getFechaNacimiento()
	{
		try
		{
			String c = getCURP();
			return c.substring(8, 10) + "/" + c.substring(6, 8) + "/"
					+ (Integer.parseInt(c.substring(4, 6)) > 50 ? "19" : "20") + c.substring(4, 6);
		} catch (Exception error)
		{
		}
		return "01/01/2000";
	}

	public int getEdad(int yearActual, int mesActual, int diaActual)
	{
		try
		{
			String c = getCURP();
			int yn = Integer.parseInt(c.substring(4, 6));
			int mn = Integer.parseInt(c.substring(6, 8));
			int dn = Integer.parseInt(c.substring(8, 10));
			if (yearActual == yn)
				return 0;
			int edad = yearActual - yn;
			if (mesActual < mn || (mesActual == mn && diaActual < dn))
				edad--;
			return edad;
		} catch (Exception error)
		{
			return 0;
		}
	}

	public int getSemestre(String periodoActual)
	{
		if (periodoActual.charAt(4) == '2')
			periodoActual = periodoActual.substring(0, 4) + '1';
		int i, f, t, c = Integer.parseInt(getPeriodoIngreso().substring(4, 5));
		if (c == 3)
			c = 2;
		i = Integer.parseInt(getPeriodoIngreso().substring(0, 4)) * 2 + c;
		c = Integer.parseInt(periodoActual.substring(4, 5));
		if (c == 3)
			c = 2;
		f = Integer.parseInt(periodoActual.substring(0, 4)) * 2 + c;
		t = f - i + 1;
		if (t < 0)
			return 0;
		return (int) (t + getPeriodosRevalidados());
	}

	public String getControl()
	{
		return (String) datos.get("control");
	}

	public void setControl(String control)
	{
		datos.put("control", control.trim().toUpperCase());
	}

	public String getClavePlanEstudios()
	{
		return (String) datos.get("clavePlanEstudios");
	}

	public void setClavePlanEstudios(String planEstudios)
	{
		datos.put("clavePlanEstudios", planEstudios);
	}

	public String getPaterno()
	{
		return (String) datos.get("paterno");
	}

	public void setPaterno(String paterno)
	{
		datos.put("paterno", paterno.trim().toUpperCase());
	}

	public String getMaterno()
	{
		return (String) datos.get("materno");
	}

	public void setMaterno(String materno)
	{
		datos.put("materno", materno.trim().toUpperCase());
	}

	public String getNombre()
	{
		return (String) datos.get("nombre");
	}

	public void setNombre(String nombre)
	{
		datos.put("nombre", nombre.trim().toUpperCase());
	}

	public String getPeriodoIngreso()
	{
		return (String) datos.get("periodoIngreso");
	}

	public void setPeriodoIngreso(String periodoIngreso)
	{
		datos.put("periodoIngreso", periodoIngreso);
	}

	public long getPeriodosRevalidados()
	{
		return (Long) datos.get("periodosRevalidados");
	}

	public void setPeriodosRevalidados(long periodosRevalidados)
	{
		datos.put("periodosRevalidados", periodosRevalidados);
	}

	public String getClaveEspecialidad()
	{
		return (String) datos.get("claveEspecialidad");
	}

	public void setClaveEspecialidad(String claveEspecialidad)
	{
		datos.put("claveEspecialidad", claveEspecialidad.trim());
	}

	public String getSiglaCarrera()
	{
		return (String) datos.get("siglaCarrera");
	}

	public void setSiglaCarrera(String siglaCarrera)
	{
		datos.put("siglaCarrera", siglaCarrera);
	}

	public String toString()
	{
		return getApellidosNombre();
	}

	public boolean equals(Object obj)
	{
		if (!(obj instanceof Estudiante))
			return false;
		Estudiante aux = (Estudiante) obj;
		return getControl().equals(aux.getControl());
	}

	public String getApellidosNombre()
	{
		return (getPaterno() + ' ' + getMaterno() + ' ' + getNombre()).replaceFirst("  ", " ");
	}

	public String getNombreApellidos()
	{
		return getNombre() + ' ' + getPaterno() + ' ' + getMaterno().trim();
	}

	public int getCalificacion(String idEvaluacion)
	{
		ArrayList<String> evaluaciones = getEvaluaciones();
		int x, total = evaluaciones.size();
		String eval;
		for (x = 0; x < total; x++)
		{
			eval = evaluaciones.get(x);
			if (eval.contains(idEvaluacion))
			{
				String cads[] = eval.split("~");
				int cal = Integer.parseInt(cads[3]);
				if (cal == 0 && cads[7].equals("S"))
					return 1;// deserto
				return cal;
			}
		}
		return -1;
	}

	public String getTipoEvaluacion(String idEvaluacion)
	{
		ArrayList<String> evaluaciones = getEvaluaciones();
		int x, total = evaluaciones.size();
		String eval;
		for (x = 0; x < total; x++)
		{
			eval = evaluaciones.get(x);
			if (eval.contains(idEvaluacion))
			{
				String cads[] = eval.split("~");
				return cads[6];
			}
		}
		return null;
	}

	public void almacenaEvaluacion(String id, String evaluacion)
	{
		ArrayList<String> evaluaciones = getEvaluaciones();
		eliminaEvaluacion(id);
		if (evaluacion != null && evaluacion.contains("~"))
			evaluaciones.add(evaluacion);
	}

	public boolean eliminaEvaluacion(String id)
	{
		ArrayList<String> evaluaciones = getEvaluaciones();
		for (int x = 0; x < evaluaciones.size(); x++)
			if (evaluaciones.get(x).contains(id))
			{
				evaluaciones.remove(x);
				return true;
			}
		return false;
	}

	public String getRfc()
	{
		return getCURP().substring(0, 10);
	}

	@Override
	public int compare(Estudiante o1, Estudiante o2)
	{
		return o1.getApellidosNombre().compareTo(o2.getApellidosNombre());
	}

	@Override
	public String gets(String campo)
	{
		String d = (String) datos.get(campo);
		if (d == null)
			return (String) getDatosPersonales().get(campo);
		return d;
	}

	@Override
	public Object get(String campo)
	{
		Object d = datos.get(campo);
		if (d == null)
			return getDatosPersonales().get(campo);
		return d;
	}
}
