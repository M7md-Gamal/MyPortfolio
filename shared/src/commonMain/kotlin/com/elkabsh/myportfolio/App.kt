package com.elkabsh.myportfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import com.elkabsh.myportfolio.ui.PortfolioViewModel
import com.elkabsh.myportfolio.ui.components.FadeInOnScrollSection
import com.elkabsh.myportfolio.ui.components.FooterSection
import com.elkabsh.myportfolio.ui.components.TopBar
import com.elkabsh.myportfolio.ui.sections.AboutSection
import com.elkabsh.myportfolio.ui.sections.ContactSection
import com.elkabsh.myportfolio.ui.sections.HeroSection
import com.elkabsh.myportfolio.ui.sections.ProjectsSection
import com.elkabsh.myportfolio.ui.sections.SkillsSection
import com.elkabsh.myportfolio.ui.theme.DarkBackground
import com.elkabsh.myportfolio.ui.theme.PortfolioTheme
import kotlinx.coroutines.launch

@Composable
fun App(
    viewModel: PortfolioViewModel = remember { PortfolioViewModel() }
) {
    PortfolioTheme {
        val uiState by viewModel.uiState.collectAsState()
        val portfolioData = uiState.portfolioData
        val sections = uiState.sections

        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()

        // Track absolute section offsets within scrollable container
        val sectionOffsets = remember { mutableStateMapOf<Int, Float>() }

        // Viewport height for fade-in trigger calculations
        var viewportHeight by remember { mutableIntStateOf(0) }

        // Efficiently derive the active section index without re-running on every scroll pixel
        val currentSection by remember {
            derivedStateOf {
                val currentScroll = scrollState.value
                var closest = 0
                var minDistance = Int.MAX_VALUE
                for ((index, offset) in sectionOffsets) {
                    val distance = kotlin.math.abs(currentScroll - offset.toInt())
                    if (distance < minDistance) {
                        minDistance = distance
                        closest = index
                    }
                }
                closest
            }
        }

        // Navigation helper: smoothly scrolls to the target section's absolute offset
        fun navigateToSection(index: Int) {
            viewModel.onSectionSelected(index)
            val offset = sectionOffsets[index]?.toInt() ?: 0
            coroutineScope.launch {
                scrollState.animateScrollTo(offset)
            }
        }

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBackground)
        ) {
            val isMobile = maxWidth < 768.dp

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .onGloballyPositioned { coordinates ->
                        viewportHeight = coordinates.size.height
                    }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Sticky top navigation bar
                    TopBar(
                        sections = sections,
                        currentSection = currentSection,
                        onSectionClick = { index -> navigateToSection(index) },
                        isMobile = isMobile
                    )

                    // Main content - scrollable container
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ) {
                        // Hero Section (Index 0)
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = 0,
                            viewportHeight = viewportHeight
                        ) {
                            HeroSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                onNavigateTo = { index -> navigateToSection(index) },
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[0] = coords.positionInRoot().y + scrollState.value
                                }
                            )
                        }

                        // About Section (Index 1)
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[1]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            AboutSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[1] = coords.positionInRoot().y + scrollState.value
                                }
                            )
                        }

                        // Skills Section (Index 2)
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[2]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            SkillsSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[2] = coords.positionInRoot().y + scrollState.value
                                }
                            )
                        }

                        // Projects Section (Index 3)
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[3]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            ProjectsSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[3] = coords.positionInRoot().y + scrollState.value
                                }
                            )
                        }

                        // Contact Section (Index 4)
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[4]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            ContactSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[4] = coords.positionInRoot().y + scrollState.value
                                }
                            )
                        }

                        // Footer
                        FooterSection()
                    }
                }
            }
        }
    }
}
