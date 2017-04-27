import android.app.Service;

/**
 * Created by 单 on 2017/4/13.
 */

public class ExampleService extends Service {



    int mStartMode; // indicates how to behave if the service is killed
    IBinder mBinder; // interface for clients that bind
    boolean mAllowRebind; // indicates whether onRebind should be used
    @Override
    public void onCreate (https://developer.android.com/reference/android/app/Service.html#onCreate()) () {
    // The service is being created
    }
    @Override
    public int onStartCommand (https://developer.android.com/reference/android/app/Service.html#onStartCommand(android.content.Intent, int, int))
    // The service is starting, due to a call to startService() (https://developer.android.com/reference/android/content/Context.html#startService(android.content.Intent))
            return mStartMode;
            }
            @Override
            public IBinder onBind (https://developer.android.com/reference/android/app/Service.html#onBind(android.content.Intent)) (Intent intent
    s// A client is binding to the service with bindService() (https://developer.android.com/reference/android/content/Context.html#bindService(android.content.Intent, android.content.ServiceConnection, int))
            return mBinder;
            }
            @Override
            public boolean onUnbind (https://developer.android.com/reference/android/app/Service.html#onUnbind(android.content.Intent)) (Intent intent
// All clients have unbound with unbindService() (https://developer.android.com/reference/android/content/Context.html#unbindService(android.content.ServiceConnection))
            return mAllowRebind;
            }
            @Override
            public void onRebind (https://developer.android.com/reference/android/app/Service.html#onRebind(android.content.Intent)) (Intent intent
// A client is binding to the service with bindService() (https://developer.android.com/reference/android/content/Context.html#bindService(android.content.Intent, android.content.ServiceConnection, int))
// after onUnbind() has already been called
            }
            @Override
            public void onDestroy (https://developer.android.com/reference/android/app/Service.html#onDestroy()) () {
// The service is no longer used and is being destroyed
            }
}
