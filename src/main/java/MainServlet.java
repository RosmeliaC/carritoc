

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String producto=request.getParameter("producto");
        //obtener acceso a la session
        HttpSession ses = request.getSession();
        //eliminar atributos de la session
        ses.invalidate();
        //transferir el control a index.jsp
        response.sendRedirect("index.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //viene del formulario
        String producto= request.getParameter( "producto");
        //obtener el acceso al objeto session
        HttpSession ses = request.getSession();
        //obtener el atributo lista de session
        ArrayList<String> lista = (ArrayList<String>)ses.getAttribute("lista");
                //adicionar oroducto a la lista
        lista.add( producto);
        //transferir el control de index.jsp
        response.sendRedirect( "index.jsp");
    }

}
