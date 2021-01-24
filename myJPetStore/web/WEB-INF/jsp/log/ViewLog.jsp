<%@ include file="../common/IncludeTop.jsp"%>


<section class="pricing" >
    <div class="row pricing-content">

        <div class="col-four pricing-intro">

    <h2><br>My Browse Log</h2>

    <table>
        <tr>
            <th>Item ID</th>
            <th>Time</th>
        </tr>
        <c:forEach var="browseLogs" items="${sessionScope.browseLogList}">
            <tr>
                <td>
                    <a href="viewItem?itemId=${browseLogs.itemId}">${browseLogs.itemId}</a>
                </td>
                <td>
                        ${browseLogs.logDate}
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>My Add Item To Cart Log</h2>

    <table>
        <tr>
            <th>Item ID</th>
            <th>Time</th>
        </tr>
        <c:forEach var="addItemToCartLogs" items="${sessionScope.addToItemToCartLogList}">
            <tr>
                <td>
                    <a href="viewItem?itemId=${addItemToCartLogs.itemId}">${addItemToCartLogs.itemId}</a>
                </td>
                <td>
                        ${addItemToCartLogs.logDate}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

        <div class="home-scrolldown">
            <a href="viewAccount?msg=Edit" class="scroll-icon smoothscroll">
                <span>Return to My Account</span>
                <i class="icon-arrow-right" aria-hidden="true"></i>
            </a>

        </div>
    </div>
</section>


<%@ include file="../common/IncludeBottom.jsp"%>





