DROP TABLE Ratings;
DROP TABLE Movies;
DROP TABLE Users;

CREATE TABLE Movies(
                       Id int PRIMARY KEY,
                       Title NVARCHAR(1000),
                       Year int
);
CREATE TABLE Ratings(
                        MovieId int,
                        UserId int,
                        Rating int
);
CREATE TABLE Users(
                      Id int PRIMARY KEY,
    [Name] NVARCHAR(1000)
    );


ALTER TABLE Ratings
    ADD FOREIGN KEY (MovieId) REFERENCES Movies(id);

ALTER TABLE Ratings
    ADD FOREIGN KEY (UserId) REFERENCES Users(id);