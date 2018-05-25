<%@ page pageEncoding="UTF-8" %>
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
    <p>Saisir l'URL longue ! :)</p>
        
        <p>
            <% 
            String attribut = (String) request.getAttribute("erreurLog");
            out.println( attribut );
            %>
        </p>
        
        <form method="post" action="tutu">
            <label for="url">URL : </label>
            <input type="text" name="url" id="url" />
            <input type="submit"value="Raccourcir" />
        </form>
    </div>
        
    </body>
</html>