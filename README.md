# Tema 2 Proiectarea Algoritmilor

## Trenuri

Am folosit "Scanner" si "PrintWriter" pentru citirea si scrierea in fisiere. Am folosit un **HashMap**
pentru a stoca rutele intre orase, legand fiecare oras de o **Lista** de orase in care se poate
ajunge din acel oras, reprezentand graful. Alt **HashMap** am fost folosit pentru a stoca distanta maxima de la
fiecare oras pana la orasul de destinatie. Am folosit **Dfs** pentru a calcula distanta maxima,
fiind un algoritm ce face parcurgerea in adancime si se muleaza perfect pe problema. La fiecare pas
verific daca orasul curent este destinatia si daca distanta de la orasul curent la destinatie a mai
fost calculata, caz in care nu se mai calculeaza. Altfel, parcurg toti vecinii nodului curent si
stochez intr-o variabila numarul maxim de orase vizitate din acel punct pana la destinatie. Daca
exista o cale valida de la orasul curent la destinatie, se adauga 1 la numarul de orase vizitate
care ar fi orasul curent, si se adauga la hashmap-ul de distante maxime. La final, se va returna
distanta maxima de la start, pana la destinatie. Complexitatea temporala si spatiala sunt de
**O(m + n)**, unde M este numarul de muchii/rute, iar n numarul de orase/noduri, deoarece
algoritmul recursiv parcurge fiecare vecin de la fiecare nod.
#### Documentatie : https://stackoverflow.com/questions/62205054/compute-distance-using-dfs

## Drumuri

Am folosit "Scanner" si "PrintWriter" pentru citirea si scrierea in fisiere. Am citit numarul de
orase si de drumuri, dupa care am construit un graf folosind clasa **Graph**. Am adaugat pentru
fiecare drum muchia si costul acesteia, dupa care am citit cele 3 noduri tinta. Am folosit algoritmul
**Dijkstra** pentru a calcula drumul minim de la x si y la z, si de la z la celelalte 2 noduri. Apoi
am parcurs toate nodurile grafului pentru a verifica daca exista un drum valid de la x si y pentru a
ajunge la z. Daca distanta este diferita de infinit, inseamna ca am gasit un drum valid care trece
prin nodul i, poate pleca atat de la nodul x cat si de la nodul y, si ajunge la nodul z. Apoi doar
facem verificarea pentru a vedea daca este drumul cu cel mai mic cost. La final, se va returna costul
minim. Complexitatea temporala este de **O((m+n)logn)**, deoarece asta este complexitatea algoritmului
Dijkstra, care se apeleaza de 3 ori, si dupa doar se mai parcurg toate nodurile inca o data, deci
complexitatea de O(3(m+n)logn + n) se reduce la O((m+n)logn). Complexitatea spatiala este de **O(m+n)**,
deoarece se stocheaza muchiile si nodurile intr-un graf.
#### Documentatie : https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/
