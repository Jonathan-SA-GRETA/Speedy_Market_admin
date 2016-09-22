package greta.speedymarket.beans;

import java.io.IOException;
import javax.faces.context.FacesContext;

public class RedirectBean {
    public static void redirectTo(String dest) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}