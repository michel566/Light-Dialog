package michel566.androidmodules.lightdialog

import android.content.Context
import android.os.Build
import android.view.View

object CustomDialogUtils {
    fun checkMinimalAPI(buildVersionCode: Int): Boolean {
        return Build.VERSION.SDK_INT >= buildVersionCode
    }

    fun setLayout(
        context: Context,
        view: View,
        resourceDrawable: Int,
        supportResourceDrawable: Int
    ) {
        if (checkMinimalAPI(Build.VERSION_CODES.LOLLIPOP)) {
            view.background = context.resources.getDrawable(resourceDrawable)
            view.elevation = context.resources.getDimension(R.dimen.defaultElevation)
        } else {
            view.background = context.resources.getDrawable(supportResourceDrawable)
        }
    }
}