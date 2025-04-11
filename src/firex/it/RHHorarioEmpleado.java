package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RHHorarioEmpleado implements IsSerializable, Mapa
	{
		String	id;						// periodo+"~"+tarjeta+"~"+fecha
		long			tarjeta;
		String	fecha;				// dia/mes/a�o
		String	actividades;
		boolean	bloqueado;
		String	periodo;
		String	observaciones;
		boolean	validado;
		String	corregir;			// indicaciones de recursos humanos para correccion del horario

		public RHHorarioEmpleado()
			{
				actividades = null;
				bloqueado = false;
				observaciones = "";
				corregir = "";
			}

		public RHHorarioEmpleado(String periodo, int tarjeta, String fecha)
			{
				this();
				this.periodo = periodo;
				this.tarjeta = tarjeta;
				this.fecha = fecha;
				id = periodo + "~" + tarjeta + "~" + fecha.replace("/","-");
			}

		public RHHorarioEmpleado(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("id", id.replace("/","-"));
				m.put("tarjeta", tarjeta);
				m.put("fecha", fecha);
				m.put("actividades", actividades);
				m.put("bloqueado", bloqueado);
				m.put("periodo", periodo);
				m.put("observaciones", observaciones);
				m.put("validado", validado);
				m.put("corregir", corregir);
				return m;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				id = ((String) m.get("id")).replace("/","-");
				tarjeta = (Long) m.get("tarjeta");
				fecha = (String) m.get("fecha");
				actividades = (String) m.get("actividades");
				bloqueado = (Boolean) m.get("bloqueado");
				periodo = (String) m.get("periodo");
				observaciones = (String) m.get("observaciones");
				validado = (Boolean) m.get("validado");
				corregir = (String) m.get("corregir");
			}

		public void setId(String id)
			{
				this.id = id.replace("/","-");
			}

		public void setTarjeta(long tarjeta)
			{
				this.tarjeta = tarjeta;
			}

		public String getCorregir()
			{
				return corregir;
			}

		public void setCorregir(String corregir)
			{
				if(corregir == null)
					corregir = "";
				this.corregir = corregir;
			}

		public String getObservaciones()
			{
				return observaciones;
			}

		public void setObservaciones(String observaciones)
			{
				this.observaciones = observaciones;
			}

		public boolean isValidado()
			{
				return validado;
			}

		public void setValidado(boolean validado)
			{
				this.validado = validado;
			}

		public String getPeriodo()
			{
				return periodo;
			}

		public void setPeriodo(String periodo)
			{
				this.periodo = periodo;
			}

		public boolean isBloqueado()
			{
				return bloqueado;
			}

		public void setBloqueado(boolean bloqueado)
			{
				this.bloqueado = bloqueado;
			}

		public String getId()
			{
				return id.replace("/","-");
			}

		public long getTarjeta()
			{
				return tarjeta;
			}

		public String getFecha()
			{
				return fecha;
			}

		public void setFecha(String fecha)
			{
				this.fecha = fecha;
			}

		public String getActividades()
			{
				return actividades;
			}

		public void setActividades(String actividades)
			{
				this.actividades = actividades;
			}

		public String getYearMesDia()
			{
				return fecha.substring(6, 10) + "/" + fecha.substring(3, 5) + "/" + fecha.substring(0, 2);
			}

		public String toString()
			{
				return id;
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
