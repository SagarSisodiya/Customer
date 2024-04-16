create database invento_customer;

use invento_customer;

SET FOREIGN_KEY_CHECKS = 0;

drop table customer;
drop table address;

CREATE TABLE customer (
	id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    contact VARCHAR(13) NOT NULL,
    email VARCHAR(128),
	password VARCHAR(128) NOT NULL,
    billing_address_id BIGINT,
    shipping_address_id BIGINT,
    deleted INT NOT NULL DEFAULT 0,
   	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id),
    KEY FK_BILLING_idx (billing_address_id),
    KEY FK_SHIPPING_idx (shipping_address_id),
    CONSTRAINT UQ_EMAIL UNIQUE(email),
    CONSTRAINT UQ_CONTACT UNIQUE(contact),
    CONSTRAINT FK_BILLING FOREIGN KEY (billing_address_id) REFERENCES address(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_SHIPPING FOREIGN KEY (shipping_address_id) REFERENCES address(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=latin1;

  create table authorities (
	id BIGINT NOT NULL AUTO_INCREMENT,
    customer_id BIGINT NOT NULL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY(id),
    KEY fk_customer_idx(customer_id),
    CONSTRAINT fk_authorities FOREIGN KEY (customer_id) REFERENCES customer(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=latin1;
  
CREATE TABLE address (
	id BIGINT NOT NULL AUTO_INCREMENT,
    flat_house_no VARCHAR(45) NOT NULL,
    street1 VARCHAR(128) NOT NULL,
    street2 VARCHAR(128),
    state VARCHAR(128) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    country VARCHAR(45) NOT NULL,
    deleted INT NOT NULL DEFAULT 0,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id),
    CONSTRAINT UQ_ADD UNIQUE(flat_house_no,street1,street2,state,country)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=latin1;

insert into authorities(customer_id,name) values(1, "VIEWCUSTOMERLIST");
insert into authorities(customer_id,name) values(1, "VIEWADDRESSLIST");
insert into authorities(customer_id,name) values(1, "VIEWORDERLIST");
insert into authorities(customer_id,name) values(1, "VIEWPROFILE");
insert into authorities(customer_id,name) values(1, "EDITPROFILE");
insert into authorities(customer_id,name) values(1, "VIEWADDRESS");
insert into authorities(customer_id,name) values(1, "EDITADDRESS");
insert into authorities(customer_id,name) values(1, "EDITPRODUCT");
insert into authorities(customer_id,name) values(1, "VIEWORDER");
insert into authorities(customer_id,name) values(1, "EDITORDER");

SET FOREIGN_KEY_CHECKS = 1;
