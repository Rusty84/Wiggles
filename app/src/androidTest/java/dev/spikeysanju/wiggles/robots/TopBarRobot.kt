package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag

class TopBarRobot(private val rule: ComposeTestRule) : BaseRobot(rule) {

    // Home Screen Top Bar
    fun verifyHomeTopBarIsDisplayed(titleText: String, subtitleText: String): TopBarRobot {
        rule.onNodeWithTag("topBar")
            .assertExists()
        rule.onNodeWithTag("homeTopBarTitle")
            .assertExists()
            .assertTextEquals(titleText)
        rule.onNodeWithTag("homeTopBarSubtitle")
            .assertExists()
            .assertTextEquals(subtitleText)
        rule.onNodeWithTag("themeToggleIcon")
            .assertExists()
        return this
    }

    // Detail Screen Top Bar
    fun verifyDetailTopBarIsDisplayed(titleText: String): TopBarRobot {
        rule.onNodeWithTag("detailScreenContainer")
            .assertExists()
        rule.onNodeWithTag("detailsTopBarTitle")
            .assertExists()
            .assertTextEquals(titleText)
        rule.onNodeWithTag("topBarBackIcon")
            .assertExists()
        return this
    }
}
