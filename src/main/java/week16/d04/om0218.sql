--Összegző lekérdezések - SUM, AVG, COUNT, MIN, MAX:
-- 1.  Hány lakosa van a Földnek?
SELECT SUM(`nepesseg`) AS 'A föld lakossága (eFő)' FROM `orszagok`;
-- 2.  Mennyi a Föld népsűrűsége?
SELECT SUM(`nepesseg`) / SUM(`terulet`) * 1000 AS 'Népsűrűség (Fő/KM2)' FROM `orszagok`;
-- 3.  Hány 1.000.000 km2-nél nagyobb területű ország van?
SELECT SUM(`terulet` > 1000000) AS '1 millió km2+ országok száma' FROM `orszagok`;
-- 4.  Hány ország területe esik 50.000 és 150.000 km2 közé?
SELECT SUM(`terulet` >= 50000 AND `terulet` <= 150000) AS '50.000 és 150.000 km2 közötti országok száma' FROM `orszagok`;
-- 5.  Hány 1.000.000-nál kevesebb lakosú ország van?
SELECT SUM(`nepesseg` <= 1000) AS '1 milliónál kevesebb lakosú országok száma' FROM `orszagok`;
-- 6.  Hány olyan ország van, aminek a területe kisebb, mint 10.000 km2, vagy a lakossága kevesebb 1.000.000-nál?
SELECT SUM(`terulet` < 10000 OR `nepesseg` < 1000) AS '10K- területű vagy 1M- lakosú országok' FROM `orszagok`;
-- 7.  Hány ország pénzneme a kelet-karib dollár?
SELECT SUM(`penznem` = 'kelet-karib dollár') AS 'kelet-karib dollár pénznemű országok' FROM `orszagok`;
-- 8.  Hány ország nevében van benne, hogy "ORSZÁG"?
SELECT SUM(`orszag` LIKE '%ország%') AS '"ország" nevű országok' FROM `orszagok`;
-- 9.  Hány ország van Afrikában?
SELECT SUM(`foldr_hely` LIKE '%afrika%') AS 'Országok száma Afrikában' FROM `orszagok`;
-- 10.  Mennyi Afrika lakossága?
SELECT SUM(`nepesseg`) AS 'Afrika lakossága (eFő)' FROM `orszagok` WHERE `foldr_hely` LIKE '%afrika%';
-- 11.  Mennyi Európa területe?
SELECT SUM(`terulet`) AS 'Európa területe (KM2)' FROM `orszagok` WHERE `foldr_hely` LIKE '%európa%';
-- 12.  Mennyi Európa népsűrűsége?
SELECT SUM(`nepesseg`) / SUM(`terulet`) * 1000 AS 'Európa népsűrűsége (Fő/KM2)' FROM `orszagok` WHERE `foldr_hely` LIKE '%európa%';
-- 13.  Hány országnak nincs autójelzése?
SELECT COUNT(`orszag`) AS 'Autójel nélküli országok száma' FROM `orszagok` WHERE `autojel` = '';
-- 14.  Hány országban nem 100 a váltószáma az aprópénznek?
SELECT COUNT(`orszag`) AS 'Nem 100 a váltószáma az aprópénznek országok száma' FROM `orszagok` WHERE `valtopenz` NOT LIKE '%100 %';
-- 15.  Hány országnak nagyobb a népessége, mint Romániának?
SELECT COUNT(`orszag`) AS 'Népesebb országok mint Románia' FROM `orszagok` WHERE `nepesseg` > (SELECT `nepesseg` FROM `orszagok` WHERE `orszag` = 'Románia');
-- 16.  Mennyi Európa népessége és mennyi ország van Európában?
SELECT SUM(`nepesseg`) AS 'Európa népessége (EFő)', COUNT(`orszag`) AS 'Európa országainak száma' FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%';
-- 17.  Mennyi olyan ország van, aminek a területe kisebb, mint Törökország
SELECT COUNT(`orszag`) AS 'Kisebb országok mint Törökország' FROM `orszagok` WHERE `terulet` < (SELECT `terulet` FROM `orszagok` WHERE `orszag` = 'Törökország');

-- Beágyazott lekérdezések:
-- 1.  Hány ország területe kisebb Magyarországénál?
SELECT COUNT(`orszag`) FROM `orszagok` WHERE `terulet` < (SELECT `terulet`FROM `orszagok` WHERE `orszag` = 'MAGYARORSZÁG');
-- 2.  Melyik a legnagyobb területű ország, és mennyi a területe?
SELECT `orszag`, `terulet` FROM `orszagok` ORDER BY `terulet` DESC LIMIT 1;
-- 3.  Melyik a legkisebb  területű ország, és mennyi a területe?
SELECT `orszag`, `terulet` FROM `orszagok` ORDER BY `terulet` ASC LIMIT 1;
-- 4.  Melyik a legnépesebb ország, és hány lakosa van?
SELECT `orszag`, `nepesseg` FROM `orszagok` ORDER BY `nepesseg` DESC LIMIT 1;
-- 5.  Melyik a legkisebb népességű ország, és hány lakosa van?
SELECT `orszag`, `nepesseg` FROM `orszagok` ORDER BY `nepesseg` ASC LIMIT 1;
-- 6.  Melyik a legsűrűbben lakott ország, és mennyi a népsűrűsége?
SELECT `orszag` AS 'Legzsúfoltabb ország', `nepesseg` / `terulet` * 1000 AS 'Népsűrűség (Fő/KM2)' FROM `orszagok` ORDER BY `nepesseg` / `terulet` * 1000 DESC LIMIT 1;
-- 7.  Melyik a legritkábban lakott ország, és mennyi a népsűrűsége?
SELECT `orszag` AS 'Legkevésbé zsúfolt ország', `nepesseg` / `terulet` * 1000 AS 'Népsűrűség (Fő/KM2)' FROM `orszagok` ORDER BY `nepesseg` / `terulet` * 1000 ASC LIMIT 1;
-- 8.  Melyik a legritkábban lakott európai ország, és mennyi a népsűrűsége?
SELECT `orszag` AS 'Legkevésbé zsúfolt európai ország', `nepesseg` / `terulet` * 1000 AS 'Népsűrűség (Fő/KM2)' FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%' ORDER BY `nepesseg` / `terulet` * 1000 ASC LIMIT 1;
-- 9.  Melyik a legnagyobb afrikai ország és mekkora?
SELECT `orszag` AS 'Legnagyobb afrikai ország', `terulet` AS 'Területe' FROM `orszagok` WHERE `foldr_hely` LIKE '%Afrika%' ORDER BY `terulet` DESC LIMIT 1;
