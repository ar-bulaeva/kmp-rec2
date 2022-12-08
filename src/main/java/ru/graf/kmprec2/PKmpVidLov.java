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
@since   2022/10/24 15:35:19
*/
@Entity (name="ru.graf.kmprec2.PKmpVidLov")
@NamedNativeQuery (name="ru.graf.kmprec2.PKmpVidLov", query="select  IVIDPLAT, CVIDNAME, CVIDSHORTNAME from kmp_vid")
public class PKmpVidLov implements Serializable
{
    private static final long serialVersionUID = 24_10_2022_15_35_19l;

    private Long IVIDPLAT;
    private String CVIDNAME;
    private String CVIDSHORTNAME;

    public PKmpVidLov(){}

    @Id 
    @Column(name="IVIDPLAT",nullable = false,length = 5)
    public Long getIVIDPLAT() {
        return IVIDPLAT;
    }
    public void setIVIDPLAT(Long val) {
        IVIDPLAT = val;
    }
    @Column(name="CVIDNAME",length = 255)
    public String getCVIDNAME() {
        return CVIDNAME;
    }
    public void setCVIDNAME(String val) {
        CVIDNAME = val; 
    }
    @Column(name="CVIDSHORTNAME",length = 10)
    public String getCVIDSHORTNAME() {
        return CVIDSHORTNAME;
    }
    public void setCVIDSHORTNAME(String val) {
        CVIDSHORTNAME = val; 
    }
}