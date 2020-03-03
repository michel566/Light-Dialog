package michel566.androidmodules.lightdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

public class LightDialog extends Dialog implements View.OnClickListener{

    public Context context;
    private String message;
    private DialogType type;
    private TextView tvTitle;
    private ImageView iconDialogBox;

    public LightDialog(Context context, String message, DialogType dialogType) {
        super(context);
        this.context = context;
        this.message = message;
        this.type = dialogType;
    }

    public LightDialog(Context context, String message, DialogType dialogType, boolean isCanceledOnTouchOutside) {
        super(context);
        this.context = context;
        this.message = message;
        this.type = dialogType;
        this.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogbox_alert);

        LinearLayout container = findViewById(R.id.container_dialogBoxAlert);
        iconDialogBox = findViewById(R.id.iconDialogBox);
        tvTitle = findViewById(R.id.tv_TitleDialogBox);
        TextView tvDialogText = findViewById(R.id.tv_dialogText);
        CustomDialogUtils.setLayout(context, container, R.drawable.layout_card, R.drawable.layout_card_shadow);
        changeDialogType(type);
        tvDialogText.setText(message);
    }

    private void changeDialogType(DialogType type) {
        switch (type) {
            case INFO:
                tvTitle.setText("Informação");
                tvTitle.setTextColor(context.getResources().getColor(R.color.colorInfoDialog));
                iconGenerator(iconDialogBox, R.drawable.ic_info, R.color.colorInfoDialog);
                this.dismiss();
                break;
            case ALERT:
                tvTitle.setText("Atenção!");
                tvTitle.setTextColor(context.getResources().getColor(R.color.colorAlertDialog));
                iconGenerator(iconDialogBox, R.drawable.ic_error, R.color.colorAlertDialog);
                this.dismiss();
                break;
            case ERROR:
                tvTitle.setText("Erro");
                tvTitle.setTextColor(context.getResources().getColor(R.color.colorErrorDialog));
                iconGenerator(iconDialogBox, R.drawable.ic_cancel, R.color.colorErrorDialog);
                this.dismiss();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_DialogEscape) {
            dismiss();
        }
        dismiss();
    }

    private void iconGenerator(ImageView imageView, int resourceDrawable, int resourceTargetColor) {
        if (CustomDialogUtils.checkMinimalAPI(Build.VERSION_CODES.LOLLIPOP)) {
            Drawable drawable = VectorDrawableCompat.create(context.getResources(),
                    resourceDrawable, context.getTheme());
            if (drawable != null) {
                PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(
                        ContextCompat.getColor(context, resourceTargetColor), PorterDuff.Mode.SRC_ATOP);

                drawable.setColorFilter(porterDuffColorFilter);
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public void onOptionEscapeClickListener(View.OnClickListener listener, String textButton) {
        Button escape = findViewById(R.id.bt_DialogEscape);
        escape.setVisibility(View.VISIBLE);
        escape.setText(textButton);
        escape.setOnClickListener(listener);
    }

    public void onOptionConfirmClickListener(View.OnClickListener listener, String textButton) {
        Button confirm = findViewById(R.id.bt_DialogConfirm);
        confirm.setVisibility(View.VISIBLE);
        confirm.setText(textButton);
        confirm.setOnClickListener(listener);
    }
}
