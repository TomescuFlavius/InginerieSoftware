package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.ejb.InvoiceBean;
import com.parking.parkinglot.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"READ_USERS"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"WRITE_USERS"})
        }
)

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Inject
    private InvoiceBean invoiceBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = userBean.findAllUsers();
        request.setAttribute("users", users);
        if(!invoiceBean.getUserIds().isEmpty()) {
            Collection<String> usernames = userBean.findUsernameByUserIds(invoiceBean.getUserIds());
            request.setAttribute("invoices", usernames);
        }
        request.getRequestDispatcher("WEB-INF/pages/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        String[] userIdsAsString = request.getParameterValues("userIds");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String[] userGroups = request.getParameterValues("user_groups");

        if (userGroups == null) {
            userGroups = new String[0];
        if (userIdsAsString != null) {
            List<Long> userIds = new ArrayList<>();
            for (String userId : userIdsAsString) {
                userIds.add(Long.parseLong(userId));
            }
        }
        }
        UserBean.createUser(username, email, password,
                Arrays.asList(userGroups));
        response.sendRedirect(request.getContextPath() + "/Users");
    }
    @Inject
    UserBean userBean;
}