# Design Brief: Portfolio Redesign

## Job and Audience

**Who arrives:** Recruiters, hiring managers, and potential clients evaluating Mohamed Gamal Abdelwahab for Android/KMP development roles.

**Their situation:** They arrive via LinkedIn, GitHub, or resume links. They have 30-60 seconds to form an impression. They're technically literate and skeptical of generic templates.

**What they need:** Quick assessment of technical competence, project quality, and professional credibility. They need to answer: "Is this developer worth talking to?"

**Visitor mode:** Experience (portfolio/showcase) - the artifact leads, the interface recedes.

## Outcome and Proof

**Primary task:** Understand Mohamed's capabilities and decide whether to contact him.

**Success metrics:**
- Visitor spends 30+ seconds exploring
- Visitor clicks through to GitHub repos
- Visitor initiates contact

**Real evidence:**
- CarePulse (freelance) - cross-platform patient monitoring
- Bookpedia - cross-platform book discovery
- Diabetes Diagnoses - graduation project with ML
- News App, Chatter, Memory Game - Android applications

**Product-specific truth:** KMP + Compose Multiplatform expertise demonstrated through actual shipped applications, not just claims.

## Selected Direction

**Visual authority:** The current GitHub-inspired dark theme evolves into a more expressive creative showcase.

**Structural thesis:** From linear scrolling to immersive project storytelling. Each project becomes a mini-portfolio within the portfolio.

**Interaction thesis:** Subtle motion and transitions that reward exploration without overwhelming. The interface should feel alive and responsive.

**Focal moment:** The hero section transforms from a static introduction to an animated, personality-driven opening that immediately communicates "this developer has design taste."

**Implementation consequence:** No external assets required. All visual effects achievable through Compose animations and color manipulation.

## Scope and Boundaries

**Fidelity:** Production-ready implementation. Not a mockup - real, buildable code.

**Breadth:** Complete overhaul of all sections. New information architecture. New visual language.

**Interactivity:** Exploration-level. Visitors should feel compelled to scroll and discover.

**Named target:** The complete portfolio website.

**What remains untouched:**
- All existing content (projects, skills, contact info)
- GitHub Pages deployment constraint
- Responsive behavior (mobile/desktop)
- Performance requirements (fast loading)

**Anti-goals:**
- Generic template aesthetics
- Heavy external dependencies
- Sacrificing content for style
- Slow load times

## States and Ranges

**Content ranges:**
- Projects: Currently 6, scalable to 10+
- Skills: 7 categories, 30+ individual skills
- Contact: 4 channels (email, phone, LinkedIn, GitHub)

**Material states:**
- Hero: Animated introduction
- Projects: Expandable cards with tech stack details
- Skills: Categorized visualization
- Contact: Clear call-to-action
- Mobile: Adapted layout with touch-friendly interactions
- Desktop: Rich hover states and transitions

## Interaction and Layout

**Hierarchy:** Hero → Projects (primary content) → Skills → About → Contact

**Responsiveness:**
- Mobile: Single column, stacked cards, touch-optimized
- Desktop: Multi-column grids, hover states, keyboard navigation

**Affordances:**
- Smooth scroll navigation
- Project cards that expand on hover
- Skill chips that animate on scroll
- Clear visual hierarchy through color and typography

**Feedback:**
- Subtle hover states on interactive elements
- Smooth transitions between sections
- Visual confirmation of navigation

**Transitions:**
- Section reveal animations on scroll
- Card hover effects
- Button state changes

## Constraints and Open Decisions

**Platform:** Web (Kotlin Multiplatform + Compose Multiplatform)

**Delivery:** GitHub Pages deployment

**Accessibility:** Keyboard navigation, sufficient color contrast, responsive design

**Localization:** English only (no i18n required)

**Reusable components:** Card, Chip, Button, Section Title, Navigation

**Choices a builder must not invent:**
- Content structure (already defined)
- Color system (already defined in DESIGN.md)
- Typography scale (already defined in DESIGN.md)
- Responsive breakpoints (already defined)

**Open decisions:**
- Animation timing and easing curves
- Specific hover state treatments
- Scroll reveal implementation details
- Mobile navigation pattern (hamburger vs. stacked)
