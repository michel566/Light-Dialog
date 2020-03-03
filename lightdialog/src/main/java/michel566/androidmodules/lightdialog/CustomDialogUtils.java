package michel566.androidmodules.lightdialog;

import android.content.Context;
import android.os.Build;
import android.view.View;

public class CustomDialogUtils {

    public static boolean checkMinimalAPI(int buildVersionCode) {
        return Build.VERSION.SDK_INT >= buildVersionCode;
    }

    public static void setLayout(Context context, View view, int resourceDrawable, int supportResourceDrawable) {
        if (checkMinimalAPI(Build.VERSION_CODES.LOLLIPOP)) {
            view.setBackground(context.getResources().getDrawable(resourceDrawable));
            view.setElevation(context.getResources().getDimension(R.dimen.defaultElevation));
        } else {
            view.setBackground(context.getResources().getDrawable(supportResourceDrawable));
        }
    }

}
