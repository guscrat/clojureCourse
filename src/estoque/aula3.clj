(ns estoque.aula3)

;PREDICATE
(defn aplica-desconto?
  [valor-bruto]
  (when (> valor-bruto 100)
    true))

; HIGHER ORDER FUNCTIONS
(defn valor-descontado
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; FUNCAO ANONIMA
(fn [valor-bruto] (> valor-bruto 100))
; EXEMPLOS DE UTILIDADE

;CHAMANDO FUNCAO NORMAL
(println (valor-descontado aplica-desconto? 1000))
(println (valor-descontado aplica-desconto? 100))

;CHAMANDO ANONIMA/LAMBDA
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 1000))
(println (valor-descontado (fn [valor-bruto] (> valor-bruto 100)) 100))
(println (valor-descontado (fn [V] (> V 100)) 1000))
(println (valor-descontado (fn [V] (> V 100)) 100))
(println (valor-descontado #(> %1 100) 1000))
(println (valor-descontado #(> %1 100) 100))
(println (valor-descontado #(> % 100) 1000))
(println (valor-descontado #(> % 100) 100))

 
;SIMBULO RECEBENDO LAMBDA
(def mais-caro-que100? (fn [v](> v 100)))
(println (valor-descontado mais-caro-que100? 1000))
(println (valor-descontado mais-caro-que100? 100))

;NORMAL WAY
(println (valor-descontado aplica-desconto? 1000))
(println (valor-descontado aplica-desconto? 100))