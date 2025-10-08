package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.test.espresso.Espresso

open class BaseRobot(protected val composeTestRule: ComposeTestRule) {
    fun waitForIdle() = composeTestRule.waitForIdle()

    fun pressBack() {
        Espresso.pressBack()
    }

    fun SemanticsNodeInteraction.assertExistsAndIsDisplayed(): SemanticsNodeInteraction {
        return this.assertExists().assertIsDisplayed()
    }
}
