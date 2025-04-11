package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Aula implements IsSerializable, Mapa
	{
		Map<String, Object> datos;

		public Aula()
			{
				datos = new HashMap<String, Object>();
			}
		
		public Aula(Map<String,Object> data)
		{
			datos = data;
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

		public boolean isActiva()
			{
				return (Boolean) datos.get("activa");
			}

		public void setActiva(boolean activa)
			{
				datos.put("activa", activa);
			}

		public String getNombre()
			{
				return gets("nombre");
			}

		public void setNombre(String nombre)
			{
				datos.put("nombre",nombre.trim());
			}

		public long getCapacidad()
			{
				return (Long) datos.get("capacidad");
			}

		public void setCapacidad(int capacidad)
			{
				datos.put("capacidad", capacidad);
			}

		public boolean equals(Object obj)
			{
				if(!(obj instanceof Aula))
					return false;
				return getNombre().equals(obj.toString());
			}

		public String toString()
			{
				return gets("nombre");
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
