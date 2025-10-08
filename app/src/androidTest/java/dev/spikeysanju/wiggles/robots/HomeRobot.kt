package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick

class HomeRobot(private val rule: ComposeTestRule) : BaseRobot(rule) {

    // Test tag constants
    private companion object {
        const val DOGS_LIST_TAG = "dogsList"
        const val DOG_CARD_TAG = "dogCard"
    }

    // Reusable node references
    private val dogsList get() = rule.onNodeWithTag(DOGS_LIST_TAG)

    // Added for future use and consistency across test tags
    private val dogCard get() = rule.onNodeWithTag(DOG_CARD_TAG)
    private val dogCardMatcher
        get() = hasParent(hasTestTag(DOGS_LIST_TAG)) and hasTestTag(
            DOG_CARD_TAG
        )

    fun tapOnDog(text: String, index: Int): HomeRobot {
        rule.onAllNodesWithText(text)[index]
            .assertExistsAndIsDisplayed()
            .performClick()
        return this
    }

    fun assertPetListDisplayed(): HomeRobot {
        dogsList.assertExistsAndIsDisplayed()
        return this
    }

    fun assertDogCardsPresentInList(minCount: Int = 1): HomeRobot {
        val nodes = rule.onAllNodes(dogCardMatcher, useUnmergedTree = true)
        val count = nodes.fetchSemanticsNodes().size
        require(count >= minCount) {
            "Expected at least $minCount $DOG_CARD_TAG inside $DOGS_LIST_TAG, found $count."
        }
        return this
    }

    fun detailRobot(block: DetailRobot.() -> Unit): HomeRobot {
        DetailRobot(rule).apply(block)
        return this
    }
}
