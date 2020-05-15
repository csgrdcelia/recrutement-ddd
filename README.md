# recrutement-ddd (groupe 2)

## Lancer les tests
> mvn test

## Scénario
### Given 
Un candidat avec ses disponibilités, une liste de consultants recruteurs, une liste de salles
### When
La chargé de recrutement crée l'entretien
### Then
Un entretien est planifié avec un consultant recruteur ayant plus d'années d'expérience que le candidat et les mêmes compétences, avec des disponibilités concordantes et une salle disponible à cette date et heure
