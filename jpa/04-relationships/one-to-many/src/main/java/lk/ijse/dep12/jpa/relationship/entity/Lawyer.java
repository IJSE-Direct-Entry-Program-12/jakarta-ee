package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lawyer")
public class Lawyer implements Serializable {
    @Id
    @Column(name = "reg_number")
    private String regNumber;
    private String name;
}
