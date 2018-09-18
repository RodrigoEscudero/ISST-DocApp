package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDAOImplementation;
import dao.model.Medico;
import util.Consulta;


@WebServlet("/GetHorasModificar")
public class GetHorasModificar  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idMedicoStr=req.getParameter("idMedico");
		String fechaStr = req.getParameter("diaCita");
		int id_medico=Integer.parseInt(idMedicoStr);
		System.out.println(idMedicoStr+" "+fechaStr+"mmnmnmmnnm");
		Medico medico = MedicoDAOImplementation.getInstance().readMedico(id_medico);
		Date fecha = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

			fecha = formatter.parse(fechaStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String [] horas =  Consulta.gethorasLibresDia(medico,fecha);
        String mij="",sep="";
        
        for (int i=0;i<horas.length;i++) {
        	mij += sep+horas[i];
        	sep=",";
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(mij);
	}
}	
