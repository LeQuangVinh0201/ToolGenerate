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

