package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Ficha implements IsSerializable, Mapa
{
	String id;
	boolean pagoValidado;
	String fechaBanco;
	String matricula;
	boolean aplicoExamenAdmision;
	String telefonoCasa;
	String celular;
	String correo;
	String periodo;
	String curp;
	String autBanco;
	String paterno;
	String materno;
	String nombre;
	String carrera;
	boolean aceptado;
	String aulaExamen;
	String horaExamen;
	String fechaExamen;
	Estudiante estudiante;

	public Ficha()
	{
		id = "";
		pagoValidado = false;
		fechaBanco = "";
		matricula = "";
		aplicoExamenAdmision = false;
		telefonoCasa = "";
		celular = "";
		correo = "";
		periodo = "";
		curp = "";
		autBanco = "";
		paterno = "";
		materno = "";
		nombre = "";
		carrera = "";
		aceptado = false;
		aulaExamen = "";
		horaExamen = "";
		fechaExamen = "";
		estudiante = new Estudiante();
		DatosEstudiante d = new DatosEstudiante();
		estudiante.setDatosPersonales(d.toMap());
	}

	public Ficha(String periodo, String curp)
	{
		this();
		setId(periodo, curp.trim().toUpperCase());
		setPeriodo(periodo);
		setCurp(curp);
		estudiante.setCURP(curp);
		estudiante.setPaterno(paterno);
		estudiante.setMaterno(materno);
		estudiante.setNombre(nombre);
		estudiante.setCelular(celular);
		estudiante.setTelefono(telefonoCasa);
		estudiante.setCorreo(correo);
	}

	public Ficha(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", id);
		m.put("pagoValidado", pagoValidado);
		m.put("fechaBanco", fechaBanco);
		m.put("matricula", matricula);
		m.put("aplicoExamenAdmision", aplicoExamenAdmision);
		m.put("telefonoCasa", telefonoCasa);
		m.put("celular", celular);
		m.put("correo", correo);
		m.put("periodo", periodo);
		m.put("curp", curp);
		m.put("autBanco", autBanco);
		m.put("paterno", paterno);
		m.put("materno", materno);
		m.put("nombre", nombre);
		m.put("carrera", carrera);
		m.put("aceptado", aceptado);
		m.put("horaExamen", horaExamen);
		m.put("fechaExamen", fechaExamen);
		m.put("aulaExamen", aulaExamen);
		m.put("estudiante", getEstudiante().toMap());
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		id = (String) m.get("id");
		pagoValidado = (Boolean) m.get("pagoValidado");
		fechaBanco = (String) m.get("fechaBanco");
		matricula = (String) m.get("matricula");
		aplicoExamenAdmision = (Boolean) m.get("aplicoExamenAdmision");
		telefonoCasa = (String) m.get("telefonoCasa");
		celular = (String) m.get("celular");
		correo = (String) m.get("correo");
		periodo = (String) m.get("periodo");
		curp = (String) m.get("curp");
		autBanco = (String) m.get("autBanco");
		paterno = (String) m.get("paterno");
		materno = (String) m.get("materno");
		nombre = (String) m.get("nombre");
		carrera = (String) m.get("carrera");
		aceptado = (Boolean) m.get("aceptado");
		aulaExamen = (String) m.get("aulaExamen");
		horaExamen = (String) m.get("horaExamen");
		fechaExamen = (String) m.get("fechaExamen");
		Map<String, Object> e = (Map<String, Object>) m.get("estudiante");
		if (e == null)
			estudiante = new Estudiante();
		else
			estudiante = new Estudiante(e);
		estudiante.setCURP(curp);
		estudiante.setPaterno(paterno);
		estudiante.setMaterno(materno);
		estudiante.setNombre(nombre);
		estudiante.setCelular(celular);
		estudiante.setTelefono(telefonoCasa);
		estudiante.setCorreo(correo);
	}

	public String getAulaExamen()
	{
		if (aulaExamen == null)
			aulaExamen = "";
		return aulaExamen;
	}

	public void setAulaExamen(String aulaExamen)
	{
		this.aulaExamen = aulaExamen;
	}

	public String getHoraExamen()
	{
		if (horaExamen == null)
			horaExamen = "";
		return horaExamen;
	}

	public void setHoraExamen(String horaExamen)
	{
		this.horaExamen = horaExamen;
	}

	public String getFechaExamen()
	{
		if (fechaExamen == null)
			fechaExamen = "";
		return fechaExamen;
	}

	public void setFechaExamen(String fechaExamen)
	{
		this.fechaExamen = fechaExamen;
	}

	public void setEstudiante(Estudiante e)
	{
		estudiante = e;

	}

	public Estudiante getEstudiante()
	{
		if (estudiante == null)
			estudiante = new Estudiante();
		return estudiante;
	}

	public String getApellidosNombre()
	{
		return (getPaterno() + ' ' + getMaterno() + ' ' + getNombre()).replaceFirst("  ", " ");
	}

	public String getId()
	{
		return id;
	}

	public boolean isPagoValidado()
	{
		return pagoValidado;
	}

	public void setPagoValidado(boolean pagoValidado)
	{
		this.pagoValidado = pagoValidado;
	}

	public String getFechaBanco()
	{
		return fechaBanco;
	}

	public void setFechaBanco(String fechaBanco)
	{
		this.fechaBanco = fechaBanco;
	}

	public String getMatricula()
	{
		return matricula;
	}

	public void setMatricula(String matricula)
	{
		this.matricula = matricula.trim().toUpperCase();
	}

	public boolean isAplicoExamenAdmision()
	{
		return aplicoExamenAdmision;
	}

	public void setAplicoExamenAdmision(boolean aplicoExamenAdmision)
	{
		this.aplicoExamenAdmision = aplicoExamenAdmision;
	}

	public void setId(String periodo, String curp)
	{
		this.id = periodo + "~" + curp.trim().toUpperCase();
	}

	public String getTelefonoCasa()
	{
		return telefonoCasa;
	}

	public void setTelefonoCasa(String telefonoCasa)
	{
		this.telefonoCasa = telefonoCasa;
		estudiante.setTelefono(telefonoCasa);
	}

	public String getCelular()
	{
		return celular;
	}

	public void setCelular(String celular)
	{
		this.celular = celular;
		estudiante.setCelular(celular);
	}

	public String getCorreo()
	{
		return correo;
	}

	public void setCorreo(String correo)
	{
		this.correo = correo.toLowerCase();
		estudiante.setCorreo(this.correo);
	}

	public String getPeriodo()
	{
		return periodo;
	}

	public void setPeriodo(String periodo)
	{
		this.periodo = periodo;
	}

	public String getAutBanco()
	{
		return autBanco;
	}

	public void setAutBanco(String autBanco)
	{
		this.autBanco = autBanco;
	}

	public String getCurp()
	{
		return curp;
	}

	public void setCurp(String curp)
	{
		this.curp = curp.trim().toUpperCase();
		estudiante.setCURP(this.curp);
	}

	public String getPaterno()
	{
		return paterno;
	}

	public void setPaterno(String paterno)
	{
		this.paterno = paterno.trim().toUpperCase();
		estudiante.setPaterno(this.paterno);

	}

	public String getMaterno()
	{
		return materno;
	}

	public void setMaterno(String materno)
	{
		this.materno = materno.trim().toUpperCase();
		estudiante.setMaterno(this.materno);

	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre.trim().toUpperCase();
		estudiante.setNombre(this.nombre);
	}

	public String getCarrera()
	{
		return carrera;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera.trim().toUpperCase();
	}

	public boolean isAceptado()
	{
		return aceptado;
	}

	public void setAceptado(boolean aceptado)
	{
		this.aceptado = aceptado;
	}

	public String toString()
	{
		return getPaterno() + " " + getMaterno() + " " + getNombre() + " [" + getCorreo() + "]";
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
