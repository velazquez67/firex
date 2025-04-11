package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Usuario implements IsSerializable, Mapa
{
	String nombre;
	String password;
	ArrayList<String> permisos;
	boolean activo;
	String sesion;
	Map<String, String> bloqueos;
	long credencial;
	String apellidosNombre;
	String foto; // ignore
	long avisoReinscripcion; // ignore
	boolean pagoReinscripcion; // ignore
	Estudiante estudiante; // ignore
	Empleado empleado; // ignore
	String uid;
	String nivel;

	public Usuario()
	{
		nombre = "";
		password = "";
		activo = true;
		permisos = new ArrayList<String>();
		sesion = "";
		bloqueos = new HashMap<String, String>();
		credencial = 0L;
		apellidosNombre = "";
		uid = null;
		nivel="";
	}

	public Usuario(Map<String, Object> datos)
	{
		fromMap(datos);
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("nombre", nombre);
		m.put("password", password);
		m.put("permisos", permisos);
		m.put("activo", activo);
		m.put("sesion", sesion);
		m.put("bloqueos", bloqueos);
		m.put("credencial", credencial);
		m.put("apellidosNombre", apellidosNombre);
		m.put("uid", uid);
		m.put("nivel", nivel);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void fromMap(Map<String, Object> datos)
	{
		nombre = (String) datos.get("nombre");
		password = (String) datos.get("password");
		permisos = (ArrayList<String>) datos.get("permisos");
		activo = (Boolean) datos.get("activo");
		sesion = (String) datos.get("sesion");
		nivel=(String) datos.get("nivel");
		bloqueos = (Map<String, String>) datos.get("bloqueos");
		Long l = (Long) datos.get("credencial");
		apellidosNombre = (String) datos.get("apellidosNombre");
		credencial = (l != null) ? l : 0L;
		if (datos.get("uid") != null)
			uid = (String) datos.get("uid");
	}
	
	

	public String getNivel()
	{
		return nivel;
	}

	public void setNivel(String nivel)
	{
		this.nivel = nivel;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getUid()
	{
		return uid;
	}

	public long getCredencial()
	{
		return credencial;
	}

	public void setCredencial(long credencial)
	{
		this.credencial = credencial;
	}

	public String getApellidosNombre()
	{
		return apellidosNombre;
	}

	public void setApellidosNombre(String apellidosNombre)
	{
		this.apellidosNombre = apellidosNombre;
	}

	public Map<String, String> getBloqueos()
	{
		return bloqueos;
	}

	public void setBloqueos(Map<String, String> bloqueos)
	{
		this.bloqueos = bloqueos;
	}

	public long getCodigoCredencial()
	{
		return credencial;
	}

	public void setCodigoCredencial(long codigoCredencial)
	{
		this.credencial = codigoCredencial;
	}

	public Estudiante getEstudiante()
	{
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}

	public Empleado getEmpleado()
	{
		return empleado;
	}

	public void setEmpleado(Empleado empleado)
	{
		this.empleado = empleado;
	}

	public void setPermisos(ArrayList<String> permisos)
	{
		this.permisos = permisos;
	}

	public String getSesion()
	{
		return sesion;
	}

	public boolean isPagoReinscripcion()
	{
		return pagoReinscripcion;
	}

	public void setPagoReinscripcion(boolean pagoReinscripcion)
	{
		this.pagoReinscripcion = pagoReinscripcion;
	}

	public long getAvisoReinscripcion()
	{
		return avisoReinscripcion;
	}

	public void setAvisoReinscripcion(long avisoReinscripcion)
	{
		this.avisoReinscripcion = avisoReinscripcion;
	}

	public void setSesion(String sesion)
	{
		this.sesion = sesion;
	}

	public String getFoto()
	{
		return foto;
	}

	public void setFoto(String foto)
	{
		this.foto = foto;
	}

	public boolean tienePermisoDe(String permiso)
	{
		for (int x = 0; x < permisos.size(); x++)
			if (permisos.get(x).equals(permiso))
				return true;
		return false;
	}

	public void agregaPermiso(String nvoPermiso)
	{
		if (!permisos.contains(nvoPermiso))
			permisos.add(nvoPermiso);
	}

	public boolean isActivo()
	{
		return activo;
	}

	public void setActivo(boolean activo)
	{
		this.activo = activo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String usuario)
	{
		this.nombre = usuario;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public ArrayList<String> getPermisos()
	{
		return permisos;
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

	public boolean estaBloqueado()
	{
		return bloqueos != null && !bloqueos.isEmpty();
	}

	public String getUsuarioQueBloquea()
	{
		ArrayList<String> permisos = getPermisos();
		String p;
		for (int x = 0; x < permisos.size(); x++)
		{
			p = permisos.get(x);
			if (p.contains("bloqueo"))
				return p;
		}
		return null;
	}
}
