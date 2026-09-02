# Color Palette Change Plan

## Current State
- **Primary:** `#7C3AED` (vibrant violet) — reads as "AI-generated"
- **Background:** `#0F0F1A` (warm charcoal)
- **Surface:** `#1A1A2E`

## Proposed Direction: Warm Neutral + Gold Accent

### New Palette

| Role | Current | New | Why |
|------|---------|-----|-----|
| **Primary** | `#7C3AED` (violet) | `#D4A574` (warm gold/bronze) | Premium, sophisticated, distinctive |
| **Primary Dark** | `#6D28D9` | `#B8956A` | Deeper gold for hover states |
| **Secondary** | `#F59E0B` (amber) | `#E8DCC8` (warm cream) | Neutral support, not competing |
| **Background** | `#0F0F1A` | `#1A1614` (warm charcoal) | Slightly warmer, more inviting |
| **Surface** | `#1A1A2E` | `#252017` (warm brown-black) | Cohesive warm foundation |
| **Surface Variant** | `#252540` | `#302A1F` | Warm surface hierarchy |

### Color Roles

| Token | Hex | Usage |
|-------|-----|-------|
| `Gold` | `#D4A574` | Primary accent, CTAs, links, active states |
| `GoldDark` | `#B8956A` | Hover states, pressed |
| `Cream` | `#E8DCC8` | Secondary accents, subtle highlights |
| `WarmBackground` | `#1A1614` | Page background |
| `WarmSurface` | `#252017` | Cards, elevated surfaces |
| `WarmSurfaceVariant` | `#302A1F` | Secondary surfaces, chips |
| `TextPrimary` | `#F5F0EB` | Main text (warm white) |
| `TextSecondary` | `#A89B8C` | Descriptions (warm gray) |
| `TextMuted` | `#6B5E52` | Metadata, muted text |
| `Border` | `#3D3428` | Dividers, borders |

### Why This Works

1. **Distinctive:** Gold/bronze is rare in developer portfolios
2. **Premium:** Warm metallics feel high-end, not trendy
3. **Cohesive:** Warm neutrals create unified foundation
4. **Memorable:** Stands out from blue/purple/green defaults
5. **Professional:** Conveys craftsmanship, not AI generation

### Implementation Steps

1. Update `Color.kt` with new warm palette
2. Update `Theme.kt` Material 3 color scheme
3. Update `Type.kt` if needed for warmth
4. Verify all sections render correctly

### Risk

Gold can feel "luxury" — mitigate by keeping it restrained (10-15% of surface area) and using warm neutrals as the dominant palette.
