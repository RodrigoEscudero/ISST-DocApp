package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacienteDAO;
import dao.PacienteDAOImplementation;
import dao.model.Paciente;

@WebServlet ("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String dni = req.getParameter("dni");
        String passwordActual = req.getParameter("passwordActual");
        String passwordNueva = req.getParameter("passwordNueva");
        String passwordNuevaRep = req.getParameter("passwordNuevaRep");

        //Actualizar ddbb

        PacienteDAO dao = PacienteDAOImplementation.getInstance();
        Paciente paciente = dao.readPaciente(dni);

        if (dni.equals(paciente.getDni()) && passwordActual.equals(paciente.getPassword())){

            if(passwordNueva.equals(passwordNuevaRep)) {
                paciente.setPassword(passwordNueva);
                dao.updatePaciente(paciente);
                System.out.println("Contraseña cambiada con éxito");
                resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
                //Notificacion mediante correo
            }else {
             System.out.println("Las contraseñas nuevas no coinciden");
                resp.sendRedirect(req.getContextPath());
            }
        } else{
            System.out.println("Usuario o contraseña incorrectos");
            resp.sendRedirect(req.getContextPath());
        }
    }
}
