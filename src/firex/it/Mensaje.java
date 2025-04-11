package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Mensaje implements IsSerializable, Mapa
{
	Map<String, Object> datos;

	public Mensaje()
	{
		datos = new HashMap<String, Object>();
	}

	public Mensaje(Map<String, Object> m)
	{
		datos = m;
	}

	@Override
	public Map<String, Object> toMap()
	{
		return datos;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		datos = m;
	}

	public String getId()
	{
		return gets("id");
	}

	public void setId(String id)
	{
		datos.put("id", id);
	}

	public String getUsuario()
	{
		return gets("usuario");
	}

	public void setUsuario(String usuario)
	{
		datos.put("usuario", usuario);
	}

	public String getPara()
	{
		return gets("para");
	}

	public void setPara(String para)
	{
		datos.put("para", para);
	}

	public String getTitulo()
	{
		return gets("titulo");
	}

	public void setTitulo(String titulo)
	{
		datos.put("titulo", titulo);
	}

	public String getMensaje()
	{
		return gets("mensaje");
	}

	public void setMensaje(String mensaje)
	{
		datos.put("mensaje", mensaje);
	}

	public String getSubtitulo()
	{
		return gets("subtitulo");
	}

	public void setSubtitulo(String subtitulo)
	{
		datos.put("subtitulo", subtitulo);
	}

	public String getFechaCreacion()
	{
		return gets("fechaCreacion");
	}

	public void setFechaCreacion(String fechaCreacion)
	{
		datos.put("fechaCreacion", fechaCreacion);
	}

	@Override
	public String gets(String campo)
	{
		return (String) datos.get(campo);
	}

	@Override
	public Object get(String campo)
	{
		return datos.get(campo);
	}
}
