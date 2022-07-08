package com.example.authenticationform

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.authenticationform.authentication.Authentication
import org.junit.Rule
import org.junit.Test

class AuthenticationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun sign_in_title_displayed_by_default() {
        composeTestRule.setContent { 
            Authentication()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.title_sign_in)
        ).assertIsDisplayed()
    }

    @Test
    fun need_account_displayed_by_default() {
        composeTestRule.setContent {
            Authentication()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.action_need_account)
        ).assertIsDisplayed()
    }

    @Test
    fun sign_up_title_displayed_after_toggle() {
        composeTestRule.setContent {
            Authentication()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.action_need_account)
        ).performClick()

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.title_sign_up)
        ).assertIsDisplayed()
    }

    @Test
    fun sign_up_button_displayed_after_toggle() {
        composeTestRule.setContent {
            Authentication()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.action_need_account)
        ).performClick()

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.action_already_have_account)
        ).assertIsDisplayed()
    }

}