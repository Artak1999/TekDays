<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Login</title>
</head>

<body>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>

  <g:form action="registration">
    <table style="display: flex; justify-content: center">
      <tr class="prop">
        <td class="name">
          <label for="userName">Username:</label>
        </td>
        <td class="value">
          <input type="text" id="userName" name="userName" value="" required>
        </td>
      </tr>

      <tr class="prop">
        <td class="name">
          <label for="fullName">Full name:</label>
        </td>
        <td class="value">
          <input type="text" id="fullName" name="fullName" value="" required>
        </td>
      </tr>

      <tr class="prop">
        <td class="name">
          <label for="email">Email:</label>
        </td>
        <td class="value">
          <input type="text" id="email" name="email" value="" required>
        </td>
      </tr>

      <tr class="prop">
        <td class="name">
          <label for="password">Password:</label>
        </td>
        <td class="value">
          <input type="password" id="password" name="password" value="" required>
        </td>
      </tr>

      <tr class="prop">
        <td class="name">
          <label for="website">Website:</label>
        </td>
        <td class="value">
          <input type="text" id="website" name="website" value="" required>
        </td>
      </tr>

      <tr class="prop">
        <td class="name">
          <label for="bio">Bio:</label>
        </td>
        <td class="value">
          <input type="text" id="bio" name="bio" value="" required>
        </td>
      </tr>

      <tr>
        <td>
        </td>
        <td>
          <input type="submit" value="Sign up"/>
        </td>
      </tr>
    </table>
  </g:form>
</body>
</html>