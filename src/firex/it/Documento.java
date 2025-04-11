package firex.it;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Documento implements IsSerializable, Mapa
{
	String id;
	String periodo;
	String fecha;
	String tipo;
	String usuario;
	String control;
	String formatoArchivo;

	public Documento()
	{
		this(new Date().getTime());
	}

	public Documento(long fechaGeneracion)
	{
		periodo = "sinPeriodo";
		fecha = "";
		tipo = "";
		usuario = "---";
		control = "";
		formatoArchivo = "";
	}

	public Documento(Map<String, Object> m)
	{
		fromMap(m);
	}

	static public Documento nuevaInstancia(Map<String, Object> m)
	{
		switch ((String) m.get("documento"))
		{
		case "expediente":
			return new DocumentoExpediente(m);
		case "empleado":
			return new DocumentoEmpleado(m);
		default:
			return new Documento(m);
		}
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", id);
		m.put("periodo", periodo);
		m.put("fecha", fecha);
		m.put("tipo", tipo);
		m.put("usuario", usuario);
		m.put("control", control);
		m.put("formatoArchivo", formatoArchivo);
		m.put("documento", "documento");
		return m;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		id = "" + m.get("id");
		periodo = (String) m.get("periodo");
		fecha = (String) m.get("fecha");
		tipo = (String) m.get("tipo");
		usuario = (String) m.get("usuario");
		formatoArchivo = (String) m.get("formatoArchivo");
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getFormatoArchivo()
	{
		return formatoArchivo;
	}

	public void setFormatoArchivo(String formatoArchivo)
	{
		this.formatoArchivo = formatoArchivo;
	}

	public String getPeriodo()
	{
		return periodo;
	}

	public void setPeriodo(String periodo)
	{
		if (periodo == null)
			periodo = "sinPeriodo";
		this.periodo = periodo;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo.toUpperCase();
	}

	public String getUsuario()
	{
		return usuario;
	}

	public void setUsuario(String usuario)
	{
		if (usuario == null)
			usuario = "---";
		this.usuario = usuario;
	}

	public String getControl()
	{
		return control;
	}

	public void setControl(String control)
	{
		if (control == null)
			control = "---";
		this.control = control;
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
