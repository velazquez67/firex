package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RHActividad implements IsSerializable, Mapa
	{
		String						id;
		String						nombre;
		ArrayList<String>	metas;
		boolean						activa;

		public RHActividad()
			{
				activa = true;
				metas = new ArrayList<String>();
			}

		public RHActividad(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> r = new HashMap<String, Object>();
				r.put("id", id);
				r.put("nombre", nombre);
				r.put("metas", metas);
				r.put("activa", activa);
				return r;
			}

		@SuppressWarnings("unchecked")
		@Override
		public void fromMap(Map<String, Object> m)
			{
				setId((String) m.get("id"));
				setNombre((String) m.get("nombre"));
				setMetas((ArrayList<String>) m.get("metas"));
				setActiva((Boolean) m.get("activa"));
			}

		public String getId()
			{
				return id;
			}

		public void setId(String id)
			{
				this.id = id;
			}

		public void setMetas(ArrayList<String> metas)
			{
				this.metas = metas;
			}

		public ArrayList<String> getMetas()
			{
				return metas;
			}

		public String getNombre()
			{
				return nombre;
			}

		public void setNombre(String nombre)
			{
				this.nombre = nombre;
			}

		public boolean isActiva()
			{
				return activa;
			}

		public void setActiva(boolean activa)
			{
				this.activa = activa;
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
