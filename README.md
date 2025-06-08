# Chris Gaunt's Kotlin React App

A basic Kotlin React application that can be deployed to GitHub Pages.

## Project Structure

- `src/main/kotlin/dev/chrisgaunt/` - Kotlin source files
  - `App.kt` - Main React component
  - `Client.kt` - Entry point for the application
- `src/main/resources/` - Static resources
  - `index.html` - HTML template

## Running Locally

To run the application locally:

```bash
./gradlew browserDevelopmentRun
```

This will start a development server and open the application in your default browser.

## Building for Production

To build the application for production:

```bash
./gradlew build
```

This will:
1. Compile the Kotlin code to JavaScript
2. Bundle all resources
3. Copy the distribution files to the `docs/` directory
4. Create a `.nojekyll` file in the `docs/` directory

## Deploying to GitHub Pages

1. Push the repository to GitHub
2. Go to the repository settings
3. In the "Pages" section:
   - Set the "Source" to "Deploy from a branch"
   - Select the branch (usually "main" or "master")
   - Set the folder to "/docs"
   - Click "Save"

GitHub will then deploy your site and provide a URL where it can be accessed.

## Technologies Used

- Kotlin/JS
- React
- Gradle