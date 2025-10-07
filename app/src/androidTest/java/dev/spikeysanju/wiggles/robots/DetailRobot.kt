package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToIndex

class DetailRobot(private val rule: ComposeTestRule) : BaseRobot(rule) {

    init {
        rule.onNodeWithTag("detailScreenContainer")
            .assertExists("Failed to navigate to Detail Screen")
        waitForIdle()
    }

    fun assertDetailScreen(): DetailRobot {
        rule.onNodeWithTag("dogDetailsView")
            .assertExists()
            .assertIsDisplayed()
        return this
    }

    fun assertDogName(name: String): DetailRobot {
        rule.onNode(hasTestTag("dogInfoName") and hasText(name))
            .assertExists()
            .assertIsDisplayed()
        return this
    }

    fun assertDogGender(gender: String): DetailRobot {
        rule.onNode(hasTestTag("dogGenderTag") and hasText(gender))
            .assertExists()
            .assertIsDisplayed()
        return this
    }

    fun assertDogLocation(location: String): DetailRobot {
        rule.onNode(hasTestTag("dogInfoLocation") and hasText(location))
            .assertExists()
            .assertIsDisplayed()
        return this
    }


    fun assertAdoptButton(text: String): DetailRobot {
        rule.onNode(hasTestTag("adoptButton") and hasText(text))
            .assertExists()
            .assertIsDisplayed()
        return this
    }

    fun assertDogInfo(): DetailRobot {
        rule.onNodeWithTag("dogShortInfoCard")
            .assertExists()
            .assertIsDisplayed()
        return this
    }

    @OptIn(ExperimentalTestApi::class)
    fun scrollDetails(index: Int): DetailRobot {
        rule.onNodeWithTag("dogDetailsView")
            .performScrollToIndex(index)
        return this
    }

}
