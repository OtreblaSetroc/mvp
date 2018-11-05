package hidrosina.gshp.net.pre_alpha_hidrosina;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hidrosina.gshp.net.pre_alpha_hidrosina.Presenter.Presenter;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVMain;
import hidrosina.gshp.net.pre_alpha_hidrosina.ui.adapter.RVMain2;
import io.realm.Realm;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

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
        Realm.init(this);
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
    public void setRv(RVMain2 rvmain,Context context) {
        rvMain.setLayoutManager(lmy);
        rvMain.setAdapter(rvmain);
        presenter.setupRecyclerView( rvMain,context);

    }

    @Override
    public void initStethoWithReal(Context context) {
        //To initialize Stetho and Stetho-Realm.
        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                        .enableWebKitInspector(
                                RealmInspectorModulesProvider.builder(context)
                                        .withDeleteIfMigrationNeeded(true) //if there is any changes in database schema then rebuild bd.
                                        .withMetaTables() //extract table meta data
                                        .withLimit(10000) //by default limit of data id 250, but you can increase with this
                                        .build()
                        )
                        .build());
    }
}
