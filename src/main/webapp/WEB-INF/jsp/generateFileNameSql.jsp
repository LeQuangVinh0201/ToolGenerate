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
	#FILE_NAME_SQL {
		line-height: 1.7 !important;
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
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-2"> <span
														style="font-weight: bold; color: black;">FILE NAME SQL</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<!-- Adding show into end class, to collapse div -->
									<div id="collapseOne-2" class="border-bottom collapse show"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">
											<nav>
												<div class="nav nav-tabs" id="nav-tab" role="tablist" style="margin-bottom: 15px; font-size: 14px;">
													<a class="nav-link active" id="nav-nexthr-core-tab"
														data-bs-toggle="tab" href="#nav-nexthr-core" role="tab"
														aria-controls="nav-nexthr-core" aria-selected="true">NextHR Core</a> 
													<a
														class="nav-link" id="nav-hr-core-tab" data-bs-toggle="tab"
														href="#nav-hr-core" role="tab" aria-controls="nav-hr-core"
														aria-selected="false">HR Core</a> 
												</div>
											</nav>
											<div class="tab-content">
											
												<div class="tab-pane fade show active" id="nav-nexthr-core"
													role="tabpanel" aria-labelledby="nav-nexthr-core-tab">
													<div class="row">
														<div class="col-md-8">
															<div class="form-group">
																<label for="exampleInputEmail3">Branch name<code>*</code></label>
																<input type="text" class="form-control"
																	id="BRANCH_NAME_NEXTHR_CORE" placeholder="Branch name">
																<code id="BRANCH_NAME_NEXTHR_CORE_MESSAGE"></code>
															</div>
														</div>
														<div class="col-md-2">
															<div class="form-group">
																<label for="exampleInputEmail3">Version year<code>*</code></label>
																<input type="number" class="form-control" value="24"
																	id="VERSION_YEAR_NEXTHR_CORE" placeholder="Version">
																<code id="VERSION_YEAR_NEXTHR_CORE_MESSAGE"></code>
															</div>
														</div>
														<div class="col-md-2">
															<div class="form-group">
																<label for="exampleInputEmail3">Version sql<code>*</code></label>
																<input type="number" class="form-control" value="1"
																	id="VERSION_NEXTHR_CORE" placeholder="Version">
																<code id="VERSION_NEXTHR_CORE_MESSAGE"></code>
															</div>
														</div>
														<div class="col-md-12">
															<div class="align-self-end" style="margin-bottom: 0.3rem;">
																<button type="button"
																	id="btnGenerateFileNameSqlNextHRCore"
																	class="btn btn-primary mr-2">
																	<i class="fa fa-magic"></i> GENERATE
																</button>

																<button type="button"
																	id="btnRefreshFileNameSqlNextHrCore"
																	class="btn btn-info mr-2">
																	<i class="fa fa-refresh"></i> RESET
																</button>
															</div>
														</div>
													</div>
												</div>

												<div class="tab-pane fade" id="nav-hr-core" role="tabpanel"
													aria-labelledby="nav-hr-core-tab">
													<div class="row">
														<div class="col-md-10">
															<div class="form-group">
																<label for="exampleInputEmail3">Branch name<code>*</code></label>
																<input type="text" class="form-control"
																	id="BRANCH_NAME_HR_CORE" placeholder="Branch name">
																<code id="BRANCH_NAME_HR_CORE_MESSAGE"></code>
															</div>
														</div>
														<div class="col-md-2">
															<div class="form-group">
																<label for="exampleInputEmail3">Version sql<code>*</code></label>
																<input type="number" class="form-control" value="1"
																	id="VERSION_HR_CORE" placeholder="Version">
																<code id="VERSION_HR_CORE_MESSAGE"></code>
															</div>
														</div>
														<div class="col-md-12">
															<div class="align-self-end" style="margin-bottom: 0.3rem;">
																<button type="button"
																	id="btnGenerateFileNameSqlHRCore"
																	class="btn btn-primary mr-2">
																	<i class="fa fa-magic"></i> GENERATE
																</button>

																<button type="button"
																	id="btnRefreshFileNameSqlHrCore"
																	class="btn btn-info mr-2">
																	<i class="fa fa-refresh"></i> RESET
																</button>
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
						
						
						<div class="col-12 grid-margin stretch-card d-none" id="nav-tabContent">
							<div class="card border-primary">
								<div class="card-body">
									<div class="form-group">
										<label for="exampleInputEmail3">Result file name sql : </label>
										<textarea class="form-control" id="FILE_NAME_SQL"
											rows="3" placeholder="File name sql"></textarea>
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
		var functionClickTextarea;
		$(document).ready(function() {
			// Turn on button scroll top and scroll botton
			displayBtnScroll(true);

			// Event click textarea
			var arrayTextAreaOutput = document.getElementById("nav-tabContent").querySelectorAll("textarea");
			arrayTextAreaOutput.forEach(textarea => {
				// Set attribute event click inside tag textarea
				textarea.removeAttribute('onclick');
				textarea.setAttribute('onClick', 'functionClickTextarea(this);');
			});

			// Event click btn generate file name sql NextHR Core
			$("#BRANCH_NAME_NEXTHR_CORE").on('keyup', function (e) {
			    if (e.key === 'Enter' || e.keyCode === 13) {
			    	$("#btnGenerateFileNameSqlNextHRCore").click();
			    }
			});

			// Event click btn generate file name sql NextHR Core
			$("#btnGenerateFileNameSqlNextHRCore").click(function() {
				$("#BRANCH_NAME_NEXTHR_CORE_MESSAGE").text($("#BRANCH_NAME_NEXTHR_CORE").val() ? '' : 'Branch name is required.');
				$("#VERSION_NEXTHR_CORE_MESSAGE").text($("#VERSION_NEXTHR_CORE").val() ? '' : 'Version is required.');
				$("#VERSION_YEAR_NEXTHR_CORE_MESSAGE").text($("#VERSION_YEAR_NEXTHR_CORE").val() ? '' : 'Version is required.');

				if ($("#BRANCH_NAME_NEXTHR_CORE").val() && $("#VERSION_NEXTHR_CORE").val()) {
					// Create object data to generate
					var data = {
					  BRANCH_NAME_NEXTHR_CORE: $("#BRANCH_NAME_NEXTHR_CORE").val() || null,
					  VERSION_NEXTHR_CORE: $("#VERSION_NEXTHR_CORE").val() || null,
					  VERSION_YEAR_NEXTHR_CORE: $("#VERSION_YEAR_NEXTHR_CORE").val() || null
					}
					
					$.ajax({ 
		                type: "POST", 
		                url: contextPath + '/generate-file-name-sql', 
		                contentType: "application/json",
		                data: JSON.stringify(data), 
		                success: function(data) {
		                	// Show div output
		                	$("#nav-tabContent").removeClass('d-none');
		                    // Ajax call completed successfully 
		                    showToastSaveSuccess('bottom-right', 'You have generate successfully!');
		                    // Set text output
		                    $("#FILE_NAME_SQL").val(data || '');
		                }, 
		                error: function(data) {
		               		showToastSaveFailure('bottom-right', 'Generate file failed!');
		               		$("#FILE_NAME_SQL").val('');
		                },
		                complete: function(){
		                }
		            });
				}
			});

			// Click btn refresh
			$("#btnRefreshFileNameSqlNextHrCore").click(function() {
				window.location.href= "<%=request.getContextPath()%>/generate-file-name-sql";
			});

			// Event click btn generate file name sql HR Core
			$("#btnGenerateFileNameSqlHRCore").click(function() {
				$("#BRANCH_NAME_HR_CORE_MESSAGE").text($("#BRANCH_NAME_HR_CORE").val() ? '' : 'Branch name is required.');
				$("#VERSION_HR_CORE_MESSAGE").text($("#VERSION_HR_CORE").val() ? '' : 'Version is required.');
				if ($("#BRANCH_NAME_HR_CORE").val() && $("#VERSION_HR_CORE").val()) {
					// Create object data to generate
					alert('generate hr core');
					/* var data = {
					  BIZACTOR_INPUT: bizactorInput || null,
					  COMPA_POSITION: $("#COMPA_POSITION").val() || null
					}
					
					$.ajax({ 
		                type: "POST", 
		                url: contextPath + '/generate-dataset-column-model', 
		                contentType: "application/json",
		                data: JSON.stringify(data), 
		                success: function(data) {
		                    // Ajax call completed successfully 
		                    showToastSaveSuccess('bottom-right', 'You have generate successfully!');
		                    // Set text output
		                    $("#FILE_NAME_SQL").val(data.FILE_NAME_SQL || '');
		                }, 
		                error: function(data) {
		               		showToastSaveFailure('bottom-right', 'Generate file failed!');
		                },
		                complete: function(){
		                }
		            }); */
				}
			});

			// Click btn refresh
			$("#btnRefreshFileNameSqlHrCore").click(function() {
				window.location.href= "<%=request.getContextPath()%>/generate-file-name-sql";
			});
		});

		// Handle event click textarea
		functionClickTextarea =  function(textarea) {
			// select text inside textarea
			if (!textarea.value) {
				return;
			}
			textarea.select();
		    document.execCommand('copy');
		    showToastInfo('bottom-left', 'Data has been copied!');
		}

		// ALert save successfully
		var showToastSaveSuccess = function(position, message) {
		    'use strict';
		    resetToastPosition();
		    $.toast({
		      heading: 'Success',
		      text: message ? message : 'You have saved successfully!',
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
		      text: !message ? 'You have failed to save!' : message,
		      position: String(position),
		      icon: 'error',
		      stack: false,
		      loaderBg: '#f96868'
		    })
		}

		// ALert save successfully
		var showToastInfo = function(position, message, isShowHeader) {
		    'use strict';
		    resetToastPosition();
		    $.toast({
		      heading: isShowHeader ? 'Info' : '',
		      text: message ? message : 'Info!',
		      position: String(position),
		      icon: 'info',
		      stack: false,
		      loaderBg: '#f96868'
		    })
		}
	</script>

</body>

</html>