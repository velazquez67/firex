package firex.it;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class TablaReinscripcion implements IsSerializable, Mapa
	{
		String					periodo;
		boolean					primerSemestre;
		long	promedios[];			// se almacena: promedio
		Map<String,String> fechas;

		protected TablaReinscripcion()
			{
				primerSemestre = false;
				promedios =new long[56];
				fechas=new HashMap<String,String>();
			}

		public TablaReinscripcion(Map<String, Object> m)
			{
				this();
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				HashMap<String,Object> m= new HashMap<String,Object> ();
				m.put("periodo", periodo);
				m.put("primerSemestre", primerSemestre);
				m.put("fechas", fechas);
				ArrayList<Long> aux = new ArrayList<Long>();
				for(int x=0;x<promedios.length;x++)
					aux.add(promedios[x]);
				m.put("promedios", aux);
				return m;
			}

		@SuppressWarnings("unchecked")
		@Override
		public void fromMap(Map<String, Object> m)
			{
				setPeriodo((String) m.get("periodo"));
				setPrimerSemestre((Boolean) m.get("primerSemestre"));
				ArrayList<Long> aux =(ArrayList<Long>) m.get("promedios");
				for(int x=0;x<aux.size();x++)
					promedios[x] = aux.get(x);
				fechas = (HashMap<String,String>)m.get("fechas");
			}

		
		public Map<String,String> getFechas()
		{
			return fechas;
		}

		public void setFechas(HashMap<String,String> fechas)
		{
			this.fechas = fechas;
		}

		public boolean isPrimerSemestre()
			{
				return primerSemestre;
			}

		public void setPeriodo(String periodo)
			{
				this.periodo = periodo;
			}

		public void setPrimerSemestre(boolean primerSemestre)
			{
				this.primerSemestre = primerSemestre;
			}

		public String getPeriodo()
			{
				return periodo;
			}

		public TablaReinscripcion(String periodo)
			{
				this();
				this.periodo = periodo;
			}

		@SuppressWarnings("deprecation")
		public void asignaPromediox(int promedio, int year, int mes, int dia, int hora, int min)
			{
				Date d = new Date(year - 1900, mes - 1, dia);
				d.setMinutes(min);
				d.setHours(hora);
				d.setSeconds(0);
				if(promedio <= 50)
					promedio = 51;
				if(promedio > 106)
					promedio = 106;
				promedios[106 - promedio]= d.getTime();
			}

		public long[] getPromedios()
			{
				return promedios;
			}

		public boolean puedeInscribir(int promedio, long fechaActual)
			{
				if(promedio <= 50)
					promedio = 51;
				if(promedio > 106)
					promedio = 106;
				return promedios[106 - promedio] >= fechaActual;
			}

		public boolean estaVacia()
			{
				return promedios[0] == 0;
			}

		public long fechaReinscripcion(int prom)
			{
				if(prom <= 50)
					prom = 51;
				if(prom > 106)
					prom = 106;
				return promedios[106 - prom];
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
