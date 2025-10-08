package dev.spikeysanju.wiggles.uitests

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.spikeysanju.wiggles.MainActivity
import dev.spikeysanju.wiggles.robots.robot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalAnimationApi::class)
@RunWith(AndroidJUnit4::class)
class DetailsTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testDogDetailsAndBackNavigation() {
        robot(composeTestRule) {
            home {
                assertPetListDisplayed()
                tapOnDog("Miss Agnes", 0)
            }
            detail {
                topBar {
                    verifyDetailTopBarIsDisplayed("Details")
                }
                assertDogName("Miss Agnes")
                assertDogGender("Female")
                assertDogLocation("879m away")
                scrollDetails(2)
                assertDogInfo()
                assertAdoptButton("Adopt me")
                pressBack()
            }
            home {
                assertPetListDisplayed()
            }
        }
    }
}
