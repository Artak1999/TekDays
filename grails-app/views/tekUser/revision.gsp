<%@ page import="com.tekdays.TekUser" %>
<%

%>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'tekUser.label', default: 'TekUser')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-tekUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
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
    <h1 style="text-align: center"><g:message code="default.list.label" args="[entityName]"/></h1>
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
                <th>Created Date</th>
                <th>Last Updated</th>
            </tr>
        </thead>
        <tbody>
            <g:each var="audited" in="${data["result"]}">
                <tr>
                    <td>${audited['full_name']}</td>
                    <td>${audited['email']}</td>
                    <td>${audited['website']}</td>
                    <td>${audited['bio']}</td>
                    <td>${audited['date_created']}</td>
                    <td>${audited['last_updated']}</td>
                </tr>
            </g:each>
        </tbody>
        <tfoot>
            <tr>
                <th>FullName</th>
                <th>Email</th>
                <th>Website</th>
                <th>Bio</th>
                <th>Created Date</th>
                <th>Last Updated</th>
            </tr>
        </tfoot>
    </table>
</body>
</html>
