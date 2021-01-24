<%@ include file="../common/IncludeTop.jsp"%>
<section class="pricing" >
	<div class="row pricing-content">

		<div class="col-four pricing-intro">
	<form action="ship" method="post">
		<table>
			<tr>
				<th colspan=2>Shipping Address</th>
			</tr>

			<tr>
				<td>First name:</td>
				<td>
					<input type="text" name="order.shipToFirstName"/>
				</td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td>
					<input type="text" name="order.shipToLastName"/>
				</td>
			</tr>
			<tr>
				<td>Address 1:</td>
				<td>
					<input type="text" size="40" name="order.shipAddress1"/>
				</td>
			</tr>
			<tr>
				<td>Address 2:</td>
				<td>
					<input type="text" size="40" name="order.shipAddress2"/>
				</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>
					<input type="text" name="order.shipCity"/>
				</td>
			</tr>
			<tr>
				<td>State:</td>
				<td>
					<input type="text" size="4" name="order.shipState"/>
				</td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td>
					<input type="text" size="10" name="order.shipZip"/>
				</td>
			</tr>
			<tr>
				<td>Country:</td>
				<td>
					<input type="text" size="15" name="order.shipCountry"/>
				</td>
			</tr>
		</table>
		<input type="submit" name="newOrder" value="Continue"/>
	</form>
</div>
	</div>
</section>


<%@ include file="../common/IncludeBottom.jsp"%>