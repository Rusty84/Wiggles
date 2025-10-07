package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.junit4.ComposeTestRule

fun robot(rule: ComposeTestRule, block: AppRobot.() -> Unit) {
    AppRobot(rule).apply(block)
}
