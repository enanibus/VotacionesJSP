package votaciones.models.dao;

import org.apache.log4j.Logger;

import votaciones.models.dao.mem.MemDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory factory = null;

    public static void setFactory(DAOFactory factory) {
        DAOFactory.factory = factory;
    }

    public static DAOFactory getFactory() {
        if (factory == null) {
            factory = new MemDAOFactory();
            Logger.getLogger(DAOFactory.class).info(
                    "DAOFactory: " + factory.getClass().getSimpleName());
        }
        return factory;
    }

    public abstract VotoDAO getVotoDAO();

}
