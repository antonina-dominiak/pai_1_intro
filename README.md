# pai_1_intro
###
<p>Do czego służy PATCH czy różni się od PUT?</p>
<p>PUT jest idempotentne, pełna aktualizacja zasobu, przesyłane są całe dane (stare dane nadpisywane są nowymi). PATCH - jedynie częściowa aktualizacja zasobu, przesyłane są tylko te dane, które chcemy zmienić. Niekoniecznie idempotentne.</p>
<br>
<p>Na jakich metodach http polega API REST, kryjącymi się za skrótem CRUD?</p>
<p>REST to styl architektury oprogramowania, rozwijany mniej więcej równolegle do rozwoju protokołu HTTP i podążający za pdoobvnymi zasadami (np. bezstanowość.).</p> 
<p>CRUD - Skrót od 4 podstawowych operacji implementowanych w aplikacjach bazodanowych: Create, Read, Update, Delete.</p> 
<p>W przełożeniu na metody HTTP - Create: PUT lub POST; Read: GET; Update: POST, PUT, lub PATCH; Delete: DELETE. </p>
<br>
<p>**Co to są circuit breakers i do czego służą? Dlaczego to jest ważny element aplikacji Netfixa? Zanotuj w README.md.**</p>
<p>**Odp. To design pattern - wzorzec projektowy. Pomagają z wydajnością i stabilnością, które mogą pojawiać się w systemach rozproszonych. Jeśli dozwolona liczba nieudanych połączeń zostanie przekroczona, proxy przechodzi w stan otwarty, obwód z zamkniętego staje się otwartym, a wywołania kończą się wyjątkiem, co pozwala uniknąć kaskadowego wyczerpania zasobów. W przypadku Netflixa jest to ważne ze względu na dużą liczbę użytkowników. Jeśli dany element nie działa, zapytania zostają wysłane alternatywną ścieżką, do działającego komponentu. Dzięki temu użytkownicy nie powinni odczuwać zaburzeń przy korzysstaniu z usługi.**</p>
<br>
<p>Patrząc od strony programisty w Netflixie czy Allegro budującego serwis, dlaczego chcemy uniknąć cascading failures?</p>
<p>*Awaria kaskadowa (ang. cascading failure) - awaria elementu obiektu powodująca awarię innego elementu lub elementów tego samego obiektu. Awarie kaskadowe to awarie zależne, które nie są awariami o wspólnej przyczynie.* żródło: https://testerzy.pl/baza-wiedzy/artykuly/awarie-kaskadowe-o-wspolnej-przyczynie-nie-zalezne-i-wiele-innych </p>
<p>Awarie kaskadowe zwiększają ilość niedostępnych usług, mogą powodować przeciążenie innych (działających) komponentów systemu --> spadek wydajności (w porównanniu do opcji równoległego obciążenia systemu) oraz mogą utrudniać sam proces zlokalizowania i naprawy awarii.</p>
<br>
<p>Patrząc od strony programisty w Amazonie budującego serwis, dlaczego graceful degradation jest ważny?</p>
<p>Graceful degradation - technika projektowania i implementacji systemów, mająca na celu to, by serwis działał w sposób niezawodny i zapewniał podstawową funkcjonalność nawet w obliczu awarii/braku dostępu do części komponentów. W Amazonie mogłoby to być ważne w kontekście zapewnienia ciągłąści działania serwisu, skalowalności serwisu i minimalizacji wpływu awarii na ogólne działanie platformy.</p>
<br>
<p></p>**Rozwiązanie zadania "Praca z danymi w formacie JSON 2":**
<br>
**Odp.**

curl -s --fail https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json \
    | jq '.members[].name'
</p>


