package gal.san.clemente.tarefa6_acceso_datos.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mensaxe {
    private String text;
    private Usuario usuario;
    private LocalDateTime date;
    private List<String> hashtags = new ArrayList<>();

    public Mensaxe() {
    }

    public Mensaxe(String text, Usuario usuario) {
        this.text = text;
        this.usuario = usuario;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }
    
    public void addHashtag(String hashtag) {
        this.getHashtags().add(hashtag);
    }
    
    public void removeHashtag(String hashtag) {
        this.getHashtags().remove(hashtag);
    }
    
     @Override
    public int hashCode() {
        return Objects.hash(this.date);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Mensaxe other = (Mensaxe) obj;
        return (!Objects.equals(this.date, other.date));
    }

    @Override
    public String toString() {
        return "Mensaxe{" + "text=" + text + ", usuario=" + usuario + ", date=" + date + ", hashtags=" + hashtags + '}';
    }
    
}
