package com.elkabsh.myportfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.elkabsh.myportfolio.model.getPortfolioData
import com.elkabsh.myportfolio.ui.components.FadeInOnScrollSection
import com.elkabsh.myportfolio.ui.components.FooterSection
import com.elkabsh.myportfolio.ui.components.TopBar
import com.elkabsh.myportfolio.ui.sections.*
import com.elkabsh.myportfolio.ui.theme.*

@Composable
fun App() {
    PortfolioTheme {
        val portfolioData = remember { getPortfolioData() }
        val sections = listOf("Home", "About", "Skills", "Projects", "Contact")
        var currentSection by remember { mutableStateOf(0) }
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()

        // Track section offsets for smooth scroll navigation
        val sectionOffsets = remember { mutableStateMapOf<Int, Float>() }

        // Viewport height for fade-in calculations
        var viewportHeight by remember { mutableIntStateOf(0) }

        // Navigation: scroll to section offset
        fun navigateToSection(index: Int) {
            currentSection = index
            val offset = sectionOffsets[index]?.toInt() ?: 0
            coroutineScope.launch {
                scrollState.animateScrollTo(offset)
            }
        }

        // Track current section based on scroll position
        LaunchedEffect(scrollState.value) {
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
            if (closest != currentSection) {
                currentSection = closest
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
                    // Top navigation bar
                    TopBar(
                        sections = sections,
                        currentSection = currentSection,
                        onSectionClick = { index -> navigateToSection(index) },
                        isMobile = isMobile
                    )

                    // Main content - scrollable
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                    ) {
                        // Hero Section
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
                                        sectionOffsets[0] = coords.positionInRoot().y
                                    }
                            )
                        }

                        // About Section
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[1]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            AboutSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[1] = coords.positionInRoot().y
                                }
                            )
                        }

                        // Skills Section
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[2]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            SkillsSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[2] = coords.positionInRoot().y
                                }
                            )
                        }

                        // Projects Section
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[3]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            ProjectsSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[3] = coords.positionInRoot().y
                                }
                            )
                        }

                        // Contact Section
                        FadeInOnScrollSection(
                            scrollState = scrollState,
                            sectionOffset = sectionOffsets[4]?.toInt() ?: 0,
                            viewportHeight = viewportHeight
                        ) {
                            ContactSection(
                                data = portfolioData,
                                isMobile = isMobile,
                                modifier = Modifier.onGloballyPositioned { coords ->
                                    sectionOffsets[4] = coords.positionInRoot().y
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
