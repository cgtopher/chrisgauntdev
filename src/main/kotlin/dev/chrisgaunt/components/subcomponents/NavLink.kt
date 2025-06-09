package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.theme.ThemeConfig

external interface NavLinkProps : PropsWithChildren {
    var isActive: Boolean
    var onClick: () -> Unit
    var className: String?
}

val NavLink = FC<NavLinkProps> { props ->
    div {
        css {
            margin = Margin(0.px, 15.px)
            cursor = Cursor.pointer
            color = if (props.isActive) Color("var(--nav-link-active-color)") else Color("var(--nav-link-inactive-color)")
            textDecoration = "none".unsafeCast<TextDecoration>()
            fontSize = 1.1.rem
            transition = "color 0.3s ease".unsafeCast<Transition>()
            hover {
                color = Color("var(--nav-link-hover-color)")
            }
        }

        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }

        onClick = { props.onClick() }

        // Render children
        +props.children
    }
}
