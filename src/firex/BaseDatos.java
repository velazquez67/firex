package firex;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Blob.BlobSourceOption;
import com.google.gson.Gson;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class BaseDatos
{
	Firestore f;
	Storage storageTecnamex;
	Storage storageTecZacatepec;
	FirebaseAuth aut;
	DatabaseReference real;

	public BaseDatos()
	{
		conectarTecZacatepec();
		conectarTecnamex();
	}

	public void conectarTecZacatepec()
	{
		try
		{
			Gson g = new Gson();
			String permisos = g.toJson(new RegistroFirebase().tecZacatepec());
			ByteArrayInputStream b = new ByteArrayInputStream(permisos.getBytes());
			CredentialsProvider credentialsProvider = FixedCredentialsProvider
					.create(ServiceAccountCredentials.fromStream(b));
			FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance()
					.toBuilder().setProjectId("teczacatepec")
					.setCredentialsProvider(credentialsProvider).build();
			f = firestoreOptions.getService();

			b = new ByteArrayInputStream(permisos.getBytes());
			GoogleCredentials googleC = GoogleCredentials.fromStream(b);
			FirebaseOptions fo = FirebaseOptions.builder().setCredentials(googleC)
					.setProjectId("teczacatepec").build();
			FirebaseApp fa = FirebaseApp.initializeApp(fo);
			aut = FirebaseAuth.getInstance(fa);
			storageTecZacatepec = StorageOptions.newBuilder().setCredentials(googleC)
					.setProjectId("teczacatepec").build().getService();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void conectarTecnamex()
	{
		{
			try
			{
				Gson g = new Gson();
				String permisos = g.toJson(new RegistroFirebase().tecnamex());
				ByteArrayInputStream b = new ByteArrayInputStream(permisos.getBytes());
				GoogleCredentials googleC = GoogleCredentials.fromStream(b);
				storageTecnamex = StorageOptions.newBuilder().setCredentials(googleC)
						.setProjectId("tecnamex").build().getService();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	public void almacenarArchivox(String nombre, byte datos[])
	{
		try
		{
			BlobId blobId = BlobId.of("tecnamex.appspot.com", nombre);
			BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
			storageTecnamex.create(blobInfo, datos);
		} catch (Exception error)
		{
			error.printStackTrace();

		}
	}

	public byte[] leeArchivo(String nombre)
	{
		try
		{
			BlobId blobId = BlobId.of("tecnamex.appspot.com", nombre);
			Blob b = storageTecnamex.get(blobId);
			return b.getContent(BlobSourceOption.generationMatch());
		} catch (Exception error)
		{
		}
		return null;
	}

	public byte[] leeFotoTecnamex(String nombre)
	{
		try
		{
			BlobId blobId = BlobId.of("tecnamex.appspot.com", nombre);
			Blob b = storageTecnamex.get(blobId);
			return b.getContent(BlobSourceOption.generationMatch());
		} catch (Exception error)
		{
			// error.printStackTrace();
		}
		return null;
	}

	public byte[] leeFirma(String nombre)
	{
		return leeFoto(nombre);
	}

	public byte[] leeFoto(String nombre)
	{
		try
		{
			BlobId blobId = BlobId.of("teczacatepec.appspot.com", nombre);
			Blob b = storageTecZacatepec.get(blobId);
			return b.getContent(BlobSourceOption.generationMatch());
		} catch (Exception error)
		{
			error.printStackTrace();
		}
		return null;
	}

	public CollectionReference getColeccion(String coleccionPadre)
	{
		return f.collection(coleccionPadre);
	}

	public DocumentReference getDocumento(String coleccionPadre)
	{
		return f.document(coleccionPadre);
	}

	public void actualiza(String coleccion, String llave,
			Map<String, Object> datos)
	{
		try
		{
			DocumentReference future = f.collection(coleccion).document(llave);
			ApiFuture<WriteResult> f = future.update(datos);
			f.get();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void elimina(String coleccion, String llave)
	{
		try
		{
			DocumentReference future = f.collection(coleccion).document(llave);
			ApiFuture<WriteResult> f = future.delete();
			f.get();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public List<QueryDocumentSnapshot> consulta(String coleccion)
	{
		try
		{
			CollectionReference col = f.collection(coleccion);
			return col.get().get().getDocuments();
		} catch (Exception e)
		{
		}
		return new ArrayList<QueryDocumentSnapshot>();
	}

	public List<QueryDocumentSnapshot> consulta(String coleccion, String field,
			Object valor)
	{
		try
		{
			CollectionReference col = f.collection(coleccion);
			return col.whereEqualTo(field, valor).get().get().getDocuments();
		} catch (Exception e)
		{
		}
		return new ArrayList<QueryDocumentSnapshot>();
	}

	public List<QueryDocumentSnapshot> consulta(String coleccion, String field1,
			Object valor1, String field2, Object valor2)
	{
		try
		{
			CollectionReference col = f.collection(coleccion);
			ApiFuture<QuerySnapshot> future = col.whereEqualTo(field1, valor1)
					.whereEqualTo(field2, valor2).get();
			return future.get().getDocuments();
		} catch (Exception e)
		{
		}
		return new ArrayList<QueryDocumentSnapshot>();
	}

	public Map<String, Object> lee(String coleccion, String llave)
	{
		try
		{
			DocumentReference future = f.collection(coleccion).document(llave);
			ApiFuture<DocumentSnapshot> f = future.get();
			if (f.get().exists())
				return f.get().getData();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> leeUnico(String coleccion, String campo,
			String valor)
	{
		try
		{
			CollectionReference col = f.collection(coleccion);
			ApiFuture<QuerySnapshot> future = col.whereEqualTo(campo, valor).limit(1)
					.get();
			List<QueryDocumentSnapshot> docs = future.get().getDocuments();
			if (!docs.isEmpty())
				return docs.get(0).getData();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void almacena(CollectionReference coleccion, Object datos)
	{
		try
		{
			DocumentReference docRef = coleccion.document();
			ApiFuture<WriteResult> result = docRef.set(datos);
			result.get();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void almacena(String coleccion, Object documento)
	{
		try
		{
			CollectionReference c = f.collection(coleccion);
			ApiFuture<DocumentReference> result = c.add(documento);
			result.get();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void almacena(ObjetoFirebase obj)
	{
		String coleccion = obj.getColeccion();
		String id = obj.getId();
		if (id == null)
			almacena(coleccion, obj.toMap());
		else
			almacena(coleccion, id, obj.toMap());
	}

	public void almacena(String coleccion, String idDocumento, Object documento)
	{
		try
		{
			DocumentReference docRef = f.collection(coleccion).document(idDocumento);
			ApiFuture<WriteResult> result = docRef.set(documento);
			result.get();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void almacena(String coleccion, String id, Map<String, Object> datos)
	{
		try
		{
			DocumentReference docRef = f.collection(coleccion).document(id);
			ApiFuture<WriteResult> result = docRef.set(datos);
			// docRef.update(datos);
			result.get();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
