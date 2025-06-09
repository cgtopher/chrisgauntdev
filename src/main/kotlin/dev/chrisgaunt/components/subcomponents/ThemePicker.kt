package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.theme.ThemeConfig
import dev.chrisgaunt.theme.ThemeType
import org.w3c.dom.events.Event

val ThemePicker = FC<Props> {
    // State for dropdown visibility
    val (isDropdownOpen, setDropdownOpen) = useState(false)

    // State to track the current theme (for re-rendering when theme changes)
    val (currentTheme, setCurrentTheme) = useState(ThemeConfig.getCurrentTheme())

    // Set up theme change callback
    useEffect {
        ThemeConfig.setOnThemeChangeCallback {
            setCurrentTheme(ThemeConfig.getCurrentTheme())
        }

        // Cleanup callback when component unmounts
        cleanup {
            ThemeConfig.setOnThemeChangeCallback { }
        }
    }

    // Function to toggle dropdown visibility
    val toggleDropdown = {
        setDropdownOpen(!isDropdownOpen)
    }

    // Function to handle theme selection
    val handleThemeSelect = { themeType: ThemeType ->
        ThemeConfig.setTheme(themeType)
        setDropdownOpen(false)
    }

    // Theme picker container
    div {
        css {
            position = Position.relative
            display = Display.flex
            alignItems = AlignItems.center
            cursor = Cursor.pointer
        }

        // Theme icon
        div {
            css {
                display = Display.flex
                alignItems = AlignItems.center
                justifyContent = JustifyContent.center
                width = 24.px
                height = 24.px
                borderRadius = 50.pct
                backgroundColor = Color("var(--nav-link-inactive-color)")
                color = Color("var(--nav-background-color)")
                fontSize = 14.px
                marginRight = 5.px
                transition = "background-color 0.3s ease".unsafeCast<Transition>()
                hover {
                    backgroundColor = Color("var(--nav-link-hover-color)")
                }
            }
            onClick = { toggleDropdown() }
            +"T"  // "T" for Theme
        }

        // Dropdown menu
        if (isDropdownOpen) {
            div {
                css {
                    position = Position.absolute
                    top = 30.px
                    left = 0.px
                    backgroundColor = Color("var(--nav-background-color)")
                    border = Border(1.px, LineStyle.solid, Color("var(--nav-border-color)"))
                    borderRadius = 4.px
                    padding = 5.px
                    zIndex = integer(100)
                    boxShadow = BoxShadow(0.px, 2.px, 10.px, Color("var(--header-shadow-color)"))
                    minWidth = 120.px
                }

                // Theme options
                ThemeConfig.getAvailableThemes().forEach { themeType ->
                    div {
                        css {
                            padding = Padding(8.px, 10.px)
                            cursor = Cursor.pointer
                            color = if (themeType == currentTheme) Color("var(--nav-link-active-color)") else Color("var(--nav-link-inactive-color)")
                            backgroundColor = if (themeType == currentTheme) Color("rgba(255, 255, 255, 0.1)") else Color("transparent")
                            borderRadius = 3.px
                            transition = "background-color 0.2s ease, color 0.2s ease".unsafeCast<Transition>()
                            hover {
                                backgroundColor = Color("rgba(255, 255, 255, 0.2)")
                                color = Color("var(--nav-link-hover-color)")
                            }
                        }
                        onClick = { handleThemeSelect(themeType) }
                        +themeType.name.capitalize()
                    }
                }
            }
        }
    }
}

// Extension function to capitalize the first letter of a string
private fun String.capitalize(): String {
    return if (this.isNotEmpty()) {
        this[0].uppercase() + this.substring(1).lowercase()
    } else {
        this
    }
}
