package votaciones.controllers.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import votaciones.models.entities.Respuesta;
import votaciones.models.entities.Voto;

/**
 * Servlet implementation class FrontController
 */
@WebServlet({ "/", "/*/*" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "error";

		if (action == null || action.equals("home")) {
			view = "home";
		} else if (action.equals("votar")) {
			Voto voto = new Voto();
			VotarBean votarB = new VotarBean();
			votarB.setVoto(voto);
			request.setAttribute("votarB", votarB);
			view = "votar";
		} else if (action.equals("votaciones")) {
			VotacionesBean votacionesB = new VotacionesBean();
			votacionesB.setVotaciones(null);
			request.setAttribute("votacionesB", votacionesB);
			view = "votaciones";
		}
		getServletContext().getRequestDispatcher("/" + view + ".jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "error";

		if (action.equals("votar")) {
			Voto voto = new Voto();
			VotarBean votarB = new VotarBean();
			votarB.setVoto(voto);
			request.setAttribute("votarB", votarB);
			voto.setIpCliente(request.getRemoteAddr());
			voto.setRespVoto(Respuesta.valueOf(request
					.getParameter("respuesta")));

			view = votarB.votar();
		}
		getServletContext().getRequestDispatcher("/" + view + ".jsp").forward(
				request, response);
	}
}
