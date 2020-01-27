(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "addition with multiple colls of same size"
      (is (= [5 7 9] (map' + [1 2 3] [4 5 6]))))
    (testing "addition with multiple colls of different sizes"
      (is (= [5 7] (map' + [1 2 3] [4 5]))))))