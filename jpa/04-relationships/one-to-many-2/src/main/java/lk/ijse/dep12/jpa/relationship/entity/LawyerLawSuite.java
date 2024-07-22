package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lawyer_law_suite")
public class LawyerLawSuite implements Serializable {
    @Id
    @JoinColumn(name = "law_suite_id", referencedColumnName = "id")
    @OneToOne
    private LawSuite lawSuite;

    @ManyToOne
    @JoinColumn(name = "lawyer_reg_number", referencedColumnName = "reg_number")
    private Lawyer lawyer;

    private BigDecimal fee;
    @Column(name = "retainer_date")
    private Date retainerDate;
}
