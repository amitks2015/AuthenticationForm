package com.example.authenticationform

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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

    @Test
    fun authenticate_button_disabled_by_default() {
        composeTestRule.setContent {
            Authentication()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_sign_in)
        ).assertIsNotEnabled()
    }

    @Test
    fun authenticate_button_enabled_when_email_and_valid_password_set() {
        composeTestRule.setContent {
            Authentication()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_email)
        ).performTextInput("xyz@compose.com")

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_password)
        ).performTextInput("1ValidPassword")

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_sign_in)
        ).assertIsEnabled()
    }

    @Test
    fun authenticate_button_disabled_when_email_and_invalid_password_set() {
        composeTestRule.setContent {
            Authentication()
        }

        //Change it to signup mode
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.action_need_account)
        ).performClick()

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_email)
        ).performTextInput("xyz@compose.com")

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_password)
        ).performTextInput("InvalidPassword")

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_sign_up)
        ).assertIsNotEnabled()
    }

    @Test
    fun authenticate_button_disabled_when_email_field_empty() {
        composeTestRule.setContent {
            Authentication()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_email)
        ).performTextInput("xyz@compose.com")

        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.getString(R.string.label_sign_in)
        ).assertIsNotEnabled()
    }
}