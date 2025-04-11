package firex.it;

import java.util.Date;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Fecha implements IsSerializable
	{
		public int dia, mes, year, hora, minuto, segundo;

		public Fecha()
			{
				this(new Date());
			}

		@SuppressWarnings("deprecation")
		public Fecha(Date d)
			{
				this.dia = d.getDate();
				this.mes = d.getMonth();
				this.year = d.getYear();
				this.hora = d.getHours();
				this.minuto = d.getMinutes();
				this.segundo = d.getSeconds();
			}

		public Fecha(long time)
			{
				this(new Date(time));
			}

		public Fecha(int dia, int mes, int year, int hora, int minuto, int segundo)
			{
				this.dia = dia;
				this.mes = mes;
				this.year = year;
				this.hora = hora;
				this.minuto = minuto;
				this.segundo = segundo;
			}

		public String yearMesDia()
			{
				return (year + 1900) + "-" + (((mes + 1) < 10) ? "0" + (mes + 1) : "" + (mes + 1)) + "-"
						+ ((dia > 9) ? "" + dia : "0" + dia);
			}

		public String toString()
			{
				return yearMesDia() + " " + getHora();
			}
		
		@SuppressWarnings("deprecation")
		public long getFechaM()
			{
				return (new Date(year, mes, dia, hora, minuto, segundo)).getTime();
			}

		public String getFecha()
			{
				return ((dia > 9) ? "" + dia : "0" + dia) + "/"
						+ (((mes + 1) < 10) ? "0" + (mes + 1) : "" + (mes + 1)) + "/" + (year + 1900);
			}

		public String getHora()
			{
				return ((hora > 9) ? "" + hora : "0" + hora) + ":" + ((minuto > 9) ? "" + minuto : "0" + minuto)
						+ ":" + ((segundo > 9) ? "" + segundo : "0" + segundo);
			}
	}
