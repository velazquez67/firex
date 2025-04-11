package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class SolicitudComiteAcademico implements IsSerializable, Mapa
	{
		String									id;
		String									periodo;
		String									control;
		String									fecha;
		String									motivosAcademicos;
		String									motivosPersonales;
		String									otrosMotivos;
		String									nombreEstudiante;
		ArrayList<String>				asuntos;
		ArrayList<String>				solicitudes;
		HashMap<String, String>	resultados;				// KEY:RFC VALOR: PENDIENTE PENDIENTE
		// PENDIENTE ...
		HashMap<String, String> dictamenesx; // key: num solicitud, value SI, NO,
		// CANCELADO
		String			coordinador;
		boolean			autorizoEstudiante;
	//	@Ignore
		Estudiante	estudiante;
		boolean bloqueada;

		public SolicitudComiteAcademico()
			{
				id = "";
				periodo = "";
				control = "";
				fecha = "";
				motivosAcademicos = "";
				motivosPersonales = "";
				otrosMotivos = "";
				asuntos = new ArrayList<String>();
				solicitudes = new ArrayList<String>();
				resultados = new HashMap<String, String>();
				firma = "";
				clavePlan = "";
				nombreEstudiante = "";
				estudiante = null;
				dictamenesx = new HashMap<String, String>();
				coordinador = "";
				autorizoEstudiante = false;
				bloqueada=false;
			}

		public SolicitudComiteAcademico(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("id", id);
				m.put("periodo", periodo);
				m.put("control", control);
				m.put("fecha", fecha);
				m.put("motivosAcademicos", motivosAcademicos);
				m.put("asuntos", asuntos);
				m.put("solicitudes", solicitudes);
				m.put("resultados", resultados);
				m.put("firma", firma);
				m.put("clavePlan", clavePlan);
				m.put("nombreEstudiante", nombreEstudiante);
				m.put("dictamensx", dictamenesx);
				m.put("coordinador", coordinador);
				m.put("autorizoEstudiante", autorizoEstudiante);
				m.put("bloqueada", bloqueada);
				return m;
			}

		@SuppressWarnings("unchecked")
		@Override
		public void fromMap(Map<String, Object> m)
			{
				id = (String) m.get("id");
				periodo = (String) m.get("periodo");
				control = (String) m.get("control");
				fecha = (String) m.get("fecha");
				motivosAcademicos = (String) m.get("motivosAcademicos");
				motivosPersonales = (String) m.get("motivosPersonales");
				otrosMotivos = (String) m.get("otrosMotivos");
				asuntos = (ArrayList<String>) m.get("asuntos");
				solicitudes = (ArrayList<String>) m.get("solicitudes");
				resultados = (HashMap<String, String>) m.get("resultados");
				firma = (String) m.get("firma");
				clavePlan = (String) m.get("clavePlan");
				nombreEstudiante = (String) m.get("nombreEstudiante");
				dictamenesx = (HashMap<String, String>) m.get("dictamensx");
				coordinador = (String) m.get("coordinador");
				autorizoEstudiante = (Boolean) m.get("autorizoEstudiante");
				Boolean b= (Boolean)m.get("bloqueada");
				if(b==null)
					b=false;
				bloqueada=b;
			}

		public boolean isBloqueada()
		{
			return bloqueada;
		}

		public void setBloqueada(boolean bloqueada)
		{
			this.bloqueada = bloqueada;
		}

		public String getCoordinador()
			{
				return coordinador;
			}

		public void setCoordinador(String coordinador)
			{
				this.coordinador = coordinador;
			}

		public boolean isAutorizoEstudiante()
			{
				return autorizoEstudiante;
			}

		public void setAutorizoEstudiante(boolean autorizoEstudiante)
			{
				this.autorizoEstudiante = autorizoEstudiante;
			}

		public String getDictamen(int numSolicitud)
			{
				return dictamenesx.get("" + numSolicitud);
			}

		public void setDictamen(int numSolicitud, String dictamen)
			{
				dictamenesx.put("" + numSolicitud, dictamen);
			}

		public int getTotalSolicitudes()
			{
				return solicitudes.size();
			}

		public String getRecomendacionParaSolicitudNum(int pos)
			{
				int x;
				Iterator<String> i = resultados.values().iterator();
				int si = 0;
				int no = 0;
				int cm = 0;
				String r[];
				char c = 27;
				while (i.hasNext())
					{
						r = i.next().split("\n");
						switch (r[pos])
							{
								case "SI RECOMIENDO":
									si++;
									break;
								case "NO RECOMIENDO":
									no++;
									break;
								case "EN REUNION":
									cm++;
									break;
							}
					}
				String six, nox, cmx;
				String dic;
				x = pos;
				six = "" + si;
				nox = "" + no;
				cmx = "" + cm;
				while (six.length() < 3)
					six = "0" + six;
				while (nox.length() < 3)
					nox = "0" + nox;
				while (cmx.length() < 3)
					cmx = "0" + cmx;
				dic = this.getDictamen(x);
				if(dic == null || dic.equals("SI"))
					dic = "PENDIENTE";
				return nombreEstudiante + c + control + c + solicitudes.get(x) + c + six + c + nox + c +
				  cmx + c + id + c + dic + c + x;
			}

		String	firma;
		String	clavePlan;

		public Estudiante getEstudiante()
			{
				return estudiante;
			}

		public void setEstudiante(Estudiante estudiante)
			{
				this.estudiante = estudiante;
			}

		public ArrayList<String> getAsuntos()
			{
				return asuntos;
			}

		public ArrayList<String> getSolicitudes()
			{
				return solicitudes;
			}

		public HashMap<String, String> getResultados()
			{
				return resultados;
			}

		public String getNombreEstudiante()
			{
				return nombreEstudiante;
			}

		public void setNombreEstudiante(String e)
			{
				this.nombreEstudiante = e;
			}

		public String getClavePlan()
			{
				return clavePlan;
			}

		public void setClavePlan(String clavePlan)
			{
				this.clavePlan = clavePlan;
			}

		public String getFirma()
			{
				return firma;
			}

		public void setFirma(String firma)
			{
				this.firma = firma;
			}

		public String getId()
			{
				return id;
			}

		public void setId(String id)
			{
				this.id = id;
			}

		public String getControl()
			{
				return control;
			}

		public void setControl(String control)
			{
				this.control = control;
			}

		public String getPeriodo()
			{
				return periodo;
			}

		public void setPeriodo(String periodo)
			{
				this.periodo = periodo;
			}

		public String getFecha()
			{
				return fecha;
			}

		public void setFecha(String fecha)
			{
				this.fecha = fecha;
			}

		public String getMotivosAcademicos()
			{
				return motivosAcademicos;
			}

		public void setMotivosAcademicos(String motivosAcademicos)
			{
				this.motivosAcademicos = motivosAcademicos;
			}

		public String getMotivosPersonales()
			{
				return motivosPersonales;
			}

		public void setMotivosPersonales(String motivosPersonales)
			{
				this.motivosPersonales = motivosPersonales;
			}

		public String getOtrosMotivos()
			{
				return otrosMotivos;
			}

		public void setOtrosMotivos(String otrosMotivos)
			{
				this.otrosMotivos = otrosMotivos;
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
