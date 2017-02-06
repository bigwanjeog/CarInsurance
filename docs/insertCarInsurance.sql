/*Ajout Constructeur ID/NOM*/
INSERT INTO Constructeur VALUES (1, 'Renault');
INSERT INTO Constructeur VALUES (2, 'Ford');
INSERT INTO Constructeur VALUES (3, 'Porsche');
INSERT INTO Constructeur VALUES (4, 'Bugatti');
INSERT INTO Constructeur VALUES (5, 'Lamborghini');


/*Ajout Modele ID/NOM/IDCONS*/
/*Renault*/
INSERT INTO Modele VALUES (1, 'Clio 2', 1);
INSERT INTO Modele VALUES (2, 'Megane 4 Sedan', 1);
/*Ford*/
INSERT INTO Modele VALUES (3, 'Mustang', 2);
INSERT INTO Modele VALUES (4, 'Focus', 2);
/*Porsche*/
INSERT INTO Modele VALUES (5, 'Cayman', 3);
INSERT INTO Modele VALUES (6, '911 GT2', 3);
/*Bugatti*/
INSERT INTO Modele VALUES (7, 'Chiron', 4);
INSERT INTO Modele VALUES (8, 'Veyron', 4);
/*Lamborghini*/
INSERT INTO Modele VALUES (9, 'Gallardo', 5);
INSERT INTO Modele VALUES (10, 'Aventador', 5);


/*Ajout Voiture ID/ANNEE/CARBURANT/CHEVAUX/IDMODE*/
/*Renaut Clio 2*/
INSERT INTO Voiture VALUES (1, '2002', 'essence', 80, 1);
INSERT INTO Voiture VALUES (2, '2004', 'diesel', 100, 1);
/*Renault Megane*/
INSERT INTO Voiture VALUES (3, '2016', 'essence', 200, 2);
INSERT INTO Voiture VALUES (4, '2016', 'essence' , 250, 2);

/*Ford Mustang*/
INSERT INTO Voiture VALUES (5, '1965', 'essence', 101, 3);
INSERT INTO Voiture VALUES (6, '2014', 'essence', 421, 3);
/*Ford Focus*/
INSERT INTO Voiture VALUES (7, '1998', 'essence', 215, 4);
INSERT INTO Voiture VALUES (8, '2005', 'diesel', 115, 4);

/*Porsche Cayenne*/
INSERT INTO Voiture VALUES (9, '1996', 'essence', 204, 5);
INSERT INTO Voiture VALUES (10,'2004', 'essence', 310, 5);
/*Porsche 911 GT2*/
INSERT INTO Voiture VALUES (11,'1993', 'essence', 420, 6);
INSERT INTO Voiture VALUES (12,'2003', 'essence', 483, 6);

/*Bugatti Chiron*/
INSERT INTO Voiture VALUES (13,'2016', 'essence', 1500, 7);
/*Bugatti Veyron*/
INSERT INTO Voiture VALUES (14,'2005', 'essence', 1001, 8);
INSERT INTO Voiture VALUES (15,'2015', 'essence', 1200, 8);
/*Lamborghini Gallardo*/
INSERT INTO Voiture VALUES (16,'2013', 'essence', 530, 9);
/*Lamborghini Aventador*/
INSERT INTO Voiture VALUES (17,'2017', 'essence', 740, 10);