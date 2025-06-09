package dev.chrisgaunt

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.*
import dev.chrisgaunt.components.subcomponents.*
import dev.chrisgaunt.pages.*
import dev.chrisgaunt.theme.ThemeConfig

// Enum to represent different pages
enum class Page {
    HOME, PROJECTS
}

val App = FC<Props> {
    // State to track the current page
    val (currentPage, setCurrentPage) = useState(Page.HOME)

    // Apply theme to document
    useEffect {
        ThemeConfig.applyToDocument()
    }

    div {
        css {
            width = 100.pct
            fontFamily = "Arial, sans-serif".unsafeCast<FontFamily>()
            backgroundColor = Color("var(--background-color)")
            color = Color("var(--text-color)")
        }

        // Navigation bar (consistent across all pages)
        NavContainer {
            // Theme picker (leftmost)
            ThemePickerContainer {}

            // Navigation links (center)
            NavLink {
                isActive = currentPage == Page.HOME
                onClick = { setCurrentPage(Page.HOME) }
                +"Home"
            }

            NavLink {
                isActive = currentPage == Page.PROJECTS
                onClick = { setCurrentPage(Page.PROJECTS) }
                +"Side Projects"
            }

            // Empty div for symmetry (rightmost)
            NavSpacer {}
        }

        // Header with name and title (consistent across all pages)
        Header {}

        // Render the current page
        when (currentPage) {
            Page.HOME -> HomePage {}
            Page.PROJECTS -> ProjectsPage {}
        }
    }
}
