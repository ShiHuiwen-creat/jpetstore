<%@ include file="../common/IncludeTop.jsp"%>
<section class="pricing" style="height: 900px">

	<div class="col-ten pricing-table">
		<div class="row">
			<div class="col-eleven plan-wrap">
				<div class="plan-block primary" data-aos="fade-up">

					<div class="plan-top-part">
						<h3 >${sessionScope.category.name}</h3>
					</div>

					<div class="plan-bottom-part">
						<table>
							<tr class="plan-block-features">
								<th>Product ID</th>
								<th>Name</th>
							</tr>
							<c:forEach var="product" items="${sessionScope.productList}">
								<tr>
									<td>
											<span>
												<a href="viewProduct?productId=${product.productId}"><p2>${product.productId}</p2></a>
											</span>
									</td>
									<td><p3>${product.name}</p3></td>
								</tr>
							</c:forEach>
						</table>


					</div>
					<div class="home-scrolldown">
						<a href="main" class="scroll-icon smoothscroll">
							<span>Return to Main-></span>
						</a>

						</a>
					</div>

				</div>
			</div> <!-- end plan-wrap -->

		</div>
<!-- end pricing-table -->

	</div> <!-- end pricing-content -->
</section> <!-- end pricing -->
<%@ include file="../common/IncludeBottom.jsp"%>

<%--
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

<h2>${sessionScope.category.name}</h2>

<table>
	<tr>
		<th>Product ID</th>
		<th>Name</th>
	</tr>
	<c:forEach var="product" items="${sessionScope.productList}">
		<tr>
			<td>
				<a href="viewProduct?productId=${product.productId}">${product.productId}</a>
			</td>
			<td>${product.name}</td>
		</tr>
	</c:forEach>
</table>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>--%>


