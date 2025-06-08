package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.h2
import emotion.react.css
import web.cssom.*
import csstype.*

external interface SectionHeadingProps : Props {
    var title: String
    var className: String?
}

val SectionHeading = FC<SectionHeadingProps> { props ->
    h2 {
        css {
            borderBottom = Border(2.px, LineStyle.solid, rgb(75, 100, 160))
            paddingBottom = 12.px
            marginBottom = 20.px
            color = rgb(220, 220, 220)
            fontSize = 1.5.rem
            fontWeight = FontWeight.bold
        }
        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }
        
        +props.title
    }
}