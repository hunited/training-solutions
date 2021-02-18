-- 1.  Mi MADAGASZKÁR fővárosa?
SELECT `fovaros` FROM `orszagok` WHERE `orszag` = 'Madagaszkár';
-- 2.  Melyik ország fővárosa OUAGADOUGOU?
SELECT `orszag` FROM `orszagok` WHERE `fovaros` = 'Ouagadougou';
-- 3.  Melyik ország autójele a TT?
SELECT `orszag` FROM `orszagok` WHERE `autojel` = 'TT';
-- 4.  Melyik ország pénzének jele az SGD?
SELECT `orszag` FROM `orszagok` WHERE `penzjel` = 'SGD';
-- 5.  Melyik ország nemzetközi telefon-hívószáma a 61?
SELECT `orszag` FROM `orszagok` WHERE `telefon` = 61;
-- 6.  Mekkora területű Monaco?
SELECT `terulet` FROM `orszagok` WHERE `orszag` = 'Monaco';
-- 7.  Hányan laknak Máltán?
SELECT `nepesseg` FROM `orszagok` WHERE `orszag` = 'Málta';
-- 8.  Mennyi Japán népsűrűsége?
SELECT `nepesseg` / `terulet` * 1000 FROM `orszagok` WHERE `orszag` = 'Japán';
-- 9.  Mely országok népsűrűsége nagyobb 500 fő/km2-nél?
SELECT `orszag` FROM `orszagok` WHERE `nepesseg` / `terulet` * 1000 > 500;
-- 10.  Melyek a szigetországok?
SELECT `orszag` FROM `orszagok` WHERE `foldr_hely` LIKE '%Szigetország%';
-- 11.  Melyik a első hat legnagyobb területű ország?
SELECT `orszag` FROM `orszagok` ORDER BY `terulet` DESC LIMIT 6;
-- 12.  Melyik három ország területe a legkisebb?
SELECT `orszag` FROM `orszagok` ORDER BY `terulet` ASC LIMIT 3;