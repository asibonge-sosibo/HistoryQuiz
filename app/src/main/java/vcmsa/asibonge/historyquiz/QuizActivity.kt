package HistoryQuiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vcmsa.asibonge.historyquiz.R

class QuizActivity : AppCompatActivity() {

    private lateinit var quizTimeTextView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var radioGroupAnswers: RadioGroup
    private lateinit var radioButtonTrue: RadioButton
    private lateinit var radioButtonFalse: RadioButton
    private lateinit var nextButton: Button
    private lateinit var quizImageView: ImageView

    private val correctAnswer = true

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizTimeTextView = findViewById(R.id.QuizTime)
        questionTextView = findViewById(R.id.textViewQuestion1)
        radioGroupAnswers = findViewById(R.id.radioButtonGroupAnswers)
        radioButtonTrue = findViewById(R.id.radioButtonTrue1)
        radioButtonFalse = findViewById(R.id.radioButtonFalse1)
        nextButton = findViewById(R.id.NextQuestion)
        quizImageView = findViewById(R.id.EditTextName)

        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroupAnswers.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedAnswer = when (selectedRadioButtonId) {
                R.id.radioButtonTrue1 -> true
                R.id.radioButtonFalse1 -> false
                else -> false
            }

            if (selectedAnswer == correctAnswer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect. Try again!", Toast.LENGTH_SHORT).show()
            }


            radioGroupAnswers.clearCheck()
        }
    }
}
