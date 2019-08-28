package jp.co.charco.twolabeltextinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val textInputLayout by lazy { findViewById<TextInputLayout>(R.id.textInputLayout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (textInputLayout?.editText?.hasFocus() == true) {
            textInputLayout.editText!!.clearFocus()
        } else {
            super.onBackPressed()
        }
    }
}
