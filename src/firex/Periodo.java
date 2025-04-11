package firex;

import java.util.HashMap;

public class Periodo {

	String periodo;
	long inicioVacaciones;
	long terminoVacaciones;
	long inicio;
	long termino;

	public Periodo() {
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public long getInicioVacaciones() {
		return inicioVacaciones;
	}

	public void setInicioVacaciones(long inicioVacaciones) {
		this.inicioVacaciones = inicioVacaciones;
	}

	public long getTerminoVacaciones() {
		return terminoVacaciones;
	}

	public void setTerminoVacaciones(long terminoVacaciones) {
		this.terminoVacaciones = terminoVacaciones;
	}

	public long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public long getTermino() {
		return termino;
	}

	public void setTermino(long termino) {
		this.termino = termino;
	}

	static public HashMap<String, String> ciclos() {
		HashMap<String, String> c = new HashMap<String, String>();
		c.put("1", "ENE-JUN");
		c.put("2", "VERANO");
		c.put("3", "AGO-DIC");
		return c;
	}

	static public String letreroCorto(String periodo) {
		String cad = periodo + "0";
		switch (cad.charAt(4)) {
		case '1':
			return "ENE-JUN " + periodo.substring(0, 4);
		case '2':
			return "VERANO " + periodo.substring(0, 4);
		case '3':
			return "AGO-DIC " + periodo.substring(0, 4);
		}
		return periodo;
	}

	static public String letreroLargo(String periodo) {
		String cad = periodo + "0";
		switch (cad.charAt(4)) {
		case '1':
			return "ENERO - JUNIO " + periodo.substring(0, 4);
		case '2':
			return "VERANO " + periodo.substring(0, 4);
		case '3':
			return "AGOSTO - DICIEMBRE " + periodo.substring(0, 4);
		}
		return periodo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodo other = (Periodo) obj;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		return true;
	}

	static public int getYearPeriodo(String actual) {
		return Integer.parseInt(actual.substring(0, 4));
	}

	static public String getPeriodoSiguienteSinVerano(String actual) {
		String cad = actual + "0";
		String aux = actual.substring(0, 4);
		switch (cad.charAt(4)) {
		case '1':
			return aux + "3";
		case '3':
			return (Integer.parseInt(aux) + 1) + "1";
		}
		return cad;
	}

	static public String getPeriodoSiguienteConVerano(String actual) {
		String cad = actual + "0";
		String aux = actual.substring(0, 4);
		switch (cad.charAt(4)) {
		case '1':
			return aux + "2";
		case '2':
			return aux + "3";
		case '3':
			return (Integer.parseInt(aux) + 1) + "1";
		}
		return cad;
	}

	static public String getPeriodoAnteriorSinVerano(String actual) {
		String cad = actual + "0";
		String aux = actual.substring(0, 4);
		switch (cad.charAt(4)) {
		case '1':
			return (Integer.parseInt(aux) - 1) + "3";
		case '2':
		case '3':
			return aux + "1";
		}
		return actual;
	}

	static public String getPeriodoAnteriorConVerano(String actual) {
		String cad = actual + "0";
		String aux = actual.substring(0, 4);
		switch (cad.charAt(4)) {
		case '1':
			return (Integer.parseInt(aux) - 1) + "3";
		case '2':
			return aux + "1";
		case '3':
			return aux + "1";
		}
		return actual;
	}

	static public boolean esVerano(String periodo) {
		periodo = periodo + "0";
		return periodo.charAt(4) == '2';
	}

	public String toString() {
		return Periodo.letreroCorto(periodo);
	}
}
