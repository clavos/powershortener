<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.MonBean"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Easy Link</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body class="text-center">
    <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand">PowerShortener</h3>
          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link active" href="/Projet_Servlet/home">Réduire URL</a>
            <a class="nav-link" href="/Projet_Servlet/url">Mes URLs</a>
            <a class="nav-link" href="/Projet_Servlet/index">Changer de compte</a>
          </nav>
        </div>
      </header>
      <main role="main" class="inner cover">
        <h1 class="cover-heading">
        <%
            MonBean notreBean = (MonBean) request.getAttribute("userBean");
    	    out.println(""+notreBean.getName()+" ");
            %>
        Votre URL courte ! :)</h1>
        <p class="lead">
            <%
            notreBean = (MonBean) request.getAttribute("userBean");
    	    out.println("http://www.urlst.com/"+notreBean.getUrlCourte()+"/");
            %>
        </p>
      </main>
    </div>
    <script src="js/jquery-3.2.1.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="js/jquery-slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>