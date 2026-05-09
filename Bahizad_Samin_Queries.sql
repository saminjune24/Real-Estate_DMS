SELECT * FROM Properties;
SELECT * FROM Agents;
SELECT * FROM Price;
INSERT INTO Properties " + "VALUES(?,?,?,?,?,?,?,?,?,?,?);
DELETE FROM Properties WHERE Property_ID =?;
UPDATE properties SET Square_feet=?,Property_TypeID=?,Property_StatusID=?, Year_Built=?, Price_ID=?,Property_Addr=?, bedrooms=?,bathrooms=?,Location_ID=?, AgentID=? WHERE Property_ID=?";

SELECT avg(Listed_Price) AS average_Price FROM Price;

SELECT avg(Square_feet) AS average_size FROM Properties;

SELCT count(Property_ID) FROM Properties;

SELECT count(AgentID) FROM Agents;

