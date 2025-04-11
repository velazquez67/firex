package firex.it;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RHRegistroActividad implements IsSerializable
	{
		String	descripcion;
		String	horas;						// dia,hora\ndia,hora\n...

		public RHRegistroActividad()
			{
				descripcion = "";
				horas = null;
			}

		public String getDescripcion()
			{
				return descripcion;
			}

		public void setDescripcion(String descripcion)
			{
				this.descripcion = descripcion;
			}

		public String getHoras()
			{
				return horas;
			}

		public void setHoras(String horas)
			{
				this.horas = horas;
			}
	}
