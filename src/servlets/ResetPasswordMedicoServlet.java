package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDAO;
import dao.MedicoDAOImplementation;
import dao.model.Medico;

@WebServlet ("/ResetPasswordMedicoServlet")
public class ResetPasswordMedicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("ID");
        String passwordActual = req.getParameter("passwordActual");
        String passwordNueva = req.getParameter("passwordNueva");
        String passwordNuevaRep = req.getParameter("passwordNuevaRep");

        //Actualizar ddbb

        MedicoDAO dao = MedicoDAOImplementation.getInstance();
        Medico medico = dao.readMedico(Integer.parseInt(id));

        if (id.equals(medico.getId()) && passwordActual.equals(medico.getPassword())){

            if(passwordNueva.equals(passwordNuevaRep)) {
                medico.setPassword(passwordNueva);
                dao.updateMedico(medico);
                System.out.println("Contraseña cambiada con éxito");
                resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
                //Notificacion mediante correo
            }else {
                System.out.println("Las contraseñas nuevas no coinciden");
                resp.sendRedirect(req.getContextPath());
            }
        }else {
            System.out.println("Usuario o contraseña incorrectos");
            resp.sendRedirect(req.getContextPath());
        }
    }
}