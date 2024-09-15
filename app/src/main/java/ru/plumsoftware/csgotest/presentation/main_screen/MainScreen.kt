package ru.plumsoftware.csgotest.presentation.main_screen

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.plumsoftware.csgotest.R
import ru.plumsoftware.csgotest.presentation.main_screen.components.CyberSportsmenItem
import ru.plumsoftware.csgotest.presentation.main_screen.store.MainScreenIntent
import ru.plumsoftware.csgotest.presentation.main_screen.store.MainState
import ru.plumsoftware.csgotest.presentation.theme.CsGoTheTestGameTheme
import ru.plumsoftware.data.repository.QuestionsRepositoryImpl
import ru.plumsoftware.domain.model.CyberSportsmen
import ru.plumsoftware.domain.model.Question

@Composable
fun MainScreen(state: State<MainState>, onMainIntent: (MainScreenIntent) -> Unit) {
    MainScreenContent(
        back = state.value.back,
        question = state.value.questions.elementAt(state.value.currentQuestion),
        isFinish = state.value.isFinish,
        cyberSportsmen = state.value.cyberSportsmen,
        isVisibleText = state.value.isVisibleText,
        onMainIntent = onMainIntent
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MainScreenContent(
    @DrawableRes back: Int,
    question: Question,
    isFinish: Boolean,
    cyberSportsmen: CyberSportsmen,
    isVisibleText: Boolean,
    onMainIntent: (MainScreenIntent) -> Unit
) {

    val scale by animateFloatAsState(
        targetValue = if (isVisibleText) 1f else 0f,
        animationSpec = tween(durationMillis = 100),
        label = "question text scale"
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(back),
            contentDescription = stringResource(R.string.back_content_description),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 12.dp, alignment = Alignment.Top)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(all = 24.dp)
                    .weight(1.0f)
            ) {
                Card(
                    modifier = Modifier
                        .wrapContentWidth()
                        .defaultMinSize(minHeight = 150.dp)
                        .padding(all = 24.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.scrim
                    ),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    )
                ) {
                    if (isFinish)
                        CyberSportsmenItem(
                            cyberSportsmen = cyberSportsmen,
                            onRetryClick = {
                                onMainIntent(MainScreenIntent.RetryClick)
                            }
                        )
                    else
                        Text(
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(horizontal = 12.dp, vertical = 36.dp)
                                .scale(scale),
                            textAlign = TextAlign.Start,
                            text = question.question,
                            style = MaterialTheme.typography.bodyLarge
                        )
                }
            }

            if (!isFinish)
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1.0f)
                        .padding(all = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 12.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 12.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    maxItemsInEachRow = 2
                ) {
                    question.answers.forEachIndexed { index, s ->
                        OutlinedButton(
                            modifier = Modifier
                                .defaultMinSize(minHeight = 80.dp)
                                .weight(1.0f),
                            shape = MaterialTheme.shapes.medium,
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = MaterialTheme.colorScheme.secondary,
                                contentColor = MaterialTheme.colorScheme.onSecondary
                            ),
                            border = BorderStroke(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.scrim
                            ),
                            onClick = {
                                onMainIntent(MainScreenIntent.AnswerClick)
                            }
                        ) {
                            Text(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(horizontal = 12.dp, vertical = 24.dp),
                                textAlign = TextAlign.Start,
                                text = s,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
private fun MainScreenContentPreview() {
    CsGoTheTestGameTheme {
        Scaffold {
            MainScreenContent(
                back = ru.plumsoftware.back.R.drawable.back_1,
                question = QuestionsRepositoryImpl().getQuestions()[0],
                cyberSportsmen = CyberSportsmen(),
                isFinish = false,
                isVisibleText = true,
                onMainIntent = {}
            )
        }
    }
}