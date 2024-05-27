<!-- base:css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/typicons/typicons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/jquery-toast-plugin/jquery.toast.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/quill/quill.snow.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/simplemde/simplemde.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/ti-icons/css/themify-icons.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/vendors/datatables.net-bs4/dataTables.bootstrap4.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fancybox.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2-bootstrap-5-theme.min.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dataTables.dataTables.css" />
<style>
.sidebar {
	margin-bottom: 0px !important;
}
.main-panel {
	padding-top: 80px !important;
}
.navbar+.page-body-wrapper {
	padding-top: 0px !important;
}

.form-control, .select2-container--default .select2-selection--single,
	.select2-container--default .select2-selection--single .select2-search__field,
	.typeahead, .tt-query, .tt-hint {
	border: 1px solid #bebebe !important;
}
#loadingAjaxCall {
  background-color:#eeeeff;
  position: fixed;
  display: block;
  top: 0;
  bottom: 0;
  z-index: 1000000;
  opacity: 0.5;
  width: 100%;
  height: 100%;
  text-align: center;
}

#loadingAjaxCall img {
  margin: auto;
  display: block;
  top: calc(50% - 100px);
  left: calc(50% - 10px);
  position: absolute;
  z-index: 999999;
}

select.form-control, .select2-container--default select.select2-selection--single, .select2-container--default .select2-selection--single select.select2-search__field, select.typeahead, select.tt-query, select.tt-hint {
  color: #495057 !important;
}

.fake-disable {
	pointer-events:none;
}
.form-control[readonly] {
	background-color: white;
}

.sidebar .nav:not(.sub-menu) {
    margin-top: 1rem;
    margin-left: 5px;
    margin-right: 5px;
}
.toggle-slider.round {
    border-color: #844fc1;
}
textarea {
	line-height: normal !important;
}
.textarea-auto-height {
	max-height: 400px;
	padding: 0.375rem 1.375rem;
}
#btn-back-to-top {
  position: fixed;
  bottom: 80px;
  right: 15px;
  display: none;
  z-index:100;
  position: fixed;
}

#btn-go-to-bottom {
  position: fixed;
  bottom: 20px;
  right: 15px;
  display: none;
  z-index:100;
  position: fixed;
}

/* Start css drag and drop upload 1 file */
.drop-zone {
  max-width: 200px;
  height: 200px;
  padding: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  font-family: "Quicksand", sans-serif;
  font-weight: 500;
  font-size: 20px;
  cursor: pointer;
  color: #cccccc;
  border: 4px dashed #009578;
  border-radius: 10px;
}

.drop-zone--over {
  border-style: solid;
}

.drop-zone__input {
  display: none;
}

.drop-zone__thumb {
  width: 100%;
  height: 100%;
  border-radius: 10px;
  overflow: hidden;
  background-color: #ffffff;
  background-size: cover;
  position: relative;
}

.drop-zone__thumb::after {
  content: attr(data-label);
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  padding: 5px 0;
  color: #ffffff;
  background: rgba(0, 0, 0, 0.75);
  font-size: 11px;
  text-align: center;
}

.border-style {
	border: 4px dashed #009578;
    border-radius: 10px;
}
.border-none {
	border: none !important;
    outline: none;
}
/* End css drag and drop upload 1 file */

</style>