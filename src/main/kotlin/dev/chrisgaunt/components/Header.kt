package dev.chrisgaunt.components

import react.*
import dev.chrisgaunt.components.subcomponents.HeaderContainer
import dev.chrisgaunt.components.subcomponents.HeaderTitle
import dev.chrisgaunt.components.subcomponents.HeaderSubtitle

val Header = FC<Props> {
    HeaderContainer {
        HeaderTitle {
            title = "Christopher Gaunt"
        }
        HeaderSubtitle {
            subtitle = "Software Engineer"
        }
    }
}
