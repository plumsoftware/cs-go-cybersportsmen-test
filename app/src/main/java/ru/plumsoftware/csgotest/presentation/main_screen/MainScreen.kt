package ru.plumsoftware.csgotest.presentation.main_screen

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.unit.IntOffset

@Composable
fun MainScreen(state: State<MainState>, onMainIntent: (MainScreenIntent) -> Unit) {
    MainScreenContent(
        back = state.value.back,
        question = state.value.questions.elementAt(state.value.currentQuestion),
        isFinish = state.value.isFinish,
        cyberSportsmen = state.value.cyberSportsmen,
        isVisibleText = state.value.isVisibleText,
        isVisibleButtons = state.value.isVisibleButtons,
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
    isVisibleButtons: Boolean,
    onMainIntent: (MainScreenIntent) -> Unit
) {

    val scale by animateFloatAsState(
        targetValue = if (isVisibleText) 1f else 0f,
        animationSpec = tween(durationMillis = 100),
        label = "question text scale"
    )

    val ver: FiniteAnimationSpec<IntOffset> = tween(
        durationMillis = 400,
        easing = LinearOutSlowInEasing
    )
    val fade: FiniteAnimationSpec<Float> = tween(
        durationMillis = 400,
        easing = FastOutSlowInEasing
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(back),
            contentDescription = stringResource(R.string.back_content_description),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
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
                    .weight(if (isFinish) 1.4f else 1.0f)
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
                    AnimatedVisibility(
                        visible = isFinish,
                        enter = fadeIn(
                            tween(
                                durationMillis = 800,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            tween(
                                durationMillis = 200,
                                easing = FastOutSlowInEasing
                            )
                        )
                    ) {
                        CyberSportsmenItem(
                            cyberSportsmen = cyberSportsmen,
                            onRetryClick = {

                            }
                        )
                    }

                    AnimatedVisibility(
                        visible = !isFinish,
                        enter = fadeIn(
                            tween(
                                durationMillis = 800,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            tween(
                                durationMillis = 200,
                                easing = FastOutSlowInEasing
                            )
                        )
                    ) {
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
            }

            if (isFinish) {
                OutlinedButton(
                    modifier = Modifier,
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
                        onMainIntent(MainScreenIntent.RetryClick)
                    }
                ) {
                    Text(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(horizontal = 12.dp, vertical = 24.dp),
                        textAlign = TextAlign.Start,
                        text = stringResource(R.string.retry_test),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

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
                    AnimatedVisibility(
                        modifier = Modifier
                            .defaultMinSize(minHeight = 80.dp)
                            .weight(1.0f),
                        visible = isVisibleButtons,
                        enter = fadeIn(fade) + slideInVertically(ver),
                        exit = fadeOut(fade) + slideOutVertically(ver)
                    ) {
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
                isVisibleButtons = true,
                onMainIntent = {}
            )
        }
    }
}