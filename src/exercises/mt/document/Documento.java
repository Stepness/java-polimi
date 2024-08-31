package exercises.mt.document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class Documento{
    public List<Parte> parti = new ArrayList<>();

    public Documento(int numParti){
        for(int i = 0; i < numParti; i++){
            Parte parte = new Parte();
            parti.add(parte);
        }
    }
}
