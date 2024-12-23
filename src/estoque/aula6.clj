(ns estoque.aula6)

(def pedido {:mochila {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})


; DESTRUCT
(defn imprime-e-15
  [[chave valor]]
  (println chave "<e>" valor)
  15)

(println (map imprime-e-15 pedido))

; PRECO TOTAL DO PEDIDO
(defn preco-por-produto
  [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

; EXECUCAO DA FUNCAO
(map preco-por-produto pedido)

; PRECO TOTAL DO PEDIDO
; THREAD LAST
(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-por-produto)
       (reduce +)))

(total-do-pedido pedido)






; PRECO TOTAL DO PEDIDO
(defn preco-total-do-produto
  [produto]
  (* (:quantidade produto) (:preco produto)))

; THREAD LAST
(defn total-do-pedido2
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(total-do-pedido2 pedido)




(def pedido2 {:mochila {:quantidade 2, :preco 80}
              :camiseta {:quantidade 3, :preco 40}
              :chaveiro {:quantidade 1}})

(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println (filter gratuito? pedido2))




(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(filter (fn [[_ item]] (gratuito? item)) pedido2)
(filter #(gratuito? (second %)) pedido2)