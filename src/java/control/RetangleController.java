/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rectangle;

/**
 *
 * @author DAOTHAOVAN
 */
public class RetangleController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RetangleController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RetangleController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        ArrayList<Rectangle> listAllRect = new ArrayList<>();
        ArrayList<Rectangle> listFillRect = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < num; i++) {
            Rectangle r = new Rectangle();
            r.setHeight(random.nextInt(51) + 50);
            r.setWidth(random.nextInt(51) + 50);
            r.setX(random.nextInt(499 - r.getWidth()) + 1);
            r.setY(random.nextInt(499 - r.getHeight()) + 1);
            listAllRect.add(r);
        }
        for (int i = 0; i < listAllRect.size() - 1; i++) {
            for (int j = i + 1; j < listAllRect.size(); j++) {
                int x_overlap = Math.max(0, Math.min(listAllRect.get(i).getX() + listAllRect.get(i).getWidth(), listAllRect.get(j).getX() + listAllRect.get(j).getWidth()) - Math.max(listAllRect.get(i).getX(), listAllRect.get(j).getX()));
                int y_overlap = Math.max(0, Math.min(listAllRect.get(i).getY() + listAllRect.get(i).getHeight(), listAllRect.get(j).getY() + listAllRect.get(j).getHeight()) - Math.max(listAllRect.get(i).getY(), listAllRect.get(j).getY()));
                if (x_overlap * y_overlap != 0) {
                    Rectangle rFill = new Rectangle(Math.max(listAllRect.get(i).getX(), listAllRect.get(j).getX()), Math.max(listAllRect.get(i).getY(), listAllRect.get(j).getY()), x_overlap, y_overlap);
                    rFill.setRed(random.nextInt(251));
                    rFill.setGreen(random.nextInt(251));
                    rFill.setBlue(random.nextInt(251));
                    listFillRect.add(rFill);
                }
            }
        }
        request.setAttribute("listAllRect", listAllRect);
        request.setAttribute("listFillRect", listFillRect);
        request.getRequestDispatcher("rect.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
