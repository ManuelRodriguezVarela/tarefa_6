package gal.san.clemente.tarefa6_acceso_datos.model.utils;

public class ConnectionConf {
    
    private String address;
    
    private String port;
    
    private String dbname;
    
    private String username;
    
    private String password;

    public ConnectionConf(String address, String port, String dbname, String username, String password) {
        this.address = address;
        this.port = port;
        this.dbname = dbname;
        this.username = username;
        this.password = password;
    }

    public ConnectionConf() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
