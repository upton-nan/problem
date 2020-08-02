<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${ctx}/static/css/element.css">

<script type="text/javascript" src="${ctx}/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/axios.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/vue.js"></script>
<script type="text/javascript" src="${ctx}/static/js/element.js"></script>
<script type="text/javascript">
	$GV = {
		ROOT : "${ctx}"
	};
</script>


