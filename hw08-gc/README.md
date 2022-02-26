# 2021-12-otus-java-potekhin

### Студент: Потехин Александр Михайлович
#### Группа: java-2021-12
#### Курс: Java Developer. Professional

Задание № 4
Работа gc

Определение нужного размера хипа

----------------------------------------
Таблица с результатами замеров:

| heap size             | original time                     | optimization time        |
|-----------------------|-----------------------------------|--------------------------|
| -Xms256m -Xmx256m     | OutOfMemoryError: Java heap space | spend msec:10004, sec:10 |
| -Xms384m -Xmx384m     | spend msec:16933, sec:16          | spend msec:9813, sec:9   |
| -Xms512m -Xmx512m     | spend msec:15841, sec:15          | spend msec:9344, sec:9   |
| -Xms640m -Xmx640m     | spend msec:15756, sec:15          | spend msec:9112, sec:9   |
| -Xms768m -Xmx768m     | spend msec:14886, sec:14          | spend msec:9063, sec:9   |
| -Xms896m -Xmx896m     | spend msec:15323, sec:15          | spend msec:8338, sec:8   |
| -Xms1024m -Xmx1024m   | spend msec:14680, sec:14          | spend msec:8000, sec:8   |
| -Xms1152m -Xmx1152m   | spend msec:14686, sec:14          | spend msec:7609, sec:7   |
| -Xms1280m -Xmx1280m   | spend msec:14717, sec:14          | spend msec:7484, sec:7   |
| -Xms1408m -Xmx1408m   | spend msec:14323, sec:14          | spend msec:7000, sec:7   |
| -Xms1536m -Xmx1536m   | spend msec:14105, sec:14          | spend msec:6729, sec:6   |
| -Xms1664m -Xmx1664m   | spend msec:13831, sec:13          | spend msec:6328, sec:6   |
| `-Xms1792m -Xmx1792m` | `spend msec:13202, sec:13`        | spend msec:5990, sec:5   |
| -Xms1920m -Xmx1920m   | spend msec:13553, sec:13          | spend msec:5703, sec:5   |
| -Xms2048m -Xmx2048m   | spend msec:13372, sec:13          | spend msec:5500, sec:5   |
| -Xms2176m -Xmx2176m   | spend msec:13655, sec:13          | spend msec:5501, sec:5   |
| -Xms2304m -Xmx2304m   | spend msec:13913, sec:13          | spend msec:5515, sec:5   |
| `-Xms2432m -Xmx2432m` | `spend msec:13303, sec:13`        | spend msec:5687, sec:5   |
| -Xms2560m -Xmx2560m   | spend msec:13573, sec:13          ||
| `-Xms2688m -Xmx2688m` | `spend msec:13180, sec:13`        | spend msec:5735, sec:5   |
| -Xms2816m -Xmx2816m   | spend msec:13573, sec:13          ||
| -Xms2944m -Xmx2944m   | spend msec:13584, sec:13          ||
| `-Xms3072m -Xmx3072m` | `spend msec:13248, sec:13`        | spend msec:5892, sec:5   |
| -Xms3200m -Xmx3200m   | spend msec:13647, sec:13          ||
| `-Xms3328m -Xmx3328m` | `spend msec:13113, sec:13`        | spend msec:5859, sec:5   |
| `-Xms3456m -Xmx3456m` | `spend msec:13084, sec:13`        | spend msec:5954, sec:5   |
| -Xms3584m -Xmx3584m   | spend msec:13480, sec:13          | spend msec:5938, sec:5   |
| -Xms4096m -Xmx4096m   | spend msec:13824, sec:13          | spend msec:6176, sec:6   |


