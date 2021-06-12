# DVT Interview Solution
Interview Solution App using [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/), in 100% Kotlin

## Background
Create a weather application to display the current weather at the user’s location and a 5-day forecast.

1) You are required to implement one of 2 designs, the Forest design or the Sea design (see iOS Screen Designs or Android Screen Designs folders). You can choose either one.
2) The forecast must be based on the user’s current location.
3) The application should connect to the following API to collect the weather information. 
      * https://openweathermap.org/current 
      * https://openweathermap.org/forecast5
5) You will be required to change the background image depending on the type of weather (Cloudy, Sunny and Rainy). Please use the provided assets and icons.

## Tech-stack

* Tech-stack
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
    * MVVM - Model View View Model
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/)) - a simple framework to write repeatable tests.
    * [UI Tests]() ([Espresso](https://developer.android.com/training/testing/espresso)) - concise and reliable Android UI testing framework.

## UI and Unit Tests
#### Unit Tests on Presentation Layer

The Unit Tests here test ViewModel

<img src="https://github.com/mijiga/Weather-App/blob/main/screenshots/weather_presentation_unit_test.PNG">

More tests can be added

## Theme & Design
  * Theme colors generated using the [Material Color Tool](https://material.io/resources/color/)

## Issues
  * The [Forecast endpoint](https://openweathermap.org/forecast5) serves data for every 3 hours and not single day(premium feature) as suggested in the provided design

