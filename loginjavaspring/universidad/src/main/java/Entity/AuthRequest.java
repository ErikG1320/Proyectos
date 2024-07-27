package Entity;

public class AuthRequest {
    private String user_name;
    private String pass;
    
    // Constructor
    
    public AuthRequest(String user_name, String pass) {
        this.user_name = user_name;
        this.pass = pass;
    }
    //Constructor vacio
    public AuthRequest() {
    }
    public String getUser_name() {
        return user_name;
    }
    
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    public String getPass() {
        return pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
}
