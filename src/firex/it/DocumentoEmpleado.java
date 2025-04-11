package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DocumentoEmpleado extends Documento implements IsSerializable, Mapa
{
	String rfc; // rfc del empleado sin homoclave;

	public DocumentoEmpleado()
	{
		rfc = "";
	}

	public DocumentoEmpleado(Map<String, Object> m)
	{
		fromMap(m);
		rfc = (String) m.get("rfc");
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("rfc", rfc);
		m.put("documento", "empleado");
		return m;
	}

	public String getRfc()
	{
		return rfc;
	}

	public void setRfc(String rfc)
	{
		if (rfc == null)
			rfc = "---";
		else
			rfc = rfc.substring(0, 10);
		this.rfc = rfc;
	}
}
