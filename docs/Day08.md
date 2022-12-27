# [Tag 8: Treetop Tree House](https://adventofcode.com/2022/day/8)

## Überlegungen

- Beim Parsen wird eine Liste der Reihen und Spalten angelegt
- Für die Auswertung, ob ein Baum sichtbar ist, werden dann die entsprechenden Spalten und Zeilen genommen und geprüft
  - Ob der Baum an Position (1,1) \[5\] sichtbar ist, wird `reihen[1]` und `spalten[1]` ausgewertet

### Beispiel

```text
30373
25512
65332
33549
35390

reihen = ["30373", "25512", "65332", "33549", "35390"]
spalten = ["32633", "05535", "35353", "71349", "32290"]

```

## Teil 1

Wie in den Überlegungen beschrieben wird zu den Zeilen auch eine Liste der Spalten erzeugt.

Für jeden Baum wird geprüft, ob er sichtbar ist. Für die Lösung wird gezählt wie viele Positionen sichtbar sind.

```kotlin
fun isVisible(group: String, pos: Int, item: Int): Boolean
```

*group* wird in die Positionen vor und die Positionen nach der angegebenen Position aufgeteilt und die *Char* Einträge in *Int* umgewandelt. Für die Rückgabe wird geprüft, ob alle Einträge in *before* und *after* kleiner sind wie der Wert an der angegebenen Position

**Lösung**: 1679

## Teil 2

Wie schon in Teil 1 wird eine Liste der Spalten erzeugt.

Für jede Position wird der Scenic Score errechnet. 'getScenicScore()' berechnet den Score für ein Element in der angegebenen Gruppe  (also Zeile oder Spalte). Der Gesamtscore ist dann das Produkt des Scores für Zeile und Spalte.

```kotlin
fun getScenicScore(group: String, pos: Int): Int
```

Wie bei `isInvisible()` wird die Gruppe in zwei Teile *before* und *after* aufgeteilt. Für jeden Teil wird die ausgehend von der angegebenen Position so viele Elemente genommen, bis das erste größer oder gleich dem Wert der Position ist. Die Anzahl der Elemente ist der gesuchte Wert. Falls nicht alle Elemente die Bedingung erfüllen, muss der Wert noch um eines erhöht werden für das erste Element, das die Bedingung reißt.

**Lösung**: 536625