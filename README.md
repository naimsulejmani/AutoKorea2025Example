* Dependencies -> WEB, Lombok, Spring Dev Tools, Thymeleaf, DockerCompose support, JPA, Postgres/MySQL/MSSQK, Validation, MapStruct
* Docker compose.yaml me rregullu -> zakonisht portin user, password
* application.properties -> fix configurimet qe nevoiten per databaze conenction, etj
* entities -> krijoni modelet qe ju nevoiten per databaze 
* dtos -> krijoni dto modelet qe i pranojme prej front-end ose i dergojmene front-end
* mappers -> krijoni mapperat qe konvertojn prej entity-ne-dto dhe viceverca
* exceptions -> cfare perjashtime mundet me pas sistemi -> te menaxhuara
* repositories -> krijoni repositoryt per tabelat qe ju nevoiten zbashku me metodat perkatese
* services -> krijoni service qe i pranojme kerkesat prej controllerit edhe i marrim te dhanat i mappojm edhe i derogjm ne repository edhe viceverace
* controllers -> krijoni controllerat i pranojme kerkesat edhe i validojme DTO-te
* templates -> krijoni templates qe i pranojme prej front-end dhe i dergojmene front-end