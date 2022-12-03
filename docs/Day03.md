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
* Abteillisten zu gemeinsamen Element: `flatMap { (front, back) -> front.toSet().intersect(back.toSet()) }`
  * Es kann nur ein gemeinsames Element vorkommen, deswegen kann mit `flatMap` gleich das Element aus dem Set gezogen werden
* Liste der gemeinsamen Elemente zu Gesamtsumme: `sumOf { priorities.indexOf(it) + 1 }`

**Lösung**: 7817

## Teil 2

Die Elfen sind Dreiergruppen eingeteilt. Jeder Gruppe trägt Objekte derselben Art bei sich und wird normalerweise durch ein Abzeichen gekennzeichnet. Dieses Jahr wurde vergessen die Abzeichen zu bestätigen. Unsere Aufgabe ist es mithilfe der Packliste für jede Gruppe die korrekte Objektart zu bestimmen (die Objektart, die von allen drei Gruppenmitgliedern getragen wird) und dessen Priorität zu ermitteln. Das gesuchte Ergebnis ist die Summe der Prioritäten.

Wie in Teil 1 wird die Eingabe verschiedenen Transformationen unterzogen:
* Zeilen (Rucksäcke) in Dreier-Gruppen: `chunked(3)`
* Dreier-Gruppen zu gemeinsamen Element: `flatMap { group -> group.fold(group[0].toSet()) { acc, line -> acc.intersect(line.toSet())`
  * Die Rucksäcke einer Gruppe werden mit `fold` gefaltet. Der Startwert ist der gesamte erste Rucksack als Set. Alle weiteren Rücksäcke werden mit dem Ausgangswert der vorherigen Aktion geschnitten (`intersect`). So bleiben immer die gemeinsamen Zeichen übrig. Am Ende das eine, dass allen drei Rucksäcken gemeinsam ist
* Liste der gemeinsamen Elemente zu Prioritäten-Gesamtsummer: `sumOf { priorities.indexOf(it) +  1 }`

**Lösung**: 2444
