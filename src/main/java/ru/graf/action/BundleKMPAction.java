package ru.graf.action;

import ru.inversion.bicomp.action.ActionBiComp;
import ru.inversion.fx.form.AbstractBaseController;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Для ресурс бандлов экшенов чтобы не плодить новый файл ресурсов на каждый класс.
 */

public class BundleKMPAction {
    protected static final ResourceBundle BUNDLE= AbstractBaseController.getResourceBundle(BundleKMPAction.class);

    public static String getString(String key) {
        return BUNDLE.getString(key);
    }
    
    /**
     * Для инициализации ошибки при вызове формы через FxFormLauncher вместо экшена
     */
    public static void throwActionOnlyException(Class<? extends ActionBiComp<?,?>> actionClass, AbstractBaseController<?> ctrl){
        String rawMsg = getString("ERR_USE_ACTION_INSTEAD_OF_FFL");
        throw new RuntimeException(rawMsg);
    }
}