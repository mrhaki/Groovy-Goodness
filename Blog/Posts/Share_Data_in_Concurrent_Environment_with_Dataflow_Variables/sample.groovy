$ groovy citytemp.groovy Tilburg,NL
Task 'convertTemperature' is waiting for dataflow variable 'cityWeather'
Task 'parseCity' is waiting for dataflow variable 'searchCity'
Task 'findCityWeather' is waiting for dataflow variable 'searchCity'
Task 'findCityWeather' got dataflow variable 'searchCity'
Task 'parseCity' got dataflow variable 'searchCity'
Main thread is waiting for dataflow variables 'cityWeather', 'temperature' and 'cityName'
Variable 'searchCity' bound to 'Tilburg,NL'
Variable 'cityName' bound to 'Tilburg'
Task 'convertTemperature' got dataflow variable 'cityWeather'
Variable 'cityWeather' bound to '[city:Tilburg,NL, temperature:11.76]'
Variable 'temperature' bound to '53.167999999999985'

Temperature in city Tilburg (searched with Tilburg,NL):
11.76 Celcius
53.167999999999985 Fahrenheit
