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
            <a class="nav-link active" href="#">Home</a>
            <a class="nav-link" href="#">Features</a>
            <a class="nav-link" href="#">Contact</a>
          </nav>
        </div>
      </header>
      <main role="main" class="inner cover">
        <div class="row">
		

                <div class="col-md-6 offset-md-3">
				
                    <!-- form card change password -->
                    <div class="card card-outline-secondary">
                        <div class="card-header">
                            <h3 class="mb-0">Crée son compte ou se connecter</h3>
                        </div>
                        <div class="card-body">
                            <form action="tutu" method="post">
					            <div class="input">
					                <label for="username">
					                    <c:if test="${hasErrors}">
					                       <span class='error'>* </span>                        
					                    </c:if>Username: 
					                </label>
					                <input type="text" id="username" name="username" />
					            </div><div class="clearer">&nbsp;</div>
					            <div class="input">
					                <label for="password">
					                    <c:if test="${hasErrors}">
					                        <span class='error'>* </span>
					                    </c:if> Password: 
					                </label>
					                <input type="password" id="password" name="password" />
					            </div><div class="clearer">&nbsp;</div>
					            <div class="inputSubmit">
					                <input type="submit" value="Submit" />
					            </div>
					          </form>
                        </div>
                    </div>
                    <!-- /form card change password -->

                </div>
      </main>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="js/jquery-slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>