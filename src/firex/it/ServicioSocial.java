package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ServicioSocial implements IsSerializable, Mapa {
	Map<String, Object> datos;
	boolean inscrito;
	Estudiante estudiante;

	public ServicioSocial() {
		datos = new HashMap<String, Object>();
		estudiante = null;
		inscrito = false;
	}

	public ServicioSocial(String control, String clavePlan, String periodo) {
		this.setControl(control);
		this.setClavePlan(clavePlan);
		this.setPeriodo(periodo);
	}

	public ServicioSocial(Map<String, Object> m) {
		datos = m;
		estudiante = null;
		inscrito = false;
	}

	@Override
	public Map<String, Object> toMap() {
		return datos;
	}

	@Override
	public void fromMap(Map<String, Object> m) {
		datos = m;
	}

	public String nombre() {
		return (String) get("nombre");
	}

	public void setNombre(String nombre) {
		datos.put("nombre", nombre);
	}

	public String getCarrera() {
		return (String) get("carrera");
	}

	public void setCarrera(String carrera) {
		datos.put("carrera", carrera);
	}

	public void setNivel(String nivel) {
		datos.put("nivel", nivel);
	}

	public String getNivel() {
		return (String) datos.get("nivel");
	}

	public boolean isInscrito() {
		return inscrito;
	}

	public void setInscrito(boolean inscrito) {
		this.inscrito = inscrito;
	}

	public String getActividades() {
		return (datos.get("actividades") != null) ? (String) datos.get("actividades") : "";
	}

	public void setActividades(String actividades) {
		datos.put("actividades", actividades);
	}

	public String getFechaInicio() {
		return (String) datos.get("fechaInicio");
	}

	public void setFechaInicio(String fechaInicio) {
		datos.put("fechaInicio", fechaInicio);
	}

	public String getFechaTermino() {
		return (String) datos.get("fechaTermino");
	}

	public void setFechaTermino(String fechaTermino) {
		datos.put("fechaTermino", fechaTermino);
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String getNombreResponsable() {
		return (String) datos.get("nombreResponsable");
	}

	public void setNombreResponsable(String nombreResponsable) {
		datos.put("nombreResponsable", nombreResponsable);
	}

	public String getCargo() {
		return (String) datos.get("cargo");
	}

	public void setCargo(String cargo) {
		datos.put("cargo", cargo);
	}

	public String getDependencia() {
		return (String) datos.get("dependencia");
	}

	public void setDependencia(String dependencia) {
		datos.put("dependencia", dependencia);
	}

	public String getMunicipio() {
		return (String) datos.get("municipio");
	}

	public void setMunicipio(String municipio) {
		datos.put("municipio", municipio);
	}

	public String getEstado() {
		return (String) datos.get("estado");
	}

	public void setEstado(String estado) {
		datos.put("estado", estado);
	}

	public String getControl() {
		return (String) datos.get("control");
	}

	public void setControl(String control) {
		datos.put("control", control);
	}

	public String getPeriodo() {
		return (String) datos.get("periodo");
	}

	public void setPeriodo(String periodo) {
		datos.put("periodo", periodo);
	}

	public String getClavePlan() {
		return (String) datos.get("clavePlan");
	}

	public void setClavePlan(String clavePlan) {
		datos.put("clavePlan", clavePlan);
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
