package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Excel implements IsSerializable, Mapa
{
	 String id;
	String datos;
	String nombreArchivo;
	String nombreHoja;

	public Excel()
	{
	}

	public Excel(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", id);
		res.put("datos", datos);
		res.put("nombreArchivo", nombreArchivo);
		res.put("nombreHoja", nombreHoja);
		return res;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		id = (String) m.get("id");
		datos = (String) m.get("datos");
		nombreArchivo = (String) m.get("nombreArchivo");
		nombreHoja = (String) m.get("nombreHoja");
	}

	public String getNombreArchivo()
	{
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo)
	{
		this.nombreArchivo = nombreArchivo;
	}

	public String getNombreHoja()
	{
		return nombreHoja;
	}

	public void setNombreHoja(String nombreHoja)
	{
		this.nombreHoja = nombreHoja;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDatos()
	{
		return datos;
	}

	public void setDatos(String datos)
	{
		this.datos = datos;
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
