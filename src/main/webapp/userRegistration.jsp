<%@ page import="java.sql.*"%>
<%
    String username = request.getParameter("username");    
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "MySQLroot1$");
    Statement st = con.createStatement();
    int i = st.executeUpdate("insert into USER2(FIRST_NAME, LAST_NAME, EMAIL, USERNAME, PASSWORD) values ('" + firstName + "','" 
    + lastName + "','" + email + "','" + username + "','" + password + "');");
    if (i > 0) {
        response.sendRedirect("welcome.jsp");
       
    } else {
        response.sendRedirect("index.jsp");
    }
%>