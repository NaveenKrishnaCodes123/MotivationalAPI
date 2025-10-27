package com.ecomartx.practise1

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class MyComposeContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun header_isDisplayed() {
        composeTestRule.setContent {
            MyComposeContent()
        }

        // Verify header exists
        composeTestRule.onNodeWithText("🍴 Today's Menu").assertIsDisplayed()
    }

    @Test
    fun items_areAddedAndDisplayed() {
        composeTestRule.setContent {
            MyComposeContent()
        }

        // Wait for items to be added (delay in LaunchedEffect)
        composeTestRule.waitUntil(timeoutMillis = 6000) {
            composeTestRule.onAllNodesWithText("🍟 Food Item 10").fetchSemanticsNodes().isNotEmpty()
        }

        // Verify one of the items
        composeTestRule.onNodeWithText("🍟 Food Item 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("🍟 Food Item 10").assertIsDisplayed()
    }
}