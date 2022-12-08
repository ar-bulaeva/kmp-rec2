package ru.graf.kmprec2;

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
 * @since   Wed Oct 05 17:51:39 MSK 2022
 */
public class PKmpPolMain extends BaseApp 
{
    
    @Override
    protected void showMainWindow () 
    {
        showViewKmpPol (getPrimaryViewContext (), null, Collections.emptyMap ());
    }

    @Override
    public String getAppID () 
    {
        return "XXI.PKMPPOL"; 
    }
    
    public static void main (String[] args) 
    {
        launch (args);
    }

    @StartMethod (description = "Не поленитесь указать описание для showViewKmpPol, JInvDesktop будет премного благодарен") 
    public static void showViewKmpPol ( ViewContext vc, TaskContext tc, Map<String, Object> map ) 
    {
        new FXFormLauncher<> (tc, vc, ViewKmpPolController.class)
            .initProperties (map)
            .show ();
    }
    
}

