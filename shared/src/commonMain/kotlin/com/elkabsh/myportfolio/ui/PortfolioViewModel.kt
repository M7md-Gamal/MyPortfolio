package com.elkabsh.myportfolio.ui

import androidx.lifecycle.ViewModel
import com.elkabsh.myportfolio.model.PortfolioData
import com.elkabsh.myportfolio.model.getPortfolioData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class PortfolioUiState(
    val portfolioData: PortfolioData = getPortfolioData(),
    val currentSection: Int = 0,
    val sections: List<String> = listOf("Home", "About", "Skills", "Projects", "Contact")
)

class PortfolioViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PortfolioUiState())
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()

    fun onSectionSelected(index: Int) {
        if (index in 0 until _uiState.value.sections.size) {
            _uiState.update { it.copy(currentSection = index) }
        }
    }

    companion object {
        /**
         * Formats a phone number for direct WhatsApp links (wa.me API).
         * Strips non-digit characters and ensures country dialing code prefix (e.g. Egypt 20).
         */
        fun formatWhatsAppUrl(phoneNumber: String): String {
            val digitsOnly = phoneNumber.filter { it.isDigit() }
            val formatted = when {
                digitsOnly.startsWith("20") -> digitsOnly
                digitsOnly.startsWith("0") -> "20" + digitsOnly.drop(1)
                else -> "20$digitsOnly"
            }
            return "https://wa.me/$formatted"
        }
    }
}
