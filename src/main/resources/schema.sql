create table PRICES (
                        id INTEGER AUTO_INCREMENT PRIMARY KEY,
                        brand_id INTEGER NOT NULL,
                        start_date TIMESTAMP NOT NULL,
                        end_date TIMESTAMP NOT NULL,
                        price_list INTEGER NOT NULL,
                        product_id INTEGER NOT NULL,
                        priority INTEGER  NOT NULL,
                        price REAL NOT NULL,
                        curr VARCHAR(255) NOT NULL
);