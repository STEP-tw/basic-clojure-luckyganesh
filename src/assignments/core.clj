(ns assignments.core
  (:require [assignments.conditions :as c]
            [assignments.lists :as l]
            [assignments.util :as u]))

; Only functions whose :implemented? is marked true
; will execute and print.

(defn run-conditions-fns
  []
  (do (println "Condition functions")
      (println "-------------------")
      (u/print-and-do
        (c/safe-divide 6 2)
        (c/safe-divide 6 0)
        ;;
        (c/informative-divide 6 2)
        (c/informative-divide 6 0)
        ;;
        (c/harishchandra true)
        (c/harishchandra false)
        (c/harishchandra nil)
        ;;
        (c/yudishtira true)
        (c/yudishtira false)
        (c/yudishtira nil)
        ;;
        (c/duplicate-first [1 2])
        (c/duplicate-first [])
        ;;
        (c/five-point-someone 1 5)
        (c/five-point-someone 5 1)
        (c/five-point-someone 20 3)
        (c/five-point-someone 3 20)
        ;;
        (c/conditions-apply [0 1 0 3])
        (c/conditions-apply [:a :b :e :c])
        (c/conditions-apply [[0 0] [2 3] [1 1] [4 5] [5 6]])
        (c/conditions-apply [7 8 9])
        ;;
        (c/repeat-and-truncate [1 2 3] false false 2)
        (c/repeat-and-truncate [1 2 3] false true 2)
        (c/repeat-and-truncate [1 2 3] true false 5)
        (c/repeat-and-truncate [1 2 3] true true 5)
        ;;
        (c/order-in-words 4 3 2)
        (c/order-in-words 3 4 2)
        (c/order-in-words 2 3 4)
        (c/order-in-words 1 1 2)
        ;;
        (c/zero-aliases 0)
        (c/zero-aliases [])
        (c/zero-aliases '())
        (c/zero-aliases #{})
        (c/zero-aliases {})
        (c/zero-aliases "")
        (c/zero-aliases 5)
        ;;
        (c/zero-separated-palindrome [1 2])
        ;(c/zero-separated-palindrome [:a])
        (c/zero-separated-palindrome [0]))))

; list fns are to be filled by you
(defn run-lists-fns
  []
  (do (println "List functions")
      (println "--------------")
      (u/print-and-do
        (l/map' identity [1 2 3])
        (l/map' inc [1 2 3])
        (l/map' + [1 2 3] [4 5 6])
        ;; fill the rest accordingly
        (l/filter' (partial < 2) [1 2 3 4])
        (l/filter' (partial > 5) [1 2 3 4 6 3])
        ;;
        (l/reduce' + [1 2 3 4])
        (l/reduce' + 10 [1 2 3 4])
        ;;
        (l/count' [1 2 3])
        (l/count' {:one 1 :two 2})
        (l/count' [1 \a "string" [1 2] {:foo :bar}])
        ;;
        (l/reverse' [1 2 3])
        (l/reverse' {:one 1 :two 2})
        (l/reverse' [1 \a "string" [1 2] {:foo :bar}])
        ;;
        (l/every?' odd? [1 3 5])
        (l/every?' zero? [0 0])
        (l/every?' even? [1 2 4])
        ;;
        (l/some?' odd? [1 3 5])
        (l/some?' zero? [0 0])
        (l/some?' even? [1 3 5])
        ;;
        (l/ascending? [1 2 3])
        (l/ascending? [1 4 3])
        ;;
        (l/transpose [1 2 3] [4 5 6])
        ;;
        (l/cross-product [1 2 3] [4 3 5])                   ;
        ;;
        (l/double-up [1 2 3])
        (l/double-up ["I" "love" "clojure"])
        ;;
        (l/third-or-fifth [1 2 3 "I" 4 "love" "clojure"])
        ;;
        (l/sqr-of-the-first [1 2 3])
        ;;
        (l/index-of [1 2 3] 1)
        (l/index-of [1 2 3] "not there")
        (l/index-of [1 2 3] 2)
        ;;
        (l/palindrome? [1 2 1])
        (l/palindrome? [4 8 5])
        )))

(defn -main [& args]
  (do (run-conditions-fns)
      (run-lists-fns)))