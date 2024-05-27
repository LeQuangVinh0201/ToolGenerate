<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>%>
<!DOCTYPE html>
<html lang="en">

<c:import url="include/layout/header.jsp"></c:import>
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
								<div class="card">
									<div class="card-header border-bottom" id="headingOne-3"
										style="padding: 15px 15px 15px 15px; background-color: #f2f4f6 !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-2"> <span
														style="font-weight: bold; color: black;">LIST FILE TEMPLATE</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<div id="collapseOne-2" class="border-bottom collapse show"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">
											
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-12">
							<div id="accordion" class="accordion">
								<div class="card">
									<div class="card-header border-bottom" id="headingOne-3"
										style="padding: 15px 15px 15px 15px; background-color: #f2f4f6 !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-3"> <span
														style="font-weight: bold; color: black;">LIST FILE TEMPLATE</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<div id="collapseOne-3" class="border-bottom collapse show"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">
											
										</div>
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

		});
	</script>

</body>

</html>