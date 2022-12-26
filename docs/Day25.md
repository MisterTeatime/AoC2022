# [Tag 25: Full of Hot Air](https://adventofcode.com/2022/day/25)

## Überlegungen

### Dezimal -> SNAFU

Im Prinzip zentriert sich das System um die Vielfachen von 5 und gibt bis zu zwei Schritte Differenz an:

```text
0  1  2  3  4  5  6  7 
0  1  2 -2 -1  0  1  2
0  1  2  =  -  0  1  2
```

D.h., wenn der Wert einer Stelle > 2 ist, dann bezieht sie sich auf die nächsthöhere Stelle und erzeugt ein Carry Over, das bedingt, dass die nächste Stelle um 1 erhöht werden muss. Das bedeutet aber auch, dass `0`, `-` und `=` nie am Anfang einer SNAFU Zahl stehen können:

- `0` ist überflüssig und könnte weggelassen werden
- `-` liegt 1 unter der nächsten Stelle. Diese muss also mindestens 1 sein und damit steht `-` nicht mehr an vorderster Stelle 
- `=` liegt 2 unter der nächsten Stelle. Diese muss also mindestens 1 sein und damit steht `=` nicht mehr an vorderster Stelle

```text
12345 -> 343340
343340 -> 043343
043343 -> 0---0-1
0
 -1
  -1
   -1
    0
     -1
0---0-1 -> 1-0---0
```

- Die Zahl in String einer Zahl zur Basis 5 umwandeln
- Den String umkehren und jedes Zeichen nach SNAFU übersetzt
  - Wenn der Wert 4 oder 5 ist, muss ein Carry Over gemerkt werden
  - Gibt es von vorher ein Carry Over, dann muss der aktuelle Wert um 1 erhöht werden
- Den transformierten SNAFU String für die Ausgabe nochmal umkehren

### SNAFU -> Dezimal

```text
1=11-2 -> 3125 - 1250 + 125 + 25 - 5 + 2

1       2
5       -1
25      1
125     1
625     -2
3125    1

```

- Den SNAFU String Stelle für Stelle durchgehen
  - Zeichen ggf. übersetzen und Wert berechnen: `Wert * 5 ^ index`

### Implementierung

Die beschriebene Funktionalität wird in zwei Extension-Funktionen implementiert.

`String.parseSNAFU(): Long` gibt zu einem String, der eine SNAFU-Zahl darstellt, den Wert als Dezimal-Long zurück. Long wird wegen der zu erwartenden Werte verwendet.

`Long.toSNAFU(): String` gibt die Dezimalzahl als SNAFU-String zurück.

## Teil 1

Mit den beiden Extension-Funktionen ist die Aufgabe schnell zu lösen. Im Kern wird jede SNAFU Zahl in ihren Long-Wert transformiert und dann alle Werte aufsummiert. Das Ergebnis wird dann als SNAFU Zahl zurückgegeben.

```kotlin
input.sumOf { it.parseSNAFU() }.toSNAFU()
```

**Lösung**: 2=--00--0220-0-21==1

## Teil 2

Gibt es nicht. Der letzte Stern ist ein Geschenk.
