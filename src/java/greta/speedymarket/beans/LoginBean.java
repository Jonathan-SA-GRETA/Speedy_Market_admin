package greta.speedymarket.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="LoginBean")
public class LoginBean {
    private String login = "";
    private String password = "";
    public String getLogin() {
    
    return login;
}
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}