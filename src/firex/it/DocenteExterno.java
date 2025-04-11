package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DocenteExterno extends Docente implements IsSerializable
{
	public DocenteExterno()
	{
	}

	public DocenteExterno(Map<String, Object> datos)
	{
		super(datos);

	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "docenteExterno");
		return m;
	}
}
