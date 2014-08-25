(ns haunted.util-test
  (:require [clojure.test :refer :all]
            [haunted.util :refer :all]))

(deftest room-builder-test

  (testing "Room-builder catches duplicate keys."
    (let [a {:a "a" :b "b"}
          b {:a "a" :c "c"}]
      (is (thrown-with-msg? Exception #"already defined key\(s\) a"
            ((room-builder "Test" a) b)))))

  (testing "Room-builder combines maps"
    (let [a {:a "a" :b "b"}
          c {:c "c" :d "d"}]
      (is (= {:a "a" :b "b" :c "c" :d "d"}
            ((room-builder "Test" a) c))))))
