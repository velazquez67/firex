package firex.it;

import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

public class DocumentoExpediente extends Documento implements IsSerializable
{
	boolean revisado;
	boolean valido;

	public DocumentoExpediente()
	{
		revisado = false;
		valido = false;
		
	}

	public DocumentoExpediente(Map<String, Object> m)
	{
		fromMap(m);
		revisado = (Boolean) m.get("revisado");
		valido = (Boolean) m.get("valido");
	}

	@Override
	public Map<String, Object> toMap()
	{
		Map<String, Object> m = super.toMap();
		m.put("revisado", revisado);
		m.put("valido", valido);
		m.put("documento", "expediente");
		return m;
	}

	public boolean isRevisado()
	{
		return revisado;
	}

	public void setRevisado(boolean revisado)
	{
		this.revisado = revisado;
	}

	public boolean isValido()
	{
		return valido;
	}

	public void setValido(boolean valido)
	{
		this.valido = valido;
	}
}
