package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class MateriaAcademica extends MateriaExtraescolar implements IsSerializable
{
	public MateriaAcademica()
	{
		super();
	}

	public MateriaAcademica(String clavePlan, String clave)
	{
		super(clavePlan, clave);
	}

	public MateriaAcademica(Map<String, Object> m)
	{
		super(m);
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "academica");
		return m;
	}
}
