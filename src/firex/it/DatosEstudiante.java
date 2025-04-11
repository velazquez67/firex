package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DatosEstudiante implements IsSerializable, Mapa
{
	Map<String, Object> datos;

	public DatosEstudiante()
	{
		datos = new HashMap<String, Object>();
	}

	public DatosEstudiante(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public void fromMap(Map<String, Object> obj)
	{
		datos = obj;
	}

	public Map<String, Object> toMap()
	{
		return datos;
	}

	public String getSoyDiestro()
	{
		String s = (String) datos.get("soyDiestro");
		if (s != null)
			return s;
		return "SI";
	}

	public boolean isSoyDiestro()
	{
		return getSoyDiestro().equals("SI");
	}

	public void setSoyDiestro()
	{
		datos.put("soyDiestro", "SI");
	}

	public void setSoyZurdo()
	{
		datos.put("soyDiestro", "NO");
	}

	public long getMiembrosFamilia()
	{
		Long l = (Long) datos.get("miembrosFamilia");
		if (l != null)
			return l;
		return 0;
	}

	public void setMiembrosFamilia(long miembros)
	{
		datos.put("miembrosFamilia", miembros);
	}

	public String getEstudiaIngles()
	{
		return gets("estudiaIngles");
	}

	public void setEstudiaIngles(String estudiaIngles)
	{
		datos.put("estudiaIngles", estudiaIngles);
	}

	public String getTipoSangre()
	{
		return gets("tipoSangre");
	}

	public void setTipoSangre(String tipoSangre)
	{
		datos.put("tipoSangre", tipoSangre);
	}

	public String getEstadoCivil()
	{
		return gets("estadoCivil");
	}

	public void setEstadoCivil(String civil)
	{
		datos.put("estadoCivil", civil);
	}

	public String getNacionalidad()
	{
		return gets("nacionalidad");
	}

	public void setNacionalidad(String nacionalidad)
	{
		datos.put("nacionalidad", nacionalidad);
	}

	public String getCalle()
	{
		return gets("calle");
	}

	public void setCalle(String calle)
	{
		datos.put("calle", calle);
	}

	public String getColonia()
	{
		return gets("colonia");
	}

	public void setColonia(String colonia)
	{
		datos.put("colonia", colonia);
	}

	public String getMunicipio()
	{
		return gets("municipio");
	}

	public void setMunicipio(String municipio)
	{
		datos.put("municipio", municipio);
	}

	public String getEstado()
	{
		return gets("estado");
	}

	public void setEstado(String estado)
	{
		datos.put("estado", estado);
	}

	public String getTelefono2()
	{
		return gets("telefono2");
	}

	public void setTelefono2(String telefono2)
	{
		datos.put("telefono2", telefono2);
	}

	public String getAfiliado()
	{
		return gets("afiliado");
	}

	public void setAfiliado(String afiliado)
	{
		datos.put("afiliado", afiliado);
	}

	public String getNoAfiliacion()
	{
		return gets("noAfiliacion");
	}

	public void setNoAfiliacion(String noAfiliacion)
	{
		datos.put("noAfiliacion", noAfiliacion);
	}

	public String getBachilleratoProcedencia()
	{
		return gets("bachilleratoProcedencia");
	}

	public void setBachilleratoProcedencia(String escuela)
	{
		datos.put("bachilleratoProcedencia", escuela);
	}

	public String getNombreBachilleratoProcedencia()
	{
		return gets("nombreBachilleratoProcedencia");
	}

	public void setNombreBachilleratoProcedencia(String nombreEscuela)
	{
		datos.put("nombreBachilleratoProcedencia", nombreEscuela);
	}

	public String getMunicipioBachilleratoProcedencia()
	{
		return gets("municipioBachilleratoProcedencia");
	}

	public void setMunicipioBachilleratoProcedencia(String municipioEscuela)
	{
		datos.put("municipioBachilleratoProcedencia", municipioEscuela);
	}

	public String getEstadoBachilleratoProcedencia()
	{
		return gets("estadoBachilleratoProcedencia");
	}

	public void setEstadoBachilleratoProcedencia(String estadoEscuela)
	{
		datos.put("estadoBachilleratoProcedencia", estadoEscuela);
	}

	public String getPromedioBachillerato()
	{
		return gets("promedioBachillerato");
	}

	public void setPromedioBachillerato(String promedio)
	{
		datos.put("promedioBachillerato", promedio);
	}

	public String getDiscapacidad()
	{
		return gets("discapacidad");
	}

	public void setDiscapacidad(String discapacidad)
	{
		datos.put("discapacidad", discapacidad);
	}

	public String getCualDiscapacidad()
	{
		return gets("cualDiscapacidad");
	}

	public void setCualDiscapacidad(String cualD)
	{
		datos.put("cualDiscapacidad", cualD);
	}

	public String getPeso()
	{
		return (String) datos.get("peso");
	}

	public void setPeso(String peso)
	{
		datos.put("peso", peso);
	}

	public String getTalla()
	{
		return gets("talla");
	}

	public void setTalla(String talla)
	{
		datos.put("talla", talla);
	}

	public String getLengua()
	{
		return gets("lengua");
	}

	public void setLengua(String lengua)
	{
		datos.put("lengua", lengua);
	}

	public String getCualLengua()
	{
		return (String) datos.get("cualLengua");
	}

	public void setCualLengua(String cualL)
	{
		datos.put("cualLengua", cualL);
	}

	public String getAlergia()
	{
		return gets("alergia");
	}

	public void setAlergia(String alergia)
	{
		datos.put("alergia", alergia);
	}

	public String getCualAlergia()
	{
		return gets("cualAlergia");
	}

	public void setCualAlergia(String cualA)
	{
		datos.put("cualAlergia", cualA);
	}

	public String getMedicamento()
	{
		return gets("medicamento");
	}

	public void setMedicamento(String medicamento)
	{
		datos.put("medicamento", medicamento);
	}

	public String getCualMedicamento()
	{
		return gets("cualMedicamento");
	}

	public void setCualMedicamento(String cualM)
	{
		datos.put("cualMedicamento", cualM);
	}

	public String getEnfermedad()
	{
		return gets("enfermedad");
	}

	public void setEnfermedad(String enfermedad)
	{
		datos.put("enfermedad", enfermedad);
	}

	public String getCualEnfermedad()
	{
		return gets("cualEnfermedad");
	}

	public void setCualEnfermedad(String cualE)
	{
		datos.put("cualEnfermedad", cualE);
	}

	public String getBecado()
	{
		return gets("becado");
	}

	public void setBecado(String becado)
	{
		datos.put("becado", becado);
	}

	public String getNombreBeca()
	{
		return gets("nombreBeca");
	}

	public void setNombreBeca(String nombreBeca)
	{
		datos.put("nombreBeca", nombreBeca);
	}

	public String getProspera()
	{
		return gets("prospera");
	}

	public void setProspera(String prospera)
	{
		datos.put("prospera", prospera);
	}

	public String getFolioProspera()
	{
		return gets("folioProspera");
	}

	public void setFolioProspera(String folio)
	{
		datos.put("folioProspera", folio);
	}

	public String getTrabajas()
	{
		return gets("trabajas");
	}

	public void setTrabajas(String trabajas)
	{
		datos.put("trabajas", trabajas);
	}

	public String getEnQueTrabajas()
	{
		return gets("enQueTrabajas");
	}

	public void setEnQueTrabajas(String enque)
	{
		datos.put("enQueTrabajas", enque);
	}

	public String getLugarTrabajo()
	{
		return gets("lugarTrabajo");
	}

	public void setLugarTrabajo(String lugar)
	{
		datos.put("lugarTrabajo", lugar);
	}

	public String getHorarioTrabajo()
	{
		return gets("horarioTrabajo");
	}

	public void setHorarioTrabajo(String horario)
	{
		datos.put("horarioTrabajo", horario);
	}

	public String getNombreTutor()
	{
		return gets("nombreTutor");
	}

	public void setNombreTutor(String nombreT)
	{
		datos.put("nombreTutor", nombreT);
	}

	public String getNacionalidadTutor()
	{
		return gets("nacionalidadTutor");
	}

	public void setNacionalidadTutor(String nacionalidadT)
	{
		datos.put("nacionalidadTutor", nacionalidadT);
	}

	public String getDomicilioTutor()
	{
		return gets("domicilioTutor");
	}

	public void setDomicilioTutor(String domicilioT)
	{
		datos.put("domicilioTutor", domicilioT);
	}

	public String getOcupacionTutor()
	{
		return gets("ocupacionTutor");
	}

	public void setOcupacionTutor(String ocupacionT)
	{
		datos.put("ocupacionTutor", ocupacionT);
	}

	public String getEdadTutor()
	{
		return gets("edadTutor");
	}

	public void setEdadTutor(String edadT)
	{
		datos.put("edadTutor", edadT);
	}

	public String getLugarTutor()
	{
		return gets("lugarTutor");
	}

	public void setLugarTutor(String lugarT)
	{
		datos.put("lugarTutor", lugarT);
	}

	public String getIngresoTutor()
	{
		return gets("ingresoTutor");
	}

	public void setIngresoTutor(String ingresoT)
	{
		datos.put("ingresoTutor", ingresoT);
	}

	public String getNombreMadre()
	{
		return gets("nombreMadre");
	}

	public void setNombreMadre(String nombreM)
	{
		datos.put("nombreMadre", nombreM);
	}

	public String getNacionalidadMadre()
	{
		return gets("nacionalidadMadre");
	}

	public void setNacionalidadMadre(String nacionalidadM)
	{
		datos.put("nacionalidadMadre", nacionalidadM);
	}

	public String getDomicilioMadre()
	{
		return gets("domicilioMadre");
	}

	public void setDomicilioMadre(String domicilioM)
	{
		datos.put("domicilioMadre", domicilioM);
	}

	public String getOcupacionMadre()
	{
		return gets("ocupacionMadre");
	}

	public void setOcupacionMadre(String ocupacionM)
	{
		datos.put("ocupacionMadre", ocupacionM);
	}

	public String getEdadMadre()
	{
		return gets("edadMadre");
	}

	public void setEdadMadre(String edadM)
	{
		datos.put("edadMadre", edadM);
	}

	public String getLugarMadre()
	{
		return gets("lugarMadre");
	}

	public void setLugarMadre(String lugarM)
	{
		datos.put("lugarMadre", lugarM);
	}

	public String getIngresoMadre()
	{
		return gets("ingresoMadre");
	}

	public void setIngresoMadre(String ingresoM)
	{
		datos.put("ingresoMadre", ingresoM);
	}

	public String getAccidente()
	{
		return gets("accidente");
	}

	public void setAccidente(String accidente)
	{
		datos.put("accidente", accidente);
	}

	public String getTelefonoAccidente()
	{
		return gets("telefonoAccidente");
	}

	public void setTelefonoAccidente(String tel)
	{
		datos.put("telefonoAccidente", tel);
	}

	public String getNivelIngles()
	{
		return gets("nivelIngles");
	}

	public void setNivelIngles(String nivelIngles)
	{
		datos.put("nivelIngles", nivelIngles);
	}

	public String gets(String campo)
	{
		String s = (String) datos.get(campo);
		if (s != null)
			return s;
		return "";
	}

	public Object get(String campo)
	{
		return datos.get(campo);
	}
}
