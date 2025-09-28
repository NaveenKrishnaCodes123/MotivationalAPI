package com.ecomartx.ecodeliveryboy.animations

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically

object AnimationUtils {
    
    // Screen transition animations
    val slideInFromRight = slideInHorizontally(
        initialOffsetX = { 300 },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
    
    val slideOutToLeft = slideOutHorizontally(
        targetOffsetX = { -300 },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300))
    
    val slideInFromLeft = slideInHorizontally(
        initialOffsetX = { -300 },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
    
    val slideOutToRight = slideOutHorizontally(
        targetOffsetX = { 300 },
        animationSpec = tween(300)
    ) + fadeOut(animationSpec = tween(300))
    
    // Content animations
    val slideInFromTop = slideInVertically(
        initialOffsetY = { -40 },
        animationSpec = tween(600)
    ) + fadeIn(animationSpec = tween(600))
    
    val slideInFromBottom = slideInVertically(
        initialOffsetY = { 50 },
        animationSpec = tween(800)
    ) + fadeIn(animationSpec = tween(800))
    
    // Spring animations
    val bouncySpring = spring<Float>(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessLow
    )
    
    val mediumSpring = spring<Float>(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessMedium
    )
    
    // Staggered animation delays
    fun getStaggeredDelay(index: Int, baseDelay: Int = 100): Int {
        return baseDelay * index
    }
}
