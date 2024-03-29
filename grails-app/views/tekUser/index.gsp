<%@ page import="com.tekdays.TekUser" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tekUser.label', default: 'TekUser')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<script>
			$(document).ready(function () {
				$('#dt').DataTable({
					sScrollY: "75%",
					sScrollX: "100%",
					bProcessing: true,
					bServerSide: true,
					sAjaxSource: "/TekDays/tekUser/dataTablesRenderer",
					bJQueryUI: false,
					bAutoWidth: false,
					sPaginationType: "full_numbers",
					aLengthMenu: [5, 10, 25, 50, 100, 200],
					iDisplayLength: 5,
					aoColumnDefs: [
						{
							aTargets: [0],
							visible: true,
							bSortable: true
						},
						{
							render: function (data, type, full, meta) {
								if (full[4]) {
									return '<a href="${createLink(controller: 'TekUser', action: 'show')}/' + full[4] + '"class="btn">' + data + '</a>';
								} else {
									return data;
								}
							},
							aTargets: [1],
							visible: true,
							bSearchable: true,
							bSortable: true
						},
						{
							render: function (data, type, full, meta) {
								if (full[4]) {
									return '<a href="${createLink(controller: 'TekUser', action: 'show')}/' + full[4] + '"class="btn">' + data + '</a>';
								} else {
									return data;
								}
							},
							aTargets: [2],
							visible: true,
							bSearchable: true,
							bSortable: true
						},
						{
							createdCell: function (td, cellData, rowData, row, col) {
								$(td).attr('style', 'color: #423F3FFF');
							},
							aTargets: [3],
							bSearchable: false,
							bSortable: false,
							visible: true
						},
						{
							createdCell: function (td, cellData, rowData, row, col) {
								$(td).attr('style', 'color: #423F3FFF');
							},
							aTargets: [4],
							bSearchable: false,
							bSortable: false,
							visible: true
						},
					]
				});
			});
		</script>
	</head>
	<body>
		<a href="#list-tekUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tekUser" class="content scaffold-list" role="main">
			<h1 style="text-align: center"><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
		</div>
	<table class="table-bordered" id="dt">
		<thead>
			<tr>
				<th>fullName</th>
				<th>email</th>
				<th>website</th>
				<th>bio</th>
				<th>password</th>
			</tr>
		</thead>
	</table>
	</body>
</html>
