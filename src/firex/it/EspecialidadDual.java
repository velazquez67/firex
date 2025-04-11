package firex.it;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import com.google.gwt.user.client.rpc.IsSerializable;

public class EspecialidadDual extends Especialidad implements IsSerializable
{

	 HashMap<String, Materia> materiasDual;

	public EspecialidadDual()
	{
		materiasDual = new HashMap<String, Materia>();
	}

	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("especialidadDual", true);
		return m;
	}

	public HashMap<String, Materia> getMaterias()
	{
		if (faltaAgregarMateriasDual())
			agregaMateriasDual();
		return materias;
	}

	public ArrayList<Materia> getMateriasOrdenadas()
	{
		TreeMap<String, Materia> mates = new TreeMap<String, Materia>();
		Iterator<Materia> i = materias.values().iterator();
		Materia m;
		while (i.hasNext())
		{
			m = i.next();
			mates.put(m.getAbreviado() + m.getClave(), m);
		}
		return new ArrayList<Materia>(mates.values());
	}

	private boolean faltaAgregarMateriasDual()
	{
		if (materiasDual.isEmpty())
			return false;
		String clave = materiasDual.keySet().iterator().next();
		return materias.get(clave) == null;
	}

	private void agregaMateriasDual()
	{
		Iterator<Materia> i = materiasDual.values().iterator();
		Materia mat;
		while (i.hasNext())
		{
			mat = i.next();
			materias.put(mat.getClave(), mat);
		}
	}

	public String toString()
	{
		return getNombre() + " [ DUAL " + clave + "]";
	}
}
