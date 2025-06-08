package dev.chrisgaunt

import react.create
import react.dom.client.createRoot
import web.dom.Element
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    window.onload = {
        val container = document.getElementById("root") ?: error("Couldn't find root container!")
        createRoot(container as Element).render(App.create())
    }
}
