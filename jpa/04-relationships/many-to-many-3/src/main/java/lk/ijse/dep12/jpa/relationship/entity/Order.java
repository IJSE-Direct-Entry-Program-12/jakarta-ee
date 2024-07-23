package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    private String id;
    private Date date;
    @Column(name = "customer_name")
    private String customerName;
}
