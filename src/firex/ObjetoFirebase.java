package firex;



import java.util.HashMap;
import java.util.Map;


public class ObjetoFirebase implements  Mapa
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
	}
