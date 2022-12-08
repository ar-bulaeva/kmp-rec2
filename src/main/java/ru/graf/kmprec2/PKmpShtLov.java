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
@since   2022/10/25 16:54:23
*/
@Entity (name="ru.graf.kmprec2.PKmpShtLov")
@NamedNativeQuery (name="ru.graf.kmprec2.PKmpShtLov", query="select ISHTID,CSHTCMT  from kmp_sht")
public class PKmpShtLov implements Serializable
{
    private static final long serialVersionUID = 25_10_2022_16_54_23l;

    private Long ISHTID;
    private String CSHTCMT;

    public PKmpShtLov(){}

    @Id 
    @Column(name="ISHTID",nullable = false,length = 7)
    public Long getISHTID() {
        return ISHTID;
    }
    public void setISHTID(Long val) {
        ISHTID = val; 
    }
    @Column(name="CSHTCMT",length = 210)
    public String getCSHTCMT() {
        return CSHTCMT;
    }
    public void setCSHTCMT(String val) {
        CSHTCMT = val; 
    }

}