package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.a
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.subcomponents.SectionContainer
import dev.chrisgaunt.components.subcomponents.SectionHeading

// Define a data class for projects
data class Project(
    val name: String,
    val year: String,
    val description: List<String>,
    val link: String? = null
)

val Projects = FC<Props> {
    // Define the projects
    val projects = listOf(
        Project(
            name = "Spirio.ai",
            year = "2024",
            description = listOf(
                "Joined a very small company for profit share that wanted to experiment with implementing a RAG system for helping users organize their lives. I created a Flask API in Python that managed user segmented vector stores in a PostgreSQL database that represented their documents and could be added to chat sessions with LLMs as context. It also supported setting up chat sessions with prompts to guide the LLMs in different topics. I set up and managed linux servers with storage mounts to run the API and handle user documents. Didn't take off, but I learned a ton building it."
            )
        ),
        Project(
            name = "Garden Planner",
            year = "2024",
            description = listOf(
                "Fun little project I did to help my wife and I figure out which plants would be beneficial to plant together, as well as experiment with using graph databases to manage complex relationships. I created a Flask API backed by a Neo4J database, and munged data from a couple of sources."
            ),
            link = "https://github.com/cgtopher/companion-planting-api"
        ),
        Project(
            name = "Status Tracker",
            year = "2023",
            description = listOf(
                "Project I did to experiment with Kotlin's API framework, Ktor. It's an application that manages the status of processes, built primarily to be lightweight to allow for very fast polling and updates, using postgres for managing \"tracks\" and redis for active processes."
            ),
            link = "https://github.com/cgtopher/status-tracker"
        )
    )

    SectionContainer {
        SectionHeading {
            title = "Side Projects"
        }

        // Render each project
        projects.forEach { project ->
            div {
                css {
                    marginBottom = 25.px
                    paddingBottom = 20.px
                    borderBottom = if (project != projects.last()) Border(1.px, LineStyle.dashed, rgb(70, 70, 80)) else null
                }

                div {
                    css {
                        display = Display.flex
                        justifyContent = JustifyContent.spaceBetween
                        alignItems = AlignItems.center
                        marginBottom = 10.px
                    }

                    h3 {
                        css {
                            margin = 0.px
                            fontSize = 1.3.rem
                            color = rgb(180, 200, 255)
                        }
                        +project.name
                    }

                    p {
                        css {
                            margin = 0.px
                            fontStyle = FontStyle.italic
                            color = rgb(170, 170, 170)
                        }
                        +project.year
                    }
                }

                // Project description
                project.description.forEach { paragraph ->
                    p {
                        css {
                            lineHeight = 1.5.em
                            marginBottom = 10.px
                            color = rgb(200, 200, 200)
                        }
                        +paragraph
                    }
                }

                // Project link if available
                project.link?.let { link ->
                    p {
                        css {
                            marginTop = 10.px
                        }
                        a {
                            href = link
                            css {
                                color = rgb(120, 150, 220)
                                textDecoration = "none".unsafeCast<TextDecoration>()
                                transition = "color 0.3s ease".unsafeCast<Transition>()
                                hover {
                                    color = rgb(150, 180, 255)
                                }
                            }
                            +"GitHub Repository"
                        }
                    }
                }
            }
        }
    }
}
