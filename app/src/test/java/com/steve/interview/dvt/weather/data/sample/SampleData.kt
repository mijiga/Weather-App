package com.steve.interview.dvt.weather.data.sample

import com.google.gson.Gson
import com.steve.interview.dvt.weather.R
import com.steve.interview.dvt.weather.data.model.CurrentWeather
import com.steve.interview.dvt.weather.data.model.ForecastResponse

private val gson = Gson()

var testTheme = 0

var testWeatherCode = 800
var testStyle = R.style.Theme_Sunny

val weatherString = "{\n" +
    "    \"coord\": {\n" +
    "        \"lon\": 33.7873,\n" +
    "        \"lat\": -13.9669\n" +
    "    },\n" +
    "    \"weather\": [\n" +
    "        {\n" +
    "            \"id\": 800,\n" +
    "            \"main\": \"Clear\",\n" +
    "            \"description\": \"clear sky\",\n" +
    "            \"icon\": \"01d\"\n" +
    "        }\n" +
    "    ],\n" +
    "    \"base\": \"stations\",\n" +
    "    \"main\": {\n" +
    "        \"temp\": 21.11,\n" +
    "        \"feels_like\": 20.48,\n" +
    "        \"temp_min\": 21.11,\n" +
    "        \"temp_max\": 21.11,\n" +
    "        \"pressure\": 1022,\n" +
    "        \"humidity\": 46,\n" +
    "        \"sea_level\": 1022,\n" +
    "        \"grnd_level\": 905\n" +
    "    },\n" +
    "    \"visibility\": 10000,\n" +
    "    \"wind\": {\n" +
    "        \"speed\": 2.68,\n" +
    "        \"deg\": 121,\n" +
    "        \"gust\": 3.86\n" +
    "    },\n" +
    "    \"clouds\": {\n" +
    "        \"all\": 0\n" +
    "    },\n" +
    "    \"dt\": 1621409120,\n" +
    "    \"sys\": {\n" +
    "        \"type\": 1,\n" +
    "        \"id\": 2259,\n" +
    "        \"country\": \"MW\",\n" +
    "        \"sunrise\": 1621396701,\n" +
    "        \"sunset\": 1621437874\n" +
    "    },\n" +
    "    \"timezone\": 7200,\n" +
    "    \"id\": 927967,\n" +
    "    \"name\": \"Lilongwe\",\n" +
    "    \"cod\": 200\n" +
    "}"

val forecastString = "{\n" +
    "    \"cod\": \"200\",\n" +
    "    \"message\": 0,\n" +
    "    \"cnt\": 5,\n" +
    "    \"list\": [\n" +
    "        {\n" +
    "            \"dt\": 1621414800,\n" +
    "            \"main\": {\n" +
    "                \"temp\": 21.39,\n" +
    "                \"feels_like\": 21.02,\n" +
    "                \"temp_min\": 21.39,\n" +
    "                \"temp_max\": 24.16,\n" +
    "                \"pressure\": 1024,\n" +
    "                \"sea_level\": 1024,\n" +
    "                \"grnd_level\": 905,\n" +
    "                \"humidity\": 55,\n" +
    "                \"temp_kf\": -2.77\n" +
    "            },\n" +
    "            \"weather\": [\n" +
    "                {\n" +
    "                    \"id\": 800,\n" +
    "                    \"main\": \"Clear\",\n" +
    "                    \"description\": \"clear sky\",\n" +
    "                    \"icon\": \"01d\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"clouds\": {\n" +
    "                \"all\": 4\n" +
    "            },\n" +
    "            \"wind\": {\n" +
    "                \"speed\": 2.6,\n" +
    "                \"deg\": 89,\n" +
    "                \"gust\": 3.8\n" +
    "            },\n" +
    "            \"visibility\": 10000,\n" +
    "            \"pop\": 0,\n" +
    "            \"sys\": {\n" +
    "                \"pod\": \"d\"\n" +
    "            },\n" +
    "            \"dt_txt\": \"2021-05-19 09:00:00\"\n" +
    "        },\n" +
    "        {\n" +
    "            \"dt\": 1621425600,\n" +
    "            \"main\": {\n" +
    "                \"temp\": 24.15,\n" +
    "                \"feels_like\": 23.56,\n" +
    "                \"temp_min\": 24.15,\n" +
    "                \"temp_max\": 26.22,\n" +
    "                \"pressure\": 1019,\n" +
    "                \"sea_level\": 1019,\n" +
    "                \"grnd_level\": 903,\n" +
    "                \"humidity\": 36,\n" +
    "                \"temp_kf\": -2.07\n" +
    "            },\n" +
    "            \"weather\": [\n" +
    "                {\n" +
    "                    \"id\": 801,\n" +
    "                    \"main\": \"Clouds\",\n" +
    "                    \"description\": \"few clouds\",\n" +
    "                    \"icon\": \"02d\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"clouds\": {\n" +
    "                \"all\": 22\n" +
    "            },\n" +
    "            \"wind\": {\n" +
    "                \"speed\": 3.37,\n" +
    "                \"deg\": 75,\n" +
    "                \"gust\": 3.88\n" +
    "            },\n" +
    "            \"visibility\": 10000,\n" +
    "            \"pop\": 0,\n" +
    "            \"sys\": {\n" +
    "                \"pod\": \"d\"\n" +
    "            },\n" +
    "            \"dt_txt\": \"2021-05-19 12:00:00\"\n" +
    "        },\n" +
    "        {\n" +
    "            \"dt\": 1621436400,\n" +
    "            \"main\": {\n" +
    "                \"temp\": 20.96,\n" +
    "                \"feels_like\": 20.1,\n" +
    "                \"temp_min\": 20.96,\n" +
    "                \"temp_max\": 20.96,\n" +
    "                \"pressure\": 1018,\n" +
    "                \"sea_level\": 1018,\n" +
    "                \"grnd_level\": 902,\n" +
    "                \"humidity\": 38,\n" +
    "                \"temp_kf\": 0\n" +
    "            },\n" +
    "            \"weather\": [\n" +
    "                {\n" +
    "                    \"id\": 803,\n" +
    "                    \"main\": \"Clouds\",\n" +
    "                    \"description\": \"broken clouds\",\n" +
    "                    \"icon\": \"04d\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"clouds\": {\n" +
    "                \"all\": 75\n" +
    "            },\n" +
    "            \"wind\": {\n" +
    "                \"speed\": 3.48,\n" +
    "                \"deg\": 68,\n" +
    "                \"gust\": 6.97\n" +
    "            },\n" +
    "            \"visibility\": 10000,\n" +
    "            \"pop\": 0,\n" +
    "            \"sys\": {\n" +
    "                \"pod\": \"d\"\n" +
    "            },\n" +
    "            \"dt_txt\": \"2021-05-19 15:00:00\"\n" +
    "        },\n" +
    "        {\n" +
    "            \"dt\": 1621447200,\n" +
    "            \"main\": {\n" +
    "                \"temp\": 16.91,\n" +
    "                \"feels_like\": 15.99,\n" +
    "                \"temp_min\": 16.91,\n" +
    "                \"temp_max\": 16.91,\n" +
    "                \"pressure\": 1020,\n" +
    "                \"sea_level\": 1020,\n" +
    "                \"grnd_level\": 903,\n" +
    "                \"humidity\": 51,\n" +
    "                \"temp_kf\": 0\n" +
    "            },\n" +
    "            \"weather\": [\n" +
    "                {\n" +
    "                    \"id\": 804,\n" +
    "                    \"main\": \"Clouds\",\n" +
    "                    \"description\": \"overcast clouds\",\n" +
    "                    \"icon\": \"04n\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"clouds\": {\n" +
    "                \"all\": 88\n" +
    "            },\n" +
    "            \"wind\": {\n" +
    "                \"speed\": 1.77,\n" +
    "                \"deg\": 132,\n" +
    "                \"gust\": 3.42\n" +
    "            },\n" +
    "            \"visibility\": 10000,\n" +
    "            \"pop\": 0,\n" +
    "            \"sys\": {\n" +
    "                \"pod\": \"n\"\n" +
    "            },\n" +
    "            \"dt_txt\": \"2021-05-19 18:00:00\"\n" +
    "        },\n" +
    "        {\n" +
    "            \"dt\": 1621458000,\n" +
    "            \"main\": {\n" +
    "                \"temp\": 14.72,\n" +
    "                \"feels_like\": 14.02,\n" +
    "                \"temp_min\": 14.72,\n" +
    "                \"temp_max\": 14.72,\n" +
    "                \"pressure\": 1020,\n" +
    "                \"sea_level\": 1020,\n" +
    "                \"grnd_level\": 901,\n" +
    "                \"humidity\": 68,\n" +
    "                \"temp_kf\": 0\n" +
    "            },\n" +
    "            \"weather\": [\n" +
    "                {\n" +
    "                    \"id\": 804,\n" +
    "                    \"main\": \"Clouds\",\n" +
    "                    \"description\": \"overcast clouds\",\n" +
    "                    \"icon\": \"04n\"\n" +
    "                }\n" +
    "            ],\n" +
    "            \"clouds\": {\n" +
    "                \"all\": 100\n" +
    "            },\n" +
    "            \"wind\": {\n" +
    "                \"speed\": 1.38,\n" +
    "                \"deg\": 169,\n" +
    "                \"gust\": 2.24\n" +
    "            },\n" +
    "            \"visibility\": 10000,\n" +
    "            \"pop\": 0,\n" +
    "            \"sys\": {\n" +
    "                \"pod\": \"n\"\n" +
    "            },\n" +
    "            \"dt_txt\": \"2021-05-19 21:00:00\"\n" +
    "        }\n" +
    "    ],\n" +
    "    \"city\": {\n" +
    "        \"id\": 927967,\n" +
    "        \"name\": \"Lilongwe\",\n" +
    "        \"coord\": {\n" +
    "            \"lat\": -13.9669,\n" +
    "            \"lon\": 33.7873\n" +
    "        },\n" +
    "        \"country\": \"MW\",\n" +
    "        \"population\": 646750,\n" +
    "        \"timezone\": 7200,\n" +
    "        \"sunrise\": 1621396701,\n" +
    "        \"sunset\": 1621437874\n" +
    "    }\n" +
    "}"

val testWeather: CurrentWeather = gson.fromJson(weatherString, CurrentWeather::class.java)

val testForecastResponse: ForecastResponse =
    gson.fromJson(forecastString, ForecastResponse::class.java)
