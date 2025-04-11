package firex;


import java.util.Map;

public interface Mapa
	{
		Map<String, Object> toMap();

		void fromMap(Map<String, Object> m);
	}
