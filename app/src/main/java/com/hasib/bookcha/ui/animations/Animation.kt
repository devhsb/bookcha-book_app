package com.hasib.bookcha.ui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


//shimmer effct box for vertical list
@Composable
fun VerticalShimmerEffect(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        LazyVerticalGrid(GridCells.Adaptive(150.dp)){
            items(10){
                Column(
                    modifier = Modifier
                        .width(150.dp)
                        .height(250.dp)
                        .padding(10.dp)
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(vertical = 10.dp)
                            .shimmerEffect(),
                    )
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .height(10.dp)
                            .shimmerEffect()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(10.dp)
                                .shimmerEffect()
                        )
                        Spacer(modifier = Modifier.weight(.3F))
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .height(10.dp)
                                .shimmerEffect()
                        )
                    }
                }
            }
        }
    } else {
        contentAfterLoading()
    }
}

//shimmer effct box for horizontal list
@Composable
fun HorizontalShimmerEffect(
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        LazyRow{
            items(10){
                Column(
                    modifier = Modifier
                        .width(150.dp)
                        .height(250.dp)
                        .padding(10.dp)
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(vertical = 10.dp)
                            .shimmerEffect(),
                    )
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .height(10.dp)
                            .shimmerEffect()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(10.dp)
                                .shimmerEffect()
                        )
                        Spacer(modifier = Modifier.weight(.3F))
                        Box(
                            modifier = Modifier
                                .weight(0.5f)
                                .height(10.dp)
                                .shimmerEffect()
                        )
                    }
                }
            }
        }
    } else {
        contentAfterLoading()
    }
}


//modifier extension shimmer effect
fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ), label = ""
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFE6E6E6),
                Color(0xFFCFCFCF),
                Color(0xFFE6E6E6)
            ),
            start = Offset(startOffsetX, 0F),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )

        .onGloballyPositioned { size = it.size }
}


//visibility animation
@Composable
fun FadeEffect(
    content: @Composable AnimatedVisibilityScope.() -> Unit
){
    var visible by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit, block = {
        delay(0L)
        visible = true
    })
    AnimatedVisibility(
        visible = visible, modifier = Modifier.fillMaxSize(),
        enter = fadeIn(initialAlpha = 0.0f) + slideInHorizontally(
            tween(
                durationMillis = 150,
                delayMillis = 150,
                easing = LinearOutSlowInEasing
            ),
            initialOffsetX = { 0 }
        )
        , content = content
    )
}