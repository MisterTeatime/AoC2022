# [Tag 6: Tuning Trouble](https://adventofcode.com/2022/day/6)

## Finden des Startmarkers und Beginn der Nachricht

* Die Eingabe wird mit `windowed()` in Gruppen aufgeteilt
* Die erste Gruppe, die nur unterschiedliche Zeichen enthält, ist die gesuchte Sequenz
* Wenn das Fenster gefunden wurde, wird der erste Index dieser Gruppe in der Eingabe (oder der transformierten Eingabe) gesucht => Index + Länge des Fensters ist die gesuchte Zahl

## Teil 1

Die Methode zur Ermittlung des Startmarkers und des Index, an dem die Nachricht beginnt, wird mit der Länge 4 aufgerufen. Damit wird der Start-Of-Packet gefunden.

**Lösung**: 1779

## Teil 2

Die Methode zur Ermittlung des Startmarkers und des Index, an dem die Nachricht beginnt, wird mit der Länge 14 aufgerufen. Damit wird der Start-Of-Messsage gefunden.

**Lösung**: 2635
