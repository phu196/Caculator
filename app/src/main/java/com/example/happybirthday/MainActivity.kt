package com.example.happybirthday

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity(), View.OnClickListener {
    lateinit var textResult : TextView
    var state:Int = 1
    var op : Int = 0
    var op1 : Int = 0
    var op2 : Int = 0
    var mem = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.text_result)
        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.ce).setOnClickListener(this)
        findViewById<Button>(R.id.c).setOnClickListener(this)
        findViewById<Button>(R.id.bs).setOnClickListener(this)
        findViewById<Button>(R.id.divide).setOnClickListener(this)
        findViewById<Button>(R.id.time).setOnClickListener(this)
        findViewById<Button>(R.id.sub).setOnClickListener(this)
        findViewById<Button>(R.id.add).setOnClickListener(this)
        findViewById<Button>(R.id.equal).setOnClickListener(this)
        findViewById<Button>(R.id.dec).setOnClickListener(this)
        findViewById<Button>(R.id.another).setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if(id == R.id.button0){
            addDigit(0)
        }
        else if(id == R.id.button1){
            addDigit(1)
        }
        else if(id == R.id.button2){
            addDigit(2)
        }
        else if(id == R.id.button3){
            addDigit(3)
        }
        else if(id == R.id.button4){
            addDigit(4)
        }
        else if(id == R.id.button5){
            addDigit(5)
        }
        else if(id == R.id.button6){
            addDigit(6)
        }
        else if(id == R.id.button7){
            addDigit(7)
        }
        else if(id == R.id.button8){
            addDigit(8)
        }
        else if(id == R.id.button9){
            addDigit(9)
        }
        else if(id == R.id.c){
            state = 1
            textResult.text="0"
            op = 0
            op1 = 0
            op2 = 0
        }
        else if(id == R.id.ce){
            textResult.text="0"
            if(state == 1){
                op1 = 0
            }
            else if(state == 2){
                op2 = 0
            }
        }
        else if(id == R.id.bs){
            if(state == 1){
                if(op1 >= 0){
                    var temp = op1 % 10
                    op1 = op1 - temp
                    op1 = op1 / 10
                    textResult.text="$op1"
                }
                else{
                    op1 = -op1
                    var temp = op1 % 10
                    op1 = op1 - temp
                    op1 = op1 / 10
                    op1 = -op1
                    textResult.text="$op1"
                }
            }
            else if(state == 2){
                if(op2 >= 0){
                    var temp = op2 % 10
                    op2 = op2 - temp
                    op2 = op2 / 10
                    textResult.text="$op2"
                }
                else{
                    op2 = -op2
                    var temp = op2 % 10
                    op2 = op2 - temp
                    op2 = op2 / 10
                    op2 = -op2
                    textResult.text="$op2"
                }
            }
        }
        else if(id == R.id.divide){
            if(state == 1){
                op = 1
                state = 2
            }
            else if(state == 2){
                textResult.text="${mem}"
                op1 = mem
                op2 = 0
                op = 1
                state = 2
            }
        }
        else if(id == R.id.time){
            if(state == 1){
                op = 2
                state = 2
            }
            else if(state == 2){
                textResult.text="${mem}"
                op1 = mem
                op2 = 0
                op = 2
                state = 2
            }

        }
        else if(id == R.id.sub){
            if(state == 1){
                op = 3
                state = 2
            }
            else if(state == 2){
                textResult.text="${mem}"
                op1 = mem
                op2 = 0
                op = 3
                state = 2
            }
        }
        else if(id == R.id.add){
            if(state == 1){
                op = 4
                state = 2
            }
            else if(state == 2){
                textResult.text="${mem}"
                op1 = mem
                op2 = 0
                op = 4
                state = 2
            }
        }
        else if(id == R.id.dec){

        }
        else if(id == R.id.another) {
            if(state == 1){
                op1 = -op1
                textResult.text="${op1}"
            }
            else if(state == 2){
                op2 = -op2
                textResult.text="${op2}"
            }
        }
        else if(id == R.id.equal){
            var result = 0
            if(op == 4){
                result = op1 + op2
            }
            else if(op == 3){
                result = op1 - op2
            }
            else if(op == 2){
                result = op1 * op2
            }
            else if(op == 1){
                result = op1 / op2
            }
            textResult.text="$result"
            state = 1
            op1 = result
            op2 = 0

        }
    }
    fun addDigit(c : Int){
        if(state == 1){
            if(op1 >= 0){
                op1 = op1 * 10 + c
            }
            else{
                op1 = op1 * 10 - c
            }
            textResult.text="$op1"
        }
        else{
            if(op2 >= 0){
                op2 = op2 * 10 + c
            }
            else{
                op2 = op2 * 10 - c
            }
            textResult.text="$op2"
            if(op == 1){
                mem = op1 / op2
            }
            else if(op == 2){
                mem = op1 * op2
            }
            else if(op == 3){
                mem = op1 - op2
            }
            else if(op == 4){
                mem = op1 + op2
            }
        }
    }
}

