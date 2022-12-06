# [Tag 6: Tuning Trouble](https://adventofcode.com/2022/day/6)

## Übersicht

## Teil 1

### Überlegungen

* Die Eingabe wird mit `windowed(4, 1)` in Gruppen mit 4 Zeichen aufgeteilt
* Die erste Gruppe mit 4 unterschiedlichen Zeichen ist die gesuchte Sequenz
* Das gewünschte Ergebnis kann auf mehrere Arten ermittelt werden
  * **externe Zählvariable**: Beginnt bei 0, wird mit jedem Fenster erhöht => Counter + 4 (Länge des Fensters) ist die gesuchte Zahl
  * **Index des Fensters**: Wenn das Fenster gefunden wurde, wird der erste Index dieser Gruppe in der Eingabe (oder der transformierten Eingabe) gesucht => Index + 4 (Länge des Fensters) ist die gesuchte Zahl

## Teil 2
