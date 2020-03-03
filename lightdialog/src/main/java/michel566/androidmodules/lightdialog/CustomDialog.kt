package michel566.androidmodules.lightdialog

import android.app.Dialog
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

class CustomDialog : Dialog, View.OnClickListener {
    private var message: String
    private var type: DialogType
    private var tvTitle: TextView? = null
    private var iconDialogBox: ImageView? = null

    constructor(
        context: Context,
        message: String,
        dialogType: DialogType
    ) : super(context) {
        this.message = message
        type = dialogType
    }

    constructor(
        context: Context,
        message: String,
        dialogType: DialogType,
        isCanceledOnTouchOutside: Boolean
    ) : super(context) {
        this.message = message
        type = dialogType
        setCanceledOnTouchOutside(isCanceledOnTouchOutside)
    }

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialogbox_alert)
        val container = findViewById<LinearLayout>(R.id.container_dialogBoxAlert)
        iconDialogBox = findViewById(R.id.iconDialogBox)
        tvTitle = findViewById(R.id.tv_TitleDialogBox)
        val tvDialogText = findViewById<TextView>(R.id.tv_dialogText)
        CustomDialogUtils.setLayout(
            context,
            container,
            R.drawable.layout_card,
            R.drawable.layout_card_shadow
        )
        changeDialogType(type)
        tvDialogText.text = message
    }

    private fun changeDialogType(type: DialogType) {
        when (type) {
            DialogType.INFO -> {
                tvTitle!!.text = "Informação"
                tvTitle!!.setTextColor(context.resources.getColor(R.color.colorInfoDialog))
                iconGenerator(iconDialogBox, R.drawable.ic_info, R.color.colorInfoDialog)
                dismiss()
            }
            DialogType.ALERT -> {
                tvTitle!!.text = "Atenção!"
                tvTitle!!.setTextColor(context.resources.getColor(R.color.colorAlertDialog))
                iconGenerator(iconDialogBox, R.drawable.ic_error, R.color.colorAlertDialog)
                dismiss()
            }
            DialogType.ERROR -> {
                tvTitle!!.text = "Erro"
                tvTitle!!.setTextColor(context.resources.getColor(R.color.colorErrorDialog))
                iconGenerator(iconDialogBox, R.drawable.ic_cancel, R.color.colorErrorDialog)
                dismiss()
            }
            else -> {
            }
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_DialogEscape) {
            dismiss()
        }
        dismiss()
    }

    private fun iconGenerator(
        imageView: ImageView?,
        resourceDrawable: Int,
        resourceTargetColor: Int
    ) {
        if (CustomDialogUtils.checkMinimalAPI(Build.VERSION_CODES.LOLLIPOP)) {
            val drawable: Drawable? = VectorDrawableCompat.create(
                context.resources,
                resourceDrawable, context.theme
            )
            if (drawable != null) {
                val porterDuffColorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(context, resourceTargetColor), PorterDuff.Mode.SRC_ATOP
                )
                drawable.colorFilter = porterDuffColorFilter
                imageView!!.setImageDrawable(drawable)
            }
        }
    }

    fun onOptionEscapeClickListener(
        listener: View.OnClickListener?,
        textButton: String?
    ) {
        val escape =
            findViewById<Button>(R.id.bt_DialogEscape)
        escape.visibility = View.VISIBLE
        escape.text = textButton
        escape.setOnClickListener(listener)
    }

    fun onOptionConfirmClickListener(
        listener: View.OnClickListener?,
        textButton: String?
    ) {
        val confirm =
            findViewById<Button>(R.id.bt_DialogConfirm)
        confirm.visibility = View.VISIBLE
        confirm.text = textButton
        confirm.setOnClickListener(listener)
    }
}