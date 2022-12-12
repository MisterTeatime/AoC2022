# [Tag 7: No Space Left On Device](https://adventofcode.com/2022/day/7)

## Überlegungen

### Data Class TreeNode

Die Datenklasse repräsentiert einen Knoten im Dateisystem. Jeder Knoten besitzt einen Namen und hat einen Inhalt. Über einen sekundären Konstruktor kann die Größe mit angegeben werden (nur bei Dateien erforderlich). Es gibt auch noch einen Eigenschaft für den Elternknoten.

Die Größe wird über `getSize()` abgefragt und entspricht entweder dem hinterlegten Wert (bei Dateien) oder wird berechnet, in dem die Größen der Knoten im Inhalt aufsummiert werden.

Die Klasse bietet zudem Methoden, um Inhalt hinzuzufügen (`addChild()`) und ein Kindknoten aus dem Inhalt abzurufen. Beim Hinzufügen wird der Knoten, dessen Methode aufgerufen wurde, als *parent* dem neuen Kind zugeordnet.

### Parsen des Verzeichnisbaums

Beim Parsen wird die Log der Eingabeaufforderung durchgegangen. Zu Beginn wird der Root-Knoten angelegt, als *currentNode* festgelegt und dem Set der bekannten Verzeichnisse hinzugefügt.

Die restlichen Zeilen (ohne die ersten beiden) werden der Reihe nach verarbeitet:

- Die Zeilen werden am Leerzeichen aufgesplittet
- Ist der erste String eine Zahl, dann wird *currentElement* ein neuer Knoten hinzugefügt. Da Name (zweiter String) und Größe (erster String) angegeben werden, handelt es sich um eine Datei
- Ist der erste String `dir`, dann ist es ein Verzeichnis. *currentElement* erhält einen neuen Knoten, der nur aus dem Namen (zweiter String) besteht
- Ist der erste String `$` und der zweite String `cd`, dann kommt es auf den dritten String an
  - Ist er `..`, dann wird der *parent* von *currentNode* die neue *currentNode*
  - Sonst wird *currentNode* auf die TreeNode aus dem Inhalt von *currentNode* gesetzt, die den entsprechenden Namen (drtter String) hat
  - `$ ls` wird schlicht ignoriert, da die Anweisung für das Parsen keine Bedeutung hat

Nach dem Parsen ist der Wurzelknoten bekannt und alle Knoten sind entsprechend enthalten. *nodes* ist ein Set mit allen Verzeichnissen, da für die Aufgaben verwendet werden kann.

## Teil 1

Es wird die Summe der Größen aller Verzeichnisse gesucht, die höchstens eine Größe von 100.000 Bytes haben.

Nach dem Parsen werden die Elemente von *nodes* auf ihre Größen gemappt, dann die Elemente behalten, die die Bedingung erfüllen (<= 100_000) und dann werden die Größen aufsummiert.

**Lösung**: 1743217

## Teil 2

Für das Update werden 30_000_000 Bytes Platz benötigt. Der Gesamtspeicherplatz ist 70_000_000 Bytes. Falls nicht genug Platz zur Verfügung steht (was es tut), muss ein Verzeichnis gelöst werden. Der Kandidat ist das kleinste Verzeichnis, dass mindestens den fehlenden Platz freigibt. Gesucht ist die Größe dieses Verzeichnisses.

Nach dem Parsen wird der Platz berechnet, der freigegeben werden muss. Platz für das Update - aktuell freier Platz. Sollte der Wert kleiner 0 sein, dann ist mehr Speicher frei als benötigt wird und es muss nichts gelöscht werden (wird nicht vorkommen).

Die Elemente von *nodes* werden wieder auf ihre Grö´ße gemappt und auch wieder gefiltert. Diesmal werden alle Verzeichnisse behalten, die größer oder gleich dem Platz sind, der freigegeben werden muss. Aus dieser Gruppe wird dann das kleinste Elemente zurückgegeben.

**Lösung**: 8319096