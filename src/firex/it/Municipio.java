package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Municipio implements IsSerializable, Mapa
	{
		String	numero;
		String	nombre;

		public Municipio()
			{
				numero = "";
				nombre = "";
			}

		public Municipio(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				HashMap<String, Object> aux = new HashMap<String, Object>();
				aux.put("numero", numero);
				aux.put("nombre", nombre);
				return aux;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				numero = (String) m.get("numero");
				nombre = (String) m.get("nombre");
			}

		public String getNumero()
			{
				return numero;
			}

		public void setNumero(String numero)
			{
				this.numero = numero;
			}

		public String getNombre()
			{
				return nombre;
			}

		public void setNombre(String nombre)
			{
				this.nombre = nombre;
			}

		public String toString()
			{
				return nombre;
			}

		@Override
		public String gets(String campo)
			{
				return null;
			}

		@Override
		public Object get(String campo)
			{
				return null;
			}
	}
