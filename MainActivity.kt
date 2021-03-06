package com.andrewbas.interviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val createdList =  mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(this)
    }

    private fun searchForPouch(createdList: MutableList<Int>){



        var currentSum: Float = 0F
        var idealSum: Float = 0F

        for (index in createdList.indices){

            if (index == 0 ) {

                idealSum += createdList[index].toFloat()
                currentSum += createdList[index].toFloat()


            }else if (index != 0){


                idealSum +=100F / index.toFloat()
                currentSum += createdList[index].toFloat()/index.toFloat()
            }
        }


       val answer =  (10/(idealSum-currentSum))

            tvAnswer.text = answer.toString()
    }

    private fun createList(size: Int, number: Int): MutableList<Int>{

        var iterator = 0

        createdList.removeAll(createdList)

        while (size >= iterator){

            createdList.add(index = iterator, element = 100)

           ++iterator
        }
        createdList.add(number, 90)
        return createdList
    }

    override fun onClick(v: View?) {
        if (v?.id == btn.id){

            var number = 0
            var size = 0

            if (etNumber.text.isNotEmpty()){
                number = etNumber.text.toString().toInt()
            }

            if (etSize.text.isNotEmpty()) {
               size = etSize.text.toString().toInt()
            }

            if(number == 0 || size ==0){

                val toast = Toast.makeText(this, "номер мешочка или количество мешочков не должно равняться нулю", Toast.LENGTH_LONG)
                    .show()

            }else if (number > 0 && size > 0){

                if (size >= number){

                    createList(size, number)

                    searchForPouch(createdList)

                }else{
                    val toast = Toast.makeText(this, "номер мешочка должен быть меньше количества мешочков", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}

