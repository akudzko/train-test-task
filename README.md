# Train test task

## Programmieraufgabe
Wir bauen einen Zug … der im Folgenden beschriebene Aufbau und die dazugehörigen
Funktionalitäten sollen in Java umgesetzt werden:
* Ein Zug besteht aus einer oder mehreren Lokomotiven und keinem bis mehreren
Wagons.
* Lokomotiven und Wagons haben ein fixes Leergewicht.
* Lokomotiven und Wagons haben eine fixe Länge.
* Die Elemente innerhalb eines Zuges haben eine gewisse Reihenfolge.
* Jede Lokomotive hat eine bestimmte Zugkraft, diese gibt an wie viel Gewicht die
Lokomotive, zusätzlich zu ihrem eigenen Leergewicht, ziehen kann.
* Jede Lokomotive kann eine bestimmte Anzahl an Passagieren (0 oder mehr)
aufnehmen und hat ein maximales Zuladungsgewicht für Güter (0 oder mehr)
* Jede Lokomotive hat eine Typenbezeichnung, einen Hersteller, ein Baujahr und eine
eindeutige Seriennummer.
* Lokomotiven werden nach den Antriebsarten Diesel, Dampf, elektrisch
unterschieden.
* Es gibt mehrere Arten von Wagons (Personenwagen, Schlafwagen, Speisewagen,
Güterwagen, ...)
* Jeder Wagon kann eine bestimmte Anzahl an Passagieren (0 oder mehr) aufnehmen
und hat ein maximales Zuladungsgewicht für Güter (0 oder mehr).
* Jeder Wagon hat eine Typenbezeichnung, einen Hersteller, ein Baujahr und eine
eindeutige Seriennummer.
* Es kann das Leergewicht des gesamten Zuges abgefragt werden.
* Es kann die maximale Anzahl an Passagieren pro Zug abgefragt werden.
* Es kann das maximale Zuladungsgewicht für Güter pro Zug abgefragt werden.
* Es kann die maximale Zuladung eines Zuges abgefragt werden (= maximale Anzahl
der Passagiere im Zug x 75kg + maximales Zuladungsgewicht für Güter)
* Es kann das maximale Gesamtgewicht des Zuges abgefragt werden.
* Es kann die Länge des Zuges abgefragt werden.
* Es soll geprüft werden können, ob der Zug fahrfähig ist. Das heißt, ob die im Zug
vorhandenen Lokomotiven in der Lage sind, den Zug mit maximaler Zuladung
(Passagiere und Güter) zu ziehen.
* Wenn ein Zug mehr als 0 maximale Passagiere hat, wird ein Schaffner auf diesem Zug
benötigt.
* Pro 50 möglicher Passagiere wird ein Schaffner benötigt.
* Es kann die Zahl der maximal benötigten Schaffner pro Zug abgefragt werden.
* Lokomotiven oder Wagons können immer nur einem Zug zugewiesen sein.
* Die Zusammenstellung von Zügen kann verändert werden.
* Weitere Prüfungen sind je nach Implementierung zu integrieren, zum Beispiel dürfen
keine Zyklen innerhalb eines Zuges auftreten – Wagon A hängt an Wagon B und
Wagon B hängt an Wagon A.
* Mittels JUnit-Tests ist die korrekte Funktionsweise zu prüfen

## Programming task
We are building a train... the structure described below and the associated ones
Functionalities are to be implemented in Java:
* A train consists of one or more locomotives and none or more
wagons. • Locomotives and wagons have a fixed empty weight.
* Locomotives and wagons have a fixed length.
* The elements within a train have a certain order.
* Each locomotive has a certain tractive effort, this indicates how much weight the
locomotive can pull, in addition to its own curb weight.
* Each locomotive can carry a certain number of passengers (0 or more)
and has a maximum payload weight for goods (0 or more)
* Each locomotive has a type designation, a manufacturer, a year of construction and a
unique serial number.
* Locomotives are classified according to the drive types diesel, steam or electric
distinguished.
* There are several types of wagons (passenger cars, sleeper cars, dining cars,
Freight wagons, ...)
* Each carriage can hold a certain number of passengers (0 or more).
and has a maximum payload weight for goods (0 or more).
* Each wagon has a type designation, a manufacturer, a year of construction and a
unique serial number.
* The empty weight of the entire train can be queried.
* The maximum number of passengers per train can be queried.
* The maximum loading weight for goods per train can be queried.
* The maximum payload of a train can be queried (= maximum number
of passengers on the train x 75kg + maximum load weight for goods)
* The maximum total weight of the train can be queried.
* The length of the train can be queried.
* It should be possible to check whether the train is drivable. That is, whether those on the train
Existing locomotives are able to pull the train with maximum payload
(passengers and goods) to pull.
* If a train has more than 0 maximum passengers, a conductor will be on that train
needed.
* One conductor is required for every 50 possible passengers.
* The maximum number of conductors required per train can be queried.
* Locomotives or wagons can only be assigned to one train at a time.
* The composition of trains can be changed.
* Depending on the implementation, further checks are to be integrated, for example allowed
no cycles occur within a train – wagon A is connected to wagon B and
Wagon B is attached to Wagon A.
* The correct functioning is to be checked by means of JUnit tests