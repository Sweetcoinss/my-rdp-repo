package virtual.camera.app.util;

import android.content.Context;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;

import virtual.camera.app.app.App;

public class ToastUtils {
    static Toast toast;

    public static void showToast(int messageID) {
        showToast(App.getContext(), messageID);
    }

    public static void showToast(String message) {
        showToast(App.getContext(), message);
    }

    public static void showToast(int messageID, int duration) {
        showToast(App.getContext(), messageID, duration);
    }

    public static void showToast(String message, int duration) {
        showToast(App.getContext(), message, duration);
    }

    public static void showToast(Context context, int resId) {
        showToast(context, context.getString(resId), Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }

    private static void showToast(Context context, int resId, int duration) {
        showToast(context, context.getString(resId), duration);
    }

    private static void showToast(Context context, String message, int duration) {
        if (context == null) return;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            HandlerUtil.runOnMain(() -> toast(context, message, duration));
        } else {
            toast(context, message, duration);
        }
    }

    private static void toast(Context context, String message, int duration) {
        try {
            if (toast == null) {
                toast = new Toast(context);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(duration);
            }
            toast.setText(message);
            toast.show();
        } catch (Exception e) {
            Toast.makeText(context, message, duration).show();
            e.printStackTrace();
        }
    }
}
