(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 3 (informative-divide 6 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandra-test
  (testing "truthy value"
    (is (harishchandra true)))
  (testing "falsy value (false)"
    (is (= nil (harishchandra false))))
  (testing "falsy value (nil)"
    (is (= nil (harishchandra nil))))
  (testing "input is 0"
    (is (zero? (harishchandra 0)))))

(deftest yudishtira-test
  (testing "truthy value"
    (is (yudishtira true)))
  (testing "falsy value (false)"
    (is (= :ashwathama (yudishtira false))))
  (testing "falsy value (nil)"
    (is (= :ashwathama (yudishtira nil))))
  (testing "input is 0"
    (is (zero? (yudishtira 0)))))

(deftest duplicate-first-test
  (testing "normal list"
    (is (= [1 1 2 3] (duplicate-first [1 2 3]))))
  (testing "list is empty"
    (is (nil? (duplicate-first []))))
  (testing "list with first as nil"
    (is (= [nil nil 1 2] (duplicate-first [nil 1 2])))))

(deftest five-point-someone-test
  (testing "y is 5"
    (is (= :chetan-bhagat (five-point-someone 1 5))))
  (testing "x is 5"
    (is (= :satan-bhagat (five-point-someone 5 1))))
  (testing "x > y"
    (is (= :greece (five-point-someone 20 3))))
  (testing "x < y"
    (is (= :universe (five-point-someone 3 20)))))

(deftest conditions-apply-test
  (testing "collection has a single occurrence of 1 and 3 in that order"
    (is (= :wonder-woman (conditions-apply [0 1 0 3]))))
  (testing "collection has a single occurrence of :a :b and :c in that order"
    (is (= :durga (conditions-apply [:a :b :e :c]))))
  (testing "collection has a single occurrence of [2 3] and [4 5] in that order"
    (is (= :cleopatra (conditions-apply [[0 0] [2 3] [1 1] [4 5] [5 6]]))))
  (testing "none of the conditions apply"
    (is (= :tuntun (conditions-apply [7 8 9]))))
  (testing "collection has two occurrence of 1 and 3 in that order"
    (is (= :tuntun (conditions-apply [0 1 3 1 3])))))

(deftest repeat-and-truncate-test
  (testing "no repeat and no truncate"
    (is (= [2 3] (repeat-and-truncate [2 3] false false 4))))
  (testing "only repeat"
    (is (= [2 3 2 3] (repeat-and-truncate [2 3] true false 4))))
  (testing "only truncate"
    (is (= [1 2 3] (repeat-and-truncate [1 2 3 4 5] false true 3))))
  (testing "repeat and truncate together"
    (is (= [1 2 3 1 2] (repeat-and-truncate [1 2 3] true true 5)))))