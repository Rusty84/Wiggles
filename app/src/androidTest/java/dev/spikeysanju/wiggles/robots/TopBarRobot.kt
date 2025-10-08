package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag

class TopBarRobot(private val rule: ComposeTestRule) : BaseRobot(rule) {

    // Test tag constants
    private companion object {
        const val TOP_BAR_TAG = "topBar"
        const val HOME_TOP_BAR_TITLE_TAG = "homeTopBarTitle"
        const val HOME_TOP_BAR_SUBTITLE_TAG = "homeTopBarSubtitle"
        const val THEME_TOGGLE_ICON_TAG = "themeToggleIcon"
        const val DETAIL_SCREEN_CONTAINER_TAG = "detailScreenContainer"
        const val DETAILS_TOP_BAR_TITLE_TAG = "detailsTopBarTitle"
        const val TOP_BAR_BACK_ICON_TAG = "topBarBackIcon"
    }

    // Reusable node references
    private val topBar get() = rule.onNodeWithTag(TOP_BAR_TAG)
    private val homeTopBarTitle get() = rule.onNodeWithTag(HOME_TOP_BAR_TITLE_TAG)
    private val homeTopBarSubtitle get() = rule.onNodeWithTag(HOME_TOP_BAR_SUBTITLE_TAG)
    private val themeToggleIcon get() = rule.onNodeWithTag(THEME_TOGGLE_ICON_TAG)
    private val detailScreenContainer get() = rule.onNodeWithTag(DETAIL_SCREEN_CONTAINER_TAG)
    private val detailsTopBarTitle get() = rule.onNodeWithTag(DETAILS_TOP_BAR_TITLE_TAG)
    private val topBarBackIcon get() = rule.onNodeWithTag(TOP_BAR_BACK_ICON_TAG)

    // Home Screen Top Bar
    fun verifyHomeTopBarIsDisplayed(titleText: String, subtitleText: String): TopBarRobot {
        topBar.assertExistsAndIsDisplayed()
        homeTopBarTitle.assertExistsAndIsDisplayed().assertTextEquals(titleText)
        homeTopBarSubtitle.assertExistsAndIsDisplayed().assertTextEquals(subtitleText)
        themeToggleIcon.assertExistsAndIsDisplayed()
        return this
    }

    // Detail Screen Top Bar
    fun verifyDetailTopBarIsDisplayed(titleText: String): TopBarRobot {
        detailScreenContainer.assertExistsAndIsDisplayed()
        detailsTopBarTitle.assertExistsAndIsDisplayed().assertTextEquals(titleText)
        topBarBackIcon.assertExistsAndIsDisplayed()
        return this
    }
}
