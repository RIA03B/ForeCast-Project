# My ForeCast  

---  

Design Document  

Rania Ibrahim, Ali Ibrahim, Ben Momeni  

## Introduction  

Do you wonder what the weather will be today? Do you know what the weather looks like in a few days? MyForecast can help you:
- Display current temperature/ weather condition.
- Display feel like of the weather for the day.
- Display humidity of the weather for the day.
-	Display a decription of the weather for the days.
-	Display the wind speed.
-	Display level of cloudiness for the day.
-	Display the level of pressure for the day .  

Forecasts can be used to plan activities around these events, and to plan ahead and survive them. Use your Android device to check your daily weather or the weather for a location you plan on visiting for the day.  

## Storyboard  

[Forecast storyboard](https://1drv.ms/p/s!Anzr06X31ysqhjy1Eov89PM9rUyf?e=9kuLYc)  

![Forecast](https://user-images.githubusercontent.com/56984616/118527242-18005700-b70f-11eb-9fbf-e73b5e77fc29.png)  

## Functional Requirments  

### Requirment 100:The weather for today  

#### Senario  

As a user I want to be able to know the weather for today based on: how it feels like outside, the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.  

#### Dependencies  

- The device will use the location the user enters for a location to determine the weather.  

- Weather data are available and accessible.  

#### Assumptions 

- Unit system in Metric.  

#### Examples  

1.1  

**Given** the weather for the day based on how it feels like outside,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed based on user’s entery for location.  

**When** user types the name if the city.  

**Then** the weather for that city will display how it feels like,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.      


### Requirment 101:The weather for a city in a different country  

#### Senario  

As a user I want to be able to know the weather for a city in a different country. As well as be able to know how it feels like,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.  

#### Dependencies  

- The device will use the location the user enters for a location to determine the weather.  

- Weather data are available and accessible.  
  

#### Assumptions 

- Unit system in Metric. 

#### Examples  

1.1  

**Given** the weather for a city in a different country. As well as be able to know how it feels like,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.    

**When** user types the name of the city and country.  

**Then** the weather for that city and country will display how it feels like,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.      

  

### Class Diagram  

![ClassDirectory](https://user-images.githubusercontent.com/56984616/118529235-4bdc7c00-b711-11eb-8af9-f43ecb35433a.png)  

### Class Diagram Description  

**Main Activity:** In the main screen the user will be able to see current temperature/ weather condition, how it feels like,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.    

**DataActivity:** In the main screen the user will be able to see details of the weather selected for any city in any country displaying current temperature/ weather condition, how it feels like,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.  

**Volley:** Use Volley, which is an HTTP library that makes networking for Android apps easier and most importantly, faster.Volley excels at RPC-type operations used to populate a UI, such as fetching a page of search results as structured data. It integrates easily with any protocol and comes out of the box with support for raw strings, images, and JSON.  

**Json:** Use json object from the string response.  

**Weather:** The screen the user sees will display current temperature/ weather condition, how it feels like,  the wind, humidity, description of the weather, cloudiness, pressure, and wind speed.  

**IDAO:** Interface for weather data. Define a final string variable to store the url and define a final string variable to store the app id. 

### Scrum Roles  

- DevOps/Product Owner/Scrum Master: Rania Ibrahim  

-	Frontend Developer: Ali Ibrahim  

-	Integration Developer: Ben Momeni  

### Weekly Meeting  

Wednesday at 5 PM. Use this Microsoft Teams:  
https://teams.microsoft.com/l/meetup-join/19%3ameeting_NmJlZjdhZjQtZDFiMi00NjhhLTgyYzQtZDAwMGRlZmEwMDgz%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%226e862e08-9333-40a7-8d35-a86bba5e38fc%22%7d  







