package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class MateriaServicioSocial extends Materia implements IsSerializable
{
	public MateriaServicioSocial()
	{
		super();
	}

	public MateriaServicioSocial(String clavePlan, String clave)
	{
		super(clavePlan, clave);
	}

	public MateriaServicioSocial(Map<String, Object> m)
	{
		super(m);
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "servicioSocial");
		return m;
	}
}
