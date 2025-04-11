package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class MateriaExtraescolar extends Materia implements IsSerializable
{
	public MateriaExtraescolar()
	{
		super();
	}

	public MateriaExtraescolar(String clavePlan, String clave)
	{
		super(clavePlan, clave);
	}

	public MateriaExtraescolar(Map<String, Object> m)
	{
		super(m);
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "extraescolar");
		return m;
	}
}
