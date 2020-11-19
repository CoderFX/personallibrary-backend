INSERT INTO BOOKS (book_id, title, year) VALUES
(1, 'Name of the Wind', 2007),
(2, 'Wise Mans Fear', 2011),
(3, 'Off to Be the Wizard', 2013),
(4, 'Spell or High Water', 2014),
(5, 'The Magicians, Book 1', 2009),
(6, 'The Magicians, Book 2', 2014),
(7, 'The Painted Man', 2009),
(8, 'The Desert Spear', 2010),
(9, 'The Daylight War', 2013),
(10, 'The Skull Throne', 2015),
(11, 'The Core', 2017),
(12, 'Hyperion', 1989),
(13, 'The Fall of Hyperion', 1989),
(14, 'Endymion', 1996),
(15, 'The Rise of Endymion', 1997);

INSERT INTO AUTHORS (author_id, first_name, last_name) VALUES
(1, 'Patrick', 'Rothfuss'),
(2, 'Scott', 'Meyer'),
(3, 'Lev', 'Grossman'),
(4, 'Peter V.', 'Brett'),
(5, 'Dan', 'Simmons');

INSERT INTO BOOK_AUTHORS (book_id, author_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 4),
(8, 4),
(9, 4),
(10, 4),
(11, 4),
(12, 5),
(13, 5),
(14, 5),
(15, 5);