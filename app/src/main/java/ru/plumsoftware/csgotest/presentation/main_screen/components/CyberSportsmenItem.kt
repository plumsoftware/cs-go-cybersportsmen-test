package ru.plumsoftware.csgotest.presentation.main_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.plumsoftware.csgotest.R
import ru.plumsoftware.domain.model.CyberSportsmen

@Composable
fun CyberSportsmenItem(cyberSportsmen: CyberSportsmen, onRetryClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(space = 12.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 12.dp)
    ) {
        Image(
            modifier = Modifier.size(width = 210.dp, height = 190.dp),
            painter = painterResource(cyberSportsmen.icon),
            contentDescription = cyberSportsmen.name
        )

        Text(text = cyberSportsmen.name, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(height = 12.dp))
        Text(
            text = stringResource(R.string.money),
            style = MaterialTheme.typography.bodyMedium
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = 6.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            Text(
                text = cyberSportsmen.money.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
            Image(
                modifier = Modifier.size(width = 44.dp, height = 44.dp),
                painter = painterResource(R.drawable.coin),
                contentDescription = cyberSportsmen.money.toString()
            )
        }
    }
}