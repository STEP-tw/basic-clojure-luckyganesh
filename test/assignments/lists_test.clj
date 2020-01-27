(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest map-test
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "addition with multiple colls of same size"
      (is (= [5 7 9] (map' + [1 2 3] [4 5 6]))))
    (testing "addition with multiple colls of different sizes"
      (is (= [5 7] (map' + [1 2 3] [4 5])))))

(deftest filter-test
  (testing "even?"
    (is (= [2 4 6] (filter' even? [1 2 3 4 6 3]))))
  (testing "odd?"
    (is (=  [1 3] (filter' odd? [1 2 3 4]))))
  (testing "everything from a seq that is not nil"
    (is (= '(1 [] :a) (filter some? '(1 nil [] :a nil))))))