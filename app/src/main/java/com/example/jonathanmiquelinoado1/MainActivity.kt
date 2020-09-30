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

        val sh = getSharedPreferences("produtos", Context.MODE_PRIVATE)
        val sh1 = getSharedPreferences("produtos1", Context.MODE_PRIVATE)

        //limpa a caixa de texto e nome da anotação
        btLimpar.setOnClickListener { v: View? ->
            textProd.text.clear()
            textCust.text.clear()
            txtVend.text.clear()
        }

        btSalvar.setOnClickListener{View ->

            if(textProd.text.isNotEmpty()){

                //salvar produto
                sh.edit().putString(textProd.text.toString(), textCust.text.toString()).apply()
                sh1.edit().putString(textProd.text.toString(), txtVend.text.toString()).apply()
                Toast.makeText(this, "Produto salvo !", Toast.LENGTH_SHORT).show()

            }else{

                Toast.makeText(this, "Campo nome vazio", Toast.LENGTH_SHORT).show()

            }

        }

        btAbrir.setOnClickListener { v: View? ->
            if(textProd.text.isNotEmpty()){
                var nome = sh.getString(textProd.text.toString(),"")
                var custo = sh1.getString(textProd.text.toString(),"")

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

//        btResultado.setOnClickListener{v:View? ->
//            if(textProd.text.isNotEmpty()){
//                var preco = sh.getString(textProd.text.toString(),"")
//                var custo = sh.getString(textProd.text.toString()+"Custo","")
//                var calc = (preco!!.toDouble() - custo!!.toDouble())
//                if(calc >0){
//                    .setText("Lucro "+calc.toString())
//                }else{
//                    calculo.setText("Prejuízo "+calc.toString())
//                }
//            }
//        }

        //////////////////////////////////////////////////////
//        btResultado.setOnClickListener { View ->
//            var custo = textCust.text.toString()
//            var venda = txtVend.text.toString()
//            var nome = textProd.text.toString()
//
//
//            if(nome.isNotEmpty() && custo.isNotEmpty() && venda.isNotEmpty()){
//
//                var resultado = venda.toDouble() - custo.toDouble()
//                var intent = Intent(this, ResultadoActivity::class.java)
//
//                if(resultado < 0){
//
//                    intent.putExtra("resposta", "Prejuízo!")
//                    intent.putExtra("resultado", resultado)
//
//                }else if(resultado > 0){
//
//                    intent.putExtra("resposta", "Lucro!")
//                    intent.putExtra("resultado", resultado)
//
//
//                }else{
//
//                    intent.putExtra("resposta", "Sem ganhos!")
//                    intent.putExtra("resultado", resultado)
//
//                }
//
//                startActivity(intent)
//
//            }else{
//
//                Toast.makeText(this, "Todos os campos devem estar preenchidos", Toast.LENGTH_SHORT).show()
//
//            }
//
//        }

        ///////////////////////////////////////////////////////

    }
}