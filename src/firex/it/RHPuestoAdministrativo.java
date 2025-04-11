package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RHPuestoAdministrativo implements IsSerializable, Mapa
	{
		String	nombre;
		String	departamento;

		public RHPuestoAdministrativo()
			{
				nombre = "";
				departamento = "";
			}

		public RHPuestoAdministrativo(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("nombre", nombre);
				m.put("departamento", departamento);
				return m;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				nombre = (String) m.get("nombre");
				departamento = (String) m.get("departamento");
			}

		public String getNombre()
			{
				return nombre;
			}

		public void setNombre(String nombre)
			{
				this.nombre = nombre;
			}

		public String getDepartamento()
			{
				return departamento;
			}

		public void setDepartamento(String departamento)
			{
				this.departamento = departamento;
			}

		public String toString()
			{
				return nombre;
			}

		@Override
		public String gets(String campo)
			{
				// TODO Auto-generated method stub
				return null;
			}

		@Override
		public Object get(String campo)
			{
				// TODO Auto-generated method stub
				return null;
			}
	}
