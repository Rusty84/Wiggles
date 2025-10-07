package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performScrollToIndex
import kotlin.collections.get

class HomeRobot(private val rule: ComposeTestRule) : BaseRobot(rule) {
    fun tapOnDog(text: String, index: Int): HomeRobot {
        rule
            .onAllNodesWithText(text)[index]
            .assertExists()
            .assertIsDisplayed()
            .performClick()
        return this
    }

    @OptIn(ExperimentalTestApi::class)
    fun scroll(index: Int): HomeRobot {
        rule
            .onNodeWithTag("dogsList")
            .performScrollToIndex(index)
        waitForIdle()
        return this
    }

    fun assertPetListDisplayed(): HomeRobot {
        rule
            .onNodeWithTag("dogsList")
            .assertExists()
            .assertIsDisplayed()
        return this
    }

    fun assertDogCardsPresentInList(minCount: Int = 1): HomeRobot {
        val matcher = hasParent(hasTestTag("dogsList")) and hasTestTag("dogCard")
        val nodes = rule.onAllNodes(matcher, useUnmergedTree = true)
        val count = nodes.fetchSemanticsNodes().size
        require(count >= minCount) {
            "Expected at least $minCount dogCard inside dogsList, found $count."
        }
        return this
    }
}
