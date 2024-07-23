package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    private int qty;
    private BigDecimal price;

    @ManyToOne
    @MapsId("orderId")
    //@JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @MapsId("itemCode")
    // @JoinColumn(name = "item_code", referencedColumnName = "code", insertable = false, updatable = false)
    private Item item;

    public OrderDetail(Order order, Item item, int qty, BigDecimal price) {
        this.orderDetailPK = new OrderDetailPK(order.getId(), item.getCode());
        this.order = order;
        this.item = item;
        this.qty = qty;
        this.price = price;
    }

//    public OrderDetail(OrderDetailPK orderDetailPK, int qty, BigDecimal price) {
//        this.orderDetailPK = orderDetailPK;
//        this.qty = qty;
//        this.price = price;
//    }
//
//    public OrderDetail(String orderId, String itemCode, int qty, BigDecimal price) {
//        this.orderDetailPK = new OrderDetailPK(orderId, itemCode);
//        this.qty = qty;
//        this.price = price;
//    }
}
