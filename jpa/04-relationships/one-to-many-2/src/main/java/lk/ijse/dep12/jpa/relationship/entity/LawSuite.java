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
@Entity
@Table(name = "law_suite")
public class LawSuite implements Serializable {
    @Id
    private String id;
    private String type;
    private String description;
    @Column(name = "filed_date")
    private Date filedDate;
    @JoinTable(name = "lawyer_law_suite",
    joinColumns = @JoinColumn(name = "law_suite_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "lawyer_reg_number", referencedColumnName = "reg_number"))
    @ManyToOne
    private Lawyer lawyer;

    public LawSuite(String id, String type, String description, Date filedDate) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.filedDate = filedDate;
    }
}
