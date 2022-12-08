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
@since   2022/10/26 15:54:13
*/
@Entity (name="ru.graf.kmpaudit.PKmpAudit")
@NamedNativeQuery (name="ru.graf.kmpaudit.PKmpAudit", query="select * from (select DAU_TABLEDATE, trunc(DAU_TABLEDATE) as DAU_TABLEDATE_TR, CAU_TABLEUSR, CAU_TABLEACTION, CAU_TABLETBLNAME, IAU_TABLEOBJID  from KMP_V_AU_TABLE_ACT)"
	+"")
public class PKmpAudit implements Serializable
{
    private static final long serialVersionUID = 26_10_2022_15_54_13l;

    private LocalDate DAU_TABLEDATE_TR;

    private LocalDate DAU_TABLEDATE;

    private String CAU_TABLEUSR;
    private String CAU_TABLEACTION;

    private Long P_OBJ_ID;

    private String CAU_TABLETBLNAME;

    public PKmpAudit(){}

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

    @Column(name="CAU_TABLEUSR",length = 100)
    public String getCAU_TABLEUSR() {
        return CAU_TABLEUSR;
    }
    public void setCAU_TABLEUSR(String val) {
        CAU_TABLEUSR = val; 
    }
    @Column(name="CAU_TABLEACTION",length = 10)
    public String getCAU_TABLEACTION() {
        return CAU_TABLEACTION;
    }
    public void setCAU_TABLEACTION(String val) {
        CAU_TABLEACTION = val; 
    }

    @Column(name="IAU_TABLEOBJID",length = 6)
    public Long getIAU_TABLEOBJID() {
        return P_OBJ_ID;
    }
    public void setIAU_TABLEOBJID(Long val) {
        P_OBJ_ID = val;
    }
    @Column(name="CAU_TABLETBLNAME",length = 60)
    public String getCAU_TABLETBLNAME() {
        return CAU_TABLETBLNAME;
    }
    public void setCAU_TABLETBLNAME(String val) {
        CAU_TABLETBLNAME = val;
    }
}