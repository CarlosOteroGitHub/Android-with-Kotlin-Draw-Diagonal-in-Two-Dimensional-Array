package com.example.myapplicationkootlin

/*

Author: Ing. Carlos Otero Ramírez

 */

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() , View.OnClickListener {

    var guardar:String = "";
    var posicion:Int = 0;
    var matriz = Array(3, {IntArray(3)});

    private var button1:Button ?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTitle("Matrices");

        button1 = findViewById(R.id.AM1_id1);
        button1!!.setOnClickListener(this);

        for(i in 0..matriz.size-1){
            for(j in 0..matriz[i].size-1){
                matriz[i][j] = 1;
                if(i == posicion){
                    matriz[i][j] = 5;
                }
                posicion++;
            }
            posicion = 0;
        }

        dialogoAlerta(null, imprimir(matriz));
    }

    fun dialogoAlerta(view: View?, mensaje: String){
        val builder = AlertDialog.Builder(this);
        builder.setTitle("Mensaje Informativo!");
        builder.setMessage(mensaje);
        builder.show();
    }

    fun imprimir(matriz: Array<IntArray>): String {
        for(i in 0..matriz.size-1){
            for(j in 0..matriz[i].size-1){
                guardar += "[" + matriz[i][j] + "] ";
            }
            guardar += "\n";
        }
        return guardar;
    }

    override fun onClick(v: View?){
        when(v?.id) {
            R.id.AM1_id1 ->
                System.exit(0);
        }
    }
}