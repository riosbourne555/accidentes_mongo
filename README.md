# Este proyecto permite realizar 5 consultas diferentes a un conjunto de aproximadamente 3 millones de accidentes en EEUU (año 2019)
# almacenados en una base de datos MongoDB.
# Las siguientes consultas son posibles:

1. Devolver todos los accidentes ocurridos entre 2 fechas dadas
    * endpoint: http://localhost:9090/api/from/{fecha1}/to/{fecha2}
    # Formato de Fechas: {yyyy-MM-dd HH:mm:ss)

2. Determinar las condiciones más comunes en los accidentes (condiciones climáticas)
    * endpoint: http://localhost:9090/api/WeatherCondition

3. Dado un punto geográfico y un radio (expresado en kilómetros) y devolver todos los accidentes ocurridos dentro del radio.
    * endpoint: http://localhost:9090/api/{latitud}/{longitud}/{radio_Km}

4. Devolver los 5 puntos más peligrosos (definiendo un determinado radio)
    * endpoint: http://localhost:9090/api/severity/{latitud}/{longitud}/{radio_Km}

5. Obtener la distancia promedio desde el inicio al fin del accidente
    * endpoint: http://localhost:9090/api/DistanciaPromedio

# grupo del proyecto: Cristian Emmanuel Rios, Emmanuel Portugal.