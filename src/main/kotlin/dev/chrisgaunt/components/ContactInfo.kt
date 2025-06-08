package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.img
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
                display = Display.flex
                alignItems = AlignItems.center
                gap = 8.px
            }
            img {
                css {
                    width = 20.px
                    height = 20.px
                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icon white
                }
                src = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/icons/telephone.svg"
                alt = "Phone"
            }
            +"480.628.0260"
        }

        p {
            css {
                margin = 5.px
                fontSize = 1.rem
                display = Display.flex
                alignItems = AlignItems.center
                gap = 8.px
            }
            img {
                css {
                    width = 20.px
                    height = 20.px
                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icon white
                }
                src = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/icons/envelope.svg"
                alt = "Email"
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
                display = Display.flex
                alignItems = AlignItems.center
                gap = 8.px
            }
            img {
                css {
                    width = 20.px
                    height = 20.px
                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icon white
                }
                src = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/icons/linkedin.svg"
                alt = "LinkedIn"
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
                display = Display.flex
                alignItems = AlignItems.center
                gap = 8.px
            }
            img {
                css {
                    width = 20.px
                    height = 20.px
                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icon white
                }
                src = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/icons/geo-alt.svg"
                alt = "Location"
            }
            +"South Shore, Massachusetts"
        }

    }
}
