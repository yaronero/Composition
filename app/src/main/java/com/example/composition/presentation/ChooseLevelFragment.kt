package com.example.composition.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.composition.R
import com.example.composition.databinding.FragmentChooseLevelBinding
import com.example.composition.databinding.FragmentGameBinding
import com.example.composition.domain.entity.Level
import java.lang.RuntimeException

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            buttonLevelTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            buttonLevelEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }
    }

    private fun launchGameFragment(level: Level){
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, GameFragment.newInstance(level))
            .addToBackStack(GameFragment.NAME)
            .commit()
    }

    companion object{

        fun newInstance(): ChooseLevelFragment {
            return ChooseLevelFragment()
        }
    }
}