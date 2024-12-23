 (ns estoque.aula4)

(def precos [30 700 1000])

(println (get precos 0))
(println (get precos 1))
(println (get precos 2))
(println (get precos 3 nil))

(println (conj precos 5))

(println (update precos 0 inc))
(println (update precos 1 dec))



(defn soma-1
  [valor]
  (println "Estou somando 1 em" valor)
  (inc valor))

(println (update precos 0 soma-1))

; ================================================== ;

(defn aplica-desconto?
  [valor-bruto]
  (when (> valor-bruto 100)
    true))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; MAP PARA PERCORRER O ARRAY E APLICAR A FUNCAO DO SEGUNDO ARG
(println (map valor-descontado precos))


; MAP E FILTER
(println (range 10))
(println (filter even? (range 10)))

(println precos)
(filter aplica-desconto? precos)

(map valor-descontado (filter aplica-desconto? precos))

 ; REDUCE

(reduce + precos)

(defn minha-soma
  [valor1, valor2]
  (println "Somando valor 1 e 2")
  (+ valor1 valor2))

(reduce minha-soma precos)