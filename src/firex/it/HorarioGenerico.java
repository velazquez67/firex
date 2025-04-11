package firex.it;

import java.util.ArrayList;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class HorarioGenerico extends HLayout
	{
		class Celda extends HTMLPane
			{
				int dia;
				int hora;
			}

		static String[]     dia =
			{ "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" };
		int                 largo;
		int                 alto;
		VLayout             horario[][];
		ArrayList<HTMLPane> espacios;
		int                 col, ren;
		int                 horaActual;
		int                 diaActual;

		public HorarioGenerico()
			{
				largo = 80;
				alto = 28;
				horario = new VLayout[7][14];
				generaHorario();
			}

		public HorarioGenerico(int largo, int alto)
			{
				this.largo = largo;
				this.alto = alto;
				horario = new VLayout[7][14];
				generaHorario();
			}

		private void generaHorario()
			{
				VLayout horariox = new VLayout();
				HLayout renglon;
				for (ren = 0; ren < 14; ren++)
					{
						renglon = new HLayout();
						for (col = 0; col < 7; col++)
							{
								horario[col][ren] = new VLayout();
								horario[col][ren].setWidth(largo);
								horario[col][ren].setHeight(alto);
								horario[col][ren].setBorder("1px solid");
								if(col > 0 && ren > 0)
									horario[col][ren].setStyleName("horarioLimpio");
								else
									if(col == 0) // es la columna de las horas
										horario[col][ren].setWidth(50);
								renglon.addMember(horario[col][ren]);
							}
						horariox.addMember(renglon);
					}
				HTMLPane h;
				for (col = 1; col < 7; col++)
					{
						h = new HTMLPane();
						h.setContents(dia[col - 1]);
						horario[col][0].setMembers(h);
						horario[col][0].setStyleName("horasDias");
						horario[col][0].setOverflow(Overflow.HIDDEN);
					}
				for (ren = 1; ren < 14; ren++)
					{
						h = new HTMLPane();
						h.setContents((ren + 6) + "a" + (ren + 7));
						horario[0][ren].setMembers(h);
						horario[0][ren].setStyleName("horasDias");
						horario[0][ren].setOverflow(Overflow.HIDDEN);
					}
				horariox.setMargin(10);
				horariox.setHeight(400);
				this.setMembers(horariox);
			}

		public void agregaActividad(int dia, int hora, String actividad, String prompt, String estilo)
			{
				Celda h = new Celda();
				h.dia = dia;
				h.hora = hora;
				h.setContents(actividad);
				h.setPrompt(prompt);
				if(estilo != null)
					h.setStyleName(estilo);
				horario[dia][hora - 6].addMember(h);
				h.addClickHandler(new ClickHandler()
					{
						@Override
						public void onClick(ClickEvent event)
							{
								Celda d = (Celda) event.getSource();
								horaActual = d.hora;
								diaActual = d.dia;
								clickEnHoraDia();
							}
					});
			}

		public boolean estaOcupado(int dia, int hora)
			{
				return horario[dia][hora - 6].getMembersLength() > 0;
			}

		public void limpiaHorario(String estiloABorrar)
			{
				int col, ren;
				Canvas[] c;
				for (ren = 1; ren < 14; ren++)
					for (col = 1; col < 7; col++)
						{
							c = horario[col][ren].getMembers();
							if(c != null)
								for (int x = 0; x < c.length; x++)
									if(estiloABorrar == null)
										horario[col][ren].removeMembers(horario[col][ren].getMembers());
									else
										if(c[x].getStyleName().equals(estiloABorrar))
											horario[col][ren].removeMembers(c[x]);
						}
			}

		public void clickEnHoraDia()
			{
			}

		public void vacia()
			{
				int col, ren;
				Canvas[] c;
				for (ren = 1; ren < 14; ren++)
					for (col = 1; col < 7; col++)
						{
							c = horario[col][ren].getMembers();
							if(c != null)
								for (int x = 0; x < c.length; x++)
									horario[col][ren].removeMembers(horario[col][ren].getMembers());
						}
			}

		public int getHoraActual()
			{
				return horaActual + 6;
			}

		public int getDiaActual()
			{
				return diaActual;
			}
	}
