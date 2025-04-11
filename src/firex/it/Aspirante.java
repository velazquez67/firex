package firex.it;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Aspirante extends Estudiante implements IsSerializable
	{
	
		String	carreraIngreso;
		String	idCeneval;
		boolean	aceptado;

		public Aspirante()
			{
				idCeneval = "";
				carreraIngreso = "";
				aceptado = true;
			}

		public String getCarreraIngreso()
			{
				return carreraIngreso;
			}

		public void setCarreraIngreso(String carreraIngreso)
			{
				this.carreraIngreso = carreraIngreso;
			}

		public String getIdCeneval()
			{
				return idCeneval;
			}

		public void setIdCeneval(String idCeneval)
			{
				this.idCeneval = idCeneval;
			}

		public String getMatricula()
			{
				return getControl();
			}

		public void setMatricula(String idItz)
			{
				setControl(idItz);
			}

		public boolean isAceptado()
			{
				return aceptado;
			}

		public void setAceptado(boolean aceptado)
			{
				this.aceptado = aceptado;
			}
	}
