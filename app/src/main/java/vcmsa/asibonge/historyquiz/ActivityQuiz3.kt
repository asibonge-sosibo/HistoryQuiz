package vcmsa.asibonge.historyquiz

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
import androidx.constraintlayout.widget.ConstraintLayout

class ActivityQuiz3 : AppCompatActivity() {

    private lateinit var answerQuestionTextView: TextView
    private lateinit var questionTextView: TextView
    private lateinit var radioGroupAnswers: RadioGroup
    private lateinit var radioButtonTrue: RadioButton
    private lateinit var radioButtonFalse: RadioButton
    private lateinit var nextButton: Button
    private lateinit var quizImageView: ImageView

    private val correctAnswer = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz3)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.QuestionQuiz1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        answerQuestionTextView = findViewById(R.id.AnswerQuestion3)
        questionTextView = findViewById(R.id.textViewQuestion3)
        radioGroupAnswers = findViewById(R.id.radioGroupAnswers)
        radioButtonTrue = findViewById(R.id.radioButtonTrue3)
        radioButtonFalse = findViewById(R.id.radioButtonFalse3)
        nextButton = findViewById(R.id.NextQuestion)
        quizImageView = findViewById(R.id.EditTextName)

        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroupAnswers.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedAnswer = when (selectedRadioButtonId) {
                R.id.radioButtonTrue3 -> true
                R.id.radioButtonFalse3 -> false
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
