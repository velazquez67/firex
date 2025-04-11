package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RecuperacionPassword implements IsSerializable, Mapa
	{
		Map<String, Object> datos;

		public RecuperacionPassword()
			{
				datos = new HashMap<String, Object>();
			}

		public RecuperacionPassword(Map<String, Object> m)
			{
				datos = m;
			}

		@Override
		public Map<String, Object> toMap()
			{
				return datos;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				datos = m;
			}

		public String getId()
			{
				return gets("id");
			}

		public void setId(String id)
			{
				datos.put("id", id);
			}

		public String getControl()
			{
				return gets("control");
			}

		public void setControl(String control)
			{
				datos.put("control", control);
			}

		public String getNombre()
			{
				return gets("nombre");
			}

		public void setNombre(String nombre)
			{
				datos.put("nombre", nombre);
			}

		@Override
		public String gets(String campo)
			{
				return (String) datos.get(campo);
			}

		@Override
		public Object get(String campo)
			{
				return datos.get(campo);
			}
	}
