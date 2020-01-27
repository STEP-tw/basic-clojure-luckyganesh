(ns assignments.util)

(defn implemented? [f]
  (-> f resolve meta :implemented?))

(defn insert-println-if-implemented [form]
  (let [f (first form)]
    (when (and (resolve f) (implemented? f))
      (list '(println "---")
            `(println "Running: " '~form)
            `(println "Result:  " ~form)))))

(defmacro print-and-do [& forms]
  (let [forms-with-println (mapcat insert-println-if-implemented forms)]
    (list* 'do forms-with-println)))

(defn single-count-&-is-in-order [x y] (and (= 1 (count y)) (= x (first y))))

(defn is-single-occurrence? [x y]
             (->> y
                  (filter (into #{} x))
                  (partition-by identity)
                  (map first)
                  (partition (count x))
                  (single-count-&-is-in-order x)
                  ))