    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : home
    Created on : Feb 11, 2015, 2:30:20 AM
    Author     : emam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean  scope="session" class="model.Person" id="login"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>SUMS</title>
	
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

  <body>
	<div id="wrapper">
		<div id="main-container ">		
			<!-- BEGIN TOP NAVIGATION -->
				<nav class="navbar-top" role="navigation">
					<!-- BEGIN BRAND HEADING -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle pull-right" data-toggle="collapse" data-target=".top-collapse">
							<i class="fa fa-bars"></i>
						</button>
						<div class="navbar-brand">
							<a href="index.html">
								<img src="assets/images/logo.png" alt="logo" class="img-responsive">
							</a>
						</div>
					</div>
					<!-- END BRAND HEADING -->
					<div class="nav-top">
						<!-- BEGIN RIGHT SIDE DROPDOWN BUTTONS -->
							<ul class="nav navbar-right">					
								
								<li class="dropdown user-box">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                                            <img class="img-circle" src="assets/images/user.jpg" alt=""> <span class="user-info"><jsp:getProperty name="login" property="username"/></span> <b class="caret"></b>
									</a>
									<ul class="dropdown-menu dropdown-user">
										<li>
											<a href="Profile">
												<i class="fa fa-user"></i>My Profile
											</a>
										</li>
									</ul>
								</li>
								
								<!--Search Box-->
							</ul>
						<!-- END RIGHT SIDE DROPDOWN BUTTONS -->							
						<!-- BEGIN TOP MENU -->
							<div class="collapse navbar-collapse top-collapse">
								<!-- .nav -->
								<ul class="nav navbar-left navbar-nav">
									<li><a href="index.html">Mails</a></li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">
											Actions <b class="caret"></b>
										</a>
										<ul class="dropdown-menu">
											<li> <a href="Mail">Manage Mail</a></li>
                                                                                        <li> <a href="Ideas">Manage Idea</a></li>
										</ul>
									</li>
									
								</ul><!-- /.nav -->
							</div>
						<!-- END TOP MENU -->
					</div><!-- /.nav-top -->
				</nav><!-- /.navbar-top -->
				<!-- END TOP NAVIGATION -->

				
				

				<!-- BEGIN MAIN PAGE CONTENT -->
				<div id="page-wrapper" class="collapsed">
					<!-- BEGIN PAGE HEADING ROW -->
						<div class="row">
							<div class="col-lg-12">
								<!-- BEGIN BREADCRUMB -->
								<div class="breadcrumbs">
									<ul class="breadcrumb">
										<li>
											<a href="#">Home</a>
										</li>
									</ul>
									
									
								</div>
								<!-- END BREADCRUMB -->	
								
								<div class="page-header title">
								<!-- PAGE TITLE ROW -->
									<h1>Mail List <span class="sub-title"></span></h1>								
								</div>
								
									
								
							</div><!-- /.col-lg-12 -->
						</div><!-- /.row -->
					<!-- END PAGE HEADING ROW -->					
						<div class="row">
							<div class="col-lg-12">
							
							<div class="portlet"><!-- /Portlet -->
									<div class="portlet-heading dark">
										<div class="portlet-title">
											<h4>Project Ideas <small class="text-white"></small></h4>
										</div>
										<div class="portlet-widgets">
											<a data-toggle="collapse" data-parent="#accordion" href="#basic"><i class="fa fa-chevron-down"></i></a>
											<span class="divider"></span>
											<a href="#" class="box-close"><i class="fa fa-times"></i></a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div id="basic" class="panel-collapse collapse in">
										<div class="portlet-body no-padding">
											<table class="table table-bordered table-hover tc-table">
												<thead>
													<tr>
														
														<th>Title</th>
                                                                                                                <th>Description</th>
                                                                                                                <th>Aims</th>
                                                                                                                <th>Academic Question</th>
                                                                                                                <th>Submission Date</th>
                                                                                                                <th>Number Of Student</th>
                                                                                                                
														
														<th class="col-medium center">Action</th>
													</tr>
												</thead>
												<tbody>
                                                                                                    
                                                                                                    <c:forEach items="${list}" var="l">
													<tr>
														
                                                                                                            <td class="hidden-xs"><c:out value="${m.getTitle()}"></c:out></td>
                                                                                                            <td class="hidden-xs"><c:out value="${m.getDesc()}"></c:out></td>
                                                                                                            <td class="hidden-xs"><c:out value="${m.getAims()}"></c:out></td>
                                                                                                            <td class="hidden-xs"><c:out value="${m.getAcQuestion()}"></c:out></td>
                                                                                                            <td class="hidden-xs"><c:out value="${m.getDate()}"></c:out></td>
                                                                                                            <td class="hidden-xs"><c:out value="${m.getNumberOfStudent()}"></c:out></td>
														
														<td class="col-medium center">
															<div class="btn-group btn-group-xs ">
																<a href="ViewEditmail?id=<c:out value="${m.getId()}"></c:out>&name=<c:out value="${m.getTitle()}"></c:out>" class="btn btn-inverse"><i class="fa fa-pencil icon-only"></i></a>
                                                                                                                                
															</div>	
														</td>
													</tr>
                                                                                                        
                                                                                                        </c:forEach>
													
												</tbody>
											</table>												
										</div>
									</div>
								</div><!-- /Portlet -->
					
							</div>
						</div>
						
					<!-- BEGIN FOOTER CONTENT -->		
						<div class="footer">
							<div class="footer-inner">
								<!-- basics/footer -->
								<div class="footer-content">
									&copy; 2014 <a href="#">eKoders</a>, All Rights Reserved.
								</div>
								<!-- /basics/footer -->
							</div>
						</div>
						<button type="button" id="back-to-top" class="btn btn-primary btn-sm back-to-top">
							<i class="fa fa-angle-double-up icon-only bigger-110"></i>
						</button>
					<!-- END FOOTER CONTENT -->
					
				</div><!-- /#page-wrapper -->	  
			<!-- END MAIN PAGE CONTENT -->
		</div>  
	</div> 
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
	
	<!-- initial page level scripts for examples -->	
  </body>
</html>