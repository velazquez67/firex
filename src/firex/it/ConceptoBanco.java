package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ConceptoBanco implements IsSerializable, Mapa
{
	String concepto;
	String id;
	String costo;
	boolean activo;
	String semestre; 

	public ConceptoBanco()
	{
		concepto = "";
		id = "";
		costo = "";
		activo = true;
		semestre = "Todos";
	}

	public ConceptoBanco(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("concepto", concepto);
		m.put("id", id);
		m.put("costo", costo);
		m.put("activo", activo);
		m.put("semestre", semestre);
		return m;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		concepto = (String) m.get("concepto");
		id = (String) m.get("id");
		costo = (String) m.get("costo");
		activo = (Boolean) m.get("activo");
		semestre = (String) m.get("semestre");
	}

	public String getConcepto()
	{
		return concepto;
	}

	public void setConcepto(String concepto)
	{
		this.concepto = concepto;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCosto()
	{
		return costo;
	}

	public void setCosto(String costo)
	{
		this.costo = costo;
	}

	public boolean isActivo()
	{
		return activo;
	}

	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}

	public String getSemestre()
	{
		return semestre;
	}

	public void setSemestre(String semestre)
	{
		this.semestre = semestre;
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
