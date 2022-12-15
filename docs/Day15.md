# [Tag 15: Beacon Exclusion Zone](https://adventofcode.com/2022/day/15)

## Überlegungen

### Abgedeckter Bereich eines Sensors

- Da jeder Sensor das nächste Beacon kennt, kann so der Manhattan-Abstand berechnet werden
  - *Point2D* bietet hier die Methode `distanceTo()`
- Jeder Punkt mit Abstand <= Abstand zum Beacon liegt im abgedeckten Bereich des Sensors
- **(Teil 1)** Da die Zeile (y-Koordinate) bekannt ist, kann jeder Sensor verworfen werden, der nicht bis hier her reicht
  - Wenn Sensor.y + Beacon-Abstand <= Zeile.y <= Sensor.y - Beacon-Abstand, dann ist dieser Sensor nicht relevant für die weiteren Berechnungen

### Ermitteln der abgedeckten Punkte einer Zeile

Für jeden Punkt in der Zeile `Point2D[X,y]` für $X \in [M..N]$ wird geprüft, ob es einen Sensor gibt, in dessen abgedeckten Bereich er liegt. Für `M` steht für den niedrigsten x-Korrdinatenwert, der abgedeckt ist, und `N` für den größten.

## Teil 1

## Teil 2