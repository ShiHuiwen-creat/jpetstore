<%@ include file="../common/IncludeTop.jsp"%>

<section class="pricing" style="height: 900px">

	<div class="col-ten pricing-table">

			<div class="col-eleven plan-wrap" >
				<div class="plan-block " data-aos="fade-up">

					<div class="plan-bottom-part">
						<table class="two-line">
							<tr>
								<td>${sessionScope.product.description}</td>
							</tr>
							<tr>
								<td><b> ${sessionScope.item.itemId}</b></td>
							</tr>
							<tr>
								<td><b>

										${sessionScope.item.attribute1}
										${sessionScope.item.attribute2}
										${sessionScope.item.attribute3}
										${sessionScope.item.attribute4}
										${sessionScope.item.attribute5}
										${sessionScope.product.name}
								</b></td>
							</tr>
							<tr>
								<td>
									<span>ProductName</span>
								</td>
								<td>${sessionScope.product.name}</td>
							</tr>
							<tr>
								<td>
									<span>Stock</span>
								</td>
								<td>
									<c:if test="${sessionScope.item.quantity <= 0}">
										Back ordered.
									</c:if> <c:if test="${sessionScope.item.quantity > 0}">
										${sessionScope.item.quantity} in stock.
									</c:if>
									</td>
							</tr>
							<tr>
								<td>
									<span>ListPrice</span>
								</td>
								<td>

										<fmt:formatNumber value="${sessionScope.item.listPrice}" pattern="$#,##0.00" />

								</td>
							</tr>

							<tr>
								<td>
									<c:if test="${sessionScope.account != null}"><a class="button button-primary" href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a></c:if>
									<c:if test="${sessionScope.account == null}"><a class="button button-primary" href="viewAccount?msg=SignOn">Add to Cart</a></c:if>
								</td>
							</tr>
						</table>


					</div>

					<div class="home-scrolldown">
						<a href="viewProduct?productId=${sessionScope.product.productId}" class="scroll-icon smoothscroll">
							<span>Return to ${sessionScope.product.productId}</span>
							<i class="icon-arrow-right" aria-hidden="true"></i>
						</a>
					</div>

				</div>
			</div> <!-- end plan-wrap -->

		</div>
<!-- end pricing-table -->

<!-- end pricing-content -->
</section> <!-- end pricing -->


<%@ include file="../common/IncludeBottom.jsp"%>



<%--
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="viewProduct?productId=${sessionScope.product.productId}">Return to ${sessionScope.product.productId}</a>
</div>

<div id="Catalog">
	<table>
		<tr>
			<td>${sessionScope.product.description}</td>
		</tr>
		<tr>
			<td><b> ${sessionScope.item.itemId} </b></td>
		</tr>
		<tr>
			<td><b><font size="4"> ${sessionScope.item.attribute1}
			${sessionScope.item.attribute2} ${sessionScope.item.attribute3}
			${sessionScope.item.attribute4} ${sessionScope.item.attribute5}
			${sessionScope.product.name} </font></b></td>
		</tr>
		<tr>
			<td>${sessionScope.product.name}</td>
		</tr>
		<tr>
			<td><c:if test="${sessionScope.item.quantity <= 0}">
			Back ordered.
		  </c:if> <c:if test="${sessionScope.item.quantity > 0}">
			${sessionScope.item.quantity} in stock.
		  </c:if></td>
		</tr>
		<tr>
			<td><fmt:formatNumber value="${sessionScope.item.listPrice}" pattern="$#,##0.00" /></td>
		</tr>

		<tr>
			<td>
				<c:if test="${sessionScope.account != null}"><a class="Button" href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a></c:if>
				<c:if test="${sessionScope.account == null}"><a class="Button" href="viewAccount?msg=SignOn">Add to Cart</a></c:if>
		   </td>
		</tr>
	</table>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>



--%>
