# [Tag 5: Supply Stacks](https://adventofcode.com/2022/day/5)

## Übersicht

Beim Ausladen werden Kisten in Stapeln abgelegt und dann noch umarrangiert. Die Ausgangslage der Kisten und Stapel ist bekannt, ebenso die Anweisungen mit denen die Kisten umgestapelt werden sollen in der Form `N Kisten von A nach B`.

### Überlegungen

#### Stapel und Parsen der Eingabe der Stapel

* Die Ausgangslage ist der erste Teil in der Eingabe und getrennt mit einer Leerzeile von den Anweisungen
* Um die Kisten einer Ebene zu bekommen, kann die Zeile in Chunks der Größe 4 aufgeteilt werden. Der Buchstabe der Kiste befindet sich dann an Index 1
  * **ACHTUNG:** Die unterste Kiste kommt als letztes
* Ein Stapel kann als *String* (oder *CharArray*) repräsentiert werden

**Umsetzung**

* Die Zeilen der Eingabe werden zu Strings: `chunked(4).map { it[1] }`
  * Die Zeile wird zuerst in Chunks der Größe 4 aufgeteilt
  * Von jedem dieser Chunks wird nur das zweite Zeichen verwendet (Name der Kiste)
* Strings umkehren. Damit befindet sich die oberste Kiste am Ende des Strings

#### Verschieben von Kisten

Da sich die obersten Kisten eines Stapels am Ende des Strings befinden, kann die gewünschte Anzahl einfach mit `takeLast()` ermittelt werden. Dieser Substring wird dann einfach an den Zielstapel angehängt. Da die "entnommenen" Kisten nicht direkt entfernt werden, muss mit `dropLast()` dafür gesorgt werden, dass die Kisten vom Ausgangsstapel verschwinden.

## Teil 1

* Stapelkonfiguration *stacks* und Instruktionen werden ermittelt
* Dann wird über die Instruktionen iteriert und *stacks* entsprechend manipuliert
  * Ausgangsstapel und Zielstapel werden ermittelt (*source* bzw. *destination* der Anweisung minus 1)
  * Dann die zu verschiebenden Kisten (*amount*) vom Ausgangsstapel ermittelt und in umgekehrter Reihenfolge auf den Zielstapel gelegt
  * Von Ausgangsstapel werden die Kisten noch entfernt
  * Als Letztes werden die neuen Stapel zurück auf *stacks* gelegt (gleiche Stelle wie vorher)
* Nach dem Abarbeiten der Instruktionen wird *stacks* gefaltet, so dass nur die letzten Zeichen jedes Stapels verkettet werden.

**Lösung**: SVFDLGLWV

## Teil 2

Das Vorgehen ist fast identisch wie in Teil 1. Die Reihenfolge der Kisten wird nicht umgekehrt.

**Lösung**: DCVTCVPCL