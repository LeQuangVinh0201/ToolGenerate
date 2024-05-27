<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style>
#quillFileContent {
	height: 415px !important;
}

.input-value-param {
	border: 1px solid #844fc1 !important;
}
.btn.btn-icon, .ajax-upload-dragdrop .btn-icon.ajax-file-upload {
    width: 35px;
    height: 35px;
    padding: 0;
}
[id^="inputParamDesc"] {
    font-weight: 500;
    color: #844fc1;
}
.drop-zone {
	max-width: 100%;
  	height: 460px;
}
/* Hide label file name */
.drop-zone__thumb::after {
  content: none;
}
.image-file-template {
	border: 4px dashed #009578;
    border-radius: 10px;
    width: 100%;
	height: 460px;
	padding: 5px;
}
.image-file-template img {
	width: 100%;
	height: 100%;
}
/* Large screen device */
@media screen and (max-width: 1199.98px) {
	#leftRightBtn {
		display: none;
	}
	#fileTemplateDiv {
		display: block !important;
	}
}
</style>
<c:set var="indexParameter" value="1" scope="page" />
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
											<label for="exampleInputName1">File template name</label> <input
												type="hidden" class="form-control" readonly
												id="FILE_TEMPLATE_ID" placeholder="File template id">
											<input type="text" class="form-control" readonly
												id="FILE_TEMPLATE_NAME" placeholder="File template name" tabindex="-1">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail3">File extension</label> 
											<input
												type="text" class="form-control" readonly
												id="FILE_TEMPLATE_EXTENSION" placeholder="File extension" tabindex="-1">
										</div>
										<div class="form-group">
											<label for="exampleTextarea1">Description</label>
											<textarea class="form-control" readonly
												id="FILE_DESCRIPTION" rows="12"
												placeholder="File description" tabindex="-1"></textarea>
										</div>
									</div>

									<div class="col-xl-8 col-lg-12" id="fileContentDiv">
										<nav>
											<div class="nav nav-tabs" id="nav-tab" role="tablist" style="margin-bottom: 15px;">
												<a class="nav-link <c:if test="${infoFileTemplate.fileTemplateDocumentStorages.size() == 0}">active</c:if>" id="nav-home-tab"
													data-bs-toggle="tab" href="#nav-home" role="tab"
													aria-controls="nav-home" aria-selected="true">Content</a> 
												<a
													class="nav-link <c:if test="${infoFileTemplate.fileTemplateDocumentStorages.size() > 0}">active</c:if>" id="nav-image-tab" data-bs-toggle="tab"
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
											<div class="tab-pane fade <c:if test='${infoFileTemplate.fileTemplateDocumentStorages.size() == 0}'>show active</c:if>" id="nav-home"
												role="tabpanel" aria-labelledby="nav-home-tab">
												<div class="form-group">
													<div id="quillFileContent"
														class="quill-container ql-container ql-snow"></div>
													<code id="FILE_CONTENT_MESSAGE"></code>
												</div>
											</div>
											<div class="tab-pane fade <c:if test='${infoFileTemplate.fileTemplateDocumentStorages.size() > 0}'>show active</c:if>" id="nav-profile" role="tabpanel"
												aria-labelledby="nav-image-tab">
												
												<div class="form-group">
													  <c:if test="${infoFileTemplate.fileTemplateDocumentStorages.size() == 0}">
													  	 <div class="image-file-template" data-fancybox="gallery" 
														  	data-src="<%=request.getContextPath()%>/images/404_not_found.png"> 
														    <img src="<%=request.getContextPath()%>/images/404_not_found.png" />
														  </div>
													  </c:if>
													  <c:if test="${infoFileTemplate.fileTemplateDocumentStorages.size() > 0}">
													  	  <div class="image-file-template" data-fancybox="gallery" 
														  	data-src="<%=request.getContextPath()%>/file${infoFileTemplate.fileTemplateDocumentStorages[0].path}"> 
														    <img src="<%=request.getContextPath()%>/file${infoFileTemplate.fileTemplateDocumentStorages[0].path}" 
														    	onerror="this.src='<%=request.getContextPath()%>/images/404_not_found.png'" />
														  </div>
													  </c:if>
												</div>
											</div>
										</div>

									</div>

								</div>
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

						<c:forEach var="parameter"
							items="${infoFileTemplate.fileTemplateParametersWithBlock}">
							<c:set var="indexBlockParent" value="${indexParameter}" scope="page" />
							<div id="accordion" class="accordion">
								<div class="card border-primary">
									<div class="card-header border-bottom" id="headingOne-3"
										style="padding: 15px 30px 5px 38px; background-color: #e9eaeb !important;">
										<h5 class="mb-0">
											<div class="row">
												<div>
													<label class="toggle-switch"> <c:if
															test="${parameter.parameterKey != null}">
															<input type="checkbox"
																<c:if test="${parameter.parameterRequired}">checked</c:if>
																data-group="paramGroup${indexParameter}"
																id="inputParamNm${indexParameter}"
																data-value="PARAMETER_KEY"
																value="${parameter.parameterKey}"
																<c:if test="${parameter.parameterKey == null}"></c:if>>
															<span class="toggle-slider round"></span>
														</c:if> <c:if test="${parameter.parameterKey == null}">
															<input type="checkbox" checked
																data-group="paramGroup${indexParameter}"
																id="inputParamNm${indexParameter}"
																data-value="PARAMETER_KEY"
																value="${parameter.parameterKey}"
																<c:if test="${parameter.parameterKey == null}"></c:if>>
															<span class="toggle-slider round"></span>
														</c:if> <input class="form-control d-none" readonly
														id="inputParamType${indexParameter}"
														data-value="PARAMETER_TYPE"
														data-group="paramGroup${indexParameter}"
														value="${parameter.parameterType}" tabindex="-1" /> <input
														class="form-control d-none" readonly
														id="inputParamDesc${indexParameter}"
														data-value="PARAMETER_DESCRIPTION"
														data-group="paramGroup${indexParameter}"
														value="${parameter.parameterDescription}" tabindex="-1" />
													</label>
												</div>
												<div class="col">
													<a aria-expanded="${parameter.isOpen == null || parameter.isOpen  ? true : false}" style="padding-top: 5px"
														data-toggle="collapse"
														id="acollapseOne-${indexParameter}"
														href="#collapseOne-${indexParameter}" class="collapsed">
														<c:if test="${parameter.parameterKey != null}">
															<span style="color: black;"><span style="font-weight: 600;">${parameter.parameterDescription}</span>
																${parameter.parameterKey.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;")}
															</span>
														</c:if> <c:if test="${parameter.parameterKey == null}">
															<span style="font-weight: bold; color: black;">NOT
																BELONG ANY BLOCK:</span>
														</c:if>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<div id="collapseOne-${indexParameter}"
										class="collapse border-bottom ${parameter.isOpen == null || parameter.isOpen  ? 'show' : ''}"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3">
										<c:if
											test="${parameter.fileTemplateParameters != null && parameter.fileTemplateParameters.size() > 0}">
											<div class="card-body"
												style="padding: 1.5rem 1.8rem !important">
												<c:forEach var="paramChild"
													items="${parameter.fileTemplateParameters}">
													<c:set var="indexParameter" value="${indexParameter + 1}"
														scope="page" />
													<span style="display: none" id="span${indexParameter}"></span>

													<div class="form-group row" id="parameter${indexParameter}">
														<div class="col-xl-2 col-lg-6" style="display: none;">
															<label for="exampleSelectGender">Type</label> <input
																class="form-control" readonly
																id="inputParamType${indexParameter}"
																data-value="PARAMETER_TYPE"
																data-group="paramGroup${indexParameter}"
																type="hidden"
																value="${paramChild.parameterType}" 
																tabindex="-1"/>
														</div>
														<div class="col-xl-3 col-lg-6">
															<label>Parameter key</label> <input
																class="form-control" readonly
																id="inputParamNm${indexParameter}"
																data-value="PARAMETER_KEY"
																data-group="paramGroup${indexParameter}"
																value="${paramChild.parameterKey}" 
																tabindex="-1"/>
														</div>
														<div class="col-xl-3 col-lg-6">
															<label>Description</label> <input
																class="form-control" readonly
																id="inputParamDesc${indexParameter}"
																data-value="PARAMETER_DESCRIPTION"
																data-group="paramGroup${indexParameter}"
																value="${paramChild.parameterDescription}" 
																tabindex="-1"/>
														</div>
														<div class="col-xl-6 col-lg-12">
															<label>Parameter value <c:if
																	test="${paramChild.parameterRequired}">
																	<code>*</code>
																</c:if></label> 
															<%-- <input class="form-control input-value-param"
																id="inputParamValue${indexParameter}"
																data-value="PARAMETER_VALUE"
																data-group="paramGroup${indexParameter}"
																value="${paramChild.parameterDefaultValue.replace(" \'","&#39;").replace("\"","&#34;")}" /> --%>
																
															<textarea 
																	class="form-control textarea-auto-height"
																	id="inputParamValue${indexParameter}"
																	data-value="PARAMETER_VALUE"
																	index-parent="${indexBlockParent}"
																	data-group="paramGroup${indexParameter}">${paramChild.parameterDefaultValue.replace(" \'","&#39;").replace("\"","&#34;")}</textarea>

															<input type="hidden"
																class="form-control input-value-param"
																id="inputParamRequired${indexParameter}"
																data-value="PARAMETER_REQUIRED"
																data-group="paramGroup${indexParameter}"
																value="${paramChild.parameterRequired}" />
														</div>
													</div>
												</c:forEach>
											</div>
										</c:if>
									</div>
									<c:set var="indexParameter" value="${indexParameter + 1}"
										scope="page" />
								</div>
							</div>
						</c:forEach>

					</div>

					<button type="button" id="btnGenerateFileTemplate"
						class="btn btn-primary mr-2">
						<i class="fa fa-download"></i> GENERATE FILE
					</button>
					<button type="button" class="btn btn-secondary"
						id="returnToListBtn">
						<i class="fa fa-caret-left"></i> RETURN TO LIST
					</button>
				</div>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$( document ).ready(function() {
		// Display btn scroll top and btn scroll to bottom
		displayBtnScroll(true);

		// Init variable
		var indexParameter = 1;
		var quillFileContent;

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
		      readOnly: true
		    });
		}
		
		// Setting info file template if exists data else new page
		function renderFileTemplate() {
			if (${infoFileTemplate != null} && ${infoFileTemplate.fileTemplateId != null} && ${infoFileTemplate.fileTemplateId > 0}) {
				// Set data info DIV FILE TEMPLATE
				$("#FILE_TEMPLATE_ID").val("${infoFileTemplate.fileTemplateId}");
				$("#FILE_TEMPLATE_NAME").val("${infoFileTemplate.fileTemplateName}");
				$("#FILE_TEMPLATE_EXTENSION").val("${infoFileTemplate.fileTemplateExtension}");
				$("#FILE_DESCRIPTION").val("${infoFileTemplate.fileDescription}");

				// Set data quill editor for TEMPLATE CONTENT
				quillFileContent.setContents(${infoFileTemplate.fileContentFormat != null ? infoFileTemplate.fileContentFormat.replace("</script>", "<\\/script>") : null});

			}
		}
		renderFileTemplate();
		
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

		// Btn save file template
		$("#btnGenerateFileTemplate").click(function() {
			// Get all element in div parameters to looping
			var arrElementsInDivParam = $("#divParameter :input");
			// Create new map to handle data-group element
			var mapDataGroup = new Map();
			for (const element of arrElementsInDivParam) {
				if (element.id) {
					// If not exists key data-group then create new key map with value is new array. After add first element
					if (!mapDataGroup.get(element.getAttribute('data-group'))) {
						mapDataGroup.set(element.getAttribute('data-group'), {});
						// Is element input is checkbox
						if ($("#" + element.id).is(':checkbox')) {
							mapDataGroup.get(element.getAttribute('data-group'))['PARAMETER_VALUE'] = $("#" + element.id).is(":checked") ? true : false;
						}
						mapDataGroup.get(element.getAttribute('data-group'))[element.getAttribute('data-value')] = $("#" + element.id).val();
						mapDataGroup.get(element.getAttribute('data-group'))['DATA_GROUP'] = element.getAttribute('data-group');
					} else {
						// If exists key then insert element into index 0 of map with this key
						mapDataGroup.get(element.getAttribute('data-group'))[element.getAttribute('data-value')] = $("#" + element.id).val();
					}
				}
			}
			// Convert from Map to Array and filter remove BLOCK (NOT BELONG TO ANY BLOCK) 
			var arraySaveParams = Array.from(mapDataGroup.values()).filter(item => item.PARAMETER_TYPE != '');

			// Handle requried data before save
			var checkBeforeSave = true;
			var indexToScroll = null;
			for (const item of arraySaveParams) {
				var indexGroupParam = item.DATA_GROUP && item.DATA_GROUP.length > 10 ?  item.DATA_GROUP.substring(10) : null;
				var indexParent = $("#inputParamValue" + indexGroupParam) ? $("#inputParamValue" + indexGroupParam).attr('index-parent') : null;
				if (item && item.PARAMETER_TYPE == 'PARAM' && $("#inputParamNm" + indexParent).is(":checked")
					&& item.PARAMETER_REQUIRED == "true" && item.PARAMETER_VALUE == '') {
					
					$("#inputParamValue" + indexGroupParam).attr('style', 'border-color: red !important');
					checkBeforeSave = false;
					if (indexToScroll == null) indexToScroll = indexGroupParam ;

					// Handle open block when items inside have errors
					handleOpenBlockWhenItemsInsideError(indexGroupParam);
				} else {
					$("#inputParamValue" + indexGroupParam).css('border-color', '');
				}
				// Call auto height textarea
				autoHeightTextarea();
			}

			if (!checkBeforeSave) {
				showToastRequired('bottom-right');
				// Scroll element
				scrollSmothIntoElement("parameter" + indexToScroll);
				return;
			}
			indexToScroll = null;

			// Create object data to save parameters
			var data = {
			  FILE_TEMPLATE_ID: $("#FILE_TEMPLATE_ID").val() || null,
			  FILE_TEMPLATE_NAME: $("#FILE_TEMPLATE_NAME").val(),
			  FILE_TEMPLATE_EXTENSION: $("#FILE_TEMPLATE_EXTENSION").val(),
			  FILE_DESCRIPTION: $("#FILE_DESCRIPTION").val(),
			  FILE_CONTENT: (quillFileContent && quillFileContent.getText()) ? quillFileContent.getText() : null,
			  FILE_CONTENT_FORMAT: (quillFileContent && quillFileContent.getContents()) ? JSON.stringify(quillFileContent.getContents()) : null,
			  CUD_KEY: $("#FILE_TEMPLATE_ID").val() ? "UPDATE" : "CREATE",
			  FILE_TEMPLATE_PARAMETERS: arraySaveParams
			}

			
			$.ajax({
                type: "POST", 
                url: '<%=request.getContextPath()%>/generate-file-template', 
                contentType: "application/json",
                data: JSON.stringify(data), 
                success: function(data, textStatus, request) {
                    // Ajax call completed successfully 
                    showToastSaveSuccess('bottom-right', 'Generate file successfully!');
                    
                    var fileName = request.getResponseHeader('FILE-NAME');
                  	//Convert the Byte Data to BLOB object.
                    var blob = new Blob([data], { type: "application/octetstream; charset=utf-8" });
 
                    //Check the Browser type and download the File.
                    var isIE = false || !!document.documentMode;
                    if (isIE) {
                        window.navigator.msSaveBlob(blob, fileName);
                    } else {
                        var url = window.URL || window.webkitURL;
                        link = url.createObjectURL(blob);
                        var aTagDownload = $("<a id='aTagDownload' />");
                        aTagDownload.attr("download", fileName);
                        aTagDownload.attr("href", link);
                        $("body").append(aTagDownload);
                        aTagDownload[0].click();
                        $("#aTagDownload").remove();
                    }
                }, 
                error: function(request, textStatus, errorThrown) {
                	showToastSaveFailure('bottom-right', 'Generate file failed!');
                    // Some error in ajax call 
                    if (request.status == 417) { // Error code 417 define exaclly fieldName and messageError
                    	var arrayErrors = data.responseJSON.errors;
                    	for(var i in arrayErrors) {  
                    		var item = arrayErrors[i]; 
                    		alert(item.messageError);
                    	}
                    }
                },
                complete: function(){
                }
            }); 
            
		});

		// Handle open block when items inside have errors
		function handleOpenBlockWhenItemsInsideError(indexGroupParam) {
			// Open div collapse to see error input
			if ($("#inputParamType" + indexGroupParam).val() == 'BLOCK') {
				$("#collapseOne-" + indexGroupParam).removeClass("show").addClass("show");
			} else if ($("#inputParamType" + indexGroupParam).val() == 'PARAM') {
				if ($("#parameter" + indexGroupParam).parent()
						&& $("#parameter" + indexGroupParam).parent().parent()) {
					
					$("#parameter" + indexGroupParam).parent().parent().removeClass("show").addClass("show");
					// Change icon to + open block
					$("#a" + $("#parameter" + indexGroupParam).parent().parent().attr('id')).attr('aria-expanded', true)
				}
			}
		}

		// Click btn return to list
		$("#returnToListBtn").click(function() {
			window.location.href= "<%=request.getContextPath()%>/list-file-template";
		});

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

		// Click btn return to list
		$(".returnToListBtn").click(function() {
			window.location.href= "<%=request.getContextPath()%>/list-file-template";
		});

		// Init lib fancybox to zoom image
      	Fancybox.bind('[data-fancybox="gallery"]', {
        	//
      	});

	});
</script>