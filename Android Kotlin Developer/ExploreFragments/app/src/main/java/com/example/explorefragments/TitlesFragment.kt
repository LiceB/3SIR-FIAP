package com.example.explorefragments

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.explorefragments.databinding.FragmentTitlesBinding

class TitlesFragment : Fragment() {

    private lateinit var binding: FragmentTitlesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_titles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTitlesBinding.bind(view)

        binding.btnA.setOnClickListener {
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                val fragmentManager = parentFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                //fragmentTransaction.add(R.id.details, DetailItemAFragment())
                fragmentTransaction.replace(R.id.details, DetailItemAFragment())
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            } else {
                val intent = Intent().apply {
                    setClass(requireContext(), DetailActivity::class.java)
                    putExtra("Frag", "A")
                }
                startActivity(intent)
            }
        }
    }
}