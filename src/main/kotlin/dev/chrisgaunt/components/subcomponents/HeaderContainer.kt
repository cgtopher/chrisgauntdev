package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.theme.ThemeConfig

external interface HeaderContainerProps : PropsWithChildren {
    var className: String?
}

val HeaderContainer = FC<HeaderContainerProps> { props ->
    div {
        css {
            textAlign = TextAlign.center
            padding = 20.px
            backgroundColor = Color("var(--header-background-color)")
            marginBottom = 30.px
            boxShadow = BoxShadow(0.px, 2.px, 10.px, Color("var(--header-shadow-color)"))
            borderBottom = Border(2.px, LineStyle.solid, Color("var(--header-border-color)"))
        }
        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }

        // Render children
        +props.children
    }
}
