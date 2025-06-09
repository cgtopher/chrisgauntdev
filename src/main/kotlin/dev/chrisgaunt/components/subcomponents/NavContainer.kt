package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.theme.ThemeConfig

external interface NavContainerProps : PropsWithChildren {
    var className: String?
}

val NavContainer = FC<NavContainerProps> { props ->
    div {
        css {
            backgroundColor = Color("var(--nav-background-color)")
            padding = Padding(10.px, 0.px)
            borderBottom = Border(1.px, LineStyle.solid, Color("var(--nav-border-color)"))
            marginBottom = 20.px
        }

        div {
            css {
                display = Display.flex
                justifyContent = JustifyContent.center
                alignItems = AlignItems.center
                listStyleType = "none".unsafeCast<ListStyleType>()
                margin = 0.px
                padding = 0.px
            }

            props.className?.let { className ->
                // Apply additional className if provided
                asDynamic().className = className
            }

            // Render children
            +props.children
        }
    }
}
