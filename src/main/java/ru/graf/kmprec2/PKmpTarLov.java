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
@since   2022/10/24 17:33:05
*/
@Entity (name="ru.graf.kmprec2.PKmpTarLov")
@NamedNativeQuery (name="ru.graf.kmprec2.PKmpTarLov", query="select  id, cname from kmp_tar_scale")
public class PKmpTarLov implements Serializable
{
    private static final long serialVersionUID = 24_10_2022_17_33_05l;

    private Long ID;
    private String CNAME;

    public PKmpTarLov(){}

    @Id 
    @Column(name="ID",nullable = false,length = 0)
    public Long getID() {
        return ID;
    }
    public void setID(Long val) {
        ID = val; 
    }
    @Column(name="CNAME",length = 250)
    public String getCNAME() {
        return CNAME;
    }
    public void setCNAME(String val) {
        CNAME = val; 
    }
}