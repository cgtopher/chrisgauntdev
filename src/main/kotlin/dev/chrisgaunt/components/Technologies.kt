package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.ul
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.span
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.subcomponents.SectionContainer
import dev.chrisgaunt.components.subcomponents.SectionHeading

// Technology data class to hold name and logo URL
data class Technology(val name: String, val logoUrl: String)

// Technology categories
val programmingLanguages = listOf(
    Technology("Kotlin", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kotlin/kotlin-original.svg"),
    Technology("Java", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg"),
    Technology("TypeScript", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/typescript/typescript-original.svg"),
    Technology("Python", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/python/python-original.svg"),
    Technology("Perl", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/perl/perl-original.svg")
)

val frameworks = listOf(
    Technology("SpringBoot", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"),
    Technology("Nest.js", "https://nestjs.com/img/logo-small.svg"),
    Technology("Flask", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/flask/flask-original.svg"),
    Technology("FastAPI", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/fastapi/fastapi-original.svg"),
    Technology("SQLAlchemy", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/sqlalchemy/sqlalchemy-original.svg"),
    Technology("Ktor", "https://avatars.githubusercontent.com/u/28214161?s=200&v=4"),
    Technology("Jooq", "https://www.jooq.org/img/logo.png"),
    Technology("React", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/react/react-original.svg"),
    Technology("Hibernate", "https://hibernate.org/images/hibernate-logo.svg"),
    Technology("TypeORM", "https://raw.githubusercontent.com/typeorm/typeorm/master/resources/logo_big.png")
)

val cloudStacks = listOf(
    Technology("AWS", "https://upload.wikimedia.org/wikipedia/commons/9/93/Amazon_Web_Services_Logo.svg"),
    Technology("GCP", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/googlecloud/googlecloud-original.svg")
)

val otherTools = listOf(
    Technology("Bash", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/bash/bash-original.svg"),
    Technology("PostgreSQL", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg"),
    Technology("MySQL", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg"),
    Technology("Redis", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/redis/redis-original.svg"),
    Technology("Jenkins", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg"),
    Technology("GitHub", "https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg")
)

val Technologies = FC<Props> {
    SectionContainer {
        SectionHeading {
            title = "Technologies"
        }

        p {
            css {
                marginBottom = 20.px
                fontSize = 1.rem
                color = rgb(200, 200, 200)
            }
            +"Some of the more notable tools I've used include:"
        }

        div {
            css {
                display = Display.flex
                flexDirection = FlexDirection.column
                gap = 20.px
            }

            // Programming Languages
            div {
                css {
                    marginBottom = 10.px
                }
                p {
                    css {
                        fontWeight = FontWeight.bold
                        marginBottom = 15.px
                        color = rgb(180, 200, 255)
                        fontSize = 1.2.rem
                    }
                    +"Programming Languages"
                }

                // Grid for technology logos and names
                div {
                    css {
                        display = Display.grid
                        gridTemplateColumns = "repeat(auto-fill, minmax(100px, 1fr))".unsafeCast<GridTemplateColumns>()
                        gap = 20.px
                        justifyContent = JustifyContent.center
                    }

                    programmingLanguages.forEach { tech ->
                        div {
                            css {
                                display = Display.flex
                                flexDirection = FlexDirection.column
                                alignItems = AlignItems.center
                                textAlign = TextAlign.center
                            }

                            img {
                                css {
                                    width = 50.px
                                    height = 50.px
                                    marginBottom = 8.px
                                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icons white
                                }
                                src = tech.logoUrl
                                alt = "${tech.name} logo"
                            }

                            span {
                                css {
                                    fontSize = 0.9.rem
                                    color = rgb(200, 200, 200)
                                }
                                +tech.name
                            }
                        }
                    }
                }
            }

            // Frameworks
            div {
                css {
                    marginBottom = 10.px
                }
                p {
                    css {
                        fontWeight = FontWeight.bold
                        marginBottom = 15.px
                        color = rgb(180, 200, 255)
                        fontSize = 1.2.rem
                    }
                    +"Frameworks"
                }

                div {
                    css {
                        display = Display.grid
                        gridTemplateColumns = "repeat(auto-fill, minmax(100px, 1fr))".unsafeCast<GridTemplateColumns>()
                        gap = 20.px
                        justifyContent = JustifyContent.center
                    }

                    frameworks.forEach { tech ->
                        div {
                            css {
                                display = Display.flex
                                flexDirection = FlexDirection.column
                                alignItems = AlignItems.center
                                textAlign = TextAlign.center
                            }

                            img {
                                css {
                                    width = 50.px
                                    height = 50.px
                                    marginBottom = 8.px
                                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icons white
                                }
                                src = tech.logoUrl
                                alt = "${tech.name} logo"
                            }

                            span {
                                css {
                                    fontSize = 0.9.rem
                                    color = rgb(200, 200, 200)
                                }
                                +tech.name
                            }
                        }
                    }
                }
            }

            // Cloud Stacks
            div {
                css {
                    marginBottom = 10.px
                }
                p {
                    css {
                        fontWeight = FontWeight.bold
                        marginBottom = 15.px
                        color = rgb(180, 200, 255)
                        fontSize = 1.2.rem
                    }
                    +"Cloud Stacks"
                }

                div {
                    css {
                        display = Display.grid
                        gridTemplateColumns = "repeat(auto-fill, minmax(100px, 1fr))".unsafeCast<GridTemplateColumns>()
                        gap = 20.px
                        justifyContent = JustifyContent.center
                    }

                    cloudStacks.forEach { tech ->
                        div {
                            css {
                                display = Display.flex
                                flexDirection = FlexDirection.column
                                alignItems = AlignItems.center
                                textAlign = TextAlign.center
                            }

                            img {
                                css {
                                    width = 50.px
                                    height = 50.px
                                    marginBottom = 8.px
                                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icons white
                                }
                                src = tech.logoUrl
                                alt = "${tech.name} logo"
                            }

                            span {
                                css {
                                    fontSize = 0.9.rem
                                    color = rgb(200, 200, 200)
                                }
                                +tech.name
                            }
                        }
                    }
                }
            }

            // Other Tools
            div {
                p {
                    css {
                        fontWeight = FontWeight.bold
                        marginBottom = 15.px
                        color = rgb(180, 200, 255)
                        fontSize = 1.2.rem
                    }
                    +"Other Tools"
                }

                div {
                    css {
                        display = Display.grid
                        gridTemplateColumns = "repeat(auto-fill, minmax(100px, 1fr))".unsafeCast<GridTemplateColumns>()
                        gap = 20.px
                        justifyContent = JustifyContent.center
                    }

                    otherTools.forEach { tech ->
                        div {
                            css {
                                display = Display.flex
                                flexDirection = FlexDirection.column
                                alignItems = AlignItems.center
                                textAlign = TextAlign.center
                            }

                            img {
                                css {
                                    width = 50.px
                                    height = 50.px
                                    marginBottom = 8.px
                                    filter = "brightness(0) invert(1)".unsafeCast<Filter>() // Make icons white
                                }
                                src = tech.logoUrl
                                alt = "${tech.name} logo"
                            }

                            span {
                                css {
                                    fontSize = 0.9.rem
                                    color = rgb(200, 200, 200)
                                }
                                +tech.name
                            }
                        }
                    }
                }
            }
        }
    }
}
