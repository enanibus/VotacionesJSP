package votaciones.controllers.beans;

import org.apache.log4j.Logger;

import votaciones.controllers.ejb.VotarEjb;
import votaciones.models.entities.Pregunta;
import votaciones.models.entities.Respuesta;
import votaciones.models.entities.Voto;

public class VotarBean extends Bean {

	private Voto voto;

	public VotarBean() {
	}

	public Respuesta[] getRespuestas() {
		return Respuesta.values();
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public String getPregunta() {
		return Pregunta.getPregunta();
	}

	public void setPregunta(Pregunta pregunta) {
	}

	public String votar() {
		VotarEjb vEjb = new VotarEjb();
		String result = "votar";
		if (!vEjb.votar(voto)) {
			this.addFieldError("Error en el proceso de votación");
		} else {
			Logger.getLogger(VotarBean.class).info(
					"voto realizado correctamente: " + voto.toString() );
		}
		return result;
	}
}
