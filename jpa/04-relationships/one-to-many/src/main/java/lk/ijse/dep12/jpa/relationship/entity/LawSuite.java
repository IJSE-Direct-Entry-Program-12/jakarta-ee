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
@Table(name = "law_suite")
public class LawSuite implements Serializable {
    @Id
    private String id;
    private String type;
    private String description;
    @Column(name = "filed_date")
    private Date filedDate;
    @JoinColumn(name = "lawyer_reg_number", referencedColumnName = "reg_number")
    @ManyToOne
    private Lawyer lawyer;
    @Column(name = "lawyer_retainer_date")
    private Date lawyerRetainerDate;
    @Column(name = "lawyer_fee")
    private BigDecimal lawyerFee;

    public LawSuite(String id, String type, String description, Date filedDate) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.filedDate = filedDate;
    }
}
