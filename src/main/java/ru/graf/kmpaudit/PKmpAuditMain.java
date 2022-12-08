package ru.graf.kmpaudit;

import java.util.Collections;
import java.util.Map;
import ru.inversion.fx.form.ViewContext;
import ru.inversion.fx.app.BaseApp;
import ru.inversion.fx.form.FXFormLauncher;
import ru.inversion.tc.TaskContext;
import ru.inversion.annotation.StartMethod;

/**
 *
 * @author  Anastasia
 * @since   Wed Oct 26 15:54:28 MSK 2022
 */
public class PKmpAuditMain extends BaseApp 
{
    
    @Override
    protected void showMainWindow () 
    {
        showViewKmpAudit (getPrimaryViewContext (), null, Collections.emptyMap ());
    }

    @Override
    public String getAppID () 
    {
        return "XXI.PKMPAUDIT"; 
    }
    
    public static void main (String[] args) 
    {
        launch (args);
    }

    @StartMethod (description = "Не поленитесь указать описание для showViewKmpAudit, JInvDesktop будет премного благодарен") 
    public static void showViewKmpAudit ( ViewContext vc, TaskContext tc, Map<String, Object> map ) 
    {
        new FXFormLauncher<> (tc, vc, ViewKmpAuditController.class)
            .initProperties (map)
            .show ();
    }
    
}

