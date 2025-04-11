package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DepartamentoAdministrativo extends Departamento implements IsSerializable, Mapa
{
	public DepartamentoAdministrativo()
	{
	}

	public DepartamentoAdministrativo(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "administrativo");
		return m;
	}
}
