package ru.graf.action;

import javafx.event.ActionEvent;
import ru.graf.kmpaudit.ViewKmpAuditController;
import ru.graf.kmprec2.ViewKmpPolController;
import ru.inversion.bicomp.action.ActionBiComp;
import ru.inversion.fx.form.AbstractBaseController;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.icons.IconDescriptorBuilder;
import ru.inversion.icons.enums.FontAwesome;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ActionPL extends ActionBiComp<Map<String,Object>,Void> {


    public ActionPL() {
        super(new IconDescriptorBuilder<>(FontAwesome.fa_code, null).build(),
                BundleKMPAction.getString("TT.PL"),
                new HashMap<>());
        super.setDefaultHandler(this::defaultHandler);
    }

    public ActionPL(Consumer<Map<String,Object>> preCallback) {
        this();
        setActionPreCallback(preCallback);
    }

    private void defaultHandler(ActionEvent event) {
        new FXFormLauncher<>(tc, vc, ViewKmpPolController.class)
                .dialogMode(AbstractBaseController.FormModeEnum.VM_CHOICE)
                .initProperties(actObj)
                .modal(true)
                .show();
    }
}

