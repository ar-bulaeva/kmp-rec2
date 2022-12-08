package ru.graf.kmprec2;


import ru.inversion.fxpdocparam.util.PStoredCode;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table (name="KMP_POL")
public class PSearchCode extends PStoredCode<String>
{
    @Override
    @Column (name = CODE_COLUMN_NAME)
    public String getCode () {
        return super.getCode ();
    }

    @Transient
    @Override
    public String getMethodPropertyName () {
        return METHOD_NAME;
    }

    private static final String METHOD_NAME = "1";
    private static final String CODE_COLUMN_NAME = "CSQL";
}
