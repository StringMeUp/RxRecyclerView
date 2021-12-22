package com.example.rxrecyclerview.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.rxrecyclerview.databinding.RxEditTextBinding

class RxEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var _binding: RxEditTextBinding? = null
    val binding: RxEditTextBinding
        get() = _binding!!

    init {
        _binding = RxEditTextBinding.inflate(LayoutInflater.from(context), this, true)
    }

}