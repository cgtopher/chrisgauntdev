package dev.chrisgaunt.components

import react.*
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.ul
import react.dom.html.ReactHTML.li
import emotion.react.css
import web.cssom.*
import csstype.*
import dev.chrisgaunt.components.subcomponents.SectionContainer
import dev.chrisgaunt.components.subcomponents.SectionHeading

// Define a data class for job experience
data class JobExperience(
    val company: String,
    val title: String,
    val period: String,
    val description: List<String>,
    val technologies: String
)

val Experience = FC<Props> {
    // Define the job experiences
    val experiences = listOf(
        JobExperience(
            company = "Arbor",
            title = "Senior Software Engineer",
            period = "February 2024 - Current",
            description = listOf(
                "Early engineer, working on a system to broker users to different electricity supply contracts at a better cost, and with climate friendly suppliers",
                "Designed a re-engineering of the full brokerage platform, indexing primarily on maintainability and stability. This involved a holistic reimagining of the architecture and core data models, using service oriented and event based architectures which resulted in a more modular and scalable system, with much more observability.",
                "Two key areas of focus for myself were infrastructure and AI integration. I designed a container based system that ran in GCP's cloud run, controlled with terraform. I set up a load balancing system secured by WAF, with API gateways that routed traffic to our services. I also implemented a utility statement parser that used LLMs to extract data from user's bills. This provided the data needed most to run the brokerage business."
            ),
            technologies = "Stack: Typescript, Nest.js, Python, PostgreSQL, GCP Cloud Functions, Firebase, BigQuery, Datadog"
        ),
        JobExperience(
            company = "Regal.io",
            title = "Senior Software Engineer",
            period = "September 2022 - October 2023",
            description = listOf(
                "Acted as tech lead engineer on a team of 5, developing features on an event-driven VOIP platform that helped sales and customer teams reach their customers.",
                "Designed and implemented key features to help our customers manage calls, complex call routing rules, team management, as well as contributing to overall platform stability.",
                "Worked with junior and mid-level engineers to help with their technical and professional growth."
            ),
            technologies = "Stack: Typescript, Nest.js, React, Redis, PostgreSQL, Docker, AWS ECS and CodePipeline"
        ),
        JobExperience(
            company = "Metromile Enterprise",
            title = "Senior Software Engineer",
            period = "December 2019 - September 2022",
            description = listOf(
                "Acted as tech lead engineer on a team of 6 to develop a solution for allowing Enterprise Insurance customers to create flexible business workflows with easy integrations",
                "My initial projects included building a deployment manager for lamba's deployed in kubernetes that could integrate into our claims software, as well as maintaining the claims software as it was deployed to the largest insurance company in Japan.",
                "After the initial deployment, I was tasked with replacing the main stack with a more modular, maintainable system, with the key benefit of moving from a deployed per customer system, to a multi-tenant system, capable of handling large enterprise customers. Designed a new services oriented system in Kotlin and SpringBoot, using a BPMN process management engine to handle the creation and use of complex claims flows with integrations with customer's systems."
            ),
            technologies = "Stack: Kotlin, Java, Python, SpringBoot, Kubernetes, PostgreSQL, AWS lambda, AWS SQS/SNS"
        ),
        JobExperience(
            company = "Endurance International",
            title = "Software Engineer",
            period = "September 2016 - December 2019",
            description = listOf(
                "Worked in engineering teams to develop platform features and integrations to allow customers to create websites, register domains, and manage email servers.",
                "Primarily contributed to a Perl codebase running on linux web servers, mostly building and maintaining the billing system which was responsible for processing millions of dollars in transactions per day. This included onboarding, subscription renewals, credit card processing, and tax reconciliation. I also acted as lead on a project to bring the full system into PCI compliance, by implementing a new token based credit card processing system",
                "Toward the end of my stint, I was tasked with our first foray into breaking our monolithic application into micro services, written in Java running in SpringBoot. We first rebuilt the tax platform and integrated it back into the monolith, and as a result set the patterns the team would be using moving forward, rewriting the system piecemeal making it more maintainable and stable over time."
            ),
            technologies = "Stack: Perl, Linux, Java, Docker, Kubernetes, SpringBoot, MySQL"
        )
    )

    SectionContainer {
        SectionHeading {
            title = "Experience"
        }

        // Render each job experience
        experiences.forEach { job ->
            div {
                css {
                    marginBottom = 25.px
                    paddingBottom = 20.px
                    borderBottom = if (job != experiences.last()) Border(1.px, LineStyle.dashed, rgb(70, 70, 80)) else null
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
                        +"${job.company} / ${job.title}"
                    }

                    p {
                        css {
                            margin = 0.px
                            fontStyle = FontStyle.italic
                            color = rgb(170, 170, 170)
                        }
                        +job.period
                    }
                }

                // Job description
                job.description.forEach { paragraph ->
                    p {
                        css {
                            lineHeight = 1.5.em
                            marginBottom = 10.px
                            color = rgb(200, 200, 200)
                        }
                        +paragraph
                    }
                }

                // Technologies used
                p {
                    css {
                        marginTop = 10.px
                        fontStyle = FontStyle.italic
                        color = rgb(170, 170, 170)
                    }
                    +job.technologies
                }
            }
        }
    }
}
