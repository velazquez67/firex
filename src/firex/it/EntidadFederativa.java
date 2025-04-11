package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import com.google.gwt.user.client.rpc.IsSerializable;

public class EntidadFederativa implements IsSerializable, Mapa
{
	String numero;
	String nombre;
	String abreviado;
	String CURP;
	ArrayList<Municipio> municipios;
	HashMap<String, String> ordenados; // Ignore

	public EntidadFederativa()
	{
		municipios = new ArrayList<Municipio>();
		ordenados = null;
	}

	public EntidadFederativa(Map<String, Object> m)
	{
		this();
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		HashMap<String, Object> m = new HashMap<String, Object>();
		m.put("numero", numero);
		m.put("nombre", nombre);
		m.put("abreviado", abreviado);
		m.put("CURP", CURP);
		m.put("municipios", municipios);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		numero = (String) m.get("numero");
		nombre = (String) m.get("nombre");
		abreviado = (String) m.get("abreviado");
		abreviado = "";
		CURP = (String) m.get("CURP");
		ArrayList<Map<String, Object>> aux = (ArrayList<Map<String, Object>>) m.get("municipios");
		for (int x = 0; x < aux.size(); x++)
			municipios.add(new Municipio(aux.get(x)));
	}

	public String getNumero()
	{
		return numero;
	}

	public String getCURP()
	{
		return CURP;
	}

	public void setCURP(String cURP)
	{
		CURP = cURP;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
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

	public ArrayList<Municipio> getMunicipios()
	{
		return municipios;
	}

	public void setMunicipios(ArrayList<Municipio> municipios)
	{
		this.municipios = municipios;
	}

	public HashMap<String, String> getMunicipiosOrdenados()
	{
		if (ordenados != null)
			return ordenados;
		int x, total = municipios.size();
		Municipio m;
		TreeMap<String, String> aux = new TreeMap<String, String>();
		for (x = 0; x < total; x++)
		{
			m = municipios.get(x);
			aux.put(m.getNumero(), m.getNombre());
		}
		ordenados = new HashMap<String, String>(aux);
		return ordenados;
	}

	public String toString()
	{
		return nombre;
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
