<%@ include file="header.jspf" %>
	<form action="register" method="post">
		<fieldset>
			<legend>Registrieren</legend>
			<table>
				<tbody>
					<tr>
						<th>
							<label for="emal">Email</label>
						</th>
						<td>
							<!--<jsp:useBean id="customer" class="de.java2enterprise.onlineshop.model.Customer"></jsp:useBean>-->
							
							<!-- for input -->
							<!-- value='<jsp:getProperty property="email" name="customer"/>' -->
							<input type="email" name="email" size="40" maxlength="40" title="muster@beispiel.de" placeholder="E-Mail eingeben" pattern=".{6,40}" required="required" >
						</td>
					</tr>
					<tr>
						<th>
							<label for="password">Password:</label>
						</th>
						<td>
							<input type="password" name="password" size="10" maxlength="10" title="6-10 Zeichen" placeholder="Passwort eingeben" pattern=".{6,10}" required="required">
						</td>
					</tr>
					<tr>
						<td>
							<input type="reset">
							<input type="submit">
						</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
<%@ include file="footer.jspf"%>