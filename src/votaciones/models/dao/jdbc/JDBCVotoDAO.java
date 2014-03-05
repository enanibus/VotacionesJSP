package votaciones.models.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import votaciones.models.dao.VotoDAO;
import votaciones.models.entities.Respuesta;
import votaciones.models.entities.Voto;

public class JDBCVotoDAO extends JDBCGenericDAO<Voto, Integer> implements VotoDAO {
    private Logger log = Logger.getLogger(JDBCVotoDAO.class);

    public void createTable() {
        ContextJDBC.getJDBC().update("DROP TABLE IF EXISTS Voto ");
        ContextJDBC.getJDBC().update(
                "CREATE TABLE Voto (idvoto INT(6) AUTO_INCREMENT, ipcliente VARCHAR(32),"
                        + "respvoto CHAR(2), PRIMARY KEY (idvoto))");
        log.info("create Table...");
    }

    @Override
    public void create(Voto Voto) {
        log.info("create voto:" + Voto);
        ContextJDBC.getJDBC().update(
                "INSERT Voto VALUES ('" + Voto.getIdVoto() + "','" + Voto.getIpCliente()
                        + "','" + Voto.getRespVoto() + "')");
    }

    @Override
    public Voto read(Integer id) {
        Voto voto = null;
        ResultSet rs = ContextJDBC.getJDBC().query("SELECT * FROM Voto WHERE idvoto='" + id +"'");
        try {
            if (rs != null && rs.next()) {
                voto = new Voto(rs.getInt("idvoto"), rs.getString("ipcliente"),Respuesta.valueOf(rs.getString("respvoto")));
            }
        } catch (SQLException e) {
            log.error("read (" + id + ")" + e.getMessage());
        }
        return voto;
    }

    @Override
    public void update(Voto Voto) {
        ContextJDBC.getJDBC().update(
                "UPDATE Voto SET idvoto='" + Voto.getIdVoto() + "',ipcliente='"
                        + Voto.getIpCliente() + "',respvoto='" + Voto.getRespVoto() + "'");
    }

    @Override
    public void delete(Voto Voto) {
        this.deleteByID(Voto.getIdVoto());
    }

    @Override
    public void deleteByID(Integer id) {
        ContextJDBC.getJDBC().update("DELETE FROM Voto WHERE idvoto=" + id);
    }

    @Override
    public List<Voto> findAll() {
        List<Voto> Votos = new ArrayList<Voto>();
        ResultSet rs = ContextJDBC.getJDBC().query("SELECT * FROM Voto");
        try {
            while (rs.next()) {
                Voto voto = new Voto(rs.getInt("idvoto"), rs.getString("ipcliente"),Respuesta.valueOf(rs.getString("respvoto")));
                Votos.add(voto);
            }
        } catch (SQLException e) {
            log.error("findAll : " + e.getMessage());
        }
        return Votos;
    }

    public static void main(String[] args) {
        JDBCVotoDAO dao = new JDBCVotoDAO();
        dao.createTable();
		Voto voto = new Voto(1, "192.168.1.1", Respuesta.NO);
		dao.create(voto);
		dao.create(new Voto(2, "192.168.1.1", Respuesta.SI));
    }

}
