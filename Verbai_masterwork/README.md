# **3D Print management API**

## Áttekintés

Az alkalmazás célja a 3D nyomtatás technológiájának alkalmazása során felmerülő logisztikai problémák kezelésének
megkönnyítése. Egy adott tárgy megalkotásához egy STL kiterjesztésű fájlra, az alapanyagként szolgáló müanyagszálra(
Későbbiekben filament)
és egy 3D nyomtatóra van szükség. A 3D modellből egy gépi kódot állítunk elő, ami tartalmazza a nyomtató és adott
alapanyag használatához szükséges adatokat (Hőmérséklet, nyomtatás méretei, sebesség stb.). A kész nyomtatási fájlokból
nehéz ezeket az adatokat visszakeresni. Az alkalmazás célja, hogy segítséget nyújtson projektjeink során. A következő
funkciókkal segíti munkánkat:

- Anyagkészlet monitorozása
- Nyomtatók nyilvántartása
- Nyomtatási tervek nyilvántartása
- Konverzió a rendelkezésre álló filament hossza és tömege között
- Kopatibilitás figyelése az alapanyag és a nyomtató között

# Az alkalmazás struktúrája

Entitások:
- Filament: Egy adott tekercs műanyag
- Printer: A nyomtatót reprezentálja, tárolja annak szükséges adatait
- PrintPlan: Egy nyomtatás anyagszükségletét és a hozzá tartozó fájl nevét tartalmazza
- User: A felhasználó adatait tartalmazza


Mivel egy-egy nyomtatási fájl csak adott gépen használható, így adott volt a one-to-many kapcsolat alkalmazása. 
A filamentek és a nyomtatók 1.75mm, 2.8mm vagy 3mm-es átmérőhöz vannak optimalizálva. Ennek értelmében egy nyomtatóhoz több filament is használható, 
ugyanakkor a filament nem gépspecifikus. Ezt a tulajdonságot figyelembevéve many-to-many kapcsolatot alkalmaztam, kapcsolótábla beiktatásával.
A felhasználók és a filamentek közötti one-to-many kapcsolat lehetővé teszi, hogy a rendszer figyelmeztetést küldjön, ha az adott anyag
elérhető mennyisége egy kritikus szint alá csökken. Ezt akár e-mail küldésével is jelezheti.

# Az alkalmazás működése

Az alkalmazás Modell, Controller, Service és Repository rétegekre tagozódik. Minden entitáshoz tartozik egy controller, ami az 
alapvető CRUD műveleteket képes elvégezni. Annak érdekében, hogy a felhasználó csak a szükséges adatokat kapja meg, minden entitáshoz 
tartozik egy-egy DTO is. A Controller réteg ezeket fogadja és adja át a végpontok megfelelő meghívása esetén. 

A logikai összefüggéseket, a validációt és a DTO-k és a tárolt objektumok közötti átjárást a service réteg valósítja meg. 

A repository réteg felelős az adatbázissal való összeköttetésért. 

# Alkalmazott technológiák
- Projekt: Spring Boot, Gradle, Java 8
- Adatbázis: H2
- Konténerizáció: Docker
- Tesztelés: Junit5, MockMVC, Mockito
- Validáció: Javax
- Dokumentáció: Swagger


