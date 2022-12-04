# [Tag 4: Camp Cleanup](https://adventofcode.com/2022/day/4)

## Übersicht

Die Eingabe ist eine Liste von Paaren von Sektorbereichen. Jedes Paar ist ein Team von Elfen, die die bezeichneten Sektoren des Lagers aufräumen müssen. Dabei kam es zu Überschneidungen innerhalb der Teams. 

## Teil 1

Es soll herausgefunden werden bei wie vielen Paaren eine vollständige Überdeckung vorliegt. Also die Anzahl der Paare bei denen ein Sektorbereich vollständig im anderen Sektorbereich liegt.

Die Eingabe wird verschiedenen Transformationen unterzogen:

* Zeile zu Liste (Paar) von Sektorbezeichnungen mit `split(",")`
* Liste von Sektorbezeichnungen zu Liste von Listen von Sets mit Sektoren
  * Für die Initialisierung der IntRange wird von einer Bezeichnung alles bis zum `-` als Start und alle hinter dem `-` als Ende des Intervalls angegeben
  * Für die weitere Verarbeitung wird das Intervall dann in ein Set umgewandelt
* Liste von Listen von Sets mit Sektoren zu Liste von Flags, ob es eine vollständige Überschneidung gibt
  * Das erste Sektorenset wird mit dem zweiten Sektorenset geschnitten. Das resultierende Set enthält alle Sektoren, die von beiden Bereichen abgedeckt sind
  * Das Resultat wird dann mit dem ersten und zweite Set verglichen, ob es damit identisch ist
* Aufsummieren der Einträge, die `true` sind

**Lösung**: 424

## Teil 2

Anstatt der vollständigen Überdeckung wird jetzt jede Art von Überdeckung gesucht. Es handelt sich quasi um den allgemeineren Fall von Teil 1.

Die Eingabe wird wieder verschiedenen Transformationen unterzogen. Der Anfang ist identisch mit Teil 1.

* Anstatt die Schnittmenge in ein Flag zu verwandeln, wird die Schnittmenge direkt verwendet
* Es wird gezählt wieviele Sets nicht leer sind

**Lösung**: 804