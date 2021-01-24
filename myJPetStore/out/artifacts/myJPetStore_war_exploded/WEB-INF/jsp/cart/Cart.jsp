<%@ include file="../common/IncludeTop.jsp"%>
<script src="js/autoRefreshCart.js"></script>
		<section class="pricing" >
			<div class="row pricing-content " >

<h1 >Shopping Cart</h1>
	<form action="#" method="post">
		<table class="cart-line">
			<tr>
				<th><b>Item ID</b></th>
				<th><b>Product ID</b></th>
				<th><b>Description</b></th>
				<th><b>In Stock?</b></th>
				<th><b>Quantity</b></th>
				<th><b>List Price</b></th>
				<th><b>Total Cost</b></th>
				<th>&nbsp;</th>
			</tr>
			<c:if test="${sessionScope.cart.numberOfItems == 0}">
				<tr>
					<td colspan="8"><b>Your cart is empty.</b></td>
				</tr>
			</c:if>

			<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
				<tr>
					<td>
						<a href="viewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
					</td>
					<td>
							${cartItem.item.product.productId}
					</td>
					<td>
							${cartItem.item.attribute1} ${cartItem.item.attribute2}
							${cartItem.item.attribute3} ${cartItem.item.attribute4}
							${cartItem.item.attribute5} ${cartItem.item.product.name}
					</td>
					<td>
							${cartItem.inStock}
					</td>
					<td>
						<input type="text" id="quantityOf${cartItem.item.itemId}" name="${cartItem.item.itemId}" value="${cartItem.quantity}" onchange="refreshCart('${cartItem.item.itemId}',${cartItem.item.listPrice});"/>
					</td>
					<td>
						<fmt:formatNumber value="${cartItem.item.listPrice}" pattern="$#,##0.00" /></td>
					<td id="totalOf${cartItem.item.itemId}">
						<fmt:formatNumber value="${cartItem.total}" pattern="$#,##0.00" /></td>
					<td>
						<a href="removeItemFromCart?workingItemId=${cartItem.item.itemId}" class="Button">Remove</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7"  id="SubTotal">
					Sub Total: <fmt:formatNumber value="${sessionScope.cart.subTotal}" pattern="$#,##0.00" />
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>

	<c:if test="${sessionScope.cart.numberOfItems > 0}">
		<a href="newOrder" class="button button-primary large">Proceed to Checkout</a>
	</c:if>


			</div>
		</section>




<%@ include file="../common/IncludeBottom.jsp"%>