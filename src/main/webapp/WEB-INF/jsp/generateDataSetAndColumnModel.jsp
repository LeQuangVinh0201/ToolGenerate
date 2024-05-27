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
	#CODE_DATASET, #CODE_COLUMN_MODEL{
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
														style="font-weight: bold; color: black;">BIZACTOR INPUT</span>
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
											<div class="row">
												<div class="col-12">
													<div class="form-group" style="margin-bottom: 0.3rem;">
														<label for="exampleTextarea1">Please enter<code>*</code></label>
														<textarea class="form-control" id="BIZACTOR_INPUT"
															rows="8" placeholder="File description"></textarea>
														<code id="BIZACTOR_INPUT_MESSAGE"></code>
													</div>
												</div>
												<div class="col-12">
													<div class="row">
														<div class="col-12" style="max-width: 200px;">
															<div class="form-group" style="margin-bottom: 0.3rem;">
																<label for="exampleTextarea1">Comma position<code>*</code></label>
																<select class="form-control" id="COMPA_POSITION">
																	<option value="LEFT" selected>, Left postition</option>
																	<option value="RIGHT">Right postition
																		,</option>
																</select>
															</div>
														</div>
														<div class="align-self-end" style="margin-bottom: 0.3rem;">
															<button type="button"
																id="btnGenerateDatasetAndColumnModel"
																class="btn btn-primary mr-2">
																<i class="fa fa-code"></i> GENERATE
															</button>
															
															<button type="button"
																id="btnRefreshDataSetAndColumnModel"
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

						<div class="col-12 grid-margin stretch-card d-none" id="divOutputDataSetAndColumnModel">
							<div class="card border-primary">
								<div class="card-body">
								
									<nav>
										<div class="nav nav-tabs" id="nav-tab" role="tablist" style="margin-bottom: 15px; font-size: 14px;">
											<a class="nav-link active" id="nav-dataset-tab"
												data-bs-toggle="tab" href="#nav-dataset" role="tab"
												aria-controls="nav-dataset" aria-selected="true">DataSet</a> 
											<a
												class="nav-link" id="nav-column-model-tab" data-bs-toggle="tab"
												href="#nav-column-model" role="tab" aria-controls="nav-column-model"
												aria-selected="false">Column Model</a> 
										</div>
									</nav>
									<div class="tab-content" id="nav-tabContent">
										<div class="tab-pane fade show active" id="nav-dataset"
											role="tabpanel" aria-labelledby="nav-dataset-tab">
											<div class="form-group">
												<textarea class="form-control" id="CODE_DATASET"
													rows="14" placeholder="Code dataset"></textarea>
											</div>
										</div>
										<div class="tab-pane fade" id="nav-column-model" role="tabpanel"
											aria-labelledby="nav-column-model-tab">
											
											<div class="form-group">
												  <textarea class="form-control" id="CODE_COLUMN_MODEL"
													rows="14" placeholder="Code column model"></textarea>
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
		var functionClickTextarea;
		$(document).ready(function() {
			// Turn on button scroll top and scroll botton
			displayBtnScroll(true);

			// Click btn refresh
			$("#btnRefreshDataSetAndColumnModel").click(function() {
				window.location.href= "<%=request.getContextPath()%>/generate-dataset-column-model";
			});

			// Event click textarea
			var arrayTextAreaOutput = document.getElementById("nav-tabContent").querySelectorAll("textarea");
			arrayTextAreaOutput.forEach(textarea => {
				// Set attribute event click inside tag textarea
				textarea.removeAttribute('onclick');
				textarea.setAttribute('onClick', 'functionClickTextarea(this);');
			});
			
			// Event click btn generate dataset and column model
			$("#btnGenerateDatasetAndColumnModel").click(function() {
				generateDatasetAndColumnModel($("#BIZACTOR_INPUT").val());
			});

			// Function generate dataset and column model
			function generateDatasetAndColumnModel(bizactorInput) {
				$("#BIZACTOR_INPUT_MESSAGE").text(bizactorInput ? '' : 'Bizactor input is required.');
				if (bizactorInput) {
					generateDatasetAndColumnModels(bizactorInput);
				}
			}

		});

		// Generate dataset and column models
		function generateDatasetAndColumnModels(bizactorInput) {
			// Create object data to generate
			var data = {
			  BIZACTOR_INPUT: bizactorInput || null,
			  COMPA_POSITION: $("#COMPA_POSITION").val() || null
			}
			
			$.ajax({ 
                type: "POST", 
                url: contextPath + '/generate-dataset-column-model', 
                contentType: "application/json",
                data: JSON.stringify(data), 
                success: function(data) {
                	// Show div output
                	$("#divOutputDataSetAndColumnModel").removeClass('d-none');
                    // Ajax call completed successfully 
                    showToastSaveSuccess('bottom-right', 'You have generate successfully!');
                    // Set text output
                    $("#CODE_DATASET").val(data.STRING_DATASETS || '');
                    $("#CODE_COLUMN_MODEL").val(data.STRING_COLUMN_MODELS || '');
                    // Click button go to bottom
                    $("#btn-go-to-bottom").click();
                }, 
                error: function(data) {
               		showToastSaveFailure('bottom-right', 'Generate file failed!');
                },
                complete: function(){
                }
            });
		}

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