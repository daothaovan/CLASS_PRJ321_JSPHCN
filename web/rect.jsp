<%-- 
    Document   : rect
    Created on : Sep 21, 2020, 10:19:11 AM
    Author     : DAOTHAOVAN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Rectangle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <%
            ArrayList<Rectangle> listAllRect = (ArrayList<Rectangle>) request.getAttribute("listAllRect");
            ArrayList<Rectangle> listFillRect = (ArrayList<Rectangle>) request.getAttribute("listFillRect");

        %>
        <canvas id="myCanvas" width="500" height="500" style="border:1px solid #d3d3d3;">
            Your browser does not support the HTML5 canvas tag.</canvas>

        <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            ctx.beginPath();
            <%for (Rectangle rect : listAllRect) {
            %>
            ctx.rect(<%=rect.getX()%>, <%=rect.getY()%>, <%=rect.getWidth()%>, <%=rect.getHeight()%>);
            <%}%>
            <%for (Rectangle rectFill : listFillRect) {
            %>//
            ctx.fillStyle = "rgb(<%=rectFill.getRed()%>,<%=rectFill.getGreen()%>,<%=rectFill.getBlue()%>)";
            ctx.fillRect(<%=rectFill.getX()%>, <%=rectFill.getY()%>, <%=rectFill.getWidth()%>, <%=rectFill.getHeight()%>);
            <%}%>
            ctx.stroke();

        </script> 

    </body>
</html>
