package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RHCategoria implements IsSerializable, Mapa
	{
		Map<String, Object>	datos;

		public RHCategoria()
			{
				datos = new HashMap<String, Object>();
			}

		public RHCategoria(Map<String, Object> m)
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

		public String getNombre()
			{
				return gets("nombre");
			}

		public void setNombre(String nombre)
			{
				datos.put("nombre", nombre);
			}

		public String getId()
			{
				return gets("id");
			}

		public void setId(String id)
			{
				datos.put("id", id);
			}

		public String getNivel()
			{
				return gets("nivel");
			}

		public void setNivel(String nivel)
			{
				datos.put("nivel", nivel);
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
