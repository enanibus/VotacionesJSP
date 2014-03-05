package votaciones.controllers.ejb;

import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.VotoDAO;
import votaciones.models.entities.Voto;

public class VotarEjb {

	/**
	 * @param voto
	 * @return booleam si se puede crear el voto, error si no puede ser creado
	 */
	public boolean votar(Voto voto) {
		VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
		Voto v = votoDAO.read(voto.getIdVoto());

		if (v == null) {
			votoDAO.create(voto);
			return true;
		}
		return false;

	}

}
