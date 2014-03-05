package votaciones.controllers.beans;

import java.util.List;

import votaciones.controllers.ejb.VotacionesEjb;
import votaciones.models.entities.Voto;

public class VotacionesBean extends Bean {

	private List<Voto> votaciones;

	public VotacionesBean() {
	}

	public List<Voto> getVotaciones() {
		votaciones = VotacionesEjb.votaciones();
		return votaciones;
	}

	public void setVotaciones(List<Voto> votaciones) {
	}

}
