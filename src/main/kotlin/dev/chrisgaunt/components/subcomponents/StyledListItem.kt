package dev.chrisgaunt.components.subcomponents

import react.*
import react.dom.html.ReactHTML.li
import emotion.react.css
import web.cssom.*
import csstype.*

external interface StyledListItemProps : PropsWithChildren {
    var className: String?
}

val StyledListItem = FC<StyledListItemProps> { props ->
    li {
        css {
            marginBottom = 10.px
            lineHeight = 1.5.em
            color = rgb(200, 200, 200)
        }
        props.className?.let { className ->
            // Apply additional className if provided
            asDynamic().className = className
        }
        
        // Render children
        +props.children
    }
}