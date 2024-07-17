package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @Entity
@Table(name = "partner")
public class Partner implements Serializable {
    @Id
    @JoinColumn(name = "user1_nic", referencedColumnName = "nic")
    @OneToOne
    private User user1Nic;
    @OneToOne
    @JoinColumn(name = "user2_nic", referencedColumnName = "nic")
    private User user2Nic;
    // private Date date;
}
