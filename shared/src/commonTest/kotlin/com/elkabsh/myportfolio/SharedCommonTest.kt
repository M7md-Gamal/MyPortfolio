package com.elkabsh.myportfolio

import com.elkabsh.myportfolio.model.getPortfolioData
import com.elkabsh.myportfolio.ui.PortfolioViewModel
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SharedCommonTest {

    @Test
    fun testPortfolioDataIntegrity() {
        val data = getPortfolioData()

        assertTrue(data.name.isNotBlank(), "Name should not be blank")
        assertTrue(data.title.isNotBlank(), "Title should not be blank")
        assertTrue(data.email.contains("@"), "Email should be valid")
        assertTrue(data.phone.isNotBlank(), "Phone should not be blank")
        assertTrue(data.linkedInUrl.startsWith("https://"), "LinkedIn URL should use HTTPS")
        assertTrue(data.githubUrl.startsWith("https://"), "GitHub URL should use HTTPS")

        assertFalse(data.skillCategories.isEmpty(), "Skill categories should not be empty")
        data.skillCategories.forEach { category ->
            assertTrue(category.name.isNotBlank(), "Category name should not be blank")
            assertFalse(category.skills.isEmpty(), "Category '${category.name}' should have skills")
        }

        assertFalse(data.projects.isEmpty(), "Projects should not be empty")
        data.projects.forEach { project ->
            assertTrue(project.name.isNotBlank(), "Project name should not be blank")
            assertFalse(project.techStack.isEmpty(), "Project '${project.name}' should list tech stack")
        }
    }

    @Test
    fun testWhatsAppUrlFormatting() {
        // Standard Egyptian local mobile number
        assertEquals(
            "https://wa.me/201019292126",
            PortfolioViewModel.formatWhatsAppUrl("01019292126")
        )

        // Number already containing country code
        assertEquals(
            "https://wa.me/201019292126",
            PortfolioViewModel.formatWhatsAppUrl("201019292126")
        )

        // Number with dashes, spaces, and plus signs
        assertEquals(
            "https://wa.me/201019292126",
            PortfolioViewModel.formatWhatsAppUrl("+20 101-929-2126")
        )
    }

    @Test
    fun testPortfolioViewModelStateTransitions() {
        val viewModel = PortfolioViewModel()
        assertEquals(0, viewModel.uiState.value.currentSection)
        assertEquals(5, viewModel.uiState.value.sections.size)

        // Valid section change
        viewModel.onSectionSelected(2)
        assertEquals(2, viewModel.uiState.value.currentSection)

        // Out of bounds selection should be rejected
        viewModel.onSectionSelected(-1)
        assertEquals(2, viewModel.uiState.value.currentSection)

        viewModel.onSectionSelected(99)
        assertEquals(2, viewModel.uiState.value.currentSection)
    }
}