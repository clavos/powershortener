<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.MonBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Easy Link</title>
        <link rel="stylesheet" href="css/style.css" />
        <script src="js/jquery-3.3.1.min.js"></script>
           
    </head>

    <body>
    <img id="img-logo" class="img-logo" src="images/logo.jpg" />
    
    <div id="bloc-main" class="bloc-main">
    <p>Voici votre nouvelle URL ! :)</p>
        
        <p>
            <%

            MonBean notreBean = (MonBean) request.getAttribute("urlBean");
    	    out.println("http://www.urlst.com/"+notreBean.getUrlCourte()+"/");
            %>
        </p>
    </div>
        
    </body>
</html>