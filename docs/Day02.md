# [Tag 2: Rock Paper Scissors](https://adventofcode.com/2022/day/2)

## Übersicht

Ein Strategie-Guide gibt Aufschluss darüber, welchen Zug der Gegner machen wird und wie darauf zu reagieren ist. Am Anfang sind die Anweisungen unvollständig und es wird angenommen, dass X, Y und Z für das zu wählende Symbol stehen. Im weiteren Verlauf stellt sich heraus, dass X, Y und Z für das erforderliche Ergebnis stehen.

Nach jeder gespielten Runde gibt es Punkte je nach Ausgang und gewähltem Symbol.
* Sieg = 6 Punkte
* Unentschieden = 3 Punkte
* Niederlage = 0 Punkte
* Stein = 1 Punkt
* Papier = 2 Punkte
* Schere = 3 Punkte

Gesucht wird immer die Gesamtpunktzahl des Spielers am Ende des Spiels.

## Teil 1

Es wird eine Map aufgebaut, die jeder Buchstabenkombination den gesamten Punktewert zuordnet. Z.B. `AX = 3 + 3`, weil ein Unentschieden mit Stein erspielt wird. Die Eingabe wird zuerst in Listen aufgesplittet und dann die Summe über die ermittelten Punkte aus der Map gebildet.

**Lösung**: 13924

## Teil 2

Es wird wieder eine Map aufgebaut. Z.B. `AX = 0 + 3`, weil eine Niederlage gegen Stein (mit Schere) erspielt werden muss. Wie in Teil 1 wird die Eingabe aufgesplittet und zugeordnet.

**Lösung**: 13448