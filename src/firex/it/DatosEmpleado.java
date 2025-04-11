package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DatosEmpleado implements IsSerializable, Mapa
{
	String rfc;
	String estudios;
	String ultimoGradoEstudios; // P primaria S secundaria B
															// bachillerato o preparatoria O Otro
	private ArrayList<RHPlaza> plazas;
	private ArrayList<RHPuestoAdministrativo> puestos;
	String puesto;
	String departamentoPuesto;
	String ingresoSep;
	long tarjeta;
	String ingresoInstituto;

	public DatosEmpleado()
	{
		rfc = "";
		estudios = "";
		ultimoGradoEstudios = "";
		plazas = new ArrayList<RHPlaza>();
		puestos = new ArrayList<RHPuestoAdministrativo>();
		puesto = "";
		departamentoPuesto = "";
		ingresoSep = "";
		ingresoInstituto = "";
		tarjeta = 0;
	}

	public DatosEmpleado(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("rfc", rfc);
		m.put("estudios", estudios);
		m.put("ultimoGradoEstudios", ultimoGradoEstudios);
		m.put("puesto", puesto);
		m.put("departamentoPuesto", departamentoPuesto);
		m.put("ingresoSep", ingresoSep);
		m.put("ingresoInstituto", ingresoInstituto);
		m.put("tarjeta", tarjeta);
		m.put("plazas", plazasToMap());
		m.put("puestos", puestosToMap());
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> m)
	{
		rfc = (String) m.get("rfc");
		estudios = (String) m.get("estudios");
		ultimoGradoEstudios = (String) m.get("ultimoGradoEstudios");
		puesto = (String) m.get("puesto");
		departamentoPuesto = (String) m.get("departamentoPuesto");
		ingresoSep = (String) m.get("ingresoSep");
		ingresoInstituto = (String) m.get("ingresoInstituto");
		tarjeta = (Long) m.get("tarjeta");
		plazas = new ArrayList<RHPlaza>();
		puestos = new ArrayList<RHPuestoAdministrativo>();
		ArrayList<Map<String, Object>> aux = (ArrayList<Map<String, Object>>) m.get("plazas");
		for (int x = 0; x < aux.size(); x++)
			plazas.add(new RHPlaza(aux.get(x)));
		aux = (ArrayList<Map<String, Object>>) m.get("puestos");
		for (int x = 0; x < aux.size(); x++)
			puestos.add(new RHPuestoAdministrativo(aux.get(x)));
	}

	public ArrayList<Map<String, Object>> plazasToMap()
	{
		ArrayList<Map<String, Object>> m = new ArrayList<Map<String, Object>>();
		for (int x = 0; x < plazas.size(); x++)
			m.add(plazas.get(x).toMap());
		return m;
	}

	public ArrayList<Map<String, Object>> puestosToMap()
	{
		ArrayList<Map<String, Object>> m = new ArrayList<Map<String, Object>>();
		for (int x = 0; x < puestos.size(); x++)
			m.add(puestos.get(x).toMap());
		return m;
	}

	public ArrayList<RHPuestoAdministrativo> getPuestos()
	{
		return puestos;
	}

	public long getTarjeta()
	{
		return tarjeta;
	}

	public void setTarjeta(long tarjeta)
	{
		this.tarjeta = tarjeta;
	}

	public ArrayList<RHPlaza> getPlazas()
	{
		return plazas;
	}

	/*
	 * public String getPuesto() { return puesto; }
	 * 
	 * public void setPuesto(String puesto) { if(puesto==null) puesto="";
	 * this.puesto = puesto; }
	 */
	public String getDepartamentoPuesto()
	{
		return departamentoPuesto;
	}

	public void setDepartamentoPuesto(String departamentoPuesto)
	{
		this.departamentoPuesto = departamentoPuesto;
	}

	public String getIngresoSep()
	{
		return ingresoSep;
	}

	public void setIngresoSep(String ingresoSep)
	{
		this.ingresoSep = ingresoSep;
	}

	public String getIngresoInstituto()
	{
		return ingresoInstituto;
	}

	public void setIngresoInstituto(String ingresoInstituto)
	{
		this.ingresoInstituto = ingresoInstituto;
	}

	public String getRfc()
	{
		return rfc;
	}

	public void setRfc(String rfc)
	{
		this.rfc = rfc;
	}

	public String getEstudios()
	{
		return estudios;
	}

	public void setEstudios(String estudios)
	{
		this.estudios = estudios;
	}

	public String getUltimoGradoEstudios()
	{
		return ultimoGradoEstudios;
	}

	public void setUltimoGradoEstudios(String ultimoGradoEstudios)
	{
		this.ultimoGradoEstudios = ultimoGradoEstudios;
	}

	public int getHorasNombramiento()
	{
		int suma = 0;
		for (int x = 0; x < plazas.size(); x++)
			suma += plazas.get(x).getHoras();
		return suma;
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
