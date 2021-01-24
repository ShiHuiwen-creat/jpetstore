function dynamicShipping(checkbox){
    if (checkbox.checked)
        $("#addShipForm").append("<div id=\"Catalog\">\n" +
            "\n" +
            "\t\t<table>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<th colspan=2>Shipping Address</th>\n" +
            "\t\t\t</tr>\n" +
            "\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>First name:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" name=\"order.shipToFirstName\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Last name:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" name=\"order.shipToLastName\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Address 1:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" size=\"40\" name=\"order.shipAddress1\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Address 2:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" size=\"40\" name=\"order.shipAddress2\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>City:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" name=\"order.shipCity\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>State:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" size=\"4\" name=\"order.shipState\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Zip:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" size=\"10\" name=\"order.shipZip\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t\t<tr>\n" +
            "\t\t\t\t<td>Country:</td>\n" +
            "\t\t\t\t<td>\n" +
            "\t\t\t\t\t<input type=\"text\" size=\"15\" name=\"order.shipCountry\"/>\n" +
            "\t\t\t\t</td>\n" +
            "\t\t\t</tr>\n" +
            "\t\t</table>\n" +
            "\n" +
            "</div>");
    else $("#addShipForm").empty();
}