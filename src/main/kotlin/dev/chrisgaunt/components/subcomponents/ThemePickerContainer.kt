package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*

/**
 * A container for the ThemePicker component.
 * This positions the theme picker on the left side of the navigation bar.
 */
val ThemePickerContainer = FC<Props> {
    div {
        css {
            marginRight = Auto.auto  // Push to the left
            marginLeft = 20.px       // Add some spacing from the left edge
        }
        ThemePicker {}
    }
}