package com.jetbrains.MyWebApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>Hola!</title></head>");
        out.write("<body>");

        String  idOrganizacion = request.getParameter("id_organizacion");
        String nombre = request.getParameter("nombre");
        String estado = request.getParameter("estado");
        String ciudad = request.getParameter("ciudad");
        String mail = request.getParameter("mail");
        String telefono = request.getParameter("telefono");
        String idCategoria = request.getParameter("id_categoria");

        String validationTel = "\"^\\\\d{10}$\"";
        String validationMail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        String validationRegex = "^[a-zA-Z\\s]+";
        String validationNum = "[+-]?\\d+";
         if(idOrganizacion.matches(validationNum) && nombre.matches(validationRegex) && estado.matches(validationRegex) && estado.matches(validationRegex) && ciudad.matches(validationRegex) && mail.matches(validationMail) && telefono.matches(validationTel) && idCategoria.matches(validationNum)) {
            Organizacion organizacion = new Organizacion();
            organizacion.setNombre(nombre);
            organizacion.setEstado(estado);
            organizacion.setCiudad(ciudad);
            organizacion.setMail(mail);
             organizacion.setTelefono(telefono);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(organizacion);
            em.getTransaction().commit();

            out.write("<h1>Envió exitoso!</h1>");
            //ACA VA EL BOTON DE REGRESAR o continuar o no se pero aca va algo


   /*
            //AAAAAAAAA
            out.write("<table border ='1'>");
            out.write("<tr>");
            out.write("<th>Name          </th>");
            out.write("<th>Usuario de GitHub</th>");
            out.write("</tr>");

            List<Person> people = em
                    .createQuery("Select p from Person p", Person.class)
                    .getResultList();
          /*  for (Person p: people) {
                out.write("<tr>");
                out.write("<td>" + p.getName() +"</td>");
                out.write("<td>" + p.getGitHub() +"</td>");
                out.write("</tr>");
            }

            out.write("</table>");
        */ } else {
            out.write("<h1>Lo Siento! Sólo acepto letras!</h1>");
        }

        out.write("<br><a href=\"index.jsp\">Regresar al form</a>");
        out.write("</body></html>");
    }

    public void destroy() {
    }
}