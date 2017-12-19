-- insertion des ranks --
INSERT INTO t_ranks(id_rank, label_rank, comment) VALUES
    (1, 'administrateur','tous les droits'),
    (2, 'manager','commander pour son restaurant et ajouter user'),
    (3, 'employee', 'droits en consultation sur les listes');

-- insertion de quelques produits pour les tests --
INSERT INTO t_products(label_product, quantity_in_stock, unity_price) VALUES
    ('Tomate', 100, 0.1),
    ('Poulet', 30, 2.35),
    ('Frites', 200, 0.5);

-- insertion de l'user administrator a qui on donnera les codes --
INSERT INTO t_users(last_name, first_name, email, password, id_rank) VALUES
    ('administrateur', 'root', 'root@root.com', 'Passw0rd', 1);