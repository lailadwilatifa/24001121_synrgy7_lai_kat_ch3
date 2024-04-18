package com.example.kata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kata.databinding.FragmentAlphabetBinding

class AlphabetFragment : Fragment() {
    private var _binding: FragmentAlphabetBinding? = null
    private val binding get() = _binding!!
    private var isList = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAlphabetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listWord = arrayListOf(
            MyWord("A", arrayListOf("ayah", "anggrek", "apel")),
            MyWord("B", arrayListOf("bioskop", "bunga", "boneka")),
            MyWord("C", arrayListOf("cantik", "cacing", "coklat")),
            MyWord("D", arrayListOf("dermawan", "delman", "dermaga")),
            MyWord("E", arrayListOf("elok", "elang", "empat")),
            MyWord("F", arrayListOf("facebook", "facewash", "fotosintesis")),
            MyWord("G", arrayListOf("gajah", "game", "golf")),
            MyWord("H", arrayListOf("harga", "hasil", "halal")),
            MyWord("I", arrayListOf("ibu", "implementasi", "institut")),
            MyWord("J", arrayListOf("jadwal", "jamur", "jawa")),
            MyWord("K", arrayListOf("koala", "keluarga", "kotlin")),
            MyWord("L", arrayListOf("lebaran", "lirik", "limit")),
            MyWord("M", arrayListOf("manusia", "menyapu", "mandiri")),
            MyWord("N", arrayListOf("niat", "netflix", "nonton")),
            MyWord("O", arrayListOf("obat", "orang", "ojk")),
            MyWord("P", arrayListOf("pantai", "pemilu", "puasa")),
            MyWord("Q", arrayListOf("quiz", "queen", "qatar")),
            MyWord("R", arrayListOf("richeese", "rumput", "rendang")),
            MyWord("S", arrayListOf("stasiun", "surat", "satwa")),
            MyWord("T", arrayListOf("taylor", "telepon", "telat")),
            MyWord("U", arrayListOf("uang", "universitas", "ukuran")),
            MyWord("V", arrayListOf("vidio", "vpn", "vespa")),
            MyWord("W", arrayListOf("waktu", "whatsapp", "wattpad")),
            MyWord("X", arrayListOf("xxi", "xenia", "xl")),
            MyWord("Y", arrayListOf("youtube", "yudisium", "yoyo")),
            MyWord("Z", arrayListOf("zendaya", "zodiak", "zalora"))
        )

        val adapter = AlphabetAdapter(listWord)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        setView(adapter, layoutManager)

        binding.btnMode.setOnClickListener {
            isList = !isList
            binding.btnMode.setImageDrawable(if(isList) resources.getDrawable(R.drawable.baseline_grid_view_24) else resources.getDrawable(R.drawable.baseline_menu_24))
            if(isList){
                setView(adapter, layoutManager)
            }else{
                setView(adapter, gridLayoutManager)
            }
        }
    }
    private fun setView(adapter: AlphabetAdapter, layoutManager: LinearLayoutManager){
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
    companion object {
        val EXTRA_WORDS = "EXTRA_WORDS"
    }
}