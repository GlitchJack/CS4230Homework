<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Jack's Super Awesome Webpage</title>
	</head>
	<body>
		<h1>Contacts</h1>
		<ul>
		 <c:forEach items="${contacts}" var="contact">
    		<li><c:out value="${contact.firstName}"></c:out>
    			<c:out value="${contact.lastName}"></c:out>
    			<c:out value="Phone Num: (${contact.phoneNum})"></c:out>
    			<c:out value="Home Address: (${contact.homeAddress})"></c:out>
    			<c:out value="Business Address: (${contact.businessAddress})}"></c:out></li>
		</c:forEach>
		</ul>
		<h2>Add Contact Form</h2>
		<p>(* means required field)</p>
		<form name="add_contact_form" action="/MyServlet" method="post">
			<label for="fname">First name*:</label><br>
  			<input type="text" id="fname" name="fname" required><br>
  			<label for="lname">Last name*:</label><br>
  			<input type="text" id="lname" name="lname" required><br>
  			<label for="phonenum">Phone Number:</label><br>
  			<input type="text" id="phonenum" name="phonenum"><br>
  			<label for="homeaddr">Home Address*:</label><br>
  			<input type="text" id="homeaddr" name="homeaddr"><br>
  			<label for="busiaddr">Business Address*:</label><br>
  			<input type="text" id="busiaddr" name="busiaddr"><br>
  			<input type="submit" value="Add Contact">
		</form>
		<c:out value="${errormessage}"></c:out>
	</body>
</html>