-- Table rôles --
CREATE TABLE t_ranks (
    id_rank INT(4) NOT NULL AUTO_INCREMENT,
    label_rank VARCHAR(15) NOT NULL,
    comment VARCHAR(250),
        CONSTRAINT pk_id_rank PRIMARY KEY(id_rank)
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
    address VARCHAR(250) NOT NULL,
    phone_number VARCHAR(14) NOT NULL,
    id_manager INT(4) NOT NULL,
        CONSTRAINT pk_id_restaurant PRIMARY KEY(id_restaurant),
        CONSTRAINT fk_id_manager FOREIGN KEY(id_manager) REFERENCES t_users(id_user)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- Table produits --
CREATE TABLE t_products (
    id_product INT(4) NOT NULL AUTO_INCREMENT,
    label_product VARCHAR(30) NOT NULL,
    quantity_in_stock INT(10) NOT NULL,
    unity_price FLOAT(4) NOT NULL,
        CONSTRAINT pk_id_product PRIMARY KEY(id_product)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- Table commandes --
CREATE TABLE t_orders (
    id_order INT(4) NOT NULL AUTO_INCREMENT,
    date_order DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_restaurant INT(4) NOT NULL,
    id_product INT(4) NOT NULL,
    quantity INT(4) NOT NULL,
    unity_price INT(4) NOT NULL,
        CONSTRAINT pk_id_order PRIMARY KEY(id_order),
        CONSTRAINT fk_id_restaurant FOREIGN KEY(id_restaurant) REFERENCES t_restaurants(id_restaurant),
        CONSTRAINT fk_id_product FOREIGN KEY(id_product) REFERENCES t_products(id_product)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
