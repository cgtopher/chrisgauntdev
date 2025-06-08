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
            name = "My Homepage 2025",
            year = "2025",
            description = listOf(
                "In the spirit of adventure on the new AI frontier, I decided to try a few new things out at once. I've always been interested in the Kotlin programming language and its flexibility to run almost anywhere! Front end development has never been my strong suit, and I've played around with writing kotlin to run in node and browsers, so I thought it would be fun to make a resume site in Kotlin using the React framework, then compile it to a bundle that could be run in GitHub Pages. It took some iteration on design, and coaxing it through abstraction of components, but I think Junie and I made something that looks good, is modern, and has cool technologies underlying it!"
            ),
            link = "https://github.com/cgtopher/chrisgauntdev"
        ),
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

        // Container for cards with grid layout
        div {
            css {
                display = Display.grid
                gridTemplateColumns = "repeat(auto-fill, minmax(300px, 1fr))".unsafeCast<GridTemplateColumns>()
                gap = 30.px
                rowGap = 60.px
                marginTop = 20.px
            }

            // Render each project as a card
            projects.forEach { project ->
                // Project card
                div {
                    css {
                        backgroundColor = rgb(30, 30, 35)
                        borderRadius = 8.px
                        padding = 20.px
                        boxShadow = BoxShadow(0.px, 2.px, 6.px, rgba(0, 0, 0, 0.15))
                        display = Display.flex
                        flexDirection = FlexDirection.column
                        position = Position.relative
                        zIndex = integer(1)
                        minHeight = 100.pct
                        marginBottom = 5.px
                    }

                    // Card header with project name and year
                    div {
                        css {
                            display = Display.flex
                            justifyContent = JustifyContent.spaceBetween
                            alignItems = AlignItems.center
                            marginBottom = 15.px
                            borderBottom = Border(1.px, LineStyle.solid, rgb(50, 50, 60))
                            paddingBottom = 10.px
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

                    // Card content
                    div {
                        css {
                            flexGrow = number(1.0)
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
                    }

                    // Card footer with link if available
                    project.link?.let { link ->
                        div {
                            css {
                                marginTop = 15.px
                                borderTop = Border(1.px, LineStyle.solid, rgb(50, 50, 60))
                                paddingTop = 10.px
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
}
