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
@since   2022/11/29 16:31:22
*/
@Entity (name="ru.graf.kmprec2.PNadpLov")
@Table (name="AP_REPORT_CAT")
public class PNadpLov implements Serializable
{
    private static final long serialVersionUID = 29_11_2022_16_31_22l;


/*
* Идентификатор отчета
*/
    private Long REPORT_ID;

/*
* Наименование отчета
*/
    private String REPORT_NAME;

    public PNadpLov(){}

    @Id 
    @Column(name="REPORT_ID",nullable = false,length = 12)
    public Long getREPORT_ID() {
        return REPORT_ID;
    }
    public void setREPORT_ID(Long val) {
        REPORT_ID = val; 
    }
    @Column(name="REPORT_NAME",length = 4000)
    public String getREPORT_NAME() {
        return REPORT_NAME;
    }
    public void setREPORT_NAME(String val) {
        REPORT_NAME = val; 
    }
}