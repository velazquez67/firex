package firex.it;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.IsSerializable;

public class HorarioAlumno implements IsSerializable
{ public ArrayList<Estudiante> a;
  public ArrayList<Evaluacion> e;
  public ArrayList<Grupo> g;
}
