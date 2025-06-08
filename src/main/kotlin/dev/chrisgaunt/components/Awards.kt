package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.ul
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.subcomponents.SectionContainer
import dev.chrisgaunt.components.subcomponents.SectionHeading
import dev.chrisgaunt.components.subcomponents.StyledListItem

val Awards = FC<Props> {
    SectionContainer {
        SectionHeading {
            title = "Awards"
        }

        ul {
            css {
                paddingLeft = 20.px
                margin = 0.px
            }

            StyledListItem {
                +"I have won awards in three hackathons across two companies, for projects in ML and automation."
            }

            StyledListItem {
                +"I am a proud Eagle Scout"
            }
        }
    }
}
