<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

/* Set css input select2 only 1 row and show scroll y when full data. Not wrap text */
.select2-selection {
  overflow-y:none;
  white-space:nowrap;
  min-height: 48px !important;
}
#listCmMessageId tr{
	height: 54px !important;
}
/* Hidden first row duplicate header */
#listCmMessageId thead tr {
	/* visibility: collapse */
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
									<div class="card-header border-bottom" id="headingOne-2"
										style="padding: 15px 15px 15px 15px; background-color: #f2f4f6 !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<!-- aria-expanded="false" -> icon -   else true -> icon +  -->
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-2"> <span
														style="font-weight: bold; color: black;">CHECK MESSAGE</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<!-- Adding show into end class, to collapse div -->
									<div id="collapseOne-2" class="border-bottom collapse show"
										aria-labelledby="headingOne-2" data-bs-parent="#accordion-2"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">

											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label for="exampleInputEmail3">Input message<code>*</code></label>
														<input type="text" class="form-control"
															id="TEXT_WANT_TO_TRANSLATE" placeholder="">
														<code id="TEXT_WANT_TO_TRANSLATE_MESSAGE"></code>
													</div>
												</div>
												<div class="col-md-12">
													<div class="align-self-end" style="margin-bottom: 0.3rem;">
														<button type="button" id="btnCheckMessage"
															class="btn btn-primary mr-2">
															<i class="fa fa-magic"></i> CHECK
														</button>

														<button type="button"
															id="btnRefreshCmMessage"
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

						<div class="col-12 d-none" id="divListCmMessage">
							<div id="accordion" class="accordion">
								<div class="card border-primary">
									<div class="card-header border-bottom" id="headingOne-4"
										style="padding: 15px 15px 15px 15px; background-color: #f2f4f6 !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<!-- aria-expanded="false" -> icon -   else true -> icon +  -->
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-4"> <span
														style="font-weight: bold; color: black;">LIST MESSAGE</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<!-- Adding show into end class, to collapse div -->
									<div id="collapseOne-4" class="border-bottom collapse show"
										aria-labelledby="headingOne-4" data-bs-parent="#accordion-4"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">

											<div class="row">
												<div class="col-md-12">
													
													<table class="table table-striped table-bordered"
														id="listCmMessageId" class="display" width="100%"></table>

												</div>


												<div class="col-md-12">
													<div class="align-self-end" style="margin-bottom: 0.3rem;">
														<button type="button"
															id="btnCreateNewMessage"
															class="btn btn-info mr-2">
															<i class="fa fa-plus"></i> CREATE NEW MESSAGE
														</button>
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-12 d-none" id="divCreateNewMessage">
							<div id="accordion" class="accordion">
								<div class="card border-primary">
									<div class="card-header border-bottom" id="headingOne-3"
										style="padding: 15px 15px 15px 15px; background-color: #f2f4f6 !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<!-- aria-expanded="false" -> icon -   else true -> icon +  -->
													<a aria-expanded="true" data-toggle="collapse"
														href="#collapseOne-3"> <span
														style="font-weight: bold; color: black;">CREATE NEW MESSAGE</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<!-- Adding show into end class, to collapse div -->
									<div id="collapseOne-3" class="border-bottom collapse show"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">

											<div class="row">
												<div class="col-md-6">
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label for="exampleInputEmail3">MSG_GRP<code>*</code></label>
																<select class="form-control input-select2" id="MSG_GRP" data-placeholder="Please choose">
																	<option value="UILBL_HR" selected>UILBL_HR</option>
																	<option value="API">API</option>
																</select>
																<code id="MSG_GRP_MESSAGE"></code>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label for="exampleInputEmail3">MSG_TYPE<code>*</code></label>

																<select class="form-control input-select2" id="MSG_TYPE" data-placeholder="Please choose">
																	<option value="LBL" selected>LBL</option>
																	<option value="MSG">MSG</option>
																</select>

																<code id="MSG_TYPE_MESSAGE"></code>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label for="exampleInputEmail3">COMP_CD<code>*</code></label>
																<select class="form-control input-select2" id="COMP_CD" data-placeholder="Please choose">
																	<option value="*" selected>*</option>
																	<option value="LG01">LG01</option>
																</select>
																<code id="COMP_CD_MESSAGE"></code>
															</div>
														</div>

														<div class="col-md-6">
															<div class="form-group">
																<label for="exampleInputEmail3">MSG_CD<code>*</code></label>
																<input type="text" class="form-control" id="MSG_CD"
																	placeholder="">
																<code id="MSG_CD_MESSAGE"></code>
															</div>
														</div>

														<div class="col-md-12">
															<div class="form-group">
																<label for="exampleInputEmail3">MSG Korea<code>*</code></label>
																<input type="text" class="form-control" id="MSG_KOREAN"
																	placeholder="">
																<code id="MSG_KOREAN_MESSAGE"></code>
															</div>
														</div>

														<div class="col-md-12">
															<div class="form-group">
																<label for="exampleInputEmail3">MSG English<code>*</code></label>
																<input type="text" class="form-control" id="MSG_ENGLISH"
																	placeholder="">
																<code id="MSG_ENGLISH_MESSAGE"></code>
															</div>
														</div>

													</div>
												</div>

												<div class="col-md-6">
													<div class="col-md-12">
														<div class="form-group border-style">
															<textarea class="form-control border-none"
																id="CODE_SQL" rows="20"
																placeholder="Generate code sql" readonly></textarea>
														</div>
													</div>
												</div>

												<div class="col-md-12">
													<div class="align-self-end" style="margin-bottom: 0.3rem;">
														<button type="button" id="btnGenerateCmMessage"
															class="btn btn-primary mr-2">
															<i class="fa fa-refresh"></i> GENERATE SQL
														</button>
														<button type="button"
															id="btnDownloadFileSql"
															class="btn btn-info mr-2">
															<i class="fa fa-download"></i> DOWNLOAD FILE.SQL
														</button>
														<button type="button"
															id="btnSaveCmMessage"
															class="btn btn-success mr-2">
															<i class="fa fa-database"></i> SAVE DATABASE NEXTHR-CORE
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
			<!-- main-panel ends -->

		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- base:js -->
	<c:import url="include/layout/footer.jsp"></c:import>

	<!-- Javascript datatable for this page -->
	<script src="https://cdn.datatables.net/2.0.2/js/dataTables.js"></script>
	
	<script type="text/javascript">
		var functionClickTextarea;
		var checkExistsMessage = false;
		const regexEnglish = /^[A-Za-z0-9\s#_$&+,.:;=~?@{}()"'[\]\/-]+$/;

		// Click btn refresh cm message
		$("#btnRefreshCmMessage").click(function() {
			window.location.href= "<%=request.getContextPath()%>/generate-cm-message-nexthr-core";
		});

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

			// Event check message
			$("#TEXT_WANT_TO_TRANSLATE").on('keyup', function (e) {
			    if (e.key === 'Enter' || e.keyCode === 13) {
			    	$("#btnCheckMessage").click();
			    }
			});

			$("#btnCheckMessage").click(function() {
				resetAllMessageCode();
				// Hiden div create new message
				$("#divCreateNewMessage").removeClass('d-none').addClass('d-none');
				$("#divListCmMessage").removeClass('d-none').addClass('d-none');

				$("#CODE_SQL").val("");

				// Empty data table and destroy every before init
				$('#listCmMessageId').empty();
				if ($('#listCmMessageId') != null && $('#listCmMessageId').DataTable() != null) {
					$('#listCmMessageId').DataTable().destroy();
				}

				// Validate input
				$("#TEXT_WANT_TO_TRANSLATE_MESSAGE").text(!isEmpty($("#TEXT_WANT_TO_TRANSLATE").val()) ? '' : 'Message is required.');

				// Handling
				if (!isEmpty($("#TEXT_WANT_TO_TRANSLATE").val())) {
					// Create object data to check
					var data = {
						msg : $("#TEXT_WANT_TO_TRANSLATE").val() || null
					};
					$.ajax({
						type : "GET",
						url : contextPath + '/list-cm-message',
						contentType : "application/json",
						traditional: true,
						data : data,
						success : function(data) {
							console.log(data);
							// If the CM_MESSAGE list does not exist, translate and generate the message
							if (!data) {
								// Call feature translate
								translateAndGenerateCmMessage();
							} else { // show list CM_MESSAGE
								$("#divListCmMessage").removeClass('d-none');

								/* Start render table */
								var dataSet = [];
								for (var i = 0; i < data.length; i++) {
									var content = [];
									content.push(i + 1);
									var msg_grp_and_msg_cd = "<span id='MSG_GRP_AND_CD_" + i + "' onClick='functionClickSpan(this)'>" + (data[i].MSG_GRP ? "<span style='color: #844fc1;'>" + data[i].MSG_GRP + "</span>" : '') + '.' + (data[i].MSG_CD ? "<span style='color: #007bff; font-weight: 500;'>" + data[i].MSG_CD + "</span>" : '') + "</span>";
									content.push(msg_grp_and_msg_cd);
									// content.push(data[i].MSG_GRP ? "<span style='color: #0056b3;'>" + data[i].MSG_GRP + "</span>" : '');
									content.push(data[i].MSG_TYPE || '');
									content.push(data[i].LANG_CD || '');
									content.push(data[i].COMP_CD || '');
									content.push(data[i].SYS_CD || '');
									content.push(data[i].MSG || '');

									dataSet.push(content);
								}
								
								var dataTable = new DataTable('#listCmMessageId', {
									autoWidth: false,
								    columns: [
								    	{ title: 'No', width: "5%" },
								        /* { title: 'Msg grp' }, */
								        { title: 'Msg cd', width: "30%" },
								        { title: 'Msg type', width: "15%" },
								        { title: 'Lang cd', width: "5%" },
								        { title: 'Comp cd', width: "15%" },
								        { title: 'Sys cd', width: "5%" },
								        { 
								        	title: 'Msg', 
								        	width: "25%"
								        }
								    ],
								    columnDefs: [
								        {
								            targets: 6,
								            data: 6,
								            render: function (data, type, row, meta) {
								            	return '<span style="white-space: initial">' + data + "</span>";
								            }
								        }
								    ],
								    data: dataSet,
								    "aLengthMenu": [
								        [5, 10, 15, -1],
								        [5, 10, 15, "All"]
								    ],
								    "iDisplayLength": 10,
								    "language": {
								        search: ""
								    }
									// ,scrollX: true
								});
								/* End render table */

								// Scroll to Element
								scrollSmothIntoElement("divListCmMessage");
							}
						},
						error : function(data) {
							showToastSaveFailure('bottom-right', 'Generate file failed!');
						},
						complete : function() {
						}
					});

				} else {
					// Scroll element
					scrollSmothIntoElement("TEXT_WANT_TO_TRANSLATE_MESSAGE");
				}
			});

		});

		// Handling translate
		function translateAndGenerateCmMessage() {
			// Validate input
			$("#TEXT_WANT_TO_TRANSLATE_MESSAGE").text(!isEmpty($("#TEXT_WANT_TO_TRANSLATE").val()) ? '' : 'Message is required.');
			// Handling
			if (!isEmpty($("#TEXT_WANT_TO_TRANSLATE").val())) {
				// Show div create new message
				$("#divCreateNewMessage").removeClass('d-none');

				// Scroll to Element
				scrollSmothIntoElement("divCreateNewMessage");

				// Create object data to generate
				var data = {
					SOURCE_LANGUAGE : regexEnglish.test($("#TEXT_WANT_TO_TRANSLATE").val()) ? 'English' : 'Korean',
					TEXT_WANT_TO_TRANSLATE : $("#TEXT_WANT_TO_TRANSLATE").val() || null,
					TARGET_LANGUAGE : regexEnglish.test($("#TEXT_WANT_TO_TRANSLATE").val()) ? 'Korean' : 'English'
				};

				$.ajax({
					type : "POST",
					url : contextPath + '/translate',
					contentType : "application/json",
					data : JSON.stringify(data),
					success : function(data) {
						let textWantToTranslateTmp = $("#TEXT_WANT_TO_TRANSLATE").val();
						if (textWantToTranslateTmp.substring(textWantToTranslateTmp.length-1, textWantToTranslateTmp.length) != '.'
								&& data.substring(data.length-1, data.length) == '.') {
							data = data.substring(0, data.length - 1);
						}

						// Ajax call completed successfully 
						showToastSaveSuccess('bottom-right', 'You have generate successfully!');
						// Set text output
						if (regexEnglish.test(data)) {
							$("#MSG_ENGLISH").val(data);
							$("#MSG_KOREAN").val($("#TEXT_WANT_TO_TRANSLATE").val());
						} else {
							$("#MSG_ENGLISH").val($("#TEXT_WANT_TO_TRANSLATE").val());
							$("#MSG_KOREAN").val(data);
						}
						// Set MSG_CD
						$("#MSG_CD").val(camelize($("#MSG_ENGLISH").val()));

						// Generate cm message
						$("#btnGenerateCmMessage").click();

					},
					error : function(data) {
						showToastSaveFailure('bottom-right', 'Generate file failed!');
					},
					complete : function() {
					}
				});
			} else {
				// Scroll element
				scrollSmothIntoElement("TEXT_WANT_TO_TRANSLATE_MESSAGE");
			}
		}

		// Handle event click textarea
		functionClickTextarea = function(textarea) {
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
				heading : 'Success',
				text : message ? message : 'You have saved successfully!',
				position : String(position),
				icon : 'success',
				stack : false,
				loaderBg : '#f96868'
			})
		}

		// ALert save failure
		showToastSaveFailure = function(position, message) {
			'use strict';
			resetToastPosition();
			$.toast({
				heading : 'Failure',
				text : !message ? 'You have failed to save!' : message,
				position : String(position),
				icon : 'error',
				stack : false,
				loaderBg : '#f96868'
			})
		}

		// ALert save successfully
		var showToastInfo = function(position, message, isShowHeader) {
			'use strict';
			resetToastPosition();
			$.toast({
				heading : isShowHeader ? 'Info' : '',
				text : message ? message : 'Info!',
				position : String(position),
				icon : 'info',
				stack : false,
				loaderBg : '#f96868'
			})
		}

		// Handling convert String to camel case
		function camelize(str) {
			if (isEmpty(str)) return str;
			str = str.toLowerCase().replace(/[&\/\\#,+()$~%.'":*?<>{}]/g,'');
		  	return str.replace(/(?:^\w|[A-Z]|\b\w)/g, function(word, index) {
			    return index === 0 ? word.toLowerCase() : word.toUpperCase();
		  	}).replace(/\s+/g, '');
		}

		// Handling animation typing text
		var indexText = 0;
		// var text = 'Lorem ipsum dummy text blabla.';
		function typeWriter(text, miliseconds) {
		  	if (indexText < text.length) {
    			// document.getElementById("demo").innerHTML += text.charAt(i);
    			$("#CODE_SQL").val($("#CODE_SQL").val() + text.charAt(indexText));

    			indexText++;
    			if (indexText == text.length - 1) {
    				indexText = 0;
    				return;
    			}
			    setTimeout(function() {
			    	typeWriter(text, miliseconds)
			    }, miliseconds);
		  	}
		}

		// Event click btn create new Message
		$("#btnCreateNewMessage").click(function() {
			// Call feature translate and generate cm message
			translateAndGenerateCmMessage();
		});

		// Event click textarea
		var arrayTextAreaOutput = document.getElementById("divCreateNewMessage").querySelectorAll("textarea");
		arrayTextAreaOutput.forEach(textarea => {
			// Set attribute event click inside tag textarea
			textarea.removeAttribute('onclick');
			textarea.setAttribute('onClick', 'functionClickTextarea(this);');
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

		// Handle event click span
		function functionClickSpan(span) {
			span.textContent;
			var textAreaTemp = document.createElement("textarea");
			textAreaTemp.value = span.textContent;
		    document.body.appendChild(textAreaTemp);
		    textAreaTemp.select();
		    document.execCommand("copy");
		    textAreaTemp.remove();
		    showToastInfo('bottom-left', 'Data has been copied!');
			
		}

		// Event click btn generate cm message
		$("#MSG_CD").on('keyup', function (e) {
		    if (e.key === 'Enter' || e.keyCode === 13) {
		    	$("#btnGenerateCmMessage").click();
		    }
		});
		$("#MSG_KOREAN").on('keyup', function (e) {
		    if (e.key === 'Enter' || e.keyCode === 13) {
		    	$("#btnGenerateCmMessage").click();
		    }
		});
		$("#MSG_ENGLISH").on('keyup', function (e) {
		    if (e.key === 'Enter' || e.keyCode === 13) {
		    	$("#btnGenerateCmMessage").click();
		    }
		});
		$("#btnGenerateCmMessage").click(function() {
			$("#CODE_SQL").val("");
			// Validate input
			$("#MSG_GRP_MESSAGE").text(!isEmpty($("#MSG_GRP").val()) ? '' : 'Message group is required.');
			$("#MSG_TYPE_MESSAGE").text(!isEmpty($("#MSG_TYPE").val()) ? '' : 'Message type is required.');
			$("#COMP_CD_MESSAGE").text(!isEmpty($("#COMP_CD").val()) ? '' : 'Company code is required.');
			$("#MSG_CD_MESSAGE").text(!isEmpty($("#MSG_CD").val()) ? '' : 'Message code is required.');
			$("#MSG_KOREAN_MESSAGE").text(!isEmpty($("#MSG_KOREAN").val()) ? '' : 'Message korean is required.');
			$("#MSG_ENGLISH_MESSAGE").text(!isEmpty($("#MSG_ENGLISH").val()) ? '' : 'Message english is required.');

			// Handling
			if (isEmpty($("#MSG_GRP").val()) || isEmpty($("#MSG_TYPE").val()) || isEmpty($("#COMP_CD").val()) 
					|| isEmpty($("#MSG_CD").val()) || isEmpty($("#MSG_KOREAN").val()) || isEmpty($("#MSG_ENGLISH").val())) {
				return;
			} else {
				generateStringCodeSql(true, true);
			}
		});

		function generateStringCodeSql(isShowAlert, isCheckExistsMessage) {
			var arraySaveParams = [];
			var itemParam = {};

			// MSG_GRP
			itemParam["PARAMETER_TYPE"] = "PARAM";
			itemParam["PARAMETER_KEY"] = "<<MSG_GRP>>";
			itemParam["PARAMETER_VALUE"] = $("#MSG_GRP").val();
			// push element into array
			arraySaveParams.push(itemParam);

			// MSG_TYPE
			itemParam = {};
			itemParam["PARAMETER_TYPE"] = "PARAM";
			itemParam["PARAMETER_KEY"] = "<<MSG_TYPE>>";
			itemParam["PARAMETER_VALUE"] = $("#MSG_TYPE").val();
			// push element into array
			arraySaveParams.push(itemParam);

			// COMP_CD
			itemParam = {};
			itemParam["PARAMETER_TYPE"] = "PARAM";
			itemParam["PARAMETER_KEY"] = "<<COMP_CD>>";
			itemParam["PARAMETER_VALUE"] = $("#COMP_CD").val();
			// push element into array
			arraySaveParams.push(itemParam);

			// MSG_CD
			itemParam = {};
			itemParam["PARAMETER_TYPE"] = "PARAM";
			itemParam["PARAMETER_KEY"] = "<<MSG_CD>>";
			itemParam["PARAMETER_VALUE"] = $("#MSG_CD").val();
			// push element into array
			arraySaveParams.push(itemParam);

			// SYS_CD
			itemParam = {};
			itemParam["PARAMETER_TYPE"] = "PARAM";
			itemParam["PARAMETER_KEY"] = "<<SYS_CD>>";
			itemParam["PARAMETER_VALUE"] = "HR";
			// push element into array
			arraySaveParams.push(itemParam);

			// MSG_KOREAN
			itemParam = {};
			itemParam["PARAMETER_TYPE"] = "PARAM";
			itemParam["PARAMETER_KEY"] = "<<MSG_KOREAN>>";
			itemParam["PARAMETER_VALUE"] = $("#MSG_KOREAN").val();
			// push element into array
			arraySaveParams.push(itemParam);

			// MSG_ENGLISH
			itemParam = {};
			itemParam["PARAMETER_TYPE"] = "PARAM";
			itemParam["PARAMETER_KEY"] = "<<MSG_ENGLISH>>";
			itemParam["PARAMETER_VALUE"] = $("#MSG_ENGLISH").val();
			// push element into array
			arraySaveParams.push(itemParam);

			var data = {
				FILE_TEMPLATE_ID: ${settingCreateCmMessageForNextHRCore != null && settingCreateCmMessageForNextHRCore.value != null && settingCreateCmMessageForNextHRCore.value != '' 
					? settingCreateCmMessageForNextHRCore.value: -9999},
				FILE_TEMPLATE_PARAMETERS: arraySaveParams
			};

			$.ajax({
                type: "POST", 
                url: '<%=request.getContextPath()%>/generate-file-template-to-string', 
                contentType: "application/json",
                data: JSON.stringify(data), 
                success: function(data, textStatus, request) {
                    // Ajax call completed successfully 
                    if (isShowAlert) showToastSaveSuccess('bottom-right', 'Generate file successfully!');
                    
                    console.log(data);
                 	// Set code sql
                 	$("#CODE_SQL").val(data);
					// typeWriter(data, 10);

					if (isCheckExistsMessage) {
						// Check exists cm message
						checkExistsCmMessage();
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
		}

		// Handling event check exists cm message
		function checkExistsCmMessage() {
			// Reset
			checkExistsMessage = false;

			// Create object data to check
			var data = {
				msg : null,
				listLangCd: null,
				listMsgGrp: [$("#MSG_GRP").val()],
				listMsgType: null,
				listSysCd: null,
				listCompCd: $("#COMP_CD").val() == '*' ? null : [$("#COMP_CD").val()],
				msgCd : $("#MSG_CD").val()
			};
			return $.ajax({
				type : "GET",
				url : contextPath + '/check-exists-cm-message',
				contentType : "application/json",
				traditional: true,
				data : data,
				success : function(data) {
					console.log(data);
					if (data) {
						// Exists
						$("#MSG_CD_MESSAGE").text('Message code already exists.');
						checkExistsMessage = true;
					} else {
						$("#MSG_CD_MESSAGE").text('');
						checkExistsMessage = false;
					}
				},
				error : function(data) {
					showToastSaveFailure('bottom-right', 'Generate file failed!');
				},
				complete : function() {
				}
			});
		}

		// Handling event click btn execute query and generate file sql
		$("#btnDownloadFileSql").click(function() {
			generateStringCodeSql(false, false);
			// Download file sql
	    	downloadFileSql();
			
		});

		// Handling event create cm_message
		$("#btnSaveCmMessage").click(function() {
			saveCmMessage();
		});
		function saveCmMessage() {
			generateStringCodeSql(false, true);
			$.when(checkExistsCmMessage()).done(function(response) {
			    // the code here will be executed when all four ajax requests resolve.
			    console.log('ajax checkExistsCmMessage request complete.');
			    if (!checkExistsMessage) { // If the message does not exist, save and process the generate sql file
			    	// Save cm message into NextHR-Core
			    	var arraySaveParams = [];
					var itemParam = {};

					// MSG_GRP
					itemParam["PARAMETER_TYPE"] = "PARAM";
					itemParam["PARAMETER_KEY"] = "<<MSG_GRP>>";
					itemParam["PARAMETER_VALUE"] = $("#MSG_GRP").val();
					// push element into array
					arraySaveParams.push(itemParam);

					// MSG_TYPE
					itemParam = {};
					itemParam["PARAMETER_TYPE"] = "PARAM";
					itemParam["PARAMETER_KEY"] = "<<MSG_TYPE>>";
					itemParam["PARAMETER_VALUE"] = $("#MSG_TYPE").val();
					// push element into array
					arraySaveParams.push(itemParam);

					// COMP_CD
					itemParam = {};
					itemParam["PARAMETER_TYPE"] = "PARAM";
					itemParam["PARAMETER_KEY"] = "<<COMP_CD>>";
					itemParam["PARAMETER_VALUE"] = $("#COMP_CD").val();
					// push element into array
					arraySaveParams.push(itemParam);

					// MSG_CD
					itemParam = {};
					itemParam["PARAMETER_TYPE"] = "PARAM";
					itemParam["PARAMETER_KEY"] = "<<MSG_CD>>";
					itemParam["PARAMETER_VALUE"] = $("#MSG_CD").val();
					// push element into array
					arraySaveParams.push(itemParam);

					// SYS_CD
					itemParam = {};
					itemParam["PARAMETER_TYPE"] = "PARAM";
					itemParam["PARAMETER_KEY"] = "<<SYS_CD>>";
					itemParam["PARAMETER_VALUE"] = "HR";
					// push element into array
					arraySaveParams.push(itemParam);

					// MSG_KOREAN
					itemParam = {};
					itemParam["PARAMETER_TYPE"] = "PARAM";
					itemParam["PARAMETER_KEY"] = "<<MSG_KOREAN>>";
					itemParam["PARAMETER_VALUE"] = $("#MSG_KOREAN").val();
					// push element into array
					arraySaveParams.push(itemParam);

					// MSG_ENGLISH
					itemParam = {};
					itemParam["PARAMETER_TYPE"] = "PARAM";
					itemParam["PARAMETER_KEY"] = "<<MSG_ENGLISH>>";
					itemParam["PARAMETER_VALUE"] = $("#MSG_ENGLISH").val();
					// push element into array
					arraySaveParams.push(itemParam);

					var data = {
						FILE_TEMPLATE_ID: ${settingCreateCmMessageForNextHRCore != null && settingCreateCmMessageForNextHRCore.value != null && settingCreateCmMessageForNextHRCore.value != ''
							? settingCreateCmMessageForNextHRCore.value: -9999},
						FILE_TEMPLATE_PARAMETERS: arraySaveParams
					};

					$.ajax({
		                type: "POST", 
		                url: '<%=request.getContextPath()%>/save-cm-message-into-nexthr-core', 
		                contentType: "application/json",
		                data: JSON.stringify(data), 
		                success: function(data, textStatus, request) {
		                	console.log(data);
		                    // Ajax call completed successfully 
		                    if (data) {
		                    	showToastSaveSuccess('bottom-right', 'Save cm message into NextHR-Core successfully!');
		                    } else {
		                    	showToastSaveFailure('bottom-right', 'Save cm message into NextHR-Core failed!');
		                    }
		                }, 
		                error: function(request, textStatus, errorThrown) {
		                	showToastSaveFailure('bottom-right', 'Save cm message into NextHR-Core failed!');
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
			    	
			  	}
			});
		}

		// Handling event execute query and generate file sql
		function downloadFileSql() {
			// Handling
			if (isEmpty($("#MSG_GRP").val()) || isEmpty($("#MSG_TYPE").val()) || isEmpty($("#COMP_CD").val()) 
					|| isEmpty($("#MSG_CD").val()) || isEmpty($("#MSG_KOREAN").val()) || isEmpty($("#MSG_ENGLISH").val())) {
				return;
			} else {
				var arraySaveParams = [];
				var itemParam = {};

				// MSG_GRP
				itemParam["PARAMETER_TYPE"] = "PARAM";
				itemParam["PARAMETER_KEY"] = "<<MSG_GRP>>";
				itemParam["PARAMETER_VALUE"] = $("#MSG_GRP").val();
				// push element into array
				arraySaveParams.push(itemParam);

				// MSG_TYPE
				itemParam = {};
				itemParam["PARAMETER_TYPE"] = "PARAM";
				itemParam["PARAMETER_KEY"] = "<<MSG_TYPE>>";
				itemParam["PARAMETER_VALUE"] = $("#MSG_TYPE").val();
				// push element into array
				arraySaveParams.push(itemParam);

				// COMP_CD
				itemParam = {};
				itemParam["PARAMETER_TYPE"] = "PARAM";
				itemParam["PARAMETER_KEY"] = "<<COMP_CD>>";
				itemParam["PARAMETER_VALUE"] = $("#COMP_CD").val();
				// push element into array
				arraySaveParams.push(itemParam);

				// MSG_CD
				itemParam = {};
				itemParam["PARAMETER_TYPE"] = "PARAM";
				itemParam["PARAMETER_KEY"] = "<<MSG_CD>>";
				itemParam["PARAMETER_VALUE"] = $("#MSG_CD").val();
				// push element into array
				arraySaveParams.push(itemParam);

				// SYS_CD
				itemParam = {};
				itemParam["PARAMETER_TYPE"] = "PARAM";
				itemParam["PARAMETER_KEY"] = "<<SYS_CD>>";
				itemParam["PARAMETER_VALUE"] = "HR";
				// push element into array
				arraySaveParams.push(itemParam);

				// MSG_KOREAN
				itemParam = {};
				itemParam["PARAMETER_TYPE"] = "PARAM";
				itemParam["PARAMETER_KEY"] = "<<MSG_KOREAN>>";
				itemParam["PARAMETER_VALUE"] = $("#MSG_KOREAN").val();
				// push element into array
				arraySaveParams.push(itemParam);

				// MSG_ENGLISH
				itemParam = {};
				itemParam["PARAMETER_TYPE"] = "PARAM";
				itemParam["PARAMETER_KEY"] = "<<MSG_ENGLISH>>";
				itemParam["PARAMETER_VALUE"] = $("#MSG_ENGLISH").val();
				// push element into array
				arraySaveParams.push(itemParam);

				var data = {
					FILE_TEMPLATE_ID: ${settingCreateCmMessageForNextHRCore != null && settingCreateCmMessageForNextHRCore.value != null && settingCreateCmMessageForNextHRCore.value != ''
						? settingCreateCmMessageForNextHRCore.value: -9999},
					FILE_TEMPLATE_PARAMETERS: arraySaveParams
				};

				$.ajax({
	                type: "POST", 
	                url: '<%=request.getContextPath()%>/generate-file-template', 
	                contentType: "application/json; charset=utf-8",
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

			}
		}

		// Reset all message code
		function resetAllMessageCode() {
			document.querySelectorAll("[id$='_MESSAGE']").forEach(itemCodeMessage => {
				$("#" + itemCodeMessage.id).val("");
			});
		}

	</script>

</body>

</html>