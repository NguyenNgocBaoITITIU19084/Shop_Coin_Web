create database shop_coin;
use shop_coin;
create table Bank(
	BankID int not null unique auto_increment,
    BankName varchar(100) not null unique,
    primary key (BankID)
);
create table Account(
	AccountID int not null unique auto_increment,
    AccountName varchar(100) not null unique,
    password varchar(100) not null,
    token varchar(500) unique,
    primary key (AccountID)
);
create table AccountDetail(
	AccountID int not null,
    BankID int,
    userName varchar(100) not null,
    AccountNumber varchar(10) unique,
    Balance float(10,2) default 0.00,
    primary key (AccountID),
    foreign key (AccountID) references Account(AccountID),
    foreign key (BankID) references Bank(BankID)
);
create table Coin(
	CoinID int not null unique auto_increment,
    CoinName varchar(100) not null unique,
    price float(10,2) not null,
    highestPrice float(10,2),
    lowestPrice float(10,2),
    quantityCoin float(10,2),
    primary key (CoinID)
);
create table OwnedCoin(
	AccountID int not null unique auto_increment,
    CoinID int not null unique,
    quantityOwned float(10,2) default 0.00,
    primary key (AccountID),
    foreign key (AccountID) references Account(AccountID),
    foreign key (CoinID) references Coin(CoinID)
);