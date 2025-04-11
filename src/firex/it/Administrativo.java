package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Administrativo extends Empleado implements IsSerializable
	{
		public Administrativo()
			{
			}

		public Administrativo(Map<String, Object> datos)
			{
				super(datos);
			}

		public Map<String, Object> toMap()
			{
				Map<String, Object> m = super.toMap();
				m.put("tipo","administrativo");
				return m;
			}
	}
