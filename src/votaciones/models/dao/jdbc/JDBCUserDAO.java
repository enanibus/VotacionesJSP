package votaciones.models.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import votaciones.models.dao.VotoDAO;
import votaciones.models.entities.Respuesta;
import votaciones.models.entities.Voto;

public class JDBCVotoDAO extends JDBCGenericDAO<Voto, String> implements VotoDAO {
    private Logger log = Logger.getLogger(JDBCVotoDAO.class);

    public void createTable() {
        ContextJDBC.getJDBC().update("DROP TABLE IF EXISTS Voto ");
        ContextJDBC.getJDBC().update(
                "CREATE TABLE Voto (nick VARCHAR(99) NOT NULL, password VARCHAR(99),"
                        + "firstName VARCHAR(99),lastName VARCHAR(99),age INT,gender VARCHAR(99),"
                        + "country VARCHAR(99), administrator BIT, PRIMARY KEY (nick))");
        log.info("create Table...");
    }

    @Override
    public void create(Voto Voto) {
        log.info("create usuario:" + Voto);
        ContextJDBC.getJDBC().update(
                "INSERT Voto VALUES ('" + Voto.getNick() + "','" + Voto.getPassword()
                        + "','" + Voto.getFirstName() + "','" + Voto.getLastName() + "',"
                        + Voto.getAge() + ",'" + Voto.getGender() + "','" + Voto.getCountry() + "',"
                        + Voto.isAdministrator() + ")");
    }

    @Override
    public Voto read(String nick) {
        Voto usr = null;
        ResultSet rs = ContextJDBC.getJDBC().query("SELECT * FROM Voto WHERE nick='" + nick +"'");
        try {
            if (rs != null && rs.next()) {
                usr = new Voto(rs.getString("nick"), rs.getString("password"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender")), rs.getString("country"));
                usr.setAdministrator(rs.getBoolean("administrator"));
            }
        } catch (SQLException e) {
            log.error("read (" + nick + ")" + e.getMessage());
        }
        return usr;
    }

    @Override
    public void update(Voto Voto) {
        ContextJDBC.getJDBC().update(
                "UPDATE Voto SET password='" + Voto.getPassword() + "',firstName='"
                        + Voto.getFirstName() + "',lastName='" + Voto.getLastName()
                        + "',age=" + Voto.getAge() + "',gender='" + Voto.getGender()
                        + "',country='" + Voto.getGender() + "' WHERE nick='" + Voto.getNick()
                        + "'");
    }

    @Override
    public void delete(Voto Voto) {
        this.deleteByID(Voto.getNick());
    }

    @Override
    public void deleteByID(String id) {
        ContextJDBC.getJDBC().update("DELETE FROM Voto WHERE nick=" + id);
    }

    @Override
    public List<Voto> findAll() {
        List<Voto> Votos = new ArrayList<Voto>();
        ResultSet rs = ContextJDBC.getJDBC().query("SELECT * FROM Voto");
        try {
            while (rs.next()) {
                Voto usr = new Voto(rs.getString("nick"), rs.getString("password"),
                        rs.getString("firstName"), rs.getString("lastName"), rs.getInt("age"),
                        Gender.valueOf(rs.getString("gender")), rs.getString("country"));
                usr.setAdministrator(rs.getBoolean("administrator"));
                Votos.add(usr);
            }
        } catch (SQLException e) {
            log.error("findAll : " + e.getMessage());
        }
        return Votos;
    }

    public static void main(String[] args) {
        JDBCVotoDAO dao= new JDBCVotoDAO();
        dao.createTable();
        Voto admin = new Voto("admin", "a", "admin", "", 69, Gender.MALE, "Madrid");
        admin.setAdministrator(true);
        dao.create(admin);
        dao.create(new Voto("Voto", "u", "Voto", "", 69, Gender.MALE, "Madrid"));
    }
}
