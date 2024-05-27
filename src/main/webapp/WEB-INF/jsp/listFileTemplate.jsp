<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<c:import url="include/layout/header.jsp"></c:import>
<style>
	div.dataTables_wrapper div.dataTables_filter input {
		width: 400px;
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

						<%-- <div class="col-12">
							<div id="accordion" class="accordion">
								<div class="card">
									<div class="card-header border-bottom" id="headingOne-3"
										style="padding: 15px 15px 15px 15px; background-color: #e9eaeb !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-2"> <span
														style="font-weight: bold; color: black;">SEARCH
															CONDITIONS</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<div id="collapseOne-2" class="collapse show"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">


											<div class="form-group-param row">

												<div class="form-group col-xl-3 col-lg-6">
													<label for="exampleSelectGender">Required <code>*</code></label>
													<select class="form-control"
														id="inputParamRequired${indexParameter}"
														data-value="PARAMETER_REQUIRED"
														data-group="paramGroup${indexParameter}">
														<c:forEach var="ynType" items="${ynType.ynTypes}">
															<option value="${ynType.ynValue}"
																<c:if test="${ynType.ynValue == parameterChild.parameterRequired}"> selected </c:if>>${ynType.ynType}
															</option>
														</c:forEach>
													</select>
												</div>
												<div class="form-group col-xl-3 col-lg-6">
													<label>Description <code>*</code>
													</label> <input class="form-control" id="inputParamDesc"
														data-value="PARAMETER_DESCRIPTION"
														data-group="paramGroup${indexParameter}"
														value="${parameterChild.parameterDescription}">
												</div>
												<div class="order-listing_filter col-xl-3 col-lg-6">
													<label>Default value </label> <input class="form-control"
														id="inputParamDefaultValue"
														data-value="PARAMETER_DEFAULT_VALUE"
														data-group="paramGroup" value="">
												</div>
												<div class="d-flex flex-row-reverse form-group col">
													<button type="button" id="btnGenerateFileTemplate"
														class="btn btn-primary mr-2" style="margin-top: 25px;">
														<i class="fa fa-search"></i> SEARCH
													</button>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div> --%>

						<div class="col-12">
							<div id="accordion" class="accordion">
								<div class="card border-primary">
									<div class="card-header border-bottom" id="headingOne-3"
										style="padding: 15px 15px 15px 15px; background-color: #e9eaeb !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-3"> <span
														style="font-weight: bold; color: black;">LIST FILE
															TEMPLATE</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<div id="collapseOne-3" class="border-bottom collapse show"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 0.8rem !important">
											<div class="table-responsive">
												<div id="order-listing_wrapper"
													class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
													<div class="row">
														<div class="col-sm-12">
															<div class="d-flex flex-row-reverse form-group col">
																<button type="button" class="btn btn-outline-success btn-fw" 
																	onclick="location.href='<%=request.getContextPath()%>/file-template'">
																	CREATE TEMPLATE
																</button>
															</div>

															<table id="order-listing"
																class="table dataTable no-footer table-striped" role="grid"
																aria-describedby="order-listing_info">
																<thead>
																	<tr role="row">
																		<th tabindex="0"
																			rowspan="1" colspan="1"
																			style="width: 60.1719px;">Actions</th>
																		<th class="sorting" tabindex="0"
																			aria-controls="order-listing" rowspan="1" colspan="1"
																			aria-label="Purchased On: activate to sort column ascending"
																			style="width: 113.25px;">File template name</th>
																		<th class="sorting" tabindex="0"
																			aria-controls="order-listing" rowspan="1" colspan="1"
																			aria-label="Customer: activate to sort column ascending"
																			style="width: 80.2969px;">Extension</th>
																		<th class="sorting" tabindex="0"
																			aria-controls="order-listing" rowspan="1" colspan="1"
																			aria-label="Ship to: activate to sort column ascending"
																			style="width: 54.7031px;">Description</th>
																		<th class="sorting" tabindex="0"
																			aria-controls="order-listing" rowspan="1" colspan="1"
																			aria-label="Purchased Price: activate to sort column ascending"
																			style="width: 129.797px;">Update date</th>
																		<th class="sorting" tabindex="0"
																			aria-controls="order-listing" rowspan="1" colspan="1"
																			aria-label="Purchased Price: activate to sort column ascending"
																			style="width: 129.797px;">Is file system</th>
																		<th class="sorting" tabindex="0"
																			aria-controls="order-listing" rowspan="1" colspan="1"
																			aria-label="Status: activate to sort column ascending"
																			style="width: 55.3125px;">Delete</th>
																	</tr>
																</thead>
																<tbody>

																	<c:forEach var="itemFileTemplate"
																		items="${listFileTemplate.getContent()}" varStatus="loop">
																		<tr role="row" class="${(loop.index + 1) % 2 == 0 ? 'odd' : 'even'}">
																			<td>
																				<button class="btn btn-outline-info btn-sm" 
																					onclick=" window.open('<%=request.getContextPath()%>/file-template/${itemFileTemplate.fileTemplateId}','_blank')">
																					View
																				</button>

																				<button class="btn btn-outline-primary btn-sm" 
																					onclick=" window.open('<%=request.getContextPath()%>/generate-file-template/${itemFileTemplate.fileTemplateId}','_blank')">
																					Generate
																				</button>
																			</td>
																			<td>
																				<a class="nav-link" target="_blank" href="<%=request.getContextPath()%>/generate-file-template/${itemFileTemplate.fileTemplateId}">
																					${itemFileTemplate.fileTemplateName}
																				</a>
																			</td>
																			<td>${itemFileTemplate.fileTemplateExtension}</td>
																			<td>${itemFileTemplate.fileDescription}</td>
																			<td>${itemFileTemplate.formatUpdtDt}</td>
																			<td>
																				<label class="toggle-switch"> 
																					<input type="checkbox" 
																						id="inputIsFileSystem${loop.index + 1}"
																						onClick="changeInfoFileSystem(this, ${itemFileTemplate.fileTemplateId})"
																						<c:if test="${itemFileTemplate.isFileSystem}">checked</c:if>
																						value="${itemFileTemplate.isFileSystem}">
																					<span class="toggle-slider round"></span>
																				</label>
																			</td>
																			<td>
																				<button type="button" class="btn btn-outline-danger btn-fw btn-sm"
																					onClick="deleteFileTemplate(${itemFileTemplate.fileTemplateId})">Delete</button>
																			</td>
																		</tr>
																	</c:forEach>

																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>

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
		displayBtnScroll(false);

		// Handle delete file template
		function deleteFileTemplate(fileTemplateId) {
			showSwalDeleteParam(fileTemplateId);
		}

		// Popup confirm delete parameter
		function showSwalDeleteParam(fileTemplateId) {
		      swal({
		        title: 'Do you want to delete?',
		        // text: "You won't be able to revert this!",
		        text: " ",
		        icon: 'warning',
		        showCancelButton: true,
		        confirmButtonColor: '#3f51b5',
		        cancelButtonColor: '#ff4081',
		        confirmButtonText: 'Great ',
		        buttons: {
		          cancel: {
		            text: "Cancel",
		            value: "CANCEL",
		            visible: true,
		            className: "btn btn-danger",
		            closeModal: true,
		          },
		          confirm: {
		            text: "OK",
		            value: "OK",
		            visible: true,
		            className: "btn btn-primary",
		            closeModal: true
		          }
		        }
		      }).then(function(inputValue) {
		    	   if (inputValue == 'OK') {
		    		   $.ajax({ 
		                   type: "DELETE", 
		                   url: contextPath + '/delete-file-template/' + fileTemplateId, 
		                   contentType: "application/json",
		                   success: function(data) {
		                       // Ajax call completed successfully 
		                       showToastSaveSuccess('bottom-right');
		                       setTimeout(function() {
		                    	   // Refresh the page
			                       location.reload();
		                       }, 1000);
		                   }, 
		                   error: function(data) {
		                   	   showToastSaveFailure('bottom-right');
		                   },
		                   complete: function(){
		                   }
		               });
		    	   } else if (inputValue == 'CANCEL') {
		    	   }
		      });
		}

		// ALert save successfully
		showToastSaveSuccess = function(position, message) {
		    'use strict';
		    resetToastPosition();
		    $.toast({
		      heading: 'Success',
		      text: message ? message : 'You have delete successfully!',
		      position: String(position),
		      icon: 'success',
		      stack: false,
		      loaderBg: '#f96868'
		    })
		}

		// ALert save failure
		showToastSaveFailure = function(position, message) {
		    'use strict';
		    resetToastPosition();
		    $.toast({
		      heading: 'Failure',
		      text: !message ? 'You have failed to delete!' : message,
		      position: String(position),
		      icon: 'error',
		      stack: false,
		      loaderBg: '#f96868'
		    })
		}

		// Handling change info is file name system
		function changeInfoFileSystem(inputIsFileSystem, fileTemplateId) {
			swal({
		        title: 'Do you want to set this is file system?',
		        // text: "You won't be able to revert this!",
		        text: " ",
		        icon: 'warning',
		        showCancelButton: true,
		        confirmButtonColor: '#3f51b5',
		        cancelButtonColor: '#ff4081',
		        confirmButtonText: 'Great ',
		        buttons: {
		          cancel: {
		            text: "Cancel",
		            value: "CANCEL",
		            visible: true,
		            className: "btn btn-danger",
		            closeModal: true,
		          },
		          confirm: {
		            text: "OK",
		            value: "OK",
		            visible: true,
		            className: "btn btn-primary",
		            closeModal: true
		          }
		        }
		      }).then(function(inputValue) {
		    	   if (inputValue == 'OK') {
			   			var isFileSystem = $("#" + inputIsFileSystem.id).is(":checked");
			   			var data = {
			   				IS_FILE_SYSTEM: isFileSystem
			   			};
			   			$.ajax({ 
		                   type: "PUT", 
		                   url: contextPath + '/set-system-file-template/' + fileTemplateId, 
		                   contentType: "application/json",
		                   data : JSON.stringify(data),
		                   success: function(data) {
		                       // Ajax call completed successfully 
		                       showToastSaveSuccess('bottom-right', 'Set file system is successfully!');
		                   }, 
		                   error: function(data) {
		                   	showToastSaveFailure('bottom-right', 'Set file system is failure!');
		                   },
		                   complete: function(){
		                   }
		               });
		    	   } else if (inputValue == 'CANCEL') {
		    			$("#" + inputIsFileSystem.id).prop('checked', !$("#" + inputIsFileSystem.id).is(":checked"));
		    	   }
		    });

		}
	</script>

</body>

</html>