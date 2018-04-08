package ru.ivanarh.ndcrashdemo;

import android.util.Log;
import android.widget.Toast;

import ru.ivanarh.jndcrash.Error;
import ru.ivanarh.jndcrash.NDCrashService;
import ru.ivanarh.jndcrash.Unwinder;

/**
 * Service for out-of-process crash handling daemon. Should be run from a separate process.
 */
public class CrashService extends NDCrashService {

    /**
     * Log tag.
     */
    private static final String TAG = "NDCRASHDEMO";

    @Override
    public void onCrash(String reportPath) {
        Log.i(TAG, "Crash report has been successfully saved: " + reportPath);
    }

    @Override
    protected void onDaemonStart(Unwinder unwinder, String reportPath, Error result) {
        if (result == Error.ok) return;
        Toast.makeText(
                this,
                "Couldn't start NDCrash out-of-process daemon with unwinder: " + unwinder + ", error: " + result,
                Toast.LENGTH_SHORT
        ).show();
    }
}
