package lk.ijse.dep12.jpa.query.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailPK implements Serializable {
    private Order order;
    private Item item;
}
