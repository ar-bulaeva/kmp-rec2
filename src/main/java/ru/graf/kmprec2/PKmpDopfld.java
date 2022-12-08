package ru.graf.kmprec2;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import javax.persistence.*;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;
import ru.inversion.util.util.U;

/**
@author  Anastasia
@since   2022/11/16 16:53:07
*/
@Entity (name="ru.graf.kmprec2.PKmpDopfld")
@Table (name="KMP_DOPFLD")
public class PKmpDopfld implements Serializable
{
    private static final long serialVersionUID = 16_11_2022_16_53_07l;

    private String CDOPFLDNAME;
    private String CDOPFLDALIAS;
    private String IDOPFLDREQ;
    private String IDOPFLDEDIT;
    private String IDOPFLDENBL;
    private String IDOPFLDACC;
    private String IDOPFLDSAVE;
    private String CDOPFLDFMTSTR;
    private Long IDOPFLDSHTIDX;
    private Long IDOPFLDLNGTH;


    public PKmpDopfld(){}

    @Id 
    @Column(name="CDOPFLDNAME",length = 50)
    public String getCDOPFLDNAME() {
        return CDOPFLDNAME;
    }
    public void setCDOPFLDNAME(String val) {
        CDOPFLDNAME = val; 
    }
    @Column(name="CDOPFLDALIAS",length = 10)
    public String getCDOPFLDALIAS() {
        return CDOPFLDALIAS;
    }
    public void setCDOPFLDALIAS(String val) {
        CDOPFLDALIAS = val; 
    }

    @Column(name="IDOPFLDREQ",length = 1)
    public String getIDOPFLDREQ() {
        return U.nvl(IDOPFLDREQ,"0");
    }
    public void setIDOPFLDREQ(String val) {
        IDOPFLDREQ = val;
    }

    @Transient
    @ProxyFor(columnName="IDOPFLDREQ")
    public Boolean getIDOPFLDREQ_CH() {
        return getIDOPFLDREQ().equals("1");
    }
    public void setIDOPFLDREQ_CH(Boolean val) {
        setIDOPFLDREQ(val ? "1" : "0");
    }

    @Column(name="IDOPFLDEDIT",length = 1)
    public String getIDOPFLDEDIT() {
        return U.nvl(IDOPFLDEDIT,"0");
    }
    public void setIDOPFLDEDIT(String val) {
        IDOPFLDEDIT = val; 
    }

    @Transient
    @ProxyFor(columnName="IDOPFLDEDIT")
    public Boolean getIDOPFLDEDIT_CH() {
        return getIDOPFLDEDIT().equals("1");
    }
    public void setIDOPFLDEDIT_CH(Boolean val) {
        setIDOPFLDEDIT(val ? "1" : "0");
    }

    @Column(name="IDOPFLDENBL",length = 1)
    public String getIDOPFLDENBL() {
        return U.nvl(IDOPFLDENBL,"0");
    }
    public void setIDOPFLDENBL(String val) {
        IDOPFLDENBL = val; 
    }

    @Transient
    @ProxyFor(columnName="IDOPFLDENBL")
    public Boolean getIDOPFLDENBL_CH() {
        return getIDOPFLDENBL().equals("1");
    }
    public void setIDOPFLDENBL_CH(Boolean val) {
        setIDOPFLDENBL(val ? "1" : "0");
    }

    @Column(name="IDOPFLDACC",length = 0)
    public String getIDOPFLDACC() {
        return U.nvl(IDOPFLDACC,"0");
    }
    public void setIDOPFLDACC(String val) {
        IDOPFLDACC = val; 
    }

    @Transient
    @ProxyFor(columnName="IDOPFLDACC")
    public Boolean getIDOPFLDACC_CH() {
        return getIDOPFLDACC().equals("1");
    }
    public void setIDOPFLDACC_CH(Boolean val) {
        setIDOPFLDACC(val ? "1" : "0");
    }

    @Column(name="IDOPFLDSAVE",length = 10)
    public String getIDOPFLDSAVE() {
        return U.nvl(IDOPFLDSAVE,"0");
    }
    public void setIDOPFLDSAVE(String val) {
        IDOPFLDSAVE = val; 
    }

    @Transient
    @ProxyFor(columnName="IDOPFLDSAVE")
    public Boolean getIDOPFLDSAVE_CH() {
        return getIDOPFLDSAVE().equals("1");
    }
    public void setIDOPFLDSAVE_CH(Boolean val) {
        setIDOPFLDSAVE(val ? "1" : "0");
    }

    @Column(name="CDOPFLDFMTSTR",length = 20)
    public String getCDOPFLDFMTSTR() {
        return CDOPFLDFMTSTR;
    }
    public void setCDOPFLDFMTSTR(String val) {
        CDOPFLDFMTSTR = val; 
    }
    @Column(name="IDOPFLDSHTIDX",length = 2)
    public Long getIDOPFLDSHTIDX() {
        return IDOPFLDSHTIDX;
    }
    public void setIDOPFLDSHTIDX(Long val) {
        IDOPFLDSHTIDX = val; 
    }
    @Column(name="IDOPFLDLNGTH",length = 2)
    public Long getIDOPFLDLNGTH() {
        return IDOPFLDLNGTH;
    }
    public void setIDOPFLDLNGTH(Long val) {
        IDOPFLDLNGTH = val; 
    }
    }