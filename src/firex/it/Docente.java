package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Docente extends Empleado implements IsSerializable
{
	String cedula;
	String profesion;
	String institucionEgreso;
	String gradoCompleto;
	long yearExpedicionCedula;

	public Docente()
	{
		cedula = "";
		yearExpedicionCedula = 0;
		profesion = "";
		institucionEgreso = "";
		gradoCompleto = "";
	}

	public Docente(Map<String, Object> datos)
	{
		super(datos);
		cedula = (String) datos.get("cedula");
		yearExpedicionCedula = (Long) datos.get("yearExpedicionCedula");
		profesion = (String) datos.get("profesion");
		institucionEgreso = (String) datos.get("institucionEgreso");
		gradoCompleto = (String) datos.get("gradoCompleto");
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("tipo", "docente");
		m.put("cedula", cedula);
		m.put("yearExpedicionCedula", yearExpedicionCedula);
		m.put("profesion", profesion);
		m.put("institucionEgreso", institucionEgreso);
		m.put("gradoCompleto", gradoCompleto);
		return m;
	}

	public String getCedula()
	{
		return cedula;
	}

	public void setCedula(String cedula)
	{
		this.cedula = cedula;
	}

	public long getYearExpedicionCedula()
	{
		return yearExpedicionCedula;
	}

	public void setYearExpedicionCedula(long yearExpedicionCedula)
	{
		this.yearExpedicionCedula = yearExpedicionCedula;
	}

	public String getProfesion()
	{
		return profesion;
	}

	public void setProfesion(String profesion)
	{
		this.profesion = profesion;
	}

	public String getInstitucionEgreso()
	{
		return institucionEgreso;
	}

	public void setInstitucionEgreso(String institucionEgreso)
	{
		this.institucionEgreso = institucionEgreso;
	}

	public String getGradoCompleto()
	{
		return gradoCompleto;
	}

	public void setGradoCompleto(String gradoCompleto)
	{
		this.gradoCompleto = gradoCompleto;
	}

	public String getGradoCorto()
	{
		return this.getAbreviaturaTitulo();
	}

	public void setGradoCorto(String gradoCorto)
	{
		this.setAbreviaturaTitulo(gradoCorto);
	}
}
