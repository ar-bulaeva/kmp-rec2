package ru.graf.kmprec2;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import javax.persistence.*;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;

/**
@author  Anastasia
@since   2022/10/25 17:01:04
*/
@Entity (name="ru.graf.kmprec2.PKmpGrpLov")
@NamedNativeQuery (name="ru.graf.kmprec2.PKmpGrpLov", query="select IGRPID, CGRPNAME from kmp_grp")
public class PKmpGrpLov implements Serializable
{
    private static final long serialVersionUID = 25_10_2022_17_01_04l;

    private Long IGRPID;
    private String CGRPNAME;

    public PKmpGrpLov(){}

    @Id 
    @Column(name="IGRPID",nullable = false,length = 6)
    public Long getIGRPID() {
        return IGRPID;
    }
    public void setIGRPID(Long val) {
        IGRPID = val; 
    }
    @Column(name="CGRPNAME",length = 60)
    public String getCGRPNAME() {
        return CGRPNAME;
    }
    public void setCGRPNAME(String val) {
        CGRPNAME = val; 
    }
}