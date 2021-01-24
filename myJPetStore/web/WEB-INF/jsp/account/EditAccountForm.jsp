<%@ include file="../common/IncludeTop.jsp"%>
<section class="pricing" >
	<div class="row pricing-content">

		<div class="col-four pricing-intro">
			<h1 class="intro-header" data-aos="fade-up">My Account</h1>

			<p data-aos="fade-up">
			<c:if test="${sessionScope.EditMsg != null}"><font size="3" color="red">${sessionScope.EditMsg}</font></c:if>
				<form action="updateUserInfo?msg=Edit" method="post">
					<h3>User Information</h3>
					<table>
						<tr>
							<td>User ID:</td>
							<td>${sessionScope.account.username}</td>
						</tr>
						<tr>
							<td>New password:</td>
							<td>
								<input type="password" size="30"name="password"/>
							</td>
						</tr>
						<tr>
							<td>Repeat password:</td>
							<td><input type="password" size="30" name="repeatPassword"/></td>
						</tr>
					</table>
					<%@ include file="IncludeAccountFields.jsp"%>
			<p class="tips">${sessionScope.editMsg}</p>
			<input type="submit" name= "editAccount" class="button button-primary large" value="Save Account Information">
			</form>
			<a href="listOrders">My Orders</a>
			<a href="myLog">My Log</a>
			</p>
		</div>
	</div>
</section>

<%@ include file="../common/IncludeBottom.jsp"%>
