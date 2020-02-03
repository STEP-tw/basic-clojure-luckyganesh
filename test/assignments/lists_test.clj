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

(deftest reduce-test
  (testing "+ without initial value"
    (is (= 15 (reduce' + [1 2 3 4 5]))))
  (testing "conj with initial value"
    (is (= #{:a :c :b} (reduce' conj #{} [:a :b :c]))))
  (testing "simple factorial"
    (is (= 120 (reduce * (range 1 (inc 5)))))))

(deftest count-test
  (testing "with empty list"
    (is (zero? (count' []))))
  (testing "with integer elements in list"
    (is (= 4 (count' [4 2 6 2]))))
  (testing "list containing multiple data types"
    (is (= 5 (count' [1 \a "string" [1 2] {:foo :bar}])))))

(deftest reverse-test
  (testing "with empty list"
    (is (= () (reverse' []))))
  (testing "with elements in list"
    (is (= '(3 2 1) (reverse' [1 2 3]))))
  (testing "with string"
    (is (= '(\e \r \u \j \o \l \c) (reverse' "clojure"))))
  (testing "with non-seqable"
    (is (nil? (reverse' true)))))

(deftest every?-test
  (testing "with empty list"
    (is (true? (every?' odd? []))))
  (testing "odd? with odd value"
    (is (true? (every?' odd? [1 3 5]))))
  (testing "odd? with one even value in list"
    (is (false? (every?' odd? [1 2 3])))))

(deftest some?-test
  (testing "with empty list"
    (is (false? (some?' odd? []))))
  (testing "odd? with odd value"
    (is (true? (some?' odd? [1 3 5]))))
  (testing "odd? with one even value in list"
    (is (true? (some?' odd? [1 2 3]))))
  (testing "even? with no even values in list"
    (is (false? (some?' even? [1 3 5])))))

(deftest ascending?-test
  (testing "with correct sequence"
    (is (true? (ascending? [1 2 3]))))
  (testing "with wrong sequence"
    (is (false? (ascending? [1 4 3])))))

(deftest transpose-test
  (testing "with empty sequence"
    (is (= [] (transpose [[] []]))))
  (testing "with 2 rows"
    (is (= [[1 4] [2 5] [3 6]] (transpose [[1 2 3] [4 5 6]])))))

(deftest cross-product-test
  (testing "with empty sequence"
    (is (= [] (cross-product [] []))))
  (testing "with 2 sequences"
    (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]]
           (cross-product [1 2 3] [4 3 5])))))

(deftest double-up-test
  (testing "with empty sequence"
    (is (= [] (double-up []))))
  (testing "with integer sequence"
    (is (= [1 1 2 2 3 3] (double-up [1 2 3]))))
  (testing "with string sequence"
    (is (= ["I" "I" "love" "love" "clojure" "clojure"]
           (double-up ["I" "love" "clojure"])))))

(deftest third-or-fifth-test
  (testing "with single item"
    (is (= [] (third-or-fifth ["I"]))))
  (testing "with collection containing 4 items - last index is 3"
    (is (= [4] (third-or-fifth [1 2 3 4]))))
  (testing "with collection containing 6 items - last index is 5"
    (is (= [4 6] (third-or-fifth [1 2 3 4 5 6])))))

(deftest sqr-of-the-first-test
  (testing "with single item"
    (is (= [1] (sqr-of-the-first [1]))))
  (testing "with collection containing 4 items"
    (is (= [4 4 4 4] (sqr-of-the-first [2 3 4 5])))))

(deftest index-of-test
  (testing "with empty collection"
    (is (= -1 (index-of [] "something"))))
  (testing "with element present in the collection"
    (is (= 4 (index-of [0 1 2 5 3] 3))))
  (testing "with element not present in the collection"
    (is (= -1 (index-of [1 2 3] 0)))))

(deftest palindrome?-test
  (testing "with empty collection"
    (is (true? (palindrome? []))))
  (testing "with palindrome list"
    (is (true? (palindrome? [1 2 1]))))
  (testing "with string"
    (is (true? (palindrome? "NaN"))))
  (testing "not a palindrome"
    (is (false? (palindrome? [1 2 3])))))

(deftest sum-of-adjacent-digits-test
  (testing "with empty collection and single collection"
    (are [x y] (= x y)
               [] (sum-of-adjacent-digits [])
               [] (sum-of-adjacent-digits [1])))
  (testing "with collection containing more than single element"
    (is (= [1 4 3] (sum-of-adjacent-digits [0 1 3 0])))))

(deftest muted-thirds-test
  (testing "with empty,1 and 2 elements in collection"
    (are [x y] (= x y)
               [] (muted-thirds [])
               [1] (muted-thirds [1])
               [1 2] (muted-thirds [1 2])))
  (testing "with more than 2 elements in collection"
    (are [x y] (= x y)
               [1 2 0] (muted-thirds [1 2 3])
               [1 2 0 4 15 0 7] (muted-thirds [1 2 8 4 15 2 7]))))

(deftest difference-test
  (testing "with empty collection"
    (is (= [] (difference [] []))))
  (testing "with 2nd collection that are present is 1st collection"
    (is (= [] (difference [1 2 3] [2 3]))))
  (testing "with 2nd collection having elements after difference"
    (is (= [4] (difference [1 2 3] [2 3 4])))))

(deftest points-around-origin-test
  (testing "points around origin"
    (is (= '([-1 -1]
            [-1 0]
            [-1 1]
            [0 -1]
            [0 1]
            [1 -1]
            [1 0]
            [1 1]) points-around-origin))))

(deftest russian-dolls-test
  (testing "single nesting gives result as same input"
    (is (= [1 2 3] (russian-dolls [1 2 3] 1))))
  (testing "triple nesting"
    (is (= [[[1]] [[2]] [[3]]] (russian-dolls [1 2 3] 3)))))

(deftest validate-sudoku-grid-test
  (testing "correct grid"
    (is (true? (validate-sudoku-grid
                 [[4 3 5 2 6 9 7 8 1]
                  [6 8 2 5 7 1 4 9 3]
                  [1 9 7 8 3 4 5 6 2]
                  [8 2 6 1 9 5 3 4 7]
                  [3 7 4 6 8 2 9 1 5]
                  [9 5 1 7 4 3 6 2 8]
                  [5 1 9 3 2 6 8 7 4]
                  [2 4 8 9 5 7 1 3 6]
                  [7 6 3 4 1 8 2 5 9]]))))
  (testing "incorrect grid"
    (is (false? (validate-sudoku-grid
                  [[4 4 5 2 6 9 7 8 1]
                   [6 8 2 5 7 1 4 9 3]
                   [1 9 7 8 3 4 5 6 2]
                   [8 2 6 1 9 5 3 4 7]
                   [3 7 4 6 8 2 9 1 5]
                   [9 5 1 7 4 3 6 2 8]
                   [5 1 9 3 2 6 8 7 4]
                   [2 4 8 9 5 7 1 3 6]
                   [7 6 3 4 1 8 2 5 9]])))))

(deftest distinct-test
  (testing "with no duplicates"
    (is (= [1 2 3] (distinct' [1 2 3]))))
  (testing "with duplicates"
    (is (= [1 2 3] (distinct' [1 1 2 3 2])))))

(deftest dedupe-test
  (testing "with no duplicates"
    (is (= [1 2 3] (dedupe' [1 2 3]))))
  (testing "with duplicates but not consecutive"
    (is (= [1 2 3 1] (dedupe' [1 2 3 1]))))
  (testing "with consecutive duplicates"
    (is (= [1 2 3] (dedupe' [1 1 2 3 3])))))

(deftest union-test
  (testing "with no common elements"
    (is (= [1 2 3 4 5 6] (union [1 2 3] [ 4 5 6]))))
  (testing "with common elements but elements doesn't repeat"
    (is (= [1 2 3 4 5] (union [1 2 3] [3 4 5]))))
  (testing "with common element and elements repeat"
    (is (= [1 2 3 1 4 5 6 4] (union [1 2 3 1] [4 5 6 3 2 4])))))

(deftest split-comb-test
  (testing "with even sequence"
    (is (= [1 3 2 4] (split-comb [1 2 3 4]))))
  (testing "with odd sequence"
    (is (= [1 3 2 4 5] (split-comb [1 2 3 4 5])))))

(deftest max-three-digit-sequence-test
  (testing "with less than three numbers"
    (is (= [1 2] (max-three-digit-sequence [1 2]))))
  (testing "with more than three numbers"
    (is (= [2 -1 2] (max-three-digit-sequence [1 2 -1 2 0])))))