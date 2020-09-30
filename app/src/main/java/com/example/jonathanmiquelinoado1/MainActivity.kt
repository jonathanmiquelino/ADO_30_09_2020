package com.example.jonathanmiquelinoado1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prod1 = getSharedPreferences("produtos", Context.MODE_PRIVATE)
        val prod2 = getSharedPreferences("produtos1", Context.MODE_PRIVATE)

        //limpa a caixa de texto e nome da anotação
        btLimpar.setOnClickListener { v: View? ->
            textProd.text.clear()
            textCust.text.clear()
            txtVend.text.clear()
        }

        btSalvar.setOnClickListener{View ->

            if(textProd.text.isNotEmpty()){

                //salvar produto
                prod1.edit().putString(textProd.text.toString(), txtVend.text.toString()).apply()
                prod2.edit().putString(textProd.text.toString(), textCust.text.toString()).apply()
                Toast.makeText(this, "Produto salvo !", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this, "Campo nome vazio", Toast.LENGTH_SHORT).show()

            }

        }

        btAbrir.setOnClickListener { v: View? ->
            if(textProd.text.isNotEmpty()){
                var nome = prod1.getString(textProd.text.toString(),"")
                var custo = prod2.getString(textProd.text.toString(),"")

                if(nome!!.isNotEmpty()){
                    textCust.setText(nome)
                    txtVend.setText(custo)
                    Toast.makeText(this,"Produto aberto",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Nome Vazio ou Inexistente",Toast.LENGTH_SHORT).show()
                }

            }
            else{
                Toast.makeText(this,"Nome da anotação vazio",Toast.LENGTH_SHORT).show()
            }
        }

        btResultado.setOnClickListener{v:View? ->
            if(textProd.text.isNotEmpty()){
                var preco = prod1.getString(textProd.text.toString(),"")
                var custo = prod2.getString(textProd.text.toString(),"")
                var calc =  (custo!!.toDouble() - preco!!.toDouble())
                if(calc > 0){
                    resultado.setText("Você teve Lucro :"+calc.toString())
                }else{
                    resultado.setText("Você teve Prejuízo: "+calc.toString())
                }
            }
        }

    }
}