For å fullføre laben, ber vi deg om å svare på følgende spørsmål. Svar på spørsmålene ved å fylle ut denne filen.

## Hva har du lært om Java og objekt-orientert programmering under arbeidet med denne oppgaven? Beskriv hvilke deloppgave(r) du jobbet med i læringsøyeblikket.

<!-- ditt svar her -->
Først og fremst har jeg lært mye av denne oppgaven. Det å lage noe helt fra bunnen av gjør at man får en helt annen tilnærming til koden, som gjør at oversikten, forståelsen og utførselsen blir enklere. Underveis i denne oppgaven føler jeg har fått en større forståelse om hvodan OOP fungerer. Sånn generelt føler at jeg at jeg forstår bedre hvordan de ulike objektene i kommuniserer med hverandre, og hvorfor de ulike feltene og metodene tildeles ulike aksessnivåer. i løpet av hele oppgaven har vi tildelt aksesskontroll til de ulike meotodene, og det har vært en god øvelse i å forstå hvorfor det er viktig å gjøre dette. 


## Hva er det neste du ønsker å lære om Java og programmering?

<!-- ditt svar her -->
Jeg har veldig lyst å lære meg om nye bibloteker og utvide mine ferdigheter innen fullstack utvikling i java. Jeg synes det hørres veldig innteresant å utforske det populære javascript bibloteket React for å lære meg å bygge grensesnitt på nettet. Det å bruke java som back-end og implementere React som front-end har jeg velig lyst å mestre. 

Ellers har jeg lyst til å bli enda flinkere på Interaktivt grafikk,noen som vi har brukt i denne semesteroppgaven. Interaktivt grafikk er en veldig spennende og kreativt fagfelt som jeg har lyst til å lære mer om.




## Hvilke grep gjør vi for å øke modulariteten i koden? Gi noen eksempeler.

<!-- ditt svar her  -->
Det er ulike grep jeg gjør for å øke modulariteten i koden. I steden for å skrive all kode fra bunnen av, bruker jeg nytte av eksisterende moduler og bibloteker. Dette resulterer i at jobben blir enklere og økt gjenbrukbarhet a koden. I denne oppganen bruker jeg flere bibloteker og monduler. Import setningene øverst i koden benytter seg av pakker fra ulike bibloteker for å definere klassene som blir brukt. 

TetrisModel-klassen implementerer både ViewableTetrisModel og ControllableTetrisModel-grensesnittene. Dette bidrar til å dele opp funksjonaliteten i mindre, selvstendige deler og gjør koden mer modulær.

Ved å dele opp koden i mindre monduler  og funksjoner øker man lesbarheten og gjør det lettere å gjenbruke koden. Store og komplekse koder kan være vansekelig å lese, velikeholde og endre. I Tetris Modelen er det derfor en god løsning å dele opp alle de ulike funksjonene til Tetrominoen i flere metoder, noe som gjør den mer oversiktelig å letter å lese. Metodene moveTetromino(), isLegalMove(), rotatTetromino(), placeTetromino() og score(), tar inn eller retunere verdier som gjør dem uavhening av resten av koden. Dette gjør det lettere å teste og gjenbruke i andre deler av programmet.

Konstruktøren til TetrisModel-klassen tar inn en TetrisBoard- og TetrominoFactory-instans som parametere. Dette gir større fleksibilitet, siden man kan bytte ut disse instansene med andre implementasjoner uten å måtte endre koden til TetrisModel-klassen.











