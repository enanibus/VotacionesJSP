package votaciones.controllers.ejb;

import java.util.List;

import com.sun.istack.internal.logging.Logger;

import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.VotoDAO;
import votaciones.models.entities.Voto;

public class VotacionesEjb {

	/**
	 * @param
	 * @return devuelve la lista con los votos realizados
	 */
	public static List<Voto> votaciones() {
		VotoDAO votoDAO = DAOFactory.getFactory().getVotoDAO();
		Logger.getLogger(VotacionesEjb.class).info(votoDAO.findAll().toString());
		return votoDAO.findAll();
	}

}
