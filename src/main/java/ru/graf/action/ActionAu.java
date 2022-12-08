package ru.graf.action;

import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import ru.graf.action.BundleKMPAction;
import ru.inversion.bicomp.action.ActionBiComp;
import ru.inversion.fx.form.AbstractBaseController;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.icons.IconDescriptorBuilder;
import ru.inversion.icons.enums.FontAwesome;
import java.util.function.Consumer;
import ru.graf.kmpaudit.ViewKmpAuditController;

public class ActionAu extends ActionBiComp<Map<String,Object>,Void> {

    public enum ParamKeyAu{
        /**
         * Алиас подсистемы
         */
        P_OBJ_ID,
        P_TBL_NAME,
        P_ALIAS
    }

    public ActionAu() {
        super(new IconDescriptorBuilder<>(FontAwesome.fa_user_secret, null).build(),
                BundleKMPAction.getString("TT.AU"),
                new HashMap<>());
        super.setDefaultHandler(this::defaultHandler);
    }

    public ActionAu(Consumer<Map<String,Object>> preCallback) {
        this();
        setActionPreCallback(preCallback);
    }

    private void defaultHandler(ActionEvent event) {
        new FXFormLauncher<>(tc, vc, ViewKmpAuditController.class)
                .dialogMode(AbstractBaseController.FormModeEnum.VM_CHOICE)
                .initProperties(actObj)
                .modal(true)
                .show();
    }
}

