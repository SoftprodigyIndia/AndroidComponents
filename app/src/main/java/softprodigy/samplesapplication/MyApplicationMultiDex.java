package softprodigy.samplesapplication;

import android.content.Context;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class MyApplicationMultiDex extends MultiDexApplication {
    private Object mTempObject = null;

    private boolean flagHomeFragmentFirstCreate = true;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
