package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class MateriaTutoria extends MateriaExtraescolar implements IsSerializable
{
	public MateriaTutoria()
	{
		super();
	}

	public MateriaTutoria(String clavePlan, String clave)
	{
		super(clavePlan, clave);
	}

	public MateriaTutoria(Map<String, Object> m)
	{
		super(m);
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "tutoria");
		return m;
	}
}
