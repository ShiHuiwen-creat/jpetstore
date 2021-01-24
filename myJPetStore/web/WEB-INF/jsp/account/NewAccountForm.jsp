<%@ include file="../common/IncludeTop.jsp"%>

<script src="js/checkUsernameIsExist.js"></script>

<section class="pricing">
	<div class="row pricing-content">



		<div class="col-ten pricing-table">
			<div class="row">

				<div class="col-eight plan-wrap">
					<div class="plan-block" data-aos="fade-up">

						<div class="plan-top-part">
							<h3 class="plan-block-title">NewAccount</h3>
						</div>

						<div class="plan-bottom-part">
							<form action="updateUserInfo?msg=New" method="post" name="registerForm">
								<h3>User Information</h3>

								<table>
									<tr>
										<td><span>User ID:</span></td>
										<td><input type="text" name="username" onkeyup="usernameIsExist();"/>
											<div id="usernameMsg"></div>
										</td>

									</tr>
									<tr>
										<td>New password:</td>
										<td><input type="password" name="password"/></td>
										<p class="error">${sessionScope.passwordMsg}</p>
									</tr>
									<tr>
										<td>Repeat password:</td>
										<td><input type="password" name="repeatPassword"/></td>
									</tr>
									<p class="error">${sessionScope.usernameMsg}</p>
									<%--		<%@ include file="IncludeAccountFields.jsp"%>--%>

								</table>
								<p class="error">${sessionScope.registerMsg}</p>
								<input type="submit" name="newAccount" class="button button-primary large" value="Save Account Information"/>

							</form></div>

					</div>

				</div>
			</div> <!-- end plan-wrap -->

		</div> <!-- end plan-wrap -->

	</div>
	</div> <!-- end pricing-table -->

	</div> <!-- end pricing-content -->
</section> <!-- end pricing -->

<%@ include file="../common/IncludeBottom.jsp"%>

<%--
<%@ include file="../common/IncludeTop.jsp"%>
<script src="js/checkUsernameIsExist.js"></script>
<div id="Catalog">
	<form action="updateUserInfo?msg=New" method="post" name="registerForm">
		<h3>User Information</h3>
		<table>
			<tr>
				<td>User ID:</td>
				<td>
					<input type="text" name="username" onblur="usernameIsExist();"/>
					<div id="usernameMsg"></div>
					</td>
			</tr>
			<tr>
				<td>New password:</td>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td>Repeat password:</td>
				<td>
					<input type="password" name="repeatPassword"/>
				</td>
			</tr>
		</table>

&lt;%&ndash;		<%@ include file="IncludeAccountFields.jsp"%>&ndash;%&gt;

		<input type="submit" name="newAccount" value="Save Account Information"/>
	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>--%>
