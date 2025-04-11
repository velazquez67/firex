package firex.it;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class ProyectoResidencia implements IsSerializable, Mapa
{
	 String id;
	 String control;
	 String nombreEstudiante;
	 String clavePlan;
	 String periodo;
	 String nombreProyecto;
	 String inicio;
	 String termino;
	 String nombreAsesorExterno;
	 String gradoAsesorExterno;
	 String quienFirma;
	 String gradoQuienFirma;
	 String nombreAsesorInterno;
	 long folio;
	 String nombreEmpresa;
	 String giroEmpresa;
	 String calleEmpresa;
	 String ciudadEmpresa;
	 String coloniaEmpresa;
	 String estadoEmpresa;
	 String postalEmpresa;
	 String telefonoEmpresa;
	 String emailEmpresa;
	 String misionEmpresa;
	 String nombreGerenteEmpresa;
	 String puestoGerenteEmpresa;
	 boolean autorizadaAcademico;
	 boolean calificar;
	 boolean autorizadaDivision;
	 String constanciaNombre;
	 String constanciaPuesto;
	 String constanciaGrado;
	 boolean valido;
	 String calificacion;

	public ProyectoResidencia()
	{
		id = "";
		control = "";
		periodo = "";
		nombreEstudiante = "";
		clavePlan = "";
		autorizadaAcademico = false;
		autorizadaDivision = true;
		calificar = false;
		inicio = (new Fecha(new Date())).yearMesDia();
		termino = (new Fecha(new Date())).yearMesDia();
		nombreProyecto = "";
		nombreAsesorExterno = "";
		gradoAsesorExterno = "C.";
		quienFirma = "";
		gradoQuienFirma = "C.";
		folio = 0L;
		nombreEmpresa = "";
		giroEmpresa = "";
		calleEmpresa = "";
		ciudadEmpresa = "";
		coloniaEmpresa = "";
		estadoEmpresa = "";
		postalEmpresa = "";
		telefonoEmpresa = "";
		emailEmpresa = "";
		misionEmpresa = "";
		nombreGerenteEmpresa = "";
		puestoGerenteEmpresa = "";
		nombreAsesorInterno = "";
		constanciaNombre = "";
		constanciaPuesto = "";
		constanciaGrado = "";
		valido = true;
		calificacion = "";
	}

	public ProyectoResidencia(Map<String, Object> m)
	{
		this();
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("id", id);
		m.put("control", getControl());
		m.put("nombreEstudiante", getNombreEstudiante());
		m.put("clavePlan", getClavePlan());
		m.put("periodo", getPeriodo());
		m.put("autorizadaAcademico", isAutorizadaAcademico());
		m.put("autorizadaDivision", isAutorizadaDivision());
		m.put("calificar", isCalificar());
		m.put("inicio", getInicio());
		m.put("termino", getTermino());
		m.put("nombreProyecto", getNombreProyecto());
		m.put("nombreAsesorExterno", getNombreAsesorExterno());
		m.put("gradoAsesorExterno", getGradoAsesorExterno());
		m.put("quienFirma", getQuienFirma());
		m.put("gradoQuienFirma", getGradoQuienFirma());
		m.put("folio", getFolio());
		m.put("nombreEmpresa", getNombreEmpresa());
		m.put("giroEmpresa", getGiroEmpresa());
		m.put("calleEmpresa", getCalleEmpresa());
		m.put("ciudadEmpresa", getCiudadEmpresa());
		m.put("coloniaEmpresa", getColoniaEmpresa());
		m.put("estadoEmpresa", getEstadoEmpresa());
		m.put("postalEmpresa", getPostalEmpresa());
		m.put("telefonoEmpresa", getTelefonoEmpresa());
		m.put("emailEmpresa", getEmailEmpresa());
		m.put("misionEmpresa", getMisionEmpresa());
		m.put("nombreGerenteEmpresa", getNombreGerenteEmpresa());
		m.put("puestoGerenteEmpresa", getPuestoGerenteEmpresa());
		m.put("nombreAsesorInterno", getNombreAsesorInterno());
		m.put("constanciaNombre", getConstanciaNombre());
		m.put("constanciaPuesto", getConstanciaPuesto());
		m.put("constanciaGrado", getConstanciaGrado());
		m.put("valido", isValido());
		m.put("calificacion", getCalificacion());
		return m;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		setId((String) m.get("periodo") + "_" + m.get("control"));
		setControl((String) m.get("control"));
		setPeriodo((String) m.get("periodo"));
		setNombreEstudiante((String) m.get("nombreEstudiante"));
		setClavePlan((String) m.get("clavePlan"));
		Boolean b = (Boolean) m.get("autorizadaAcademico");
		if (b == null)
			b = false;
		setAutorizadaAcademico(b);
		b = (Boolean) m.get("autorizadaDivision");
		if (b == null)
			b = false;
		setAutorizadaDivision(b);
		b = (Boolean) m.get("calificar");
		if (b == null)
			b = false;
		setCalificar(b);

		try
		{
			setInicio((String) m.get("inicio"));

			setTermino((String) m.get("termino"));
		} catch (Exception error)
		{
			System.err.println("Error:" + m);
		}
		setNombreProyecto((String) m.get("nombreProyecto"));
		setNombreAsesorExterno((String) m.get("nombreAsesorExterno"));
		setGradoAsesorExterno((String) m.get("gradoAsesorExterno"));
		setQuienFirma((String) m.get("quienFirma"));
		setGradoQuienFirma((String) m.get("gradoQuienFirma"));
		Long l = (Long) m.get("folio");
		if (l == null)
			l = 0L;
		setFolio(l);
		setNombreEmpresa((String) m.get("nombreEmpresa"));
		setGiroEmpresa((String) m.get("giroEmpresa"));
		setCalleEmpresa((String) m.get("calleEmpresa"));
		setCiudadEmpresa((String) m.get("ciudadEmpresa"));
		setColoniaEmpresa((String) m.get("coloniaEmpresa"));
		setEstadoEmpresa((String) m.get("estadoEmpresa"));
		setPostalEmpresa((String) m.get("postalEmpresa"));
		setTelefonoEmpresa((String) m.get("telefonoEmpresa"));
		setEmailEmpresa((String) m.get("emailEmpresa"));
		setMisionEmpresa((String) m.get("misionEmpresa"));
		setNombreGerenteEmpresa((String) m.get("nombreGerenteEmpresa"));
		setPuestoGerenteEmpresa((String) m.get("puestoGerenteEmpresa"));
		setNombreAsesorInterno((String) m.get("nombreAsesorInterno"));
		setConstanciaNombre((String) m.get("constanciaNombre"));
		setConstanciaPuesto((String) m.get("constanciaPuesto"));
		setConstanciaGrado((String) m.get("constanciaGrado"));
		setValido((Boolean) m.get("valido"));
		setCalificacion((String) m.get("calificacion"));
	}

	public String getCalificacion()
	{
		return calificacion;
	}

	public void setCalificacion(String calificacion)
	{
		this.calificacion = calificacion;
	}

	public boolean isValido()
	{
		return valido;
	}

	public void setValido(boolean valido)
	{
		this.valido = valido;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		if (id == null)
			id = "";
		this.id = id;
	}

	public String getNombreEstudiante()
	{
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante)
	{
		if (nombreEstudiante == null)
			this.nombreEstudiante = "";
		else
			this.nombreEstudiante = nombreEstudiante;
	}

	public String getClavePlan()
	{
		return clavePlan;
	}

	public void setClavePlan(String clavePlan)
	{
		if (clavePlan == null)
			clavePlan = "";
		this.clavePlan = clavePlan;
	}

	public String getConstanciaNombre()
	{
		return constanciaNombre;
	}

	public void setConstanciaNombre(String constanciaNombre)
	{
		if (constanciaNombre == null)
			constanciaNombre = "";
		this.constanciaNombre = constanciaNombre.toUpperCase();
	}

	public String getConstanciaPuesto()
	{
		return constanciaPuesto;
	}

	public void setConstanciaPuesto(String constanciaPuesto)
	{
		if (constanciaPuesto == null)
			constanciaPuesto = "";
		this.constanciaPuesto = constanciaPuesto.toUpperCase();
	}

	public String getConstanciaGrado()
	{
		return constanciaGrado;
	}

	public void setConstanciaGrado(String constanciaGrado)
	{
		if (constanciaGrado == null)
			constanciaGrado = "";
		this.constanciaGrado = constanciaGrado.toUpperCase();
	}

	public boolean isAutorizadaDivision()
	{
		autorizadaDivision = true;
		return autorizadaDivision;
	}

	public void setAutorizadaDivision(boolean autorizadaDivision)
	{
		this.autorizadaDivision = true;
	}

	public String getNombreAsesorInterno()
	{
		return nombreAsesorInterno;
	}

	public void setNombreAsesorInterno(String nombreAsesorInterno)
	{
		if (nombreAsesorInterno == null)
			nombreAsesorInterno = "";
		this.nombreAsesorInterno = nombreAsesorInterno;
	}

	public boolean isAutorizadaAcademico()
	{
		return autorizadaAcademico;
	}

	public void setAutorizadaAcademico(boolean autorizada)
	{
		this.autorizadaAcademico = autorizada;
	}

	public String getPeriodo()
	{
		return periodo;
	}

	public void setPeriodo(String periodo)
	{
		if (periodo == null)
			periodo = "";
		this.periodo = periodo;
	}

	public String getControl()
	{
		return control;
	}

	public void setControl(String control)
	{
		if (control == null)
			control = "";
		this.control = control.trim();
	}

	public String getNombreProyecto()
	{
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto)
	{
		if (nombreProyecto == null)
			nombreProyecto = "";
		this.nombreProyecto = nombreProyecto;
	}

	public String getInicio()
	{
		return inicio;
	}

	public void setInicio(String inicio)
	{
		if (inicio == null)
			inicio = "2023-08-01";
		this.inicio = inicio;
	}

	public String getTermino()
	{
		return termino;
	}

	public void setTermino(String termino)
	{
		if (termino == null)
			termino = "2023-08-01";
		this.termino = termino;
	}

	public String getNombreAsesorExterno()
	{
		return nombreAsesorExterno;
	}

	public void setNombreAsesorExterno(String nombreAsesorExterno)
	{
		if (nombreAsesorExterno == null)
			nombreAsesorExterno = "";
		this.nombreAsesorExterno = nombreAsesorExterno;
	}

	public String getGradoAsesorExterno()
	{
		return gradoAsesorExterno;
	}

	public void setGradoAsesorExterno(String gradoAsesorExterno)
	{
		if (gradoAsesorExterno == null)
			gradoAsesorExterno = "";
		this.gradoAsesorExterno = gradoAsesorExterno;
	}

	public String getQuienFirma()
	{
		return quienFirma;
	}

	public void setQuienFirma(String quienFirma)
	{
		if (quienFirma == null)
			quienFirma = "";
		this.quienFirma = quienFirma;
	}

	public String getGradoQuienFirma()
	{
		return gradoQuienFirma;
	}

	public void setGradoQuienFirma(String gradoQuienFirma)
	{
		if (gradoQuienFirma == null)
			gradoQuienFirma = "";
		this.gradoQuienFirma = gradoQuienFirma;
	}

	public long getFolio()
	{
		return folio;
	}

	public void setFolio(long folio)
	{
		this.folio = folio;
	}

	public String getNombreEmpresa()
	{
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa)
	{
		if (nombreEmpresa == null)
			nombreEmpresa = "";
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getGiroEmpresa()
	{
		return giroEmpresa;
	}

	public void setGiroEmpresa(String giroEmpresa)
	{
		if (giroEmpresa == null)
			giroEmpresa = "";
		this.giroEmpresa = giroEmpresa;
	}

	public String getCalleEmpresa()
	{
		return calleEmpresa;
	}

	public void setCalleEmpresa(String calleEmpresa)
	{
		if (calleEmpresa == null)
			calleEmpresa = "";
		this.calleEmpresa = calleEmpresa;
	}

	public String getCiudadEmpresa()
	{
		return ciudadEmpresa;
	}

	public void setCiudadEmpresa(String ciudadEmpresa)
	{
		if (ciudadEmpresa == null)
			ciudadEmpresa = "";
		this.ciudadEmpresa = ciudadEmpresa;
	}

	public String getColoniaEmpresa()
	{
		return coloniaEmpresa;
	}

	public void setColoniaEmpresa(String coloniaEmpresa)
	{
		if (coloniaEmpresa == null)
			coloniaEmpresa = "";
		this.coloniaEmpresa = coloniaEmpresa;
	}

	public String getEstadoEmpresa()
	{
		return estadoEmpresa;
	}

	public void setEstadoEmpresa(String estadoEmpresa)
	{
		if (estadoEmpresa == null)
			estadoEmpresa = "";
		this.estadoEmpresa = estadoEmpresa;
	}

	public String getPostalEmpresa()
	{
		return postalEmpresa;
	}

	public void setPostalEmpresa(String postalEmpresa)
	{
		this.postalEmpresa = postalEmpresa;
	}

	public String getTelefonoEmpresa()
	{
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa)
	{
		if (telefonoEmpresa == null)
			telefonoEmpresa = "";
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public String getEmailEmpresa()
	{
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa)
	{
		if (emailEmpresa == null)
			emailEmpresa = "";
		this.emailEmpresa = emailEmpresa;
	}

	public String getMisionEmpresa()
	{
		return misionEmpresa;
	}

	public void setMisionEmpresa(String misionEmpresa)
	{
		if (misionEmpresa == null)
			misionEmpresa = "";
		this.misionEmpresa = misionEmpresa;
	}

	public String getNombreGerenteEmpresa()
	{
		return nombreGerenteEmpresa;
	}

	public void setNombreGerenteEmpresa(String nombreGerenteEmpresa)
	{
		if (nombreGerenteEmpresa == null)
			nombreGerenteEmpresa = "";
		this.nombreGerenteEmpresa = nombreGerenteEmpresa;
	}

	public String getPuestoGerenteEmpresa()
	{
		return puestoGerenteEmpresa;
	}

	public void setPuestoGerenteEmpresa(String puestoGerenteEmpresa)
	{
		if (puestoGerenteEmpresa == null)
			puestoGerenteEmpresa = "";
		this.puestoGerenteEmpresa = puestoGerenteEmpresa;
	}

	public boolean isCalificar()
	{
		return calificar;
	}

	public void setCalificar(boolean calificar)
	{
		this.calificar = calificar;
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
