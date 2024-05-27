<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Tool generate</title>
<c:import url="include/layout/css.jsp"></c:import>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>" readonly></input>
<script type="text/javascript">
	var contextPath = document.getElementById("contextPath").value || '';
	console.log("==== CONTEXT PATH ==== : " + contextPath);
	var callBack_fileUploadInfo;

	function isEmpty(str) {
	    return str == null || !str.trim().length;
	}

</script>
</head>
<!-- Back to top button -->
<button type="button" class="btn btn-danger btn-rounded btn-icon" id="btn-back-to-top">
  <i class="fa fa-arrow-up"></i>
</button>

<button type="button" class="btn btn-danger btn-rounded btn-icon" id="btn-go-to-bottom">
  <i class="fa fa-arrow-down"></i>
</button>