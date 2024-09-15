package ru.plumsoftware.data.repository

import ru.plumsoftware.data.R
import ru.plumsoftware.domain.model.CyberSportsmen
import ru.plumsoftware.domain.repository.CyberSportsmenRepository
import kotlin.random.Random

class CyberSportsmenRepositoryImpl : CyberSportsmenRepository {
    override fun getRandomPlayer(): CyberSportsmen {

        val cybersportsmenList = listOf(
            CyberSportsmen("s1mple", 1223054L, R.drawable.s1mple),
            CyberSportsmen("device", 1017035L, R.drawable.device),
            CyberSportsmen("NiKo", 999444L, R.drawable.niko),
            CyberSportsmen("ZywOo", 875795L, R.drawable.zywoo),
            CyberSportsmen("electronic", 789117L, R.drawable.electronic),
            CyberSportsmen("coldzera", 786870L, R.drawable.coldzera),
            CyberSportsmen("Magisk", 701454L, R.drawable.magisk),
            CyberSportsmen("NAF", 645741L, R.drawable.naf),
            CyberSportsmen("dupreeh", 641298L, R.drawable.dupreeh),
            CyberSportsmen("gla1ve", 632283L, R.drawable.gla1ve),
        )
        val index = Random.nextInt(from = 0, until = cybersportsmenList.size)
        return cybersportsmenList[index]
    }
}