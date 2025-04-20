# Demo code

[![API](https://img.shields.io/badge/API-29%2B-yellow.svg?style=flat)](https://developer.android.com/about/versions/10)
[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org)
[![LICENSE](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/chih87s/database-migration-tool/blob/main/LICENSE)

## Table of Contents
- [Environment Setup](#environment-setup)
- [Architecture](#architecture)

## Environment Setup
To set up the development environment, make sure you have the following installed:
### Android Studio
`Android Studio Ladybug | 2024.2.2 Patch 1`
### Gradle
`Gradle Version 8.9 +`

## Architecture
The **Project** employs a **MVVM (Model-View-ViewModel) Clean Architecture** pattern, which facilitates a clear separation of concerns and promotes scalability, maintainability, and testability. This architecture divides the application into distinct layers:

- **UI Layer**: The UI is built using Jetpack Compose, and it automatically adjusts to different screen orientations.

- **Domain Layer**: Handles business logic and interacts with the Repository layer to fetch recipe data.

- **Data Layer**:
  - **Repository**: Provides data sources and handles fetching data from the server.
  - **Models**:
    -**UI Model**: These models are specifically designed for UI representation.
    -**Remote Model**: These models are used for parsing the data from the response.
    -**Mapper**: Convert remote model to ui model
