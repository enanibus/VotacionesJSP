package votaciones.models.dao.jdbc;

import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.VotoDAO;

public class JDBCDAOFactory extends DAOFactory {

	@Override
	public VotoDAO getVotoDAO() {
		return new JDBCVotoDAO();
	}
}