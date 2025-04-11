package firex;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.gson.Gson;
import firex.it.Estudiante;
import firex.it.Kardex;
import firex.it.Materia;
import firex.it.PlanEstudios;
import firex.it.RegistroKardex;
import firex.it.Usuario;

public class Principal
{
	Firestore f;
	Storage storage;
	FirebaseAuth auth;

	public static void main(String[] args) throws Exception
	{
		Principal p = new Principal();
		System.out.println("inicia");
		p.conectar(new RegistroFirebase().tecZacatepec(), "teczacatepec");
		p.cambiaClavesHorarios("20251", "ACF0901", "ACF-2301");
		System.out.println("fin");
	}

	@SuppressWarnings("unchecked")
	public void cambiaClavesHorarios(String periodo, String materiaOld,
			String materiaNew) throws Exception
	{
		CollectionReference colH = f.collection("itz/tecnamex/horarios");
		List<QueryDocumentSnapshot> l = colH.whereEqualTo("periodo", periodo).get()
				.get().getDocuments();
		Map<String, Object> data, mat;
		for (int x = 0; x < l.size(); x++)
		{
			data = l.get(x).getData();
			if (data.get("#" + materiaOld) != null)
			{
				mat = (Map<String, Object>) data.get("#" + materiaOld);
				
				data.remove("#" + materiaOld);
				System.out.println(data);
//				mat.put("claveMateria", materiaNew);
//				mat.put("idGrupo", periodo + "|" + materiaNew + "|" + mat.get("grupo"));
//				data.put("#" + materiaNew, mat);
//				System.out.println(data);
				DocumentReference doc = l.get(x).getReference();
				doc.set(data).get();
				
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void cambiaClavesGrupos(String periodo, String materiaOld,
			String materiaNew) throws Exception
	{
		CollectionReference colG = f.collection("itz/tecnamex/grupos");
		List<QueryDocumentSnapshot> l = colG.whereEqualTo("periodo", periodo)
				.whereEqualTo("claveMateriaBase", materiaOld).get().get()
				.getDocuments();
		Map<String, Object> data;
		DocumentReference doc;
		for (int x = 0; x < l.size(); x++)
		{
			data = l.get(x).getData();
			System.out.println(data.get("id").toString());
			data.put("claveMateriaBase", materiaNew);
			data.put("id", periodo + "|" + materiaNew + "|" + data.get("grupo"));
			ArrayList<String> aux = new ArrayList<String>();
			aux.add(materiaNew);
			data.put("clavesMaterias", aux);
			Map<String, Object> materias = (Map<String, Object>) data.get("materias");
			Map<String, Object> mat = (Map<String, Object>) materias.values()
					.iterator().next();
			materias.remove(data.get("clavePlanBase") + "_" + materiaOld);
			mat.put("clave", materiaNew);
			mat.put("claveOficial", materiaNew);
			materias.put(data.get("clavePlanBase") + "_" + materiaNew, mat);
			doc = colG.document(data.get("id").toString());
			doc.set(data).get();
			System.out.println(data.get("id").toString());

			CollectionReference colEOld = f.collection("itz/tecnamex/grupos/" + periodo + "|"
					+ materiaOld + "|" + data.get("grupo") + "/estudiantes");
			CollectionReference colENew = f.collection("itz/tecnamex/grupos/" + periodo + "|"
					+ materiaNew + "|" + data.get("grupo") + "/estudiantes");
			List<QueryDocumentSnapshot> ests = colEOld.get().get().getDocuments();
			for (int w = 0; w < ests.size(); w++)
			{
				data = ests.get(w).getData();
				doc = colENew.document(data.get("control").toString());
				doc.set(data).get();
			}

		}
	}

	public void respaldo(String periodo) throws Exception
	{
		String[] entidades =
		{ // "aulas",
			// "conceptoBanco",
			// "condonaciones",
			// "cuestionarioEvaluacionDocente",
			// "departamentos",
			// "empleados",
			// "entidadesFederativas",
				"estudiantes",
				// "grupos",
				// "horarios",
				// "planes",
				// "residencias",
				// "servicioSocial",
				// "tecnologico",
				// "usuarios"
		};
		BufferedWriter arch;
		CollectionReference col;
		Iterator<QueryDocumentSnapshot> i, ie;
		String entidad, clavePlan, json;
		Gson gson = new Gson();
		for (int x = 0; x < entidades.length; x++)
		{
			entidad = entidades[x];
			System.out.println(entidad);
			col = f.collection("itz/tecnamex/" + entidad);
			if (entidad.equals("estudiantes"))
			{
				CollectionReference colPlanes = f.collection("itz/tecnamex/planes");
				i = colPlanes.get().get().iterator();
				while (i.hasNext())
				{
					clavePlan = i.next().getString("clave");
					System.out.println(clavePlan);
					ie = col.whereEqualTo("clavePlanEstudios", clavePlan).get().get()
							.iterator();
					arch = new BufferedWriter(new FileWriter(
							"c:\\aurelio\\respaldos\\Estudiantes_" + clavePlan + ".json"));
					arch.write("[\n");
					while (ie.hasNext())
					{
						json = gson.toJson(ie.next().getData());
						arch.write(json.replace("},", "},\n"));
					}
					arch.write("\n]");
					arch.close();
				}

			}
			else
			{
				if (entidad.equals("grupos") || entidad.equals("horarios")
						|| entidad.equals("residencias")
						|| entidad.equals("servicioSocial"))
					i = col.whereEqualTo("periodo", periodo).get().get().iterator();
				else
					i = col.get().get().iterator();
				arch = new BufferedWriter(
						new FileWriter("c:\\aurelio\\respaldos\\" + entidad + ".json"));
				while (i.hasNext())
				{
					json = gson.toJson(i.next().getData());
					arch.write(json.replace("},", "},\n"));
				}
				arch.write("\n]");
				arch.close();

			}
		}
	}

	public void foto(String archivo) throws IllegalArgumentException
	{
		BlobstoreService blobstoreService = BlobstoreServiceFactory
				.getBlobstoreService();
		String ruta = "/gs/tecnamex.appspot.com/fotos/";
		System.out.println(blobstoreService);
		System.out.println(ruta + archivo);
		BlobKey bk = blobstoreService.createGsBlobKey(ruta + archivo);
		System.out.println(bk.getKeyString());
	}

	public void jojutlaDescarga() throws Exception
	{

		String[] nombres =
		{ "JESUS MELGAR VASQUEZ" };

		CollectionReference col = f.collection("jojutla");
		FileWriter f = new FileWriter(
				"c:\\aurelio\\credencialesJojutla\\jojutlaFinal.csv");
		BufferedWriter arch = new BufferedWriter(f);
		arch.write("PAGINA\t");
		for (int x = 1; x <= 5; x++)
		{
			arch.write("NOMBRE" + x + "\tAREA" + x + "\tCARGO" + x + "\tCURP" + x
					+ "\tDEPARTAMENTO" + x + "\tFIRMO" + x + "\tNUMERO" + x + "\tRFC" + x
					+ "\tSANGRE" + x + "\tFOTO" + x + "\tFIRMA" + x);
			if (x < 5)
				arch.write("\t");
		}
		arch.write("\n");
		List<QueryDocumentSnapshot> l = col.get().get().getDocuments();
		Map<String, Object> data;
		int pagina = 1;
		int cont = 1;
		boolean existe;
		String n;
		for (int x = 0; x < l.size(); x++)
		{
			data = l.get(x).getData();
			n = data.get("nombre").toString();
			existe = false;
			for (int y = 0; y < nombres.length; y++)
				if (n.equals(nombres[y]))
				{
					System.out.println(n);
					existe = true;
					break;
				}
			if (existe)
			{
				if (cont == 1)
					arch.write(pagina + "\t");
				arch.write(data.get("nombre") + "\t" + data.get("area") + "\t"
						+ data.get("cargo") + "\t" + data.get("curp") + "\t"
						+ data.get("departamento") + "\t" + data.get("firmo") + "\t"
						+ data.get("numero") + "\t" + data.get("rfc") + "\t"
						+ data.get("sangre") + "\t"
						+ "c:\\aurelio\\credencialesJojutla\\fotos\\" + data.get("curp")
						+ ".png" + "\t" + "c:\\aurelio\\credencialesJojutla\\firmas\\"
						+ data.get("curp") + ".png");
				if (cont < 5)
					arch.write("\t");
				cont++;
				if (cont == 6)
				{
					cont = 1;
					pagina++;
					arch.write("\n");

				}
			}
		}
		arch.write("\n");
		arch.close();

	}

	public void pruebaGo() throws Exception
	{
		CollectionReference col = f.collection(Estaticos.fEstudiantes);
		Iterator<QueryDocumentSnapshot> i = col.get().get().getDocuments()
				.iterator();
		Date inicio = new Date();
		while (i.hasNext())
		{
			i.next();
		}
		Date fin = new Date();
		System.out.println(inicio.getTime());
		System.out.println(fin.getTime());
		System.out.println(fin.getTime() - inicio.getTime());

	}

	@SuppressWarnings("unchecked")
	public void titulados() throws Exception
	{
		CollectionReference col = f.collection(Estaticos.fEstudiantes);
		DocumentReference doc;
		FileReader f = new FileReader("c:\\aurelio\\titulados.txt");
		BufferedReader arch = new BufferedReader(f);
		String[] cad;
		String control, fecha;
		Map<String, Object> titulacion = new HashMap<String, Object>();

		arch.readLine();
		String ss, opcion;
		while (arch.ready())
		{
			ss = arch.readLine();
			cad = ss.split("\t");
			if (cad.length > 2)
			{
				fecha = cad[0];
				control = cad[1];
				opcion = cad[2];
				doc = col.document(control);
				if (doc.get().get().exists())
				{
					titulacion = (Map<String, Object>) doc.get().get().getData()
							.get("titulacion");
					if (titulacion == null)
					{
						titulacion = new HashMap<String, Object>();
						titulacion.put("fechaTitulacion", "");
						titulacion.put("opcion", "");
						titulacion.put("fechaExpedicion", "");
					}
					titulacion.put("fechaTitulacion", fecha);
					titulacion.put("opcion", opcion.trim());
					// titulacion.put("fechaExpedicion", fechaExpedicion);
					doc.update("titulacion", titulacion).get();
					System.out.println(ss);
				}
				else
					System.out.println(control);
			}
		}
		arch.close();

	}

	public void jojutla() throws Exception
	{
		BufferedReader arch = new BufferedReader(
				new FileReader("c:\\aurelio\\pensionados2.txt"));
		CollectionReference col = f.collection("jojutla");
		String linea;
		String[] a;
		Map<String, Object> data = new HashMap<String, Object>();
		DocumentReference doc;
		while (arch.ready())
		{
			linea = arch.readLine();
			a = linea.split("\t");

			doc = col.document(a[3]);
			data.put("numero", a[0].trim());
			data.put("departamento", a[4].trim());

			data.put("nombre", a[1].trim());

			data.put("cargo", a[5].trim());

			data.put("area", a[4].trim());

			data.put("rfc", a[2].trim());
			data.put("curp", a[3].trim());
			data.put("sangre", "");
			data.put("firmo", false);
			doc.set(data).get();

			System.out.println(a[3]);
		}
		arch.close();

	}

	public void actualizaInscritos() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/grupos");
		Iterator<QueryDocumentSnapshot> i = col.get().get().iterator();
		DocumentReference doc;
		int x;
		while (i.hasNext())
		{
			doc = i.next().getReference();
			try
			{
				x = f.collection("itz/tecnamex/grupos/" + doc.getId() + "/estudiantes")
						.get().get().getDocuments().size();
			} catch (Exception error)
			{
				x = 0;
			}
			doc.update("inscritos", x).get();
			System.out.println(doc.getId());
		}

	}

	public void copiaAspirantesPapaloapan() throws Exception
	{
		Principal p = new Principal();
		p.conectar(new RegistroFirebase().aspirantespapaloapan(),
				"ingresopapaloapan");
		CollectionReference col = p.f.collection("entidadesFederativas");

		Principal p2 = new Principal();
		p2.conectar(new RegistroFirebase().aspirantesitz(), "aspirantesitz");
		CollectionReference col2 = p2.f.collection("entidadesFederativas");
		List<QueryDocumentSnapshot> l = col2.get().get().getDocuments();

		Map<String, Object> data;
		DocumentReference doc, doc2;
		for (int x = 0; x < l.size(); x++)
			try
			{
				doc2 = l.get(x).getReference();
				data = doc2.get().get().getData();

				doc = col.document((String) data.get("numero"));

				System.out.println(data);
				doc.set(data).get();
			} catch (Exception error)
			{
			}
	}

	@SuppressWarnings("unchecked")
	public void restauraGrupoArregloClavesMateria(String periodo) throws Exception
	{
		CollectionReference col = f.collection(Estaticos.fGrupos);
		List<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", periodo)
				.whereEqualTo("clavesPlanes", null).

				get().get().getDocuments();
		Map<String, Object> data, aux;
		String key;
		String plan;
		DocumentReference doc;
		ArrayList<String> a;
		Iterator<String> i;
		for (int x = 0; x < l.size(); x++)
		{
			data = l.get(x).getData();
			aux = (Map<String, Object>) data.get("materias");
			i = aux.keySet().iterator();
			a = new ArrayList<String>();
			while (i.hasNext())
			{
				key = i.next();
				plan = key.split("_")[0];
				a.add(plan);
			}
			doc = l.get(x).getReference();
			doc.update("clavesPlanes", a).get();
			System.out.println(data.get("id"));
		}
	}

	@SuppressWarnings("unchecked")
	public void corrigeHorariosEstudiantes(String periodo) throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/grupos");
		Iterator<QueryDocumentSnapshot> i = col.whereEqualTo("periodo", periodo)
				.get().get().iterator();
		TreeMap<String, Map<String, Object>> grupos = new TreeMap<String, Map<String, Object>>();
		Map<String, Object> horario, mat, grupo;
		while (i.hasNext())
		{
			grupo = i.next().getData();
			grupos.put((String) grupo.get("id"), grupo);
		}
		col = f.collection("itz/tecnamex/horarios");
		i = col.whereEqualTo("periodo", periodo).get().get().iterator();
		DocumentReference doc;
		Iterator<String> ih;
		String k;
		boolean almacena;
		while (i.hasNext())
		{
			almacena = false;
			doc = i.next().getReference();
			horario = doc.get().get().getData();
			ih = horario.keySet().iterator();
			while (ih.hasNext())
			{
				k = ih.next();
				if (k.charAt(0) == '#')
				{
					mat = (Map<String, Object>) horario.get(k);
					grupo = grupos.get(mat.get("idGrupo"));
					if (!mat.get("docente").equals(grupo.get("docente"))
							|| diferente((ArrayList<Object>) mat.get("claseDia"),
									(ArrayList<Object>) grupo.get("claseDia"))
							|| diferente((ArrayList<Object>) mat.get("claseHora"),
									(ArrayList<Object>) grupo.get("claseHora"))
							|| diferente((ArrayList<Object>) mat.get("claseAula"),
									(ArrayList<Object>) grupo.get("claseAula")))
					{
						System.out.println(horario.get("control"));
						System.out.println(mat.get("claseDia"));
						System.out.println(grupo.get("claseDia"));
						System.out.println(mat.get("claseHora"));
						System.out.println(grupo.get("claseHora"));
						System.out.println(mat.get("claseAula"));
						System.out.println(grupo.get("claseAula"));
						System.out.println(mat.get("docente"));
						System.out.println(grupo.get("docente"));

						mat.put("claseDia", grupo.get("claseDia"));
						mat.put("claseAula", grupo.get("claseAula"));
						mat.put("claseHora", grupo.get("claseHora"));
						mat.put("docente", grupo.get("docente"));
						almacena = true;
						System.out.println("*********************************************");

					}
				}
			}
			if (almacena)
				doc.update(horario).get();
		}
	}

	boolean diferente(ArrayList<Object> a, ArrayList<Object> b)
	{
		if (a.size() != b.size())
			return true;
		for (int x = 0; x < a.size(); x++)
			if (!a.get(x).equals(b.get(x)))
				return true;
		return false;
	}

	public void mensajeCorreosNuevoIngreso() throws Exception
	{
		BufferedReader arch = new BufferedReader(
				new FileReader("c:\\aurelio\\correos.csv"));
		CollectionReference col = f.collection("itz/tecnamex/mensajes");
		String linea, ctrl;
		String[] a;
		Map<String, Object> data = new HashMap<String, Object>();
		DocumentReference doc;
		while (arch.ready())
		{
			doc = col.document();
			linea = arch.readLine();
			// System.out.println(linea);
			a = linea.split(",");
			ctrl = a[1].split("@")[0].replaceFirst("L", "");
			System.out.println(ctrl + "  " + a[1]);
			data.put("fechaCreacion", "2024-08-15");
			data.put("id", doc.getId());
			data.put("mensaje",
					"Bienvenido(a). Tu usuario y contraseña \r\n"
							+ "del correo institucional es:\r\n\r\n" + "usuario:" + a[1]
							+ "\r\n" + "Contraseña:" + a[2] + "\r\n\r\n"
							+ "Ingresa desde hotmail o outlook");
			data.put("para", ctrl);
			data.put("subtitulo", "");
			data.put("titulo", "CORREO ELECTRONICO");
			data.put("usuario", "DEPARTAMENTO DE CENTRO DE COMPUTO");
			doc.set(data).get();
		}

		arch.close();
	}

	public void corrigeHistoriaQuebec() throws Exception
	{
		Principal p = new Principal();
		p.conectar(new RegistroFirebase().quebec(), "colegioquebec");
		CollectionReference col = p.f.collection("historiaAcademica");
		CollectionReference col2 = p.f.collection("estudiantes");
		List<QueryDocumentSnapshot> l = col.whereEqualTo("ciclo", "2024-2025").get()
				.get().getDocuments();
		Map<String, Object> data;
		DocumentReference doc, est;
		for (int x = 0; x < l.size(); x++)
		{
			doc = l.get(x).getReference();
			data = doc.get().get().getData();
			est = col2.document((String) data.get("matricula"));
			data.put("grado", est.get().get().get("grado"));
			doc.update(data).get();
		}
	}

	public void registraNuevoIngreso() throws Exception
	{
		CollectionReference colE = f.collection(Estaticos.fEstudiantes);
		CollectionReference colU = f.collection(Estaticos.fUsuarios);
		DocumentReference doc;
		BufferedReader arch = new BufferedReader(
				new FileReader("c:\\aurelio\\nuevoIngreso.txt"));
		Estudiante est = new Estudiante();
		est.setPeriodoIngreso("20251");
		est.setPeriodosRevalidados(0);
		String linea;
		String[] datos;
		Usuario u = new Usuario();

		while (arch.ready())
		{
			linea = arch.readLine() + "\t.\t.\t.\t.";
			datos = linea.split("\t");
			est.setControl(datos[0].trim());
			est.setPaterno(datos[1].trim());
			est.setMaterno(datos[2].trim());
			est.setNombre(datos[3].trim());
			est.setClavePlanEstudios(datos[4].trim());
			est.setCURP(datos[5].trim());
			est.setSeguro(datos[6].trim());
			est.setCorreo(datos[7].trim());
			est.setCelular(datos[8].trim());
			est.setCorreoInstitucional(
					"L" + est.getControl() + "@zacatepec.tecnm.mx");
			est.setNivel("L");
			doc = colE.document(est.getControl());
			doc.set(est.toMap()).get();

			u.setNombre(est.getControl());
			u.setApellidosNombre(est.getApellidosNombre());
			u.setNivel("L");
			u.setPassword(Md5.encripta(est.getCURP()));
			u.getPermisos().add("Estudiante");
			generaUsuarioFirebase(u, est.getCorreoInstitucional(), est.getCURP());
			doc = colU.document(est.getControl());
			doc.set(u.toMap()).get();
			System.out.println(est.getControl());
		}
		arch.close();
	}

	private void generaUsuarioFirebase(Usuario u, String correo, String password)
	{
		try
		{
			CreateRequest request = new CreateRequest().setEmail(correo)
					.setEmailVerified(true).setPassword(password)
					.setDisplayName(u.getApellidosNombre()).setDisabled(false);
			FirebaseAuth aut = FirebaseAuth.getInstance();
			String uid = aut.createUser(request).getUid();
			u.setUid(uid);
			// Map<String, Object> claims = new HashMap<>();
			// ArrayList<String> permisos = u.getPermisos();
			// for (int x = 0; x < permisos.size(); x++)
			// claims.put(permisos.get(x), true);
			// aut.setCustomUserClaims(uid, claims);
		} catch (Exception error)
		{
			System.err.println("generaUsuarioFirebase\n" + error);

		}
	}

	public void corrigeHistoriaQuebec2() throws Exception
	{
		Principal p = new Principal();
		p.conectar(new RegistroFirebase().quebec(), "colegioquebec");

		CollectionReference col2 = p.f.collection("estudiantes");
		List<QueryDocumentSnapshot> l = col2.whereEqualTo("ciclo", "2024-2025")
				.whereEqualTo("grupo", "").get().get().getDocuments();
		DocumentReference doc;
		for (int x = 0; x < l.size(); x++)
		{
			doc = l.get(x).getReference();
			doc.update("grupo", "A").get();
			System.out.println(x);
		}
	}

	public void conectar(RegistroFirebase r, String idProyecto)
	{
		try
		{
			Gson g = new Gson();
			String permisos = g.toJson(r);
			ByteArrayInputStream b = new ByteArrayInputStream(permisos.getBytes());
			CredentialsProvider credentialsProvider = FixedCredentialsProvider
					.create(ServiceAccountCredentials.fromStream(b));
			FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance()
					.toBuilder().setProjectId(idProyecto)
					.setCredentialsProvider(credentialsProvider).build();
			f = firestoreOptions.getService();

			b = new ByteArrayInputStream(permisos.getBytes());
			GoogleCredentials gc = GoogleCredentials.fromStream(b);
			storage = StorageOptions.newBuilder().setCredentials(gc)
					.setProjectId(idProyecto).build().getService();

			if (!idProyecto.equals("colegioquebec"))
			{
				FirebaseOptions fo = FirebaseOptions.builder().setCredentials(gc)
						.setProjectId(idProyecto).build();
				FirebaseApp fa = FirebaseApp.initializeApp(fo);
				auth = FirebaseAuth.getInstance(fa);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void choques(String periodo)
	{
		try
		{
			CollectionReference colH = f.collection(Estaticos.fHorarios);
			Map<String, Object> data, data2;
			List<QueryDocumentSnapshot> l = colH.whereEqualTo("periodo", periodo)
					.get().get().getDocuments();
			String h[][] = new String[20][20];
			Iterator<String> it;
			String key;
			int dia, hora;
			ArrayList<Long> dias, horas;
			boolean salir;
			String ww;
			for (int x = 0; x < l.size(); x++)
			{
				for (int i = 0; i < 20; i++)
					for (int j = 0; j < 20; j++)
						h[i][j] = null;
				data = l.get(x).getData();
				it = data.keySet().iterator();
				salir = false;
				while (it.hasNext() && !salir)
				{
					key = it.next();
					if (key.charAt(0) == '#')
					{
						data2 = (Map<String, Object>) data.get(key);
						dias = (ArrayList<Long>) data2.get("claseDia");
						horas = (ArrayList<Long>) data2.get("claseHora");
						for (int d = 0; d < dias.size(); d++)
						{
							dia = dias.get(d).intValue();
							hora = horas.get(d).intValue();
							ww = data2.get("abreviado").toString() + " " + data2.get("grupo");
							if (h[dia][hora] != null)
							{
								System.out.println(data.get("clavePlan") + ","
										+ data.get("control") + "," + h[dia][hora] + " vs " + ww);
								salir = true;
								break;
							}
							else
								h[dia][hora] = ww;
						}
					}
				}
			}
		} catch (Exception error)
		{
			for (int x = 0; x < error.getStackTrace().length; x++)
				System.err.println(error.getStackTrace()[x]);
		}
	}

	@SuppressWarnings("unchecked")
	public void inconsistencias(String periodo) throws Exception
	{
		CollectionReference col, colH = f.collection("itz/tecnamex/horarios");
		col = f.collection("itz/tecnamex/grupos");
		Iterator<QueryDocumentSnapshot> i = col.whereEqualTo("periodo", periodo)
				.get().get().iterator();
		DocumentReference doc;
		String ctrl, idGrupo, k;
		boolean existe;
		Map<String, Object> hr, mat;
		Iterator<String> ii;
		List<QueryDocumentSnapshot> l;
		while (i.hasNext())
		{
			doc = i.next().getReference();
			idGrupo = doc.getId();
			l = doc.collection("estudiantes").get().get().getDocuments();

			for (int x = 0; x < l.size(); x++)
			{
				existe = false;
				ctrl = l.get(x).getData().get("control").toString();
				doc = colH.document(periodo + "-" + ctrl);
				if (doc.get().get().exists())
				{
					hr = doc.get().get().getData();
					ii = hr.keySet().iterator();
					while (ii.hasNext())
					{
						k = ii.next();
						if (k.charAt(0) == '#')
						{
							mat = (Map<String, Object>) hr.get(k);
							if (mat.get("idGrupo").equals(idGrupo))
							{
								existe = true;
								continue;
							}
						}
					}
				}
				if (!existe)
					System.out.println(ctrl + " " + idGrupo);
			}
		}
	}

	public void bitacora() throws Exception
	{

		CollectionReference col = f.collection("itz/tecnamex/bitacora");
		Iterator<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", "20251")
				.whereEqualTo("movimiento", "grupo agregado de horario").get().get()
				.iterator();
		Map<String, Object> data;
		DocumentReference doc;
		while (l.hasNext())
		{
			doc = l.next().getReference();
			data = doc.get().get().getData();
			// doc.delete().get();
			System.out.println(data);
		}
	}

	public void tutorias() throws Exception
	{

		CollectionReference col = f.collection("itz/tecnamex/grupos");
		Iterator<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", "20243")
				.whereEqualTo("claveMateriaBase", "TUTOR01").get().get().iterator();
		DocumentReference doc;
		Map<String, Object> data;
		// String f;
		while (l.hasNext())
		{
			doc = l.next().getReference();
			data = doc.get().get().getData();
			{
				data.put("calificar", true);
				doc.update(data).get();
				System.out.println(data);
			}
		}

	}

	public void cerrarAbonoBanco() throws Exception
	{

		CollectionReference col = f.collection("itz/tecnamex/abonoBanco");
		Iterator<QueryDocumentSnapshot> l = col.whereEqualTo("queSePago", "").get()
				.get().iterator();
		DocumentReference doc;
		Map<String, Object> data;
		// String f;
		while (l.hasNext())
		{
			doc = l.next().getReference();
			data = doc.get().get().getData();
			// f = data.get("fecha").toString();
			// if (f.compareTo("2024/06/01") < 0)
			{
				data.put("queSePago", "---");
				data.put("validado", true);
				doc.update(data).get();
				System.out.println(data);
			}
		}

	}

	public void especiales() throws Exception
	{
		String periodo = "20251";

		CollectionReference col = f.collection("itz/tecnamex/planes");
		DocumentReference doc = col.document("ISIC-2010-224");
		PlanEstudios plan = new PlanEstudios(doc.get().get().getData());
		Kardex k = new Kardex();

		Estudiante e;
		Map<String, Object> data;
		Iterator<QueryDocumentSnapshot> i = f.collection("itz/tecnamex/estudiantes")
				.whereGreaterThan("periodoIngreso", "20201").get().get().getDocuments()
				.iterator();
		while (i.hasNext())
		{
			data = i.next().getData();

			e = new Estudiante();
			e.fromMap(data);
			k.inicializa(e, plan, periodo);
			if (k.getTotalEspeciales() == 2)
			{
				System.out.println(e.getControl() + " " + k.getTotalEspeciales());

			}

		}

	}

	public void movil() throws Exception
	{
		String periodo = "20251";
		String claveMat = "DAB-2302";

		CollectionReference col = f.collection("itz/tecnamex/planes");
		PlanEstudios plan;
		plan = new PlanEstudios(
				col.document("ISIC-2010-224").get().get().getData());
		System.out.println(plan);
		col = f.collection("itz/tecnamex/estudiantes");
		Iterator<QueryDocumentSnapshot> i = col
				.whereEqualTo("clavePlanEstudios", "ISIC-2010-224").get().get()
				.iterator();
		Kardex k = new Kardex();

		// DWB1505 DWB-2103
		// DAB-2305
		Estudiante e;
		Map<String, Object> data;
		RegistroKardex r;
		Materia mat = plan.getMateria(claveMat);
		System.out.println(mat);
		while (i.hasNext())
		{
			data = i.next().getData();

			e = new Estudiante();
			e.fromMap(data);

			// if (!e.esHombre())
			{
				k.inicializa(e, plan, periodo);

				r = k.getRegistro(claveMat);
				if (r == null)
					r = new RegistroKardex(mat);
				if (k.puedeCursar(r))
				{
					System.out.println(e.getControl());
					continue;
				}

			}
		}

	}

	public void permisos() throws Exception
	{
		UserRecord u = auth.getUserByEmail("evm670113pva@tecnamex.com");
		Map<String, Object> p = u.getCustomClaims();
		System.out.println(p);
		System.out.println(u.getEmail());
		// h.put("usuario", "Docente");
		// auth.setCustomUserClaims(u.getUid(), h);
	}

	public void palabras() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/empleados");
		List<QueryDocumentSnapshot> l = col.get().get().getDocuments();
		DocumentReference doc;
		ArrayList<String> p = new ArrayList<String>();
		Map<String, Object> data;
		for (int i = 0; i < l.size(); i++)
		{
			doc = l.get(i).getReference();
			data = doc.get().get().getData();
			System.out.println(data.get("apellidosNombre"));
			p.clear();

			String[] n = ((String) data.get("apellidosNombre")).trim().split(" ");
			String s;
			for (int x = 0; x < n.length; x++)
				if (!n[x].equals("DE") && !n[x].equals("LA") && !n[x].equals("LOS")
						&& !n[x].equals("DEL"))
				{

					p.add(n[x]);
					s = n[x].replace("Á", "A").replace("É", "E").replace("Í", "I")
							.replace("Ó", "O").replace("Ú", "U");
					if (!s.equals(n[x]))
						p.add(s);
				}
			String nn = (String) data.get("nombre");
			if (nn.contains(" "))
			{
				p.add(nn);
				s = nn.replace("Á", "A").replace("É", "E").replace("Í", "I")
						.replace("Ó", "O").replace("Ú", "U");
				if (!s.equals(nn))
					p.add(s);
			}
			doc.update("palabras", p).get();
		}

	}

	public void corrigeUsuariosQuebec() throws Exception
	{
		Principal p = new Principal();
		p.conectar(new RegistroFirebase().quebec(), "colegioquebec");

		CollectionReference colu = p.f.collection("usuarios");
		CollectionReference col = p.f.collection("estudiantes");
		List<QueryDocumentSnapshot> l = col.whereEqualTo("ciclo", "2024-2025").get()
				.get().getDocuments();
		Map<String, Object> data;
		DocumentReference doc;
		String paterno;
		for (int x = 0; x < l.size(); x++)
			try
			{
				data = l.get(x).getData();
				if (data.get("matricula").toString().substring(0, 4).equals("2425"))
				{
					paterno = data.get("primerApellido").toString();
					doc = colu.document(data.get("matricula").toString());
					data = doc.get().get().getData();
					data.put("password", Md5.encriptaQuebec(paterno));
					doc.set(data).get();
					System.out.println(paterno + " " + data.get("nombre"));
				}

			} catch (Exception error)
			{
			}
	}

	public void semanaAcademica() throws Exception
	{
		try
		{
			CollectionReference col = f
					.collection("eventos/jornadas2024/conferencias");
			Iterator<QueryDocumentSnapshot> i = col.get().get().iterator();
			Map<String, Object> data;
			String cc;
			TreeMap<String, String> conf = new TreeMap<String, String>();
			while (i.hasNext())
			{
				data = i.next().getData();
				conf.put(data.get("id").toString(),
						data.get("departamento").toString());
			}
			CollectionReference colE = f
					.collection("eventos/jornadas2024/reportesAsistencia");
			i = colE.get().get().iterator();

			while (i.hasNext())
			{
				data = i.next().getData();
				cc = conf.get(data.get("idConferencia"));
				if (cc != null)
					cc = data.get("departamento").toString();
				System.out.println(data);
				System.out.println(data.get("plan") + "\t" + data.get("control") + "\t"
						+ data.get("nombre") + "\t" + data.get("dia") + "\t"
						+ data.get("conferencia") + "\t" + cc);
			}
		} catch (Exception error)
		{
			System.err.println(error);
		}
	}

	public void nivelUsuarios() throws Exception
	{
		CollectionReference colE = f.collection("itz/tecnamex/estudiantes");
		CollectionReference col = f.collection("itz/tecnamex/usuarios");
		Iterator<QueryDocumentSnapshot> i = col.get().get().iterator();
		DocumentReference doc;
		Map<String, Object> data;
		String nivel, nombre;
		while (i.hasNext())
		{
			doc = i.next().getReference();
			data = doc.get().get().getData();
			nombre = data.get("nombre").toString();
			nivel = "";
			if (nombre.length() < 13)
				try
				{
					data = colE.document(nombre).get().get().getData();
					nivel = (String) data.get("nivel");
					if (nivel == null)
						nivel = "";
				} catch (Exception error)
				{
				}
			else
				nivel = "--";
			doc.update("nivel", nivel).get();
		}
	}

	public void eliminaPeriodosInscrito() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/estudiantes");
		Iterator<DocumentReference> i = col.listDocuments().iterator();
		Map<String, Object> data;
		DocumentReference doc;
		while (i.hasNext())
		{
			doc = i.next();
			data = doc.get().get().getData();
			if (data.get("periodosInscrito") != null)
			{
				data.remove("periodosInscrito");
				doc.set(data).get();
				System.out.println(data.get("control"));
			}
		}
	}

	public void generaListasEstudiantes() throws Exception
	{
		CollectionReference ests, col = f.collection("itz/tecnamex/grupos");
		DocumentReference doc, ee;
		Map<String, Object> data;
		QueryDocumentSnapshot q;
		Iterator<String> e;
		String k;
		Iterator<QueryDocumentSnapshot> i = col.get().get().iterator();
		while (i.hasNext())
		{
			q = i.next();
			doc = q.getReference();
			ests = doc.collection("estudiantes");
			data = q.getData();
			System.out.println(data.get("id"));
			e = data.keySet().iterator();
			while (e.hasNext())
			{
				k = e.next();
				if (k.charAt(0) == '#')
				{
					ee = ests.document(k.substring(1));
					ee.set(data.get(k)).get();
				}
			}
		}
	}

	public void eliminaPermisosEstudiante() throws Exception
	{
		Random r = new Random();
		CollectionReference col = f.collection("itz/tecnamex/usuarios");
		List<QueryDocumentSnapshot> l = col.get().get().getDocuments();
		Map<String, Object> data;
		DocumentReference doc;
		StringBuffer cad;
		String codigo;
		for (int x = 1; x < l.size(); x++)
		{
			data = l.get(x).getData();
			codigo = (String) data.get("codigoDatosCredencial");
			if (codigo == null)
			{
				cad = new StringBuffer();
				for (int w = 0; w < 20; w++)
					if (r.nextInt(2) == 0)
						cad.append(((char) (r.nextInt(26) + 97)));
					else
						cad.append((((char) (r.nextInt(26) + 97)) + "").toUpperCase());
				System.out.println(data.get("nombre") + cad.toString());
				doc = l.get(x).getReference();
				doc.update("codigoDatosCredencial", data.get("nombre") + cad.toString())
						.get();
			}
		}
	}

	public void validarHorario() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/horarios");
		List<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", "20243")
				.whereEqualTo("semestre", 1).whereEqualTo("validado", false).get().get()
				.getDocuments();
		DocumentReference doc;
		for (int x = 0; x < l.size(); x++)
		{
			doc = l.get(x).getReference();
			doc.update("validado", true);
		}
	}

	public void tutorias(String periodo) throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/grupos");
		List<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", periodo)
				.whereEqualTo("claveMateriaBase", "TUTOR01").get().get().getDocuments();
		DocumentReference doc;
		for (int x = 0; x < l.size(); x++)
		{
			doc = l.get(x).getReference();
			doc.update("asesoria", true);
		}
	}

	public void desarrolloAspirantes() throws Exception
	{
		Principal otro = new Principal();
		otro.conectar(new RegistroFirebase().aspirantesitz(), "aspirantesitz");
		CollectionReference col = f.collection("itz/tecnamex/planes");
		CollectionReference colA = otro.f.collection("carreras");
		Iterator<QueryDocumentSnapshot> i = col.whereEqualTo("situacion", 1).get()
				.get().iterator();
		while (i.hasNext())
		{
			QueryDocumentSnapshot q = i.next();
			String id = q.getId();
			Map<String, Object> data = q.getData();
			Map<String, Object> car = new HashMap<String, Object>();
			car.put("clave", data.get("clave"));
			car.put("nombre", data.get("nombre"));
			car.put("fichas", true);
			DocumentReference doc = colA.document(id);
			doc.set(car).get();
		}
	}

	public void horarios() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/horarios");
		List<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", "20243").get()
				.get().getDocuments();
		Map<String, Object> data;
		int cont = 0;
		for (int x = 0; x < l.size(); x++)
		{
			data = l.get(x).getData();
			if (data.get("control").toString().compareTo("24090196") > 0)
				cont++;
		}

		System.out.println(cont);
	}

	@SuppressWarnings("unchecked")
	public void asistencia(String periodo) throws Exception
	{
		CollectionReference colG = f.collection("itz/tecnamex/grupos");
		CollectionReference colE = f.collection("itz/tecnamex/asistencia_aula");
		DocumentReference doc;
		List<QueryDocumentSnapshot> l = colE.whereGreaterThan("fecha", "2024-05-30")
				.get().get().getDocuments();
		Map<String, Object> d, gpo, mats, mat;
		String status = "";
		System.out.println(l.size());
		for (int x = 0; x < l.size(); x++)
		{
			d = l.get(x).getData();
			doc = colG.document(d.get("idGrupo").toString());
			gpo = doc.get().get().getData();
			if (gpo.get("periodo").toString().equals(periodo))
			{
				switch (d.get("status").toString())
				{
					case "0":
						status = "todos";
						break;
					case "1":
						status = "alumnos";
						break;
					case "2":
						status = "docente";
						break;
					case "3":
						status = "nadie";
						break;
					default:
						status = "----";

				}
				if (!status.equals("todos"))
				{
					mats = (Map<String, Object>) gpo.get("materias");
					mat = (Map<String, Object>) mats.values().iterator().next();
					System.out.println(status + "~" + d.get("aula") + "~" + d.get("dia")
							+ "~" + d.get("hora") + "~" + d.get("fecha") + "~"
							+ d.get("docente") + "~" + mat.get("abreviado") + "~"
							+ gpo.get("grupo"));
				}
			}
		}
	}

	public void buscarExalumnos() throws Exception
	{
		BufferedReader arch = new BufferedReader(
				new FileReader("c:\\aurelio\\exalumnos.txt"));
		TreeMap<String, String> ctrls = new TreeMap<String, String>();
		String[] s;
		String n, m, p;
		while (arch.ready())
		{
			p = arch.readLine();
			s = p.split(",");
			m = s[0] + s[1] + s[2];
			ctrls.put(m, p);
		}
		arch.close();
		CollectionReference col = f.collection("itz/tecnamex/estudiantes");
		Iterator<QueryDocumentSnapshot> i = col.get().get().iterator();
		Map<String, Object> data;
		while (i.hasNext())
		{
			data = i.next().getData();
			p = (String) data.get("paterno");
			m = (String) data.get("materno");
			n = (String) data.get("nombre");
			if (ctrls.containsKey(p + m + n))
			{
				System.out.println(data.get("control"));
			}
		}
	}

	public void rostros() throws Exception
	{
		CollectionReference colu = f.collection("itz/tecnamex/usuarios");
		CollectionReference col = f.collection("itz/tecnamex/rostros");
		Iterator<QueryDocumentSnapshot> i = col.get().get().iterator();
		DocumentReference doc;
		Map<String, Object> data, data2;
		while (i.hasNext())
		{
			doc = i.next().getReference();
			data = doc.get().get().getData();
			doc = colu.document(data.get("nombre").toString());
			if (doc.get().get().exists())
			{
				data2 = doc.get().get().getData();
				data2.put("embeddings", data.get("embeddings"));
				doc.update(data2).get();
				System.out.println(data.get("nombre"));
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void calificacionesServicioSocial() throws Exception
	{
		CollectionReference colE = f.collection("itz/tecnamex/estudiantes");
		CollectionReference col = f.collection("itz/tecnamex/grupos");
		Iterator<QueryDocumentSnapshot> l = col
				.whereEqualTo("claveMateriaBase", "SERVSOC").get().get().iterator();
		DocumentReference doc;
		Map<String, Object> data, est, reg;
		String k;
		String control, s;
		String w[];
		String cal;
		ArrayList<String> evals;
		Iterator<String> i;
		int x;
		boolean modificado;
		while (l.hasNext())
		{
			modificado = false;
			doc = l.next().getReference();
			data = doc.get().get().getData();
			i = data.keySet().iterator();
			while (i.hasNext())
			{
				k = i.next();
				if (k.charAt(0) == '#')
				{
					reg = (Map<String, Object>) data.get(k);
					cal = reg.get("calificacion").toString();
					if (!cal.isEmpty())
					{
						control = reg.get("control").toString();
						est = colE.document(control).get().get().getData();
						evals = (ArrayList<String>) est.get("evaluaciones");
						for (x = 0; x < evals.size(); x++)
						{
							s = evals.get(x);
							if (s.contains("SERVSOC"))
							{
								w = s.split("\\~");
								reg.put("calificacion", w[3]);
								modificado = true;
								System.out.println(control);
							}
						}
					}
				}
			}
			if (modificado)
				doc.update(data).get();
		}

	}

	@SuppressWarnings("unchecked")
	public void reporteIndustrial() throws Exception
	{
		BufferedWriter arch = new BufferedWriter(
				new FileWriter("c:\\aurelio\\docentesEneroAgosto2024.csv"));
		CollectionReference colD = f.collection("itz/tecnamex/datosEmpleado");
		CollectionReference col = f.collection("itz/tecnamex/empleados");
		List<QueryDocumentSnapshot> ll = col.whereEqualTo("tipo", "docente").get()
				.get().getDocuments();
		TreeMap<String, Map<String, Object>> t = new TreeMap<String, Map<String, Object>>();
		Map<String, Object> grupo, data, d, datos, plaza, materias, mat;
		ArrayList<Map<String, Object>> plazas;
		String k, docente;
		for (int x = 0; x < ll.size(); x++)
		{
			data = ll.get(x).getData();
			t.put(data.get("apellidosNombre").toString(), data);
		}
		col = f.collection("itz/tecnamex/grupos");
		Iterator<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", "20241")
				.whereEqualTo("clavePlanBase", "IIND-2010-227").get().get().iterator();
		// DocumentReference doc;
		Iterator<String> ii;
		while (l.hasNext())
		{
			grupo = l.next().getData();
			materias = (Map<String, Object>) grupo.get("materias");
			docente = (String) grupo.get("docente");
			d = t.get(docente);
			if (d != null)
			{
				datos = colD.document(d.get("rfc").toString()).get().get().getData();
				plazas = (ArrayList<Map<String, Object>>) datos.get("plazas");
				for (int w = 0; w < plazas.size(); w++)
				{
					plaza = (Map<String, Object>) plazas.get(w);
					ii = materias.keySet().iterator();
					while (ii.hasNext())
					{
						k = ii.next();
						mat = (Map<String, Object>) materias.get(k);
						arch.write(
								grupo.get("docente") + "," + plaza.get("clavePresupuestal")
										+ "," + plaza.get("nombramiento") + "," + plaza.get("horas")
										+ "," + mat.get("nombre") + "," + inscritos(grupo) + ","
										+ grupo.get("grupo") + "\n");
					}

				}
			}
		}
		arch.close();
	}

	int inscritos(Map<String, Object> gpo)
	{
		Iterator<String> i = gpo.keySet().iterator();
		String k;
		int c = 0;
		while (i.hasNext())
		{
			k = i.next();
			if (k.charAt(0) == '#')
				c++;
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public void bloqueos() throws Exception
	{

		CollectionReference col = f.collection("itz/tecnamex/estudiantes");
		Iterator<QueryDocumentSnapshot> l = col.get().get().iterator();
		DocumentReference doc;
		Map<String, Object> data, d;
		while (l.hasNext())
		{
			doc = l.next().getReference();
			data = doc.get().get().getData();
			d = (Map<String, Object>) data.get("bloqueos");
			if (d != null)
			{
				System.out.println(data);
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void corrigeRegistroHorario() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/horarios");
		DocumentReference doc = col.document("20233-18090569");
		Map<String, Object> data = doc.get().get().getData();
		Map<String, Object> d = (Map<String, Object>) data.get("#ESF-1804");
		d.put("claveMateria", "DIF-2104");
		doc.update("#DIF-2104", d).get();

	}

	public void nuevoIngresoFolders() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/planes");
		List<QueryDocumentSnapshot> l = col.get().get().getDocuments();
		Map<String, Object> data, plan;
		TreeMap<String, Map<String, Object>> planes = new TreeMap<String, Map<String, Object>>();
		for (int x = 0; x < l.size(); x++)
		{
			plan = l.get(x).getData();
			planes.put(plan.get("clave").toString(), plan);
		}

		col = f.collection("itz/tecnamex/estudiantes");
		l = col.whereEqualTo("periodoIngreso", "20241").get().get().getDocuments();
		BufferedWriter arch = new BufferedWriter(
				new FileWriter("c:\\aurelio\\nuevos2024.csv"));
		// codigo,estudiante,carrera
		// TECNM/09T/SE/04S.07/23091008/2023,OLIVARES SOTELO
		// SERGIO/ISIC/A-D-2023,INGENIERÍA EN SISTEMAS COMPUTACIONALES ISIC-2010-224
		String sigla;
		for (int x = 0; x < l.size(); x++)
		{
			data = l.get(x).getData();
			plan = planes.get(data.get("clavePlanEstudios"));
			sigla = plan.get("clave").toString().split("-")[0];
			arch.write("TECNM/09T/SE/04S.07/" + data.get("control") + "/2024" + ","
					+ data.get("apellidosNombre") + "/" + sigla + "/E-J-2024,"
					+ plan.get("nombre") + "  " + plan.get("clave") + "\n");
		}
		arch.close();
	}

	public void residencia() throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/residencias");
		DocumentReference doc = col.document("20231_18090288");
		Map<String, Object> data = doc.get().get().getData();
		System.out.println(data);
		data.put("id", "20233_18090288");
		data.put("periodo", "20233");
		doc = col.document("20233_18090288");
		data.put("folio", doc.get().get().getData().get("folio"));
		doc.set(data).get();
	}

	public void firmas() throws Exception
	{

		BaseDatos b = new BaseDatos();
		b.conectarTecnamex();
		byte[] f;
		FileOutputStream arch;
		for (int x = 21090001; x <= 21091600; x++)
			try
			{
				f = b.leeArchivo("firmas/" + x + ".jpg");
				if (f != null && f.length > 0)
				{
					Thread.sleep(300);
					System.out.println(x);
					arch = new FileOutputStream("c:\\aurelio\\firmas\\" + x + ".jpg");
					arch.write(f);
					arch.close();
				}
			} catch (Exception e)
			{
			}
	}

	@SuppressWarnings("unchecked")
	public void especialReprobado(String periodo)
	{

		CollectionReference col = f.collection("itz/tecnamex/grupos");
		try
		{
			List<QueryDocumentSnapshot> l = col.whereEqualTo("periodo", periodo).get()
					.get().getDocuments();
			col = f.collection("itz/tecnamex/horarios");
			DocumentReference doc;
			Map<String, Object> d1, d2, d3;
			Iterator<String> i;
			String k, curso, calif;
			for (int x = 0; x < l.size(); x++)
			{
				d1 = l.get(x).getData();
				i = d1.keySet().iterator();
				while (i.hasNext())
				{
					k = i.next();
					if (k.charAt(0) == '#')
					{
						d2 = (Map<String, Object>) d1.get(k);
						curso = (String) d2.get("curso");
						if (curso.equals("E"))
						{
							calif = (String) d2.get("calificacion");
							if (calif.equals("NA") || calif.equals("NP"))
							{
								doc = col.document("20241-" + k.replace("#", ""));
								d3 = doc.get().get().getData();
								if (!d3.isEmpty())
									System.out.println(d1.get("id") + " " + k
											+ " Inscrito con especial reprobado");
							}
						}
					}
				}
			}
		} catch (Exception error)
		{
			error.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void horasLibreGrupo(String periodo, String idGrupo) throws Exception
	{
		CollectionReference col = f.collection(Estaticos.fGrupos);
		DocumentReference doc = col.document(idGrupo);
		Map<String, Object> data, horario, grupo = doc.get().get().getData();
		col = f.collection(Estaticos.fHorarios);
		Iterator<String> ii, i = grupo.keySet().iterator();
		String ctrl;
		int h[][] = new int[6][20];
		for (int x = 0; x < 6; x++)
			for (int j = 0; j < 20; j++)
				h[x][j] = 0;
		ArrayList<Long> horas, dias;
		String mat;
		while (i.hasNext())
		{
			ctrl = i.next();
			if (ctrl.charAt(0) == '#')
			{
				ctrl = ctrl.replace("#", "");
				doc = col.document(periodo + "-" + ctrl);
				horario = doc.get().get().getData();
				ii = horario.keySet().iterator();
				while (ii.hasNext())
				{
					mat = ii.next();
					if (mat.charAt(0) == '#')
					{
						data = (Map<String, Object>) horario.get(mat);
						horas = (ArrayList<Long>) data.get("claseHora");
						dias = (ArrayList<Long>) data.get("claseDia");
						for (int x = 0; x < dias.size(); x++)
							h[dias.get(x).intValue()][horas.get(x).intValue()]++;
					}
				}
			}
		}
		for (int j = 0; j < 20; j++)
		{
			System.out.print(j + "-> ");
			for (int x = 0; x < 6; x++)
				System.out.print(h[x][j] + " ");
			System.out.println();
		}
	}

	public void bitacora(String control) throws Exception
	{
		CollectionReference col = f.collection("itz/tecnamex/bitacora");
		Iterator<QueryDocumentSnapshot> i = col
				.whereEqualTo("usuarioAfectado", control).get().get().getDocuments()
				.iterator();
		QueryDocumentSnapshot q;
		while (i.hasNext())
		{
			q = i.next();
			System.out.println(q.getData());
		}
	}

	@SuppressWarnings("unchecked")
	public void inconsistenciasHorarioVsGrupos(String periodo)
	{
		try
		{

			CollectionReference col = f.collection(Estaticos.fGrupos);
			CollectionReference colH = f.collection(Estaticos.fHorarios);
			Map<String, Object> data, data2, grupo;

			List<QueryDocumentSnapshot> l = colH.whereEqualTo("periodo", periodo)
					.get().get().getDocuments();
			TreeMap<String, Map<String, Object>> horarios = new TreeMap<String, Map<String, Object>>();
			for (int x = 0; x < l.size(); x++)
			{
				data = l.get(x).getData();
				horarios.put("#" + data.get("control"), data);
			}

			Iterator<QueryDocumentSnapshot> i = col.whereEqualTo("periodo", periodo)
					.get().get().iterator();
			Iterator<String> ii, iii;
			String ctrl, idGrupo, c;
			Map<String, Object> horario;
			boolean existe;
			// TreeMap<String, String> res = new TreeMap<String, String>();
			while (i.hasNext())
			{
				grupo = i.next().getData();
				idGrupo = (String) grupo.get("id");
				ii = grupo.keySet().iterator();
				while (ii.hasNext())
				{
					ctrl = ii.next();
					if (ctrl.charAt(0) == '#')
					{

						existe = false;
						horario = (Map<String, Object>) horarios.get(ctrl);
						if (horario != null)
						{
							iii = horario.keySet().iterator();
							while (!existe && iii.hasNext())
							{
								c = iii.next();
								if (c.charAt(0) == '#')
								{
									data2 = (Map<String, Object>) horario.get(c);
									if (data2.get("idGrupo").equals(idGrupo))
										existe = true;
								}
							}
						}
						if (!existe)
						{
							System.err.println(idGrupo + " " + ctrl);
							DocumentReference doc = col.document(idGrupo);
							Map<String, Object> gg = doc.get().get().getData();
							gg.remove(ctrl);
							// doc.update(gg).get();
						}
					}
				}

			}
		} catch (Exception error)
		{
			for (int x = 0; x < error.getStackTrace().length; x++)
				System.err.println(error.getStackTrace()[x]);
		}

	}

}
