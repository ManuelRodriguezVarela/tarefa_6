package gal.san.clemente.tarefa6_acceso_datos.model.converter;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import gal.san.clemente.tarefa6_acceso_datos.exception.ProjectException;
import gal.san.clemente.tarefa6_acceso_datos.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioConverter implements IConverter<Usuario, BasicDBObject>  {

    @Override
    public Usuario BaseDataToEntity(BasicDBObject baseData) throws ProjectException {
        Usuario user = new Usuario();
        user.setNome(baseData.getString("nome"));
        user.setUsername(baseData.getString("username"));
        user.setPassword(baseData.getString("password"));
        BasicDBList seguidores = (BasicDBList) baseData.get("follows");
        List<String> follows = new ArrayList<>();
        seguidores.forEach((follow) -> {follows.add(follow.toString());});
        user.setFollows(follows);
        return user;
    }

    @Override
    public BasicDBObject EntityToBaseData(Usuario entity) throws ProjectException {
        BasicDBObject dBObjectUsuario = new BasicDBObject();
        dBObjectUsuario.append("nome", entity.getNome());
        dBObjectUsuario.append("username", entity.getUsername());
        dBObjectUsuario.append("password", entity.getPassword());
        dBObjectUsuario.append("follows", entity.getFollows());
        return dBObjectUsuario;
    }

}
