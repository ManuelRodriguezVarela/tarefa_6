package gal.san.clemente.tarefa6_acceso_datos.model.converter;

import gal.san.clemente.tarefa6_acceso_datos.model.Mensaxe;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MensaxeConverter implements IConverter<Mensaxe, BasicDBObject> {

    @Override
    public Mensaxe BaseDataToEntity(BasicDBObject baseData) throws ProjectException {
        Mensaxe msm = new Mensaxe();
        msm.setText(baseData.getString("text"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.nnnnnn");
        LocalDateTime d = LocalDateTime.parse(baseData.getString("date"), formatter);
        msm.setDate(d);
        //msm.setUsuario(usuario);
        BasicDBList tags = (BasicDBList) baseData.get("hashtags");
        List<String> hashtags = new ArrayList<>();
        tags.forEach((tag) -> { hashtags.add(tag.toString()); });
        msm.setHashtags(hashtags);
        return msm;
    }

    @Override
    public BasicDBObject EntityToBaseData(Mensaxe entity) throws ProjectException {
        LocalDateTime date = entity.getDate();
        if(date == null) 
            date = LocalDateTime.now();

        BasicDBObject dBObjectMensaxe = new BasicDBObject();
        dBObjectMensaxe.append("text", entity.getText());
        dBObjectMensaxe.append("date", date.toString());
        dBObjectMensaxe.append("user", new BasicDBObject())
                .append("nome", entity.getUsuario().getNome())
                .append("username", entity.getUsuario().getUsername());
        dBObjectMensaxe.append("hashtags", entity.getHashtags());
        return dBObjectMensaxe;
    }
    
}
