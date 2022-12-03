# [Tag 3: Rucksack Reorganization](https://adventofcode.com/2022/day/3)

## Übersicht

Beim Packen der Rucksäcke sind Fehler gemacht worden. In jedem Rucksack ist genau ein Gegenstand im falschen Abteil gelandet. Die Objektarten werden mit den Buchstaben `a` bis `z` und `A` bis `Z` bezeichnet. Gegenstände einer Objektart gehören alle in das gleiche Abteil.

Zusätzlich besitzt jede Objektart eine Priorität:
`[a..z] => [1..26]`
`[A..Z] => [27..52]`

Diese Prioritäten werden durch eine *List<Char>* `priorities = ('a'..'z') + ('A'..'Z')` dargestellt. Die gesuchte Priorität ist dann Index + 1.

Puzzleeingabe ist eine Packliste der Rucksäcke. Eine Zeile pro Rucksack.

## Teil 1

Für jeden Rucksack soll die Objektart ermittelt werden, die fälschlicherweise in beiden Abteilen verpackt wurde. Gesucht ist die Summe der Prioritäten der falsch verpackten Objektarten aller Rucksäcke.

Die Eingabe wird verschiedenen Transformationen unterzogen:

* Zeilen (Rucksäcke) zu Listen mit erster und zweiter Hälfte (Abteile): `map { it.chunked(it.length/2) }`
* Abteillisten zu Set gemeinsamer Elemente: `map { (front, back) -> front.toSet().intersect(back.toSet()) }`
* Herausholen des gemeinsamen Elements: `map { it.first() }`
  * Vorgabe ist, dass es genau ein gemeinsames Element gibt. D.h. es kann000 nur ein Element im Set geben
* Liste der gemeinsamen Elemente zu Gesamtsumme: `sumOf { priorities.indexOf(it) + 1 }`

**Lösung**: 7817