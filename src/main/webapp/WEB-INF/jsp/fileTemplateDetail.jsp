<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style>
#quillFileContent {
	height: 415px !important;
}

.form-group-param {
	margin-bottom: -15px !important;
}

.label-block {
	font-size: 0.875rem !important;
	line-height: 1.4rem !important;
	vertical-align: top !important;
	margin-bottom: 0.5rem !important;
}

.text-block {
	font-weight: 400 !important;
	font-size: 0.875rem !important;
}

.btn-delete-param {
	font-size: 1rem;
}
.btn.btn-icon, .ajax-upload-dragdrop .btn-icon.ajax-file-upload {
    width: 35px;
    height: 35px;
    padding: 0;
}
.fa-plus {
    padding-left: 1px;
}
.drop-zone {
	max-width: 100%;
  	height: 460px;
}
.drop-zone-overlay {
  	position: absolute;
    right: -3px;
    z-index: 10;
    top: 38px;
}
/* Extra screen device */
@media screen and (min-width: 1341px) {
	.btn-delete-param {
		margin-top: 30px;
	}
	.btn-delete-block {
		margin: auto 5px;
	}
	.btn-collapse-block {
		margin: auto 5px;
	}
	.btn-add-line-param {
		margin-top: 5px;
	}
}
/* Large screen device */
@media screen and (max-width: 1340px) {
	.btn-delete-param {
		margin-top: 0px;
	}
	.btn-delete-block {
		margin: auto 5px;
	}
	.btn-collapse-block {
		margin: auto 5px;
	}
	#leftRightBtn {
		display: none;
	}
	#fileTemplateDiv {
		display: block !important;
	}
}
/* Medium screen device */
@media screen and (max-width: 991.98px) {
	.btn-delete-param {
		margin-top: 0px;
	}
	.btn-delete-block {
		margin-bottom: 25px;
	}
	.btn-collapse-block {
		margin-bottom: 25px;
	}
}
</style>
<c:set var="indexParameter" value="1" scope="page" />
<!-- partial -->
<div class="content-wrapper">
	<div class="row">

		<div class="col-12">
			<div id="accordion" class="accordion">
				<div class="card border-primary">
					<div class="card-header border-bottom" id="headingOne-3"
						style="padding: 15px 15px 15px 28px; background-color: #e9eaeb !important;">
						<h5 class="mb-0">
							<div class="row">
								<div class="col">
									<!-- aria-expanded="false" -> icon -   else true -> icon +  -->
									<a aria-expanded="${isLayout ? true : true}" data-toggle="collapse"
										href="#collapseOne-2"> <span
										style="font-weight: bold; color: black;">FILE TEMPLATE</span>
									</a>
								</div>
							</div>
						</h5>
					</div>
					<!--  class="border-bottom collapse toggle" show or toggle or hide -->
					<div id="collapseOne-2" class="border-bottom collapse ${isLayout ? 'show' : 'show'}"
						aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
						style="">
						<div class="card-body" style="padding: 1.5rem 1.8rem !important">
						
						
							<form class="forms-sample">
								<div class="row">
									<div class="col-xl-4 col-lg-12" id="fileTemplateDiv">
										<div class="form-group">
											<label for="exampleInputName1">File template name<code>*</code></label>
											<input type="hidden" class="form-control"
												id="FILE_TEMPLATE_ID" placeholder="File template id">
											<input type="text" class="form-control"
												id="FILE_TEMPLATE_NAME" placeholder="File template name">
											<code id="FILE_TEMPLATE_NAME_MESSAGE"></code>
										</div>
										<div class="form-group">
											<label for="exampleInputEmail3">File extension<code>*</code></label>
											<input type="text" class="form-control"
												id="FILE_TEMPLATE_EXTENSION" placeholder="File extension">
											<code id="FILE_TEMPLATE_EXTENSION_MESSAGE"></code>
										</div>
										<div class="form-group">
											<label for="exampleTextarea1">Description<code>*</code></label>
											<textarea class="form-control" id="FILE_DESCRIPTION"
												rows="10" placeholder="File description"></textarea>
											<code id="FILE_DESCRIPTION_MESSAGE"></code>
										</div>

									</div>

									<div class="col-xl-8 col-lg-12" id="fileContentDiv">
										<nav>
											<div class="nav nav-tabs" id="nav-tab" role="tablist" style="margin-bottom: 15px;">
												<a class="nav-link active" id="nav-home-tab"
													data-bs-toggle="tab" href="#nav-home" role="tab"
													aria-controls="nav-home" aria-selected="true">Content</a> 
												<a
													class="nav-link" id="nav-profile-tab" data-bs-toggle="tab"
													href="#nav-profile" role="tab" aria-controls="nav-profile"
													aria-selected="false">Image</a> 
												<button type="button" id="leftRightBtn"
														class="btn btn-outline-secondary btn-sm btn-icon"
														style="height: 29px; margin-top: 5px; margin-left: 5px;">
														<i class="fa fa-caret-left"></i> <i
															class="fa fa-caret-right"></i>
												</button>
											</div>
										</nav>
										<div class="tab-content" id="nav-tabContent">
											<div class="tab-pane fade show active" id="nav-home"
												role="tabpanel" aria-labelledby="nav-home-tab">
												<div class="form-group">
													<div id="quillFileContent"
														class="quill-container ql-container ql-snow"></div>
													<code id="FILE_CONTENT_MESSAGE"></code>
												</div>
											</div>
											<div class="tab-pane fade" id="nav-profile" role="tabpanel"
												aria-labelledby="nav-profile-tab">
												
												<div class="form-group">
													  <div class="drop-zone-overlay">
														    <button type="button" class="btn btn-danger btn-rounded btn-icon" onClick="deleteImage()">
										                        <i class="fa fa-trash-o"></i>
										                    </button>
														</div>
													  <div class="drop-zone" id="divDropZone">
													    <span class="drop-zone__prompt">Drop file here or click to upload</span>
											    		<input id="fileInput" type="file" name="files" class="drop-zone__input" accept="image/*">
											    		<input type="hidden" class="form-control" id="FILE_TEMPLATE_UPLOAD_ID" placeholder="File template upload id">
													  </div>
												</div>
											</div>
										</div>

									</div>
								</div>
								<c:if test="${!infoFileTemplate.isFileSystem}">
									<button type="button" id="btnSaveFileTemplate"
										class="btn btn-primary mr-2">
										<i class="fa fa-save"></i> SAVE
									</button>
								</c:if>
								<button type="button" class="btn btn-secondary returnToListBtn">
									<i class="fa fa-caret-left"></i> RETURN TO LIST
								</button>
							</form>
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-12 grid-margin stretch-card">
			<div class="card border-primary">
				<div class="card-body">
					<h4 class="card-title">PARAMETERS</h4>
					<div id="divParameter">
						<div id="accordionBlock0" class="accordion">
							<div class="card border-primary">
								<div class="card-header border-bottom" id="headingOne-3"
									style="padding: 10px 29px 23px 28px; background-color: #e9eaeb !important;">
									<div class="form-group form-group-param row">
										<div class="d-flex align-items-center col-9">
											<span class="label-block" style="font-weight: bold;">NOT
												BELONG ANY BLOCK</span>
										</div>


										<div class="col d-flex flex-row-reverse">
											<button aria-expanded="true" data-toggle="collapse"
												href="#collapseOne-0" type="button"
												class="btn btn-outline-secondary btn-rounded btn-icon">
												<i class="fa fa-sort"></i>
											</button>
										</div>

									</div>
								</div>
								<div id="collapseOne-0" class="border-bottom collapse show"
									aria-labelledby="headingOne-3" data-bs-parent="#accordion-3">
									<div class="card-body"
										style="padding: 1.5rem 1.8rem !important">
										<div id="divBlock0">
											<c:forEach var="parameter"
												items="${infoFileTemplate.fileTemplateParametersWithBlock}">
												<c:if test="${parameter.parameterKey == null}">
													<c:forEach var="parameterChild"
														items="${parameter.fileTemplateParameters}">
														<div class="form-group form-group-param row"
															id="parameter${indexParameter}">

															<div class="form-group col-xl-3 col-lg-6">
																<label>Parameter key <code>*</code>
																</label> <input class="form-control"
																	id="inputParamNm${indexParameter}"
																	data-value="PARAMETER_KEY"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterKey}"> <input
																	type="hidden" class="form-control"
																	id="inputParamType${indexParameter}"
																	data-value="PARAMETER_TYPE"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterType}">
															</div>
															<div class="form-group col-xl-1 col-lg-6">
																<label for="exampleSelectGender">Required</label>
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
																</label> <input class="form-control"
																	id="inputParamDesc${indexParameter}"
																	data-value="PARAMETER_DESCRIPTION"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterDescription}">
															</div>
															<div class="form-group col-xl-4 col-lg-6">
																<label>Default value </label>
																<%-- <input
																	class="form-control"
																	id="inputParamDefaultValue${indexParameter}"
																	data-value="PARAMETER_DEFAULT_VALUE"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterDefaultValue}"> --%>
																<textarea 
																	class="form-control textarea-auto-height"
																	id="inputParamDefaultValue${indexParameter}"
																	data-value="PARAMETER_DEFAULT_VALUE"
																	data-group="paramGroup${indexParameter}">${parameterChild.parameterDefaultValue}</textarea>
															</div>
															<div class="d-flex flex-row-reverse form-group col" style="margin-right: -15px;">
															  <c:if test="${!infoFileTemplate.isFileSystem}">
															  <div class="btn-group-vertical" role="group" aria-label="Basic example" style="padding-top: 12px; height: 90px;">
															    <button type="button" data-value="btnMoveUpParam${indexParameter}" class="btn btn-outline-secondary btn-sm btn-icon" style="border-top-right-radius: 3px; border-top-left-radius: 3px; width: 30px;">
															      <i class="typcn typcn-arrow-sorted-up"></i>
															    </button>
															    <button type="button" data-value="btnMoveDownParam${indexParameter}" class="btn btn-outline-secondary btn-sm btn-icon" style="border-bottom-right-radius: 3px;border-bottom-left-radius: 3px; width: 30px;">
															      <i class="typcn typcn-arrow-sorted-down"></i>
															    </button>
															  </div>
															  </c:if>
															  <c:if test="${!infoFileTemplate.isFileSystem}">
															  <button type="button" style="margin-right: 11px" data-value="btnDeleteParam${indexParameter}" class="btn btn-outline-danger btn-rounded btn-icon btn-delete-param">
															    <i class="typcn typcn-trash"></i>
															  </button>
															  </c:if>
															</div>
														</div>
														<c:set var="indexParameter" value="${indexParameter + 1}"
															scope="page" />
													</c:forEach>
												</c:if>
											</c:forEach>
										</div>
										<c:if test="${!infoFileTemplate.isFileSystem}">
										<button type="button" data-value="addParamDiv0"
											class="btn btn-outline-info btn-rounded btn-icon btn-add-line-param">
											<i class="fa fa-plus"></i>
										</button>
										</c:if>

									</div>
								</div>
							</div>
						</div>


						<c:forEach var="parameter"
							items="${infoFileTemplate.fileTemplateParametersWithBlock}">

							<c:if test="${parameter.parameterKey != null}">

								<div id="accordionBlock${indexParameter}" class="accordion">
									<div class="card border-primary">
										<div class="card-header border-bottom" id="headingOne-3"
											style="padding: 10px 24px 7px 28px; background-color: #e9eaeb !important;">
											<h5 class="mb-0">
												<div class="form-group form-group-param row">

													<div class="form-group col-xl-3 col-lg-6">
														<label class="label-block" style="font-weight: bold;">BLOCK
															KEY <code>*</code>
														</label> <input class="form-control text-block"
															id="inputParamNm${indexParameter}"
															data-value="PARAMETER_KEY"
															data-group="paramGroup${indexParameter}"
															value="${parameter.parameterKey}"
															onchange="onChangeParameterKey(this)"> <input
															type="hidden" class="form-control"
															id="inputParamType${indexParameter}"
															data-value="PARAMETER_TYPE"
															data-group="paramGroup${indexParameter}"
															value="${parameter.parameterType}">
													</div>

													<div class="form-group col-xl-1 col-lg-6">
														<label class="label-block" for="exampleSelectGender">Required
														</label> <select class="form-control text-block"
															id="inputParamRequired${indexParameter}"
															data-value="PARAMETER_REQUIRED"
															data-group="paramGroup${indexParameter}">
															<c:forEach var="ynType" items="${ynType.ynTypes}">
																<option value="${ynType.ynValue}"
																	<c:if test="${ynType.ynValue == parameter.parameterRequired}"> selected </c:if>>${ynType.ynType}
																</option>
															</c:forEach>
														</select>
													</div>

													<div class="form-group col-xl-3 col-lg-6">
														<label class="label-block">Description <code>*</code>
														</label> <input class="form-control text-block"
															id="inputParamDesc${indexParameter}"
															data-value="PARAMETER_DESCRIPTION"
															data-group="paramGroup${indexParameter}"
															value="${parameter.parameterDescription}">
													</div>
													
													<div class="form-group col-xl-1 col-lg-6">
														<label class="label-block" for="exampleSelectGender">Open
														</label> <select class="form-control text-block"
															id="inputIsOpen${indexParameter}"
															data-value="IS_OPEN"
															data-group="paramGroup${indexParameter}">
															<c:forEach var="ynType" items="${ynType.ynTypes}">
																<option value="${ynType.ynValue}"
																	<c:if test="${ynType.ynValue == parameter.isOpen}"> selected </c:if>>${ynType.ynType}
																</option>
															</c:forEach>
														</select>
													</div>

													<div class="col-xl col-lg d-flex flex-row-reverse" style="height: 85px; margin-right: -15px;">
														<c:if test="${!infoFileTemplate.isFileSystem}">
														<div class="btn-group-vertical" role="group" aria-label="Basic example" style="padding-top: 12px; margin-left: 5px; margin-right: 5px;">
														  <button type="button" data-value="btnMoveUpBlock${indexParameter}" class="btn btn-outline-secondary btn-sm btn-icon" style="border-top-right-radius: 3px; border-top-left-radius: 3px; width: 30px;">
														    <i class="typcn typcn-arrow-sorted-up"></i>
														  </button>
														  <button type="button" data-value="btnMoveDownBlock${indexParameter}" class="btn btn-outline-secondary btn-sm btn-icon" style="border-bottom-right-radius: 3px;border-bottom-left-radius: 3px; width: 30px;">
														    <i class="typcn typcn-arrow-sorted-down"></i>
														  </button>
														</div>
														</c:if>
														<c:if test="${!infoFileTemplate.isFileSystem}">
														<button type="button"
															data-value="btnDeleteParam${indexParameter}"
															data-type="BLOCK"
															class="btn btn-outline-danger btn-rounded btn-icon btn-delete-block">
															<i class="typcn typcn-trash"
																style="font-size: 1.25rem !important;"></i>
														</button>
														</c:if>
														<button aria-expanded="true" data-toggle="collapse"
															href="#collapseOne-${indexParameter}" type="button"
															class="btn btn-outline-secondary btn-rounded btn-icon btn-collapse-block">
															<i class="fa fa-sort"></i>
														</button>

													</div>

												</div>
											</h5>
										</div>
										<div id="collapseOne-${indexParameter}"
											class="border-bottom collapse show"
											aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
											style="">

											<div class="card-body"
												style="padding: 1.5rem 1.8rem !important">
												<c:set var="tempIndexBlock" value="${indexParameter}"
													scope="page" />
												<div id="divBlock${indexParameter}">
													<c:forEach var="parameterChild"
														items="${parameter.fileTemplateParameters}">
														<c:set var="indexParameter" value="${indexParameter + 1}"
															scope="page" />
														<div class="form-group form-group-param row"
															id="parameter${indexParameter}">

															<div class="form-group col-xl-3 col-lg-6">
																<label>Parameter key <code>*</code>
																</label> <input class="form-control"
																	id="inputParamNm${indexParameter}"
																	data-value="PARAMETER_KEY"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterKey}"> <input
																	class="form-control" type="hidden"
																	id="inputBelongToTheBlock${indexParameter}"
																	data-value="BELONG_TO_THE_BLOCK"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.belongToTheBlock}"> <input
																	type="hidden" class="form-control"
																	id="inputParamType${indexParameter}"
																	data-value="PARAMETER_TYPE"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterType}">

															</div>
															<div class="form-group col-xl-1 col-lg-6">
																<label for="exampleSelectGender">Required
																</label> <select class="form-control text-block"
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
																</label> <input class="form-control"
																	id="inputParamDesc${indexParameter}"
																	data-value="PARAMETER_DESCRIPTION"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterDescription}">
															</div>
															<div class="form-group col-xl-4 col-lg-6">
																<label>Default value </label> 
																<%-- <input
																	class="form-control"
																	id="inputParamDefaultValue${indexParameter}"
																	data-value="PARAMETER_DEFAULT_VALUE"
																	data-group="paramGroup${indexParameter}"
																	value="${parameterChild.parameterDefaultValue}"> --%>
																
																<textarea 
																	class="form-control textarea-auto-height"
																	id="inputParamDefaultValue${indexParameter}"
																	data-value="PARAMETER_DEFAULT_VALUE"
																	data-group="paramGroup${indexParameter}">${parameterChild.parameterDefaultValue}</textarea>
															</div>

															<div class="d-flex flex-row-reverse form-group col" style="margin-right: -15px;">
															  <c:if test="${!infoFileTemplate.isFileSystem}">
															  <div class="btn-group-vertical" role="group" aria-label="Basic example" style="padding-top: 12px; height: 90px;">
																<button type="button" data-value="btnMoveUpParam${indexParameter}" class="btn btn-outline-secondary btn-sm btn-icon" style="border-top-right-radius: 3px; border-top-left-radius: 3px; width: 30px;">
																  <i class="typcn typcn-arrow-sorted-up"></i>
																</button>
																<button type="button" data-value="btnMoveDownParam${indexParameter}" class="btn btn-outline-secondary btn-sm btn-icon" style="border-bottom-right-radius: 3px;border-bottom-left-radius: 3px; width: 30px;">
																  <i class="typcn typcn-arrow-sorted-down"></i>
																</button>
															  </div>
															  </c:if>
															  <c:if test="${!infoFileTemplate.isFileSystem}">
															  <button style="margin-right: 11px" type="button" data-value="btnDeleteParam${indexParameter}" class="btn btn-outline-danger btn-rounded btn-icon btn-delete-param">
																<i class="typcn typcn-trash"></i>
															  </button>
															  </c:if>
															</div>
															
														</div>

													</c:forEach>
												</div>
												<c:if test="${!infoFileTemplate.isFileSystem}">
												<button type="button"
													data-value="addParamDiv${tempIndexBlock}"
													class="btn btn-outline-info btn-rounded btn-icon btn-add-line-param">
													<i class="fa fa-plus"></i>
												</button>
												</c:if>
											</div>
										</div>
									</div>
								</div>
							</c:if>
							<c:set var="indexParameter" value="${indexParameter + 1}"
								scope="page" />
						</c:forEach>
					</div>

					<c:if test="${!infoFileTemplate.isFileSystem}">
					<button type="button" class="btn btn-info" id="addBlockBtn">
						<i class="fa fa-plus"></i> BLOCK
					</button>
					<button type="submit" class="btn btn-primary mr-2"
						disabled="disabled" id="saveParamsBtn">
						<i class="fa fa-save"></i> SAVE
					</button>
					</c:if>
					<button type="button" class="btn btn-secondary returnToListBtn">
						<i class="fa fa-caret-left"></i> RETURN TO LIST
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- content-wrapper ends -->

<script type="text/javascript">
	var onChangeParameterKey;
	var deleteImage;
	$( document ).ready(function() {
		displayBtnScroll(true);

		// Active tab
      	function activaTab(tab){
		    $('.nav-tabs a[href="#' + tab + '"]').tab('show');
		};

		// Init variable
		var indexParameter = 1;
		var quillFileContent;
		var isUpdatePathvariable = ${infoFileTemplate == null} || ${infoFileTemplate.fileTemplateId == null} || ${infoFileTemplate.fileTemplateId <= 0};
		var jsIndexParameter = ${indexParameter + 1};

		// Init quill ckeditor file content
		if ($("#quillFileContent").length) {
			quillFileContent = new Quill('#quillFileContent', {
		      modules: {
		        toolbar: [
		          ['code-block'],
		          ['bold', 'italic', 'underline', { 'size': ['small', false, 'large', 'huge'] }],
		          [{ 'color': [] }, { 'background': [] }, 'clean'],
		        ]
		      },
		      placeholder: 'Please enter information file template...',
		      theme: 'snow',
		      readOnly: false
		    });
		}
		
		// Setting info file template if exists data else new page
		function renderFileTemplate() {
			if (${infoFileTemplate != null} && ${infoFileTemplate.fileTemplateId != null} && ${infoFileTemplate.fileTemplateId > 0}) {
				// Enable button save parameters after create file template
				$("#saveParamsBtn").prop('disabled', false);

				// Set data info DIV FILE TEMPLATE
				$("#FILE_TEMPLATE_ID").val("${infoFileTemplate.fileTemplateId}");
				$("#FILE_TEMPLATE_NAME").val("${infoFileTemplate.fileTemplateName}");
				$("#FILE_TEMPLATE_EXTENSION").val("${infoFileTemplate.fileTemplateExtension}");
				$("#FILE_DESCRIPTION").val("${infoFileTemplate.fileDescription}");
				$("#FILE_TEMPLATE_UPLOAD_ID").val(${infoFileTemplate.fileTemplateDocumentStorages.size() > 0 ? infoFileTemplate.fileTemplateDocumentStorages[0].id : ''});
				// Set data quill editor for TEMPLATE CONTENT
				quillFileContent.setContents(${infoFileTemplate.fileContentFormat != null ? infoFileTemplate.fileContentFormat.replace("</script>", "<\\/script>") : null});

				// Set image thumnail
				setThumbnail($("#divDropZone")[0]
							, "${infoFileTemplate.fileTemplateDocumentStorages.size() > 0 ? infoFileTemplate.fileTemplateDocumentStorages[0].originalName : ''}"
							, "/file" + "${infoFileTemplate.fileTemplateDocumentStorages.size() > 0 ? infoFileTemplate.fileTemplateDocumentStorages[0].path : ''}"
				);				
			}
		}
		renderFileTemplate();
		
		// Handle event click button add block
		$("#addBlockBtn").click(function() {
			$("#divParameter").append(' <div id="accordionBlock' + jsIndexParameter + '" class="accordion"> <div class="card border-primary"> <div class="card-header border-bottom" id="headingOne-3" style="padding: 10px 24px 7px 28px; background-color: #e9eaeb !important;"> <h5 class="mb-0"> <div class="form-group form-group-param row"> <div class="form-group col-xl-3 col-lg-6"> <label class="label-block" style="font-weight: bold;">BLOCK KEY <code>*</code> </label> <input class="form-control text-block" id="inputParamNm' + jsIndexParameter + '" data-value="PARAMETER_KEY" data-group="paramGroup' + jsIndexParameter +'" value="" onchange="onChangeParameterKey(this)"> <input type="hidden" class="form-control" id="inputParamType' + jsIndexParameter + '" data-value="PARAMETER_TYPE" data-group="paramGroup' + jsIndexParameter + '" value="BLOCK"> </div> <div class="form-group col-xl-1 col-lg-6"> <label class="label-block" for="exampleSelectGender">Required </label> <select class="form-control text-block" id="inputParamRequired' + jsIndexParameter + '" data-value="PARAMETER_REQUIRED" data-group="paramGroup' + jsIndexParameter + '"> <c:forEach var="ynType" items="${ynType.ynTypes}"> <option value="${ynType.ynValue}">${ynType.ynType} </option> </c:forEach> </select> </div> <div class="form-group col-xl-3 col-lg-6"> <label class="label-block">Description <code>*</code> </label> <input class="form-control text-block" id="inputParamDesc' + jsIndexParameter + '" data-value="PARAMETER_DESCRIPTION" data-group="paramGroup' + jsIndexParameter + '" value=""> </div> <div class="form-group col-xl-1 col-lg-6"> <label class="label-block" for="exampleSelectGender">Open </label> <select class="form-control text-block" id="inputIsOpen' + jsIndexParameter + '" data-value="IS_OPEN" data-group="paramGroup' + jsIndexParameter + '"> <c:forEach var="ynType" items="${ynType.ynTypes}"> <option value="${ynType.ynValue}" <c:if test="${ynType.ynValue == parameter.isOpen}"> selected </c:if>>${ynType.ynType} </option> </c:forEach> </select> </div> <div class="col-xl col-lg d-flex flex-row-reverse" style="height: 85px; margin-right: -15px;"> <c:if test="${!infoFileTemplate.isFileSystem}"><div class="btn-group-vertical" role="group" aria-label="Basic example" style="padding-top: 12px; margin-left: 5px; margin-right: 5px;"> <button type="button" data-value="btnMoveUpBlock' + jsIndexParameter + '" class="btn btn-outline-secondary btn-sm btn-icon" style="border-top-right-radius: 3px; border-top-left-radius: 3px; width: 30px;"> <i class="typcn typcn-arrow-sorted-up"></i> </button> <button type="button" data-value="btnMoveDownBlock' + jsIndexParameter + '" class="btn btn-outline-secondary btn-sm btn-icon" style="border-bottom-right-radius: 3px;border-bottom-left-radius: 3px; width: 30px;"> <i class="typcn typcn-arrow-sorted-down"></i> </button> </div> </c:if> <c:if test="${!infoFileTemplate.isFileSystem}"><button type="button" data-value="btnDeleteParam' + jsIndexParameter + '" data-type="BLOCK" class="btn btn-outline-danger btn-rounded btn-icon btn-delete-block"> <i class="typcn typcn-trash" style="font-size: 1.25rem !important;"></i> </button></c:if> <button aria-expanded="true" data-toggle="collapse" href="#collapseOne-' + jsIndexParameter + '" type="button" class="btn btn-outline-secondary btn-rounded btn-icon btn-collapse-block"> <i class="fa fa-sort"></i> </button> </div> </div> </h5> </div> <div id="collapseOne-'+ jsIndexParameter +'" class="border-bottom collapse show" aria-labelledby="headingOne-3" data-bs-parent="#accordion-3" style=""> <div class="card-body" style="padding: 1.5rem 1.8rem !important"> <div id="divBlock' + jsIndexParameter + '"></div> <c:if test="${!infoFileTemplate.isFileSystem}"><button type="button" data-value="addParamDiv' + jsIndexParameter + '" class="btn btn-outline-info btn-rounded btn-icon btn-add-line-param"> <i class="fa fa-plus"></i> </button> </c:if> </div> </div> </div> </div>');
			jsIndexParameter = jsIndexParameter + 1;
		});
		
		// Handle event click button in divParameter (for btnDelete, btnMoveUp, btnMoveDown, btnMoveUpBlock, btnMoveDownBlock...)
		$('#divParameter').on('click', 'button', function(e){
			var btnParam = e.currentTarget.getAttribute("data-value");
			var btnParamKey = e.currentTarget.getAttribute("data-type");

			// Click button delete parameter
			if (btnParam && (btnParam.length > 14 && btnParam.toLowerCase().includes("btndeleteparam".toLowerCase()))) {
				var indexBtnDelParam = btnParam.substring(14);
				showSwalDeleteParam(indexBtnDelParam, btnParamKey);
			}
			// Click button add parameter
			if (btnParam && (btnParam.length > 11 && btnParam.toLowerCase().includes("addParamDiv".toLowerCase()))) {
				var indexDivBlock = btnParam.substring(11);
				var valueNameBlock = $("#inputParamNm" + indexDivBlock) && $("#inputParamNm" + indexDivBlock).val() ? $("#inputParamNm" + indexDivBlock).val() : '';
				$("#divBlock" + indexDivBlock).append(' <div class="form-group form-group-param row" id="parameter' + jsIndexParameter + '"> <div class="form-group col-xl-3 col-lg-6"> <label>Parameter key <code>*</code> </label> <input class="form-control" id="inputParamNm' + jsIndexParameter + '" data-value="PARAMETER_KEY" data-group="paramGroup' + jsIndexParameter + '" value=""> <input class="form-control" type="hidden" id="inputBelongToTheBlock' + jsIndexParameter + '" data-value="BELONG_TO_THE_BLOCK" data-group="paramGroup' + jsIndexParameter + '" value="' + valueNameBlock + '"> <input type="hidden" class="form-control" id="inputParamType' + jsIndexParameter + '" data-value="PARAMETER_TYPE" data-group="paramGroup' + jsIndexParameter + '" value="PARAM"> </div> <div class="form-group col-xl-1 col-lg-6"> <label for="exampleSelectGender">Required</label> <select class="form-control text-block" id="inputParamRequired' + jsIndexParameter + '" data-value="PARAMETER_REQUIRED" data-group="paramGroup' + jsIndexParameter + '"> <c:forEach var="ynType" items="${ynType.ynTypes}"> <option value="${ynType.ynValue}">${ynType.ynType} </option> </c:forEach> </select> </div> <div class="form-group col-xl-3 col-lg-6"> <label>Description <code>*</code> </label> <input class="form-control" id="inputParamDesc' + jsIndexParameter + '" data-value="PARAMETER_DESCRIPTION" data-group="paramGroup' + jsIndexParameter + '" value=""> </div> <div class="form-group col-xl-4 col-lg-6"> <label>Default value </label> <!-- <input class="form-control" id="inputParamDefaultValue' + jsIndexParameter + '" data-value="PARAMETER_DEFAULT_VALUE" data-group="paramGroup' + jsIndexParameter + '" value=""> --> <textarea class="form-control textarea-auto-height" id="inputParamDefaultValue' + jsIndexParameter + '" data-value="PARAMETER_DEFAULT_VALUE" data-group="paramGroup' + jsIndexParameter + '"></textarea> </div> <div class="d-flex flex-row-reverse form-group col" style="margin-right: -15px;"><c:if test="${!infoFileTemplate.isFileSystem}"><div class="btn-group-vertical" role="group" aria-label="Basic example" style="padding-top:12px; height: 90px;"><button type="button" data-value="btnMoveUpParam' + jsIndexParameter + '" class="btn btn-outline-secondary btn-sm btn-icon" style="border-top-right-radius:3px;border-top-left-radius:3px; width: 30px;"><i class="typcn typcn-arrow-sorted-up"></i></button><button type="button" data-value="btnMoveDownParam' + jsIndexParameter + '" class="btn btn-outline-secondary btn-sm btn-icon" style="border-bottom-right-radius:3px;border-bottom-left-radius:3px; width: 30px;"><i class="typcn typcn-arrow-sorted-down"></i></button></div></c:if> <c:if test="${!infoFileTemplate.isFileSystem}"><button type="button" style="margin-right: 11px" data-value="btnDeleteParam' + jsIndexParameter + '" class="btn btn-outline-danger btn-rounded btn-icon btn-delete-param"><i class="typcn typcn-trash"></i></button></c:if></div> </div> ');
				// Call auto height textarea
				autoHeightTextarea();
				jsIndexParameter = jsIndexParameter + 1;
			}
			// Click button btnMoveUp parameter
			if (btnParam && (btnParam.length > 14 && btnParam.toLowerCase().includes("btnmoveupparam".toLowerCase()))) {
				var indexBtnMoveUpParam = btnParam.substring(14);
				
				let currentDivParameter = document.getElementById('parameter' + indexBtnMoveUpParam);
				let prevDivParameter = currentDivParameter.previousElementSibling;
				if (prevDivParameter == null) {
					showWarningToast('bottom-right', 'Currently in first place');
					return;
				}
				tdiv1 = currentDivParameter.cloneNode(true);
				tdiv2 = prevDivParameter.cloneNode(true);
				
				currentDivParameter.replaceWith(tdiv2);
				prevDivParameter.replaceWith(tdiv1);

				// Scroll element
				scrollElement(indexBtnMoveUpParam, currentDivParameter);
				
			}
			// Click button btnMoveDown parameter
			if (btnParam && (btnParam.length > 16 && btnParam.toLowerCase().includes("btnmovedownparam".toLowerCase()))) {
				var indexBtnMoveDownParam = btnParam.substring(16);
				
				let currentDivBlock = document.getElementById('parameter' + indexBtnMoveDownParam);
				let nextDivParameter = currentDivBlock.nextElementSibling;
				if (nextDivParameter == null) {
					showWarningToast('bottom-right', 'Currently in last place');
					return;
				}
				tdiv1 = currentDivBlock.cloneNode(true);
				tdiv2 = nextDivParameter.cloneNode(true);
				
				currentDivBlock.replaceWith(tdiv2);
				nextDivParameter.replaceWith(tdiv1);

				// Scroll element
				scrollElement(indexBtnMoveDownParam, currentDivBlock);
			}
			// Click button btnMoveUpBlock
			if (btnParam && (btnParam.length > 14 && btnParam.toLowerCase().includes("btnmoveupblock".toLowerCase()))) {
				var indexBtnMoveUpBlock = btnParam.substring(14);
				
				let currentDivParameter = document.getElementById('accordionBlock' + indexBtnMoveUpBlock);
				let prevDivBlock = currentDivParameter.previousElementSibling;
				if (prevDivBlock == null || prevDivBlock.id == 'accordionBlock0') {
					showWarningToast('bottom-right', 'Currently in first place');
					return;
				}
				tdiv1 = currentDivParameter.cloneNode(true);
				tdiv2 = prevDivBlock.cloneNode(true);
				
				currentDivParameter.replaceWith(tdiv2);
				prevDivBlock.replaceWith(tdiv1);

				// Scroll element
				scrollElement(indexBtnMoveUpBlock, currentDivParameter);
			}
			// Click button btnMoveDown block
			if (btnParam && (btnParam.length > 16 && btnParam.toLowerCase().includes("btnmovedownblock".toLowerCase()))) {
				var indexBtnMoveDownBlock = btnParam.substring(16);
				
				let currentDivBlock = document.getElementById('accordionBlock' + indexBtnMoveDownBlock);
				let nextDivBlock = currentDivBlock.nextElementSibling;
				if (nextDivBlock == null) {
					showWarningToast('bottom-right', 'Currently in last place');
					return;
				}
				tdiv1 = currentDivBlock.cloneNode(true);
				tdiv2 = nextDivBlock.cloneNode(true);
				
				currentDivBlock.replaceWith(tdiv2);
				nextDivBlock.replaceWith(tdiv1);

				// Scroll element
				scrollElement(indexBtnMoveDownBlock, currentDivBlock);
			}
		});
		
		// Scroll element
		function scrollElement(indexBtnMoveUpParam, currentDivParameter) {
			scrollSmothIntoElement(currentDivParameter.id);

			// Focus element border
			$("#inputParamNm" + indexBtnMoveUpParam).attr('style', 'border-color: red !important');
			$("#inputParamRequired" + indexBtnMoveUpParam).attr('style', 'border-color: red !important');
			$("#inputParamDesc" + indexBtnMoveUpParam).attr('style', 'border-color: red !important');
			$("#inputParamDefaultValue" + indexBtnMoveUpParam).attr('style', 'border-color: red !important');

			// Recall auto height
			setTimeout(function() {
				autoHeightTextarea();
			}, 100);

			// Remove focus element after 0.7s
			setTimeout(function() {
				$("#inputParamNm" + indexBtnMoveUpParam).css('border-color', '');
				$("#inputParamRequired" + indexBtnMoveUpParam).css('border-color', '');
				$("#inputParamDesc" + indexBtnMoveUpParam).css('border-color', '');
				$("#inputParamDefaultValue" + indexBtnMoveUpParam).css('border-color', '');
			}, 700);
		}

		// Function onchange key block
		onChangeParameterKey = function(paramKey){
			// Get data group from this param key input
			var dataGroupParamKey = paramKey.getAttribute("data-group");
			if (dataGroupParamKey && (dataGroupParamKey.length > 10 && dataGroupParamKey.toLowerCase().includes("paramGroup".toLowerCase()))) {
				var arrElementsInDivBlock = $("#divBlock" + dataGroupParamKey.substring(10) + " :input");
				for (const element of arrElementsInDivBlock) {
					console.log(element);
					if (element.getAttribute("data-value").toLowerCase().includes("BELONG_TO_THE_BLOCK".toLowerCase())) {
						 $("#" + element.id).val(paramKey.value);
					}
				}
			}
			
			
		}
		
		// Handle change select in divParameter
		$('#divParameter').on('change', 'select', function(e){
			var selectParam = e.currentTarget.id;

			// Select type parameter
			if (selectParam && (selectParam.length > 14 && selectParam.toLowerCase().includes("inputparamtype"))) {
				var indexSelectParam = selectParam.substring(14);
				var selectParamValue = e.currentTarget.value;
				if (selectParamValue == 'BLOCK') {
					$("#inputBelongToTheBlock" + indexSelectParam).val('');
					$("#inputBelongToTheBlock" + indexSelectParam).prop('readonly', true);

					$("#inputParamDefaultValue" + indexSelectParam).val(true);
					$("#inputParamDefaultValue" + indexSelectParam).prop('readonly', true);
				} else {
					$("#inputBelongToTheBlock" + indexSelectParam).prop('readonly', false);
					$("#inputParamDefaultValue" + indexSelectParam).prop('readonly', false);
					$("#inputParamDefaultValue" + indexSelectParam).val('');
				}
			}
		});
		
		// Popup confirm delete parameter
		function showSwalDeleteParam(indexBtnDelParam, btnParamKey) {
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
		    		   if (btnParamKey && btnParamKey == 'BLOCK') {
		    			   $("#accordionBlock" + indexBtnDelParam).remove();
		    		   } else {
		    			   $("#parameter" + indexBtnDelParam).remove();
		    		   }
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

		// ALert 
		showWarningToast = function(position, message) {
		    'use strict';
		    resetToastPosition();
		    $.toast({
		      heading: 'Warning',
		      text: !message ? 'Waring' : message,
		      showHideTransition: 'slide',
		      icon: 'warning',
		      loaderBg: '#57c7d4',
		      position: String(position)
		    })
		};

		// ALert must required
		showToastRequired = function(position) {
		    'use strict';
		    resetToastPosition();
		    $.toast({
		      heading: 'Failure',
		      text: 'Data is required!',
		      position: String(position),
		      icon: 'error',
		      stack: false,
		      loaderBg: '#f96868'
		    })
		}

		// Reset all code message error div file template
		function resetAllCodeMessFileTemplate() {
            $("#FILE_TEMPLATE_NAME_MESSAGE").text('');
            $("#FILE_TEMPLATE_EXTENSION_MESSAGE").text('');
            $("#FILE_DESCRIPTION_MESSAGE").text('');
            $("#FILE_CONTENT_MESSAGE").text('');
		}

		// Btn save file template
		function fnSaveFileTemplate() {
			var data = {
			  FILE_TEMPLATE_ID: $("#FILE_TEMPLATE_ID").val() || null,
			  FILE_TEMPLATE_NAME: $("#FILE_TEMPLATE_NAME").val(),
			  FILE_TEMPLATE_EXTENSION: $("#FILE_TEMPLATE_EXTENSION").val(),
			  FILE_DESCRIPTION: $("#FILE_DESCRIPTION").val(),
			  FILE_CONTENT: (quillFileContent && quillFileContent.getText()) ? quillFileContent.getText() : null,
			  FILE_CONTENT_FORMAT: (quillFileContent && quillFileContent.getContents()) ? JSON.stringify(quillFileContent.getContents()) : null,
			  FILE_TEMPLATE_UPLOAD_ID: $("#FILE_TEMPLATE_UPLOAD_ID").val() || null,
			  CUD_KEY: $("#FILE_TEMPLATE_ID").val() ? "UPDATE" : "CREATE"
			}
			// Reset all code message error div file template
			resetAllCodeMessFileTemplate();

			$.ajax({ 
                type: "POST", 
                url: contextPath + '/save-file-template', 
                contentType: "application/json",
                data: JSON.stringify(data), 
                success: function(data) {
                    // Ajax call completed successfully 
                    showToastSaveSuccess('bottom-right', 'You have saved file template successfully!');
                    // Insert vale FILE_TEMPLDATE_ID into input hidden. IF this input exists data then UPDATE else CREATE
                    $("#FILE_TEMPLATE_ID").val(data.FILE_TEMPLATE_ID);
                    // Enable button save parameters after create file template
                    $("#saveParamsBtn").prop('disabled', false);
                    
                    // Adding pathvariabe id after create
                    if (isUpdatePathvariable) {
                    	window.history.pushState({}, null, contextPath + '/file-template/' + data.FILE_TEMPLATE_ID);
                    	isUpdatePathvariable = false;
                    }
                    
                }, 
                error: function(data) {
                	showToastSaveFailure('bottom-right');
                    // Some error in ajax call 
                    if (data.status == 417) { // Error code 417 define exaclly fieldName and messageError
                    	var arrayErrors = data.responseJSON.errors;
                    	for(var i in arrayErrors) {  
                    		var item = arrayErrors[i]; 
                    		$('#' + item.fieldName + '_MESSAGE').text(item.messageError);
                    		activaTab("nav-home");
                    	}
                    }
                },
                complete: function(){
                }
            }); 
		}

		$("#btnSaveFileTemplate").click(function() {
			fnSaveFileTemplate();
			if ($("#FILE_TEMPLATE_ID") && $("#FILE_TEMPLATE_ID").val() != null && $("#FILE_TEMPLATE_ID").val() != 0) {
				fnSaveParam();
			}
		});

		// Click btn return to list
		$(".returnToListBtn").click(function() {
			window.location.href= "<%=request.getContextPath()%>/list-file-template";
		});

		function fnSaveParam() {
			// Get all element in div parameters to looping
			var arrElementsInDivParam = $("#divParameter :input");
			// Create new map to handle data-group element
			var mapDataGroup = new Map();
			for (const element of arrElementsInDivParam) {
				if (element.id) {
					// If not exists key data-group then create new key map with value is new array. After add first element
					if (!mapDataGroup.get(element.getAttribute('data-group'))) {
						// create new element object
						mapDataGroup.set(element.getAttribute('data-group'), {});
						// Put element
						mapDataGroup.get(element.getAttribute('data-group'))[element.getAttribute('data-value')] = $("#" + element.id).val();
						mapDataGroup.get(element.getAttribute('data-group'))['DATA_GROUP'] = element.getAttribute('data-group');
					} else {
						// If exists key then insert element into index 0 of map with this key
						mapDataGroup.get(element.getAttribute('data-group'))[element.getAttribute('data-value')] = $("#" + element.id).val();
					}
				}
			}

			// Convert from Map to Array
			var arraySaveParams = Array.from(mapDataGroup.values());
			
			// Handle requried data before save
			var checkBeforeSave = true;
			var indexToScroll = null;
			for (const item of arraySaveParams) {
				var indexGroupParam = item.DATA_GROUP && item.DATA_GROUP.length > 10 ?  item.DATA_GROUP.substring(10) : null;
				// Error Parameter key or Block key
				if (!item.PARAMETER_KEY) {
					$("#inputParamNm" + indexGroupParam).attr('style', 'border-color: red !important');
					if (indexToScroll == null) indexToScroll = "#inputParamNm" + indexGroupParam;
					// Handle open block when items inside have errors
					handleOpenBlockWhenItemsInsideError(indexGroupParam);
				} else {
					$("#inputParamNm" + indexGroupParam).css('border-color', '');
				}

				// Error Parameter description or Block description
				if (!item.PARAMETER_DESCRIPTION) {
					$("#inputParamDesc" + indexGroupParam).attr('style', 'border-color: red !important');
					if (indexToScroll == null) indexToScroll = "#inputParamDesc" + indexGroupParam ;
					// Handle open block when items inside have errors
					handleOpenBlockWhenItemsInsideError(indexGroupParam);
				} else {
					$("#inputParamDesc" + indexGroupParam).css('border-color', '');
				}
				
				if (!item.PARAMETER_KEY || !item.PARAMETER_DESCRIPTION) {
					checkBeforeSave = false;
					showToastRequired('bottom-right');
				}
			}

			if (!checkBeforeSave) {
				// Scroll element
				scrollSmothIntoElement(indexToScroll.replace("#", ""));
				return;
			}
			indexToScroll = null;
			// Create object data to save parameters
			var data = {
			  FILE_TEMPLATE_ID: $("#FILE_TEMPLATE_ID").val() || null,
			  FILE_TEMPLATE_PARAMETERS: arraySaveParams
			}

			// Call API to save data parameters
			$.ajax({
                type: "POST", 
                url: contextPath + '/save-file-template-params', 
                contentType: "application/json",
                data: JSON.stringify(data), 
                success: function(data) {
                    // Ajax call completed successfully 
                    showToastSaveSuccess('bottom-right', 'You have saved file parameters successfully!');
                }, 
                error: function(data) {
                    // Some error in ajax call 
                    if (data && data.responseJSON && data.responseJSON.message)
                    showToastSaveFailure('bottom-right', data.responseJSON.message);
                },
                complete: function(){
                }
    		});
		}

		// Click btn save parameters
		$("#saveParamsBtn").click(function() {
			fnSaveParam();
			if ($("#FILE_TEMPLATE_ID") && $("#FILE_TEMPLATE_ID").val() != null && $("#FILE_TEMPLATE_ID").val() != 0) {
				fnSaveFileTemplate();
			}
		});

		// Handle open block when items inside have errors
		function handleOpenBlockWhenItemsInsideError(indexGroupParam) {
			// Open div collapse to see error input
			if ($("#inputParamType" + indexGroupParam).val() == 'BLOCK') {
				$("#collapseOne-" + indexGroupParam).removeClass("show").addClass("show");
			} else if ($("#inputParamType" + indexGroupParam).val() == 'PARAM') {
				if ($("#parameter" + indexGroupParam).parent().attr("id") && $("#parameter" + indexGroupParam).parent().attr("id").length > 8) {
					var indexGroupParent = $("#parameter" + indexGroupParam).parent().attr("id").substring(8);
					$("#collapseOne-" + indexGroupParent).removeClass("show").addClass("show");
				}
			}
		}

		// Click btn left to right div file template
		$("#leftRightBtn").click(function() {
			if ($("#fileContentDiv").hasClass('col-xl-8 col-lg-12')) {
				$('#fileContentDiv').attr('class', 'col-xl-12 col-lg-12');
				$("#fileTemplateDiv").hide();
			} else {
				$('#fileContentDiv').attr('class', 'col-xl-8 col-lg-12');
				$("#fileTemplateDiv").show();
			}
		});

		/* START Handle upload file */
	    callBack_fileUploadInfo = function(data) {
	    	// id file
	    	$("#FILE_TEMPLATE_UPLOAD_ID").val(data[0].ID);
	    }
		/* END Handle upload file */

		// Popup confirm delete image
		function showSwalDeleteImage() {
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
		    		   $("#divDropZone").html('<span class="drop-zone__prompt">Drop file here or click to upload</span> <input id="fileInput" type="file" name="files" class="drop-zone__input" accept="image/*"> <input type="hidden" class="form-control" id="FILE_TEMPLATE_UPLOAD_ID" placeholder="File template upload id">');
		    	   } else if (inputValue == 'CANCEL') {
		    	   }
		      });
		}
		deleteImage = function() {
			showSwalDeleteImage();
		}
	});
</script>
