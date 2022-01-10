<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page With other Login Options</title>
    <style>
        html {
            background: rgb(148, 129, 129);
        }
        
        .body-content {
            padding-top: 14.25vh;
        }
        
        .container {
            width: 350px;
            height: 450px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: auto;
            border: 2px solid White;
            border-radius: 15px;
            background: white;
        }
        h2{
            color: rgb(87, 83, 83);
            font-family: Arial, Helvetica, sans-serif;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        
        .form-item {
            margin: 5px;
            padding-bottom: 10px;
            display: flex;
        }
        
        .form-item label {
            display: block;
            padding: 2px;
            font-size: 20px;
            width: 100px;
        }
        
        .form-item input {
            width: 320px;
            height: 35px;
            border: 2px solid #e1dede69;
            border-radius: 20px;
            background: #e1dede69;
            color: grey;
            text-align: center;
        }
        
        .form-btns {
            display: flex;
            flex-direction: column;
            margin: auto;
            padding: 10px 0;
        }
        
        .form-btns button {
            margin: auto;
            font-size: 20px;
            padding: 5px 15px;
            border: 2px solid;
            border-radius: 15px;
            color: white;
            background: #178cc6;
            width: 280px;
            cursor: pointer;
        }
        
        .options {
            padding-top: 15px;
            margin: auto;
        }
        
        .options a {
            font-family: Arial, Helvetica, sans-serif;
            text-decoration: none;
            color: black;
            margin: 0 45px;
            font-size: 14px;
        }
        .options a:hover {
            color:grey;
        }
        hr {
            background: grey;
            width: 80%;
        }
        
        .login-options{
            display: flex;
            flex-direction: column;
            margin: 10px;
        }
        .login-options .facebook{
            margin: auto;
            font-size: 16px;
            padding: 10px 15px;
            border: 2px solid;
            border-radius: 15px;
            color: white;
            background: #178cc6;
            width: 320px;
            cursor: pointer;

        }
        .login-options .google{
            margin: auto;
            font-size: 16px;
            padding: 10px 15px;
            border: 2px solid;
            border-radius: 15px;
            color: white;
            background: #c61d17;
            width: 320px;
            cursor: pointer;
        }
    </style>
</head>

<body>
    <div class="body-content">
        <div class="container">
            <h3>${message}</h3>
            <h2>Login</h2>
            <div class="login-form">
                <form action="/login" method="post">
                    <div class="form-item">
                        <!-- <label for="userName">Username:</label> -->
                        <input type="text" name="email" id="email" placeholder="Email">
                    </div>
                    <div class="form-item">
                        <!-- <label for="passWord">Password:</label> -->
                        <input type="password" name="password" id="password" placeholder="Password">
                    </div>
                    <div class="form-btns">
                        <button type="submit">Login</button>

                        <div class="options">
                            <a href="#">Sign Up</a>
                            <a href="#">Forget Password?</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>