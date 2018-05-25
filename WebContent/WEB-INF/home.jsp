<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
        <div class="container py-5">
    <div class="row">
        <div class="col-md-12">
            <h2 class="text-center mb-5">Power Shortener</h2>
           
            <div class="row">
		

                <div class="col-md-6 offset-md-3">
				
                    <!-- form card change password -->
                    <div class="card card-outline-secondary">
                        <div class="card-header">
                            <h3 class="mb-0">Crée son compte ou se connecter</h3>
                        </div>
                        <div class="card-body">
                            <form class="form" role="form" action="home" method="POST" autocomplete="off">
                                <div class="form-group">
                                    <label for="inputPasswordOld">login</label>
                                    <input
                                     type="text" 
                                     name="login"  
                                     class="form-control" 
                                     id="inputPasswordOld" 
                                     required="" 
                                     value="<% 
                                     String login = (String) request.getAttribute("login");   
                                     if(login != null){ %>  <%= login %>  <% } %>"
                                     >
                                </div>
                                <div class="form-group">
                                    <label for="inputPasswordNew">password</label>
                                    <input type="text"
                                     name="password" 
                                     class="form-control" 
                                     id="inputPasswordNew" 
                                     required=""
                                     value="<% 
                                     String password = (String) request.getAttribute("password");
                                     if(password != null){ %>  <%= password %>  <% } %>"
                                     >
                                </div>

                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success btn-lg ml-4">Connexion / inscription</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- /form card change password -->

                </div>



            </div>
            <!--/row-->

        <br><br><br><br>

        </div>
        <!--/col-->
    </div>
    <!--/row-->
    
</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script src="js.js"> </script>
</body>
</html>