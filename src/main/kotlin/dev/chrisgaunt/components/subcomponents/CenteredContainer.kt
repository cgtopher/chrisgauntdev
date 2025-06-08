package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import web.cssom.*
import csstype.*

external interface CenteredContainerProps : PropsWithChildren {
    var className: String?
}

val CenteredContainer = FC<CenteredContainerProps> { props ->
    div {
        css {
            textAlign = TextAlign.center
            padding = 25.px
            marginBottom = 30.px
            display = Display.flex
            flexDirection = FlexDirection.column
            alignItems = AlignItems.center
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