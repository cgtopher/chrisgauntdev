package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.h1
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.theme.ThemeConfig

external interface HeaderTitleProps : Props {
    var title: String
    var className: String?
}

val HeaderTitle = FC<HeaderTitleProps> { props ->
    h1 {
        css {
            fontSize = 3.rem
            marginBottom = 0.px
            color = Color("var(--header-title-color)")
            fontWeight = FontWeight.bold
        }
        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }

        +props.title
    }
}
