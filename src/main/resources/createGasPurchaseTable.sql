CREATE TABLE gaspurchase.GAS_PURCHASE (
	purchase_id BIGINT auto_increment NOT NULL,
	customer_email varchar(100) NULL,
	customer_name varchar(100) NULL,
	customer_last_name varchar(100) NULL,
	card_number varchar(100) NULL,
	card_expiration_date_year varchar(100) NULL,
	card_expiration_date_month varchar(100) NULL,
	gas_type INT NULL,
	amount DOUBLE NULL,
	gas_station varchar(100) NULL,
	seller_name varchar(100) NULL,
	gas_station_address varchar(100) NULL,
	gas_station_rfc varchar(100) NULL,
	purchase_date_insert varchar(100) NULL,
	regular_price varchar(100) NULL,
	cologne varchar(100) NULL,
	licence_number varchar(100) NULL,
	licence_id varchar(100) NULL,
	application_date varchar(100) NULL,
	longitude varchar(100) NULL,
	latitude varchar(100) NULL,
	premium_price varchar(100) NULL,
	business_name varchar(100) NULL,
	postal_code varchar(100) NULL,
	dieasel varchar(100) NULL,
	CONSTRAINT GAS_PURCHASE_PK PRIMARY KEY (purchase_id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;