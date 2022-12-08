package ru.graf.kmprec2;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import ru.inversion.bicomp.stringconverter.BundleStringConverter;
import ru.inversion.bicomp.util.ParamMap;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.fx.form.Alerts;
import ru.inversion.fx.form.JInvFXFormController;
import ru.inversion.fx.form.ResultForm;
import ru.inversion.fx.form.controls.*;
import javafx.fxml.FXML;
import ru.inversion.fx.form.controls.combobox.JInvComboBoxSimple;
import ru.inversion.fx.form.lov.JInvEntityLov;
import ru.inversion.fx.form.lov.JInvFileChooserLov;
import ru.inversion.fxpdoc.get_acc_lov.GetAccLov;
import static ru.inversion.fxacc.acc_ins.PAccInsMain.showViewAccIns;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.File;
import java.util.function.Consumer;


/**
 * @author Anastasia
 * @since Wed Oct 05 17:51:38 MSK 2022
 */
public class EditKmpPolController extends JInvFXFormController<PKmpPol> {
    private final GetAccLov accLov = new GetAccLov();
    private final GetAccLov accZLov = new GetAccLov();

    @FXML private JInvTable<PKmpPol> KMP_POL;
//
//
//    @FXML JInvLongField IPOLIDPOL;
//    @FXML JInvTextField CPOLMFO;
//    @FXML JInvTextField CPOLCORACC;
//    @FXML JInvTextField CPOLACCC;
    @FXML JInvTextField CPOLACCD;
    @FXML JInvTextField CPOLACCZ;
//    @FXML JInvTextField CPOLCRINN;
//    @FXML JInvTextField CPOLKPP;
//    @FXML JInvLongField IPOLCOCODE;
//    @FXML JInvLongField IPOLPRIORITY;
    @FXML
    JInvLongField IPOLVIDPLAT;
    //    @FXML JInvLongField IPOLOTD;
//    @FXML JInvTextField DPOLOPEN;
    @FXML JInvLongField ISHTID;
    @FXML JInvTextField CSHTCMT;
//    @FXML JInvTextField IPOLPERIODICAL;
//    @FXML JInvTextField IPOLACTIV;
//    @FXML JInvTextField IPOLRETAIL;
//    @FXML JInvTextField IPOLLEGAL;
//    @FXML JInvTextField IPOLONLINEPL;
//    @FXML JInvTextField CPOLDOGNUM;
//    @FXML JInvTextField DPOLDOGDATE;
    @FXML
    JInvComboBoxSimple IPOLUFTYPE;
//    @FXML JInvTextField MPOLMINSUM;
//    @FXML JInvLongField IPOLONLINEVID;
//    @FXML JInvTextField IPOLACTIVE;
//    @FXML JInvTextField CPOLNAME;
//    @FXML JInvTextField CPOLNAMEPLAT;
//    @FXML JInvTextField CPOLPURPUSE;
    @FXML JInvLongField IGRPID;
    @FXML JInvTextField CGRPNAME;
    @FXML JInvComboBoxSimple IPOLTYPEKOM;
    @FXML
    JInvLongField ID;
    @FXML
    private JInvTextField CNAME;


    //    @FXML JInvLongField IGRPID;
//    @FXML JInvTextField CGRPNAME;
//    @FXML JInvTextField CPOLNOTE;

    @FXML JInvLongField IPOLNADP;
    @FXML JInvTextField NADP_NAME;
    @FXML JInvLongField IPOLREPID;
    @FXML JInvTextField REPORT_NAME;
    @FXML JInvTextField CPOLFILENAME;
    @FXML JInvComboBoxSimple IPOLPRINT_FILE;
    @FXML JInvTextField CPOLDBFFILENAME;

    @FXML
    protected void onNewAccount(ActionEvent event) {
        ParamMap p = new ParamMap();
        p.add("BS2_VALUE", 40911L);
        p.add("CUR_VALUE", "RUR");
        p.add("DISABLE_LOOP", "Y");
        showViewAccIns(getViewContext(), getTaskContext(), p,
                (o) -> {
                    if (o.getFormReturn().equals(FormReturnEnum.RET_OK)) {
                        Alerts.info(this, o.getController().getInitParameter("last_inserted_account"));
                    }
                });
    }

//
// Initializes the controller class.
//
    @Override
    protected void init() throws Exception {
        super.init();

        JInvEntityLov<PKmpVidLov, String> KmpVidLov = new JInvEntityLov<>(PKmpVidLov.class, "IVIDPLAT");
        KmpVidLov.setTaskContext(getTaskContext());
        KmpVidLov.setChoiceOrderBy("IVIDPLAT");
        IPOLVIDPLAT.setLOV(KmpVidLov);

        JInvEntityLov<PKmpTarLov, String> KmpTarLov = new JInvEntityLov<>(PKmpTarLov.class, "ID");
        KmpTarLov.setTaskContext(getTaskContext());
        KmpTarLov.setChoiceOrderBy("ID");
        KmpTarLov.bindControl(CNAME, PKmpTarLov::getCNAME);
        ID.setLOV(KmpTarLov);

        JInvEntityLov<PKmpGrpLov, String> KmpGrpLov = new JInvEntityLov<>(PKmpGrpLov.class, "IGRPID");
        KmpGrpLov.setTaskContext(getTaskContext());
        KmpGrpLov.setChoiceOrderBy("IGRPID");
        KmpGrpLov.bindControl(CGRPNAME, PKmpGrpLov::getCGRPNAME);
        IGRPID.setLOV(KmpGrpLov);


        JInvEntityLov<PNadpLov, String> NadpLov = new JInvEntityLov<>(PNadpLov.class, "REPORT_ID");
        NadpLov.setTaskContext(getTaskContext());
        NadpLov.setWherePredicat("REPORT_TYPE_ID = 1200119");
        NadpLov.setChoiceOrderBy("REPORT_ID");
        NadpLov.bindControl(NADP_NAME, PNadpLov::getREPORT_NAME);
        IPOLNADP.setLOV(NadpLov);

        JInvEntityLov<PRepLov, String> RepLov = new JInvEntityLov<>(PRepLov.class, "REPORT_ID");
        RepLov.setTaskContext(getTaskContext());
        RepLov.setWherePredicat("REPORT_TYPE_ID = 1200121");
        RepLov.setChoiceOrderBy("REPORT_ID");
        RepLov.bindControl(REPORT_NAME, PRepLov::getREPORT_NAME);
        IPOLREPID.setLOV(RepLov);

        JInvEntityLov<PKmpShtLov, String> KmpShtLov = new JInvEntityLov<>(PKmpShtLov.class, "ISHTID");
        KmpShtLov.setTaskContext(getTaskContext());
        KmpShtLov.setChoiceOrderBy("ISHTID");
        KmpShtLov.bindControl(CSHTCMT, PKmpShtLov::getCSHTCMT);
        ISHTID.setLOV(KmpShtLov);

        CPOLACCD.setLOV(accLov, false);
        accLov.setParameter(GetAccLov.Parameters.TITLE, getBundleString("CPOLACCD"));
        accLov.setParameter(GetAccLov.Parameters.DEFAULT_WHERE, "caccacc like '40911810%'");

        CPOLACCZ.setLOV(accZLov, false);
        accZLov.setParameter(GetAccLov.Parameters.TITLE, getBundleString("CPOLACCZ"));
        accZLov.setParameter(GetAccLov.Parameters.DEFAULT_WHERE, "caccacc like '40907810%'");

        CNAME.setReadOnly(true);
        CSHTCMT.setReadOnly(true);
        CGRPNAME.setReadOnly(true);
        NADP_NAME.setReadOnly(true);
        REPORT_NAME.setReadOnly(true);

        BundleStringConverter.setupFor(getClass(), "cb_ufbs", IPOLUFTYPE);
        BundleStringConverter.setupFor(getClass(), "cb_typekom", IPOLTYPEKOM);
        BundleStringConverter.setupFor(getClass(), "cb_print", IPOLPRINT_FILE);

        new ParamMap();
        FileChooser fileChooser = new FileChooser();
        this.CPOLDBFFILENAME.setLOV(new JInvFileChooserLov());
        if (this.getInitProperties().get("loadpath") != null) {
            if ((new File((String)this.getInitProperties().get("loadpath"))).exists()) {
                ((JInvFileChooserLov)this.CPOLDBFFILENAME.getLOV()).setInitialDirectory((new File((String)this.getInitProperties().get("loadpath"))).getAbsoluteFile());
            } else {
                ((JInvFileChooserLov)this.CPOLDBFFILENAME.getLOV()).setInitialDirectory(new File(System.getenv("TEMP")));
            }
        }

        FileChooser.ExtensionFilter flt1 = new FileChooser.ExtensionFilter("Все файлы", new String[]{"*.*"});
        ((JInvFileChooserLov)this.CPOLDBFFILENAME.getLOV()).getExtensionFilters().add(flt1);
        CPOLDBFFILENAME.setButtonIgnoresEditable(true);
    }

}

