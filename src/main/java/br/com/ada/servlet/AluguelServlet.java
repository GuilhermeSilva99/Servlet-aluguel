package br.com.ada.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/aluguel")
public class AluguelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomePessoa = req.getParameter("nome_pessoa");
        String local = req.getParameter("local");
        String placa = req.getParameter("placa");
        String inicioAluguel = req.getParameter("inicio_aluguel");
        String fimAluguel = req.getParameter("fim_aluguel");

        if (nomePessoa.equals("") || local.equals("") || placa.equals("") || inicioAluguel.equals("") || fimAluguel.equals("") ){
            resp.setContentType("text/html");
            resp.getWriter().println("<h3> Dados obrigatorios não preenchidos </h3>");
        }else {
            req.setAttribute("nome_pessoa", nomePessoa);
            req.setAttribute("local", local);
            req.setAttribute("placa", placa);
            req.setAttribute("inicio_aluguel", inicioAluguel);
            req.setAttribute("fim_aluguel", fimAluguel);
            RequestDispatcher rd = req.getRequestDispatcher("exibirAluguel.jsp");
            rd.forward(req, resp);
        }
    }
}
