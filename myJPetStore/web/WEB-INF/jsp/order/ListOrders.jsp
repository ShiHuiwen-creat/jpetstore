<%@ include file="../common/IncludeTop.jsp"%>
<section class="pricing" >
	<div class="row pricing-content">

		<div class="col-four pricing-intro">
<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Date</th>
		<th>Total Price</th>
	</tr>
	<c:if test="${sessionScope.orderList == null}">
		<tr>
			<td colspan="3"><b>Your orderList is empty.</b></td>
		</tr>
	</c:if>
	<c:forEach var="order" items="${sessionScope.orderList}">
		<tr>
			<td>
				<a href="viewOrder?orderId=${order.orderId}&msg=view">${order.orderId}</a>
			</td>
			<td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd" /></td>
			<td><fmt:formatNumber value="${order.totalPrice}" pattern="$#,##0.00" /></td>
		</tr>
	</c:forEach>
</table>
<div class="home-scrolldown">
	<a href="viewCategory?categoryId=${sessionScope.product.categoryId}" class="scroll-icon smoothscroll">
		<span>Return to ${sessionScope.product.categoryId}-></span>
	</a>
</div>
		</div>
	</div>
</section>

<%@ include file="../common/IncludeBottom.jsp"%>


