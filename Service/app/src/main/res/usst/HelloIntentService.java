package usst;

import android.app.IntentService;

/**
 * Created by 单 on 2017/4/13.
 */

public class HelloIntentService extends IntentService {
    public HelloIntentService() {
        super("HelloIntentService");
    }

    protected void onHandleIntent(Intent intent) {
// Normally we would do some work here, like download a file.
// For our sample, we just sleep for 5 seconds.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
// Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent,flags,startId);
    }
}
