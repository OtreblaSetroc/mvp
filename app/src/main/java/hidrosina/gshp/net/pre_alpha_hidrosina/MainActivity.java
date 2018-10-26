package hidrosina.gshp.net.pre_alpha_hidrosina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.Presenter;

public class MainActivity extends AppCompatActivity implements Presenter.View {
    @BindView(R.id.txttitleActivity2)
     TextView txtViewMenu;
    @BindView(R.id.id_tittle_header)
     TextView txtViewTittle;
    private Presenter  presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        presenter= new Presenter(this);
        presenter.init();


    }


    @Override
    public void changeMenuTittle(String info) {
        txtViewMenu.setText(info+"");

    }

    @Override
    public void changeHeaderTittle(String info) {
        txtViewTittle.setText(info+"");
    }
}
