package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.persistence.ItemDAO;
import org.csu.mypetstore.persistence.LineItemDAO;
import org.csu.mypetstore.persistence.OrderDAO;
import org.csu.mypetstore.persistence.SequenceDAO;
import org.csu.mypetstore.persistence.impl.ItemDAOImpl;
import org.csu.mypetstore.persistence.impl.LineItemDAOImpl;
import org.csu.mypetstore.persistence.impl.OrderDAOImpl;
import org.csu.mypetstore.persistence.impl.SequenceDAOImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private SequenceDAO sequenceDAO;
    private LineItemDAO lineItemDAO;

    public OrderService (){
        itemDAO = new ItemDAOImpl();
        orderDAO = new OrderDAOImpl();
        sequenceDAO = new SequenceDAOImpl();
        lineItemDAO = new LineItemDAOImpl();
    }

    public void insertOrder(Order order) {
        order.setOrderId(getNextId("ordernum"));
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = order.getLineItems().get(i);
            String itemId = lineItem.getItemId();
            Integer increment = lineItem.getQuantity();
            Map<String, String> param = new HashMap<String, String>(2);
            param.put("itemId", itemId);
            param.put("increment", String.valueOf(increment));
//            itemDAO.updateInventoryQuantity(param);
        }

        orderDAO.insertOrder(order);
        orderDAO.insertOrderStatus(order);
        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = order.getLineItems().get(i);
            lineItem.setOrderId(order.getOrderId());
            lineItemDAO.insertLineItem(lineItem);
        }
    }

    public Order getOrder(int orderId) {
        Order order = orderDAO.getOrder(orderId);
        order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));

        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = order.getLineItems().get(i);
            Item item = itemDAO.getItem(lineItem.getItemId());
            item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }

        return order;
    }

    public List<Order> getOrdersByUsername(String username) {
        return orderDAO.getOrdersByUsername(username);
    }

    public int getNextId(String name) {
        Sequence sequence = new Sequence(name, -1);
        sequence = sequenceDAO.getSequence(sequence);
        if (sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
                    + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceDAO.updateSequence(parameterObject);
        return sequence.getNextId();
    }

}
