# [Tag 20: Grove Positioning System](https://adventofcode.com/2022/day/20)

## Überlegungen

Um die Verschiebungen nicht schrittweise simulieren zu müssen, sollte ein Weg gefunden werden wie der Zielindex direkt berechnet werden kann. Problematisch ist hierbei der Umgang mit Überlauf (also, wenn die Bewegung über die Indexgrenze hinaus geht).

### Modulo

Der offensichtliche Ansatz ist, den Index mit der Modulo Funktion zu berechnen. Hierbei ist die ringförmige Struktur der Liste zu beachten. Diese führt dazu, dass `A B C D E` die gleiche Liste ist wie `B C D E A` mit $mod size$ sind aber beide Positionen unterschiedlich. Der "Trick" ist daher, eine der beiden Positionen zu ignorieren. Am einfachsten geht es mit der letzten Position, weil sie mit $mod (size - 1)$ ausgeblendet werden kann.

Das bedeutet, dass der neue Index mit dieser Formel berechnet werden kann:
```text
newIndex = (index + steps).mod(size)
```

Dabei ist zu beachten, dass wirklich `mod()` verwendet wird! Bis Kotlin 1.4 hatte `mod()` das gleiche Verhalten wie `%` (oder `rem()`). Das Ergebnis ist 0 oder eine Zahl mit dem gleichen Vorzeichen wie der Dividend (also die Zahl die geteilt werden soll). Mit Kotlin 1.5 wurde `mod()` neu definiert und liefert jetzt 0 oder eine Zahl mit dem gleichen Vorzeichen wie der Divisor (also die Zahl die teilt).

### Beispiele

```text
5 mod 3 = 2
5 % 3 = 2

(-5) mod 3 = 1
(-5) % 3 = -2

5 mod (-3) = -1
5 % (-3) = 2

(-5) mod (-3) = -2
(-5) % (-3) = -2
```

## Teil 1




## Teil 2
