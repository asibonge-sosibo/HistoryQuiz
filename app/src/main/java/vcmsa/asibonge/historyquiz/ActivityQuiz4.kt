package vcmsa.asibonge.historyquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityQuiz4 : AppCompatActivity() {

    private lateinit var answerQuestionTextView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var radioGroupAnswers: RadioGroup
    private lateinit var radioButtonTrue: RadioButton
    private lateinit var radioButtonFalse: RadioButton
    private lateinit var nextButton: Button
    private lateinit var quizImageView: ImageView

    private val correctAnswer = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_quiz4)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.QuestionQuiz1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        answerQuestionTextView = findViewById(R.id.AnswerQuestion4)
        questionTextView = findViewById(R.id.textViewQuestion4)
        radioGroupAnswers = findViewById(R.id.radioGroupAnswers) ?: findRadioGroup()
        radioButtonTrue = findViewById(R.id.radioButtonTrue4)
        radioButtonFalse = findViewById(R.id.radioButtonFalse4)
        nextButton = findViewById(R.id.NextQuestion)
        quizImageView = findViewById(R.id.EditTextName)

        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroupAnswers.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedAnswer = when (selectedRadioButtonId) {
                R.id.radioButtonTrue4 -> true
                R.id.radioButtonFalse4 -> false
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

    private fun findRadioGroup(): RadioGroup {
        val root = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.QuestionQuiz1)
        val innerLayout = root.getChildAt(0) as? androidx.constraintlayout.widget.ConstraintLayout
            ?: throw IllegalStateException("Inner layout not found or not a ConstraintLayout!")

        val childCount = innerLayout.childCount
        for (i in 0 until childCount) {
            val child = innerLayout.getChildAt(i)
            if (child is RadioGroup) {
                return child
            }
        }

        throw IllegalStateException("RadioGroup not found in layout!")
    }
}
