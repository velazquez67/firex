package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class AsistenciaAula implements IsSerializable, Mapa
	{
		String	aula;
		long			dia;
		String	docente;
		String	fecha;
		String	id;
		String idGrupo;
		long			status;
		long			hora;

		public AsistenciaAula()
			{
				aula = "";
				dia = 1;
				docente = "";
				fecha = "";
				hora = 7;
				id = "";
				idGrupo = "";
				status = 0;
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("aula", getAula());
				data.put("dia", getDia());
				data.put("docente", getDocente());
				data.put("fecha", getFecha());
				data.put("hora", getHora());
				data.put("id", getId());
				data.put("idGrupo", getIdGrupo());
				data.put("status", getStatus());
				return data;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				setAula((String) m.get("aula"));
				setDia((Long) m.get("dia"));
				setDocente((String) m.get("docente"));
				setFecha((String) m.get("fecha"));
				setHora((Long) m.get("hora"));
				setId((String) m.get("id"));
				setIdGrupo((String) m.get("idGrupo"));
				setStatus((Long) m.get("status"));
			}

		public String getAula()
			{
				return aula;
			}

		public void setAula(String aula)
			{
				this.aula = aula;
			}

		public long getDia()
			{
				return dia;
			}

		public void setDia(long dia)
			{
				this.dia = dia;
			}

		public String getDocente()
			{
				return docente;
			}

		public void setDocente(String docente)
			{
				this.docente = docente;
			}

		public String getFecha()
			{
				return fecha;
			}

		public void setFecha(String fecha)
			{
				this.fecha = fecha;
			}

		public long getHora()
			{
				return hora;
			}

		public void setHora(long hora)
			{
				this.hora = hora;
			}

		public String getId()
			{
				return id;
			}

		public void setId(String id)
			{
				this.id = id;
			}

		public String getIdGrupo()
			{
				return idGrupo;
			}

		public void setIdGrupo(String idGrupo)
			{
				this.idGrupo = idGrupo;
			}

		public long getStatus()
			{
				return status;
			}

		public void setStatus(long status)
			{
				this.status = status;
			}

		@Override
		public String gets(String campo)
			{
				return "";
			}

		@Override
		public Object get(String campo)
			{
				return null;
			}
	}
