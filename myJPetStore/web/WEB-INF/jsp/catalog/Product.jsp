<%@ include file="../common/IncludeTop.jsp"%>
<section class="pricing" style="height: 900px">

	<div class="col-ten pricing-table">
		<div class="row">
			<div class="col-eleven plan-wrap">
				<div class="plan-block primary" data-aos="fade-up">

					<div class="plan-top-part">
						<p class="plan-block-price">${sessionScope.product.name}</p>
					</div>

					<div class="plan-bottom-part">
						<table>
							<tr>
								<th>Item ID</th>
								<th>Product ID</th>
								<th>Description</th>
								<th>List Price</th>
								<th>&nbsp;${sessionScope.qty}</th>
							</tr>
							<c:forEach var="item" items="${sessionScope.itemList}">
								<tr>
									<td>
										<a href="viewItem?itemId=${item.itemId}"><p2>${item.itemId}</p2></a>
									</td>
									<td>
										<p3>${item.product.productId}</p3>
									</td>
									<td>
										<p3>${item.attribute1} ${item.attribute2} ${item.attribute3}
												${item.attribute4} ${item.attribute5} ${sessionScope.product.name}
										</p3>
									</td>
									<td>
										<p3><fmt:formatNumber value="${item.listPrice}"
															  pattern="$#,##0.00" />
										</p3>
									</td>
									<td>
										<c:if test="${sessionScope.account !=null}"><a class="button button-primary" href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a></c:if>
										<c:if test="${sessionScope.account ==null}"><a class="button button-primary" href="viewAccount?msg=SignOn">Add to Cart</a></c:if>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td>
								</td>
							</tr>
						</table>
					</div>


					<!-- end home-social-list -->

					<div class="home-scrolldown">
							<a href="viewCategory?categoryId=${sessionScope.product.categoryId}" class="scroll-icon smoothscroll">
								<span>Return to ${sessionScope.product.categoryId}-></span>
							</a>
					</div>
				</div>
			</div> <!-- end plan-wrap -->

		</div>

	</div> <!-- end pricing-table -->
	<!-- end pricing-content -->
</section> <!-- end pricing -->



<%@ include file="../common/IncludeBottom.jsp"%>


<%--

<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="viewCategory?categoryId=${sessionScope.product.categoryId}">Return to ${sessionScope.product.categoryId}</a>
</div>

<div id="Catalog">

<h2>${sessionScope.product.name}</h2>

<table>
	<tr>
		<th>Item ID</th>
		<th>Product ID</th>
		<th>Description</th>
		<th>List Price</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach var="item" items="${sessionScope.itemList}">
		<tr>
			<td>
				<a href="viewItem?itemId=${item.itemId}">${item.itemId}</a>
			</td>
			<td>
					${item.product.productId}
			</td>
			<td>
					${item.attribute1} ${item.attribute2} ${item.attribute3}
					${item.attribute4} ${item.attribute5} ${sessionScope.product.name}
			</td>
			<td>
				<fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" />
			</td>
			<td>
				<c:if test="${sessionScope.account !=null}"><a class="Button" href="addItemToCart?workingItemId=${item.itemId}">Add to Cart</a></c:if>
				<c:if test="${sessionScope.account ==null}"><a class="Button" href="viewAccount?msg=SignOn">Add to Cart</a></c:if>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td>
		</td>
	</tr>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>

--%>




