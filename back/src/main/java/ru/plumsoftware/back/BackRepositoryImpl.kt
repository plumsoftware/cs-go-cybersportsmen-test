package ru.plumsoftware.back

import ru.plumsoftware.domain.repository.BackRepository
import kotlin.random.Random

class BackRepositoryImpl : BackRepository {
    override fun getBack(): Int {
        val backs = listOf(
            R.drawable.back_1,
            R.drawable.back_2,
            R.drawable.back_3,
            R.drawable.back_4,
            R.drawable.back_5,
            R.drawable.back_6,
            R.drawable.back_7,
            R.drawable.back_8,
            R.drawable.back_9,
            R.drawable.back_10,
        )
        return backs[Random.nextInt(from = 0, until = backs.size)]
    }
}