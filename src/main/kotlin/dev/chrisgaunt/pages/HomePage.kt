package dev.chrisgaunt.pages

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.footer
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.*

val HomePage = FC<Props> {
    div {
        css {
            maxWidth = 1200.px
            margin = "0 auto".unsafeCast<Margin>()
            padding = 20.px
        }

        // Contact information
        ContactInfo {}

        // Technologies/Skills
        Technologies {}

        // Work Experience
        Experience {}

        // Education
        Education {}

        // Footer
        footer {
            css {
                textAlign = TextAlign.center
                marginTop = 30.px
                paddingTop = 20.px
                borderTop = Border(1.px, LineStyle.solid, rgb(70, 70, 70))
                fontSize = 0.8.rem
                color = rgb(170, 170, 170)
            }
            +"© ${js("new Date().getFullYear()")} Christopher Gaunt"
        }
    }
}