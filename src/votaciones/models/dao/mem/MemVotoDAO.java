package votaciones.models.dao.mem;

import java.util.Calendar;

import org.apache.log4j.Logger;

import votaciones.models.entities.Voto;
import votaciones.models.dao.VotoDAO;

public class MemVotoDAO extends MemGenericDAO<Voto, Integer> implements VotoDAO {
	private final int julianDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
	private final int Year = Calendar.getInstance().get(Calendar.YEAR);
	private int idVoto = (Year*1000 + julianDay) * 1000;

    public MemVotoDAO() {
//        Voto voto = new Voto(this.idVoto, "192.168.1.1", Respuesta.NO);
//        this.create(voto);
//        this.create(new Voto(this.idVoto+1, "192.168.1.1", Respuesta.SI));
    }

    @Override
    protected Integer getId(Voto entity) {
    	setIdVoto();
    	Logger.getLogger(MemVotoDAO.class).info("idVoto asignado: " + this.idVoto);
        return this.idVoto;
    }

	public void setIdVoto() {
		this.idVoto = idVoto + 1;
	}
    
    

}
