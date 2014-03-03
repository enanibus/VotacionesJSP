package votaciones.controllers.ejb;

import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.VotoDAO;
import votaciones.models.entities.Voto;

public class VotarEjb {

	private Voto v;

	/**
	 * @param voto
	 * @return void si se puede crear el voto, excepcion si no puede ser creado
	 */
	public boolean votar(Voto voto) {
		VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
		 v = votoDAO.read(voto.getIdVoto());
		
        if (v == null) {
            votoDAO.create(voto);
            return true;
        }
        return false;

	}

}
