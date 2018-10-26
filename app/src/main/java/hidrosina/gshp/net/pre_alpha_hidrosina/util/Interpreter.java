package hidrosina.gshp.net.pre_alpha_hidrosina.util;

import android.text.Layout;
import android.view.View;

public interface Interpreter {

    void setViewSecction(View v ,int idModule,int idForm, String ... data);
    void setLayoutDistribution( int idLayout, Layout lyot, int colorHead, String ... title);
    void setLayoutDistributionFull(int rows,int colorHead,int margin, int marginLeft, int marginRight,int marginTop,int marginBottom,String ... title);



}
