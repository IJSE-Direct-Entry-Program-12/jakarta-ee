package lk.ijse.dep12.jpa.query.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
@IdClass(OrderDetailPK.class)
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "bar_code")
    private Item item;
    private int qty;
    private BigDecimal price;
}
