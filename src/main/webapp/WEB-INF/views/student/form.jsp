
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form modelAttribute="student">

    First name<form:input path="firstName"/><br>
    Last name<form:input path="lastName"/><br>
    Gender<form:radiobuttons path="gender" /><br>
    Country<form:select path="country"/><br>
    Notes<form:textarea name="notes" path="notes"/><br>
    Mailing List<form:checkboxes path="mailingList" items=""/><br>
    Programming Skills<form:select name="programmingskills" path="programmingSkills"/><br>
    Hobbies<form:checkboxes path="hobbies" items="JAVA"/><br>
    <input type="submit" value="Dodaj dane">
    </label>
</form:form>

</body>
</html>
