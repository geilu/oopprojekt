# OOP Rühmatöö - Kohvik

## Autorid: Geilyn Tisler, Sandra Ots
## Projekti kirjeldus
Projekti eesmärgiks oli luua kohvik, kus kasutaja saab valmistada klientide jaoks erinevaid kohvijooke.

Programm võimaldab kasutajal valida erinevaid koostisosade kombinatsioone ja valmistada kohvijooke vastavalt klientide soovidele,
klientide soovid ning ka külastavate klientide arv genereeritakse juhuslikult ning kasutaja saab valida koostisosad. Programm
kontrollib kas kasutaja valitud koostisosad kattuvad mingi olemasoleva kohvi koostisosadega ning kas tehtud jook on sobilik
kliendi sooviga. Lisatud on ka kliendi rahakoti klass, mis genereerib juhuslikult raha, et simuleerida kliendi rahakotti ning kui kliendil pole
soovitud toodeteks piisavalt raha, siis programm teavitab kasutajat sellest ning liigub järgmise kliendi juurde.

Programm töötab põhiliselt küsides kasutajalt sisendeid senikaua, kuni kasutaja ise programmi või selle faasi lõpetab,
ning genereerides juhuslikke andmeid, et simuleerida kohviku tööd.

## Klasside eesmärgid ja olulisemad meetodid
### KliendiRaha
Klassi eesmärk on simuleerida kliendi rahakotti, kus on juhuslikult genereeritud rahasumma.
Klassi olulisem meetod on:
```java
public double rahakott(ArrayList<Kohv> kohvimenuu, ArrayList<Saiake> saiamenuu)
```
mis genereerib juhuslikult rahasumma arvestades kõige kallimate toodete hinda.

### Kohv
Klassi eesmärk on simuleerida erinevaid kohvijooke, millel on erinevad koostisosad ja hind.

### Saiake
Klassi eesmärk on simuleerida erinevaid saiakesi, millel on erinevad hinnad.

### Main
Põhiprogrammi klass, kus luuakse erinevad kohvid ja saiakesed ning simuleeritakse kohviku tööd.
Klassi olulisemad meetodid on:
```java
private static boolean toopaev(ArrayList<Kohv> kohvimenuu, ArrayList<Saiake> saiamenuu) 
```
Selles meetodis simuleeritakse tööpäeva, kus genereeritakse juhuslikult kliente ja nende soovid ning kontrollitakse, kas tehtud kohvijoogid kattuvad klientide soovidega.
```java
private static Kohv kasTegiKohvi(List<Kohv> kohvid, List<String> valitudKoostisosad)
```
Selles meetodis kontrollitakse, kas kasutaja valitud koostisosad kattuvad mingi olemasoleva kohvi koostisosadega.

## Projekti protsessi kirjeldus
Kõigepealt otsustasime põhiidee, et teeme kohviku, kus on erinevad kohvijookide ja saiakeste menüü. Seejärel jagasime ülesanded ära ning igaüks töötas oma osa kallal.
### Rühmaliikmete panused
Geilyn tegi kohvi klassi ja põhiklassis lõi tema erinevaid kohvijooke ning toopaev meetodis lisas kohvijookide tegemise protsessi. Ajakulu orienteeruvalt 3-5h.

Sandra tegi saiakeste ja kliendi rahakoti klassid ning põhiklassis lõi tema erinevaid saiakesi, toopaev meetodis lisas tema klientide rahakoti ja soovide genereerimise ja kontrolli, kas klientidel on piisavalt raha soovitud toodete jaoks. Ajakulu orienteeruvalt 3-5h.
### Probleemid
Suuremaid probleeme ei tekkinud, kuid tekkisid mõned väiksemad vead, näiteks see, kui suur peaks kliendi rahakott olema võrreldes toodete hindadega, et ei oleks liigselt õnnetuid kliente selletõttu, et neil toodete jaoks piisavalt raha pole.
Samuti läks natuke aega, et saada kohvijookide tegemise protsess õigeks, et see töötaks nagu soovisime ning kontrolliks õigesti, mis kohv tehtud on.

## Hinnang lõpptulemusele
Lõpptulemus on rahuldav, kuna programm töötab ja simuleerib kohviku tööd. Edasiselt saaks arendada rohkem tooteid, lisada ka klientidele saiakeste "andmise" võimalus,
lisada klientidele võimaluse genereerida mitmeid saiakesi või jooke korraga ja teha koodi võimalusel efektiivsemaks.

## Programmi testimine
Testides programmi proovisime läbi kõik erinevad variandid, et veenduda, et programm töötab nagu soovitud. Proovisime teha valesid jooke, sisestada ebasobivaid sisendeid jms ning hindasime, kuidas programm nendele vastab.