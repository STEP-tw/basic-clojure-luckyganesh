(ns assignments.util-test
  (:require [clojure.test :refer :all])
  (:require [assignments.util :refer [is-single-occurrence?]]))

(deftest is-in-order?-test
  (testing "integers in order"
    (is (true? (is-single-occurrence? [1 3] [0 1 0 3]))))
  (testing "integers not in order"
    (is (false? (is-single-occurrence? [1 3] [0 3 0 1]))))
  (testing "vectors are in order"
    (is (true? (is-single-occurrence? [[2 3] [4 5]] [[0 0] [2 3] [1 1] [4 5] [5 6]]))))
  (testing "vectors not in order"
    (is (false? (is-single-occurrence? [[2 3] [4 5]] [[0 0] [1 1] [4 5] [2 3] [5 6]])))))
