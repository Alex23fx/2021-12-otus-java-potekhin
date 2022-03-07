# 2021-12-otus-java-potekhin

### Студент: Потехин Александр Михайлович
#### Группа: java-2021-12
#### Курс: Java Developer. Professional

Задание № 4
Работа gc

Определение нужного размера хипа

## Вывод
### В результате выполнения практической работы, было наглядно продемонстрировано о необходимости разумного применение типов и конструкций языка Java. Так же в ходе выполнения, было наглядно продемонстрировано, что недостаток памяти, приводит к замедлению работы программы, а избыток не дает существенного выигрыша в скорости. Оптимальный размет heap равен размеру, необходимому для размещения всех объектов программы в памяти. 
----------------------------------------
Таблица с результатами замеров:

| №   | heap size             | original time                     | optimization time      |
|-----|-----------------------|-----------------------------------|------------------------|
| 1   | -Xms256m -Xmx256m     | OutOfMemoryError: Java heap space | spend msec:984, sec:0  |
| 2   | -Xms384m -Xmx384m     | spend msec:16933, sec:16          | spend msec:1000, sec:1 |
| 3   | -Xms512m -Xmx512m     | spend msec:15841, sec:15          | spend msec:1000, sec:1 |
| 4   | -Xms640m -Xmx640m     | spend msec:15756, sec:15          | spend msec:1000, sec:1 |
| 5   | -Xms768m -Xmx768m     | spend msec:14886, sec:14          | spend msec:984, sec:0  |
| 6   | -Xms896m -Xmx896m     | spend msec:15323, sec:15          | spend msec:1000, sec:1 |
| 7   | -Xms1024m -Xmx1024m   | spend msec:14680, sec:14          | spend msec:969, sec:0  |
| 8   | -Xms1152m -Xmx1152m   | spend msec:14686, sec:14          | spend msec:1000, sec:1 |
| 9   | -Xms1280m -Xmx1280m   | spend msec:14717, sec:14          | spend msec:1000, sec:1 |
| 10  | -Xms1408m -Xmx1408m   | spend msec:14323, sec:14          | spend msec:984, sec:0  |
| 11  | -Xms1536m -Xmx1536m   | spend msec:14105, sec:14          | spend msec:984, sec:0  |
| 12  | -Xms1664m -Xmx1664m   | spend msec:13831, sec:13          | spend msec:1000, sec:1 |
| 13  | `-Xms1792m -Xmx1792m` | `spend msec:13202, sec:13`        | spend msec:1000, sec:1 |
| 14  | -Xms1920m -Xmx1920m   | spend msec:13553, sec:13          | spend msec:984, sec:0  |
| 15  | -Xms2048m -Xmx2048m   | spend msec:13372, sec:13          | spend msec:1000, sec:1 |
| 16  | -Xms2176m -Xmx2176m   | spend msec:13655, sec:13          | spend msec:1000, sec:1 |
| 17  | -Xms2304m -Xmx2304m   | spend msec:13913, sec:13          | spend msec:1000, sec:1 |
| 18  | `-Xms2432m -Xmx2432m` | `spend msec:13303, sec:13`        | spend msec:1000, sec:1 |
| 19  | -Xms2560m -Xmx2560m   | spend msec:13573, sec:13          | spend msec:1000, sec:1 |
| 20  | `-Xms2688m -Xmx2688m` | `spend msec:13180, sec:13`        | spend msec:1000, sec:1 |
| 21  | -Xms2816m -Xmx2816m   | spend msec:13573, sec:13          | spend msec:1000, sec:1 |
| 22  | -Xms2944m -Xmx2944m   | spend msec:13584, sec:13          | spend msec:984, sec:0  |
| 23  | `-Xms3072m -Xmx3072m` | `spend msec:13248, sec:13`        | spend msec:1000, sec:1 |
| 24  | -Xms3200m -Xmx3200m   | spend msec:13647, sec:13          | spend msec:1000, sec:1 |
| 25  | `-Xms3328m -Xmx3328m` | `spend msec:13113, sec:13`        | spend msec:1000, sec:1 |
| 26  | `-Xms3456m -Xmx3456m` | `spend msec:13084, sec:13`        | spend msec:1000, sec:1 |
| 27  | -Xms3584m -Xmx3584m   | spend msec:13480, sec:13          | spend msec:1000, sec:1 |
| 28  | -Xms4096m -Xmx4096m   | spend msec:13824, sec:13          | spend msec:1000, sec:1 |


