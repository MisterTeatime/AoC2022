# [Day 1: Calorie Counting](https://adventofcode.com/2022/day/1)

## Übersicht

Eingabe ist eine Liste von Kalorien, die von verschiedenen Elfen getragen werden. Die einzelnen Stücklisten sind durch eine Leerzeile getrennt.

## Teil 1

Es werden die Gesamtkalorien gesucht, die der Elf mit den meisten Kalorien bei sich trägt.

Dazu wird die Eingabe mit `partitionGroups()` aufgeteilt und die einzelnen Listen durch die Summe ihrer Elemente mit `map()` ersetzt. Dann wird das Maximumelement ausgesucht und zurückgegeben. 

**Lösung:** 66186

## Teil 2

Für die Lösung ist die Summe der Gesamtkalorien der drei Elfen mit den größten Gesamtkalorien relevant.

Dazu wird die Eingabe mit `partitionGroups()` aufgeteilt und die Listen durch die Summer ihrer Elemente mit `map()` ersetzt. Dann wird mit `topMax()` die drei größten Elemente ermittelt. Das Ergebnis ist dann die Summe der Elemente.

**Lösung:** 196804
