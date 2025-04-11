package firex.it;

import java.util.Map;
import java.util.HashMap;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Condonacion implements IsSerializable, Mapa {
	static public String[] MOTIVOS_CON_ASENTOS = {
			"por insolvencia econ�mica, solicitada por el C�mite Ejecutivo de la Sociedad de Alumnos (CESA)",
			"por acuerdo seg�n el manual de normas para la administraci�n de recursos humanos de la Secretar�a de Educaci�n P�blica del apartado 21.4.47",
			"por su participaci�n en el Evento Nacional de Arte y Cultura",
			"por su participaci�n en el Evento Nacional Deportivo",
			"por haber obtenido uno de los tres primeros lugares en evento acad�mico",
			"por haber obtenido el primer lugar en el Evento Nacional InnovaTecNM",
			"por ser Esposo(a) de Trabajador(a) del Instituto Tecnol�gico de Zacatepec",
			"por ser Personal del Instituto Tecnol�gico de Zacatepec",
			"por ser Hijo(a) de Personal del Instituto Tecn�logico de Zacatepec",
			"por su participaci�n en los grupos representativos de Arte y Cultura", "por insolvencia econ�mica" };

	static public String[] MOTIVOS_SIN_ASENTOS = {
			"por insolvencia economica, solicitada por el Comite Ejecutivo de la Sociedad de Alumnos (CESA)",
			"por acuerdo al manual de normas para la administracion de recursos humanos de la Secretaria de Educacion Publica del apartado 21.4.47",
			"por su participacion en el Evento Nacional de Arte y Cultura",
			"por su participacion en el Evento Nacional Deportivo",
			"por haber obtenido uno de los tres primeros lugares en evento academico",
			"por haber obtenido el primer lugar en el Evento Nacional InnovaTecNM",
			"por ser Esposo(a) de Trabajador(a) del Instituto Tecnologico de Zacatepec",
			"por ser Personal del Instituto Tecnologico de Zacatepec",
			"por ser Hijo(a) de Personal del Instituto Tecnologico de Zacatepec",
			"por su participacion en los grupos representativos de Arte y Cultura", "por insolvencia economica" };

	String id; // periodo_control;
	String periodo;
	String control;
	long descuento;
	boolean porcentaje;
	String motivo;
	String usuarioOtorgo;
	String nombreEstudiante;
	String planEstudiante;
	String carreraEstudiante;
	long semestre;
	String concepto;
	boolean esHombre;
	String fecha;

	public Condonacion() {
		this.setId("");
		this.setPeriodo("");
		this.setControl("");
		this.setDescuento(0);
		this.setPorcentaje(true);
		this.setMotivo("");
		this.setUsuarioOtorgo("");
		this.setNombreEstudiante("");
		this.setPlanEstudiante("");
		this.setCarreraEstudiante("");
		this.setConcepto("");
		this.setFecha("");
		this.setEsHombre(true);
	}

	public long getSemestre() {
		return semestre;
	}

	public void setSemestre(long semestre) {
		this.semestre = semestre;
	}

	public Condonacion(Map<String, Object> m) {
		this.fromMap(m);
	}

	public Condonacion(String periodo, String control) {
		this();
		this.setPeriodo(periodo);
		this.setControl(control);
		this.setId(periodo + "_" + control);
	}

	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("id", this.getId());
		res.put("periodo", this.getPeriodo());
		res.put("control", this.getControl());
		res.put("descuento", this.getDescuento());
		res.put("porcentaje", this.isPorcentaje());
		res.put("motivo", this.getMotivo());
		res.put("usuarioOtorgo", this.getUsuarioOtorgo());
		res.put("nombreEstudiante", this.getNombreEstudiante());
		res.put("planEstudiante", this.getPlanEstudiante());
		res.put("carreraEstudiante", this.getCarreraEstudiante());
		res.put("semestre", this.getSemestre());
		res.put("concepto", this.getConcepto());
		res.put("fecha", this.getFecha());
		res.put("esHombre", this.isEsHombre());
		return res;
	}

	@Override
	public void fromMap(Map<String, Object> m) {
		this.setId((String) m.get("id"));
		this.setPeriodo((String) m.get("periodo"));
		this.setControl((String) m.get("control"));
		this.setDescuento((Long) m.get("descuento"));
		this.setPorcentaje((Boolean) m.get("porcentaje"));
		this.setMotivo((String) m.get("motivo"));
		this.setUsuarioOtorgo((String) m.get("usuarioOtorgo"));
		this.setNombreEstudiante((String) m.get("nombreEstudiante"));
		this.setPlanEstudiante((String) m.get("planEstudiante"));
		this.setCarreraEstudiante((String) m.get("carreraEstudiante"));
		this.setSemestre((Long) m.get("semestre"));
		this.setConcepto((String) m.get("concepto"));
		this.setFecha((String) m.get("fecha"));
		this.setEsHombre((Boolean) m.get("esHombre"));
	}

	public boolean isEsHombre() {
		return esHombre;
	}

	public void setEsHombre(boolean esHombre) {
		this.esHombre = esHombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getPlanEstudiante() {
		return planEstudiante;
	}

	public void setPlanEstudiante(String planEstudiante) {
		this.planEstudiante = planEstudiante;
	}

	public String getCarreraEstudiante() {
		return carreraEstudiante;
	}

	public void setCarreraEstudiante(String carreraEstudiante) {
		this.carreraEstudiante = carreraEstudiante;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public long getDescuento() {
		return descuento;
	}

	public void setDescuento(long descuento) {
		this.descuento = descuento;
	}

	public boolean isPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(boolean porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getMotivoConAcentos() {
		for (int x = 0; x < Condonacion.MOTIVOS_SIN_ASENTOS.length; x++)
			if (motivo.equals(Condonacion.MOTIVOS_SIN_ASENTOS[x]))
				return Condonacion.MOTIVOS_CON_ASENTOS[x];
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getUsuarioOtorgo() {
		return usuarioOtorgo;
	}

	public void setUsuarioOtorgo(String usuarioOtorgo) {
		this.usuarioOtorgo = usuarioOtorgo;
	}

	@Override
	public String gets(String campo) {
		return null;
	}

	@Override
	public Object get(String campo) {
		return null;
	}
}
