package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ObjetoFirebase implements IsSerializable, Mapa
	{
		String              coleccion;
		String              id;
		Map<String, Object> datos;

		public ObjetoFirebase()
			{
				id = null;
				datos = new HashMap<String, Object>();
			}

		public ObjetoFirebase(String coleccion)
			{
				this();
				this.coleccion = coleccion;
			}

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
				return id;
			}

		public void setId(String id)
			{
				this.id = id;
			}

		public void put(String llave, Object valor)
			{
				datos.put(llave, valor);
			}

		public void set(String llave, Object valor)
			{
				datos.put(llave, valor);
			}

		public Object get(String llave)
			{
				return datos.get(llave);
			}

		public String getColeccion()
			{
				return coleccion;
			}

		public void setColeccion(String coleccion)
			{
				this.coleccion = coleccion;
			}

		public Map<String, Object> getDatos()
			{
				return datos;
			}

		public void setDatos(Map<String, Object> datos)
			{
				this.datos = datos;
			}

		@Override
		public String gets(String campo)
			{
				// TODO Auto-generated method stub
				return null;
			}
	}
