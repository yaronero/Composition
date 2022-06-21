package com.example.composition.domain.usecases

import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(val repository: GameRepository) {

    operator fun invoke(maxSumValue: Int): Question{
        return repository.generateQuestion(maxSumValue, COUNTS_OF_OPTIONS)
    }

    private companion object{
        private const val COUNTS_OF_OPTIONS = 4
    }
}