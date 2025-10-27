package com.ecomartx.motivationalapi

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class ErrorScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun errorMessageIsDisplayed() {
        val errorMsg = "Failed to load phrases"
        composeTestRule.setContent {
            ErrorScreen(errorMessage = errorMsg, onRetry = {})
        }

        composeTestRule.onNodeWithText(errorMsg).assertIsDisplayed()
        composeTestRule.onNodeWithText("Retry").assertIsDisplayed()
    }
}