package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {

    lateinit var bind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val tarefas = getTarefas()


        updateList(tarefas)

        bind.btnSave.setOnClickListener {
            val prioridade = Integer.parseInt(bind.txtPrioridade.text.toString())
            val descricao = bind.txtDescricao.text.toString()
            tarefas.add(TarefaModel(prioridade, descricao))
            saveList(tarefas)
            updateList(tarefas)
        }

    }

    //viewModel
    fun saveList(listTarefas:List<TarefaModel>){
        val listJson = Gson().toJson(listTarefas)

        val sharedPreferences = getSharedPreferences(Constantes.TAREFAS_BASE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(Constantes.LISTA_TAREFAS, listJson)
        editor.apply()
    }

    //viewModel
    fun getTarefas() : MutableList<TarefaModel> {
        val shared = getSharedPreferences(Constantes.TAREFAS_BASE, Context.MODE_PRIVATE)
        val jsonLista = shared.getString(Constantes.LISTA_TAREFAS, null)
        if(jsonLista == null) {
            return mutableListOf()
        } else {
            val type: Type = object : TypeToken<MutableList<TarefaModel>>(){}.type
            val listaTarefa = Gson().fromJson<MutableList<TarefaModel>>(jsonLista, type)
            return listaTarefa
        }
    }

    fun updateList(lista: List<TarefaModel>) {
        if(lista.size > 0){
            lista.sortedBy { it.prioridade }
            var value = ""
            for (tarefa : TarefaModel in lista) {
                value += " - ${tarefa.prioridade} -> ${tarefa.descricao} \n"
            }
            bind.txtLista.text = value
        } else {
            bind.txtLista.text = "nada para fazer"
        }
    }
}