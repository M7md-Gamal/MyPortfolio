package com.elkabsh.myportfolio.model

data class PortfolioData(
    val name: String,
    val title: String,
    val tagline: String,
    val location: String,
    val email: String,
    val phone: String,
    val linkedInUrl: String,
    val githubUrl: String,
    val bio: String,
    val education: Education,
    val skillCategories: List<SkillCategory>,
    val projects: List<Project>,
    val languages: List<Language>
)

data class Education(
    val degree: String,
    val university: String,
    val dateRange: String,
    val grade: String
)

data class SkillCategory(
    val name: String,
    val skills: List<Skill>,
    val color: SkillColor
)

data class Skill(
    val name: String
)

enum class SkillColor {
    BLUE, GREEN, ORANGE, PURPLE, YELLOW
}

data class Project(
    val name: String,
    val description: String,
    val techStack: List<String>,
    val githubUrl: String? = null,
    val isFreelance: Boolean = false,
    val isGraduation: Boolean = false,
    val metric: String? = null,
    val architectureHighlights: List<String> = emptyList()
)

data class Language(
    val name: String,
    val proficiency: String
)

fun getPortfolioData() = PortfolioData(
    name = "Mohamed Gamal AbdelWahab",
    title = "Android | KMP Developer",
    tagline = "Building scalable, high-performance mobile applications with modern Android technologies",
    location = "Cairo, Egypt",
    email = "mohamedgamal20k@gmail.com",
    phone = "01019292126",
    linkedInUrl = "https://www.linkedin.com/in/m7md-gamal/",
    githubUrl = "https://github.com/M7md-Gamal",
    bio = "Mobile Developer specializing in building scalable, high-performance mobile applications using modern Android technologies. Proficient in Kotlin, Jetpack Compose, and XML-based UI development with a strong foundation in clean architecture principles. Experienced in Kotlin Multiplatform for cross-platform development. Proven track record of delivering robust applications with seamless user experiences, offline capabilities, and real-time data synchronization.",
    education = Education(
        degree = "Bachelor of Computer Science",
        university = "Sohag University",
        dateRange = "September 2019 - July 2023",
        grade = "Excellent With Honor"
    ),
    skillCategories = listOf(
        SkillCategory(
            name = "Languages & Frameworks",
            skills = listOf(
                Skill("Android SDK"),
                Skill("Kotlin"),
                Skill("KMP"),
                Skill("Jetpack Compose"),
                Skill("XML"),
                Skill("Material Design 3")
            ),
            color = SkillColor.BLUE
        ),
        SkillCategory(
            name = "Architecture",
            skills = listOf(
                Skill("MVVM"),
                Skill("MVI"),
                Skill("Clean Architecture"),
                Skill("SOLID Principles"),
                Skill("Design Patterns"),
                Skill("OOP")
            ),
            color = SkillColor.GREEN
        ),
        SkillCategory(
            name = "Data & Storage",
            skills = listOf(
                Skill("Room DB"),
                Skill("DataStore"),
                Skill("Shared Preferences")
            ),
            color = SkillColor.ORANGE
        ),
        SkillCategory(
            name = "Networking",
            skills = listOf(
                Skill("Retrofit"),
                Skill("Ktor Client")
            ),
            color = SkillColor.PURPLE
        ),
        SkillCategory(
            name = "Async & Reactive",
            skills = listOf(
                Skill("Kotlin Coroutines"),
                Skill("Kotlin Flow"),
                Skill("RxJava")
            ),
            color = SkillColor.YELLOW
        ),
        SkillCategory(
            name = "Dependency Injection",
            skills = listOf(
                Skill("Dagger Hilt"),
                Skill("Koin")
            ),
            color = SkillColor.BLUE
        ),
        SkillCategory(
            name = "Libraries & Tools",
            skills = listOf(
                Skill("Glide"),
                Skill("Coil"),
                Skill("Lottie Animation"),
                Skill("Firebase"),
                Skill("TensorFlow Lite"),
                Skill("Git"),
                Skill("GitHub")
            ),
            color = SkillColor.GREEN
        )
    ),
    projects = listOf(
        Project(
            name = "CarePulse",
            description = "Cross-platform (Android & iOS) patient monitoring application used in hospitals to track real-time patient stats, vital signs, and clinical indicators. Integrated an automated MEWS/NEWS early warning scoring engine that instantly alerts medical staff upon detecting signs of clinical deterioration.",
            techStack = listOf("KMP", "Compose MP", "Ktor", "Koin", "Vico Charts", "Lottie"),
            isFreelance = true,
            metric = "Hospital Telemetry & Alerting",
            architectureHighlights = listOf(
                "Implemented automated MEWS/NEWS clinical scoring engine for real-time deterioration detection",
                "Engineered offline-first local cache synchronization for uninterrupted hospital operation",
                "Integrated reactive Vico multiplatform charting with low-latency telemetry updates"
            )
        ),
        Project(
            name = "News App",
            description = "Comprehensive news app with real-time updates, offline reading, and smooth pagination. Architected using Jetpack Compose with MVI and Clean Architecture.",
            techStack = listOf("Jetpack Compose", "MVI", "Room", "Retrofit", "Hilt", "Material Design 3"),
            githubUrl = "https://github.com/M7md-Gamal/News-App",
            metric = "Clean Architecture & MVI",
            architectureHighlights = listOf(
                "Unidirectional MVI architecture with strict separation of Intent, State, and Single-shot Effects",
                "Multi-tiered offline caching using Room DB, Flow observers, and remote boundary callbacks",
                "Smooth infinite pagination using Jetpack Compose lazy layout state orchestration"
            )
        ),
        Project(
            name = "Bookpedia",
            description = "Cross-platform book discovery application targeting Android and iOS. Features book search, detailed information, and favorites with a unified codebase while maintaining platform-specific UI optimizations.",
            techStack = listOf("KMP", "Compose MP", "Ktor Client", "Koin"),
            githubUrl = "https://github.com/M7md-Gamal/Bookpedia",
            metric = "100% Shared KMP Core",
            architectureHighlights = listOf(
                "Shared 100% of data, networking (Ktor), and dependency injection (Koin) across platforms",
                "Unified Compose Multiplatform design system adapted gracefully for iOS and Android ergonomics",
                "Optimized in-memory LRU and disk caching for book metadata and cover image loading"
            )
        ),
        Project(
            name = "Diabetes Diagnoses",
            description = "Healthcare app using ML to predict diabetes risk, assisting doctors with quick and easy diagnosis. Features offline ML inference, secure user management, and modular architecture.",
            techStack = listOf("Jetpack Compose", "TensorFlow Lite", "Room", "Firebase", "Hilt"),
            githubUrl = "https://github.com/M7md-Gamal/Diabetes",
            isGraduation = true,
            metric = "On-Device ML Inference",
            architectureHighlights = listOf(
                "Embedded quantized TensorFlow Lite model performing sub-100ms offline medical inference",
                "Engineered secure encrypted storage for patient diagnostic records and medical history",
                "Built modular architecture separating the neural inference engine from UI layers"
            )
        ),
        Project(
            name = "Chatter",
            description = "Feature-rich messaging app with enterprise-level architecture. Real-time messaging, secure user authentication, and scalable data management.",
            techStack = listOf("Jetpack Compose", "Firebase", "MVVM", "Realtime Database"),
            githubUrl = "https://github.com/M7md-Gamal/Chatter",
            metric = "Real-Time Synchronization",
            architectureHighlights = listOf(
                "Bi-directional WebSocket connection management with automatic reconnection and packet queuing",
                "Optimistic UI state updates for instantaneous messaging experience during network latency",
                "Scalable security rules and role-based access control with Firebase Auth"
            )
        ),
        Project(
            name = "Memory Game & GameMeter",
            description = "Interactive games built with modern Android technologies.",
            techStack = listOf("Android SDK", "Kotlin", "Jetpack Compose"),
            githubUrl = "https://github.com/M7md-Gamal",
            metric = "State & Game Loop",
            architectureHighlights = listOf(
                "Declarative state-driven game loop with smooth physics and score tracking",
                "Custom Compose canvas animations and tactile haptic feedback integrations"
            )
        )
    ),
    languages = listOf(
        Language("Arabic", "Native"),
        Language("English", "Proficient")
    )
)
