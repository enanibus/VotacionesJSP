package votaciones.controllers.beans;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import upm.miw.solitaire.controllers.ejb.LoginEjb;
import upm.miw.solitaire.models.entities.Gender;
import upm.miw.solitaire.models.entities.User;

public class VotarBean extends Bean {

    private String password;

    private User user;

    public VotarBean() {
    }

    public Gender[] getGenders() {
        return Gender.values();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login(HttpSession sesion) {
        LoginEjb eaE = new LoginEjb();
        String result = "login";

        User usr = eaE.login(this.getUser().getNick(), password);
        if (usr != null) {
            sesion.setAttribute("user", usr);
            Logger.getLogger(VotarBean.class).info("entrar correcto: " + usr.getNick());
            result = "home";
        } else {
            this.addFieldError("Usuario o contraseña incorrectos");
        }
        return result;
    }

    public String register() {
        LoginEjb eaE = new LoginEjb();
        String result = "register";

        if (!password.equals(user.getPassword())) {
            this.addFieldError("Las contraseñas no coinciden");
        } else if (password.length() < 8) {
            this.addFieldError("Las contraseñas debe ser de 8 o mas caracteres");
        } else if (!eaE.register(user)) {
            this.addFieldError("Nick ocupado");
        } else {
            Logger.getLogger(VotarBean.class).info(
                    "registrar correcto: " + user.getNick());
            result = "login";
        }
        return result;
    }
}
