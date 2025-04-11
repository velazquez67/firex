package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class MateriaResidencia extends Materia implements IsSerializable
{
	public MateriaResidencia()
	{
		super();
	}

	public MateriaResidencia(String clavePlan, String clave)
	{
		super(clavePlan, clave);
	}

	public MateriaResidencia(Map<String, Object> m)
	{
		super(m);
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "residencia");
		return m;
	}
}
