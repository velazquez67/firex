package firex.it;

import java.util.Map;

public interface Mapa
{
	Map<String, Object> toMap();

	void fromMap(Map<String, Object> m);

	String gets(String campo);

	Object get(String campo);

}
