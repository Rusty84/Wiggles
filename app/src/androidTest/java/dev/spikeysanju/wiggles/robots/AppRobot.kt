package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.junit4.ComposeTestRule

class AppRobot(private val rule: ComposeTestRule) {

    fun home(block: HomeRobot.() -> Unit) {
        HomeRobot(rule).apply(block)
    }

    fun detail(block: DetailRobot.() -> Unit) {
        DetailRobot(rule).apply(block)
    }

    fun topBar(block: TopBarRobot.() -> Unit) {
        TopBarRobot(rule).apply(block)
    }
}
