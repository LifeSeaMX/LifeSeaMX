package com.jetbrains.MyWebApp;

import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/ServletTable")
public class ServletTable extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.write("<html lang=\"en\">");
        out.write("<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link rel=\"stylesheet\" href=\"./main/webapp/Style.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"./main/webapp/navbar.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"./main/webapp/tabla.css\">\n" +
                "    <title>Consulta</title>\n" +
                "\n" +
                "</head>");



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        List<Organizacion> datos = em
                .createQuery("select o.nombre, o.estado, o.ciudad, o.mail, o.telefono, c.nombre from Organizacion o inner join Categoria c on o.idCategoria = c.idCategoria", Organizacion.class)
                .getResultList();
        String json = new Gson().toJson(datos );


        out.write("<body>");
        out.write("<div class=\"navbar\">");




        out.write("<link rel=\"stylesheet\" href=\"./main/webapp/tabla.css\">\n" +
                "<div class=\"container-clock\">\n" +
                "    <h1 id=\"time\">00:00:00</h1>\n" +
                "    <p id=\"date\"></p>\n" +
                "</div>\n" +
                "<div class=\"form-group\">\n" +
                "    <input type=\"text\" class=\"form-control pull-right\" style=\"width:20%\" id=\"search\" placeholder=\"Buscador\">\n" +
                "</div>\n" +
                "<script src=\"js/clock.js\"></script>\n" +
                "<table class=\"table-bordered table pull-right\" id=\"mytable\" cellspacing=\"0\" style=\"width: 100%;\">\n" +
                "    <thead>\n" +
                "    <tr role=\"row\">\n" +
                "        <th>Asociación</th>\n" +
                "        <th>Estado</th>\n" +
                "        <th>Ciudad</th>\n" +
                "        <th>Descripción</th>\n" +
                "        <th>e-mail</th>\n" +
                "        <th>Teléfono</th>\n" +
                "        <th>Categoría</th>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>kokorolitos</td>\n" +
                "        <td>CDMX</td>\n" +
                "        <td>Gustavo A. Madero</td>\n" +
                "        <td>team kokorolitos</td>\n" +
                "        <td>kokorolitos@innovacion.mx</td>\n" +
                "        <td>5523898423</td>\n" +
                "        <td>just for fun</td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n" +
                "<script>\n" +
                "    // Write on keyup event of keyword input element\n" +
                "\n" +
                "    $(document).ready(function() {\n" +
                "        $('#example').DataTable( {\n" +
                "            data: dataSet,\n" +
                "            columns: [\n" +
                "                { title: \"Nombre\" },\n" +
                "                { title: \"Estado\" },\n" +
                "                { title: \"Ciudad\" },\n" +
                "                { title: \"Mail\" },\n" +
                "                { title: \"Telefono\" },\n" +
                "                { title: \"Categoria\" }\n" +
                "\n" +
                "            ],\n" +
                "            \"language\":{\n" +
                "                \"lengthMenu\": \"Mostrar _MENU_ registros por pagina\",\n" +
                "                \"info\": \"Mostrando pagina _PAGE_ de _PAGES_\",\n" +
                "                \"infoEmpty\": \"No hay registros disponibles\",\n" +
                "                \"infoFiltered\": \"(filtrada de _MAX_ registros)\",\n" +
                "                \"loadingRecords\": \"Cargando...\",\n" +
                "                \"processing\":     \"Procesando...\",\n" +
                "                \"search\": \"Buscar:\",\n" +
                "                \"zeroRecords\":    \"No se encontraron registros coincidentes\",\n" +
                "                \"paginate\": {\n" +
                "                    \"next\":       \"Siguiente\",\n" +
                "                    \"previous\":   \"Anterior\"\n" +
                "                },\n" +
                "            }\n" +
                "        } );\n" +
                "    } );\n" +
                "\n" +
                "</script>");

        out.write("");
        out.write("");

        out.write("</body>>");




}


    public void destroy() {
    }

}
