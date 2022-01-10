package vn.ht.bakery.shop.controllers;

import vn.ht.bakery.shop.DAO.IUserDAO;
import vn.ht.bakery.shop.DAO.UserDAO;
import vn.ht.bakery.shop.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    IUserDAO userDAO;


    public LoginServlet(){
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String email = request.getParameter("email");
       String password =  request.getParameter("password");
        try {
            User user = userDAO.getUserByEmail(email);
            if(user != null){
                if(user.getPassword().equals(password)){
                    User userLogin  = user;
                    HttpSession httpSession = request.getSession(true);
                    httpSession.setAttribute("userLogin", userLogin);
                    request.setAttribute("userLogin", userLogin);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("message", "Login unsuccessful. Please log in again");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            }else{
                request.setAttribute("message", "Account does not exist. Please log in again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
