package ru.graf.kmpaudit;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import javax.persistence.*;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;

/**
@author  Anastasia
@since   2022/10/27 10:30:04
*/
@Entity (name="ru.graf.kmpaudit.PKmpAuditTable2")
@NamedNativeQuery (name="ru.graf.kmpaudit.PKmpAuditTable2", query="select * from (select CAU_TABLEFLDNAME, CAU_TABLEVAL, trunc(DAU_TABLEDATE) as DAU_TABLEDATE_TR from KMP_AU_TABLE) "
	+""
	+"")
public class PKmpAuditTable2 implements Serializable
{
    private static final long serialVersionUID = 27_10_2022_10_30_04l;

    private LocalDate DAU_TABLEDATE_TR;

    private LocalDate DAU_TABLEDATE;
    private String CAU_TABLEFLDNAME;
    private String CAU_TABLEVAL;

    public PKmpAuditTable2(){}


    @Id
    @Column(name="DAU_TABLEDATE_TR")
    public LocalDate getDAU_TABLEDATE_TR() {
        return DAU_TABLEDATE_TR;
    }
    public void setDAU_TABLEDATE_TR(LocalDate val) {
        DAU_TABLEDATE_TR = val;
    }

    @Column(name="DAU_TABLEDATE")
    public LocalDate getDAU_TABLEDATE() {
        return DAU_TABLEDATE;
    }
    public void setDAU_TABLEDATE(LocalDate val) {
        DAU_TABLEDATE = val;
    }

    @Column(name="CAU_TABLEFLDNAME",length = 30)
    public String getCAU_TABLEFLDNAME() {
        return CAU_TABLEFLDNAME;
    }
    public void setCAU_TABLEFLDNAME(String val) {
        CAU_TABLEFLDNAME = val;
    }
    @Column(name="CAU_TABLEVAL",length = 255)
    public String getCAU_TABLEVAL() {
        return CAU_TABLEVAL;
    }
    public void setCAU_TABLEVAL(String val) {
        CAU_TABLEVAL = val; 
    }
}