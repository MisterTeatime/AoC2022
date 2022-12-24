#[Tag 22: Monkey Map](https://adventofcode.com/2022/day/22)

## Überlegungen

### Blickrichtung

Die Blickrichtung hat einen Wert zwischen 0 und 3 und zeigt an in welche Richtung aktuell geblickt wird.

| Wert | Richtung |
|------|----------|
| 0    | Rechts   |
| 1    | Abwärts  |
| 2    | Links    |
| 3    | Aufwärts |

Wenn die Drehungen durch die Werte -1 für Linksdrehung und 1 für Rechtsdrehung dargestellt werden, dann kann die neue Blickrichtung durch $(facing \pm 1).mod(4)$ berechnet werden.

## Teil 1

## Teil 2
