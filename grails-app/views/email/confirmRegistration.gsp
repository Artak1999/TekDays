<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <title>Email For Registration</title>
  </head>

  <body>
    <%@ page contentType="text/plain" %>
    Dear ${user.fullName}
    Congratulations! You have registered with TekDays, giving you access to be part of great event.
    Your login id is: ${user.userName}
    Kind Regards,
    The TekDays Team
  </body>
</html>