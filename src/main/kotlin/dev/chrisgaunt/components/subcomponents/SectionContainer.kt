package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*

external interface SectionContainerProps : PropsWithChildren {
    var className: String?
}

val SectionContainer = FC<SectionContainerProps> { props ->
    div {
        css {
            padding = 25.px
            marginBottom = 30.px
            backgroundColor = rgb(35, 35, 40)
            color = rgb(220, 220, 220)
            borderRadius = 8.px
            boxShadow = BoxShadow(0.px, 4.px, 12.px, rgba(0, 0, 0, 0.3))
            border = Border(1.px, LineStyle.solid, rgb(50, 50, 60))
            transition = "transform 0.3s ease, box-shadow 0.3s ease, border-color 0.3s ease".unsafeCast<Transition>()
            hover {
                transform = "translateY(-5px)".unsafeCast<Transform>()
                boxShadow = BoxShadow(0.px, 8.px, 16.px, rgba(0, 0, 0, 0.4))
                borderColor = rgb(75, 100, 160).unsafeCast<BorderColor>()
            }
        }
        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }
        
        // Render children
        +props.children
    }
}