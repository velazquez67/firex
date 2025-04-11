package firex.it;

import java.util.Map;

public class MateriaGrupo
{
	Map<String, Object> data;

	MateriaGrupo(Map<String, Object> data)
	{
		this.data = data;
	}

	public String getAbreviado()
	{
		return (String) data.get("abreviado");
	}

	public String getCarrera()
	{
		return (String) data.get("carrera");
	}

	public String getClave()
	{
		return (String) data.get("clave");
	}

	public String getClavePlan()
	{
		return (String) data.get("clavePlan");
	}

	public int getCreditos()
	{
		Long i = (Long) data.get("creditos");
		return i.intValue();
	}
}
