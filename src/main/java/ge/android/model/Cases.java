package ge.android.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Cases {
    private int id;
    private String number;
    private int addUserId;
    private Timestamp createDate;
    private String desc;
    private CaseTypes type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "`number`", nullable = false, length = 50)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "add_user_id", nullable = false)
    public int getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(int addUserId) {
        this.addUserId = addUserId;
    }

    @Basic
    @Column(name = "create_date", nullable = false, insertable = false, updatable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "`desc`", nullable = true, length = 200)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JoinColumn(name = "type_id")
    @OneToOne
    public CaseTypes getType() {
        return type;
    }

    public void setType(CaseTypes type) {
        this.type = type;
    }
}
