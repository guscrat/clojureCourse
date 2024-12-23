(ns estoque.aula5)

(def estoque {"Mochila" 10, "Camiseta" 5})

(estoque)

(count estoque)
(keys estoque)
(vals estoque)

(def estoque_2 {:mochila 10, :camiseta 5})
estoque_2

; ADIOCIONAR UM NOVO VALOR
(assoc estoque_2 :cadeira 3)
(println estoque_2)

; DESADIOCIONAR UM NOVO VALOR
(dissoc estoque_2 :mochila)

; UPDATE!! 

(update estoque_2 :mochila inc)


(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(assoc pedido :chaveiro {:quantidade 2, :preco 10})

(pedido :mochila)

(get pedido :mochila)
(get pedido :cadeira 0)

(:mochila pedido {})

(:quantidade (:mochila pedido))

(update-in pedido [:mochila :quantidade] inc)
(:mochila pedido)

; THREADING F1RST

(-> pedido
    :mochila
    :quantidade)

(-> pedido
    :mochila
    :quantidade
    println)