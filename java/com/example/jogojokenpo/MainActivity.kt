package com.example.jogojokenpo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.jogojokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var binding: ActivityMainBinding
    var placarPlayer: Int = 0
    var placarCpu: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configuraInicio()
    }

    private fun configuraInicio() {
        binding.tesouraBtn.setOnClickListener(this)
        binding.pedraBtn.setOnClickListener(this)
        binding.papelBtn.setOnClickListener(this)
        binding.novoJogoBtn.setOnClickListener(this)
    }

    override fun onClick(botao: View) {
        when (botao.id) {
            binding.tesouraBtn.id -> escolhaJogador("Tesoura")
            binding.pedraBtn.id -> escolhaJogador("Pedra")
            binding.papelBtn.id -> escolhaJogador("Papel")
            binding.novoJogoBtn.id -> novoJogo()
        }
    }

    private fun sorteiaCPU(): String {
        val listaOpcoes: List<String> = listOf("Tesoura", "Pedra", "Papel")
        return listaOpcoes.random()
    }

    private fun escolhaJogador(escolha: String) {
        val escolhaCpu = sorteiaCPU()

        binding.escolhaPlayerTxt.text = escolha
        binding.opcaoCpuTxt.text = escolhaCpu

        when {
            escolha == escolhaCpu -> {
                // Empate
            }
            escolhaCpu == "Pedra" && escolha == "Tesoura" ||
                    escolhaCpu == "Papel" && escolha == "Pedra" ||
                    escolhaCpu == "Tesoura" && escolha == "Papel" -> {
                placarCpu++
            }
            else -> {
                placarPlayer++
            }
        }

        binding.resultadoPlayerTxt.text = placarPlayer.toString()
        binding.resultadoCpuTxt.text = placarCpu.toString()
    }

    private fun novoJogo() {
        placarPlayer = 0
        placarCpu = 0

        binding.resultadoPlayerTxt.text = "0"
        binding.resultadoCpuTxt.text = "0"
        binding.escolhaPlayerTxt.text = "-"
        binding.opcaoCpuTxt.text = "-"
    }
}
