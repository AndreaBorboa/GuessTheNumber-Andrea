package borboa.andrea.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.max
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var minValue = 0
    var maxValue = 100
    var num:Int = 0
    var won = false

    fun resetValues(){
        minValue = 0;
        maxValue = 100;
        num = 0;
        won = false;
    }

    fun checkingLimits():Boolean{
        return minValue!=maxValue
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var guessing:TextView = findViewById(R.id.guessings)
        var down: Button = findViewById(R.id.down)
        var up:Button = findViewById(R.id.up)
        var generate:Button = findViewById(R.id.generate)
        var guessed:Button = findViewById(R.id.guessed)

        generate.setOnClickListener {
            num = Random.nextInt(maxValue)
            guessing.text = num.toString()
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minValue = num
            if(checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessing.text = num.toString()
            }else{
                guessing.text = "no puede ser :O Ganaste"
            }
        }

        down.setOnClickListener {
            maxValue = num
            if(checkingLimits()){
                num = Random.nextInt(minValue, maxValue)
                guessing.text = num.toString()
            }else{
                guessing.setText("No puede ser :O Ganaste");
            }
        }

        guessed.setOnClickListener {
            if(!won){
                guessing.text = "Tu número es el "+ num;
                guessed.text = "Volver a jugar";
                won = true;
            }else{
                generate.visibility = View.VISIBLE;
                guessing.text = "Tap on generate to start";
                guessed.visibility = View.GONE
                resetValues();
            }
        }

    }
}
