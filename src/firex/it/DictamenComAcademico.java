package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DictamenComAcademico implements IsSerializable, Mapa
{
	String id; // numeroLibro~numero
	 String numero;
	 String control;
	String periodo;
	 String idSolicitud;
	 String numeroSolicitud;
	 String respuesta; // SI o NO
	 String foja;
	 String fechaRegistro;
	 String libroActas;
	 String director;
	 String subdirector;
	 String jefeEscolares;
	 long fechaGeneracionNumero;
	 String solicitud;
	 boolean ejecutadoPorEscolares;
	boolean dictamenCancelado;
	String recomendacion;
	// @Ignore
	Estudiante estudiante;

	public DictamenComAcademico()
	{
		id = "";
		numero = "";
		control = "";
		periodo = "";
		idSolicitud = "";
		numeroSolicitud = "";
		respuesta = "";
		foja = "";
		fechaRegistro = "";
		libroActas = "";
		director = "";
		subdirector = "";
		jefeEscolares = "";
		fechaGeneracionNumero = 0;
		solicitud = null;
		ejecutadoPorEscolares = false;
		dictamenCancelado = false;
		estudiante = null;
		recomendacion = "";
	}

	public DictamenComAcademico(Map<String, Object> m)
	{
		this();
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", id);
		m.put("numero", numero);
		m.put("control", control);
		m.put("periodo", periodo);
		m.put("idSolicitud", idSolicitud);
		m.put("numeroSolicitud", numeroSolicitud);
		m.put("respuesta", respuesta);
		m.put("foja", foja);
		m.put("fechaRegistro", fechaRegistro);
		m.put("libroActas", libroActas);
		m.put("director", director);
		m.put("subdirector", subdirector);
		m.put("jefeEscolares", jefeEscolares);
		m.put("fechaGeneracionNumero", fechaGeneracionNumero);
		m.put("solicitud", solicitud);
		m.put("ejecutadoPorEscolares", ejecutadoPorEscolares);
		m.put("dictamenCancelado", dictamenCancelado);
		m.put("recomendacion", recomendacion);
		return m;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		id = (String) m.get("id");
		numero = (String) m.get("numero");
		control = (String) m.get("control");
		periodo = (String) m.get("periodo");
		idSolicitud = (String) m.get("idSolicitud");
		numeroSolicitud = (String) m.get("numeroSolicitud");
		respuesta = (String) m.get("respuesta");
		foja = (String) m.get("foja");
		fechaRegistro = (String) m.get("fechaRegistro");
		libroActas = (String) m.get("libroActas");
		director = (String) m.get("director");
		subdirector = (String) m.get("subdirector");
		jefeEscolares = (String) m.get("jefeEscolares");
		fechaGeneracionNumero = (Long) m.get("fechaGeneracionNumero");
		solicitud = (String) m.get("solicitud");
		ejecutadoPorEscolares = (Boolean) m.get("ejecutadoPorEscolares");
		dictamenCancelado = (Boolean) m.get("dictamenCancelado");
		if (m.get("recomendacion") == null)
			recomendacion = "";
		else
			recomendacion = (String) m.get("recomendacion");
	}

	public String getRecomendacion()
	{
		if (recomendacion == null)
			recomendacion = "";
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion)
	{
		if (recomendacion == null)
			recomendacion = "";
		this.recomendacion = recomendacion;
	}

	public Estudiante getEstudiante()
	{
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}

	public boolean isDictamenCancelado()
	{
		return dictamenCancelado;
	}

	public void setDictamenCancelado(boolean dictamenCancelado)
	{
		this.dictamenCancelado = dictamenCancelado;
	}

	public boolean isEjecutadoPorEscolares()
	{
		return ejecutadoPorEscolares;
	}

	public void setEjecutadoPorEscolares(boolean registradoPorEscolares)
	{
		this.ejecutadoPorEscolares = registradoPorEscolares;
	}

	public String getSolicitud()
	{
		return solicitud;
	}

	public void setSolicitud(String solicitud)
	{
		this.solicitud = solicitud;
	}

	public long getFechaGeneracionNumero()
	{
		return fechaGeneracionNumero;
	}

	public void setFechaGeneracionNumero(long fechaGeneracionNumero)
	{
		this.fechaGeneracionNumero = fechaGeneracionNumero;
	}

	public String getId()
	{
		return id;
	}

	public void setId()
	{
		this.id = respuesta + "~" + libroActas + "~" + numero;
	}

	public String getControl()
	{
		return control;
	}

	public void setControl(String control)
	{
		this.control = control;
	}

	public String getPeriodo()
	{
		return periodo;
	}

	public void setPeriodo(String periodo)
	{
		this.periodo = periodo;
	}

	public String getIdSolicitud()
	{
		return idSolicitud;
	}

	public void setIdSolicitud(String idSolicitud)
	{
		this.idSolicitud = idSolicitud;
	}

	public String getDirector()
	{
		return director;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}

	public String getSubdirector()
	{
		return subdirector;
	}

	public void setSubdirector(String subdirector)
	{
		this.subdirector = subdirector;
	}

	public String getJefeEscolares()
	{
		return jefeEscolares;
	}

	public void setJefeEscolares(String jefeEscolares)
	{
		this.jefeEscolares = jefeEscolares;
	}

	public void setRespuesta(String respuesta)
	{
		this.respuesta = respuesta;
	}

	public String getNumeroSolicitud()
	{
		return numeroSolicitud;
	}

	public void setNumeroSolicitud(String numeroSolicitud)
	{
		this.numeroSolicitud = numeroSolicitud;
	}

	public String getRespuesta()
	{
		return respuesta;
	}

	public boolean isSi()
	{
		return respuesta.equals("SI");
	}

	public boolean isNo()
	{
		return respuesta.equals("NO");
	}

	public boolean isCancelada()
	{
		return respuesta.equals("CANCELADA");
	}

	public boolean isPendiente()
	{
		return respuesta.length() == 0;
	}

	public void setSi()
	{
		respuesta = "SI";
	}

	public void setNo()
	{
		respuesta = "NO";
	}

	public void setCancelada()
	{
		respuesta = "CANCELADA";
	}

	public void setPendiente()
	{
		respuesta = "";
	}

	public String getLibroActas()
	{
		return libroActas;
	}

	public void setLibroActas(String libroActas)
	{
		this.libroActas = libroActas;
	}

	public String getFechaRegistro()
	{
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro)
	{
		this.fechaRegistro = fechaRegistro;
	}

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public String getFoja()
	{
		return foja;
	}

	public void setFoja(String foja)
	{
		this.foja = foja;
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
