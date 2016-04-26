/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo;

import br.cesjf.lppo.Anuncio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "AnuncioControler", urlPatterns = {"/listar.html", "/novo.html"})
public class AnuncioControler extends HttpServlet {


    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("listar.html")) {
            List<Anuncio> anuncios = new ArrayList<>();
            AnuncioDAO dao = new AnuncioDAO();
            anuncios = dao.listarTodos();

            request.setAttribute("anuncios", anuncios);
            request.getRequestDispatcher("/WEB-INF/listar.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("novo.html")) {
            request.getRequestDispatcher("/WEB-INF/novo.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getRequestURI().contains("novo.html")){
            Anuncio novoAnuncio = new Anuncio();
            novoAnuncio.setNome(request.getParameter("nome"));
            novoAnuncio.setDescricao(request.getParameter("descricao"));
            novoAnuncio.setPreco(Float.parseFloat(request.getParameter("preco")));
            
            AnuncioDAO dao = new AnuncioDAO();
            dao.criar(novoAnuncio);
            
            response.sendRedirect("listar.html");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
