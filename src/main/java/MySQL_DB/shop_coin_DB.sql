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
    price float(10,2) not null default 0.00,
    highestPrice double(10,2),
    lowestPrice double(10,2),
    quantityCoin double(10,2) default 2,
    primary key (CoinID)
);
create table OwnedCoin(
	AccountID int not null,
    CoinID int not null,
    quantityOwned int not null,
    foreign key (AccountID) references Account(AccountID),
    foreign key (CoinID) references Coin(CoinID)
);
create table adminDeposit(
	adminDepositID int not null unique auto_increment,
    adminDepositName varchar(100) not null,
    adminDepositBankID int not null,
    primary key (adminDepositID)
);
create table Deposit(
	AccountID int not null,
    BankID int not null,
    depositUSTD double(10,2) not null,
    adminDepositID int not null,
    dayCreated date default(curdate()),
    timeCreated time default(CURRENT_TIME()),
    foreign key (AccountID) references Account(AccountID),
    foreign key (adminDepositID) references adminDeposit(adminDepositID)
);
create table History(
	AccountID int not null,
	price double(10,2) not null,
	CoinID int not null,
    quantity int not null,
    actionStatus varchar(10) not null,
	foreign key (AccountID) references Account(AccountID),
	foreign key (CoinID) references Coin(CoinID)
);
insert into Bank(BankName) 
value
('TechCombank'),
('ABC'),
('VietComBank');
insert into adminDeposit(adminDepositName,adminDepositBankID)
value
('Trang Nguyen',2),
('Dang Binh', 1),
('Thai Nguyen',3);
insert into Coin(CoinName) 
value
('Bitcoin'),
('Ethereum'),
('Tether'),
('USD Coin'),
('BNB'),
('Binance USD'),
('XRP'),
('Cardano'),
('Solana'),
('Dogecoin');