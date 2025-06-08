package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.a
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.subcomponents.CenteredContainer

val ContactInfo = FC<Props> {
    CenteredContainer {

        p {
            css {
                margin = 5.px
                fontSize = 1.rem
            }
            +"480.628.0260"
        }

        p {
            css {
                margin = 5.px
                fontSize = 1.rem
            }
            a {
                href = "mailto:chris.tgaunt@gmail.com"
                css {
                    color = rgb(120, 150, 220)
                    textDecoration = "none".unsafeCast<TextDecoration>()
                    transition = "color 0.3s ease".unsafeCast<Transition>()
                    hover {
                        color = rgb(150, 180, 255)
                    }
                }
                +"chris.tgaunt@gmail.com"
            }
        }

        p {
            css {
                margin = 5.px
                fontSize = 1.rem
            }
            a {
                href = "https://www.linkedin.com/in/chris-gaunt-950133b1"
                css {
                    color = rgb(120, 150, 220)
                    textDecoration = "none".unsafeCast<TextDecoration>()
                    transition = "color 0.3s ease".unsafeCast<Transition>()
                    hover {
                        color = rgb(150, 180, 255)
                    }
                }
                +"LinkedIn Profile"
            }
        }

        p {
            css {
                margin = 5.px
                fontSize = 1.rem
            }
            +"South Shore, Massachusetts"
        }

    }
}
