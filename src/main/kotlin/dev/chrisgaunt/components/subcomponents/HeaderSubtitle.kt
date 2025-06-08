package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.h2
import emotion.react.css
import web.cssom.*
import csstype.*

external interface HeaderSubtitleProps : Props {
    var subtitle: String
    var className: String?
}

val HeaderSubtitle = FC<HeaderSubtitleProps> { props ->
    h2 {
        css {
            fontSize = 1.5.rem
            fontWeight = FontWeight.normal
            marginTop = 10.px
            color = rgb(120, 150, 220)
        }
        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }
        
        +props.subtitle
    }
}