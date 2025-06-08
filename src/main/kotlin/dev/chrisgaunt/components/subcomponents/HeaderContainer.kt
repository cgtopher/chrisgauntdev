package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*

external interface HeaderContainerProps : PropsWithChildren {
    var className: String?
}

val HeaderContainer = FC<HeaderContainerProps> { props ->
    div {
        css {
            textAlign = TextAlign.center
            padding = 40.px
            backgroundColor = rgb(25, 25, 30)
            marginBottom = 30.px
            boxShadow = BoxShadow(0.px, 2.px, 10.px, rgba(0, 0, 0, 0.4))
            borderBottom = Border(2.px, LineStyle.solid, rgb(75, 100, 160))
        }
        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }
        
        // Render children
        +props.children
    }
}