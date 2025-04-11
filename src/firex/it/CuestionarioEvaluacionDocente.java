package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class CuestionarioEvaluacionDocente implements IsSerializable, Mapa
	{
		String						id;
		boolean						yaResolvio;
		ArrayList<String>	preguntas;
		ArrayList<String>	dimension;
		ArrayList<Double>	valor;
		HorarioEstudiante	horario;

		public CuestionarioEvaluacionDocente()
			{
				preguntas = new ArrayList<String>();
				dimension = new ArrayList<String>();
				valor = new ArrayList<Double>();
				yaResolvio = false;
			}

		public CuestionarioEvaluacionDocente(String id)
			{
				this();
				this.id = id;
			}

		public CuestionarioEvaluacionDocente(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("id", id);
				m.put("preguntas", preguntas);
				m.put("dimension", dimension);
				m.put("valor", valor);
				return m;
			}

		@SuppressWarnings("unchecked")
		@Override
		public void fromMap(Map<String, Object> m)
			{
				id = (String) m.get("id");
				preguntas = (ArrayList<String>) m.get("preguntas");
				dimension = (ArrayList<String>) m.get("dimension");
				valor = (ArrayList<Double>) m.get("valor");
			}

		public ArrayList<String> getPreguntas()
			{
				return preguntas;
			}

		public int getTotalPreguntas()
			{
				return preguntas.size();
			}

		public void resuelto()
			{
				yaResolvio = true;
			}

		public boolean siYaResuelto()
			{
				return yaResolvio;
			}

		public HorarioEstudiante getHorario()
			{
				return horario;
			}

		public void setHorario(HorarioEstudiante horario)
			{
				this.horario = horario;
			}

		public void setPregunta(String pregunta, String dimension, double valor)
			{
				this.preguntas.add(pregunta);
				this.dimension.add(dimension);
				this.valor.add(valor);
			}

		public ArrayList<Double> getValor()
			{
				return valor;
			}

		public String getId()
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
