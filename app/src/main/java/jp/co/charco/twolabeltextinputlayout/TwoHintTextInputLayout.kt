package jp.co.charco.twolabeltextinputlayout

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import androidx.core.view.postDelayed
import com.google.android.material.textfield.TextInputLayout

class TwoHintTextInputLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr) {

    private var focusedHint: String? = null

    init {
        initAttrs(attrs)

        editText?.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                postDelayed(167) {
                    (view as EditText).hint = focusedHint
                }
            } else {
                (view as EditText).hint = null
            }
        }
    }

    private fun initAttrs(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.TwoHintTextInputLayout)
            focusedHint = a.getResourceId(R.styleable.TwoHintTextInputLayout_focusedHint, 0)
                .takeIf { it != 0 }
                ?.let { context.getString(it) }
            a.recycle()
        }
    }
}