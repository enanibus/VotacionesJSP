package votaciones.controllers.beans;

import java.util.List;

import votaciones.controllers.ejb.VotacionesEjb;
import votaciones.models.entities.Voto;

public class VotacionesBean extends Bean {

	public VotacionesBean() {
	}

	public List<Voto> getVotaciones() {
		return VotacionesEjb.votaciones();
	}

	public void setVotaciones(List<Voto> votaciones) {
	}

}
