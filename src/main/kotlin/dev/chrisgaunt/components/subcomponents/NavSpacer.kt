package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*

/**
 * A component that creates a spacer div for navigation layout.
 * This is used to push elements to the left or right in a flex container.
 */
val NavSpacer = FC<Props> {
    div {
        css {
            marginLeft = Auto.auto  // Push to the right
            width = 20.px           // Match the left margin width
        }
    }
}