<%@ include file="../common/IncludeTop.jsp"%>


<section class="pricing" >
	<div class="row pricing-content">
		<div class="col-four pricing-intro">
			<h1 class="intro-header" data-aos="fade-up">Sign In</h1>
			<form action="SignOn" method="post">
				<font size="3" color="red">${sessionScope.message}</font>
				<table>
					<tr>
						<td>Username:</td>
						<td><input type="text" name="username" value="${sessionScope.username}" autocomplete="off"/></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" value="${sessionScope.password}" /></td>
					</tr>
					<tr>
						<td>VerifyCode:</td>
						<td><input name="vcode" type="text" class="input02"id="vcode">
							<img src ="check" align="absmiddle" title="change" onClick="this.src=this.src+'?'"/></td>
					</tr>
				</table>

				<input type="submit" class="button button-primary large"  value="Login" />
			</form>
			Need a user name and password?
			<a href="viewAccount?msg=New">Register Now!</a>
		</div>
	</div>
</section>

<%@ include file="../common/IncludeBottom.jsp"%>




<%--<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">
	<form action="SignOn" method="post">
	<p>${sessionScope.message}</p>
	<p>Username:<input type="text" name="username"/> <br />
	Password:<input type="password" name="password"/></p>
	<input type="submit" value="Login">
	</form>
	Need a user name and password?
	<a href="viewAccount?msg=New">Register Now!</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>--%>

