-- Table rôles --
CREATE TABLE t_ranks (
    id_rank INT(4) NOT NULL AUTO_INCREMENT,
    label_rank VARCHAR(15) NOT NULL,
        CONSTRAINT pk_id_rank PRIMARY KEY(id_rank)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


-- Table adresses --
CREATE TABLE t_addresses (
    id_address INT(4) NOT NULL AUTO_INCREMENT,
    label_address VARCHAR(30) NOT NULL,
    postal_code VARCHAR(6) NOT NULL,
    city VARCHAR(15) NOT NULL,
    country VARCHAR(15) NOT NULL,
        CONSTRAINT pk_id_address PRIMARY KEY(id_address)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


-- Table utilisateurs --
CREATE TABLE t_users (
    id_user INT(4) NOT NULL AUTO_INCREMENT,
    last_name VARCHAR(30) NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    email VARCHAR(60) NOT NULL,
    password VARCHAR(20) NOT NULL,
    id_rank INT(4) NOT NULL,
        CONSTRAINT pk_id_user PRIMARY KEY(id_user),
        CONSTRAINT fk_id_rank FOREIGN KEY(id_rank) REFERENCES t_ranks(id_rank)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


-- Table restaurants --
CREATE TABLE t_restaurants (
    id_restaurant INT(4) NOT NULL AUTO_INCREMENT,
    label_restaurant VARCHAR(30) NOT NULL,
    id_address INT(4) NOT NULL,
    phone_number VARCHAR(14) NOT NULL,
    id_manager INT(4) NOT NULL,
        CONSTRAINT pk_id_restaurant PRIMARY KEY(id_restaurant),
        CONSTRAINT fk_id_address FOREIGN KEY(id_address) REFERENCES t_addresses(id_address),
        CONSTRAINT fk_id_manager FOREIGN KEY(id_manager) REFERENCES t_users(id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


-- Table commandes --
CREATE TABLE t_orders (
    id_order INT(4) NOT NULL AUTO_INCREMENT,
    date_order DATETIME NOT NULL,
    id_restaurant INT(4) NOT NULL,
        CONSTRAINT pk_id_order PRIMARY KEY(id_order),
        CONSTRAINT fk_id_restaurant FOREIGN KEY(id_restaurant) REFERENCES t_restaurants(id_restaurant)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


-- Table produits --
CREATE TABLE t_products (
    id_product INT(4) NOT NULL AUTO_INCREMENT,
    label_product VARCHAR(30) NOT NULL,
    quantity_in_stock INT(10) NOT NULL,
    unity_price INT(4) NOT NULL,
        CONSTRAINT pk_id_product PRIMARY KEY(id_product)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;


-- Table contenu des commandes --
CREATE TABLE t_contain_order (
    id_contain_order INT(4) NOT NULL AUTO_INCREMENT,
    id_order INT(4) NOT NULL,
    id_product INT(4) NOT NULL,
    quantity INT(4) NOT NULL,
    unity_price INT(4) NOT NULL,
        CONSTRAINT pk_id_contain_order PRIMARY KEY(id_contain_order),
        CONSTRAINT fk_id_order FOREIGN KEY(id_order) REFERENCES t_orders(id_order),
        CONSTRAINT fk_id_product FOREIGN KEY(id_product) REFERENCES t_products(id_product)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
