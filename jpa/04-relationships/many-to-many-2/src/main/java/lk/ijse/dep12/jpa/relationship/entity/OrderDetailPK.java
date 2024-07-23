package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.Column;
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
