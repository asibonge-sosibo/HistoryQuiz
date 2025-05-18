package vcmsa.asibonge.historyquiz

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityQuiz5 : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var radioGroupAnswers: RadioGroup
    private lateinit var radioButtonTrue: RadioButton
    private lateinit var radioButtonFalse: RadioButton
    private lateinit var nextButton: Button

    // Correct answer: TRUE (World War II ended with Hitler’s surrender in 1945)
    private val correctAnswer = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz5)

        // Apply padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.QuestionQuiz1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        questionTextView = findViewById(R.id.textViewLastQuestion5)
        radioGroupAnswers = findViewById(R.id.radioGroupAnswers5)
        radioButtonTrue = findViewById(R.id.radioButtonTrue5)
        radioButtonFalse = findViewById(R.id.radioButtonFalse5)
        nextButton = findViewById(R.id.NextQuestion)

        // Button click handling
        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroupAnswers.checkedRadioButtonId

            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedAnswer = when (selectedRadioButtonId) {
                R.id.radioButtonTrue5 -> true
                R.id.radioButtonFalse5 -> false
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
