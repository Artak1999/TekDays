<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>TekDays - Dashboard</title>
    <meta name="layout" content="main"/>
</head>

<body>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}">Home</a></li>
            <li>
                <g:link class="create" controller="task" action="create">
                    Create Chapter 9. Big-Picture Views • 144 report erratum • discussTask
                </g:link>
            </li>
            <li>
                <g:link class="create" controller="sponsorship" action="create">
                    Add Sponsor
                </g:link>
            </li>
            <li>
                <g:link class="list" controller="sponsor" action="index">
                    All Sponsors
                </g:link>
            </li>
        </ul>
    </div>

    <div id="event" style='margin:10px 10px 10px 10px'>
        <g:render template="event" model="${['event': event]}"/>
    </div>

    <div id="tasks" style='margin:10px 10px 10px 10px'>
        <g:render template="tasks" model="${['tasks': tasks]}"/>
    </div>

    <div id="volunteers" style='margin:10px 10px 10px 10px'>
        <g:render template="volunteers" model="${['volunteers': volunteers]}"/>
    </div>

    <div id="messages" style='margin:10px 10px 10px 10px'>
        <g:render template="messages" model="${[messages: messages]}"/>
    </div>

    <div id="sponsors" style='margin:10px 10px 10px 10px'>
        <g:render template="sponsors" model="${[sponsorships: sponsorships]}"/>
    </div>

    <div id="twitter" style='margin:10px 10px 10px 10px'>
        <g:render template="twitter" model="${[event:event]}" />
    </div>
</body>
</html>