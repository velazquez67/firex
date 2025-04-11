package firex.it;

public class Evaluacion { // TIPOS DE EXAMEN
	static public String Convalidacion = "CONV";
	static public String Equivalencia = "EQUI";
	static public String Ordinario = "ORD";
	static public String Regularizacion = "REG";
	static public String Extraordinario = "EXT";
	static public String ExamenEspecial = "EE";
	static public String CursoEspecial = "E";
	static public String EspecialAutodidacta = "EA";
	static public String Acreditada = "AC";
	 String periodo;
	 String grupo;
	 int calificacion; // -1 Sin Calificar
	 String tipoEvaluacion;
	 String fechaCalificacion;
	 String quienCalifico;
	 boolean deserto;
	 String oportunidad;

	public Evaluacion() {
		periodo = null;
		calificacion = -1;
		tipoEvaluacion = Ordinario;
		oportunidad = "--";
	}

	public String getOportunidad() {
		return oportunidad;
	}

	public void setCN() {
		this.oportunidad = "CN";
	}

	public void setRC() {
		this.oportunidad = "RC";
	}

	public void setE() {
		this.oportunidad = "E";
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setSinCalificar() {
		calificacion = -1;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public boolean estaCalificada() {
		return calificacion != -1;
	}

	public boolean esAcreditada() {
		return (tipoEvaluacion.equals(Evaluacion.Equivalencia) || tipoEvaluacion.equals(Evaluacion.Acreditada));
	}

	public String getCalificacionTexto() {
		if (!estaCalificada())
			return "---";
		if (tipoEvaluacion.equals(Evaluacion.Equivalencia) || tipoEvaluacion.equals(Evaluacion.Acreditada))
			return "AC";
		if (calificacion == 0)
			return " NA";
		if (calificacion == 100)
			return "100";
		return " " + calificacion;
	}

	public boolean estaAprobada() {
		return calificacion > 0;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getFechaCalificacion() {
		return fechaCalificacion;
	}

	public void setFechaCalificacion(String fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public boolean isDeserto() {
		return deserto;
	}

	public void setDeserto(boolean deserto) {
		this.deserto = deserto;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public String getQuienCalifico() {
		return quienCalifico;
	}

	public void setQuienCalifico(String quienCalifico) {
		this.quienCalifico = quienCalifico;
	}

	public String getTipoExamen() {
		return tipoEvaluacion;
	}

	public void setTipoExamen(String tipoExamen) {
		this.tipoEvaluacion = tipoExamen;
	}
}
