# [Tag 15: Beacon Exclusion Zone](https://adventofcode.com/2022/day/15)

## Überlegungen

### Parsen der Eingabe

Das Parsen wird in die Methode `getSensors()` ausgelagert, da sie für beide Teile benötigt wird. Die Methode erwartet eine *List<String>* (Eingabe), so wie eine *List<Point2D>*, die die Beacons aufnehmen soll. Die Rückgabe ist eine *MutableMap<Point2D, Int>*.

Mit der Regex `x=(-?\d+), y=(-?\d+).*x=(-?\d+), y=(-?\d+)` wird jeder Eintrag der Eingabe ausgewertet und ergibt dann wegen der Gruppen 4 Zahlen, die die X- und Y-Koordinaten von Sensor und nächsten Beacon repräsentieren. Aus diesen Koordinaten werden zwei *Point2D* erzeugt. Der Beacon-Punkt kommt in übergebene Liste, für die Ausgabe werden die Einträge der Eingabe letztendlich in einen Eintrag der Map umgewandelt, der dem Sensor-Punkt den (Manhattan)-Abstand zum Beacon zuordnet.

## Teil 1

Gesucht ist die Anzahl der Koordinaten einer bestimmten Zeile (2_000_000), die sicher keinen unbekannten Beacon enthalten können. Dabei ist zu beachten, dass durch andere Beacons und Sensoren belegte Koordinaten **nicht** mitgezählt werden dürfen.

Für die Ermittlung der Koordinatenspanne wird die Liste der Sensoren transformiert. Zuerst wird jeder Sensor in eine Liste mit zwei Elemente umgewandelt. Das erste Element ist x - Abstand, das zweite x + Abstand. Beide repräsentieren also die maximale Ausdehnung für diesen Sensor. Diese Liste wird dann reduziert, so dass eine Liste mit zwei Elemente übrig bleibt, die die gewünschten kleinste und größte x-Koordinate enthält.

Für jeden Punkt in der Zeile `Point2D[X,y]` für $X \in [M..N]$ wird geprüft, ob es einen Sensor gibt, in dessen abgedeckten Bereich er liegt. Für `M` steht für den niedrigsten x-Koordinatenwert, der abgedeckt ist, und `N` für den größten.

Jeder Punkt, der nicht abgedeckt ist, erhöht den Zähler, der dann zurückgegeben wird.

**Lösung**: 5_299_855

## Teil 2

Gesucht ist die Tuningfrequenz des nicht erfassten Beacons (berechnet als x * 4_000_000 + y). Es ist bekannt, dass er sich irgendwo im Bereich zwischen den Koordinaten (0,0) und (4_000_000, 4_000_000) befindet und dass es der einzige unabgedeckte Punkt ist.

### Überlegungen

Der Ansatz aus Teil 1 funktioniert theoretisch, wenn er für jede Zeile des Bereichs angewandt wird, ist aber praktisch zu aufwendig, da viel zu viele Punkte geprüft werden müssen.

Der bessere Ansatz basiert auf den Sensoren und ihren Abständen.

Jede Abdeckung kann durch 4 geraden beschrieben werden, die den Bereich umfassen. Auf ihnen liegen als alle die Punkte, die genau eine Einheit weiter weg sind vom Sensor. Für einen Sensor `p = (x, y)` und Abstand `r` sind die Geraden:

mit Steigung 1 (Typ a)

$$
y = 1 * x + (p.y - p.x + r + 1)\\
y = 1 * x + (p.y - p.x - r - 1)
$$

mit Steigung -1 (Typ b)

$$
y = -1 * x + (p.x + p.y + r + 1)\\
y = -1 * x + (p.x + p.y - r - 1)
$$

An Schnittpunkten zweier Geraden (einer Typ a und einer Typ b) kann möglicherweise der gesuchte Punkt liegen. Der Schnittpunkt zweier Geraden der Form $y = mx + c$ für zwei geraden a und b hat die Koordinate $((b - a) / 2, (a + b) / 2)$. Die so ermittelten Schnittpunkte können dann gefiltert werden, ob sie im Bereich liegen und nicht von einem Sensor abgedeckt sind.

### Umsetzung

In zwei `Set<Int>` für die Typen a und b werden die konstanten Ausdrücke der Geradenformel (die Koeffizienten) jedes Sensors abgelegt. Die Schnittpunkte werden durch ein Kreuzen der a- und b-Koeffizienten ermittelt und ausgefiltert, wenn ihre Koordinaten außerhalb des zulässigen Bereichs liegen. Als Rückgabe wird die Liste der übrigen Schnittpunkte noch einmal gefiltert. Es werden die Schnittpunkte entfernt, die abgedeckt werden (deren Abstand zu einem Sensor kleiner als sein Abstand ist).

Per Vorgabe bleibt so nur ein Punkt übrig. Dieser wird für die Berechnung verwendet und das Ergebnis zurückgegeben.

Da hier mit Zahlen hantiert wird, die den Bereich eines *Int* übersteigen, wird *BigInteger* verwendet.

**Lösung**: 13_615_843_289_729
