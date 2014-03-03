package votaciones.controllers.beans;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import votaciones.controllers.ejb.VotacionesEjb;
import votaciones.models.entities.Voto;

public class VotacionesBean extends Bean {

    private ArrayList<Voto> resultado;

    public VotacionesBean() {
    }

    public ArrayList<Voto> verResultados() {
        VotarEjb eaE = new VotarEjb();
        String result = "register";

        if (!password.equals(user.getPassword())) {
            this.addFieldError("Las contraseñas no coinciden");
        } else if (password.length() < 8) {
            this.addFieldError("Las contraseñas debe ser de 8 o mas caracteres");
        } else if (!eaE.register(user)) {
            this.addFieldError("Nick ocupado");
        } else {
            Logger.getLogger(VotacionesBean.class).info(
                    "registrar correcto: " + user.getNick());
            result = "login";
        }
        return result;
    }
}
