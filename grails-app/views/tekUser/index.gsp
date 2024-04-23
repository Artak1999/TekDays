<%@ page import="com.tekdays.TekUser" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'tekUser.label', default: 'TekUser')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script>
        function callDelete(userId) {
            if (confirm("Դուք համոզված եք ?")) {
                $.ajax({
                    type: "POST",
                    url: "/TekDays/tekUser/delete/",
                    data: {
                        id: userId
                    },
                    cache: false,
                    success: function () {
                        alert("Անձը ջնջվել է!")
                    },
                    error: function () {
                        console.log('Error during getting services to be added for partner with id: ' + $(this).children("option:selected").val());
                        alert("Տվյալ անձը չի կարող հեռացվել քանի որ ներառված է միջոցառմանը!")
                    }
                });
            }
        }

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
                        aTargets: [1],
                        visible: true,
                        bSearchable: true,
                        bSortable: true
                    },
                    {
                        render: function (data, type, full, meta) {
                            if (full[4]) {
                                return '<a href="https://' + data + '" class="btn" target="_blank">' + data + '</a>';
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
                        visible: false
                    },
                    {
                        createdCell: function (td, cellData, rowData, row, col) {
                            $(td).attr('style', 'color: #423F3FFF; text-align: center');
                        },
                        render: function (data, type, full, meta) {
                            return '<a href="${createLink(controller: 'TekUser', action: 'edit')}/' + data + '" class="btn" title="Խմբագրել"><i class="fa fa-pencil-square-o fa-2x" style="color: #56949F;"></i>' + '</a>';
                        },
                        aTargets: [5],
                        bSearchable: false,
                        bSortable: true,
                        visible: true
                    },
                    {
                        createdCell: function (td, cellData, rowData, row, col) {
                            $(td).attr('style', 'color: #423F3FFF; text-align: center');
                        },
                        render: function (data, type, full, meta) {
                            return '<a href="#" class="btn delete-btn" onclick="callDelete(' + data + ')" title="Ջնջել"><i class="fa fa-trash fa-2x" style="color: red;"></i>' + '</a>';
                        },
                        aTargets: [6],
                        bSearchable: false,
                        bSortable: true,
                        visible: true
                    },
                    {
                        createdCell: function (td, cellData, rowData, row, col) {
                            $(td).attr('style', 'color: #423F3FFF; text-align: center');
                        },
                        render: function (data, type, full, meta) {
                            return '<a href="${createLink(controller: 'TekUser', action: 'revision')}/' + data + '" class="btn" title="Տեսնել փոփոխությունը"><i class="fa fa-history fa-2x"></i>' + '</a>';
                        },
                        aTargets: [7],
                        bSearchable: false,
                        bSortable: true,
                        visible: true
                    },
                ]
            });
        });
    </script>
</head>

<body>

<a href="#list-tekUser" class="skip" tabindex="-1">
    <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
</a>

<div class="nav" role="navigation">
    <ul>
        <li>
            <a class="home" href="${createLink(uri: '/')}">
                <g:message code="default.home.label"/>
            </a>
        </li>
        <li>
            <g:link class="create" action="create">
                <g:message code="default.new.label" args="[entityName]"/>
            </g:link>
        </li>
    </ul>
</div>

<div id="list-tekUser" class="content scaffold-list" role="main">
    <h1 style="text-align: center">
        <g:message code="default.list.label" args="[entityName]"/>
    </h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
</div>
<table class="display compact" id="dt">
    <thead>
    <tr>
        <th>FullName</th>
        <th>Email</th>
        <th>Website</th>
        <th>Bio</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Revisions</th>
    </tr>
    </thead>
    <tbody></tbody>
    <tfoot>
    <tr>
        <th>FullName</th>
        <th>Email</th>
        <th>Website</th>
        <th>Bio</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Revisions</th>
    </tr>
    </tfoot>
</table>
</body>
</html>

