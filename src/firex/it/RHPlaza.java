package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;


public class RHPlaza implements IsSerializable, Mapa
	{
		String clavePresupuestal;
		String categoria;
		long   horas;
		long   nombramiento;

		public RHPlaza()
			{
				clavePresupuestal = "";
				categoria = "";
				horas = 0;
				nombramiento = 0;
			}

		public RHPlaza(String clavePresupuestal)
			{
				this.clavePresupuestal = clavePresupuestal;
			}

		public RHPlaza(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("clavePresupuestal", clavePresupuestal);
				m.put("categoria", categoria);
				m.put("horas", horas);
				m.put("nombramiento", nombramiento);
				return m;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				clavePresupuestal = (String) m.get("clavePresupuestal");
				categoria = (String) m.get("categoria");
				horas = (Long) m.get("horas");
				nombramiento = (Long) m.get("nombramiento");
			}

		public long getNombramiento()
			{
				return nombramiento;
			}

		public void setNombramiento(int nombramiento)
			{
				this.nombramiento = nombramiento;
			}

		public String getClavePresupuestal()
			{
				return clavePresupuestal;
			}

		public void setClavePresupuestal(String clavePresupuestal)
			{
				this.clavePresupuestal = clavePresupuestal;
			}

		public String getCategoria()
			{
				return categoria;
			}

		public void setCategoria(String categoria)
			{
				this.categoria = categoria;
			}

		public long getHoras()
			{
				return horas;
			}

		public void setHoras(int horas)
			{
				this.horas = horas;
			}

		public String toString()
			{
				return clavePresupuestal;
			}

		public boolean equals(Object obj)
			{
				String clave;
				if(obj instanceof RHPlaza)
					clave = ((RHPlaza) obj).getClavePresupuestal();
				else
					clave = obj.toString();
				return clavePresupuestal.equals(clave);
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
