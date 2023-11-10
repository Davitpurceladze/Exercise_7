package com.example.exercise_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.graphics.drawable.toDrawable
import com.example.exercise_7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isNumeric: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val addFieldBtn = binding.btnAddField
        val checkBoxIsNumeric = binding.checkBoxIsNumeric

        checkBoxIsNumeric.setOnCheckedChangeListener { _, isChecked ->
            isNumeric = isChecked
        }


        addFieldBtn.setOnClickListener {
            createNewEditText(isNumeric  )
            checkBoxIsNumeric.isChecked = false
         }

    }

    private fun createNewEditText(isNumeric: Boolean   ) {
        val linearLayout = binding.scrollableLinearLayout
        val newEditText = EditText(this)
        newEditText.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        if(isNumeric)
            newEditText.inputType =  InputType.TYPE_CLASS_NUMBER
        else
            newEditText.inputType =  InputType.TYPE_CLASS_TEXT

        newEditText.hint = binding.etFieldName.text.toString()
        linearLayout.addView(newEditText)
        binding.etFieldName.setText("")

    }
}