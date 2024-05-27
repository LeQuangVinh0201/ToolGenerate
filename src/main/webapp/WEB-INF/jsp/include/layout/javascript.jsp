<!-- base:js -->
<script
	src="${pageContext.request.contextPath}/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<script
	src="${pageContext.request.contextPath}/vendors/chart.js/Chart.min.js"></script>
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="${pageContext.request.contextPath}/js/off-canvas.js"></script>
<script
	src="${pageContext.request.contextPath}/js/hoverable-collapse.js"></script>
<script src="${pageContext.request.contextPath}/js/template.js"></script>
<script src="${pageContext.request.contextPath}/js/settings.js"></script>
<script src="${pageContext.request.contextPath}/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
<script
	src="${pageContext.request.contextPath}/vendors/sweetalert/sweetalert.min.js"></script>
<script
	src="${pageContext.request.contextPath}/vendors/jquery.avgrund/jquery.avgrund.min.js"></script>
<script src="${pageContext.request.contextPath}/js/alerts.js"></script>
<script src="${pageContext.request.contextPath}/js/avgrund.js"></script>
<script
	src="${pageContext.request.contextPath}/vendors/jquery-toast-plugin/jquery.toast.min.js"></script>
<script src="${pageContext.request.contextPath}/js/toastDemo.js"></script>
<script
	src="${pageContext.request.contextPath}/js/desktop-notification.js"></script>

<script
	src="${pageContext.request.contextPath}/vendors/tinymce/tinymce.min.js"></script>
<script
	src="${pageContext.request.contextPath}/vendors/quill/quill.min.js"></script>
<script
	src="${pageContext.request.contextPath}/vendors/simplemde/simplemde.min.js"></script>
<script src="${pageContext.request.contextPath}/js/editorDemo.js"></script>
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>

<script
	src="${pageContext.request.contextPath}/vendors/datatables.net/jquery.dataTables.js"></script>
<script
	src="${pageContext.request.contextPath}/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<script src="${pageContext.request.contextPath}/js/data-table.js"></script>

<script src="${pageContext.request.contextPath}/js/autosize.js"></script>

<script
	src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>

<!-- Library fancybox zoom image -->
<script
	src="${pageContext.request.contextPath}/js/fancybox.umd.js"></script>
<!-- End custom js for this page-->


<script type="text/javascript">
	/* Handle active menu */
	$(document).ready(function() {
	    var url = window.location.pathname + window.location.search;
	    $('ul.nav a.nav-link[href="' + url + '"]').parent().addClass('active');    
	});

    /* Handle show/ hidden loading */
	$(document).ajaxStart(function() {
	    $("#loadingAjaxCall").show();
	});
	$(document).ajaxStop(function() {
	    $("#loadingAjaxCall").hide();
	});
	
	document.onreadystatechange = function() {
	    if (document.readyState !== "complete") {
	        $("#loadingAjaxCall").show();
	    } else {
	    	$("#loadingAjaxCall").hide();
	    }
	};

	// Convert rem to pixel
	function convertRemToPixels(rem) {    
	    return rem * parseFloat(getComputedStyle(document.documentElement).fontSize);
	}

	
	// Auto height Textarea
	function autoHeightTextarea() {
		autosize(document.querySelectorAll('.textarea-auto-height'));
		$('.textarea-auto-height').each(function () {
			var heightTextAreaAfterAutoSize = this.style.height ? this.style.height.substr(0, this.style.height.indexOf('px')) : 0;
			var defautHeightInput = convertRemToPixels("2.875");
			if ((defautHeightInput * 1.5) > heightTextAreaAfterAutoSize) { // Set defaut height if only 1 row then set height textarea = input
				this.style.height = defautHeightInput + "px";
			}
		}).on('input', function () {
			var heightTextAreaAfterAutoSize = this.style.height ? this.style.height.substr(0, this.style.height.indexOf('px')) : 0;
			var defautHeightInput = convertRemToPixels("2.875");
			if ((defautHeightInput * 1.5) > heightTextAreaAfterAutoSize) { // Set defaut height if only 1 row then set height textarea = input
				this.style.height = defautHeightInput + "px";
			}
		});
	}
	autoHeightTextarea();

	// Scroll smooth into element
	function scrollSmothIntoElement(elementId) {
		if(!elementId) {
			return;
		}
		let id = elementId;
		let yOffset = -120; 
		let element = document.getElementById(id);
		let y = element.getBoundingClientRect().top + window.pageYOffset + yOffset;
		
		window.scrollTo({top: y, behavior: 'smooth'});
	}

	// Scroll to top and bottom
	let btnScrollTop = document.getElementById("btn-back-to-top");
	let btnScrollBottom = document.getElementById("btn-go-to-bottom");

	// When the user scrolls down 20px from the top of the document, show the button
	function displayBtnScroll(isScrollTopAndBottom) {
		if (isScrollTopAndBottom) {
		  btnScrollTop.style.display = "block";
	      btnScrollBottom.style.display = "block";
		}
	}
	
	window.onscroll = function () {
	  scrollFunction();
	};

	function scrollFunction() {
	  /* if (
	    document.body.scrollTop > 20 ||
	    document.documentElement.scrollTop > 20
	  ) {
	    btnScrollTop.style.display = "block";
	    btnScrollBottom.style.display = "block";
	  } else {
	    btnScrollTop.style.display = "none";
	    btnScrollBottom.style.display = "none";
	  } */
	}
	// When the user clicks on the button, scroll to the top of the document
	btnScrollTop.addEventListener("click", backToTop);
	btnScrollBottom.addEventListener("click", goToBottom);

	function backToTop() {
		window.scrollTo({ left: 0, top: 0, behavior: "smooth" });
	}

	function goToBottom() {
		window.scrollTo({ left: 0, top: document.body.scrollHeight, behavior: "smooth" });
	}

	/* START drop and drag upload 1 file */
	document.querySelectorAll(".drop-zone__input").forEach((inputElement) => {
		const dropZoneElement = inputElement.closest(".drop-zone");
	
		dropZoneElement.addEventListener("click", (e) => {
			inputElement.click();
		});
	
		inputElement.addEventListener("change", (e) => {
			if (inputElement.files.length) {
				updateThumbnail(dropZoneElement, inputElement.files[0]);
			}
		});
	
		dropZoneElement.addEventListener("dragover", (e) => {
			e.preventDefault();
			dropZoneElement.classList.add("drop-zone--over");
		});
	
		["dragleave", "dragend"].forEach((type) => {
			dropZoneElement.addEventListener(type, (e) => {
				dropZoneElement.classList.remove("drop-zone--over");
			});
		});
	
		dropZoneElement.addEventListener("drop", (e) => {
			e.preventDefault();
	
			if (e.dataTransfer.files.length) {
				inputElement.files = e.dataTransfer.files;
				updateThumbnail(dropZoneElement, e.dataTransfer.files[0]);
			}
	
			dropZoneElement.classList.remove("drop-zone--over");
		});
	});
	
	/**
	 * Updates the thumbnail on a drop zone element.
	 *
	 * @param {HTMLElement} dropZoneElement
	 * @param {File} file
	 */
	function updateThumbnail(dropZoneElement, file) {
		let thumbnailElement = dropZoneElement.querySelector(".drop-zone__thumb");
	
		// First time - remove the prompt
		if (dropZoneElement.querySelector(".drop-zone__prompt")) {
			dropZoneElement.querySelector(".drop-zone__prompt").remove();
		}
	
		// First time - there is no thumbnail element, so lets create it
		if (!thumbnailElement) {
			thumbnailElement = document.createElement("div");
			thumbnailElement.classList.add("drop-zone__thumb");
			dropZoneElement.appendChild(thumbnailElement);
		}
	
		thumbnailElement.dataset.label = file.name;
	
		// Show thumbnail for image files
		if (file.type.startsWith("image/")) {
			const reader = new FileReader();
	
			reader.readAsDataURL(file);
			reader.onload = () => {
				thumbnailElement.style.backgroundImage = `url('\${reader.result}')`;
			};
		} else {
			thumbnailElement.style.backgroundImage = null;
		}
		// Call api upload file
		uploadFile(file);
	}

	/**
	 * Set Thumnail into div drop zone
	 *
	 * @param {HTMLElement} divDropZone
	 * @param {String} nameFile: name file . ex: demo.jsp
	 * @param {String} pathFile: path file . ex: /2024/03/20240316/b0ed2a47-9a48-45fd-8afb-404fd97a4f15.png
	 */
	function setThumbnail(divDropZone, nameFile, pathFile) {
		if (!divDropZone || !nameFile || !pathFile) {
			return;
		}
		// Check exists file
    	let thumbnailElement = divDropZone.querySelector(".drop-zone__thumb");

    	// First time - remove the prompt
		if (divDropZone.querySelector(".drop-zone__prompt")) {
			divDropZone.querySelector(".drop-zone__prompt").remove();
		}

    	if (!thumbnailElement) {
			thumbnailElement = document.createElement("div");
			thumbnailElement.classList.add("drop-zone__thumb");
			divDropZone.appendChild(thumbnailElement);
		}
		// Set label name file
		thumbnailElement.dataset.label = nameFile || '';
	
		// First time - there is no thumbnail element, so lets create it
		if (!thumbnailElement) {
			thumbnailElement = document.createElement("div");
			thumbnailElement.classList.add("drop-zone__thumb");
			divDropZone.appendChild(thumbnailElement);
		}
    	thumbnailElement.style.backgroundImage = "url(<%=request.getContextPath()%>" + pathFile + ")";
	        
	}

 	function uploadFile(file) {
		// Get form
		var formData = new FormData();
		// List of files to add to form data
		formData.append('files', file);
	
		// Call api upload multiple files
		$.ajax({
			type: "POST",
			enctype: 'multipart/form-data',
			url: contextPath + '/file/upload-multiple',
			data: formData,
	
			// prevent jQuery from automatically transforming the data into a query string
			processData: false,
			contentType: false,
			cache: false,
			timeout: 1000000,
			success: function(data, textStatus, jqXHR) {
				// Ajax call completed successfully 
				showToastSaveSuccess('bottom-right', 'You have upload file successfully!');
				// Call back info file upload
				callBack_fileUploadInfo(data);
			},
			error: function(data) {
				// Some error in ajax call 
				if (data && data.responseJSON && data.responseJSON.message)
					showToastSaveFailure('bottom-right', data.responseJSON.message);
			}
		});
	
	}
	/* END drop and drag upload 1 file */
</script>