package firex.it;


public class RegistroKardex
	{
		String     claveMateria;
		Evaluacion CN;
		Evaluacion RC;
		Evaluacion E;
		Materia    materia;

		protected RegistroKardex()
			{
				CN = null;
				RC = null;
				E = null;
			}

		public RegistroKardex(Materia mat)
			{
				this();
				this.claveMateria = mat.getClave();
				this.materia = mat;
			}

		public RegistroKardex(String clave)
			{
				this();
				this.claveMateria = clave;
			}

		public Materia getMateria()
			{
				return materia;
			}

		public void setMateria(Materia materia)
			{
				this.materia = materia;
			}

		public boolean esEquivalencia()
			{
				return (CN != null && CN.getTipoEvaluacion().equals(Evaluacion.Equivalencia));
			}

		public boolean esConvalidacion()
			{
				return (CN != null && CN.getTipoEvaluacion().equals(Evaluacion.Convalidacion));
			}

		public boolean estaAcreditada()
			{
				if(CN != null && CN.getCalificacion() > 0)
					return true;
				if(RC != null && RC.getCalificacion() > 0)
					return true;
				if(E != null && E.getCalificacion() > 0)
					return true;
				return false;
			}

		public String getPeriodoAcreditada()
			{
				if(CN != null && CN.getCalificacion() > 0)
					return CN.getPeriodo();
				if(RC != null && RC.getCalificacion() > 0)
					return RC.getPeriodo();
				if(E != null && E.getCalificacion() > 0)
					return E.getPeriodo();
				return "";
			}

		public String getFechaAcreditada()
			{
				if(CN != null && CN.getCalificacion() > 0)
					return CN.getFechaCalificacion();
				if(RC != null && RC.getCalificacion() > 0)
					return RC.getFechaCalificacion();
				if(E != null && E.getCalificacion() > 0)
					return E.getFechaCalificacion();
				return "";
			}

		public int getCalificacion()
			{
				if(E != null)
					return E.getCalificacion();
				if(RC != null)
					return RC.getCalificacion();
				if(CN != null)
					return CN.getCalificacion();
				return -1;
			}

		public String getCalificacionTexto()
			{
				if(E != null)
					return E.getCalificacionTexto();
				if(RC != null)
					return RC.getCalificacionTexto();
				if(CN != null)
					return CN.getCalificacionTexto();
				return "---";
			}

		public boolean estaSinCursar()
			{
				return CN == null;
			}

		public Evaluacion getEvaluacion(String periodo)
			{
				if(CN != null && CN.getPeriodo().equals(periodo))
					return CN;
				if(RC != null && RC.getPeriodo().equals(periodo))
					return RC;
				if(E != null && E.getPeriodo().equals(periodo))
					return E;
				return null;
			}

		public boolean estaReprobada()
			{
				return estaRepite() || estaEspecial();
			}

		public boolean estaRepite()
			{
				return E == null && CN != null && CN.getCalificacion() == 0 && RC == null;
			}

		public boolean estaEspecial()
			{
				return CN != null && CN.getCalificacion() == 0 && RC != null && RC.getCalificacion() == 0 && E == null;
			}

		public boolean especialReprobado()
			{
				return CN != null && CN.getCalificacion() == 0 && RC != null && RC.getCalificacion() == 0 && E != null
						&& E.getCalificacion() == 0;
			}

		public Evaluacion getCN()
			{
				return CN;
			}

		public void setCN(Evaluacion cN)
			{
				CN = cN;
				CN.setCN();
			}

		public Evaluacion getRC()
			{
				return RC;
			}

		public void setRC(Evaluacion rC)
			{
				RC = rC;
				RC.setRC();
			}

		public Evaluacion getE()
			{
				return E;
			}

		public void setE(Evaluacion e)
			{
				E = e;
				E.setE();
			}

		public String getClaveMateria()
			{
				return claveMateria;
			}

		@Override
		public boolean equals(Object obj)
			{
				if(this == obj)
					return true;
				if(obj == null)
					return false;
				if(!(obj instanceof RegistroKardex))
					return false;
				RegistroKardex other = (RegistroKardex) obj;
				if(claveMateria == null)
					{
						if(other.claveMateria != null)
							return false;
					}
				else
					if(!claveMateria.equals(other.claveMateria))
						return false;
				return true;
			}

		public String toString()
			{
				return this.claveMateria;
			}
	}
