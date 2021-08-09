# Stories

## Story 1
**Prio** 1

**Punkte** 2

Als Mitarbeiter möchte ich, dass die eingegebene Telefonnummer in einzelne Attribute aufgesplittet wird.
### Details: 
Die Felder sind dabei die folgenden: 
* Landesvorwahl 
* Ortsvorwahl 
* Hauptwahl 
* Durchwahl 
* Unformatierter Eingabestring

Ich weiß die Anforderung ist erfüllt wenn: 
* Jede eingegebene Telefonnummer korrekt in die einzelnen Teile aufgeteilt wird.

## Story 2
**Prio** 2

**Punkte** 1

Als Mitarbeiter möchte ich, dass jede beliebige Telefonnumer aufgenommen werden kann.  Kann eine Telefonnumer nicht eindeutig geparsed werden, so soll ein Vorschlag für den
Mitarbeiter angezeigt werden. Nach Möglichkeit soll jede beliebige Nummer geparsed werden können, sodass keine Fehlermeldungen auftreten.

Die Anforderung ist erfüllt, wenn:
* Eine beliebige Telefonnummer, die keinem typischen Muster entspricht trotzdem geparsed wird
* Eine Telefonnummer, die von der Parser Bibliothek als invalide markiert wurde trotzdem geparsed wird

## Story 3
**Prio** 3

**Punkte** 1

Als Mitarbeiter möchte ich die Möglichkeit haben die zugeordneten Werte zu überprüfen und zu ändern, bevor diese weiterverarbeitet werden. Der Benutzer kann so das Ergebnis des Parsers überprüfen und manuell anpassen. Die vom Benutzer erfolgten Eingaben werden dann in die Übersichtsliste übernommen.

Die Anforderung ist erfüllt, wenn:
* Dem Benutzer nach der Aufteilung der Telefonnummer in Attribute ein Fenster angezeigt wird, indem die Daten überprüft und manuell geändert werden können.
* Der Benutzer die manuellen Änderungen annehmen oder verwerfen kann

## Story 4
**Prio** 3

**Punkte** 0,5

Als Mitarbeiter möchte ich über bereits vorhandene Telefonnummern oder Duplikate informiert werden. 

Die Anforderung ist erfüllt, wenn:
* In der Übersichtsliste doppelte Einträge farbig markiert werden.

## Story 5
**Prio** 1

**Punkte** 1

Als Mitarbeiter möchte ich, dass sowohl Handy- als auch Festnetznummern erkannt werden.

Die Anforderung ist erfüllt, wenn:
* Handynummern erkannt und korrekt aufgesplittet werden.
* Festnetznummern erkannt und korrekt aufgesplittet werden.

## Story 6
**Prio** 1

**Punkte** 0,5

Als Mitarbeiter möchte ich, dass anhand der Ländervorwahl automatisch das entsprechende Land erkannt wird. Bei fehlender Ländervorwahl soll autmatisch Deutschland gewählt werden.

Die Anforderung ist erfüllt, wenn:
* Das Kürzel des Landes als Zeichenkette angezeigt werden kann
* Das standardmäßige Land Deutschland ist
