package hidrosina.gshp.net.pre_alpha_hidrosina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.Presenter;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVMain;

public class MainActivity extends AppCompatActivity implements Presenter.View {
    @BindView(R.id.txttitleActivity2)
     TextView txtViewMenu;
    @BindView(R.id.id_tittle_header)
     TextView txtViewTittle;
    @BindView(R.id.rvMain)
    RecyclerView rvMain;
    private Presenter  presenter;
    private LinearLayoutManager lmy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        presenter= new Presenter(this);
        lmy = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        presenter.init(getApplicationContext());


    }


    @Override
    public void changeMenuTittle(String info) {
        txtViewMenu.setText(info+"");

    }

    @Override
    public void changeHeaderTittle(String info) {
        txtViewTittle.setText(info+"");
    }

    @Override
    public void setRv(RVMain rvmain) {
        rvMain.setLayoutManager(lmy);
        rvMain.setAdapter(rvmain);
    }
}
