package votaciones.controllers.beans;

import java.util.List;

import votaciones.controllers.ejb.VotacionesEjb;
import votaciones.models.entities.Voto;

public class VotacionesBean extends Bean {

	private List<Voto> votaciones;

	public VotacionesBean() {
	}

	public List<Voto> getVotaciones() {
		VotacionesEjb vEjb = new VotacionesEjb();
		votaciones = vEjb.votaciones();
		return votaciones;
	}

	public void setVotaciones(List<Voto> votaciones) {
	}

}
