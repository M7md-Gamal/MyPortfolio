---
name: MyPortfolio
description: Kotlin Multiplatform developer portfolio showcasing technical expertise and project delivery
colors:
  background: "#0D1117"
  surface: "#161B22"
  surface-variant: "#1C2333"
  primary: "#58A6FF"
  primary-deep: "#388BFD"
  secondary: "#3FB950"
  tertiary: "#F78166"
  quaternary: "#BC8CFF"
  quinary: "#E3B341"
  text-primary: "#E6EDF3"
  text-secondary: "#8B949E"
  text-muted: "#6E7681"
  border: "#30363D"
typography:
  display:
    fontFamily: "system-ui, -apple-system, sans-serif"
    fontSize: "48px"
    fontWeight: 700
    lineHeight: "56px"
    letterSpacing: "-0.5px"
  headline:
    fontFamily: "system-ui, -apple-system, sans-serif"
    fontSize: "32px"
    fontWeight: 700
    lineHeight: "40px"
  title:
    fontFamily: "system-ui, -apple-system, sans-serif"
    fontSize: "20px"
    fontWeight: 600
    lineHeight: "28px"
  body:
    fontFamily: "system-ui, -apple-system, sans-serif"
    fontSize: "16px"
    fontWeight: 400
    lineHeight: "24px"
  label:
    fontFamily: "system-ui, -apple-system, sans-serif"
    fontSize: "14px"
    fontWeight: 500
    lineHeight: "20px"
    letterSpacing: "0.1px"
rounded:
  sm: "6px"
  md: "8px"
  lg: "12dp"
spacing:
  sm: "8px"
  md: "16px"
  lg: "24px"
  xl: "32px"
  xxl: "64px"
components:
  button-primary:
    backgroundColor: "{colors.primary}"
    textColor: "{colors.background}"
    rounded: "{rounded.md}"
    padding: "12px 24px"
  button-secondary:
    backgroundColor: "{colors.surface-variant}"
    textColor: "{colors.text-primary}"
    rounded: "{rounded.md}"
    padding: "12px 24px"
  card:
    backgroundColor: "{colors.surface}"
    rounded: "{rounded.lg}"
    padding: "24px"
  chip:
    backgroundColor: "{colors.surface-variant}"
    textColor: "{colors.text-secondary}"
    rounded: "{rounded.sm}"
    padding: "4px 12px"
  badge:
    backgroundColor: "rgba({color}, 0.2)"
    textColor: "{color}"
    rounded: "{rounded.sm}"
    padding: "4px 10px"
---

# Design System: MyPortfolio

## Overview

**Creative North Star: "The Developer's Workbench"**

A portfolio that feels like a well-organized development environment: clean, functional, and purposeful. The design communicates technical competence through precision rather than decoration. Every element earns its place through utility, not aesthetics.

The visual language borrows from the tools developers already trust—code editors, terminal interfaces, documentation sites—creating instant recognition and professional credibility. The dark theme isn't just a style choice; it's a deliberate alignment with the environments where the work happens.

**Key Characteristics:**
- Functional hierarchy over decorative flourish
- GitHub-inspired color system for instant developer recognition
- Responsive layout that maintains information density at every viewport
- Subtle visual hierarchy through color temperature, not shadow depth

## Colors

The palette is derived from GitHub's dark theme, creating immediate familiarity for the technical audience.

### Primary
- **Developer Blue** (#58A6FF): Primary actions, links, and interactive elements. Used sparingly for maximum impact—CTAs, navigation highlights, and accent typography.

### Secondary
- **Terminal Green** (#3FB950): Success states, positive indicators, and the "Graduation Project" badge. Represents completion and achievement.

### Tertiary
- **Warning Orange** (#F78166): Attention-grabbing elements, freelance project badges, and secondary accent. Used where emphasis is needed without the primary blue.

### Neutral
- **Deep Background** (#0D1117): Primary background, the canvas where content lives
- **Surface** (#161B22): Elevated surfaces, cards, and containers
- **Surface Variant** (#1C2333): Secondary surfaces, input backgrounds, subtle differentiation
- **Border** (#30363D): Dividers, card borders, structural separation

### Named Rules
**The 60-30-10 Rule.** Background colors (60%) dominate, surface colors (30%) create structure, accent colors (10%) draw attention. Never let accents compete for dominance.

## Typography

**Display Font:** system-ui, -apple-system, sans-serif
**Body Font:** system-ui, -apple-system, sans-serif

**Character:** Technical precision meets approachability. The system font stack ensures consistency across platforms while maintaining readability at all sizes.

### Hierarchy
- **Display** (700, 48px, 56px): Hero section name, primary headline
- **Headline** (700, 32px, 40px): Section titles, major headings
- **Title** (600, 20px, 28px): Card headings, subsection titles
- **Body** (400, 16px, 24px): Primary content, descriptions
- **Label** (500, 14px, 20px): Buttons, badges, interactive elements

### Named Rules
**The Weight Hierarchy Rule.** Font weight communicates importance: Bold (700) for primary headlines, SemiBold (600) for secondary headings, Medium (500) for labels and actions, Regular (400) for body text.

## Layout

Single-column layout with responsive behavior. Content centers on desktop (max-width implied by padding), full-width on mobile.

**Spacing System:** 8px base unit, scaled as 8/16/24/32/64px
**Horizontal Padding:** 24px mobile, 64px desktop
**Vertical Section Padding:** 64px
**Content Density:** High—respects the 30-60 second visitor attention window

### Responsive Behavior
- Mobile: Single column, 24px horizontal padding, adapted typography sizes
- Desktop: Two-column grids for projects and skills, 64px horizontal padding

## Elevation & Depth

**Flat design system.** No shadows, no gradients, no faux-depth. Hierarchy is communicated through:
- Color temperature (background → surface → surface-variant)
- Typography weight and size
- Strategic use of accent colors

Depth is implied through layering: background holds content, surfaces elevate cards and sections, accents draw focus.

## Shapes

**Corner radius strategy:** Progressive rounding based on component size and purpose.

- **2px**: Minimal accent elements (section title underline)
- **6px**: Small interactive elements (badges, chips, skill tags)
- **8px**: Medium interactive elements (buttons)
- **12px**: Large content containers (cards, skill category panels)

**Form Language:** Soft and approachable. Rounded corners reduce visual tension and create a friendly, accessible feel without sacrificing professionalism.

## Components

### Buttons
- **Shape:** 8dp radius
- **Primary:** Blue background (#58A6FF), dark text (#0D1117), 12dp vertical / 24dp horizontal padding
- **Secondary:** Dark surface variant background (#1C2333), light text (#E6EDF3), same padding
- **States:** No visible hover/focus states in current implementation

### Chips / Tags
- **Shape:** 6dp radius
- **Tech Stack Chips:** Surface variant background (#1C2333), muted text (#8B949E)
- **Skill Chips:** Colored background at 15% opacity, full color text
- **Padding:** 4dp vertical, 10-12dp horizontal

### Cards
- **Shape:** 12dp radius
- **Background:** Surface color (#161B22)
- **Padding:** 24dp all sides
- **Content Spacing:** 12dp between elements
- **Border:** None visible

### Badges
- **Shape:** 6dp radius
- **Style:** Colored background at 20% opacity, full color text
- **Padding:** 4dp vertical, 10dp horizontal
- **Typography:** Body small (12px)

### Navigation
- **Style:** Horizontal scroll on mobile, centered on desktop
- **Typography:** Label large (14px, medium weight)
- **States:** No visible active/hover states

### Section Title
- **Style:** Headline large (32px, bold), white text
- **Accent:** 60px wide, 4dp tall blue bar underneath
- **Spacing:** 8dp between title and bar

## Do's and Don'ts

### Do:
- **Do** maintain the 60-30-10 color ratio across any new sections
- **Do** use system font stack for consistency
- **Do** respect the 8px spacing grid
- **Do** keep information density high—this is a portfolio, not a brochure
- **Do** use color temperature (not shadows) for visual hierarchy

### Don't:
- **Don't** add shadows, gradients, or faux-depth effects
- **Don't** introduce new fonts or font weights
- **Don't** use accent colors for large background areas
- **Don't** reduce information density for aesthetic reasons
- **Don't** add decorative elements that don't serve a functional purpose
