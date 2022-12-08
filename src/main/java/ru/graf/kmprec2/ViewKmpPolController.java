package ru.graf.kmprec2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ru.graf.action.ActionAu;
import ru.graf.action.ActionPL;
import ru.graf.kmpaudit.PKmpAudit;
import ru.inversion.bicomp.action.JInvButtonBiCompAction;
import ru.inversion.dataset.DataLinkBuilder;
import ru.inversion.dataset.IDataSet;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.dataset.fx.DSFXAdapter;
import ru.inversion.dataset.aggr.AggrFuncEnum;
import ru.inversion.fx.form.controls.dsbar.DSInfoBar;
import ru.inversion.fx.form.controls.table.toolbar.AggregatorType;
import ru.inversion.fxpdocparam.util.StoredCodeHelper;
import ru.inversion.icons.enums.FontAwesome;
import ru.inversion.meta.EntityMetadataFactory;
import ru.inversion.meta.IEntityProperty;

import ru.inversion.fx.form.*;
import ru.inversion.fx.form.controls.*;



import ru.inversion.bicomp.action.JInvButtonPrint;
import ru.inversion.bicomp.action.StopExecuteActionBiCompException;
import ru.inversion.bicomp.fxreport.ApReport;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;



/**
 *
 * @author  Anastasia
 * @since   Mon Nov 21 16:10:37 MSK 2022
 */
public class ViewKmpPolController extends JInvFXBrowserController 
{
    @FXML private JInvTableColumn IDOPFLDSHTIDX;
    @FXML private JInvTableColumn CDOPFLDFMTSTR;
    @FXML private JInvTableColumn IDOPFLDSAVE_CH;
    @FXML private JInvTableColumn IDOPFLDACC_CH;
    @FXML private  JInvTableColumn IDOPFLDENBL_CH;
    @FXML private  JInvTableColumn IDOPFLDREQ_CH;
    @FXML private  JInvTableColumn CDOPFLDALIAS;
    @FXML private JInvTableColumn IPOLUFTYPE;
    @FXML private JInvTableColumn CPOLACCZ;

    @FXML private JInvTable<PKmpPol> KMP_POL;
    @FXML private JInvTable<PKmpDopfld> KMP_DOPFLD;

    @FXML private JInvToolBar toolBar;
    @FXML private JInvToolBar toolBar_dopfld;

    @FXML private JInvTextField CPOLNAME;
    @FXML private JInvTextField CPOLNAMEPLAT;
    @FXML private JInvTextField CPOLPURPUSE;
    @FXML private JInvTextField IPOLTYPEKOM_D;
    @FXML private JInvTextField ID;
    @FXML private JInvTextField CNAME;
    @FXML private JInvTextField IGRPID;
    @FXML private JInvTextField CGRPNAME;
    @FXML private JInvTextField ISHTID;
    @FXML private JInvTextField CSHTCMT;
    @FXML private JInvTextField CPOLNOTE;

    @FXML private JInvTextField IPOLNADP;
    @FXML private JInvTextField NADP_NAME;
    @FXML private JInvTextField IPOLREPID;
    @FXML private JInvTextField REPORT_NAME;
    @FXML private JInvTextField CPOLFILENAME;
    @FXML private JInvTextField IPOLPRINT_FILE_D;
    @FXML private JInvTextField CPOLDBFFILENAME;
 
   
    private final XXIDataSet<PKmpPol> dsKMP_POL = new XXIDataSet<> ();

    private final XXIDataSet<PKmpDopfld> dsKMP_DOPFLD = new XXIDataSet<> ();
    private StoredCodeHelper storedCodeHelper;

    //
// initDataSet
//    
    private void initDataSet () throws Exception 
    {
        dsKMP_POL.setTaskContext (getTaskContext ());
        dsKMP_POL.setRowClass (PKmpPol.class);

        dsKMP_DOPFLD.setTaskContext (getTaskContext ());
        dsKMP_DOPFLD.setRowClass (PKmpDopfld.class);

        DataLinkBuilder.linkDataSet( dsKMP_POL, dsKMP_DOPFLD,  PKmpPol::getIPOLIDPOL, "IDOPFLDPOLID");        //idopfldpolid = :pol.ipolidpol

        dsKMP_DOPFLD.setOrderBy("IDOPFLDID");

        IPOLUFTYPE.setToolTipText(getBundleString("P.IPOLUFTYPE"));
        CPOLACCZ.setToolTipText(getBundleString("P.CPOLACCZ"));

        CPOLFILENAME.setToolTipText(getBundleString("P.CPOLFILENAME"));

        CDOPFLDALIAS.setToolTipText(getBundleString("P.CDOPFLDALIAS"));
        IDOPFLDREQ_CH.setToolTipText(getBundleString("P.IDOPFLDREQ"));
        IDOPFLDENBL_CH.setToolTipText(getBundleString("P.IDOPFLDENBL"));
        IDOPFLDACC_CH.setToolTipText(getBundleString("P.IDOPFLDACC"));
        IDOPFLDSAVE_CH.setToolTipText(getBundleString("P.IDOPFLDSAVE"));
        CDOPFLDFMTSTR.setToolTipText(getBundleString("P.CDOPFLDFMTSTR"));
        IDOPFLDSHTIDX.setToolTipText(getBundleString("P.IDOPFLDSHTIDX"));

    }
//
// Initializes the controller class.
//
    @Override
    protected void init() throws Exception
    {
        setTitle (getBundleString ("VIEW.TITLE"));
        
        initDataSet ();
        DSFXAdapter<PKmpPol> dsfx = DSFXAdapter.bind (dsKMP_POL, KMP_POL, null, false);
        DSFXAdapter.bind (dsKMP_DOPFLD, KMP_DOPFLD, null, false);

        dsfx.setEnableFilter (true);
        dsfx.bindControl (CPOLNAME);
        dsfx.bindControl (CPOLNAMEPLAT);
        dsfx.bindControl (CPOLPURPUSE);
        dsfx.bindControl (IPOLTYPEKOM_D);
        dsfx.bindControl (ID);
        dsfx.bindControl (CNAME);
        dsfx.bindControl (IGRPID);
        dsfx.bindControl (CGRPNAME);
        dsfx.bindControl (ISHTID);
        dsfx.bindControl (CSHTCMT);
        dsfx.bindControl (CPOLNOTE);

        dsfx.bindControl (IPOLNADP);
        dsfx.bindControl (NADP_NAME);
        dsfx.bindControl (IPOLREPID);
        dsfx.bindControl (REPORT_NAME);
        dsfx.bindControl (CPOLFILENAME);
        dsfx.bindControl (IPOLPRINT_FILE_D);
        dsfx.bindControl (CPOLDBFFILENAME);
 
                
        initToolBar ();

        KMP_POL.setToolBar (toolBar);       
        KMP_POL.setAction (ActionFactory.ActionTypeEnum.CREATE, (a) -> doOperation (FormModeEnum.VM_INS));
        KMP_POL.setAction (ActionFactory.ActionTypeEnum.CREATE_BY, (a) -> doOperation (FormModeEnum.VM_NONE));
        KMP_POL.setAction (ActionFactory.ActionTypeEnum.VIEW, (a) -> doOperation (FormModeEnum.VM_SHOW));
        KMP_POL.setAction (ActionFactory.ActionTypeEnum.UPDATE, (a) -> doOperation (FormModeEnum.VM_EDIT));
        KMP_POL.setAction (ActionFactory.ActionTypeEnum.DELETE, (a) -> doOperation (FormModeEnum.VM_DEL));
        KMP_POL.setAction (ActionFactory.ActionTypeEnum.REFRESH, (a) -> doRefresh ());

        initToolBar_dopfld ();

        KMP_DOPFLD.setToolBar (toolBar_dopfld);
        KMP_DOPFLD.setAction (ActionFactory.ActionTypeEnum.CREATE, (a) -> doOperation_dopfld (FormModeEnum.VM_INS));
        KMP_DOPFLD.setAction (ActionFactory.ActionTypeEnum.CREATE_BY, (a) -> doOperation_dopfld (FormModeEnum.VM_NONE));
        KMP_DOPFLD.setAction (ActionFactory.ActionTypeEnum.VIEW, (a) -> doOperation_dopfld (FormModeEnum.VM_SHOW));
        KMP_DOPFLD.setAction (ActionFactory.ActionTypeEnum.UPDATE, (a) -> doOperation_dopfld (FormModeEnum.VM_EDIT));
        KMP_DOPFLD.setAction (ActionFactory.ActionTypeEnum.DELETE, (a) -> doOperation_dopfld (FormModeEnum.VM_DEL));
        KMP_DOPFLD.setAction (ActionFactory.ActionTypeEnum.REFRESH, (a) -> doRefresh ());

        doRefresh ();

        storedCodeHelper = new StoredCodeHelper (this);
    }        
//
// doRefresh
//    
    private void doRefresh () 
    {
        KMP_POL.executeQuery ();
        KMP_DOPFLD.executeQuery ();
    }
//
// initToolBar
//    
    private void initToolBar () 
    {
        JInvButtonPrint bp = new JInvButtonPrint (this::setPrintParam);        
        bp.setReportTypeId (1200122);
        toolBar.getItems ().add (bp);

        toolBar.setStandartActions (ActionFactory.ActionTypeEnum.CREATE, 
                                    ActionFactory.ActionTypeEnum.CREATE_BY, 
                                    ActionFactory.ActionTypeEnum.VIEW,
                                    ActionFactory.ActionTypeEnum.UPDATE,
                                    ActionFactory.ActionTypeEnum.DELETE);

        toolBar.getItems().add(ActionFactory.createButton(FontAwesome.fa_code, "", (a) -> doPrePLS(), getBundleString("TT.PL") ));
       // toolBar.getItems().add(new JInvButtonBiCompAction<>(new ActionPL(this::doPrePL)));
        toolBar.getItems().add(new JInvButtonBiCompAction<>(new ActionAu(this::doPreAu)));
    }

    private void initToolBar_dopfld ()
    {
        toolBar_dopfld.setStandartActions (ActionFactory.ActionTypeEnum.CREATE,
                ActionFactory.ActionTypeEnum.CREATE_BY,
                ActionFactory.ActionTypeEnum.VIEW,
                ActionFactory.ActionTypeEnum.UPDATE,
                ActionFactory.ActionTypeEnum.DELETE);
    }

    private void doPreAu(Map<String,Object> map) {
        map.put(ActionAu.ParamKeyAu.P_OBJ_ID.name(), dsKMP_POL.getCurrentRow().getIPOLIDPOL());
        map.put(ActionAu.ParamKeyAu.P_TBL_NAME.name(), "POL");
    }

    /*private void doPrePL(Map<String,Object> map) {

        this.storedCodeHelper.edit (PSearchCode.class);
    }*/

    private void doPrePLS() {

        this.storedCodeHelper.edit (PSearchCode.class);
    }
//
// setPrintParam
//
    private void setPrintParam ( ApReport ap ) 
    {
        if (dsKMP_POL.isEmpty ())
            throw new StopExecuteActionBiCompException ();
    }
//
// doOperation
//    
    private void doOperation ( JInvFXFormController.FormModeEnum mode ) 
    {
        PKmpPol p = null;

        switch (mode) {
            case VM_INS:
                p = new PKmpPol ();
                break;
            case VM_NONE:
                if (dsKMP_POL.getCurrentRow () == null) 
                    break;
                mode = FormModeEnum.VM_INS;
                p = new PKmpPol ();
                for (IEntityProperty<PKmpPol, ?> ep : EntityMetadataFactory.getEntityMetaData (PKmpPol.class).getPropertiesMap ().values ())
                    if (! (ep.isTransient () || ep.isId ()))
                        ep.invokeSetter (p, ep.invokeGetter (dsKMP_POL.getCurrentRow ()));
                break;
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                p = dsKMP_POL.getCurrentRow ();
                break;
        }

        if (p != null) 
            new FXFormLauncher<> (this, EditKmpPolController.class)
                .dataObject (p)
                .dialogMode (mode)
                .initProperties (getInitProperties ())
                .callback (this::doFormResult)    
                .doModal ();
    }

    private void doOperation_dopfld ( JInvFXFormController.FormModeEnum mode )
    {
        PKmpDopfld p = null;

        switch (mode) {
            case VM_INS:
                p = new PKmpDopfld ();
                break;
            case VM_NONE:
                if (dsKMP_DOPFLD.getCurrentRow () == null)
                    break;
                mode = FormModeEnum.VM_INS;
                p = new PKmpDopfld ();
                for (IEntityProperty<PKmpDopfld, ?> ep : EntityMetadataFactory.getEntityMetaData (PKmpDopfld.class).getPropertiesMap ().values ())
                    if (! (ep.isTransient () || ep.isId ()))
                        ep.invokeSetter (p, ep.invokeGetter (dsKMP_DOPFLD.getCurrentRow ()));
                break;
            case VM_EDIT:
            case VM_SHOW:
            case VM_DEL:
                p = dsKMP_DOPFLD.getCurrentRow ();
                break;
        }

        if (p != null)
            new FXFormLauncher<> (this, EditKmpDopfldController.class)
                    .dataObject (p)
                    .dialogMode (mode)
                    .initProperties (getInitProperties ())
                    .callback (this::doFormResult_dopfld)
                    .doModal ();
    }
//
// doFormResult 
//
    private void doFormResult ( JInvFXFormController.FormReturnEnum ok, JInvFXFormController<PKmpPol> dctl )    
    {
        if (JInvFXFormController.FormReturnEnum.RET_OK == ok)
        {
            switch (dctl.getFormMode ()) 
            {
                case VM_INS:
                    dsKMP_POL.insertRow (dctl.getDataObject (), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:                
                    dsKMP_POL.updateCurrentRow (dctl.getDataObject ());
                    break;
                case VM_DEL:
                    dsKMP_POL.removeCurrentRow ();
                    break;
                default:
                    break;
            }                
        }    

        KMP_POL.requestFocus ();
    }

    private void doFormResult_dopfld ( JInvFXFormController.FormReturnEnum ok, JInvFXFormController<PKmpDopfld> dctl )
    {
        if (JInvFXFormController.FormReturnEnum.RET_OK == ok)
        {
            switch (dctl.getFormMode ())
            {
                case VM_INS:
                    dsKMP_DOPFLD.insertRow (dctl.getDataObject (), IDataSet.InsertRowModeEnum.AFTER_CURRENT, true);
                    break;
                case VM_EDIT:
                    dsKMP_DOPFLD.updateCurrentRow (dctl.getDataObject ());
                    break;
                case VM_DEL:
                    dsKMP_DOPFLD.removeCurrentRow ();
                    break;
                default:
                    break;
            }
        }

        KMP_DOPFLD.requestFocus ();
    }
//
//
//    
}

