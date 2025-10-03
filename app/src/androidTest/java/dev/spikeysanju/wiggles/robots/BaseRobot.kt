package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.junit4.ComposeTestRule

open class BaseRobot(protected val composeTestRule: ComposeTestRule) {
    fun waitForIdle() = composeTestRule.waitForIdle()
}
