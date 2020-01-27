(ns assignments.util-test
  (:require [clojure.test :refer :all])
  (:require [assignments.util :refer [is-in-order?]]))

(deftest is-in-order?-test
  (testing "should return true when the integers are in order"
    (is (true? (is-in-order? [1 3] [0 1 0 3]))))
  (testing "should return false when the integers are not in order"
    (is (false? (is-in-order? [1 3] [0 3 0 1]))))
  (testing "should return true when the vectors are in order"
    (is (true? (is-in-order? [[2 3] [4 5]] [[0 0] [2 3] [1 1] [4 5] [5 6]]))))
  (testing "should return false when the vectors are not in order"
    (is (false? (is-in-order? [[2 3] [4 5]] [[0 0] [1 1] [4 5] [2 3] [5 6]])))))
