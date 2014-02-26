package votaciones.models.entities;

public class Voto {
	private int idVoto;
	private String ipCliente;
	private Respuesta respVoto;
	
    public Voto() {
        
    }
    
    public Voto(int idVoto, String ipCliente, Respuesta respVoto) {
        this.idVoto = idVoto;
        this.ipCliente = ipCliente;
        this.respVoto = respVoto;
    }

	public int getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public Respuesta getRespVoto() {
		return respVoto;
	}

	public void setRespVoto(Respuesta respVoto) {
		this.respVoto = respVoto;
	}

	@Override
	public String toString() {
		return "Voto [idVoto=" + idVoto + ", ipCliente=" + ipCliente
				+ ", respVoto=" + respVoto + "]";
	}
	
}
