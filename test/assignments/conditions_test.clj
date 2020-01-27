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
  (testing "should return true when input is true"
    (is (harishchandra true)))
  (testing "should return nil when input is false"
    (is (= nil (harishchandra false))))
  (testing "should return nil when input is nil"
    (is (= nil (harishchandra nil))))
  (testing "should return the value when it is not falsy value"
    (is (= 2 (harishchandra 2))))
  (testing "should return 0 when input is 0"
    (is (zero? (harishchandra 0)))))

(deftest yudishtira-test
  (testing "should return true when input is true"
    (is (yudishtira true)))
  (testing "should return :ashwathama when input is false"
    (is (= :ashwathama (yudishtira false))))
  (testing "should return :ashwathama when input is nil"
    (is (= :ashwathama (yudishtira nil))))
  (testing "should return the value when it is not falsy value"
    (is (= 2 (yudishtira 2))))
  (testing "should return 0 when input is 0"
    (is (zero? (yudishtira 0)))))

(deftest duplicate-first-test
  (testing "should return the list with duplicate-first"
    (is (= [1 1 2 3] (duplicate-first [1 2 3]))))
  (testing "should return nil when list is empty"
    (is (nil? (duplicate-first []))))
  (testing "should return the list with duplicate-first when first is nil"
    (is (= [nil nil 1 2] (duplicate-first [nil 1 2])))))

(deftest five-point-someone-test
  (testing "should return :chetan-bhagat when y is 5"
    (is (= :chetan-bhagat (five-point-someone 1 5))))
  (testing "should return :chetan-bhagat when y is 5"
    (is (= :satan-bhagat (five-point-someone 5 1))))
  (testing "should return :chetan-bhagat when y is 5"
    (is (= :greece (five-point-someone 20 3))))
  (testing "should return :chetan-bhagat when y is 5"
    (is (= :universe (five-point-someone 3 20)))))

(deftest conditions-apply-test
  (testing "should return :wonder-woman if collection has a single occurrence of 1 and 3 in that order"
    (is (= :wonder-woman (conditions-apply [0 1 0 3]))))
  (testing "should return :durga if collection has a single occurrence of :a :b and :c in that order"
    (is (= :durga (conditions-apply [:a :b :e :c]))))
  (testing "should return :cleopatra if collection has a single occurrence of [2 3] and [4 5] in that order"
    (is (= :cleopatra (conditions-apply [[0 0] [2 3] [1 1] [4 5] [5 6]]))))
  (testing "should return :tuntun if none of the conditions apply"
    (is (= :tuntun (conditions-apply [7 8 9])))))