Table clients {
  id integer [primary key]
  name varchar(100) [not null]
  email varchar(100) [not null, unique]
  cpf varchar(11) [not null, unique]
  telephone varchar(20) [not null]
  street varchar(100) [not null]
  number varchar(10)
  complement varchar(50)
  neighboorhood varchar(50) [not null]
  city varchar(50) [not null]
  uf char(2) [not null]
  cep varchar(10) [not null]
}

Table products {
  id integer [primary key]
  name varchar(100) [not null]
  description varchar(255) [not null]
  price decimal(10,2) [not null]
  amount integer [not null]
  version integer
}

Table orders {
  id integer [primary key]
  client_id integer [not null, ref: > clients.id]
  order_date timestamp [not null]
  total_price decimal(10,2) [not null]
  status varchar(10) [not null]
  version integer
}

Table order_itens {
  id integer [primary key]
  order_id integer [not null, ref: > orders.id]
  product_id integer [not null, ref: > products.id]
  amount integer [not null]
  preco_unitario decimal(10,2) [not null]
}

Ref: "orders"."client_id" < "orders"."id"