package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Tecnologico implements IsSerializable, Mapa
{
	String numero;
	String sigla;
	String nombre;
	String abreviado;
	String periodoActual;
	String lema;
	String calle;
	String colonia;
	String ciudad;
	String estado;
	String postal;
	String telefonos;
	boolean evaluacionDocente;
	boolean reinscripcion;
	boolean reinscripcionExtraescolar;
	boolean reinscripcionCoordinadores;
	boolean solicitudServicioSocial;
	boolean avisoReinscripcion; // al activar el estudiante recibe un aviso de su hora de
	// reinscripcion
	boolean bajasComiteAcademico;
	String lemaYear;
	String clave;
	long inicioVacaciones;
	long finVacaciones;
	long iniciaSemestre;
	long terminaSemestre;
	long iniciaSemanaSanta;
	long terminaSemanaSanta;
	long iniciaExamenes;
	long terminaExamenes;
	String periodoReinscripcion;
	String correo;
	// DESARROLLO ACADEMICO
	String periodoFichas;
	String usuarioFichas;
	boolean activarFichas;
	String costoFicha;
	String costoPagoFicha;
	// ignorar
	Usuario usuarioActual;

	public Tecnologico()
	{
		sigla = "";
		nombre = "";
		abreviado = "";
		numero = "";
		periodoActual = "";
		calle = "";
		colonia = "";
		ciudad = "";
		estado = "";
		postal = "";
		lema = "";
		lemaYear = "";
		avisoReinscripcion = false;
		evaluacionDocente = false;
		reinscripcion = false;
		reinscripcionExtraescolar = false;
		reinscripcionCoordinadores = false;
		bajasComiteAcademico = false;
		clave = "";
		inicioVacaciones = 0;
		finVacaciones = 0;
		iniciaSemestre = 0;
		terminaSemestre = 0;
		iniciaSemanaSanta = 0;
		terminaSemanaSanta = 0;
		iniciaExamenes = 0;
		terminaExamenes = 0;
		periodoReinscripcion = "";
		telefonos = "";
		correo = "";
		periodoFichas = "";
		usuarioFichas = "";
		activarFichas = false;
		usuarioActual = null;
		solicitudServicioSocial = false;
		costoFicha = "";
		costoPagoFicha = "";
	}

	public Tecnologico(Map<String, Object> m)
	{
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("sigla", sigla);
		m.put("nombre", nombre);
		m.put("abreviado", abreviado);
		m.put("numero", numero);
		m.put("periodoActual", periodoActual);
		m.put("calle", calle);
		m.put("colonia", colonia);
		m.put("ciudad", ciudad);
		m.put("estado", estado);
		m.put("postal", postal);
		m.put("lema", lema);
		m.put("lemaYear", lemaYear);
		m.put("avisoReinscripcion", avisoReinscripcion);
		m.put("evaluacionDocente", evaluacionDocente);
		m.put("reinscripcion", reinscripcion);
		m.put("reinscripcionExtraescolar", reinscripcionExtraescolar);
		m.put("reinscripcionCoordinadores", reinscripcionCoordinadores);
		m.put("bajasComiteAcademico", bajasComiteAcademico);
		m.put("clave", clave);
		m.put("inicioVacaciones", inicioVacaciones);
		m.put("finVacaciones", finVacaciones);
		m.put("iniciaSemestre", iniciaSemestre);
		m.put("terminaSemestre", terminaSemestre);
		m.put("iniciaSemanaSanta", iniciaSemanaSanta);
		m.put("terminaSemanaSanta", terminaSemanaSanta);
		m.put("iniciaExamenes", iniciaExamenes);
		m.put("terminaExamenes", terminaExamenes);
		m.put("periodoReinscripcion", periodoReinscripcion);
		m.put("telefonos", telefonos);
		m.put("correo", correo);
		m.put("periodoFichas", periodoFichas);
		m.put("usuarioFichas", usuarioFichas);
		m.put("activarFichas", activarFichas);
		m.put("solicitudServicioSocial", solicitudServicioSocial);
		m.put("costoFicha", getCostoFicha());
		m.put("costoPagoFicha", getCostoPagoFicha());
		usuarioActual = null;
		return m;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		sigla = (String) m.get("sigla");
		nombre = (String) m.get("nombre");
		abreviado = (String) m.get("abreviado");
		numero = (String) m.get("numero");
		periodoActual = (String) m.get("periodoActual");
		calle = (String) m.get("calle");
		colonia = (String) m.get("colonia");
		ciudad = (String) m.get("ciudad");
		estado = (String) m.get("estado");
		postal = (String) m.get("postal");
		lema = (String) m.get("lema");
		lemaYear = (String) m.get("lemaYear");
		avisoReinscripcion = (Boolean) m.get("avisoReinscripcion");
		evaluacionDocente = (Boolean) m.get("evaluacionDocente");
		reinscripcion = (Boolean) m.get("reinscripcion");
		reinscripcionExtraescolar = (Boolean) m.get("reinscripcionExtraescolar");
		reinscripcionCoordinadores = (Boolean) m.get("reinscripcionCoordinadores");
		bajasComiteAcademico = (Boolean) m.get("bajasComiteAcademico");
		clave = (String) m.get("clave");
		inicioVacaciones = (Long) m.get("inicioVacaciones");
		finVacaciones = (Long) m.get("finVacaciones");
		iniciaSemestre = (Long) m.get("iniciaSemestre");
		terminaSemestre = (Long) m.get("terminaSemestre");
		iniciaSemanaSanta = (Long) m.get("iniciaSemanaSanta");
		terminaSemanaSanta = (Long) m.get("terminaSemanaSanta");
		iniciaExamenes = (Long) m.get("iniciaExamenes");
		terminaExamenes = (Long) m.get("terminaExamenes");
		periodoReinscripcion = (String) m.get("periodoReinscripcion");
		telefonos = (String) m.get("telefonos");
		correo = (String) m.get("correo");
		periodoFichas = (String) m.get("periodoFichas");
		usuarioFichas = (String) m.get("usuarioFichas");
		activarFichas = (Boolean) m.get("activarFichas");
		solicitudServicioSocial = (Boolean) m.get("solicitudServicioSocial");
		costoFicha = (String) m.get("costoFicha");
		costoPagoFicha = (String) m.get("costoPagoFicha");
		usuarioActual = null;
	}

	public String getCostoPagoFicha()
	{
		return costoPagoFicha;
	}

	public void setCostoPagoFicha(String costoPagoFicha)
	{
		this.costoPagoFicha = costoPagoFicha;
	}

	public String getCostoFicha()
	{
		return costoFicha;
	}

	public void setCostoFicha(String costoFicha)
	{
		this.costoFicha = costoFicha;
	}

	public Usuario getUsuarioActual()
	{
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual)
	{
		this.usuarioActual = usuarioActual;
	}

	public String getPeriodoFichas()
	{
		return periodoFichas;
	}

	public void setPeriodoFichas(String periodoFichas)
	{
		this.periodoFichas = periodoFichas;
	}

	public String getUsuarioFichas()
	{
		return usuarioFichas;
	}

	public void setUsuarioFichas(String usuarioFichas)
	{
		this.usuarioFichas = usuarioFichas;
	}

	public boolean isActivarFichas()
	{
		return activarFichas;
	}

	public void setActivarFichas(boolean activarFichas)
	{
		this.activarFichas = activarFichas;
	}

	public long getIniciaExamenes()
	{
		return iniciaExamenes;
	}

	public void setIniciaExamenes(long iniciaExamenes)
	{
		this.iniciaExamenes = iniciaExamenes;
	}

	public long getTerminaExamenes()
	{
		return terminaExamenes;
	}

	public void setTerminaExamenes(long terminaExamenes)
	{
		this.terminaExamenes = terminaExamenes;
	}

	public boolean isBajasComiteAcademico()
	{
		return bajasComiteAcademico;
	}

	public void setBajasComiteAcademico(boolean bajasComiteAcademico)
	{
		this.bajasComiteAcademico = bajasComiteAcademico;
	}

	public String getCorreo()
	{
		return correo;
	}

	public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	public String getTelefonos()
	{
		return telefonos;
	}

	public void setTelefonos(String telefonos)
	{
		this.telefonos = telefonos;
	}

	public String getColonia()
	{
		return colonia;
	}

	public void setColonia(String colonia)
	{
		this.colonia = colonia;
	}

	public String getCalle()
	{
		return calle;
	}

	public void setCalle(String calle)
	{
		this.calle = calle;
	}

	public String getPostal()
	{
		return postal;
	}

	public void setPostal(String postal)
	{
		this.postal = postal;
	}

	public String getLemaYear()
	{
		return lemaYear;
	}

	public void setLemaYear(String lemaYear)
	{
		this.lemaYear = lemaYear;
	}

	public boolean isAvisoReinscripcion()
	{
		return avisoReinscripcion;
	}

	public void setAvisoReinscripcion(boolean avisoReinscripcion)
	{
		this.avisoReinscripcion = avisoReinscripcion;
	}

	public boolean isSolicitudServicioSocial()
	{
		return solicitudServicioSocial;
	}

	public void setSolicitudServicioSocial(boolean solicitudServicioSocial)
	{
		this.solicitudServicioSocial = solicitudServicioSocial;
	}

	public boolean isReinscripcion()
	{
		return reinscripcion;
	}

	public void setReinscripcion(boolean reinscripcion)
	{
		this.reinscripcion = reinscripcion;
	}

	public boolean isReinscripcionExtraescolar()
	{
		return reinscripcionExtraescolar;
	}

	public void setReinscripcionExtraescolar(boolean reinscripcionExtraescolar)
	{
		this.reinscripcionExtraescolar = reinscripcionExtraescolar;
	}

	public boolean isReinscripcionCoordinadores()
	{
		return reinscripcionCoordinadores;
	}

	public void setReinscripcionCoordinadores(boolean reinscripcionCoordinadores)
	{
		this.reinscripcionCoordinadores = reinscripcionCoordinadores;
	}

	public String getPeriodoReinscripcion()
	{
		return periodoReinscripcion;
	}

	public void setPeriodoReinscripcion(String periodoReinscripcion)
	{
		this.periodoReinscripcion = periodoReinscripcion;
	}

	public long getIniciaSemestre()
	{
		return iniciaSemestre;
	}

	public void setIniciaSemestre(long iniciaSemestre)
	{
		this.iniciaSemestre = iniciaSemestre;
	}

	public long getIniciaSemanaSanta()
	{
		return iniciaSemanaSanta;
	}

	public void setIniciaSemanaSanta(long iniciaSemanaSanta)
	{
		this.iniciaSemanaSanta = iniciaSemanaSanta;
	}

	public long getTerminaSemanaSanta()
	{
		return terminaSemanaSanta;
	}

	public void setTerminaSemanaSanta(long terminaSemanaSanta)
	{
		this.terminaSemanaSanta = terminaSemanaSanta;
	}

	public long getTerminaSemestre()
	{
		return terminaSemestre;
	}

	public void setTerminaSemestre(long terminaSemestre)
	{
		this.terminaSemestre = terminaSemestre;
	}

	public String getClave()
	{
		return clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
	}

	public long getInicioVacaciones()
	{
		return inicioVacaciones;
	}

	public void setInicioVacaciones(long fechaVacaciones)
	{
		this.inicioVacaciones = fechaVacaciones;
	}

	public long getFinVacaciones()
	{
		return finVacaciones;
	}

	public void setFinVacaciones(long finVacaciones)
	{
		this.finVacaciones = finVacaciones;
	}

	public String getLema()
	{
		return lema;
	}

	public void setLema(String lema)
	{
		this.lema = lema;
	}

	public boolean isEvaluacionDocente()
	{
		return evaluacionDocente;
	}

	public void setEvaluacionDocente(boolean evaluacionDocente)
	{
		this.evaluacionDocente = evaluacionDocente;
	}

	public String getCiudad()
	{
		return ciudad;
	}

	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public String getSigla()
	{
		return sigla;
	}

	public void setSigla(String sigla)
	{
		this.sigla = sigla;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getAbreviado()
	{
		return abreviado;
	}

	public void setAbreviado(String abreviado)
	{
		this.abreviado = abreviado;
	}

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	public String getPeriodoActual()
	{
		return periodoActual;
	}

	public void setPeriodoActual(String periodoActual)
	{
		this.periodoActual = periodoActual;
	}

	@Override
	public String gets(String campo)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String campo)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
