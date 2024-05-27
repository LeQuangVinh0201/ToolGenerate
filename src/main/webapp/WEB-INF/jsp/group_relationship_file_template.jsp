<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<c:import url="include/layout/header.jsp"></c:import>
<style>
#tab-button {
	display: table;
	table-layout: fixed;
	width: 100%;
	margin: 0;
	padding: 0;
	list-style: none;
}

#tab-button li {
	display: table-cell;
	width: 20%;
}

#tab-button li a {
	display: block;
	padding: .5em;
	background: #dddddd59;
	text-align: center;
	color: #000;
	text-decoration: none;
}

#tab-button li:not(:first-child) a {
	border-left: none;
}

#tab-button li a:hover, #tab-button .is-active a {
	background: #fff;
}

.tab-contents {
	padding: 10px 0px 0px 0px;
	border: 1px solid #ddd;
}

.tab-button-outer {
	display: none;
}

.tab-contents {
	margin-top: 20px;
}

@media screen and (min-width: 768px) {
	.tab-button-outer {
		position: relative;
		z-index: 2;
		display: block;
	}
	.tab-select-outer {
		display: none;
	}
	.tab-contents {
		position: relative;
		margin-top: 0;
	}
}
</style>

<!-- Styles -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/select2-bootstrap-5-theme@1.3.0/dist/select2-bootstrap-5-theme.min.css" />

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
										style="padding: 15px 15px 15px 28px; background-color: #f2f4f6 !important;">
										<h5 class="mb-0">
											<div class="row">
												<div class="col">
													<!-- aria-expanded="false" -> icon -   else true -> icon +  -->
													<a aria-expanded="${isLayout ? true : true}"
														data-toggle="collapse" href="#collapseOne-2"> <span
														style="font-weight: bold; color: black;">GROUP FILE
															TEMPLATE</span>
													</a>
												</div>
											</div>
										</h5>
									</div>
									<!--  class="border-bottom collapse toggle" show or toggle or hide -->
									<div id="collapseOne-2"
										class="border-bottom collapse ${isLayout ? 'show' : 'show'}"
										aria-labelledby="headingOne-3" data-bs-parent="#accordion-3"
										style="">
										<div class="card-body"
											style="padding: 1.5rem 1.8rem !important">


											<form class="forms-sample">
												<div class="row">
													<div class="col-xl-6 col-lg-12">
														<div class="form-group">
															<label for="exampleInputName1">Group name<code>*</code></label>
															<input type="hidden" class="form-control"
																id="FILE_TEMPLATE_ID" placeholder="File template id">
															<input type="text" class="form-control"
																id="FILE_TEMPLATE_NAME" placeholder="File template name">
															<code id="FILE_TEMPLATE_NAME_MESSAGE"></code>
														</div>
														<div class="form-group">
															<label for="exampleTextarea1">Description<code>*</code></label>
															<textarea class="form-control" id="FILE_DESCRIPTION"
																rows="3" placeholder="File description"></textarea>
															<code id="FILE_DESCRIPTION_MESSAGE"></code>
														</div>
													</div>
													<div class="col-xl-6 col-lg-12">
														<div class="form-group">
															<label for="exampleInputName1">File template<code>*</code></label>

															<select class="form-select"
																id="multiple-select-file-template"
																data-placeholder="Choose template" multiple>
																<option>Christmas Island</option>
																<option>South Sudan</option>
																<option>Jamaica</option>
																<option>Kenya</option>
																<option>French Guiana</option>
																<option>Mayotta</option>
																<option>Liechtenstein</option>
																<option>Denmark</option>
																<option>Eritrea</option>
																<option>Gibraltar</option>
																<option>Saint Helena, Ascension and Tristan da
																	Cunha</option>
																<option>Haiti</option>
																<option>Namibia</option>
																<option>South Georgia and the South Sandwich
																	Islands</option>
																<option>Vietnam</option>
																<option>Yemen</option>
																<option>Philippines</option>
																<option>Benin</option>
																<option>Czech Republic</option>
																<option>Russia</option>
															</select>
														</div>
													</div>

												</div>

												<button type="button" id="btnSaveFileTemplate"
													class="btn btn-primary mr-2">
													<i class="fa fa-save"></i> SAVE
												</button>
												<button type="button" class="btn btn-secondary"
													id="returnToListBtn">
													<i class="fa fa-caret-left"></i> RETURN TO LIST
												</button>
											</form>


										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="card">
						<div class="tabs">
							<div class="tab-button-outer">
								<ul id="tab-button">
									<li><a data-target="#tab01">Tab 1</a></li>
									<li><a data-target="#tab02">Tab 2</a></li>
									<li><a data-target="#tab03">Tab 3</a></li>
									<li><a data-target="#tab04">Tab 4</a></li>
								</ul>
							</div>
							<div class="tab-select-outer">
								<select id="tab-select" class="form-control">
									<option value="#tab01">Tab 1 1</option>
									<option value="#tab02">Tab 2 2</option>
									<option value="#tab03">Tab 3 3</option>
									<option value="#tab04">Tab 4 4</option>
								</select>
							</div>

							<div id="tab01" class="tab-contents">
								<iframe class="embed-responsive-item" frameBorder="0"
									width="100%" src="<%=request.getContextPath()%>/generate-file-template/3?layout=true"
									name="myframe1" id="myframe1" onload="resizeIframe(this)"></iframe>
							</div>
							<div id="tab02" class="tab-contents">
								<iframe class="embed-responsive-item" frameBorder="0"
									width="100%" src="<%=request.getContextPath()%>/generate-file-template/1?layout=true"
									name="myframe2" id="myframe2" onload="resizeIframe(this)"></iframe>
							</div>
							<div id="tab03" class="tab-contents">
								<iframe class="embed-responsive-item" frameBorder="0"
									width="100%" src="<%=request.getContextPath()%>/generate-file-template/2?layout=true"
									name="myframe3" onload="resizeIframe(this)"></iframe>
							</div>
							<div id="tab04" class="tab-contents">
								<iframe class="embed-responsive-item" frameBorder="0"
									width="100%" src="<%=request.getContextPath()%>/generate-file-template/4?layout=true"
									name="myframe4" onload="resizeIframe(this)"></iframe>
							</div>

							<div class="card-body" style="padding: 1.5rem 1.8rem !important">
								<button type="button" id="btnSaveFileTemplate"
									class="btn btn-primary mr-2">
									<i class="fa fa-save"></i> SAVE
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
			<!-- main-panel ends -->

		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- base:js -->
	<c:import url="include/layout/footer.jsp"></c:import>

</body>
<script>
	// Init multiple Select2
	$('#multiple-select-file-template').select2({
	    theme: "bootstrap-5",
	    width: $( this ).data( 'width' ) ? $( this ).data( 'width' ) : $( this ).hasClass( 'w-100' ) ? '100%' : 'style',
	    placeholder: $( this ).data( 'placeholder' ),
	    closeOnSelect: false,
	    allowClear: true
	});
	// Handle keep order element when add them
	$("#multiple-select-file-template").on("select2:select", function (evt) {
		  var element = evt.params.data.element;
		  var $element = $(element);
		  
		  $element.detach();
		  $(this).append($element);
		  $(this).trigger("change");
	});
	
	//Calc height
	var bodyCalHeight = document.body, htmlCalHeight = document.documentElement;

	var height = Math.max( bodyCalHeight.scrollHeight, bodyCalHeight.offsetHeight, 
		htmlCalHeight.clientHeight, htmlCalHeight.scrollHeight, htmlCalHeight.offsetHeight );
		
	// Resize iframe
	function resizeIframe(iframe) {
        // Set height
		iframe.style.setProperty('height', 'calc(100vh - 175px)' );
		
	}

	$(document).ready(function() {
		var $tabButtonItem = $('#tab-button li'), $tabSelect = $('#tab-select'), $tabContents = $('.tab-contents'), activeClass = 'is-active';

		$tabButtonItem.first().addClass(activeClass);
		$tabContents.not(':first').hide();

		// Event click tab when full size
		$tabButtonItem.find('a').on('click', function(e) {
			
			
			// Get data group from this param key input
			var dataGroupParamKey = myframe1.document.querySelectorAll("[data-group]")
			for (const element of dataGroupParamKey) {
				console.log(element);
				console.log("Attribute data-value : " + element.getAttribute('data-value'));
				console.log("Attribute value : " + element.getAttribute('value'));
				console.log("Attribute id  : " + element.getAttribute('id'));
				
			}
			// Change data
			myframe3.document.getElementById("inputParamValue2").value = myframe1.document.getElementById("inputParamValue2").value;
			debugger;
			
			e.preventDefault();
		  	e.stopImmediatePropagation();
	 	 	e.stopPropagation();
			var target = $(this).attr('data-target');

			$tabButtonItem.removeClass(activeClass);
			$(this).parent().addClass(activeClass);
			$tabSelect.val(target);
			$tabContents.hide();
			$(target).show();
		
		});

		// Event click tab when mini size show combobox
		$tabSelect.on('change', function() {
			debugger;
			var target = $(this).val(), targetSelectNum = $(this).prop('selectedIndex');

			$tabButtonItem.removeClass(activeClass);
			$tabButtonItem.eq(targetSelectNum).addClass(activeClass);
			$tabContents.hide();
			$(target).show();
		});
	});
</script>
</html>

