package ru.graf.kmpaudit;

import javafx.fxml.FXML;
import ru.graf.action.ActionAu;
import ru.inversion.dataset.DataLinkBuilder;
import ru.inversion.dataset.ParametersByName;
import ru.inversion.dataset.XXIDataSet;
import ru.inversion.dataset.fx.DSFXAdapter;

import ru.inversion.fx.form.*;
import ru.inversion.fx.form.controls.*;

/**
 *
 * @author  Anastasia
 * @since   Wed Oct 26 15:54:24 MSK 2022
 */
public class ViewKmpAuditController extends JInvFXBrowserController 
{
    @FXML private JInvTextField IAU_TABLEOBJID;
    @FXML private JInvTextField CAU_TABLETBLNAME;
    @FXML private JInvTable<PKmpAudit> KMP_V_AU_TABLE_ACT;

    @FXML private JInvTable<PKmpAuditTable2> KMP_AU_TABLE;

   
    private final XXIDataSet<PKmpAudit> dsKMP_V_AU_TABLE_ACT = new XXIDataSet<> ();

    private final XXIDataSet<PKmpAuditTable2> dsKMP_AU_TABLE = new XXIDataSet<> ();


    //
// initDataSet
//    
    private void initDataSet () throws Exception 
    {
        dsKMP_V_AU_TABLE_ACT.setTaskContext (getTaskContext ());
        dsKMP_V_AU_TABLE_ACT.setRowClass (PKmpAudit.class);

        dsKMP_AU_TABLE.setTaskContext (getTaskContext ());
        dsKMP_AU_TABLE.setRowClass (PKmpAuditTable2.class);

        DataLinkBuilder.linkDataSet( dsKMP_V_AU_TABLE_ACT, dsKMP_AU_TABLE,  PKmpAudit::getDAU_TABLEDATE_TR , "DAU_TABLEDATE_TR");

        dsKMP_V_AU_TABLE_ACT.setWherePredicat("(IAU_TABLEOBJID = :P_OBJ_ID and CAU_TABLETBLNAME = :P_TBL_NAME)");
        dsKMP_V_AU_TABLE_ACT.setCallbackParameters((ParametersByName) p->{
            switch (p) {
                case "P_OBJ_ID": return getInitParameter(ActionAu.ParamKeyAu.P_OBJ_ID.name());
                case "P_TBL_NAME": return getInitParameter(ActionAu.ParamKeyAu.P_TBL_NAME.name());
                default: return null;
            }
        });
        dsKMP_V_AU_TABLE_ACT.setOrderBy("DAU_TABLEDATE");

    }

//
// Initializes the controller class.
//
    @Override
    protected void init() throws Exception
    {
        setTitle (getBundleString ("VIEW.TITLE"));
        
        initDataSet ();

        DSFXAdapter<PKmpAudit> dsfx = DSFXAdapter.bind (dsKMP_V_AU_TABLE_ACT, KMP_V_AU_TABLE_ACT, null, false);

        dsfx.setEnableFilter (false);

        DSFXAdapter.bind (dsKMP_AU_TABLE, KMP_AU_TABLE, null, false);

        dsfx.bindControl (CAU_TABLETBLNAME, IAU_TABLEOBJID);

        doRefresh ();
    }        
//
// doRefresh
//    
    private void doRefresh () 
    {
        KMP_V_AU_TABLE_ACT.executeQuery ();
        //KMP_AU_TABLE.executeQuery ();
    }

}

