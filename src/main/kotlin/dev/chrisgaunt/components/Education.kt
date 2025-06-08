package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.p
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.subcomponents.SectionContainer
import dev.chrisgaunt.components.subcomponents.SectionHeading

val Education = FC<Props> {
    SectionContainer {
        SectionHeading {
            title = "Education"
        }

        div {
            css {
                display = Display.flex
                justifyContent = JustifyContent.spaceBetween
                alignItems = AlignItems.center
                marginBottom = 10.px
            }

            h3 {
                css {
                    margin = 0.px
                    fontSize = 1.3.rem
                    color = rgb(180, 200, 255)
                }
                +"Mesa Community College / Music/General Education"
            }

            p {
                css {
                    margin = 0.px
                    fontStyle = FontStyle.italic
                    color = rgb(170, 170, 170)
                }
                +"August 2008 - May 2010"
            }
        }

        p {
            css {
                lineHeight = 1.5.em
                color = rgb(200, 200, 200)
            }
            +"Mesa, Arizona"
        }
    }
}
