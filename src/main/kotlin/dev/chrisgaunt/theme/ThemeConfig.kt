package dev.chrisgaunt.theme

import web.cssom.*
import csstype.*
import react.useState
import kotlin.properties.Delegates

/**
 * Enum class representing available themes
 */
enum class ThemeType {
    DARK, LIGHT, BLUE, GREEN
}

/**
 * Centralized theme configuration for the application.
 * This allows for easy theming of the entire site.
 */
object ThemeConfig {
    // Helper class for RGBA values
    private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)

    // Current theme type
    private var currentThemeType = ThemeType.DARK

    // Callback for theme changes
    private var onThemeChangeCallback: (() -> Unit)? = null

    // Theme definitions
    private val themes = mapOf(
        ThemeType.DARK to Theme(
            // Main colors
            backgroundColorRGB = Triple(18, 18, 18),
            textColorRGB = Triple(224, 224, 224),

            // Navigation colors
            navBackgroundColorRGB = Triple(30, 30, 35),
            navBorderColorRGB = Triple(50, 50, 60),
            navLinkActiveColorRGB = Triple(220, 230, 255),
            navLinkInactiveColorRGB = Triple(180, 200, 255),
            navLinkHoverColorRGB = Triple(220, 230, 255),

            // Header colors
            headerBackgroundColorRGB = Triple(25, 25, 30),
            headerBorderColorRGB = Triple(75, 100, 160),
            headerShadowColorRGBA = Quadruple(0, 0, 0, 0.4),
            headerTitleColorRGB = Triple(255, 255, 255),
            headerSubtitleColorRGB = Triple(120, 150, 220)
        ),

        ThemeType.LIGHT to Theme(
            // Main colors
            backgroundColorRGB = Triple(240, 240, 245),
            textColorRGB = Triple(30, 30, 30),

            // Navigation colors
            navBackgroundColorRGB = Triple(220, 220, 230),
            navBorderColorRGB = Triple(180, 180, 200),
            navLinkActiveColorRGB = Triple(20, 50, 150),
            navLinkInactiveColorRGB = Triple(60, 80, 150),
            navLinkHoverColorRGB = Triple(20, 50, 150),

            // Header colors
            headerBackgroundColorRGB = Triple(230, 230, 240),
            headerBorderColorRGB = Triple(150, 170, 220),
            headerShadowColorRGBA = Quadruple(0, 0, 0, 0.2),
            headerTitleColorRGB = Triple(20, 20, 20),
            headerSubtitleColorRGB = Triple(60, 80, 150)
        ),

        ThemeType.BLUE to Theme(
            // Main colors
            backgroundColorRGB = Triple(15, 25, 40),
            textColorRGB = Triple(220, 230, 240),

            // Navigation colors
            navBackgroundColorRGB = Triple(25, 40, 60),
            navBorderColorRGB = Triple(40, 70, 100),
            navLinkActiveColorRGB = Triple(100, 180, 255),
            navLinkInactiveColorRGB = Triple(80, 140, 200),
            navLinkHoverColorRGB = Triple(100, 180, 255),

            // Header colors
            headerBackgroundColorRGB = Triple(20, 35, 55),
            headerBorderColorRGB = Triple(60, 120, 180),
            headerShadowColorRGBA = Quadruple(0, 10, 30, 0.4),
            headerTitleColorRGB = Triple(240, 240, 255),
            headerSubtitleColorRGB = Triple(100, 160, 220)
        ),

        ThemeType.GREEN to Theme(
            // Main colors
            backgroundColorRGB = Triple(15, 30, 20),
            textColorRGB = Triple(220, 240, 220),

            // Navigation colors
            navBackgroundColorRGB = Triple(25, 45, 30),
            navBorderColorRGB = Triple(40, 80, 50),
            navLinkActiveColorRGB = Triple(120, 220, 150),
            navLinkInactiveColorRGB = Triple(100, 180, 120),
            navLinkHoverColorRGB = Triple(120, 220, 150),

            // Header colors
            headerBackgroundColorRGB = Triple(20, 40, 25),
            headerBorderColorRGB = Triple(60, 140, 80),
            headerShadowColorRGBA = Quadruple(0, 20, 10, 0.4),
            headerTitleColorRGB = Triple(230, 255, 230),
            headerSubtitleColorRGB = Triple(120, 200, 140)
        )
    )

    // Current theme
    private val currentTheme: Theme
        get() = themes[currentThemeType]!!

    // Main colors as Color objects
    val backgroundColor: Color
        get() = rgb(currentTheme.backgroundColorRGB.first, currentTheme.backgroundColorRGB.second, currentTheme.backgroundColorRGB.third)
    val textColor: Color
        get() = rgb(currentTheme.textColorRGB.first, currentTheme.textColorRGB.second, currentTheme.textColorRGB.third)

    // Navigation colors as Color objects
    val navBackgroundColor: Color
        get() = rgb(currentTheme.navBackgroundColorRGB.first, currentTheme.navBackgroundColorRGB.second, currentTheme.navBackgroundColorRGB.third)
    val navBorderColor: Color
        get() = rgb(currentTheme.navBorderColorRGB.first, currentTheme.navBorderColorRGB.second, currentTheme.navBorderColorRGB.third)
    val navLinkActiveColor: Color
        get() = rgb(currentTheme.navLinkActiveColorRGB.first, currentTheme.navLinkActiveColorRGB.second, currentTheme.navLinkActiveColorRGB.third)
    val navLinkInactiveColor: Color
        get() = rgb(currentTheme.navLinkInactiveColorRGB.first, currentTheme.navLinkInactiveColorRGB.second, currentTheme.navLinkInactiveColorRGB.third)
    val navLinkHoverColor: Color
        get() = rgb(currentTheme.navLinkHoverColorRGB.first, currentTheme.navLinkHoverColorRGB.second, currentTheme.navLinkHoverColorRGB.third)

    // Header colors as Color objects
    val headerBackgroundColor: Color
        get() = rgb(currentTheme.headerBackgroundColorRGB.first, currentTheme.headerBackgroundColorRGB.second, currentTheme.headerBackgroundColorRGB.third)
    val headerBorderColor: Color
        get() = rgb(currentTheme.headerBorderColorRGB.first, currentTheme.headerBorderColorRGB.second, currentTheme.headerBorderColorRGB.third)
    val headerShadowColor: Color
        get() = rgba(currentTheme.headerShadowColorRGBA.first, currentTheme.headerShadowColorRGBA.second, currentTheme.headerShadowColorRGBA.third, currentTheme.headerShadowColorRGBA.fourth)
    val headerTitleColor: Color
        get() = rgb(currentTheme.headerTitleColorRGB.first, currentTheme.headerTitleColorRGB.second, currentTheme.headerTitleColorRGB.third)
    val headerSubtitleColor: Color
        get() = rgb(currentTheme.headerSubtitleColorRGB.first, currentTheme.headerSubtitleColorRGB.second, currentTheme.headerSubtitleColorRGB.third)

    /**
     * Get the current theme type
     */
    fun getCurrentTheme(): ThemeType = currentThemeType

    /**
     * Get all available theme types
     */
    fun getAvailableThemes(): List<ThemeType> = ThemeType.values().toList()

    /**
     * Set the current theme and apply it
     */
    fun setTheme(themeType: ThemeType) {
        if (currentThemeType != themeType) {
            currentThemeType = themeType
            applyToDocument()
            onThemeChangeCallback?.invoke()
        }
    }

    /**
     * Set a callback to be invoked when the theme changes
     */
    fun setOnThemeChangeCallback(callback: () -> Unit) {
        onThemeChangeCallback = callback
    }

    /**
     * Updates the CSS variables in the document to match the current theme.
     * This ensures that both the HTML and Kotlin parts of the application use the same color scheme.
     */
    fun applyToDocument() {
        val root = web.dom.document.documentElement

        // Helper function to convert RGB to hex string
        fun rgbToHex(r: Int, g: Int, b: Int): String {
            return "#" + ((1 shl 24) + (r shl 16) + (g shl 8) + b).toString(16).substring(1)
        }

        // Helper function to convert Triple to hex string
        fun tripleToHex(triple: Triple<Int, Int, Int>): String {
            return rgbToHex(triple.first, triple.second, triple.third)
        }

        // Helper function to convert RGBA to rgba string
        fun rgbaToString(r: Int, g: Int, b: Int, a: Double): String {
            return "rgba($r, $g, $b, $a)"
        }

        // Helper function to convert Quadruple to rgba string
        fun quadrupleToRgba(quad: Quadruple<Int, Int, Int, Double>): String {
            return rgbaToString(quad.first, quad.second, quad.third, quad.fourth)
        }

        // Set CSS variables for the main colors
        root.style.setProperty("--background-color", tripleToHex(currentTheme.backgroundColorRGB))
        root.style.setProperty("--text-color", tripleToHex(currentTheme.textColorRGB))

        // Set CSS variables for navigation colors
        root.style.setProperty("--nav-background-color", tripleToHex(currentTheme.navBackgroundColorRGB))
        root.style.setProperty("--nav-border-color", tripleToHex(currentTheme.navBorderColorRGB))
        root.style.setProperty("--nav-link-active-color", tripleToHex(currentTheme.navLinkActiveColorRGB))
        root.style.setProperty("--nav-link-inactive-color", tripleToHex(currentTheme.navLinkInactiveColorRGB))
        root.style.setProperty("--nav-link-hover-color", tripleToHex(currentTheme.navLinkHoverColorRGB))

        // Set CSS variables for header colors
        root.style.setProperty("--header-background-color", tripleToHex(currentTheme.headerBackgroundColorRGB))
        root.style.setProperty("--header-border-color", tripleToHex(currentTheme.headerBorderColorRGB))
        root.style.setProperty("--header-shadow-color", quadrupleToRgba(currentTheme.headerShadowColorRGBA))
        root.style.setProperty("--header-title-color", tripleToHex(currentTheme.headerTitleColorRGB))
        root.style.setProperty("--header-subtitle-color", tripleToHex(currentTheme.headerSubtitleColorRGB))
    }

    /**
     * Data class representing a complete theme
     */
    private data class Theme(
        // Main colors
        val backgroundColorRGB: Triple<Int, Int, Int>,
        val textColorRGB: Triple<Int, Int, Int>,

        // Navigation colors
        val navBackgroundColorRGB: Triple<Int, Int, Int>,
        val navBorderColorRGB: Triple<Int, Int, Int>,
        val navLinkActiveColorRGB: Triple<Int, Int, Int>,
        val navLinkInactiveColorRGB: Triple<Int, Int, Int>,
        val navLinkHoverColorRGB: Triple<Int, Int, Int>,

        // Header colors
        val headerBackgroundColorRGB: Triple<Int, Int, Int>,
        val headerBorderColorRGB: Triple<Int, Int, Int>,
        val headerShadowColorRGBA: Quadruple<Int, Int, Int, Double>,
        val headerTitleColorRGB: Triple<Int, Int, Int>,
        val headerSubtitleColorRGB: Triple<Int, Int, Int>
    )
}
