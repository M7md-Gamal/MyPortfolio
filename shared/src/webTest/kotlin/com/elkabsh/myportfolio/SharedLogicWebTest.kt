package com.elkabsh.myportfolio

import com.elkabsh.myportfolio.model.getPortfolioData
import kotlin.test.Test
import kotlin.test.assertTrue

class SharedLogicWebTest {

    @Test
    fun testPortfolioWebLinks() {
        val data = getPortfolioData()

        assertTrue(data.linkedInUrl.contains("linkedin.com"), "LinkedIn URL should point to linkedin.com")
        assertTrue(data.githubUrl.contains("github.com"), "GitHub URL should point to github.com")

        data.projects.filter { it.githubUrl != null }.forEach { project ->
            assertTrue(
                project.githubUrl!!.startsWith("https://github.com/"),
                "Project '${project.name}' GitHub link must start with https://github.com/"
            )
        }
    }
}