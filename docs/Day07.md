# [Tag 7: No Space Left On Device](https://adventofcode.com/2022/day/7)

## Überlegungen

- Data Class, um ein FileObject darzustellen
  - name: Bezeichnung des Objekts
  - size: Größe des Objekts (kann auch 0 sein. s. `getSize()`)
  - content: Objekte in diesem Objekt
  - Dateien haben keinen Inhalt
  - Verzeichnisse werden mit size = 0 initialisiert
  - `getSize()`
    - Gibt *size* zurück, wenn es keinen Inhalt gibt (dann ist das Objekt eine Datei)
    - Gibt die Summe aller `getSize()` Aufrufe der Inhaltsobjekte zurück
- Vielleicht eine Liste alle angelegten Verzeichnisse für den direkten Zugriff?


## Teil 1

## Teil 2
