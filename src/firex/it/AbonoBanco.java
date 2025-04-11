package firex.it;

import java.util.HashMap;
import java.util.Map;
import com.google.gwt.user.client.rpc.IsSerializable;

//01/07/2020,Abono por cobranza Sucursal: 176 Referencia N�merica: 16091105 Referencia Alfan�merica: 16091105 Autorizaci�n: 00066213,720,-, 

public class AbonoBanco implements IsSerializable, Mapa
	{

		String     autorizacion;          // Es el numero que asigna el banco a cada movimiento realizado en
																			// la cuenta del
																			// Tecnologico
	
		String     referencia;            // numero de control, se asigna despues de haber revisado la
																			// referenciaNumerica
																			// y la referenciaAlfanumerica
		
		String     fecha;                 // YYYY/MM/DD fecha de pago
		String     cantidad;              // cuanto pago
		String     linea;                 // la linea de registro que envia el banco
		
		String     queSePago;             // aqui el estudiante describe que servicio pago
		boolean    validado;              // validado por recursos financieros
	
		String     referenciaNumerica;    // se almacena como referencia el numero de control del estudiante
	
		String     referenciaAlfanumerica;// se almacena como referencia el numero de control del estudiante
																			// cuando el
																			// numero contiene letras
	
		String     descripcionPago;       // solo se utiliza cuando es necesario vincular queSePago a una
																			// entidad del
																			// sistema, ej.
																			// Ejemplo: en Verano en queSePago se almacena el nombre de la
																			// materia y
		
		String     observaciones;
		Estudiante estudiante;

		public AbonoBanco()
			{
				autorizacion = "";
				referencia = "";
				fecha = "";
				cantidad = "";
				linea = "";
				queSePago = "";
				validado = false;
				referenciaNumerica = "";
				referenciaAlfanumerica = "";
				descripcionPago = "";
				observaciones = "";
				estudiante = null;
			}

		public AbonoBanco(Map<String, Object> m)
			{
				fromMap(m);
			}

		@Override
		public Map<String, Object> toMap()
			{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("autorizacion", autorizacion);
				m.put("referencia", referencia);
				m.put("fecha", fecha);
				m.put("cantidad", cantidad);
				m.put("linea", linea);
				m.put("queSePago", queSePago);
				m.put("validado", validado);
				m.put("referenciaNumerica", referenciaNumerica);
				m.put("referenciaAlfanumerica", referenciaAlfanumerica);
				m.put("descripcionPago", descripcionPago);
				m.put("observaciones", observaciones);
				return m;
			}

		@Override
		public void fromMap(Map<String, Object> m)
			{
				autorizacion = (String) m.get("autorizacion");
				referencia = (String) m.get("referencia");
				fecha = (String) m.get("fecha");
				cantidad = (String) m.get("cantidad");
				linea = (String) m.get("linea");
				queSePago = (String) m.get("queSePago");
				validado = (Boolean) m.get("validado");
				referenciaNumerica = (String) m.get("referenciaNumerica");
				referenciaAlfanumerica = (String) m.get("referenciaAlfanumerica");
				descripcionPago = (String) m.get("descripcionPago");
				observaciones = (String) m.get("observaciones");
			}

		// la "linea" se requiere en minusculas
		public AbonoBanco(String linea)
			{
				this();
				this.linea = linea;
				String aux;
				try
					{
						linea = linea.trim();
						if(linea.charAt(0) == 34)
							fecha = linea.replace("\"", "").substring(0, 10);
						else
							fecha = linea.substring(0, 10);
						fecha = fecha.substring(6, 10) + "/" + fecha.substring(3, 5) + "/" + fecha.substring(0, 2);// a�o
																																																				// mes
																																																				// dia
						int x = linea.indexOf("referencia n");
						aux = linea.substring(x + 21, x + 35);
						referenciaNumerica = aux.substring(0, aux.indexOf(' ')).trim();
						x = linea.indexOf("alfa");
						aux = linea.substring(x + 14, linea.length());
						referenciaAlfanumerica = aux.substring(0, aux.indexOf("autoriza")).trim();
						x = linea.indexOf("autoriza");
						aux = linea.substring(x + 14);
						autorizacion = aux.substring(0, 8) + "~" + fecha;
						aux = aux.substring(9);
						if(aux.charAt(0) == ',')
							aux = aux.substring(1);
						if(aux.charAt(0) == 34)
							{
								aux = aux.substring(1);
								cantidad = aux.substring(0, aux.indexOf(34)).trim();
							}
						else
							cantidad = aux.substring(0, aux.indexOf(',')).trim();
						observaciones = "";
					} catch (Exception error)
					{
						autorizacion = "";
					}
			}

		public String getObservaciones()
			{
				return observaciones;
			}

		public void setObservaciones(String observaciones)
			{
				this.observaciones = observaciones;
			}

		public String getDescripcionPago()
			{
				return descripcionPago;
			}

		public void setDescripcionPago(String descripcionPago)
			{
				this.descripcionPago = descripcionPago;
			}

		public Estudiante getEstudiante()
			{
				return estudiante;
			}

		public void setEstudiante(Estudiante estudiante)
			{
				this.estudiante = estudiante;
			}

		public String getReferenciaAlfanumerica()
			{
				return referenciaAlfanumerica;
			}

		public void setReferenciaAlfanumerica(String referenciaAlfanumerica)
			{
				this.referenciaAlfanumerica = referenciaAlfanumerica;
			}

		public String getReferenciaNumerica()
			{
				return referenciaNumerica;
			}

		public void setReferenciaNumerica(String referenciaNumerica)
			{
				this.referenciaNumerica = referenciaNumerica;
			}

		public boolean isValidado()
			{
				return validado;
			}

		public void setValidado(boolean validado)
			{
				this.validado = validado;
			}

		public String getQueSePago()
			{
				return queSePago;
			}

		public void setQueSePago(String queSePago)
			{
				this.queSePago = queSePago;
			}

		public String getAutorizacion()
			{
				return autorizacion;
			}

		public String getReferencia()
			{
				return referencia;
			}

		public String getCantidad()
			{
				return cantidad;
			}

		public String getLinea()
			{
				return linea;
			}

		public String getFecha()
			{
				return fecha;
			}

		public void setFecha(String fecha)
			{
				this.fecha = fecha;
			}

		public void setAutorizacion(String autorizacion)
			{
				this.autorizacion = autorizacion;
			}

		public void setReferencia(String referencia)
			{
				this.referencia = referencia;
			}

		public void setCantidad(String cantidad)
			{
				this.cantidad = cantidad;
			}

		public void setLinea(String linea)
			{
				this.linea = linea;
			}

		public String toString()
			{
				return linea;
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
	}
