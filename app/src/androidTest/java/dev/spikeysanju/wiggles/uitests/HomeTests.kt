package dev.spikeysanju.wiggles.uitests

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.spikeysanju.wiggles.MainActivity
import dev.spikeysanju.wiggles.robots.robot
import junit.framework.TestCase.assertTrue
import junit.framework.TestCase.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalAnimationApi::class)
@RunWith(AndroidJUnit4::class)
class HomeTests {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testHomeScreenAndNavigation() {
        robot(composeTestRule) {
            home {
                topBar {
                    verifyHomeTopBarIsDisplayed("Hey Spikey,", "Adopt a new friend near you!")
                }
                assertPetListDisplayed()
                assertDogCardsPresentInList()
                tapOnDog("Skooby Doo", 0)
            }
            detail {
                assertDetailScreen()
                pressBack()
            }
        }
    }

    @Test
    fun testDirectNavigationToDetailScreenFails() {
        try {
            // Attempt to navigate directly to detail screen
            robot(composeTestRule) {
                home {
                    detailRobot {
                        assertDetailScreen()
                    }
                }
            }

            // If we reach here, navigation unexpectedly succeeded
            fail("Test should have failed with navigation error")
        } catch (e: AssertionError) {
            // Verify error message contains expected text
            assertTrue(
                "Error should mention missing detailScreenContainer: ${e.message}",
                e.message?.contains("detailScreenContainer") == true
            )
        }
    }
}
