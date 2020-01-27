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