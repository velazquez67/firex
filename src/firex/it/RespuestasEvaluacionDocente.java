package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class RespuestasEvaluacionDocente implements IsSerializable, Mapa
	{
		String	id;								// periodo|materia|grupo|control
		String	control;
		String	periodo;
		String	idGrupo;
		String	materia;
		String	clavePlan;
		String	claveDepartamento;
		String	respuestas;
	//	@Ignore
		String	docente;

		public RespuestasEvaluacionDocente()
			{
			}

		public RespuestasEvaluacionDocente(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("id", id);
				m.put("control", control);
				m.put("periodo", periodo);
				m.put("idGrupo", idGrupo);
				m.put("materia", materia);
				m.put("clavePlan", clavePlan);
				m.put("claveDepartamento", claveDepartamento);
				m.put("respuestas", respuestas);
				return m;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				id = (String) m.get("id");
				control = (String) m.get("control");
				periodo = (String) m.get("periodo");
				idGrupo = (String) m.get("idGrupo");
				materia = (String) m.get("materia");
				clavePlan = (String) m.get("clavePlan");
				claveDepartamento = (String) m.get("claveDepartamento");
				respuestas = (String) m.get("respuestas");
			}

		public String getId()
			{
				return id;
			}

		public String getPeriodo()
			{
				return periodo;
			}

		public String getDocente()
			{
				return docente;
			}

		public void setDocente(String docente)
			{
				this.docente = docente;
			}

		public RespuestasEvaluacionDocente(String periodo, String materia, String grupo,
		  String control, String clavePlan, String claveDepartamento, String respuestas)
			{
				id = periodo + '|' + materia + '|' + grupo + '|' + control;
				idGrupo = periodo + '|' + materia + '|' + grupo;
				this.control = control;
				this.periodo = periodo;
				this.materia = materia;
				this.clavePlan = clavePlan;
				this.claveDepartamento = claveDepartamento;
				this.respuestas = respuestas;
			}

		public String getClavePlan()
			{
				return clavePlan;
			}

		public String getClaveDepartamento()
			{
				return claveDepartamento;
			}

		public String getControl()
			{
				return control;
			}

		public String getRespuestas()
			{
				return respuestas;
			}

		public String getIdGrupo()
			{
				return idGrupo;
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
