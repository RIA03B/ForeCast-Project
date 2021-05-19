# My ForeCast  

---  

Design Document  

Rania Ibrahim, Ali Ibrahim, Ben Momeni  

## Introduction  

Do you wonder what the weather will be today? Do you know what the weather looks like in a few days? MyForecast can help you:
- Display current temperature/ weather condition.
- Display winds of the weather for the day.
- Display visibility of the weather for the day.
-	Display the weather for the next seven days.
-	Display the weather for different locations.
-	Ability to change unit system.  

Forecasts can be used to plan activities around these events, and to plan ahead and survive them. Use your Android device to check your daily weather. See the forecast for the next 7 days of your location or any other location simply by changing the location.  

## Storyboard  

[Forecast storyboard](https://1drv.ms/p/s!Anzr06X31ysqhjy1Eov89PM9rUyf?e=9kuLYc)  

![Forecast](https://user-images.githubusercontent.com/56984616/118527242-18005700-b70f-11eb-9fbf-e73b5e77fc29.png)  

## Functional Requirments  

### Requirment 100:The weather for today  

#### Senario  

As a user I want to be able to know the weather for today based on: how it feels like outside, the wind, precipitation, and visibility.  

#### Dependencies  

- The device will use user’s location to determine the weather.  

- Weather data are available and accessible.  

#### Assumptions 

- Unit system in Metric.  

- Unit system in Imperial.  

#### Examples  

1.1  

**Given** the weather for the day based on how it feels like outside, the wind, precipitation, and visibility based on user’s location.  

### Requirment 101:The weather for the next seven days  

#### Senario  

As a user I want to be able to know the weather for the next seven days based on: how it feels like outside, the wind, precipitation, and visibility.  

#### Dependencies  

- The device will use user’s location to determine the weather.  

- Weather data are available and accessible.  

#### Assumptions 

- Unit system in Metric.  

- Unit system in Imperial.  

#### Examples  

1.1  

**Given** the weather for the next seven days based on how it feels like outside, the wind, precipitation, and visibility based on user’s location.  

**When** select the day you would like to view the weather for.  

**Then** the weather for the next seven days based on how it feels like outside, the wind, precipitation, and visibility will be displayed.  

### Requirment 102:Change Weather unit system   

#### Senario  

As a user I want to be able to know the weather in different unit systems based on the Metric system or the Imperial system.  

#### Dependencies  

- Weather data are available and accessible.  

#### Assumptions 

- Unit system in Metric.  

- Unit system in Imperial.  

#### Examples  

1.1  

**Given** two different unit systems.

**When** selecting either of the unit systems.  

**Then** I will be able to see a change in unit system next to the temperature of the weather on the main page.  

### Requirment 103:Change Location  

#### Senario  

As a user I want to be able to know the weather in different locations of the world.  

#### Dependencies  

- The device will use user’s location to determine the weather.  

- Weather data are available and accessible.  

#### Assumptions 

- Unit system in Metric.  

- Unit system in Imperial.  

#### Examples  

1.1  

**Given** search area for a location.

**When** selecting a location.  

**Then** I will be able to see that specified locations weather on the main page.  

### Class Diagram  

![ClassDirectory](https://user-images.githubusercontent.com/56984616/118529235-4bdc7c00-b711-11eb-8af9-f43ecb35433a.png)  

### Class Diagram Description  

**Main Activity:** The first screen the user sees will display current temperature/ weather condition, wind, and visibility for that day.  

**Weather:** The first screen the user sees will display current temperature/ weather condition, wind, and visibility for that day.  

**SevenDayWeather:** A screen that shows the weather for the next seven day.  

**SevenDayWeatherDataActivity:** A screen that shows details of the weather selected for the next seven day.  

**RetrofitInstance:** Boostrap class required for Retrofit.  

**Weather:** The first screen the user sees will display current temperature/ weather condition, wind, and visibility for that day.  

**IForecastDAO:** Interface for Retrofit for weather JSON.  

**ISevenDayWeatherDAO:** Interface for weather data.  

### Scrum Roles  

- DevOps/Product Owner/Scrum Master: Rania Ibrahim  

-	Frontend Developer: Ali Ibrahim  

-	Integration Developer: Ben Momeni  

### Weekly Meeting  

Wednesday at 5 PM. Use this Microsoft Teams:  
https://teams.microsoft.com/l/meetup-join/19%3ameeting_NmJlZjdhZjQtZDFiMi00NjhhLTgyYzQtZDAwMGRlZmEwMDgz%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%226e862e08-9333-40a7-8d35-a86bba5e38fc%22%7d  







