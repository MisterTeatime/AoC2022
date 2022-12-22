# [Tag 20: Grove Positioning System](https://adventofcode.com/2022/day/20)

## Überlegungen

Um die Verschiebungen nicht schrittweise simulieren zu müssen, sollte ein Weg gefunden werden wie der Zielindex direkt berechnet werden kann. Problematisch ist hierbei der Umgang mit Überlauf (also, wenn die Bewegung über die Indexgrenze hinaus geht).

### Modulo

Der offensichtliche Ansatz ist, den Index mit der Modulo Funktion zu berechnen. Hierbei ist die ringförmige Struktur der Liste zu beachten. Diese führt dazu, dass `A B C D E` die gleiche Liste ist wie `B C D E A` mit `mod size` sind aber beide Positionen unterschiedlich. Der "Trick" ist daher, eine der beiden Positionen zu ignorieren. Am einfachsten geht es mit der letzten Position, weil sie mit `mod (size - 1)` ausgeblendet werden kann.

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

Die Eingabe wird zuerst in *Int* umgewandelt und dann jedem Element sein Index zugeordnet und so ein `Pair<Int, Int>` pro Eintrag erzeugt.

Das Mixing selbst wird auf einer Kopie der transformierten Eingabe `encrypted` als *MutableList<Pair<Int, Int>>* `decrypted` durchgeführt.

Für jeden Eintrag in der `encrypted` wird der Index des aktuellen Elements in `decrypted` anhand des Elements-Index bestimmt. Der neue Index wird mit `(index + steps).mod(size - 1)` berechnet und dann die Verschiebung vorgenommen. Dazu wird eine Extensionmethode verwendet.

Nach dem Abarbeiten der Liste wird das Element `0` gesucht und von dort ausgehend die Werte der Elemente an Stelle 1000, 2000 und 3000 bestimmt. Auch das kann mit Modulus erreicht werden. Der effektive Index in der Liste ist: `(<gewünschter Index> + <Startindex>) mod <Listengröße>`.

Das Ergebnis ist die Summe der drei Werte.

**Lösung**: 2203

## Teil 2

Teil 2 ist von der Berechnung her identisch mit Teil 1. Alle Elemente werden mit dem Verschlüsselungswert multipliziert und das Mixing wird mit `repeat(10) {...}` 10 Mal durchgeführt.
Da mit deutlich größeren Werten zu arbeiten ist, wird mit *Long* anstatt *Int* gearbeitet.

**Lössung**: 6641234038999
