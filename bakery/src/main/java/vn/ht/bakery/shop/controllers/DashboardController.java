package vn.ht.bakery.shop.controllers;

import vn.ht.bakery.shop.DAO.BakeryDAO;
import vn.ht.bakery.shop.DAO.IBakeryDAO;
import vn.ht.bakery.shop.DAO.IUserDAO;
import vn.ht.bakery.shop.DAO.UserDAO;
import vn.ht.bakery.shop.model.Bakery;
import vn.ht.bakery.shop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/admin")
public class DashboardController extends HttpServlet {
    IUserDAO userDAO;
    IBakeryDAO bakeryDAO;

    public static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final String LOGO_ROOT_FOLDER = "Users//thuanho//Desktop//C0921G1//bakery//src//main//webapp//logo";

    public DashboardController() {
        userDAO = new UserDAO();
        bakeryDAO = new BakeryDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        if (userLogin==null){
            to404Page(request,response);
        } else {

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "usermanager":
                showListUser(request, response);
                break;
            case "addnewuser":
                addNewUserForm(request, response);
                break;
            case "updateuser":
                try {
                    showEditFrom(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "blockUser":
                try {
                    setStatus(request, response, "UnActive");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "activeUser":
                try {
                    setStatus(request, response, "Active");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "bakerymanager":
                showListBakery(request, response);
                break;
            case "addnewbakery":
                addNewBakeryForm(request, response);
                break;
            case "updatebakery":
                try {
                    showBakeryEditFrom(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "listorder":
                showListOrder(request, response);
                break;
                case "logout":
                loguot(request, response);
                break;

        }

        }
    }

    private void loguot(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        httpSession.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    private void setStatus(HttpServletRequest request, HttpServletResponse response, String status) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id);
        user.setStatus(status);
        userDAO.updateUser(user);
        showListUser(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        if (userLogin==null){
            to404Page(request,response);
        } else {
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "addnewuser":
                    try {
                        insertUser(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "updateuser":
                    try {
                        updateUser(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "addnewbakery":
                    try {
                        System.out.println("gsybuhadjnkm");
                        insertBakery(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "updatebakery":
                    try {
                        updateBakery(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.getUserById(id);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        request.setAttribute("userLogin", userLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit-staff.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void showListOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        request.setAttribute("userLogin", userLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-order.jsp");
        dispatcher.forward(request, response);
    }


    private void addNewUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        request.setAttribute("userLogin", userLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create-staff.jsp");
        dispatcher.forward(request, response);
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserDAO userDAO = new UserDAO();
        List<User> userList = new ArrayList<>();
        userList = userDAO.selectAllUser();
        System.out.println(userList);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        if (userLogin.getRole().equals("admin")){
            request.setAttribute("userLogin", userLogin);
            request.setAttribute("listUser", userList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list-user.jsp");
            dispatcher.forward(request, response);
        } else{
            to404Page(request,response);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        User user = new User(id, fullName, email, phone, age, address);
        System.out.println(user);
        userDAO.updateUser(user);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        if (userLogin.getRole().equals("admin")){
            request.setAttribute("userLogin", userLogin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/edit-staff.jsp");
            dispatcher.forward(request, response);
        } else{
            to404Page(request,response);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String status = "Active";
        String role = "staff";
        User user = new User(fullName, email, phone, age, address, status, password, role);
        userDAO.insertUser(user);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        if (userLogin.getRole().equals("admin")){
            request.setAttribute("userLogin", userLogin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/create-staff.jsp");
            dispatcher.forward(request, response);
        } else{
            to404Page(request,response);
        }
    }


    private void showListBakery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IBakeryDAO bakeryDAO = new BakeryDAO();
        List<Bakery> bakeryList = new ArrayList<>();
        bakeryList = bakeryDAO.selectAllBakery();
        System.out.println(bakeryList);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        request.setAttribute("userLogin", userLogin);
        request.setAttribute("listBakery", bakeryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-bakery.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBakery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String bakeryName = request.getParameter("bakeryName");
        double price = Double.parseDouble(request.getParameter("price"));
        long quantity = Long.parseLong(request.getParameter("quantity"));
        String description = request.getParameter("description");
        Bakery bakery = new Bakery(bakeryName, price, quantity, description);
        System.out.println(bakery);
        bakeryDAO.insertBakery(bakery);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        request.setAttribute("userLogin", userLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create-bakery.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBakery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String bakeryName = request.getParameter("bakeryName");
        double price = Double.parseDouble(request.getParameter("price"));
        long quantity = Long.parseLong(request.getParameter("quantity"));
        String description = request.getParameter("description");
        Bakery bakery = new Bakery(id, bakeryName, price, quantity, description);
        System.out.println(bakery);
        bakeryDAO.updateBakery(bakery);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
//        if (userLogin==null){
//            to404Page(request,response);
//        } else {
            request.setAttribute("userLogin", userLogin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/edit-bakery.jsp");
            dispatcher.forward(request, response);
//        }
    }

    private void to404Page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/404.jsp");
        dispatcher.forward(request, response);

    }

    private void addNewBakeryForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        request.setAttribute("userLogin", userLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create-bakery.jsp");
        dispatcher.forward(request, response);
    }

    private void showBakeryEditFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Bakery existingBakery = bakeryDAO.getBakeryById(id);
        System.out.println(existingBakery);
        request.setAttribute("bakery", existingBakery);
        HttpSession httpSession = request.getSession(true);
        User userLogin = (User) httpSession.getAttribute("userLogin");
        request.setAttribute("userLogin", userLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit-bakery.jsp");
        request.setAttribute("user", existingBakery);
        dispatcher.forward(request, response);
    }
}
