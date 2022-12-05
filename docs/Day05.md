# [Tag 5: Supply Stacks](https://adventofcode.com/2022/day/5)

## Übersicht

Beim Ausladen werden Kisten in Stapeln abgelegt und dann noch umarrangiert. Die Ausgangslage der Kisten und Stapel ist bekannt, ebenso die Anweisungen mit denen die Kisten umgestapelt werden sollen in der Form `N Kisten von A nach B`.

### Überlegungen

#### Stapel und Parsen der Eingabe der Stapel

* Die Ausgangslage ist der erste Teil in der Eingabe und getrennt mit einer Leerzeile von den Anweisungen
* Um die Kisten einer Ebene zu bekommen, kann die Zeile in Chunks der Größe 4 aufgeteilt werden. Der Buchstabe der Kiste befindet sich dann an Index 1
  * **ACHTUNG:** Die unterste Kiste kommt als letztes
* Ein Stapel kann als *String* (oder *CharArray*) repräsentiert werden.

## Teil 1

### Beispiel

```text
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2

Ausgangslage:

NZ          ZN
DCM         MCD
P           P

1 Kiste von 2 nach 1 => Das erste Zeichen von String 1 nehmen, (umkehren) und an den Anfang von String 0 packen.

DNZ         ZND
CM          MC
P           P

3 Kisten von 1 nach 3 => Die erste 3 Zeichen von String 0 nehmen, umkehren und an den Anfang von String 2 packen.

•           •
CM          MC
ZNDP        PDNZ

2 Kisten von 2 nach 1 => Die ersten 2 Zeichen von String 1 nehmen, umkehren und an den Anfang von String 0 packen.

MC          CM
•           •
ZNDP        PDNZ

1 Kiste von 1 nach 2 => Das erste Zeichen von String 0 nehmen, (umkehren) und an den Anfang von String 1 packen

C           C
M           M
ZNDP        PDNZ

```

## Teil 2
