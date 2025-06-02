insert into utilisateur (loginutilisateur, mdputilisateur) values ('Magali','mgo');
insert into utilisateur (loginutilisateur, mdputilisateur) values ('Maxime','rmax');


insert into section (libelleSection) values ('Licence développeur et infrastructure'), ('Management de projet ');

insert into etudiant (nomEtudiant, prenometudiant, datedenaissance, idSection) values
('Singier','Romain','05/01/2005',1),
('Dupont','Remy','10/02/2005',1),
('Castre','Alexandra','11/12/2005',1),
('Hazaki','Tokyo','01/03/2005',2),
('Fournil','Dimitri','11/01/2005',2);

insert into cours (libelleCours, descriptionCours, idSection) values 
	('Front-end','Cours pour prendre en main les bases du developpement Front', 1),
	('UML','Cours sur les concepts de base de la modélisation UML', 1);