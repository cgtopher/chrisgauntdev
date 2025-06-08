package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.p
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.subcomponents.SectionContainer
import dev.chrisgaunt.components.subcomponents.SectionHeading

val Goal = FC<Props> {
    SectionContainer {
        SectionHeading {
            title = "Goal"
        }

        p {
            css {
                lineHeight = 1.6.em
                fontSize = 1.rem
                color = rgb(200, 200, 200)
            }
            +"To find a challenging and exciting software engineering position, for which I can bring nearly a decade of experience and a love of creative problem solving."
        }
    }
}
