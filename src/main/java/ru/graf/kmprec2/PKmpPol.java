package ru.graf.kmprec2;

import java.math.BigDecimal;
import java.sql.*;
import java.time.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import ru.inversion.dataset.mark.*;
import ru.inversion.db.entity.ProxyFor;
import ru.inversion.util.util.U;

/**
 @author  Anastasia
 @since   2022/10/05 17:51:32
 */
@Entity (name="ru.graf.kmprec2.PKmpPol")
@NamedNativeQuery (name="ru.graf.kmprec2.PKmpPol", query="select IPOLIDPOL, CPOLMFO, CPOLCORACC, CPOLACCC, CPOLACCD, CPOLACCZ,"
        +" CPOLCRINN, CPOLKPP, "
        +"IPOLCOCODE, IPOLPRIORITY, IPOLVIDPLAT, "
        +"IPOLOTD, DPOLOPEN,"
        +"ISHTID, CSHTCMT, IPOLPERIODICAL, IPOLACTIV, IPOLRETAIL, IPOLLEGAL, IPOLONLINEPL,"
        +"CPOLDOGNUM, DPOLDOGDATE, IPOLUFTYPE, MPOLMINSUM, IPOLONLINEVID,"
        +"IPOLACTIVE, "
        +"CPOLNAME,  CPOLNAMEPLAT,  CPOLPURPUSE, "
        +"DECODE(IPOLTYPEKOM, 1, ML2.GetText(pCode => 'KOMPLAT.POL.IPOLTYPEKOM.POL'"
        +"                            ,pText => 'С получателя') , ML2.GetText(pCode => 'KOMPLAT.POL.IPOLTYPEKOM.PLAT'"
        +"                            ,pText => 'С плательщика')) as IPOLTYPEKOM_D, "
        +" ID, CNAME, IGRPID, CGRPNAME, CPOLNOTE,  IPOLNADP,\n" +
        "(SELECT REPORT_NAME FROM AP_REPORT_CAT WHERE REPORT_TYPE_ID = 1200119 and REPORT_ID = IPOLNADP) as NADP_NAME,\n" +
        "IPOLREPID, \n" +
        "(SELECT REPORT_NAME FROM AP_REPORT_CAT WHERE REPORT_TYPE_ID = 1200121 and REPORT_ID = IPOLREPID) as REPORT_NAME, \n" +
        "CPOLFILENAME, \n" +
        "DECODE(IPOLPRINT_FILE, 1, ML2.GetText(pCode => 'KOMPLAT.POL.IPOLPRINT_FILE.FILE'\n" +
        "                                ,pText => 'В файл') , 0,\n" +
        "                          ML2.GetText(pCode => 'KOMPLAT.POL.IPOLPRINT_FILE.PRINT'\n" +
        "                                ,pText => 'Печать')) as IPOLPRINT_FILE_D, \n" +
        "CPOLDBFFILENAME, IPOLTYPEKOM, IPOLPRINT_FILE  from  kmp_pol \n"
        +"left join kmp_grp on kmp_pol.IPOLGRP=kmp_grp.IGRPID \n"
        +"left join tar_scale on kmp_pol.IPOLTARNUM=tar_scale.ID\n"
        +"left join kmp_sht on kmp_pol.IPOLSHT=kmp_sht.ISHTID")

public class PKmpPol implements Serializable
{
    private static final long serialVersionUID = 5_10_2022_17_51_32l;

    private Long IPOLIDPOL;
    private String CPOLMFO;
    private String CPOLCORACC;
    private String CPOLACCC;
    private String CPOLACCD;
    private String CPOLACCZ;
    private String CPOLCRINN;
    private String CPOLKPP;
    private Long IPOLCOCODE;
    private Long IPOLPRIORITY;
    private Long IPOLVIDPLAT;
    private Long IPOLOTD;
    private LocalDate DPOLOPEN;
    private Long ISHTID;
    private String CSHTCMT;
    private String IPOLPERIODICAL;
    private String IPOLACTIV;
    private String IPOLRETAIL;
    private String IPOLLEGAL;
    private String IPOLONLINEPL;
    private String CPOLDOGNUM;
    private LocalDate DPOLDOGDATE;
    private Long IPOLUFTYPE;
    private BigDecimal MPOLMINSUM;
    private Long IPOLONLINEVID;
    private String IPOLACTIVE;
    private String CPOLNAME;
    private String CPOLNAMEPLAT;
    private String CPOLPURPUSE;
    private String IPOLTYPEKOM_D;
    private String IPOLTYPEKOM;
    private Long ID;
    private String CNAME;
    private Long IGRPID;
    private String CGRPNAME;
    private String CPOLNOTE;

    private Long IPOLNADP;
    private String NADP_NAME;
    private Long IPOLREPID;
    private String REPORT_NAME;
    private String CPOLFILENAME;
    private String IPOLPRINT_FILE_D;
    private String IPOLPRINT_FILE;
    private String CPOLDBFFILENAME;


    public PKmpPol(){}

    @Id
    @Column(name="IPOLIDPOL",nullable = false,length = 10)
    public Long getIPOLIDPOL() {
        return IPOLIDPOL;
    }
    public void setIPOLIDPOL(Long val) {
        IPOLIDPOL = val;
    }
    @Column(name="CPOLMFO",nullable = false,length = 11)
    public String getCPOLMFO() {
        return CPOLMFO;
    }
    public void setCPOLMFO(String val) {
        CPOLMFO = val;
    }
    @Column(name="CPOLCORACC",length = 25)
    public String getCPOLCORACC() {
        return CPOLCORACC;
    }
    public void setCPOLCORACC(String val) {
        CPOLCORACC = val;
    }
    @Column(name="CPOLACCC",nullable = false,length = 25)
    public String getCPOLACCC() {
        return CPOLACCC;
    }
    public void setCPOLACCC(String val) {
        CPOLACCC = val;
    }
    @Column(name="CPOLACCD",nullable = false,length = 25)
    public String getCPOLACCD() {
        return CPOLACCD;
    }
    public void setCPOLACCD(String val) {
        CPOLACCD = val;
    }
    @Column(name="CPOLACCZ",length = 25)
    public String getCPOLACCZ() {
        return CPOLACCZ;
    }
    public void setCPOLACCZ(String val) {
        CPOLACCZ = val;
    }
    @Column(name="CPOLCRINN",length = 13)
    public String getCPOLCRINN() {
        return CPOLCRINN;
    }
    public void setCPOLCRINN(String val) {
        CPOLCRINN = val;
    }
    @Column(name="CPOLKPP",length = 9)
    public String getCPOLKPP() {
        return CPOLKPP;
    }
    public void setCPOLKPP(String val) {
        CPOLKPP = val;
    }
    @Column(name="IPOLCOCODE",nullable = false,length = 3)
    public Long getIPOLCOCODE() {
        return IPOLCOCODE;
    }
    public void setIPOLCOCODE(Long val) {
        IPOLCOCODE = val;
    }
    @Column(name="IPOLPRIORITY",length = 1)
    public Long getIPOLPRIORITY() {
        return IPOLPRIORITY;
    }
    public void setIPOLPRIORITY(Long val) {
        IPOLPRIORITY = val;
    }
    @Column(name="IPOLVIDPLAT",nullable = false,length = 10)
    public Long getIPOLVIDPLAT() {
        return IPOLVIDPLAT;
    }
    public void setIPOLVIDPLAT(Long val) {
        IPOLVIDPLAT = val;
    }
    @Column(name="IPOLOTD",length = 6)
    public Long getIPOLOTD() {
        return IPOLOTD;
    }
    public void setIPOLOTD(Long val) {
        IPOLOTD = val;
    }
    @Column(name="DPOLOPEN")
    public LocalDate getDPOLOPEN() {
        return DPOLOPEN;
    }
    public void setDPOLOPEN(LocalDate val) {
        DPOLOPEN = val;
    }
    @Column(name="ISHTID",nullable = false,length = 7)
    public Long getISHTID() {
        return ISHTID;
    }
    public void setISHTID(Long val) {
        ISHTID = val;
    }
    @Column(name="CSHTCMT",nullable = false,length = 160)
    public String getCSHTCMT() {
        return CSHTCMT;
    }
    public void setCSHTCMT(String val) {
        CSHTCMT = val;
    }
    @Column(name="IPOLPERIODICAL",length = 1)
    public String getIPOLPERIODICAL() {
        return U.nvl(IPOLPERIODICAL,"0");
    }
    public void setIPOLPERIODICAL(String val) {
        IPOLPERIODICAL = val;
    }
    @Transient
    @ProxyFor(columnName="IPOLPERIODICAL")
    public Boolean getIPOLPERIODICAL_CH() {
        return getIPOLPERIODICAL().equals("1");
    }
    public void setIPOLPERIODICAL_CH(Boolean val) {
        setIPOLPERIODICAL(val ? "1" : "0");
    }

    @Column(name="IPOLACTIV",length = 1)
    public String getIPOLACTIV() {
        return U.nvl(IPOLACTIV,"0");
    }
    public void setIPOLACTIV(String val) {
        IPOLACTIV = val;
    }
    @Transient
    @ProxyFor(columnName="IPOLACTIV")
    public Boolean getIPOLACTIV_CH() {
        return getIPOLACTIV().equals("1");
    }
    public void setIPOLACTIV_CH(Boolean val) {
        setIPOLACTIV(val ? "1" : "0");
    }

    @Column(name="IPOLRETAIL",length = 1)
    public String getIPOLRETAIL() {
        return U.nvl(IPOLRETAIL,"0");
    }

    public void setIPOLRETAIL(String val) {
        IPOLRETAIL = val;
    }
    @Transient
    @ProxyFor(columnName="IPOLRETAIL")
    public Boolean getIPOLRETAIL_CH() {
        return getIPOLRETAIL().equals("1");
    }
    public void setIPOLRETAIL_CH(Boolean val) {
        setIPOLACTIVE(val ? "1" : "0");
    }

    @Column(name="IPOLLEGAL",length = 1)
    public String getIPOLLEGAL() {
        return U.nvl(IPOLLEGAL,"0");
    }
    public void setIPOLLEGAL(String val) {
        IPOLLEGAL = val;
    }
    @Transient
    @ProxyFor(columnName="IPOLLEGAL")
    public Boolean getIPOLLEGAL_CH() {
        return getIPOLLEGAL().equals("1");
    }
    public void setIPOLLEGAL_CH(Boolean val) {
        setIPOLLEGAL(val ? "1" : "0");
    }

    @Column(name="IPOLONLINEPL",nullable = false,length = 1)
    public String getIPOLONLINEPL() {
        return U.nvl(IPOLONLINEPL,"0");
    }
    public void setIPOLONLINEPL(String val) {
        IPOLONLINEPL = val;
    }
    @Transient
    @ProxyFor(columnName="IPOLONLINEPL")
    public Boolean getIPOLONLINEPL_CH() {
        return getIPOLONLINEPL().equals("1");
    }
    public void setIPOLONLINEPL_CH(Boolean val) {
        setIPOLONLINEPL(val ? "1" : "0");
    }
    @Column(name="CPOLDOGNUM",length = 15)
    public String getCPOLDOGNUM() {
        return CPOLDOGNUM;
    }
    public void setCPOLDOGNUM(String val) {
        CPOLDOGNUM = val;
    }
    @Column(name="DPOLDOGDATE")
    public LocalDate getDPOLDOGDATE() {
        return DPOLDOGDATE;
    }
    public void setDPOLDOGDATE(LocalDate val) {
        DPOLDOGDATE = val;
    }
    @Column(name="IPOLUFTYPE",length = 0)
    public Long getIPOLUFTYPE() {
        return IPOLUFTYPE;
    }
    public void setIPOLUFTYPE(Long val) {
        IPOLUFTYPE = val;
    }
    @Column(name="MPOLMINSUM",nullable = false,length = 12)
    public BigDecimal getMPOLMINSUM() {
        return MPOLMINSUM;
    }
    public void setMPOLMINSUM(BigDecimal val) {
        MPOLMINSUM = val;
    }
    @Column(name="IPOLONLINEVID",length = 10)
    public Long getIPOLONLINEVID() {
        return IPOLONLINEVID;
    }
    public void setIPOLONLINEVID(Long val) {
        IPOLONLINEVID = val;
    }
    @Column(name="IPOLACTIVE",length = 1)
    public String getIPOLACTIVE() {
        return U.nvl(IPOLACTIVE,"0");
    }
    public void setIPOLACTIVE(String val) {
        IPOLACTIVE = val;
    }
    @Transient
    @ProxyFor(columnName="IPOLACTIVE")
    public Boolean getIPOLACTIVE_CH() {
        return getIPOLACTIVE().equals("1");
    }
    public void setIPOLACTIVE_CH(Boolean val) {
        setIPOLACTIVE(val ? "1" : "0");
    }
    @Column(name="CPOLNAME",length = 160)
    public String getCPOLNAME() {
        return CPOLNAME;
    }
    public void setCPOLNAME(String val) {
        CPOLNAME = val;
    }
    @Column(name="CPOLNAMEPLAT",length = 160)
    public String getCPOLNAMEPLAT() {
        return CPOLNAMEPLAT;
    }
    public void setCPOLNAMEPLAT(String val) {
        CPOLNAMEPLAT = val;
    }
    @Column(name="CPOLPURPUSE",length = 210)
    public String getCPOLPURPUSE() {
        return CPOLPURPUSE;
    }
    public void setCPOLPURPUSE(String val) {
        CPOLPURPUSE = val;
    }
    @Column(name="IPOLTYPEKOM_D",nullable = false,length = 4000)
    public String getIPOLTYPEKOM_D() {
        return IPOLTYPEKOM_D;
    }
    public void setIPOLTYPEKOM_D(String val) {
        IPOLTYPEKOM_D = val;
    }

    @Column(name="IPOLTYPEKOM",nullable = false,length = 4000)
    public String getIPOLTYPEKOM() {
        return IPOLTYPEKOM;
    }
    public void setIPOLTYPEKOM(String val) {
        IPOLTYPEKOM = val;
    }
    @Column(name="ID",length = 38)
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
    @Column(name="IGRPID",length = 6)
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
    @Column(name="CPOLNOTE",length = 500)
    public String getCPOLNOTE() {
        return CPOLNOTE;
    }
    public void setCPOLNOTE(String val) {
        CPOLNOTE = val;
    }

    @Column(name="IPOLNADP",length = 0)
    public Long getIPOLNADP() {
        return IPOLNADP;
    }
    public void setIPOLNADP(Long val) {
        IPOLNADP = val;
    }
    @Column(name="NADP_NAME",length = 4000)
    public String getNADP_NAME() {
        return NADP_NAME;
    }
    public void setNADP_NAME(String val) {
        NADP_NAME = val;
    }
    @Column(name="IPOLREPID",length = 12)
    public Long getIPOLREPID() {
        return IPOLREPID;
    }
    public void setIPOLREPID(Long val) {
        IPOLREPID = val;
    }
    @Column(name="REPORT_NAME",length = 4000)
    public String getREPORT_NAME() {
        return REPORT_NAME;
    }
    public void setREPORT_NAME(String val) {
        REPORT_NAME = val;
    }
    @Column(name="CPOLFILENAME",length = 80)
    public String getCPOLFILENAME() {
        return CPOLFILENAME;
    }
    public void setCPOLFILENAME(String val) {
        CPOLFILENAME = val;
    }
    @Column(name="IPOLPRINT_FILE_D",length = 4000)
    public String getIPOLPRINT_FILE_D() {
        return IPOLPRINT_FILE_D;
    }
    public void setIPOLPRINT_FILE_D(String val) {
        IPOLPRINT_FILE_D = val;
    }

    @Column(name="IPOLPRINT_FILE",length = 4000)
    public String getIPOLPRINT_FILE() {
        return IPOLPRINT_FILE;
    }
    public void setIPOLPRINT_FILE(String val) {
        IPOLPRINT_FILE = val;
    }
    @Column(name="CPOLDBFFILENAME",length = 80)
    public String getCPOLDBFFILENAME() {
        return CPOLDBFFILENAME;
    }
    public void setCPOLDBFFILENAME(String val) {
        CPOLDBFFILENAME = val;
    }
}