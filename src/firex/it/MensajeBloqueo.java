package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class MensajeBloqueo implements IsSerializable, Mapa
{
	Map<String, Object> m;

	public MensajeBloqueo()
	{
		m = new HashMap<String, Object>();
	}

	public MensajeBloqueo(Map<String, Object> m)
	{
		this();
		fromMap(m);
	}

	@Override
	public Map<String, Object> toMap()
	{
		return m;
	}

	@Override
	public void fromMap(Map<String, Object> m)
	{
		this.m = m;
	}

	@Override
	public String gets(String campo)
	{
		return (String) m.get(campo);
	}

	@Override
	public Object get(String campo)
	{
		return m.get(campo);
	}
}
