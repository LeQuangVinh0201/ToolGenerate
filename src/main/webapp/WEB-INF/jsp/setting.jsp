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
														style="font-weight: bold; color: black;">FILE TEMPLATE TO CREATE CM MESSAGE</span>
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
														<div class="col-md-12">
															<div class="form-group">
																<label for="exampleInputEmail3">File template name<code>*</code></label>
																<select class="form-control input-select2" id="SETTING_CM_MESSAGE_NEXTHR_CORE" data-placeholder="Please choose">
																	<option disabled selected value></option>
																	<c:forEach var="itemFileTemplate"
																		items="${listFileTemplate.getContent()}" varStatus="loop">
																		<option value="${itemFileTemplate.fileTemplateId}" 
																			<c:if test="${settingCreateCmMessageForNextHRCore != null && itemFileTemplate.fileTemplateId == settingCreateCmMessageForNextHRCore.value}">selected</c:if>>
																			${itemFileTemplate.fileTemplateName}
																		</option>
																	</c:forEach>
																	
																</select>
																<code id="SETTING_CM_MESSAGE_NEXTHR_CORE_MESSAGE"></code>
															</div>
														</div>
														<div class="col-md-12">
															<div class="align-self-end" style="margin-bottom: 0.3rem;">
																<button type="button"
																	id="btnSettingCmMessageNextHRCore"
																	class="btn btn-primary mr-2">
																	<i class="fa fa-save"></i> SAVE
																</button>
															</div>
														</div>
													</div>
												</div>

												<div class="tab-pane fade" id="nav-hr-core" role="tabpanel"
													aria-labelledby="nav-hr-core-tab">
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label for="exampleInputEmail3">File template name<code>*</code></label>
																<select class="form-control input-select2" id="SETTING_CM_MESSAGE_HR_CORE" data-placeholder="Please choose">
																	<option disabled selected value></option>
																	<c:forEach var="itemFileTemplate"
																		items="${listFileTemplate.getContent()}" varStatus="loop">
																		<option value="${itemFileTemplate.fileTemplateId}" 
																			<c:if test="${settingCreateCmMessageForHRCore != null && itemFileTemplate.fileTemplateId == settingCreateCmMessageForHRCore.value}">selected</c:if>>
																			${itemFileTemplate.fileTemplateName}
																		</option>
																	</c:forEach>
																	
																</select>
																<code id="SETTING_CM_MESSAGE_HR_CORE_MESSAGE"></code>
															</div>
														</div>
														<div class="col-md-12">
															<div class="align-self-end" style="margin-bottom: 0.3rem;">
																<button type="button"
																	id="btnSettingCmMessageHRCore"
																	class="btn btn-primary mr-2">
																	<i class="fa fa-save"></i> SAVE
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

			// Init multiple Select2
			$('.input-select2').select2({
				theme: 'bootstrap-5',
			    placeholder: $( this ).data( 'placeholder' ),
			    width: "100%",
			    closeOnSelect: false,
			    allowClear: true,
			    maximumSelectionLength: 100
			});
			// Handle keep order element when add them
			$(".input-select2").on("select2:select", function (evt) {
				$(".select2-selection").css("overflow-y", "auto");

				var element = evt.params.data.element;
			  	var $element = $(element);
			  
			  	$element.detach();
			  	$(this).append($element);
			  	$(this).trigger("change");
			});

			// Handling event click btn setting cm message for NextHr Core
			$("#btnSettingCmMessageNextHRCore").click(function() {
				$("#SETTING_CM_MESSAGE_NEXTHR_CORE_MESSAGE").text(!isEmpty($("#SETTING_CM_MESSAGE_NEXTHR_CORE").val()) ? '' : 'This is required.');

				// Handling
				if (!isEmpty($("#SETTING_CM_MESSAGE_NEXTHR_CORE").val())) {
					// Create object data to generate
					var data = {
						FILE_TEMPLATE_ID : $("#SETTING_CM_MESSAGE_NEXTHR_CORE").val() || null
					};

					$.ajax({
						type : "PUT",
						url : contextPath + '/setting-file-cm-message-nexthr-core',
						contentType : "application/json",
						data : JSON.stringify(data),
						success : function(data) {
							// Ajax call completed successfully 
							showToastSaveSuccess('bottom-right', 'You have save successfully!');
						},
						error : function(data) {
							showToastSaveFailure('bottom-right', 'You have save failed!');
						},
						complete : function() {
						}
					});
				}
			});

			// Handling event click btn setting cm message for Hr Core
			$("#btnSettingCmMessageHRCore").click(function() {
				$("#SETTING_CM_MESSAGE_HR_CORE_MESSAGE").text(!isEmpty($("#SETTING_CM_MESSAGE_HR_CORE").val()) ? '' : 'This is required.');

				// Handling
				if (!isEmpty($("#SETTING_CM_MESSAGE_HR_CORE").val())) {
					// Create object data to generate
					var data = {
						FILE_TEMPLATE_ID : $("#SETTING_CM_MESSAGE_HR_CORE").val() || null
					};

					$.ajax({
						type : "PUT",
						url : contextPath + '/setting-file-cm-message-hr-core',
						contentType : "application/json",
						data : JSON.stringify(data),
						success : function(data) {
							// Ajax call completed successfully 
							showToastSaveSuccess('bottom-right', 'You have save successfully!');
						},
						error : function(data) {
							showToastSaveFailure('bottom-right', 'You have save failed!');
						},
						complete : function() {
						}
					});
				}
			});
		});


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