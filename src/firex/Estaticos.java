package firex;

public class Estaticos
{
	static public String[] sem =
	{ "", "primer", "segundo", "tercer", "cuarto", "quinto", "sexto", "septimo", "octavo",
			"noveno", "décimo", "onceavo",
			"doceavo", "treceavo", "catorceavo", "quinceavo", "16", "17", "18", "19", "20" };
	static public String[] numSem =
	{ "", "1er.", "2do.", "3er.", "4to.", "5to.", "6to.", "7mo.", "8vo.", "9no.", "10mo.", "11vo.", "12vo.", "13vo.",
			"14vo.", "15vo.", "16vo.", "17vo.", "18vo.", "19vo.", "20" };
	static public String dia[] =
	{ "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
	static public String[] romano =
	{ "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII" };
	static public String[] numero =
	{ "cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece",
			"catorce", "quince", "dieciseis", "diecisiete", "dieciocho", "diecinueve", "veinte", "veintiuno", "veintidos",
			"veintitrés", "veinticuatro", "veinticinco", "veintiseis", "veintisiete", "veintiocho", "veintinueve", "treinta",
			"treinta y uno" };
	static public String mes[] =
	{ "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre",
			"diciembre" };
	// DEPARTAMENTOS
	static public String DESARROLLO_ACADEMICO = "110800";
	static public String DIVISION_ESTUDIOS = "111000";
	static public String POSGRADO = "110900";
	static public String EXTRAESCOLARES = "120400";
	static public String ESCOLARES = "120600";
	static public String DIRECCION = "100000";
	static public String GESTION = "120200";
	static public String SUBDIRECCION_ACADEMICA = "110000";
	static public String RECURSOS_FINANCIEROS = "130400";
	// MATERIAS
	static public String SERVICIO_SOCIAL = "SERVSOC";
	static public String ACTIVIDAD_CULTURAL = "ACTCULT";
	static public String ACTIVIDAD_DEPORTIVA = "ACTDEPO";
	static public String ACTIVIDAD_ACADEMICA = "ACTACAD";
	static public String ACTIVIDAD_ACADEMICA2 = "ACTACA2";
	static public String TUTORIA1 = "TUTOR01";
	static public String TUTORIA2 = "TUTOR02";
	static public String RESIDENCIA = "RESPROF";
	// RUTAS
	static public String dominioIt = "zacatepec.tecnm.mx";
	static public String idProyecto = "tecnamex";
	static public String pagina = idProyecto + ".appspot.com";
	static public String rutaPagina = "https://" + idProyecto + ".appspot.com";
	static public String rutaServlet = "https://" + idProyecto + ".appspot.com/serve?foto=";
	static public String rutaFoto = "https://" + idProyecto + ".appspot.com/serve?foto=";
	static public String rutaAlmacen = "/gs/" + idProyecto + ".appspot.com/";
	static public String rutaDocumento = "https://" + idProyecto + ".appspot.com/serve?documento=";
	static public String carpetaFotos = "/gs/" + idProyecto + ".appspot.com/fotos/";
	static public String carpetaFirmas = "/gs/" + idProyecto + ".appspot.com/firmas/";
	static public String carpetaSellos = "/gs/" + idProyecto + ".appspot.com/sellos/";
	static public String carpetaDocumentos = "/gs/" + idProyecto + ".appspot.com/documentos/";
	static public String carpetaDocumentosGenerados = "/gs/" + idProyecto + ".appspot.com/documentos/generados/";
	static public String municipioNombre = "ZACATEPEC";
	static public String municipioNumero = "17031";
	static public String estadoNumero = "17";
	static public String estadoNombre = "MORELOS";
	// RUTAS FIREBASE
	static public String raizFirebase = "itz/tecnamex/";
	static public String fAbonoBanco = raizFirebase + "abonoBanco";
	static public String fAulas = raizFirebase + "aulas";
	static public String fcovidGeneral = raizFirebase + "covidGeneral";
	static public String fEdificios = raizFirebase + "edificios";
	static public String fEmpleados = raizFirebase + "empleados";
	static public String fEstudiantes = raizFirebase + "estudiantes";
	static public String fGrupos = raizFirebase + "grupos";
	static public String fHorarios = raizFirebase + "horarios";
	static public String fPlanes = raizFirebase + "planes";
	static public String fSeleccionMaterias = raizFirebase + "seleccionMaterias";
	static public String fTecnologico = raizFirebase + "tecnologico";
	static public String fUsuarios = raizFirebase + "usuarios";
	static public String fProyectosResidencia = raizFirebase + "residencias";
	static public String fDocumentosValidados = raizFirebase + "documentosValidados";
	static public String fDatosEmpleado = raizFirebase + "datosEmpleado";
}
