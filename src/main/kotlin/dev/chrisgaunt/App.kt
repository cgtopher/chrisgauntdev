package dev.chrisgaunt

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.*
import dev.chrisgaunt.pages.*

// Enum to represent different pages
enum class Page {
    HOME, PROJECTS
}

val App = FC<Props> {
    // State to track the current page
    val (currentPage, setCurrentPage) = useState(Page.HOME)

    div {
        css {
            width = 100.pct
            fontFamily = "Arial, sans-serif".unsafeCast<FontFamily>()
            backgroundColor = rgb(18, 18, 18)
            color = rgb(224, 224, 224)
        }


        // Navigation bar (consistent across all pages)
        div {
            css {
                backgroundColor = rgb(30, 30, 35)
                padding = Padding(10.px, 0.px)
                borderBottom = Border(1.px, LineStyle.solid, rgb(50, 50, 60))
                marginBottom = 20.px
            }

            div {
                css {
                    display = Display.flex
                    justifyContent = JustifyContent.center
                    listStyleType = "none".unsafeCast<ListStyleType>()
                    margin = 0.px
                    padding = 0.px
                }

                // Home link
                div {
                    css {
                        margin = Margin(0.px, 15.px)
                        cursor = Cursor.pointer
                        color = if (currentPage == Page.HOME) rgb(220, 230, 255) else rgb(180, 200, 255)
                        textDecoration = "none".unsafeCast<TextDecoration>()
                        fontSize = 1.1.rem
                        transition = "color 0.3s ease".unsafeCast<Transition>()
                        hover {
                            color = rgb(220, 230, 255)
                        }
                    }
                    onClick = { setCurrentPage(Page.HOME) }
                    +"Home"
                }

                // Side Projects link
                div {
                    css {
                        margin = Margin(0.px, 15.px)
                        cursor = Cursor.pointer
                        color = if (currentPage == Page.PROJECTS) rgb(220, 230, 255) else rgb(180, 200, 255)
                        textDecoration = "none".unsafeCast<TextDecoration>()
                        fontSize = 1.1.rem
                        transition = "color 0.3s ease".unsafeCast<Transition>()
                        hover {
                            color = rgb(220, 230, 255)
                        }
                    }
                    onClick = { setCurrentPage(Page.PROJECTS) }
                    +"Side Projects"
                }
            }
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
