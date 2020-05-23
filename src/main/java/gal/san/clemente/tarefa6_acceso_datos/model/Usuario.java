package gal.san.clemente.tarefa6_acceso_datos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario implements Serializable {
    private String nome;
    private String username;
    private String password;
    private List<String> follows = new ArrayList();

    public Usuario(String nome, String username, String password) {
        this.nome = nome;
        this.username = username;
        this.password = password;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getFollows() {
        return follows;
    }

    public void setFollows(List<String> follows) {
        this.follows = follows;
    }
    
    public void addFollow(String follow) {
        this.getFollows().add(follow);
    }
    
    public void removeFollow(String follow) {
        this.getFollows().remove(follow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username) + Objects.hash(this.password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Usuario other = (Usuario) obj;
        return (!Objects.equals(this.username, other.username)) && (!Objects.equals(this.password, other.password));
    }

    @Override
    public String toString() {
        return "Usuario: " + "Nome: " + nome + ", Nome de usuario: " + username + ", Contrasinal: " + password + ", Seguidores: " + follows;
    }
    
}
