package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DepartamentoAcademico extends Departamento implements IsSerializable, Mapa
{
	public DepartamentoAcademico()
	{
	}

	public DepartamentoAcademico(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "academico");
		return m;
	}
}
