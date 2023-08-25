GESTIONE INCENDI
Funzionamento dell'applicazione
Nell'app si usano le dipendenze di Lombock, Spring Boot Starter, Spring Boot devtools e pattern decorator Observer.
La funzionalità sta nel permettere che la sonda invii una notifica al centro di controllo nel caso in cui ci sia un incendio
con livello di fumo superiore a 5, a video stamperà l'url con parametri di latutidine, longitudine e livello fumo che dovrebbe arrivare al centro di controllo, nel caso in cui si creasse nel progetto un altro microservizio ovvero il Centro di controllo vero e proprio si potrebbe dar
via a questa funzionalità tramite chiamata HTTP.