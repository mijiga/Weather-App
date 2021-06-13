# Weather App
An Android app consuming the [Open Weather Map API](https://openweathermap.org/), built on the MVVM pattern with clean architecture principles and Architecture Components.

Based on the user's location, the app displays the current day's forecast as well as that of the upcoming 5 days. The app's theme changes based on the current weather type(cloudy, rainy, sunny).

## Tech-stack

* Libraries
    * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations.
    * [Dagger-Hilt](https://dagger.dev/hilt/) - a standard way to incorporate Dagger dependency injection into an Android application
    * [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android.
    * [Jetpack](https://developer.android.com/jetpack)
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - is an observable data holder.
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes.
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way.
   * [Easy Permisisons](https://github.com/googlesamples/easypermissions) - a wrapper library to simplify basic system permissions logic.
* Architecture
    * MVVM - Model View ViewModel
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/)) - a simple framework to write repeatable tests.
    * [UI Tests]() ([Espresso](https://developer.android.com/training/testing/espresso)) - concise and reliable Android UI testing framework.
 * CI/CD
    * Github Actions    

## UI and Unit Tests
#### Unit Tests on Presentation Layer

The Unit Tests here test ViewModel

<img src="https://github.com/mijiga/Weather-App/blob/main/screenshots/weather_presentation_unit_test.PNG">

More tests can be added

## Theme & Design
  * Theme colors generated using the [Material Color Tool](https://material.io/resources/color/)

## Issues
  * The [Forecast endpoint](https://openweathermap.org/forecast5) serves data for every 3 hours and not single day(premium feature) as suggested in the provided design

