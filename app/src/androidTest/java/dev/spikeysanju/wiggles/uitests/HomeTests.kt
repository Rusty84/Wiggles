/*
 * All tests added use Compose UI testing framework with a robot pattern
 * for maintainable and readable test code.
 *
 * Device Compatibility:
 * Tests run successfully on:
 * - Pixel 7 API 34
 * - Pixel 6 PRO API 33
 * - Nexus S API 33
 */
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
            // Verify home screen displays correctly and navigate to details
            home {
                topBar {
                    verifyHomeTopBarIsDisplayed("Hey Spikey,", "Adopt a new friend near you!")
                }
                assertPetListDisplayed()
                assertDogCardsPresentInList()
                tapOnDog("Skooby Doo", 0)
            }
            // Confirm detail screen loads and navigation back works
            detail {
                assertDetailScreen()
                pressBack()
            }
        }
    }

    @Test
    fun testDirectNavigationToDetailScreenFails() {
        try {
            // Attempt invalid robot usage
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
