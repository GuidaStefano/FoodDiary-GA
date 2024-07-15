<div align="center">
  <img src="https://github.com/user-attachments/assets/fe31d0d1-ab24-47f7-bd27-152ff4ad4011" alt="logo-ga" width="300">
</div>

# Descrizione
**FoodDiary-GA** è un progetto sviluppato come parte del corso di Fondamenti di Intelligenza Artificiale durante l'anno accademico 2023/24 presso l'Università di Salerno. Il progetto sfrutta la potenza degli algoritmi genetici per creare piani alimentari personalizzati ed equilibrati, offrendo un approccio innovativo e intelligente alla nutrizione.

# Tecnologie utilizzate
- Java (JDK 17)
- Libreria Apache POI

# Installazione
**STEP 1)** Clonare la repository, utilizzando git:
```bash
git clone https://github.com/GuidaStefano/FoodDiary-GA.git
```
**STEP 2)** Assicurarsi di avere Java JDK 17 e Maven installati sul sistema.

**STEP 3)** Spostarsi nella directory del progetto e compilare il progetto utilizzando Maven:
```bash
cd FoodDiary-GA
mvn clean install
```

# Struttura del progetto

Il progetto si compone di quattro packages principali:

- **ga**: contiene l'implementazione dell'algoritmo genetico.
- **obj**: contiene la business logic del progetto.
- **loader**: contiene una classe ad-hoc per il caricamento del dataset di dati nutrizionali.
- **util**: contiene le classi di utilità.

# Utilizzo
Per eseguire un'ottimizzazione, basta configurare i parametri dell'algoritmo nel file FoodDiaryGARunner.java e avviare l'esecuzione. L'algoritmo genetico inizierà l'ottimizzazione e fornirà i risultati nella console.

# Documentazione
La documentazione completa del progetto è disponibile al seguente link:
[Documentazione FoodDiary-GA](https://github.com/GuidaStefano/FoodDiary-GA/blob/master/FoodDiary-GA%20-%20Documentazione.pdf)



