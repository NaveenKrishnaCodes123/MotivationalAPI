package com.ecomartx.practise1.Test

import androidx.compose.ui.test.*
import com.ecomartx.practise1.MyComposeContent
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalCoroutinesApi::class)
class MyComposeContentTest {

//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun headerAndItemsAreDisplayed() = runTest {
//        composeTestRule.setContent {
//            MyComposeContent()
//        }
//
//        // Header should be visible immediately
//        composeTestRule.onNodeWithText("🍴 Today's Menu").assertExists()
//
//        // Simulate 500ms delay for each item (10 items)
//        repeat(10) {
//            composeTestRule.mainClock.advanceTimeBy(500)
//        }
//
//        composeTestRule.waitForIdle()
//
//        // Verify first and last items
//        composeTestRule.onNodeWithText("\uD83C\uDF5F Food Item 1").assertExists()
//        composeTestRule.onNodeWithText("\uD83C\uDF5F Food Item 10").assertExists()
//    }
}

