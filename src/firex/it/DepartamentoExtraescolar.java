package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DepartamentoExtraescolar extends Departamento implements IsSerializable,Mapa
	{
		String jefeActividadDeportiva;
		String jefeActividadCultural;

		public DepartamentoExtraescolar()
			{
				jefeActividadCultural = "";
				jefeActividadDeportiva = "";
			}
		
		

		public DepartamentoExtraescolar(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = super.toMap();
				m.put("tipo", "extraescolar");
				return m;
			}

		public String getJefeActividadDeportiva()
			{
				return jefeActividadDeportiva;
			}

		public void setJefeActividadDeportiva(String jefeActividadDeportiva)
			{
				this.jefeActividadDeportiva = jefeActividadDeportiva;
			}

		public String getJefeActividadCultural()
			{
				return jefeActividadCultural;
			}

		public void setJefeActividadCultural(String jefeActividadCultural)
			{
				this.jefeActividadCultural = jefeActividadCultural;
			}
	}