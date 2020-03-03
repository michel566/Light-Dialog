package michel566.androidmodules.apptestlightdialog

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import michel566.androidmodules.lightdialog.DialogType
import michel566.androidmodules.lightdialog.LightDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState ?: Bundle())
        setContentView(R.layout.activity_main)

        bt_info_oneButton.setOnClickListener {
            val dialog = LightDialog(this, "Olá Mundo!", DialogType.INFO)
            dialog.show()
            val click = View.OnClickListener {
                dialog.dismiss()
                Toast.makeText(this, "OK clicado", Toast.LENGTH_SHORT).show()
            }
            dialog.onOptionConfirmClickListener(click, "OK")
        }

    }
}
