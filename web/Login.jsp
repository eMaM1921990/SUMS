<%-- 
    Document   : Login
    Created on : Feb 9, 2015, 12:10:25 AM
    Author     : emam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Login to - SUMS</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/fonts.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">

        <!-- PAGE LEVEL PLUGINS STYLES -->
        <!-- REQUIRE FOR SPEECH COMMANDS -->
        <link rel="stylesheet" type="text/css" href="assets/css/plugins/gritter/jquery.gritter.css" />	

        <!-- Tc core CSS -->
        <link id="qstyle" rel="stylesheet" href="assets/css/themes/style.css">	
        <!--[if lte IE 8]>
                <link rel="stylesheet" href="assets/css/ie-fix.css" />
        <![endif]-->


        <!-- Add custom CSS here -->

        <!-- End custom CSS here -->

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

    </head>

    <body class="login">
        <div id="wrapper">
            <!-- BEGIN MAIN PAGE CONTENT -->

            <div class="login-container">
                <h2>
                    <a href="index.html">SUMS</a><!-- can use your logo-->
                </h2>
                <!-- BEGIN LOGIN BOX -->
                <div id="login-box" class="login-box visible">					
                    <p class="bigger-110">
                        <i class="fa fa-key"></i> Please Enter Your Information
                    </p>

                    <div class="hr hr-8 hr-double dotted"></div>

                    <form method="post" action="LogAuth">
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-key text-gray"></span>
                                <input type="text" class="form-control" placeholder="Username" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-lock text-gray"></span>
                                <input type="password" class="form-control" placeholder="your password" name="pass">
                            </div>
                        </div>
                        <div class="tcb">
                            <button type="submit" class="pull-right btn btn-primary"><i class="fa fa-key icon-on-right"></i>Login</button>
<!--                            <a href="#" class="pull-right btn btn-primary">Login<i class="fa fa-key icon-on-right"></i></a>-->
                            <div class="clearfix"></div>
                        </div>				



                        <div class="footer-wrap">
                            <span class="pull-left">
                                <a href="#" onclick="window.open('Home','_self')"><i class="fa fa-angle-double-left"></i>Login as Guest</a>
                            </span>

                            <span class="pull-right">
                                <a href="#" onclick="show_box('registration-box');
                                                                        return false;">Register here <i class="fa fa-angle-double-right"></i></a>
                            </span>

                            <div class="clearfix"></div>
                        </div>							
                    </form>
                </div>
                <!-- END LOGIN BOX -->

                <!-- BEGIN FORGOT BOX -->
                <div id="forgot-box" class="login-box">				
                    <p class="bigger-110">
                        <i class="fa fa-key"></i> G
                    </p>

                    <div class="hr hr-8 hr-double dotted"></div>

                    <form method="post" >
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-envelope text-gray"></span>
                                <input type="email" class="form-control" placeholder="Email">
                                <span class="help-block">Enter your email and to receive instructions</span>
                            </div>
                        </div>
                        <a href="#" class="pull-right btn btn-danger">Submit</a>

                        <div class="clearfix"></div>

                        <div class="footer-wrap">
                            <a href="#" onclick="show_box('login-box');
                                                                        return false;">Back to login <i class="fa fa-angle-double-right"></i></a>
                        </div>							
                    </form>					
                </div>
                <!-- END FORGOT BOX -->

                <!-- BEGIN REGISTRATION BOX -->
                <div id="registration-box" class="login-box">				
                    <p class="bigger-110">
                        <i class="fa fa-users"></i> New User Registration
                        <br>
                    <div id="notification" style="color: red" ></div>
                    </p>

                    <div class="hr hr-8 hr-double dotted"></div>

                    <form method="post" >
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-user text-gray"></span>
                                <input type="text" class="form-control" placeholder="ForeName" id="Forename">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-user text-gray"></span>
                                <input type="text" class="form-control" placeholder="SureName" id="Surname">
                            </div>
                        </div>	
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-envelope text-gray"></span>
                                <input type="email" class="form-control" placeholder="Email" id="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-key text-gray"></span>
                                <input type="text" class="form-control" placeholder="Username" id="Username">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-lock text-gray"></span>
                                <input type="password" class="form-control" placeholder="your password" id="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-repeat text-gray"></span>
                                <input type="password" class="form-control" placeholder="confirm password" id="repass">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-archive text-gray"></span>
                                <select class="form-control selectpicker" onchange="getType(this.value)" id="types">
                                    <c:forEach items="${personstatus}" var="p">
                                        <option value="<c:out value="${p.id}"/>"><c:out value="${p.name}"/></option>
                                    </c:forEach>
                                    
                                    

                                </select>

                            </div>
                        </div>
                        <div id="type"></div>
                        <div class="form-group">
                            <div class="input-icon right">
                                <span class="fa fa-repeat text-gray"></span>
                                <input type="text" class="form-control" placeholder="Phone" id="phone">
                            </div>
                        </div>
                       			

                        <p><a  class="btn btn-success" onclick="Resgistration()">Register<i class="fa fa-angle-double-right icon-on-right"></i></a></p>

                        <div class="footer-wrap">
                            <a href="#" onclick="show_box('login-box');
                                                                        return false;"><i class="fa fa-angle-double-left"></i> Back to login</a>
                        </div>							
                    </form>
                </div>
                <!-- END REGISTRATION BOX -->
            </div>

            <!-- Modal For Terms and Conditions -->
            <div class="modal fade" id="Myterms" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
                        </div>
                        <div class="modal-body">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus ipsa porro delectus quidem dolorem ad.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success" data-dismiss="modal">I Agree</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->


            <!-- END MAIN PAGE CONTENT --> 
        </div> 

        <!-- core JavaScript -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/js/plugins/pace/pace.min.js"></script>

        <!-- PAGE LEVEL PLUGINS JS -->

        <!-- Themes Core Scripts -->	
        <script src="assets/js/main.js"></script>

        <!-- REQUIRE FOR SPEECH COMMANDS -->
        <script src="assets/js/speech-commands.js"></script>
        <script src="assets/js/plugins/gritter/jquery.gritter.min.js"></script>	
        <script src="assets/js/custom.js"></script>
        <!-- initial page level scripts for examples -->	
        <script type="text/javascript">
                                                                    function show_box(id) {
                                                                        jQuery('.login-box.visible').removeClass('visible');
                                                                        jQuery('#' + id).addClass('visible');
                                                                    }
        </script>
    </body>
</html>