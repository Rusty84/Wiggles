package dev.spikeysanju.wiggles.robots

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToIndex

@OptIn(ExperimentalTestApi::class)
class DetailRobot(private val rule: ComposeTestRule) : BaseRobot(rule) {

    // Test tag constants
    private companion object {
        const val DETAIL_SCREEN_CONTAINER_TAG = "detailScreenContainer"
        const val DOG_DETAILS_VIEW_TAG = "dogDetailsView"
        const val DOG_SHORT_INFO_CARD_TAG = "dogShortInfoCard"
        const val DOG_INFO_NAME_TAG = "dogInfoName"
        const val DOG_GENDER_TAG = "dogGenderTag"
        const val DOG_INFO_LOCATION_TAG = "dogInfoLocation"
        const val ADOPT_BUTTON_TAG = "adoptButton"
    }

    // Reusable node references
    private val detailScreenContainer get() = rule.onNodeWithTag(DETAIL_SCREEN_CONTAINER_TAG)
    private val dogDetailsView get() = rule.onNodeWithTag(DOG_DETAILS_VIEW_TAG)
    private val dogShortInfoCard get() = rule.onNodeWithTag(DOG_SHORT_INFO_CARD_TAG)

    // Added for future use and consistency across test tags
    private val dogInfoName get() = rule.onNodeWithTag(DOG_INFO_NAME_TAG)
    private val dogGender get() = rule.onNodeWithTag(DOG_GENDER_TAG)
    private val dogInfoLocation get() = rule.onNodeWithTag(DOG_INFO_LOCATION_TAG)
    private val adoptButton get() = rule.onNodeWithTag(ADOPT_BUTTON_TAG)

    init {
        detailScreenContainer
            .assertExists("Failed to navigate to Detail Screen")
        waitForIdle()
    }

    fun assertDetailScreen(): DetailRobot {
        dogDetailsView.assertExistsAndIsDisplayed()
        return this
    }

    fun assertDogName(name: String): DetailRobot {
        assertNodeWithTagAndText(DOG_INFO_NAME_TAG, name)
        return this
    }

    fun assertDogGender(gender: String): DetailRobot {
        assertNodeWithTagAndText(DOG_GENDER_TAG, gender)
        return this
    }

    fun assertDogLocation(location: String): DetailRobot {
        assertNodeWithTagAndText(DOG_INFO_LOCATION_TAG, location)
        return this
    }

    fun assertAdoptButton(text: String): DetailRobot {
        assertNodeWithTagAndText(ADOPT_BUTTON_TAG, text)
        return this
    }

    fun assertDogInfo(): DetailRobot {
        dogShortInfoCard.assertExistsAndIsDisplayed()
        return this
    }


    fun scrollDetails(index: Int): DetailRobot {
        dogDetailsView.performScrollToIndex(index)
        return this
    }

    // Helper function to reduce repetition
    private fun assertNodeWithTagAndText(tag: String, text: String) {
        rule.onNode(hasTestTag(tag) and hasText(text))
            .assertExistsAndIsDisplayed()
    }
}
