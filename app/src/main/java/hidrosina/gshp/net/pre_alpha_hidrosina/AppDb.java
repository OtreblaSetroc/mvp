package hidrosina.gshp.net.pre_alpha_hidrosina;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AppDb {
    private static final String NAME = "prueba.db";
    private static final int VERSION = 1;
    private static Realm realm;


    public static synchronized Realm getAppDbRealm(Context context) {
        if (realm == null) {
            Realm.init(context);
            RealmConfiguration configuration = new RealmConfiguration
                    .Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
            realm = Realm.getInstance(configuration);
        }
        return realm;
    }

}
