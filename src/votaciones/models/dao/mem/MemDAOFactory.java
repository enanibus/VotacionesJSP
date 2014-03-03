package votaciones.models.dao.mem;

import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.VotoDAO;

public class MemDAOFactory extends DAOFactory {
	private VotoDAO memVotoDAO = new MemVotoDAO();

    @Override
    public VotoDAO getVotoDAO() {
        return this.memVotoDAO;
    }

}
