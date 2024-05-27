<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<c:import url="include/layout/header.jsp"></c:import>
<style>
	.btn.btn-icon, .ajax-upload-dragdrop .btn-icon.ajax-file-upload {
	    width: 35px;
	    height: 35px;
	    padding: 0;
	}
</style>
<body>
	<c:import url="include/layout/loading.jsp"></c:import>
	<div class="row" id="proBanner" style="display: none;">
		<div class="col-12">
			<span class="d-flex align-items-center purchase-popup">
				<p></p> <i class="typcn typcn-delete-outline" id="bannerClose"></i>
			</span>
		</div>
	</div>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<c:import url="include/layout/navbar.jsp"></c:import>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<c:import url="include/layout/menu.jsp"></c:import>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">

						<div class="col-12">
							<div id="accordion" class="accordion">
								<div class="card border-primary">
									<div class="card-header border-bottom" id="headingOne-3"
										style="padding: 15px 15px 15px 15px; background-color: #f2f4f6 !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<!-- aria-expanded="false" -> icon -   else true -> icon +  -->
													<a aria-expanded="false" data-toggle="collapse"
														href="#collapseOne-2"> <span
														style="font-weight: bold; color: black;">DATABASE
															INFORMATION</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<!-- Adding show into end class, to collapse div -->
									<div id="collapseOne-2" class="border-bottom collapse"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">
											<div class="row">
												<div class="col-12">
													<p class="card-description">Configuration information</p>
													<ul class="list-arrow">
														<li><span class="text-primary">Setting Name: </span>Generic MariaDB</li>
														<li><span class="text-primary">Driver Class: </span>org.mariadb.jdbc.Driver</li>
														<li><span class="text-primary">JDBC URL: </span>jdbc:mariadb://localhost:3307/toolGenerate?useUnicode=true&characterEncoding=UTF-8</li>
														<li><span class="text-primary">User Name: </span>root</li>
														<li><span class="text-primary">Password: </span>123456</li>
													</ul>
												</div>
												<%-- <div class="col-6">
													<p class="card-description">Change password</p>
													<div class="row">
														<div class="col-12">
															<div class="row">
																<div class="col-6">
																	<div class="form-group">
																		<label for="exampleInputName1">User name<code>*</code></label>
																		<input type="text" class="form-control"
																			id="FILE_TEMPLATE_NAME" placeholder="User name">
																	</div>
																</div>
																<div class="col-6">
																	<div class="form-group">
																		<label for="exampleInputName1">Password<code>*</code></label>
																		<input type="text" class="form-control"
																			id="FILE_TEMPLATE_NAME" placeholder="Password">
																	</div>
																</div>
															</div>
														</div>
														<div class="col-12">
															<button type="button" id="btnSaveFileTemplate" class="btn btn-primary mr-2"><i class="fa fa-save"></i> SAVE</button>
														</div>
													</div>

												</div> --%>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-12 grid-margin stretch-card">
							<div class="card border-primary">
								<div class="card-body">
									<div class="embed-responsive embed-responsive-16by9">
										<iframe class="embed-responsive-item" src="<%=request.getContextPath()%>/h2-console"
											allowfullscreen name="myframe" onload="loadedIframe()" ></iframe>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<!-- main-panel ends -->

		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- base:js -->
	<c:import url="include/layout/footer.jsp"></c:import>
	<script type="text/javascript">
		$(document).ready(function() {
			displayBtnScroll(true);
		});

		function loadedIframe() {
			if (myframe.document.getElementById("login")) {
				myframe.document.getElementById("login").url.value = 'jdbc:mariadb://localhost:3307/toolGenerate?useUnicode=true&characterEncoding=UTF-8';
				myframe.document.getElementById("login").user.value = 'root';
				myframe.document.getElementById("login").password.value = '123456';
				myframe.document.getElementById("login").submit();
			}
		}
	</script>

</body>

</html>